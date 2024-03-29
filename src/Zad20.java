import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zad20 {

    /*
    Napisz program, który losuje dwadzieścia liczb całkowitych z przedziału
    <a, b>. Liczby a i b pobierane są od użytkownika tak długo, aż liczba a nie
    będzie liczbą parzystą podzielną przez co najmniej 4 liczby, a liczba b nie
    będzie posiadać wszystkich cyfr będących liczbami pierwszymi. Liczba a musi
    dodatkowo być liczbą mniejszą od b. Następnie wyznacz liczbę, która wystąpiła
    najwięcej razy pośród dwudziestu otrzymanych liczb. Nie stosujemy tablic
     */

    static int generateNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
                number = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("You must give a number");
                scan.nextLine();
            }
        } while (error);
        return number;
    }

    static boolean hasMinimumFourDividers(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                counter++;
            }
            if (counter >= 4) {
                return true;
            }
        }
        return false;
    }


    static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        double sqrt = Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkDigitIsNotPrime(int number) {
        int digit;
        while (number > 0) {
            digit = number % 10;
            if (!(isPrime(digit)))
                return true;
            number /= 10;
        }
        return false;
    }

    static boolean everyDigitIsNotPrime(int number) {
        return (checkDigitIsNotPrime(number) && (!isPrime(number)));
    }


    static void draw(int a, int b) {
        int drawNumber;
        int index = 1;
        int counter = 0;
        int help;
        int max;
        for (int i = 1; i < 20; i++) {
            drawNumber = generateNumber(a, b);
            help = drawNumber;
            System.out.println(index + ": " + drawNumber);
            index++;
        }
    }




    public static void main(String[] args) {

        int a, b;


        do {

            do {
                System.out.println("Give the first number:");
                a = getNumberFromUser();
                if (!(isOdd(a)) || !(hasMinimumFourDividers(a))) {
                    System.out.println("A number must be odd and have at least four divisors");
                }
            } while (!(isOdd(a)) || !(hasMinimumFourDividers(a)));

            do {
                System.out.println("Give the second number:");
                b = getNumberFromUser();
                if (!(everyDigitIsNotPrime(b))) {
                    System.out.println("The digits in the given number cannot be prime numbers.");
                }
            } while (!(everyDigitIsNotPrime(b)));
            if (a > b) {
                System.out.println("The first number cannot be greater than the second number.");
            }

        } while (!(a < b));

        draw(a, b);
    }
}

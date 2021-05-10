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

    static boolean everyDigitIsNotPrime(int number) {
        int digit = 0;
        while (number > 0) {
            digit = number % 10;
            if (isPrime(digit)) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }


    public static void main(String[] args) {

        int number1, number2;

        do {
            number1 = getNumberFromUser();
            number2 = getNumberFromUser();
        } while (!(number1 < number2));


    }
}

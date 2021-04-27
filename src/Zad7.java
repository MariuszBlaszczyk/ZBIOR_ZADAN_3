import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad7 {

    /*
    Napisz program, w którym pobierasz od użytkownika trzy liczby, dopóki
    ilość cyfr parzystych we wszystkich trzech liczbach nie będzie większa
    od ilości wszystkich cyfr pobieranych liczb.
     */

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
                number = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.err.println("You must specify a number. Please try again: ");
                scan.nextLine();
            }
        } while (error);
        return number;
    }

    static int evenNumbersCounter(int... numbers) {
        int counter = 0;
        int x = 0;
        for (int value : numbers) {
            while (value > 0) {
                x = value % 10;
                if (x % 2 == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    static int digitsCounter(int... numbers) {
        int counter = 0;
        int x = 0;
        for (int value : numbers) {
            while (value > 0) {
                x = value % 10;
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int number1, number2, number3;


        do {
            number1 = getNumberFromUser();
            number2 = getNumberFromUser();
            number3 = getNumberFromUser();
        } while (!(evenNumbersCounter(number1, number2, number3) > digitsCounter(number1, number2, number3)));
        ;
    }
}

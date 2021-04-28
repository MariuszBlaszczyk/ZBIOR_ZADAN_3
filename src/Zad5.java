import java.util.InputMismatchException;
import java.util.Scanner;

public class Zad5 {

    /*
    Napisz program, w którym użytkownik podaje liczbę całkowitą i wyznacza,
    ile jest w niej cyfr parzystych, znajdujących się na pozycji parzystej.
    Zakładamy, że cyfra jedności ma pozycję parzystą, cyfra dziesiątek
    ma pozycję nieparzystą, cyfra setek ma pozycję parzystą itd.
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

//    static int howManyEvenNumbersIsInEvenPosition(int number) {
//        int counter = 0;
//        while (number > 0) {
//
//        }
//    }

    public static void main(String[] args) {

        int number = getNumberFromUser();

    }
}



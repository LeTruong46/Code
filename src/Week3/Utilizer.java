package Week3;

import java.util.Scanner;

public class Utilizer {
    static Scanner sc = new Scanner(System.in);

    public static int checkNumber() {
        while (true) {
            System.out.print("Enter a number (>= 2): ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input >= 2) {
                    return input;
                } else {
                    System.out.println("Please enter a number with value >= 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }

    public static int checkInt() {
        while (true) {
            System.out.print("Enter a menu option: ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
    }
}

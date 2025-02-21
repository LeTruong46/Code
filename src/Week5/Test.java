package Week5;

import java.text.ParseException;
import java.util.Scanner;

public class Test {
    Scanner sc =  new Scanner(System.in);
    public void menu() throws ParseException{
        Short109_Management s109 = new Short109_Management();
        Short107_Management s107 = new Short107_Management();
        int choice;
        do {            
            System.out.println("--------- Menu Week 5 ---------");
            System.out.println("1. Short 109: Manage course information.");
            System.out.println("2. Short 107: Manage room reservations and pick up guests at the airport.");
            System.out.println("3. Short 84: Large number.");
            System.out.println("4. Exit project week 5.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    s109.menuCourse();
                    break;
                case 2:
                    s107.menuReservation();
                    break;
                case 3:
                    break;
                case 4: 
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid!");
            }
            
        } while (choice != 4);
    }
    public static void main(String[] args) throws ParseException {
        Test test = new Test();
        test.menu();
    }
}

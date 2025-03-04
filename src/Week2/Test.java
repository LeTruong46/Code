
package Week2;

import java.util.Scanner;

public class Test {
    public void menuTest(){
        Short51_DevelopAComputerProgram developAComputerProgram = new Short51_DevelopAComputerProgram();
        Short61_Management management = new Short61_Management();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("***** Menu week 5 *****");
            System.out.println("1. Short 51: Develop a computer program.");
            System.out.println("2. Short 61: Develop a program to calculate perimeter and area.");
            System.out.println("3. Matrix.");
            System.out.println("4. Exit !"); 
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    developAComputerProgram.menu();
                    break;
                case 2:
                    management.menu();
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Exit...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid. Enter a again...");
            }
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.menuTest();
    }
}

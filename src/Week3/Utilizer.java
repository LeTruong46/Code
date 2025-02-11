
package Week3;

import java.util.Scanner;

public class Utilizer {
    static Scanner sc = new Scanner(System.in);
    
    public static int checkNumber(){
        while (true) {            
            System.out.print("Enter a number: ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                if(input >= 2){
                    return input;
                } else {
                    System.out.println("Please enter the number with value >= 2");
                    return -1;
                }
            } catch (Exception e) {
                System.out.println("Error!!!");
            }
        }
    }
    
    public static int checkInt(){
        while (true) {            
            System.out.print("Enter a number: ");
            try {
                int input = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                return -1;
            }
        }
    }
}

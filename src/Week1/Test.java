package Week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {            
        System.out.println("-----------Menu-----------");
        System.out.println("1. Letter and character count.");
        System.out.println("2. Linear search.");
        System.out.println("3. Change base number.");
        System.out.println("4. Calculation program");
        System.out.println("5. Exit...!");
        System.out.print("Enter the lab you want to run: ");
        num = sc.nextInt();
        switch (num) {
            case 1: 
                LetterAndCharacterCount();
                break;
            case 2:
                linearSearch();
                break;
            case 3:
                ChangeBaseNumber();
                break;
            case 4:
                calculationProgram();
                break;
            case 5:
                System.out.println("Exit...");
                break;
            default:
                System.out.println("Error...");
        }
        } while (num != 5);
        
    }   
    
    //Lab 08
    static void LetterAndCharacterCount() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your content: ");
    String input = sc.nextLine();
    Lab08_LetterAndCharaterCount lc = new Lab08_LetterAndCharaterCount(input);

    // Đếm từ và hiển thị
    Map<String, Integer> wordCount = lc.countWord();
    System.out.println(wordCount); 

    // Đếm ký tự và hiển thị
    Map<Character, Integer> charCount = lc.countCharacter();
    System.out.println(charCount); 
}

    
    //Lab 10
    static void linearSearch(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        LinearSearch ls = new LinearSearch(size);
        ls.addValue();

        System.out.print("Enter the number to search: ");
        int number = sc.nextInt();
        ls.showArray();
                
        int index = ls.searchValue(number);
        if (index != -1) {
            System.out.println("The number is found at index: " + index);
        } else {
            System.out.println("The number is not found in the array.");
        }
    }
//    Lab 11
    static void ChangeBaseNumber() {
        Scanner sc = new Scanner(System.in);
        int inputBase, outputBase;
        String inputValue;
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose input [1: Binary, 2: Decimal, 3: Hexadecimal]");
            inputBase = sc.nextInt();
            sc.nextLine();

            if (inputBase < 1 || inputBase > 3) {
                System.out.println("Invalid selection. Please select again.");
                continue;
            }

            System.out.println("Choose output [1: Binary, 2: Decimal, 3: Hexadecimal]");
            outputBase = sc.nextInt();
            sc.nextLine();

            if (outputBase < 1 || outputBase > 3) {
                System.out.println("Invalid selection. Please select again.");
                continue;
            }

            System.out.print("Enter the value you want to convert: ");
            inputValue = sc.nextLine();

            int baseInput = (inputBase == 1) ? 2 : (inputBase == 2) ? 10 : 16;
            ChangeBaseNumber converter = new ChangeBaseNumber(inputBase, outputBase, inputValue);
            int decimalValue = converter.convertToDecimal(inputValue, baseInput);

            if (decimalValue == -1) {
                System.out.println("Cannot convert value. Please check again.");
                continue;
            }

            String result = "";
            switch (outputBase) {
                case 1:
                    result = converter.convertToBinary(decimalValue);
                    break;
                case 2:
                    result = String.valueOf(decimalValue);
                    break;
                case 3:
                    result = converter.convertToHexadecimal(decimalValue);
                    break;
            }

            System.out.println("Conversion result: " + result);

            System.out.print("Do you want to continue? (yes/no): ");
            String continueChoice = sc.nextLine();
            if (continueChoice.equalsIgnoreCase("no")) {
                exit = true;
            }
        }
    }
    
    
//    lab50
    public static void calculationProgram() {
        Scanner sc = new Scanner(System.in);
        CalculationProgram cp = new CalculationProgram(0, 0, 0);
        int choice;
        do {
            cp.menu();
            choice = cp.getValidInteger("Enter your choice: ");
            switch (choice) {
                case 1:
                    cp.calculateEquation();
                    break;
                case 2:
                    cp.calculateQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Exit program...");
                    break;
                default:
                    System.out.println("Error: Invalid choice. Please choose again...");
            }
        } while (choice != 3);
    }
}
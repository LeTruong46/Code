package Week3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("-----------Menu-----------");
            System.out.println("1. Bubble Sort Program.");
            System.out.println("2. Quick Sort Algorithm.");
            System.out.println("3. Binary Search Algorithm.");
            System.out.println("4. Exit...!");
            System.out.print("Enter the program you want to run: ");
            num = Integer.parseInt(sc.nextLine());
            
            switch (num) {
                case 1:
                    Bubblesortprogram();
                    break;
                case 2:
                    Quicksortalgorithm();
                    break;
                case 3:
                    Binaryearchalgorithm();
                    break;
                case 4:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Error: Invalid choice...");
            }
        } while (num != 4);
//        sc.close();
    }
    
    static void Binaryearchalgorithm (){
        Scanner scanner = new Scanner(System.in);
        int n;
        
        do {
            System.out.print("Enter a positive number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a positive integer.");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 0);
        
        Short06_Binaryearchalgorithm program = new Short06_Binaryearchalgorithm(n);
        program.addValues();
        
        System.out.println("Unsorted Array:");
        program.showArray();
        
        program.quickSort(program.getArray(), 0, n - 1);
        
        System.out.println("Sorted Array:");
        program.showArray();
        
        System.out.print("Enter a number to search: ");
        int target = scanner.nextInt();
        int result = program.binarySearch(target);
        
        if (result != -1) {
            System.out.println("Number " + target + " found at index " + result + ".");
        } else {
            System.out.println("Number " + target + " not found in the array.");
        }
    }
    
    static void Quicksortalgorithm(){
        int n;
        do {            
           n = Utilizer.checkNumber();
        } while (n == -1);
        
        Short04_Quicksortalgorithm program = new Short04_Quicksortalgorithm(n);
        program.addValues();
        
        System.out.println("Unsorted Array:");
        program.showArray();
        
        program.quickSort(program.getArray(), 0, n - 1);
        
        System.out.println("Sorted Array:");
        program.showArray();
    }
    
    static void Bubblesortprogram(){
        int n;
        do {            
           n = Utilizer.checkNumber();
        } while (n == -1);

        Short01_Bubblesortprogram program = new Short01_Bubblesortprogram(n);
        program.addValues();
        
        System.out.println("Unsorted Array:");
        program.showArray();
        
        program.bubbleSort();
        
        System.out.println("Sorted Array:");
        program.showArray();
        
    }
}

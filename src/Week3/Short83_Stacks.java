package Week3;

import java.util.Stack;
import java.util.Scanner;

public class Short83_Stacks {
    private Stack<Integer> stackValues;

    public Short83_Stacks() {
        stackValues = new Stack<>();
    }
    
    public void push(int value) {
        stackValues.push(value);
        System.out.println("Pushed: " + value);
    }
    
    public void pop() {
        if (!stackValues.isEmpty()) {
            System.out.println("Popped: " + stackValues.pop());
        } else {
            System.out.println("Stack is empty, cannot pop.");
        }
    }
    
    public void get() {
        if (!stackValues.isEmpty()) {
            System.out.println("Top value: " + stackValues.peek());
        } else {
            System.out.println("Stack is empty.");
        }
    }
    
    public void display() {
        System.out.println("Stack contents: " + stackValues);
    }
    
    public static void main(String[] args) {
        Short83_Stacks myStack = new Short83_Stacks();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Push\n2. Pop\n3. Get top\n4. Display stack\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter a number to push: ");
                    int value = scanner.nextInt();
                    myStack.push(value);
                    break;
                case 2:
                    myStack.pop();
                    break;
                case 3:
                    myStack.get();
                    break;
                case 4:
                    myStack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
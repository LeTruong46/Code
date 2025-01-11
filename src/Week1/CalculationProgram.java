package Week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculationProgram {
    private Scanner sc = new Scanner(System.in);
    private int a;
    private int b;
    private int c;

    public CalculationProgram(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void menu() {
        System.out.println("========== Equation Program ==========");
        System.out.println("1. Solve Superlative Equation");
        System.out.println("2. Solve Quadratic Equation");
        System.out.println("3. Exit");
    }

    public void calculateEquation() {
        System.out.println("----- Calculate Superlative Equation -----");
        this.a = getValidInteger("Enter A: ");
        this.b = getValidInteger("Enter B: ");
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            float x = -(float) b / a;
            System.out.println("Solution: x = " + x);
            checkNumberProperties(a, b);
        }
    }

    public void calculateQuadraticEquation() {
        System.out.println("\n----- Solve Quadratic Equation -----");
        this.a = getValidInteger("Enter A: ");
        this.b = getValidInteger("Enter B: ");
        this.c = getValidInteger("Enter C: ");

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has no solution.");
            } else {
                float x = -(float) c / b;
                System.out.println("Solution: x = " + x);
            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no solution.");
            } else if (delta == 0) {
                float x = -b / (2.0f * a);
                System.out.println("Solution: x = " + x);
            } else {
                float x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
                float x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
                System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
            }
            checkNumberProperties(a, b, c);
        }
    }

    private void checkNumberProperties(int... numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> perfectSquares = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }
        for (int num : numbers) {
            if (isPerfectSquare(num)) {
                perfectSquares.add(num);
            }
        }
        System.out.println("Old Number(s): " + oddNumbers);
        System.out.println("Number is Even: " + evenNumbers);
        System.out.println("Number is Perfect Square: " + perfectSquares);
    }

    private boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public int getValidInteger(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static void main(String[] args) {
        CalculationProgram program = new CalculationProgram(0, 0, 0);
        while (true) {
            program.menu();
            int choice = program.getValidInteger("Choose an option: ");
            switch (choice) {
                case 1:
                    program.calculateEquation();
                    break;
                case 2:
                    program.calculateQuadraticEquation();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}

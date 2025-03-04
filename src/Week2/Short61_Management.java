package Week2;

import java.util.Scanner;

public class Short61_Management {
    Scanner sc = new Scanner(System.in);

    public void menu(){
        int choice;
        do {            
            System.out.println("***** Calculator Shape Program *****");
            System.out.println("1. Calculator rectangle. ");
            System.out.println("2. Calculator circle. ");
            System.out.println("3. Calculator triangle. ");
            System.out.println("4. Exit!!!");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Please input side width of Rectangle: ");
                    double width = sc.nextDouble();
                    System.out.print("Please input length of Rectangle: ");
                    double length = sc.nextDouble();
                    Short61_Rectangle rectangle = new Short61_Rectangle(width, length);
                    rectangle.prinResult();
                    break;
                case 2:
                    System.out.print("Please input radius of Circle: ");
                    double radius = sc.nextDouble();
                    Short61_Circle circle = new Short61_Circle(radius);
                    circle.prinResult();
                    break;
                case 3:
                    System.out.print("Please input side A of Triangle: ");
                    double sideA = sc.nextDouble();
                    System.out.print("Please input side B of Triangle: ");
                    double sideB = sc.nextDouble();
                    System.out.print("Please input side C of Triangle: ");
                    double sideC = sc.nextDouble();
                    Short61_Triangle triangle = new Short61_Triangle(sideA, sideB, sideC);
                    triangle.prinResult();
                case 4:
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println("Invalid choice. Error!");
            }
        } while (choice != 4);
    }
    public static void main(String[] args) {
        Short61_Management management = new Short61_Management();
        management.menu();
    }
}

package Week4;

import java.util.Scanner;

public class Week4_Test {
    public void menu(){
        Scanner sc = new Scanner(System.in);
        Long21_StudentManagement studentManagement = new Long21_StudentManagement();
        int choice;
        do {            
            System.out.println("----------Menu----------");
            System.out.println("1. Long 21: Student management.");
            System.out.println("2. Short 105: Teacher & student information.");
            System.out.println("3. Exit.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    studentManagement.menu();
                    break;
                case 2:
                    enterTeacherOrStudent();
                    break;
                case 3: 
                    System.out.println("Exit....");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (choice != 3);
        sc.close();
    }
     private void enterTeacherOrStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to enter information for:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");
        int subChoice = sc.nextInt();
        sc.nextLine(); 

        if (subChoice == 1) {
            Teacher teacher = new Teacher(0, " ", 0, 0, " ", " ", 0, " ");
            System.out.println("Enter information for Person:");
            teacher.InputAll();
            System.out.println("Person information entered successfully!");
            System.out.println(teacher);
        } else if (subChoice == 2) {
            Student student = new Student(0, 0, 0, " ", " ", 0, " ");
            System.out.println("Enter information for Student:");
            student.InputAll();
            System.out.println("Student information entered successfully!");
            System.out.println(student);
        } else {
            System.out.println("Invalid choice! Returning to main menu.");
        }
    }
     public static void main(String[] args) {
        Week4_Test test = new Week4_Test();
        test.menu();
    }
}

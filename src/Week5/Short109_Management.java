package Week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Short109_Management {
    private List<Short109_OnlineCourse> onlineCourseList = new ArrayList<>();
    private List<Short109_OfflineCourse> offlineCoursesList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    public void addOnlineCourse(){
        Short109_OnlineCourse olc = new Short109_OnlineCourse(" ", " ", " ", " ", " ", 0);
        olc.inputAll();
        onlineCourseList.add(olc);      
    }
    
    public void addOfflineCourse(){
        Short109_OfflineCourse oflc = new Short109_OfflineCourse(" ", "" , " ", " ", " ", 0);
        oflc.inputAll();
        offlineCoursesList.add(oflc);
    }
    public void menuAdd() {
        String choice;
        do {
            System.out.println("*** Menu Add ***");
            System.out.println("O. Add online course.");
            System.out.println("F. Add offline course.");
            System.out.print("Enter course you want to add O(online)/F(offline): ");
            choice = sc.nextLine();
            switch (choice.toUpperCase()) { 
                case "O":
                    addOnlineCourse();
                    break;
                case "F":
                    addOfflineCourse();
                    break;
                default:
                    System.out.println("Invalid choice. Please select O (online) or F (offline).");
                    continue; 
            }

            String continueChoice;
            do {
                System.out.print("Do you want to continue adding courses? (Y/N): ");
                continueChoice = sc.nextLine().toUpperCase();
                if (continueChoice.equals("N")) {
                    System.out.println("Exiting menu...");
                    return; 
                } else if (continueChoice.equals("Y")) {
                    break; 
                } else {
                    System.out.println("Invalid input. Please enter Y (Yes) or N (No).");
                }
            } while (true);
        } while (true); 
    }

    public boolean deleteCourse() {
        System.out.print("Enter course ID you want to delete: ");
        String courseID = sc.nextLine();
        for (Short109_OnlineCourse short109_OnlineCourse : onlineCourseList) {
            if(short109_OnlineCourse.getCourseID().equals(courseID)){
                onlineCourseList.remove(short109_OnlineCourse);
                return true;
            }
        }
        for (Short109_OfflineCourse short109_OfflineCourse : offlineCoursesList) {
            if(short109_OfflineCourse.getCourseID().equals(courseID)){
                offlineCoursesList.remove(short109_OfflineCourse);
                return true;
            }
        }
        return false;
    }

    
    public void updateCourse(){
        System.out.print("Enter course ID you want to update: ");
        String courseID = sc.nextLine();
        for (Short109_OnlineCourse ol : onlineCourseList) {
            if(ol.getCourseID().equals(courseID)){
                System.out.println("*** Update course ***");
                ol.inputAll();
                return;
            }
        }
        for (Short109_OfflineCourse of : offlineCoursesList){
            if(of.getCourseID().equals(courseID)){
                System.out.println("*** Update course ***");
                of.inputAll();
                return;
            }
        }
    }
    
    public void showOnlineCourse(){
        for (Short109_OnlineCourse short109_OnlineCourse : onlineCourseList) {
            System.out.println(short109_OnlineCourse.toString());
        }
    }
    
    public void showOfflineCourse(){
        for (Short109_OfflineCourse short109_OfflineCourse : offlineCoursesList) {
            System.out.println(short109_OfflineCourse.toString());
        }
    }
    
    public void menuShow(){
        int choice;
        do {            
            System.out.println("*** Show Courses Menu ***");
            System.out.println("1. Show all courses.");
            System.out.println("2. Show online courses.");
            System.out.println("3. Show offline courses.");
            System.out.println("4. Exit.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showOnlineCourse();
                    showOnlineCourse();
                    break;
                case 2:
                    showOnlineCourse();
                    break;
                case 3:
                    showOfflineCourse();
                    break;
                case 4:
                    System.out.println("Exit...");
                    break;
                default:
                     System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        } while (choice != 4);
    }
    
    public void searchInformation(){
        String courseID = sc.nextLine();
        System.out.println("*** Search result ***");
        boolean found = false;
        for (Short109_OnlineCourse short109_OnlineCourse : onlineCourseList) {
            if(short109_OnlineCourse.getCourseID().equals(courseID)){
                System.out.println(short109_OnlineCourse);
                found = true;
            }
        }
        for (Short109_OfflineCourse short109_OfflineCourse : offlineCoursesList){
            if(short109_OfflineCourse.getCourseID().equals(courseID)){
                System.out.println(short109_OfflineCourse);
                found = true;
            }
        }
        if(!found){
            System.out.println("No course found with the given ID.");
        }
    }
    
    public void menuCourse(){
        Short109_Management mg = new Short109_Management();
        int choice;
        do {            
            System.out.println("*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all / online course / offline course");
            System.out.println("5. Search information based on course ID");
            System.out.println("6. Exit");
            System.out.print("You choose: "); 
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    mg.menuAdd();
                    break;
                case 2:
                    mg.updateCourse();
                    break;
                case 3:
                    mg.deleteCourse();
                    break;
                case 4:
                    mg.menuShow();
                    break;
                case 5:
                    mg.searchInformation();
                    break;
                case 6:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
    
    public static void main(String[] args) {
        Short109_Management mg = new Short109_Management();
        mg.menuCourse();
    }
}

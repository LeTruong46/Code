package Week5;

import java.util.Scanner;

public class Short109_Course {
    private String courseID;
    private String courseName;
    private int credits;

    public Short109_Course(String courseID, String courseName, int credits) {
        this.courseID = " ";
        this.courseName = " ";
        this.credits = 0;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Short109_Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", credits=" + credits + '}';
    }
    
    private Scanner sc = new Scanner(System.in);
    public void inputAll() {
        do {
            System.out.print("Course ID: ");
            courseID = sc.nextLine();
            if (!Utilizer.isValidCourseID(courseID)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidCourseID(courseID));

        do {
            System.out.print("Course Name: ");
            courseName = sc.nextLine();
            if (!Utilizer.isValidString(courseName)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidString(courseName));

        do {
            System.out.print("Credits: ");
            credits = sc.nextInt();
            sc.nextLine(); 
            if (!Utilizer.isValidCredits(credits)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidCredits(credits));
    }
}

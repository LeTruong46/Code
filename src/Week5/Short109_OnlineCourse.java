package Week5;

import java.util.Scanner;

public class Short109_OnlineCourse extends Short109_Course{
    private String platform;
    private String instructors;
    private String note;

    public Short109_OnlineCourse(String platform, String instructors, String note, String courseID, String courseName, int credits) {
        super(courseID, courseName, credits);
        this.platform = " ";
        this.instructors = " ";
        this.note = " ";
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return super.toString() + "Short109_OnlineCourse{" + "platform=" + platform + ", instructors=" + instructors + ", note=" + note + '}';
    }
    
    private Scanner sc = new Scanner(System.in);
    public void inputAll() {
        super.inputAll();

        do {
            System.out.print("Platform: ");
            platform = sc.nextLine();
            if (!Utilizer.isValidString(platform)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidString(platform));

        do {
            System.out.print("Instructors: ");
            instructors = sc.nextLine();
            if (!Utilizer.isValidString(instructors)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidString(instructors));

        do {
            System.out.print("Note: ");
            note = sc.nextLine();
            if (!Utilizer.isValidString(note)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidString(note));
    }
}

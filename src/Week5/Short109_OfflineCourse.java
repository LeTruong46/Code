package Week5;

import java.util.Scanner;

public class Short109_OfflineCourse extends Short109_Course{
    private String begin;
    private String end;
    private String campus;

    public Short109_OfflineCourse(String begin, String end, String campus, String courseID, String courseName, int credits) {
        super(courseID, courseName, credits);
        this.begin = " ";
        this.end = " ";
        this.campus = " ";
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return super.toString() + "Short109_OfflineCourse{" + "begin=" + begin + ", end=" + end + ", campus=" + campus + '}';
    }
    
    private Scanner sc = new Scanner(System.in);
    public void inputAll() {
        super.inputAll();

        do {
            System.out.print("Begin Date (yyyy-MM-dd): ");
            begin = sc.nextLine();
            System.out.print("End Date (yyyy-MM-dd): ");
            end = sc.nextLine();
            if (!Utilizer.isValidDate(begin, end)) {
                System.out.println("Data input is invalid, end must be after begin");
            }
        } while (!Utilizer.isValidDate(begin, end));

        do {
            System.out.print("Campus: ");
            campus = sc.nextLine();
            if (!Utilizer.isValidString(campus)) {
                System.out.println("Data input is invalid");
            }
        } while (!Utilizer.isValidString(campus));
    }
    
}

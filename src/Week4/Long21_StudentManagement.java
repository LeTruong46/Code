package Week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Long21_StudentManagement {
    private ArrayList<Long21_Students> studentList = new ArrayList<>();
    
    private boolean checkStudent(Long21_Students st){
        for (Long21_Students student : studentList) {
        int matchCount = 0;
            if(student.getID().equals(st.getID())) matchCount++;
            if(student.getStudentName().equals(st.getStudentName())) matchCount++;
            if(student.getSemester().equals(st.getSemester())) matchCount++;
            if(student.getCourseName().equals(st.getCourseName())) matchCount++;
            if(matchCount == 4){
                    return false;
            }
        }
        //kiểm tra sv đã có trong List hay chưa nếu chưa trả về true, nếu có rồi thì trả về false
        return true;
    }
    
    public boolean addStudent(Long21_Students st){
        if(checkStudent(st)){
            studentList.add(st);
            return true;
        }
        return false;
    }
    
    public void createStudent() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter student ID:");
            String id = sc.nextLine();
            System.out.print("Enter student name:");
            String name = sc.nextLine();
            System.out.print("Enter semester:");
            String semester = sc.nextLine();
            System.out.print("Enter course name (Java, .Net, C/C++):");
            String courseName = sc.nextLine();

            if (addStudent(new Long21_Students(id, name, semester, courseName))) {
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Student with this combination of details already exists.");
            }

            System.out.println("Do you want to continue adding students (Y/N)?");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("N")) {
                System.out.println("Student creation process completed.");
                break;
            }
        }
    }

    
    public void showStudent(){
        for (Long21_Students student : studentList) {
            System.out.println(student.toString());
        }
    }
    
    public List<Long21_Students> findStudents(String name){
        List<Long21_Students> listST = new ArrayList<>();
        for (Long21_Students long21_Students : listST) {
            if(long21_Students.getStudentName().toLowerCase().contains(name.toLowerCase())){
                listST.add(long21_Students);
            }
        }
        return listST;
    }
    
    public int deleteStudent(String id){
        for (Long21_Students student : studentList) {
            if(student.getID().equals(id)){
                studentList.remove(student);
                return 1;
            }
        }
        //viết code để xóa
        return 0;
    }
    
    public int updateStudent(String id){
        Scanner sc = new Scanner(System.in);
        for (Long21_Students student : studentList) {
            if(student.getID().equals(id)){
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new semester: ");
                String newSemester = sc.nextLine();
                System.out.print("Enter new course name: ");
                String newCourseName = sc.nextLine();
                student.setStudentName(newName);
                student.setSemester(newSemester);
                student.setCourseName(newCourseName);
                return 1;
            }
        }
        //code
        return 0;
    }
   
    public void sortStudent() {
        Collections.sort(studentList, new Comparator<Long21_Students>() {
            @Override
            public int compare(Long21_Students st1, Long21_Students st2) {
                return st1.getStudentName().compareToIgnoreCase(st2.getStudentName());
            }
        });
    }
    
    public void reportStudent(){
        Map<String, Integer> report = new HashMap<>();
        for (Long21_Students student : studentList) {
            String key = student.getID() + " | " + student.getStudentName() + " | " + student.getSemester() + " | " + student.getCourseName();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());          
        }
    }
    public void combinedFindAndSort() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name to search and sort:");
        String name = sc.nextLine();
        List<Long21_Students> foundStudents = findStudents(name);
        sortStudent();
        for (Long21_Students student : foundStudents) {
            System.out.println(student);
        }
    }

    public void chooseUpdateOrDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to search:");
        String id = sc.nextLine();
        for (Long21_Students student : studentList) {
            if (student.getID().equals(id)) {
                System.out.println("Do you want to update (U) or delete (D) the student?");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("U")) {
                    System.out.println("Enter new name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter new semester:");
                    String newSemester = sc.nextLine();
                    System.out.println("Enter new course name:");
                    String newCourseName = sc.nextLine();
                    student.setStudentName(newName);
                    student.setSemester(newSemester);
                    student.setCourseName(newCourseName);
                    System.out.println("Student updated successfully.");
                } else if (choice.equalsIgnoreCase("D")) {
                    studentList.remove(student);
                    System.out.println("Student deleted successfully.");
                }
                break;
            }
        }
    }
    public void menu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("-------------Student Manager-------------");
            System.out.println("1. Create.");
            System.out.println("2. Find and Sort.");
            System.out.println("3. Update or delete.");
            System.out.println("4. Report.");
            System.out.println("5. Exit.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    combinedFindAndSort();
                    break;
                case 3:
                    chooseUpdateOrDelete();
                    break;
                case 4:
                    reportStudent();
                    break;
                case 5:
                    System.out.println("Exit...");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (choice != 5);
    }
}

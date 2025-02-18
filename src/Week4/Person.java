package Week4;

import java.util.Scanner;

public class Person {

    private int ID;
    private String fullName;
    private String phoneNumber;
    private int yearOB;
    private String major;

    public Person(int ID, String fullName, String phoneNumber, int yearOB, String major) {
        this.ID = 0 ;
        this.fullName = " ";
        this.phoneNumber = " ";
        this.yearOB = 0;
        this.major = " ";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getYearOB() {
        return yearOB;
    }

    public void setYearOB(int yearOB) {
        this.yearOB = yearOB;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    @Override
    public String toString() {
        return "Person{" + "ID=" + ID + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", yearOB=" + yearOB + ", major=" + major + '}';
    }
    
    public void InputAll(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("Enter ID: ");
            String input = sc.nextLine();
            if (input.matches("\\d{6}")) {
                this.ID = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid ID. Please enter again.");
            }
        }
        
        while(true){
            System.out.print("Enter full name: ");
            String input = sc.nextLine();
            if(input.matches("[a-zA-Z ]+")){
                this.fullName = input;
                break;
            } else {
                System.out.println("Invalid full name. Please enter again.");
            }
        }
        
        while (true) {            
            System.out.print("Enter phone number: ");
            String input = sc.nextLine();
            if (input.matches("\\d{12}")) {
                this.phoneNumber = input;
                break;
            } else {
                System.out.println("Invalid phone number. Please enter again.");
            }
        }
        
        while (true){
            System.out.print("Enter year of birth:");
            int year = sc.nextInt();
            int currentYear = java.time.Year.now().getValue();
            if(year > 0 && year < currentYear){
                this.yearOB = year;
                break;
            } else {
                System.out.println("Invalid year. Please enter again.");
            }
        }
        
        while (true){
            System.out.print("Enter major: ");
            String input = sc.nextLine();
            if(input.length() <= 30){
                this.major = input;
                break;
            } else {
                System.out.println("Invalid major. Please enter again.");
            }
        }
    }

}
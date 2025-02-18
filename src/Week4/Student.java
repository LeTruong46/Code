
package Week4;

import java.util.Scanner;

public class Student extends Person{
    private int yearOfAdmission;
    private double entranceEnglishScore;

    public Student(int yearOfAdmission, double entranceEnglishScore, int ID, String fullName, String phoneNumber, int yearOB, String major) {
        super(ID, fullName, phoneNumber, yearOB, major);
        this.yearOfAdmission = yearOfAdmission;
        this.entranceEnglishScore = entranceEnglishScore;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" + "yearOfAdmission=" + yearOfAdmission + ", entranceEnglishScore=" + entranceEnglishScore + '}';
    }
    
    public void InputAll(){
        Scanner sc = new Scanner(System.in);
        
        while (true) {            
            System.out.print("Enter year of adminssion: ");
            int year = sc.nextInt();
            int currentYear = java.time.Year.now().getValue();
            if(year > 0 || year <= currentYear ){
                this.yearOfAdmission = year;
                break;
            } else{
                System.out.println("Invalid year. Please enter a valid year of adminssion.");
            }
        }
        
        while(true){
            System.out.print("Enter entrance english score: ");
            double score = sc.nextDouble();
            if(0 <= score && score <= 100){
                this.entranceEnglishScore = score;
                break;
            } else {
                System.out.println("Invalid score. Please enter score from 0 to 100.");
            }
        }
    }
    
}

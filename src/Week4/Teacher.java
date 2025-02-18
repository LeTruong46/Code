package Week4;

import java.util.Scanner;

public class Teacher extends Person{
    private int yearProfession;
    private String contractType;
    private double salary;

    public Teacher(int yearProfession, String contractType, double salary, int ID, String fullName, String phoneNumber, int yearOB, String major) {
        super(ID, fullName, phoneNumber, yearOB, major);
        this.yearProfession = 0;
        this.contractType = " ";
        this.salary = 0;
    }

    @Override
    public String toString() {
        return super.toString() +  "Teacher{" + "yearProfession=" + yearProfession + ", contractType=" + contractType + ", salary=" + salary + '}';
    }
    
    public void inputAll(){
        Scanner sc = new Scanner(System.in);
        super.InputAll();
        
        while (true) {            
            System.out.println("Enter year in profession: ");
            int year = sc.nextInt();
            int age = java.time.Year.now().getValue() - super.getYearOB();
            if (year >= 0 && year <= age) {
                this.yearProfession = year;
                break;
            } else {
                System.out.println("Invalid years in profession. Please enter a value between 0 and " + age);
            }
        }
        sc.nextLine();
        
        while (true) {            
            System.out.println("Enter contractType (Long/Short): ");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("Long") || input.equalsIgnoreCase("Short")){
                this.contractType = input;
                break;
            } else{
                System.out.println("Invalid contract type. Please enter 'Long' or 'Short'. ");
            }
        }
        
        while (true) {            
            System.out.print("Enter salary: ");
            double sl =  sc.nextDouble();
            if(sl >= 0){
                this.salary = sl;
                break;
            } else{
                System.out.println("Invalid salary. Please enter a number >= 0.");
            }
        }
    }
}
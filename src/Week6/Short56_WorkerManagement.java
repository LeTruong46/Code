package Week6;

import java.util.*;
import java.text.SimpleDateFormat;

public class Short56_WorkerManagement {
    private final List<Short56_Worker> workers = new ArrayList<>();
    private final List<Short56_SalaryHistory> salaryHistories = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    
    public boolean addWorker() {
        System.out.println("--------- Add Worker ----------");
        System.out.print("Enter Code: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter Age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 18 || age > 50) {
                    System.out.println("Error: Age must be between 18 and 50!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a valid number.");
            }
        }

        double salary;
        while (true) {
            System.out.print("Enter Salary: ");
            try {
                salary = Double.parseDouble(scanner.nextLine());
                if (salary <= 0) {
                    System.out.println("Error: Salary must be greater than 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a valid number.");
            }
        }

        System.out.print("Enter work location: ");
        String location = scanner.nextLine();

        for (Short56_Worker w : workers) {
            if (w.getId().equals(id)) {
                System.out.println("Error: Duplicate worker ID!");
                return false;
            }
        }
        workers.add(new Short56_Worker(id, name, age, salary, location));
        System.out.println("Worker added successfully!");
        return true;
    }
    
    public boolean changeSalary(String status) {
        System.out.println("------- " + (status.equals("UP") ? "Increase" : "Decrease") + " Salary --------");
        System.out.print("Enter Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Salary Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        
        if (amount <= 0) {
            System.out.println("Error: Salary amount must be > 0!");
            return false;
        }
        
        for (Short56_Worker worker : workers) {
            if (worker.getId().equals(code)) {
                double newSalary = status.equals("UP") ? worker.getSalary() + amount : worker.getSalary() - amount;
                if (newSalary < 0) {
                    System.out.println("Error: Salary cannot be negative!");
                    return false;
                }
                worker.setSalary(newSalary);
                salaryHistories.add(new Short56_SalaryHistory(worker.getId(), (int) newSalary, status));
                System.out.println("Salary updated successfully!");
                return true;
            }
        }
        System.out.println("Error: Worker ID not found!");
        return false;
    }
    
    public void displaySalaryInformation() {
        System.out.println("-------------------- Display Salary Information -----------------------");
        for (Short56_SalaryHistory sh : salaryHistories) {
            System.out.println(sh);
        }
    }
    
    public void menu() {
        while (true) {
            System.out.println("======== Worker Management =========");
            System.out.println("1. Add Worker");
            System.out.println("2. Increase Salary");
            System.out.println("3. Decrease Salary");
            System.out.println("4. Display Salary Information");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: 
                    addWorker(); 
                    break;
                case 2: 
                    changeSalary("UP"); 
                    break;
                case 3: 
                    changeSalary("DOWN"); 
                    break;
                case 4: 
                    displaySalaryInformation(); 
                    break;
                case 5: 
                    System.out.println("Exiting program..."); 
                    return;
                default: 
                    System.out.println("Invalid option, please choose again.");
            }
        }
    }
    
    public static void main(String[] args) {
        new Short56_WorkerManagement().menu();
    }
}

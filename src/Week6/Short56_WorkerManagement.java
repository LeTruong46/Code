package Week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Short56_WorkerManagement {
    private List<Short56_Worker> workers = new ArrayList<>();
    private List<Short56_SalaryHistory> salaryHistories = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
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
        displayWorkers();
        return true;
    }
    
    public void displayWorkers() {
        System.out.println("--------- List of Workers ---------");
        System.out.printf("%-5s %-10s %-3s %-10s %-10s\n", "ID", "Name", "Age", "Salary", "Location");
        for (Short56_Worker w : workers) {
            System.out.printf("%-5s %-10s %-3d %-10.2f %-10s\n", w.getId(), w.getName(), w.getAge(), w.getSalary(), w.getWorkLocation());
        }
    }
    
    public boolean changeSalary(String code, double amount, String status) {
        for (Short56_Worker worker : workers) {
            if (worker.getId().equals(code)) {
                double newSalary = status.equals("UP") ? worker.getSalary() + amount : worker.getSalary() - amount;
                if (newSalary < 0) {
                    System.out.println("Error: Salary cannot be negative!");
                    return false;
                }
                worker.setSalary(newSalary);
                salaryHistories.add(new Short56_SalaryHistory(worker.getId(), worker.getName(), worker.getAge(), newSalary, status));
                return true;
            }
        }
        System.out.println("Error: Worker ID not found!");
        return false;
    }

    public List<Short56_SalaryHistory> getInformationSalary() {
        return salaryHistories;
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
                salaryHistories.add(new Short56_SalaryHistory(worker.getId(), worker.getName(), worker.getAge(), newSalary, status));
                return true;
            }
        }
        System.out.println("Error: Worker ID not found!");
        return false;
    }

    public void displaySalaryInformation() {
        System.out.println("-------------------- Display Information Salary -----------------------");
        for (Short56_SalaryHistory sh : salaryHistories) {
            System.out.println(sh);
        }
    }
    
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        Short56_WorkerManagement manager = new Short56_WorkerManagement();
        
        while (true) {
            System.out.println("======== Worker Management =========");
            System.out.println("1. Add Worker");
            System.out.println("2. Up salary");
            System.out.println("3. Down salary");
            System.out.println("4. Display Information salary");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    manager.addWorker();
                    break;
                case 2:
                    manager.changeSalary("UP");
                    break;
                case 3:
                    manager.changeSalary("DOWN");
                    break;
                case 4:
                    manager.displaySalaryInformation();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please choose again.");
            }
        }
    }
    public static void main(String[] args) {
        Short56_WorkerManagement management = new Short56_WorkerManagement();
        management.menu();
    }
}

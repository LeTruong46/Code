package Week6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Short54_ContactManager {
    private List<Short54_Contact> contacts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int idCounter = 1;

    public void addContact() {
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter group: ");
        String group = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Phone: ");
        String phone;
        do {            
            phone = getStringInput("Enter Phone (Valid formats: \n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890)\n"
                    + "Enter: ");
        } while (!isValidPhone(phone));
        contacts.add(new Short54_Contact(idCounter++, firstName, lastName, group, address, phone));
        System.out.println("Successful");
    }
    
    private static boolean isValidPhone(String phone) {
        String regex = "^(\\d{10}|(\\d{3}[-\\.\\s]?){2}\\d{4}|\\d{3}-\\d{3}-\\d{4} x\\d{1,5}|\\d{3}-\\d{3}-\\d{4} ext\\d{1,5})$";
        return phone.matches(regex);
    }
    
    public String getStringInput(String prompt){
        System.out.println(prompt);
        while (true) {            
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
                System.out.print("Enter again: ");
            } else{
                return result;
            }
        }
    }
    
    public void displayAll() {
        System.out.println("***** Display all Contact *****");
        System.out.printf("%-5s %-20s %-12s %-12s %-8s %-15s %-15s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
            for (Short54_Contact c : contacts) {
                System.out.println(c);
            }
    }

    public void deleteContact() {
        Iterator<Short54_Contact> iterator = contacts.iterator();
        System.out.print("Enter Contact ID to delete: ");
        int id = sc.nextInt();
        while (iterator.hasNext()) {
            if (iterator.next().getID()== id) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact ID not found.");
    }
    public void menu(){
        while (true) {
            System.out.println("========= Contact program =========");
            System.out.println("1. Add a Contact");
            System.out.println("2. Display all Contacts");
            System.out.println("3. Delete a Contact");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    public static void main(String[] args) {
        Short54_ContactManager manager = new Short54_ContactManager();
        manager.menu();
    }
}
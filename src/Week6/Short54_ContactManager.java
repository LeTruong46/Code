package Week6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Short54_ContactManager {
    private List<Short54_Contact> contacts = new ArrayList<>();
    private int idCounter = 1;

    public void addContact(String firstName, String lastName, String group, String address, String phone) {
        if (!Validation.isValidPhone(phone)) {
            System.out.println("Invalid phone number format!");
            return;
        }
        contacts.add(new Short54_Contact(idCounter++, firstName, lastName, group, address, phone));
        System.out.println("Successful");
    }

    public void displayAll() {
        System.out.println("ID\tName\tGroup\tAddress\tPhone");
        for (Short54_Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void deleteContact(int id) {
        Iterator<Short54_Contact> iterator = contacts.iterator();
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
        Short54_ContactManager manager = new Short54_ContactManager();
        Scanner sc = new Scanner(System.in);
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
                    System.out.println("-------- Add a Contact --------");
                    System.out.print("Enter First Name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter Group: ");
                    String group = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    manager.addContact(firstName, lastName, group, address, phone);
                    break;
                case 2:
                    System.out.println("***** Display all Contact *****");
                    manager.displayAll();
                    break;
                case 3:
                    System.out.print("Enter Contact ID to delete: ");
                    int id = sc.nextInt();
                    manager.deleteContact(id);
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
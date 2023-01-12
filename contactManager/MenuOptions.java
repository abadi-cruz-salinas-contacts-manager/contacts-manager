package contactManager;

import java.io.*;
import java.util.*;

class ContactApp {
    static List<Contact> contacts = new ArrayList<>();
    static String fileName = "contacts.txt";

    public static void main(String[] args) {
        loadContacts();
        int choice;
        do {
            choice = showMenu();
            switch (choice) {
                case 1:
                    viewContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    saveContacts();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);
    }

    public static void loadContacts() {
        // Read from contacts.txt file and populate the contacts list
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split("\\|");
                contacts.add(new Contact(contact[0], contact[1]));
            }
        } catch (IOException e) {
            System.out.println("Error reading contacts.txt");
        }
    }

    public static void saveContacts() {
        // Write the contacts list to the contacts.txt file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                bw.write(contact.getName() + "|" + contact.getPhone());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to contacts.txt.");
        }
    }

    public static int showMenu() {
        // Show the main menu and return the user's choice
        System.out.println("\nContact App");
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.print("Enter an option (1-5): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void viewContacts() {
        // Show all contacts
        System.out.println("\nName | Phone Number");
        System.out.println("---------------");
        for (Contact contact : contacts) {
            System.out.println(contact.getName() + " | " + contact.getPhone());
        }
    }

    public static void addContact() {
        // Add a new contact
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the contact's phone number: ");
        String phone = scanner.nextLine();
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added!");
    }

    public static void searchContact() {
        // Search for a contact by name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("\nName | Phone Number");
                System.out.println("---------------");
                System.out.println(contact.getName() + " | " + contact.getPhone());
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    public static void deleteContact() {
        // Delete an existing contact
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact removed.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}










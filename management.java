import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class ContactManager {

    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Contact Management System!");
        System.out.println("Available commands: add, view, delete, exit");

        while (true) {
            System.out.print("Enter a command: ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    contacts.add(new Contact(name, phoneNumber));
                    System.out.println("Contact added: " + name);
                    break;

                case "view":
                    System.out.println("Contact List:");
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.println((i + 1) + ". " + contacts.get(i));
                        }
                    }
                    break;

                case "delete":
                    System.out.print("Enter the contact number to delete: ");
                    int contactNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (contactNumber > 0 && contactNumber <= contacts.size()) {
                        Contact removedContact = contacts.remove(contactNumber - 1);
                        System.out.println("Deleted contact: " + removedContact);
                    } else {
                        System.out.println("Invalid contact number.");
                    }
                    break;

                case "exit":
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}

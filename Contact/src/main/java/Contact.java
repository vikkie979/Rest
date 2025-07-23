import java.util.ArrayList;
import java.util.Scanner;
class Contacts {
    String name;
    String surname;
    String phoneNumber;
    String emailId;
    String place;
    Contacts(String name, String surname, String phoneNumber, String emailId, String place) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.place = place;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Phone Number: " + phoneNumber + ", Email ID: " + emailId + ", Place: " + place;
    }
}
public class Contact {
    public Contact(String name, String surname, String phoneNumber, String emailId, String place) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        ArrayList <Contact> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name (or type 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter surname: ");
            String surname = scanner.nextLine();
            System.out.println("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter email ID: ");
            String emailId = scanner.nextLine();
            System.out.println("Enter place: ");
            String place = scanner.nextLine();
            list.add(new Contact(name, surname, phoneNumber, emailId, place));
        }
        System.out.println("\nTelephone Dictionary:");
        for (Contact contact : list) {
            System.out.println(contact);
        }
        scanner.close();
    }
}
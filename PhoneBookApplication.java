package HW7Exercise2;

import java.util.Scanner;
import java.io.*;

public class PhoneBookApplication {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Read admin and normal user details from files
	
        PhoneBookAdmin admin = readAdminFromFile("src/HW7Exercise2/admin.txt");
        NormalUser normalUser = readNormalUserFromFile("src/HW7Exercise2/normaluser.txt");
        
        if (admin == null || normalUser == null) {
            System.out.println("Error to read user data from file.");
            return;
        }
        
        // Ask user to log in
        System.out.println("Welcome to the PhoneBook Application");
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
		
        // check if the user is an admin or a normal user
        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            System.out.println("Welcome Admin!");
            adminMenu(admin, input);
        } else if (normalUser.getUsername().equals(username) && normalUser.getPassword().equals(password)) {
            System.out.println("Welcome Normal User!");
            normalUserMenu(normalUser, input);
        } else {
            System.out.println("Invalid login credentials.");
        }

        input.close();
	}
	
	
	// method to print admin menu
	private static void adminMenu(PhoneBookAdmin admin, Scanner input) {
	    int choice;
	    do {
	        System.out.println("\nAdmin Menu:");
	        System.out.println("1. Add Phone Entry");
	        System.out.println("2. Edit Phone Entry");
	        System.out.println("3. Delete Phone Entry");
	        System.out.println("4. Sort Phonebook");
	        System.out.println("5. Search by Phone Number");
	        System.out.println("6. Search by ID");
	        System.out.println("7. Print Admin Info");
	        System.out.println("8. Change Username");
	        System.out.println("9. Change Password");
	        System.out.println("10.Print all entries");
	        System.out.println("0. Logout");
	        System.out.print("Enter your choice: ");
	        choice = input.nextInt();
	        input.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	            	System.out.println("Enter details for the new phonebook entry:");
	        		
	        		System.out.println("Enter ID: ");
	        		int id = input.nextInt();
	        		input.nextLine();
	        		
	        		System.out.println("Enter First Name: ");
	        		String FName = input.nextLine();
	        		
	        		System.out.println("Enter Last Name: ");
	        		String LName = input.nextLine();
	        		
	        		System.out.println("Enter Email: ");
	        		String emailAddr = input.nextLine();
	        		
	        		System.out.println("Enter Zip Code: ");
	        		String zCode = input.nextLine();
	        		
	        		System.out.println("Enter Phone Number: ");
	        		String pN = input.nextLine();
	        		PhoneBookEntry newEntry = new PhoneBookEntry(id,FName,LName,emailAddr,zCode,pN);
	                
	        		admin.addEntry(newEntry);
	                break;
	            case 2:
	                System.out.print("Enter First Name: ");
	                String firstName = input.nextLine();
	                System.out.print("Enter Last Name: ");
	                String lastName = input.nextLine();
	                admin.editEntry(firstName, lastName);
	                break;
	            case 3:
	                System.out.print("Enter ID to delete: ");
	                int adminId = input.nextInt();
	                input.nextLine();
	                admin.deleteEntry(adminId);
	                break;
	            case 4:
	                admin.sortPhoneBook();
	                break;
	            case 5:
	                System.out.print("Enter Phone Number to search: ");
	                String phoneNumber = input.nextLine();
	                admin.searchByPhoneNumber(phoneNumber);
	                break;
	            case 6:
	                System.out.print("Enter ID to search: ");
	                int searchId = input.nextInt();
	                input.nextLine();
	                admin.searchById(searchId);
	                break;
	            case 7:
	                admin.PrintUserInfo();
	                break;
	            
	            case 8:
	                System.out.print("Enter new username: ");
	                String newUsername = input.nextLine();
	                admin.setUsername(newUsername);
	                break;
	            case 9:
	                System.out.print("Enter new password: ");
	                String newPassword = input.nextLine();
	                admin.setPassword(newPassword);
	                break;
	            case 10:
	            	admin.printAllEntries();
	                break;
	            case 0:
	                System.out.println("Logging out...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    } while (choice != 0);
	}
	
	// method to print normal user menu
	private static void normalUserMenu(NormalUser user, Scanner input) {
	    int choice;
	    do {
	        System.out.println("\nNormal User Menu:");
	        System.out.println("1. Add Phone Entry");
	        System.out.println("2. Edit Phone Entry");
	        System.out.println("3. Sort Phonebook");
	        System.out.println("4. Search by Phone Number");
	        System.out.println("5. Print User Info");
	        System.out.println("0. Logout");
	        System.out.print("Enter your choice: ");
	        choice = input.nextInt();
	        input.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	            	System.out.println("Enter details for the new phonebook entry:");
	        		
	        		System.out.println("Enter ID: ");
	        		int id = input.nextInt();
	        		input.nextLine();
	        		
	        		System.out.println("Enter First Name: ");
	        		String FName = input.nextLine();
	        		
	        		System.out.println("Enter Last Name: ");
	        		String LName = input.nextLine();
	        		
	        		System.out.println("Enter Email: ");
	        		String emailAddr = input.nextLine();
	        		
	        		System.out.println("Enter Zip Code: ");
	        		String zCode = input.nextLine();
	        		
	        		System.out.println("Enter Phone Number: ");
	        		String pN = input.nextLine();
	        		PhoneBookEntry newEntry = new PhoneBookEntry(id,FName,LName,emailAddr,zCode,pN);
	                
	                user.addEntry(newEntry);
	                break;
	            case 2:
	                System.out.print("Enter First Name: ");
	                String firstName = input.nextLine();
	                System.out.print("Enter Last Name: ");
	                String lastName = input.nextLine();
	                user.editEntry(firstName, lastName);
	                break;
	            case 3:
	                user.sortPhoneBook();
	                break;
	            case 4:
	                System.out.print("Enter Phone Number to search: ");
	                String phoneNumber = input.nextLine();
	                user.searchByPhoneNumber(phoneNumber);
	                break;
	            case 5:
	                user.PrintUserInfo();
	                break;
	            case 0:
	                System.out.println("Logging out...");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    } while (choice != 0);
	}
	
	
	// method read admin from file
	public static PhoneBookAdmin readAdminFromFile(String filename) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    return new PhoneBookAdmin(parts[0].trim(), parts[1].trim(), parts[2].trim(), new PhoneBookDirectory());//Removes any whitespace characters
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading admin file: " + e.getMessage());
        }
        
        return null;
    }
	
	// method read normal user from file
	public static NormalUser readNormalUserFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                	int id = Integer.parseInt(parts[0].trim());
                    return new NormalUser(parts[1].trim(), parts[2].trim(), id, new PhoneBookDirectory());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading normal user file: " + e.getMessage());
        }
        return null;
    }
}

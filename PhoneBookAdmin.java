package HW7Exercise2;

public class PhoneBookAdmin extends User implements PhoneBookAdminInterface{
	private String email;
    private PhoneBookDirectory phoneBookDirectory;
    
    public PhoneBookAdmin(String username, String password, String email, PhoneBookDirectory phoneBookDirectory) {
        super(username, password);
        this.email = email;
        this.phoneBookDirectory = phoneBookDirectory;
    }
    
    @Override
    public void PrintUserInfo() {
        super.PrintUserInfo();
        System.out.println("Admin Email: " + email);
    }
    
    @Override
    public void addEntry(PhoneBookEntry entry) {
        phoneBookDirectory.addEntry(entry);
    }
    
    @Override
    public void editEntry(String firstName, String lastName) {
        phoneBookDirectory.Edit(firstName, lastName);
    }
    
    @Override
    public void deleteEntry(int id) {
        phoneBookDirectory.DeleteEntry(id);
    }
    
    @Override
    public void sortPhoneBook() {
        phoneBookDirectory.SortbyID();
    }
    
    @Override
    public void searchByPhoneNumber(String phoneNumber) {
        int result = phoneBookDirectory.LinearSearchByPhoneNumber(phoneNumber);
        if (result == 1) {
            System.out.println("Phone number found.");
        } else {
            System.out.println("Phone number not found.");
        }
    }
    
    @Override
    public void searchById(int id) {
        PhoneBookEntry entry = phoneBookDirectory.SearchbyIdBinarySearch(id);
        if (entry.getId() != -1) {
            entry.printBookEntry();
        } else {
            System.out.println("Entry not found.");
        }
    }
    
    @Override
    public void printAllEntries() {
        phoneBookDirectory.printEntry();
    }
    
    @Override
    public void changeUsername(String newUsername) {
        setUsername(newUsername);
    }
    
    @Override
    public void changePassword(String newPassword) {
        setPassword(newPassword);
    }
    
    
    
}

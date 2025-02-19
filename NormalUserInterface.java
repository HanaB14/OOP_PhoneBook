package HW7Exercise2;


//Define an interface for NormalUser
public interface NormalUserInterface {
	void addEntry(PhoneBookEntry entry);
    void editEntry(String firstName, String lastName);
    void sortPhoneBook();
    void searchByPhoneNumber(String phoneNumber);
    
}
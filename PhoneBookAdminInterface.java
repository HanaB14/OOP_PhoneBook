package HW7Exercise2;

public interface PhoneBookAdminInterface {
	void addEntry(PhoneBookEntry entry);
    void editEntry(String firstName, String lastName);
    void deleteEntry(int id);
    void sortPhoneBook();
    void searchByPhoneNumber(String phoneNumber);
    void searchById(int id);
    void printAllEntries();
    void changeUsername(String newUsername);
    void changePassword(String newPassword);
}

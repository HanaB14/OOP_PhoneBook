package HW7Exercise2;

public class NormalUser extends User implements NormalUserInterface {
	
	private int id;
	private PhoneBookDirectory phoneBookDirectory;
	
	public NormalUser(String username, String password, int id, PhoneBookDirectory phoneBookDirectory) {
        super(username, password);
        this.id = id;
        this.phoneBookDirectory = phoneBookDirectory;
    }

	@Override
    public void PrintUserInfo() {
        super.PrintUserInfo();
        System.out.println("User id: " + id);
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

	
	// Getters and Setters for email
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

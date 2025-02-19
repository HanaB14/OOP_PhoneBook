package HW7Exercise2;

public class PhoneBookEntry {
	private int id;
	
	private String firstName;
	
	private String lastName;

	private String email;
	
	private String zipCode;
	
	private String phoneNumber;
	
	// Constructor
	public PhoneBookEntry(){
		id = -1;
		firstName="xxx";
		lastName=null;
		email=null;
		zipCode=null;
		phoneNumber=null;
	}
	
	public PhoneBookEntry(int id, String fName, String lName, String emailAddr, String zCode, String pN) {
		this.id=id;
		this.firstName=fName;
		this.lastName=lName;
		this.email=emailAddr;
		this.zipCode=zCode;
		this.phoneNumber=pN;
	}
	
	public PhoneBookEntry(String fName, String pN) {
		this.id=-1;
		this.firstName=fName;
		this.lastName=null;
		this.email=null;
		this.zipCode=null;
		this.phoneNumber=pN;
	}
	
	public PhoneBookEntry(String fName) {
		this.id=-1;
		this.firstName=fName;
		this.lastName=null;
		this.email=null;
		this.zipCode=null;
		this.phoneNumber=null;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void printBookEntry() {
		System.out.println("ID: "+this.id);
		System.out.println("First Name: "+this.firstName);
		System.out.println("Last Name: "+this.lastName);
		System.out.println("Email: "+ this.email);
		System.out.println("Zip Code: "+this.zipCode);
		System.out.println("Phone Number: "+this.phoneNumber);
		System.out.println("------------------------------------");
	}
}

package HW7Exercise2;

// Exercise2

import java.util.Scanner;

public class PhoneBookDirectory {
	private PhoneBookEntry[] myObject;
	private int count;
	private Scanner input;
	
	
	public PhoneBookDirectory() {
		myObject = new PhoneBookEntry[6];
		count = 0;
		input = new Scanner(System.in);
	}
	
	// Method that returns 0 if the entry is full
	public int full() {
		if (count == myObject.length) {
			return 0;
		} else {
			return 1;
		}
	}
	
	// Method that finds an entry using its first name and last name
	private PhoneBookEntry findEntry(String firstName, String lastName) {
		for (int i = 0; i < count; i++) {
			if (myObject[i].getFirstName().equalsIgnoreCase(firstName) &&
		            myObject[i].getLastName().equalsIgnoreCase(lastName)) {
				return myObject[i];
			}
		}
		return null; 
	}
	
	// method 1: Add an entry to the phonebook
	public int addEntry(PhoneBookEntry entry) {
		// check if the array is full
		if(full() == 0) {
			System.out.println("Inventory is full. Cannot add add more entries.");
			return 0; // Array is full
		}
		
		myObject[count++] = entry;
		return 1; // Successfully added
		
	}
	
	// method 2: Print all phonebook entries
	public void printEntry() {
		if(count == 0) {
			System.out.println("No entry in phonebook.");
			return;
		}
		for(int i=0;i<myObject.length;i++) {
			if (myObject[i] != null) {
		        myObject[i].printBookEntry();
		        System.out.println("--------------------");
		    }
		}
	}
	
	// method 3: Search for an entry by Phone Number (Linear Search)
	public int LinearSearchByPhoneNumber(String PhoneNumber) {
		for(int i=0;i<myObject.length;i++) {
			if(myObject[i] != null && myObject[i].getPhoneNumber().equals(PhoneNumber) ){
				//return 1 if found
				return 1;
			}
		}
		//return 0 if not found
		return 0;
	}
	
	// method 4: Search for an entry by id (Binary Search)
	public PhoneBookEntry SearchbyIdBinarySearch(int id) {
		SortbyID();
		
		int low=0;
		int high=myObject.length-1;
		
		while(low<=high) {
			int mid=(low+high)/2;
			// Skip null entries in the binary search
			if (myObject[mid] == null) {
	            high--; 
	            continue;
	        }
			
			if(myObject[mid].getId() == id) {
				return myObject[mid];
			}else if(myObject[mid].getId() < id) {
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		return new PhoneBookEntry();
	}
	// Code implemented based on concepts from Chapter Eight: Arrays
	// (Professor Bari's slides)
	
	// method 5: Sort Phone Book Entries by id (selection sort)
	public void SortbyID() {
		for(int i=0;i<count - 1;i++) {
			int minIndex = i;
			for(int j=i+1;j<count;j++) {
				if(myObject[j].getId() < myObject[minIndex].getId()) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				PhoneBookEntry temp = myObject[minIndex];
				myObject[minIndex] = myObject[i];
	            myObject[i] = temp;
			}
		}
	}
	
	// method 6: Edit an entry
	public int Edit(String firstName, String lastName) {
		if (count == 0) {
			// If no entries in phonebook
			return 0;
		}
		
		System.out.print("Enter the last name of the entry you want to edit: ");
		String LNameE = input.nextLine();
		System.out.print("Enter the first name: ");
		String FNameE = input.nextLine();
		PhoneBookEntry entry = findEntry(FNameE,LNameE);
		
		// returns 0 if the entry of the given userName and lastName do not exist
		if (entry == null) {
			return 0;
		}
		
		System.out.println("Enter new id: ");
		int idE = input.nextInt();
		entry.setId(idE);
		input.nextLine();
		
		System.out.println("Enter new email: ");
		String emailE = input.nextLine();
		entry.setEmail(emailE);
		
		System.out.println("Enter new zip Code: ");
		String zCodeE = input.nextLine();
		entry.setZipCode(zCodeE);
		
		System.out.println("Enter new phone number: ");
		String pNE = input.nextLine();
		entry.setPhoneNumber(pNE);
		
		System.out.println("Entry updated successfully!");
		// return a 1 if the object was found and edited
		return 1;
	}
	
	// method 7: Delete an Entry of a given id
	
	public int DeleteEntry(int id) {
		for (int i = 0; i < count; i++) {
			if (myObject[i] != null && myObject[i].getId() == id) {
	            // Reset all attributes of the entry to default values
	            myObject[i].setId(-1);
	            myObject[i].setFirstName("xxx");
	            myObject[i].setLastName(null);
	            myObject[i].setEmail(null);
	            myObject[i].setZipCode(null);
	            myObject[i].setPhoneNumber(null);

	            return 1; // return 1 if the Entry is deleted successfully
	        }
	    }
	    return 0; // return 0 if not (not found)
		
	}	
}

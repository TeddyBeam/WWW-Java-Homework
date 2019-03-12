package w1e7;

public class Contact {
	private int id;
	private String firstName, lastName, photoPath;

	public Contact(String firstName, String lastName, String photoPath) {
		this(-1, firstName, lastName, photoPath);
	}
	
	public Contact(int id, String firstName, String lastName, String photoPath)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photoPath = photoPath;
	}	

	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getPhotoPath() {
		return photoPath;
	}
}

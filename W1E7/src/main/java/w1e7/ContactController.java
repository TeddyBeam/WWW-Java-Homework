package w1e7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.Part;

public class ContactController {
	public static final String photosDirectory = "E:\\SpringToolSuiteWorkspace\\SchoolJavaWWWHomework\\W1E7\\photos";
	
	private ContactDAO contactDAO;
	
	public ContactController() {
		contactDAO = new ContactDAO();
	}
	
	public boolean isAvailable() {
		return contactDAO != null && contactDAO.isAvailable();
	}
	
	public void refreshDAO() {
		if (!isAvailable())
			contactDAO = new ContactDAO();
	}
	
	public boolean addNewContact(String firstName, String lastName, Part photoPart) {
		if (photoPart == null)
			return addNewContact(firstName, lastName);
		
		try {
			InputStream photoInputStream = photoPart.getInputStream();			
			byte[] buffer = new byte[photoInputStream.available()];
			photoInputStream.read(buffer);
			
			String photoName = photoPart.getSubmittedFileName();
			String photoPath = photosDirectory + "\\" + photoName;
			System.out.println("PhotoPath: " + (photoPath != null ? photoPath : "null"));
			File savePhoto = new File(photoPath);
			FileOutputStream photoOutputStream = new FileOutputStream(savePhoto);
			photoOutputStream.write(buffer);
			
			photoInputStream.close();
			photoOutputStream.close();
			
			return contactDAO.insert(new Contact(firstName, lastName, photoPath));
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addNewContact(String firstName, String lastName) {
		return contactDAO.insert(new Contact(firstName, lastName, null));
	}
}

package w1e7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ContactDAO {
	public static final String dbConnectionString = "jdbc:sqlserver://localhost:1433;databaseName=WWWJavaW1E7DB;integratedSecurity=true";
	public static final String selectAllQuery = "SELECT * FROM Contact";
	public static final String insertQuery = "INSERT INTO Contact (FirstName, LastName, PhotoPath) values (?, ?, ?)";
	
	private Connection connection;
	private boolean available;
	
	public ContactDAO () {
		try {
			DriverManager.registerDriver(new SQLServerDriver());
			connection = DriverManager.getConnection(dbConnectionString);
			available = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contact> selectAll() {
		List<Contact> contacts = new ArrayList<Contact>();
				
		try {
			PreparedStatement statement = connection.prepareStatement(selectAllQuery);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				int id = result.getInt(0);
				String firstName = result.getString(1);
				String lastName = result.getString(2);
				String photoPath = result.getString(3);
				contacts.add(new Contact(id, firstName, lastName, photoPath));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			return null;
		}
		
		return contacts;
	}
	
	public boolean insert(Contact contact) {
		if (contact == null)
			return false;
		
		try {
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setString(3, contact.getPhotoPath());
			
			int row = statement.executeUpdate();
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isAvailable() {
		return available;
	}
}

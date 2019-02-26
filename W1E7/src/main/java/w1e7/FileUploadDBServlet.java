package w1e7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177215) // 16mb
public class FileUploadDBServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ContactController contactController = null;
	
	@Override
	public void init() throws ServletException {
		contactController = new ContactController();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		Part photoPart = request.getPart("Photo");

		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
		    String param = params.nextElement();
		    System.out.println("Param: " + param);
		}

		PrintWriter out = response.getWriter();
		response.setContentType("text");
		
		if (contactController != null && contactController.isAvailable()) {
			contactController.refreshDAO();
			boolean result = contactController.addNewContact(firstName, lastName, photoPart);
			out.println(result ? "The photo has been uploaded successfully!" : "Failed to upload photo!!!");
		}
		else {
			out.println("Failed to upload photo!!!");
		}	
	}
}

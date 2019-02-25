package w1e4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("FirstName") + request.getParameter("LastName");
		String email = request.getParameter("Email");
		String facebook = request.getParameter("Facebook");
		String shortbio = request.getParameter("ShortBio");
		String html = "<br>" + "<html>"
		+ "<head>" + "<title>Result Page</title>"
		+ "</head>" + "<body>"
		+ "First Name: "+ name +"<br>"
		+ "Email: "+ email +"<br> Facebook URL: "+ facebook +"<br>"
		+ "Short Bio: "+ shortbio +"<br>"
		+ "</body>" + "</html>";
		
		out.println(html);
	}
}

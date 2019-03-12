package w3e1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationForm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String firstName = req.getParameter("first-name");
		String lastName = req.getParameter("last-name");
		String birthdayString = req.getParameter("birthday");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String[] hobbies = req.getParameterValues("hobbies");
		
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-mm-dd").parse(birthdayString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student = new Student(firstName, lastName, email, gender, hobbies, birthday);
		
		req.setAttribute("student", student);
		req.getRequestDispatcher("result-form.jsp").forward(req, resp);
	}
}

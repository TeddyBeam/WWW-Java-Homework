<%@ page import="w3e1.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>Result submit</title>
</head>
<body> 
	<%
		Student student = (Student)request.getAttribute("student");
	
		String hobbies = "";
		for(String hobby: student.getHobbies()) {
			if (hobby != null && !hobby.equals(""))
			hobbies += "[" + hobby + "]";
		}
		
		out.println(
			"First name:" + student.getFirstName()
			+ "<br/> Last name: " + student.getLastName() 
			+ "<br/> Email : " + student.getEmail()
			+ "<br/> Gender: " + student.getGender()
			+ "<br/> Hobbies: " + hobbies
			+ "<br/> Birthday: " + student.getBirthday()
		);
	%>
</body>
</html>
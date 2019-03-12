<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Bài 3 chương 3</title>
</head>

<body>
	<c:set var="mangonngu" value="${param.radio_mangonngu}"/>
	<c:if test="${not empty mangonngu}">
		<fmt:setLocale value="${mangonngu}" scope="session"/>
	</c:if>

	<fmt:setBundle basename="resource" scope="session"/>
	<form action="index.jsp" method="post">
		<br>
		<fmt:message key="languagemessase"/>
		<input type="radio" name="radio_mangonngu" value="vi_VN"
			<c:if test="${mangonngu == 'vn-VN'}">checked</c:if>/>
		<fmt:message key='vn' />
		<input type="radio" name="radio_mangonngu" value="en_US"
			<c:if test="${mangonngu == 'en-US'}">checked</c:if>/>
		<fmt:message key='en' />
		<input type="submit" name="submit"
			value="<fmt:message key='choosebutton'/>"/>
		<br>
		<hr/>

		<table border="1">
			<tr>
				<td><fmt:message key="username" /></td>
				<td><input type="text" name="txtusername" value=""></td>
			</tr>
			<tr>
				<td><fmt:message key="pass" /></td>
				<td><input type="text" name="txtpassword" value=""><br></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="<fmt:message key='login'/>"></td>
			</tr>
		</table>
	</form>
</body>
</html>
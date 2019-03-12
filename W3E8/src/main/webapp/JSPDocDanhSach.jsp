<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Danh sách</title>
</head>
<body>
	<c:forEach items="${ds }" var="item">
		<form method="post" action="DanhSachDienThoaiServlet">
			<tr>
				<td><c:out value="${item.tenNCC }"></c:out></td>
				<td><i>Danh Sach Dien Thoai SX</i>
					<ul>
						<c:forEach items="${item.ds }" var="item2">
							<li><c:out value="${item2.tenDT }"></c:out></li>
						</c:forEach>
					</ul></td>
			</tr>
		</form>
	</c:forEach>
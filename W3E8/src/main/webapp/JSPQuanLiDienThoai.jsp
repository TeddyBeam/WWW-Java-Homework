<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ include file="JSPDataController.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách điện thoại nhà cung cấp</title>
<style>
* {
	padding: 0;
	margin: 0;
}

header {
	background-image: url("Images/203Logo.png");
	height: auto;
	border: 1px solid back;
}

footer {
	height: 50px;
	text-align: center;
	border: 1px solid back;
}

#main {
	height: auto;
}

#menu {
	height: 50px;
	border: 1px solid back;
	text-align: center;
}

ul {
	list-style: none;
}
</style>
</head>
<body>
	<header> </header>
	<div id="menu">
		<a href="DanhSachDienThoaiNCC.jsp">Danh sách sản phẩm</a> | <a
			href="DienThoaiForm.jsp">Thêm mới sản phẩm</a> | <a
			href="TrangQuanLy.jsp">Chức năng quản lý</a>
	</div>
	<div id="main">
		<form method="POST">
			<h1>Danh sách điện thoại</h1>
			<div>
				<table border=1 style="border-collapse: collapse;">
					<tr>
						<th>Tên nhà cung cấp</th>
						<th>Mã sản phẩm:</th>
						<th>Tên sản phẩm:</th>
						<th>Năm sản xuất</th>
						<th style="width: 300px;">Cấu hình</th>
					</tr>
					<c:forEach var="ncc" items="${dsncc.rows}">
						<tr>
							<td><c:out value="${ncc.TENNHACC}"></c:out></td>
							<sql:query var="dtncc" dataSource="${snapshot}"> SELECT DIENTHOAI.MADT, DIENTHOAI.TENDT, DIENTHOAI.NAMSANXUAT,
DIENTHOAI.CAUHINH, DIENTHOAI.MANCC, NHACUNGCAP.TENNHACC FROM DIENTHOAI INNER JOIN
NHACUNGCAP ON DIENTHOAI.MANCC = NHACUNGCAP.MANCC WHERE NHACUNGCAP.MANCC=?
<sql:param value="${ncc.MANCC}"></sql:param>
							</sql:query>
							<td>
								<ul>
									<c:forEach var="dt" items="${dtncc.rows}">
										<li><c:out value="${dt.MADT}"></c:out> <input
											type="hidden" value="${dt.MADT}" name="lblMadt"></li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach var="dt" items="${dtncc.rows }">
										<li><c:out value="${dt.TENDT}"></c:out></li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach var="dt" items="${dtncc.rows }">
										<li><c:out value="${dt.NAMSANXUAT}"></c:out></li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach var="dt" items="${dtncc.rows }">
										<li><c:out value="${dt.CAUHINH}"></c:out></li>
									</c:forEach>
								</ul>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<div>
			<c:out value="${ncc.TENNHACC}"></c:out>
			<select>
				<c:forEach var="ncc" items="${dsncc.rows}">
					<option value="${ncc.MANCC}"><c:out
							value="${ncc.TENNHACC}"></c:out></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<footer> Họ tên SV – Lớp – Phòng máy </footer>
</body>
</html>
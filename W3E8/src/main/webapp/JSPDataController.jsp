<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<sql:setDataSource var="snapshot"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost:1433;databaseName=W3E8Database"
		user="sa" password="lydongcanh" />
	<sql:query var="dsncc" dataSource="${snapshot }">
select * from NHACUNGCAP;
</sql:query>
	<c:if test="${pageContext.request.method=='POST'}">
		<c:if test="${param.action=='Them'}">
			<%
				int nam = Integer.parseInt(request.getParameter("txtNamSanXuat"));
			%>
			<c:catch var="exception">
				<sql:update var="result" dataSource="${snapshot }">
insert into DIENTHOAI(MADT,TENDT,CAUHINH,MANCC,NAMSANXUAT) values
(?,?,?,?,<%=nam%>)
<sql:param value="${param.txtMaDT}"></sql:param>
					<sql:param value="${param.txtTenDT}"></sql:param>
					<sql:param value="${param.txtCauHinh}"></sql:param>
					<sql:param value="${param.sltNCC}"></sql:param>
				</sql:update>
				<c:if test="${result>=1 }">
					<font color="green"> Thêm thành công!</font>
				</c:if>
			</c:catch>
			<c:if test="${exception!=null }">
				<font color="red">Lỗi</font>
			</c:if>
		</c:if>
	</c:if>
</body>
</html>
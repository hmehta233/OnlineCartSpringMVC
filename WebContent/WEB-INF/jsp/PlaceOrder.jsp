<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Your</th>
			<th>Order</th>
			<th>Has</th>
			<th>been</th>
			<th>placed</th>
		</tr>
		<c:forEach var="selprd" items="${sessionScope.shoppnbag.entrySet() }">
			<tr>
				<td><c:out value="${selprd.getKey() }" /></td>
				<td><c:out value="${selprd.getValue() }" /></td>
				<td><c:out value="${applicationScope['products'].get(selprd)}" /></td>

				<td>${ prod.get( selprd.getKey()) }</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total amount</td>
			<td><c:out value="${sessionScope.totalamount }" /></td>
			<td></td>

		</tr>
	</table>
	<c:if test="${sessionScope.username==null }">
		<c:redirect url="logout" />
	</c:if>
</body>
</html>
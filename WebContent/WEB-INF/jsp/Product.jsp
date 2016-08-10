<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${sessionScope.username!=null }">
		<form:form method="POST" commandName="Products" action="show.detail">
Hi ${sessionScope.username},

<form:errors path="Allproducts" />

Please Select a product : <c:forEach var="products"
				items="${applicationScope['products']}">
				<form:checkbox path="Allproducts" value="${products.getKey()}" />
				<c:out value="${products.getKey() }"></c:out>
			</c:forEach>
			<input type="submit" value="Show Details" />
			<br>
			<a href="logout">logout</a>
		</form:form>
	</c:if>

	<c:if test="${sessionScope.username==null }">
		<c:redirect url="logout" />
	</c:if>
</body>

</html>
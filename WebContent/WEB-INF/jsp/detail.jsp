<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.username!=null }">
<form:form method="POST" commandName="Details" action="addcart">
Hi ${sessionScope.username},

Please Select a product to place the order:

<form:errors path="addtocartproducts"/>

<table>
<tr>
<th>SELECT</th>
<th>PRODUCT</th>
<th>DETAILS</th>
</tr>
<c:forEach var="selprd" items="${sessionScope.selectedProducts }">
<tr>
<td><form:checkbox path="addtocartproducts" value="${selprd }"/></td>
<td><c:out value="${selprd }"/></td>
<td> Price : Rs.  <c:out value="${applicationScope['products'].get(selprd)}"/></td>
</tr>
</c:forEach>
</table>
<input type="submit" value="AddToCart"/><a href="logout">logout</a><br/><a href="product">add more product</a>
</form:form>
</c:if>

<c:if test="${sessionScope.username==null }">
		<c:redirect url="logout" />
	</c:if>

</body>
</html>
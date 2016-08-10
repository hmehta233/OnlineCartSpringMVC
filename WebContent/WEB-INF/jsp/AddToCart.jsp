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
<form:form method="POST" commandName="Cart" action="delcart">
Hi ${sessionScope.username},

Please Select a product to add to cart :

<form:errors path="DELtocartproducts"/>

<table>
<tr>
<th>SELECT</th>
<th>PRODUCT</th>
<th>QUANTITY</th>
</tr>
<c:forEach var="selprd" items="${sessionScope.shoppnbag.entrySet() }">
<tr>
<td><form:checkbox path="DELtocartproducts" value="${selprd.getKey() }"/></td>
<td><c:out value="${selprd.getKey() }"/></td>
<td><c:out value="${selprd.getValue() }"/></td>
<%-- <td>${ prod.get( selprd.getKey()) }</td> --%>
</tr>
</c:forEach>
</table>
<input type="submit" value="delete products"/><br/><br/><a href="logout">logout</a><br/><br/><a href="product">add more products</a><br/><br/>
<a href="Placeorder">PlaceOrder</a><br/>
</form:form>
</c:if>

<c:if test="${sessionScope.username==null }">
		<c:redirect url="logout" />
	</c:if>

</body>
</html>
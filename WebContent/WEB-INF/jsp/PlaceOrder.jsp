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
<form:errors path="Products"/>
<%int amount=0; %>
<table>
<c:forEach var="selprd" items="${sessionScope.shoppnbag.entrySet() }">
<tr>
<td><c:out value="${selprd.getKey() }"/></td>
<td><c:out value="${selprd.getValue() }"/></td>
<td><c:out value="${applicationScope['products'].get(selprd)}"/></td>
<%-- <% amount=amount+Integer.parseInt(selprd.getValue())*Integer.parseInt(getServletContext().getAttribute("products").get(selprd)) ; %> --%>
<%-- <td>${ prod.get( selprd.getKey()) }</td> --%>
</tr>
</c:forEach>
 <tr>
 <td> Total amount </td>
 <td> </td>
 <td></td>
 
 </tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
<a href="/">Home</a>
<h1>${language.name}</h1>
<p>${language.creator}</p>
<p>${language.currentVersion}</p>
<a href="/language/edit/${language.id}">Edit</a>
<form action="/language/delete/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

</body>
</html>
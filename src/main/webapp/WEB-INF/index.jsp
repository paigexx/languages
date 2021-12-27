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
<title>Home</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
<h1>Languages</h1>
<!-- display all langugaes  -->
<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Current Version</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${languages}" var="language">
			<tr>
				<td><a href="/language/${language.id}">${language.name}</a></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.currentVersion}"/></td>
				<td><button class="btn btn-light"><a href="/language/edit/${language.id}">Edit</a></button>
					<!-- REVIEW THIS? -->
					<form action="/language/delete/${language.id}" method="post">
    					<input type="hidden" name="_method" value="delete">
    					<input class="btn btn-danger" type="submit" value="Delete">
					</form></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- form -->
<br/>
<h3>Add a Language</h3>
<form:form action="" method="post" modelAttribute="language">
	<p>
		<form:label path="name">Language Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</p>
	<p>
		<form:label path="creator">Creator</form:label>
		<form:errors path="creator"/>
		<form:input path="creator"/>
	</p>
	<p>
		<form:label path="currentVersion">Current Version</form:label>
		<form:errors path="currentVersion"/>
		<form:input path="currentVersion"/>
	</p>
	 <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
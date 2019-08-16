<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/languages" class="float-right">Home</a>
		<h1>
			<c:out value="${language.name}" />
		</h1>
		<p>
			Creator:
			<c:out value="${language.creator}" />
		</p>
		<p>
			Version:
			<c:out value="${language.version}" />
		</p>

		<a href="/languages/${language.id}/edit" class="btn btn-info mb-2">Update</a>
	
		<form:form action="/languages/${language.id}/delete" method="post">
			<input type="hidden" name="_method" value="delete" /> <input
				type="submit" class="btn btn-danger" value="Delete">
		</form:form>

	</div>
</body>
</html>
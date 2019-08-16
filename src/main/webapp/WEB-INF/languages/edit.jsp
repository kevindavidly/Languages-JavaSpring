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
<div class="container">
		<a href="/languages" class="float-right">Home</a>
		<h1>Edit Language</h1>
		<form:form action="/languages/${language.id}" method="post"
			modelAttribute="language">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input class="form-control mb-2 col-6" path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="Creator" />
				<form:input class="form-control mb-2 col-6" path="Creator" />
			</p>
			<p>
				<form:label path="version">Version</form:label>
				<form:errors path="version" />
				<form:input class="form-control mb-2 col-6" path="version" />
			</p>

			<input type="submit" value="Submit" class="btn btn-warning" />
		</form:form>

		<form:form action="/languages/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete" /> 
			<input type="submit" class="btn btn-danger mt-2" value="Delete" />

		</form:form>

	</div>
</body>
</html>
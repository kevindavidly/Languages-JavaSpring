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
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
					<tr>
						<td><a href="/languages/${language.id}"><c:out
									value="${language.name}" /></a></td>
						<td><c:out value="${language.creator}" /></td>
						<td><c:out value="${language.version}" /></td>
						<td>
							<a href="/languages/${language.id}/edit" class="btn btn-info">Update</a> |
							
							<form:form class="d-inline" action="/languages/${language.id}" method="post">
								<input type="hidden" name="_method" value="delete" />
								<input type="submit" class="btn btn-danger" value="Delete" />
							</form:form>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<h1>New Language</h1>
		<form:form action="" method="post" modelAttribute="newLanguage">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input class="form-control mb-2 col-6" path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator" />
				<form:input class="form-control mb-2 col-6" path="creator" />
			</p>
			<p>
				<form:label path="version">Version</form:label>
				<form:errors path="version" />
				<form:input class="form-control mb-2 col-6" path="version" />
			</p>

			<input type="submit" value="Submit" class="btn btn-info" />
		</form:form>

	</div>

</body>
</html>
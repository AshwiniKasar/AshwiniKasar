<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>movie-list-admin-page</title>
<script src="js\script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images\logo.png"> <a href="ShowMovieListAdmin">Movies</a>
	</div>


	<h1>Movies</h1>
	<table>
		<tr>
			<th>Title</th>
			<th>Box-office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>

		</tr>
		<c:forEach items="${movieList}" var="movieItem">
			<tr>
				<td>${movieItem.title }</td>
				<td class="currency">$<fmt:formatNumber
						pattern="#,##,##,##,###" value="${movieItem.gross}" /></td>
				<td><c:if test="${movieItem.active}">Yes</c:if> <c:if
						test="${!movieItem.active }">No</c:if></td>
				<td><fmt:formatDate value="${movieItem. dateOfLaunch}"
						pattern="dd/MM/yyyy" /></td>
				<td>${movieItem.genre }</td>
				<td><c:if test="${movieItem.teaser}">Yes</c:if> <c:if
						test="${!movieItem.teaser}">No</c:if></td>
				<td><a href="ShowEditMovieList?id=${movieItem.id }">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>

</body>
</html>
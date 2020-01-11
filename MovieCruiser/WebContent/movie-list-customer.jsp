<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>cart-empty-page</title>
<script src="js\script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images\logo.png"> <a href="ShowMovieListCustomer">Movies</a>
		<a href="ShowFavorite">Favorites</a>

	</div>

	<div class="message">
		<h1>Movies</h1>
	</div>
	<c:if test="${addFavoritesStatus }">
		<div class="success message">Item Added to Favorites
			Successfully</div>
	</c:if>

	<table>
		<tr>
			<th>Title</th>
			<th>Box-office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>

		</tr>
		<c:forEach items="${filteredMovies }" var="movieItem">
			<tr>
				<td>${movieItem.title}</td>
				<td class="currency"><fmt:formatNumber
						value="${movieItem.gross }" pattern="$#,##,##,##,###"></fmt:formatNumber></td>
				<td>${movieItem.genre}</td>
				<td><c:if test="${movieItem.teaser}">Yes</c:if> <c:if
						test="${!movieItem.teaser}">No</c:if></td>
				<td><a href="AddToFavorite?id=${ movieItem.id}">Add to
						Favorites</a></td>
			</tr>
		</c:forEach>

	</table>

	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>
</body>
</html>
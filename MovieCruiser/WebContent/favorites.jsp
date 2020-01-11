<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<img src="images/logo.png"> <a href="ShowMovieListCustomer">Movies</a>
		<a href="ShowFavorite">Favorites</a>

	</div>

	<div class="message">
		<h1>Favorites</h1>
		<c:if test="${message }">
			<div class="success-message">Movie Removed Successfully</div>
		</c:if>
	</div>

	<table>
		<tr>
			<th>Title</th>
			<th class="currency">Box-office</th>
			<th>Genre</th>

		</tr>
		<c:forEach items="${favorites.movieList }" var="movieItem">

			<tr>
				<td>${movieItem.title }</td>
				<td class="currency"><fmt:formatNumber
						value="${movieItem.gross }" pattern="$#,##,##,##,###"></fmt:formatNumber></td>
				<td>${movieItem.genre }</td>
				<td><a href="RemoveFavorite?id=${movieItem.id }">Delete</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td><b>No.of Favorites :</b></td>
			<td><b>${favoritesCount }</b></td>
		</tr>

	</table>
	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>
</body>
</html>
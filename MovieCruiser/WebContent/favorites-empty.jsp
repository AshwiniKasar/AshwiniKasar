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
		<h2>Favorites</h2>
	</div>

	<h3>
		No item in Favorites.use "Add to favorites" option in<a
			href="ShowMovieListCustomer">Movie List</a>
	</h3>

	<div class="footer">
		<h3>Copyright@2019</h3>
	</div>
</body>
</html>
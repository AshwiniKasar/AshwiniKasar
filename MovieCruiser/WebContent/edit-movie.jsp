<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>edit-movie-page</title>
<script src="js\script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/logo.png"> <a href="ShowMovieListAdmin">Movies</a>

	</div>

	<div>
		<h1>Edit Movie</h1>
	</div>

	<div class="body-content-color">
		<form action="EditMovieList" name="editmovieitem"
			onsubmit="return validateform()" method="POST">

			<div class="form-field-spacing">
				<b> <label for="title">Name</label></b> <input type="text"
					class="text-box text-box-title" name="title" id="name"
					value="${movies.title }">
			</div>

			<div class="form-field-spacing">
				<b><label for="gross">Gross($)</label></b> <br> <input
					type="text" class="text-box" name="gross" id="gross"
					value=<fmt:formatNumber 
						pattern="#######" value="${movies.gross}" />>
			</div>


			<div class="form-field-spacing">
				<b> <label for="active">Active</label></b> <input type="radio"
					name="active" value="yes"
					<c:if test="${movies.active}">checked</c:if>>Yes <input
					type="radio" name="active" value="no"
					<c:if test="${!movies.active}">checked</c:if>>No
			</div>

			<div class="form-field-spacing">
				<b> <label for="dateofLounch">Date launch</label></b> <br> <input
					type="text" name="dateOfLaunch" id="dateofLounch"
					value=<fmt:formatDate value="${movies.dateOfLaunch}"
						pattern="dd/MM/yyyy"/>>

			</div>

			<div class=" form-field-spacing">
				<b> <label for="genre">Genre</label></b> <br> <select
					name="genre" class="dropdown">
					<option value="${movies.genre }">${movies.genre }</option>
					<option value="Science-Fiction">Science Fiction</option>
					<option value="Superhero">SuperHero</option>
					<option value="Romance">Romance</option>
					<option value="Comedy">Comedy</option>
					<option value="Advanture">Adventure</option>
					<option value="Thriller">Thriller</option>
				</select>
			</div>

			<div class="form-field-spacing">
				<b> <label for="teaser">Has Teaser</label></b> <input
					type="checkbox" name="teaser" id=""
					<c:if test="${movies.teaser}">checked</c:if>>
			</div>

			<br> <input type="hidden" name="id" value="${movies.id }">

			<div class="form-field-spacing">

				<input type="submit" class="button success-button" value="save">
			</div>

			<div class="footer">
				<h3>copyright@2019</h3>
			</div>

		</form>
	</div>
</body>
</html>
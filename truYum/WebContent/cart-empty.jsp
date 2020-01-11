<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>cart-empty-page</title>
<script src="js\script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images\truyum-logo-light.png"> <a
			href="ShowMenuItemListCustomer">Menu</a> <a href="ShowCart">Cart</a>
	</div>
	<h1>Cart</h1>
	<div class="message">
		<h3>
			No items in cart.Use'Add to Cart' option in <a
				href="ShowMenuItemListCustomer">Menu Item List</a>
		</h3>
	</div>
	<div class="footer">
		<h3>copyright@2019</h3>
	</div>
</body>
</html>
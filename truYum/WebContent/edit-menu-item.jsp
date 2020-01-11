<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>edit-menu-item-page</title>
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div>
		<h1>Edit Menu Item</h1>
	</div>
	<div class="body-content-color">
		<form action="EditMenuItem" name="menuItemForm"
			onsubmit="return validateMenuItemForm()" method="POST">

			<div class="form-field-spacing">
				<b> <label for="title">Name</label></b> <input type="text"
					class="text-box" name="title" value="${menuItem.name }">
			</div>

			<div class="form-field-spacing">
				<b><label for="price">price(Rs.)</label></b> <input type="text"
					class="text-box" name="price" id = "price"
					value=<fmt:formatNumber type="number"
						pattern="###.###" value="${menuItem.price}" />>
			</div>
			<div class="form-field-spacing">
				<b> <label for="dateofLounch">Date launch</label></b> <input
					type="text" name="dateOfLaunch" 
					value=<fmt:formatDate value="${menuItem.dateOfLaunch}"
						pattern="dd/MM/yyyy"/>>
			</div>
			<div class="form-field-spacing">
				<c:choose>
					<c:when test="${menuItem.active}">
						<label for="active">Active</label>
						<input class="radio " type="radio" name="active" value="yes"
							checked="checked">Yes 
				<input class="radio " type="radio" name="active" value="no">No
				</c:when>
					<c:otherwise>
						<label for="active">Active</label>
						<input class="radio " type="radio" name="active" value="yes">Yes 
				<input class="radio " type="radio" name="active" value="no"
							checked="checked">No				
				</c:otherwise>
				</c:choose>
			</div>
			<div class=" form-field-spacing">
				<b> <label for="category">category</label></b> <select
					name="category" class="dropdown">
					<option value="${ menuItem.category}">${ menuItem.category}</option>
					<option value="main course">main course</option>
					<option value="starters">starters</option>
					<option value="Desserts">Desserts</option>
					<option value="Drinks">Drinks</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<b> <label for="freeDelivery">free Delivery</label></b> <input
					type="checkbox" name="freeDelivery"
					<c:if test="${menuItem.freeDelivery}">checked</c:if>>
			</div>
			<input type="hidden" name="id" value="${menuItem.id }">
			<div class="form-field-spacing">
				<input type="submit" class="button success-button" value="save"><a
					href="EditMenuItem"></a>
			</div>
			<div class="footer">
				<b>copyright@2019</b>
			</div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>menu-item-list-admin</title>
<script src="js\script.js"></script>

</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images\truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="message">
		<h1>Menu Item</h1>
	</div>
	<table id="table_id">
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td class="currency">Rs.<fmt:formatNumber type="number"
						pattern="#,##,##,###.00" value="${menuItem.price}" /></td>
				<td><c:if test="${menuItem.active}">Yes</c:if> <c:if
						test="${!menuItem.active }">No</c:if></td>
				<td><fmt:formatDate value="${menuItem.dateOfLaunch}"
						pattern="dd/MM/yyyy" /></td>
				<td>${menuItem.category}</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td><a href="ShowEditMenuItem?id=${menuItem.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<b>copyright@2019</b>
	</div>
</body>
</html>
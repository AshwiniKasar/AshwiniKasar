<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>menu-item-list-customer</title>
<script src="js\script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images\truyum-logo-light.png"> <a
			href="ShowMenuItemListCustomer">Menu</a> <a href="ShowCart">Cart</a>
	</div>
	<div class="page-title">MenuItems</div>
	<c:if test="${addCartStatus}">
		<div class="success-message">Item Added To Cart Successfully</div>
	</c:if>
	<table id="table_id">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${menuItemList }" var="menuItem">
			<tr>
				<td>${menuItem.name }</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> 
				<c:if test="${!menuItem.freeDelivery}">No</c:if></td>
				<td class="currency"><fmt:formatNumber type="number"
						pattern="#,##,##,###.00" value="${menuItem.price}" /></td>
				<td>${menuItem.category}</td>
				<td><a href="AddToCart?id=${menuItem.id}">Add to Cart</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
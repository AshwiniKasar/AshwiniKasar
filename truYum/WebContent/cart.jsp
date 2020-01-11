<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>cart-page</title>
<script src="js\script.js"></script>
</head>
<body>
<body onload="addColumn()">
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListCustomer">Menu</a> <a href="ShowCart">Cart</a>
	</div>
	<div class="message">
		<h1>Menu Item</h1>
		<c:if test="${message }">
			<div class="success-message">Item Removed from cart
				Successfully</div>
		</c:if>
	</div>
	<table id="table_id">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th class="currency">Price</th>
			<th>category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name }</td>
				<td><c:if test="${menuItem.freeDelivery }">Yes</c:if> <c:if
						test="${!menuItem.freeDelivery }">No</c:if></td>
				<td class="currency">Rs.<fmt:formatNumber
						value="${menuItem.price }" pattern="######.00"></fmt:formatNumber>
				</td>
				<td>${menuItem.category }</td>
				<td><a href="RemoveCart?id=${menuItem.id }">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td class="total">total</td>
			<td class="total">Rs.<fmt:formatNumber value="${cart.total }"
					pattern="######.00"></fmt:formatNumber>
			</td>
		</tr>
	</table>
	<div class="footer">
		<h3>copyright@2019</h3>
	</div>
</body>
</html>
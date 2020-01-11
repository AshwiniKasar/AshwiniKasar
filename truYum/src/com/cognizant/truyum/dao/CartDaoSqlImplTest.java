package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {

	public static void addCartItem() {

		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.addCartItem(2L, 1L);
		System.out.println("Item added to cart Successfully");
		System.out.println("\n");
	}

	public static void getAllCartItems() throws CartEmptyException {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		long userid = 2L;
		Cart obj = cartDaoSqlImpl.getAllCartItems(userid);
		System.out.println(obj.getMenuItemList());
		System.out.println("------------");
		System.out.print("Total Price :" + obj.getTotal());
		System.out.println("\n");

	}

	public static void removeCartItem() {
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		cartDaoSqlImpl.removeCartItem(2L, 4L);

	}

	public static void main(String[] args) throws CartEmptyException {
		addCartItem();
		getAllCartItems();
		removeCartItem();
	}
}

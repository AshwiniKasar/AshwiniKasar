package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {

		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2);
		cartDao.addCartItem(2, 1);
		cartDao.addCartItem(1, 5);
		cartDao.addCartItem(2, 3);

		Cart cart = cartDao.getAllCartItems(1);// first user order 2 item i.e 2 and 5 number
												// order
		System.out.print("User Added cart list for Checkout\n");
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}

		Cart cart1 = cartDao.getAllCartItems(2);
		System.out.print("User Added cart list for Checkout\n");
		for (MenuItem menuItem : cart1.getMenuItemList()) {
			System.out.println(menuItem);
		}

	}

	public static void testremoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			cartDao.removeCartItem(1, 2); // first user order 2 menulist no order which is remove
			cartDao.removeCartItem(2, 1); // second user order 1 menulist no order
			cartDao.removeCartItem(1, 5); // first again order 5 menulist no order
			// cartDao.removeCartItem(2, 3); // then in output is show that which item u r
			// not remove i.e 3
			Cart cart = cartDao.getAllCartItems(2);
			System.out.println("Item List for Customer after remove\n");
			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e);
		}

	}

	public static void testGetAllCartItem() {

	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testremoveCartItem();
	}

}

package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.util.DateUtil;
import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() {
		System.out.println("Menu item list Admin");
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
			
		}
	}

	public static void testGetMenuItemListCustomer() {
		System.out.println("Menu item list Customer");
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListCustomer();
		for (MenuItem menuItem : menuItemList) {
			System.out.println(menuItem);
		}
	}

	public static void testModifyMenuItem() {
		
		MenuItem itemFive = new MenuItem(5, "Chocolate Browine", 80.00f, true,
				new DateUtil().convertToDate("13/12/2020"), "Desserts", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(itemFive);
		System.out.println("**Modified List**");
		testGetMenuItemListAdmin();
		MenuItem modified_Item = menuItemDao.getMenuItem(itemFive.getId());
		System.out.println("\nModified Item Detail =" + modified_Item);

	}



	public static void main(String[] args) {
		

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();

	}

}

package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	// private void Super() {
	// TODO Auto-generated method stub

	public MenuItemDaoCollectionImpl() {
		super();
		// TODO Auto-generated constructor stub
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			MenuItem itemOne = new MenuItem(1, "Sandwich", 99.00f, true, new DateUtil().convertToDate("15/03/2017"),
					"main Course", true);
			MenuItem itemTwo = new MenuItem(2, "Burger", 129.00f, true, new DateUtil().convertToDate("23/12/2017"),
					"main Course", false);
			MenuItem itemThree = new MenuItem(3, "Pizza", 149.00f, true, new DateUtil().convertToDate("11/12/2019"),
					"main Course", false);
			MenuItem itemFour = new MenuItem(4, "French Fries", 57.00f, false,
					new DateUtil().convertToDate("12/12/2019"), "Starters", true);
			MenuItem itemFive = new MenuItem(5, "Chocolate Browine", 32.00f, true,
					new DateUtil().convertToDate("13/12/2020"), "Desserts", true);

			menuItemList.add(itemOne);
			menuItemList.add(itemTwo);
			menuItemList.add(itemThree);
			menuItemList.add(itemFour);
			menuItemList.add(itemFive);
		}

	}

	// }
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> filteredMenuItem = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getDateOfLaunch().after(new Date())) {
				if (menuItem.isActive()) {
					filteredMenuItem.add(menuItem);
				}
			}
		}
		return filteredMenuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);
			}
		}

	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

}

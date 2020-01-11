package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		DecimalFormat df = new DecimalFormat("####");
		df = new DecimalFormat("#.00");
		System.out.format("%5s%25s%15s%20s%25s%25s%20s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");

		for (MenuItem menuItem : menuItemList) {
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			String price = df.format(menuItem.getPrice());
			System.out.format("%5d%25s%15s%20s%25s%25s%15s\n", menuItem.getId(), menuItem.getName(), price,
					menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());

		}

	}

	public static void testGetMenuItemListCustomer() {
		List<MenuItem> menuItemList = new MenuItemDaoCollectionImpl().getMenuItemListCustomer();
		System.out.println("\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		DecimalFormat df = new DecimalFormat("####");
		df = new DecimalFormat("#.00");
		System.out.format("%5s%25s%15s%20s%25s%25s%20s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");

		for (MenuItem menuItem : menuItemList) {
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			String price = df.format(menuItem.getPrice());
			System.out.format("%5d%25s%15s%20s%25s%25s%15s\n", menuItem.getId(), menuItem.getName(), price,
					menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());

		}

	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(1, "Cutlet", 120.0f, true, new DateUtil().convertToDate("12/12/2029"),
				"Starter", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);

	}

	public static void testGetMenuItem() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		DecimalFormat df = new DecimalFormat("####");
		df = new DecimalFormat("#.00");
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		long menuItemId = 2;
		MenuItem menuItem = menuItemDaoSqlImpl.getMenuItem(menuItemId);
		System.out.format("%5s%25s%15s%20s%25s%25s%20s\n", "ID", "NAME", "PRICE", "ACTIVE", "DATEOFLAUNCH", "CATEGORY",
				"FREEDELIVERY");
		String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
		String price = df.format(menuItem.getPrice());
		System.out.format("%5d%25s%15s%20s%25s%25s%15s\n", menuItem.getId(), menuItem.getName(), price,
				menuItem.isActive(), date, menuItem.getCategory(), menuItem.isFreeDelivery());

	}

	public static void main(String[] args) {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

}

package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public static final String GET_MENU_ITEM_ADMIN = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item";
	public static final String GET_MENU_ITEM_CUSTOMER = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item where me_active = '1'and me_date_of_launch > (SELECT CURRENT_DATE())";
	public static final String GET_MENU_ITEM = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item where me_id = ?";
	public static final String EDIT_MENU_ITEM = "update truyum.menu_item set me_name = ?, me_price = ?, me_active = ?, me_date_of_launch = ?, me_category = ?, me_free_delivery = ? where me_id = ?";

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemListAdmin = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MENU_ITEM_ADMIN);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultset.getInt("me_id"));
				menuItem.setName(resultset.getString("me_name"));
				menuItem.setPrice(resultset.getFloat("me_price"));
				menuItem.setActive(resultset.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menuItem.setCategory(resultset.getNString("me_category"));
				menuItem.setFreeDelivery(resultset.getString("me_free_delivery").equals("1"));
				menuItemListAdmin.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}

		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> filteredMenuItem = new ArrayList<MenuItem>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MENU_ITEM_CUSTOMER);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultset.getInt("me_id"));
				menuItem.setName(resultset.getString("me_name"));
				menuItem.setPrice(resultset.getFloat("me_price"));
				menuItem.setActive(resultset.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menuItem.setCategory(resultset.getNString("me_category"));
				menuItem.setFreeDelivery(resultset.getString("me_free_delivery").equals("1"));
				filteredMenuItem.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}

		return filteredMenuItem;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(EDIT_MENU_ITEM);
			preparedStatement.setString(1, menuItem.getName());
			preparedStatement.setFloat(2, menuItem.getPrice());
			preparedStatement.setBoolean(3, menuItem.isActive());
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			preparedStatement.setString(5, menuItem.getCategory());
			preparedStatement.setBoolean(6, menuItem.isFreeDelivery());
			preparedStatement.setLong(7, menuItem.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}

	}

	@Override
	public MenuItem getMenuItem(Long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		MenuItem menuItem = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MENU_ITEM);
			preparedStatement.setLong(1, menuItemId);
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultset.getInt("me_id"));
				menuItem.setName(resultset.getString("me_name"));
				menuItem.setPrice(resultset.getFloat("me_price"));
				menuItem.setActive(resultset.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menuItem.setCategory(resultset.getNString("me_category"));
				menuItem.setFreeDelivery(resultset.getString("me_free_delivery").equals("1"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return menuItem;

	}

}

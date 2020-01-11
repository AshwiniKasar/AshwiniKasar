package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	public static final String ADD_MENUITEM_TO_CART = "insert into `truyum`.cart (ct_us_id, ct_me_id) values (?,?)";
	public static final String GET_MENU_ITEM = "select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item inner join truyum.cart on ct_me_id = me_id  where ct_us_id = ?";
	public static final String GET_TOTAL = "select SUM(me_price) as Total_Price from truyum.menu_item inner join truyum.cart as Total on ct_me_id = me_id where ct_us_id = ?";
	public static final String REMOVE_ITEM = "delete from truyum.cart where ct_us_id = ? and ct_me_id = ? limit 1";

	@Override
	public void addCartItem(long userid, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			statement.setLong(1, userid);
			statement.setLong(2, menuItemId);
			int noOfRow = statement.executeUpdate();
			System.out.println("no of rows affected :" + noOfRow);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> menuCartItem = new ArrayList<>();
		Cart cart = new Cart();
		Connection connection = ConnectionHandler.getConnection();
		// double SetTotal = 0.0;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultset = null;
		ResultSet resultsetTotal = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MENU_ITEM);
			preparedStatement.setLong(1, userId);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultset.getInt("me_id"));
				menuItem.setName(resultset.getString("me_name"));
				menuItem.setPrice(resultset.getFloat("me_price"));
				menuItem.setActive(resultset.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
				menuItem.setCategory(resultset.getString("me_category"));
				menuItem.setFreeDelivery(resultset.getString("me_free_delivery").equals("1"));
				menuCartItem.add(menuItem);
			}
			cart.setMenuItemList(menuCartItem);
			preparedStatement1 = connection.prepareStatement(GET_TOTAL);
			preparedStatement1.setLong(1, userId);
			resultsetTotal = preparedStatement1.executeQuery();
			if (menuCartItem.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultsetTotal.next()) {
				cart.setTotal(resultsetTotal.getDouble("Total_Price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (preparedStatement1 != null) {
					preparedStatement1.close();
				}
				if (resultset != null) {
					resultset.close();
				}
				if (resultsetTotal != null) {
					resultsetTotal.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}

		return cart;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(REMOVE_ITEM);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			int noOfRow = preparedStatement.executeUpdate();
			System.out.println("no of rows affected :" + noOfRow);
			if (noOfRow <= 0) {
				System.out.println("No rows affected ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}

	}

}

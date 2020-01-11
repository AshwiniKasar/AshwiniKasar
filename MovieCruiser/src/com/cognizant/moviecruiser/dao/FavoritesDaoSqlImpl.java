package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {
	public static final String ADD_MOVIE_TO_FAVORITE = "insert into moviecruiser.favorite(fv_us_id, fv_mo_id)values(?, ?);";
	public static final String GET_MOVIE_LIST = "select  mo_id, mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie inner join favorite as display_movie on mo_id = fv_mo_id where fv_us_id = ?";
	public static final String GET_NO_OF_FAVORITE = "select count(fv_id) as no_of_favorite from favorite where fv_us_id = ? ";
	public static final String REMOVE_ITEM = "delete from moviecruiser.favorite where favorite.fv_us_id = ? and favorite.fv_mo_id = ? limit 1";

	@Override
	public void addFavoriteMovie(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MOVIE_TO_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
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
	public Favorites getAllFavoriteMovie(long userId) throws FavoritesEmptyException {

		ArrayList<Movies> favorites = new ArrayList<>();
		Favorites fav = new Favorites();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet resultset = null;
		ResultSet resultsetTotal = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MOVIE_LIST);
			preparedStatement.setLong(1, userId);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Movies movie = new Movies();
				movie.setId(resultset.getLong("mo_id"));
				movie.setTitle(resultset.getString("mo_title"));
				movie.setGross(resultset.getLong("mo_box_office"));
				movie.setActive(resultset.getString("mo_active").equals("1"));
				movie.setDateOfLaunch(resultset.getDate("mo_date_of_launch"));
				movie.setGenre(resultset.getString("mo_genre"));
				movie.setTeaser(resultset.getString("mo_has_teaser").equals("1"));
				favorites.add(movie);
			}
			fav.setMovieList(favorites);
			preparedStatement2 = connection.prepareStatement(GET_NO_OF_FAVORITE);
			preparedStatement2.setLong(1, userId);
			resultsetTotal = preparedStatement2.executeQuery();
			if (favorites.size() == 0) {
				throw new FavoritesEmptyException();
			}
			while (resultsetTotal.next()) {
				fav.setTotal(resultsetTotal.getInt("no_of_favorite"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null) {
					resultset.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultsetTotal != null) {
					resultsetTotal.close();
				}
				if (preparedStatement2 != null) {
					preparedStatement2.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {

			}
		}

		return fav;
	}

	@Override
	public void removeFavoriteMovie(long userID, long moviesId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(REMOVE_ITEM);
			preparedStatement.setLong(1, userID);
			preparedStatement.setLong(2, moviesId);
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

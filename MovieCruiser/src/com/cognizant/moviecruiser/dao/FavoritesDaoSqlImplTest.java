package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavoriteMovie() {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.addFavoriteMovie(2L, 3L);
		System.out.println("Item added to Favorites Successfully");
		System.out.println("\n");
	}

	public static void testRemoveFavoriteMovie() {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.removeFavoriteMovie(1L, 3L);
		System.out.println("Item Removed to Favorites Successfully");
	}

	public static void testGetAddFavorites() throws FavoritesEmptyException {

		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		long userId = 2L;
		Favorites obj = favoritesDaoSqlImpl.getAllFavoriteMovie(userId);

		System.out.println(obj.getMovieList());
		System.out.println("------------");
		System.out.print("Total no of favorites:" + obj.getnoOfFavorites());
		System.out.println("\n");
	}

	public static void main(String[] args) throws FavoritesEmptyException {

		testAddFavoriteMovie();
		testGetAddFavorites();
		testRemoveFavoriteMovie();

	}

}

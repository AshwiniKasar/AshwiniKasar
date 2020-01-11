package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	public static void testAddFavoriteMovie() throws FavoritesEmptyException {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoriteMovie(1, 2L);
		favoritesDao.addFavoriteMovie(1, 5L);
		favoritesDao.addFavoriteMovie(2, 1L);
		favoritesDao.addFavoriteMovie(2, 3L);

		Favorites favorites = favoritesDao.getAllFavoriteMovie(1);
		List<Movies> movieListItem = favorites.getMovieList();
		System.out.println("User Added Favorites for CheckOut");
		for (Movies movies : movieListItem) {
			System.out.println(movies);
		}
		System.out.println("Total noOfFavorites :" + movieListItem.size());
	}

	public static void testRemoveFavoriteMovie() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Item List for Customer after Remove");
		try {
			favoritesDao.removeFavoriteMovie(1, 2L);
			// favoritesDao.removeFavorites(1, 5L);

			Favorites favorites = favoritesDao.getAllFavoriteMovie(2);
			List<Movies> movieListItem = favorites.getMovieList();
			for (Movies movies : movieListItem) {
				System.out.println(movies);
			}
			System.out.println("Total noOfFavorites :" + movieListItem.size());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testGetAddFavorites() {

	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoriteMovie();
		testRemoveFavoriteMovie();
	}
}

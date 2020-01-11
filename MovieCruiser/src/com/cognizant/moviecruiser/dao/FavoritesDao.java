package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public interface FavoritesDao {

	public void addFavoriteMovie(long userId, long moviesId);

	public Favorites getAllFavoriteMovie(long userId) throws FavoritesEmptyException;

	public void removeFavoriteMovie(long userID, long moviesId);

}

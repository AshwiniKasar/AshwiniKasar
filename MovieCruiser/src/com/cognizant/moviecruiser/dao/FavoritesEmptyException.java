package com.cognizant.moviecruiser.dao;

@SuppressWarnings("serial")
public class FavoritesEmptyException extends Exception {

	public static final long serialversionUID = 1L;

	public FavoritesEmptyException() {
		super("Favorite List is Empty");
	}

}

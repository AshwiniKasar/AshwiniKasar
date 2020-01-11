package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

	private List<Movies> movieList;
	private int noOfFavorites;

	public Favorites() {
		super();
	}

	public Favorites(List<Movies> movieList, int noOfFavorites) {
		super();
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public int getnoOfFavorites() {
		return noOfFavorites;
	}

	public void setTotal(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", noOfFavorites=" + noOfFavorites + "]";
	}
}
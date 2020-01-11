package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMovieItemListAdmin() {
		System.out.println("Item List for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieItemList = moviesDao.getMovieListAdmin();
		for (Movies movieItem : movieItemList) {
			System.out.println(movieItem);
		}
	}

	public static void testGetMovieItemListCustomer() {
		System.out.println("Item List for Customer");
		MoviesDao moviesItemDao = new MoviesDaoCollectionImpl();
		List<Movies> moviesItemList = moviesItemDao.getMovieListCustomer();
		for (Movies movieItem : moviesItemList) {
			System.out.println(movieItem);
		}
	}

	public static void testModifyMovieItem() {
		Movies item = new Movies(5L, "Avengers", 3750760348L, true, new DateUtil().convertToDate("02/11/2022"),
				"Superhero", true);
		MoviesDao movieItemDao = new MoviesDaoCollectionImpl();
		movieItemDao.modifyMovie(item);
		System.out.println("*** Modified Menu Item List***");
		testGetMovieItemListAdmin();
		Movies modified_item = movieItemDao.getMovie(item.getId());
		System.out.println("Modified Item Detail\n" + modified_item);
	}

	public static void main(String[] args) {
		testGetMovieItemListAdmin();
		testGetMovieItemListCustomer();
		testModifyMovieItem();
	}
}

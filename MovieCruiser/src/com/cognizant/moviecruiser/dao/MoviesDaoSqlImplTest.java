package com.cognizant.moviecruiser.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testGetMovieItemListAdmin() {

		List<Movies> movieList = new MoviesDaoCollectionImpl().getMovieListAdmin();
		System.out.println("Movie List Admin\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");

		System.out.format("%5s%25s%15s%20s%25s%25s%20s \n", "ID", "TITLE", "GROSS", "ACTIVE", "DATEOFLAUNCH", "GENRE",
				"TEASER");
		for (Movies movie : movieList) {
			String date = sdf.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch()));
			String gross = df.format(movie.getGross());
			System.out.format("%5d%25s%15s%20s%25s%25s%20s \n", movie.getId(), movie.getTitle(), gross,
					movie.isActive(), date, movie.getGenre(), movie.isTeaser());
		}

	}

	public static void testGetMovieItemListCustomer() {

		List<Movies> movieList = new MoviesDaoCollectionImpl().getMovieListCustomer();
		System.out.println("\n");
		System.out.println("Movie List customer\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%5s%25s%15s%20s%25s%25s%20s \n", "ID", "TITLE", "GROSS", "ACTIVE", "DATEOFLAUNCH", "GENRE",
				"TEASER");
		for (Movies movie : movieList) {
			String date = sdf.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch()));
			String gross = df.format(movie.getGross());
			System.out.format("%5d%25s%15s%20s%25s%25s%20s \n", movie.getId(), movie.getTitle(), gross,
					movie.isActive(), date, movie.getGenre(), movie.isTeaser());
		}

	}

	public static void testModifyMovieItem() {
		Movies movie = new Movies(5L, "Joker", 2222222L, true, new DateUtil().convertToDate("29/12/2026"), "Thriller",
				true);
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();

		moviesDaoSqlImpl.modifyMovie(movie);
		System.out.println("\n");
		System.out.println("Modified Item\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		System.out.format("%5s%25s%15s%20s%25s%25s%20s \n", "ID", "TITLE", "GROSS", "ACTIVE", "DATEOFLAUNCH", "GENRE",
				"TEASER");
		String date = sdf.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch()));
		String gross = df.format(movie.getGross());
		System.out.format("%5d%25s%15s%20s%25s%25s%20s \n", movie.getId(), movie.getTitle(), gross, movie.isActive(),
				date, movie.getGenre(), movie.isTeaser());

	}

	public static void testGetMovieList() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##,##,##,###");
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();
		long movieId = 3;
		Movies movie = moviesDaoSqlImpl.getMovie(movieId);
		System.out.println("\n");
		System.out.println("Display Movie List\n");
		System.out.format("%5s%25s%15s%20s%25s%25s%20s \n", "ID", "TITLE", "GROSS", "ACTIVE", "DATEOFLAUNCH", "GENRE",
				"TEASER");
		String date = sdf.format(DateUtil.convertToSqlDate(movie.getDateOfLaunch()));
		String gross = df.format(movie.getGross());
		System.out.format("%5d%25s%15s%20s%25s%25s%20s \n", movie.getId(), movie.getTitle(), gross, movie.isActive(),
				date, movie.getGenre(), movie.isTeaser());

	}

	public static void main(String[] args) {

		testGetMovieItemListAdmin();
		testGetMovieItemListCustomer();
		testModifyMovieItem();
		testGetMovieList();

	}

}

package com.cognizant.truyum.dao;

@SuppressWarnings("serial")
public class CartEmptyException extends Exception {

	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;

	public CartEmptyException() {
		super("Cart List Is empty");
	}

}

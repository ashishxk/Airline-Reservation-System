package com.airlinereservation.exceptions;

public class FlightNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlightNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FlightNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

package com.airlinereservation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private String serviceType;
	private String classType;
	private LocalDate departureDate;
	private LocalDateTime departureTime;
	private int numberOfPassengers;
	private double fare;

	
	public Flight() {
		super();
	}
	

	public Flight(int flightId, String flightName, String source, String destination, String serviceType,
			String classType, LocalDate departureDate, LocalDateTime departureTime, int numberOfPassengers,
			double fare) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.serviceType = serviceType;
		this.classType = classType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.numberOfPassengers = numberOfPassengers;
		this.fare = fare;
	}



	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "\n----------------Flights Detail-----------------\n\nFlight ID = " + flightId + "\nFlight Name = " + flightName + "\nSource = " + source + "\nDestination = "
				+ destination + "\nClass Type = " + classType + "\nService Type = " + serviceType + "\nDepartureDate = "
				+ departureDate + "\nDeparture Time = " + departureTime + "\nSeats Available = " + numberOfPassengers
				+ "\nFare = " + fare +"\n";
	}

}

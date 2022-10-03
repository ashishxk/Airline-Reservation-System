package com.airlinereservation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightBookAndCancel {
	private String flightName;
	private String source;
	private String destination;
	private String serviceType;
	private String classType;
	private LocalDate departureDate;
	private LocalDateTime departureTime;
	
	public FlightBookAndCancel() {
		super();
	}
	
	public FlightBookAndCancel(String flightName, String source, String destination, String serviceType, String classType,
			LocalDate departureDate, LocalDateTime departureTime) {
		super();
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.serviceType = serviceType;
		this.classType = classType;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
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

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
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

	@Override
	public String toString() {
		return "FlightBooking [flightName=" + flightName + ", source=" + source + ", destination=" + destination
				+ ", serviceType=" + serviceType + ", classType=" + classType + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + "]";
	}
}

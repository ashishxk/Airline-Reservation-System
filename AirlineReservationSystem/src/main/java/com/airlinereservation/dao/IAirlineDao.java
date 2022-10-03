package com.airlinereservation.dao;

import java.util.List;

import com.airlinereservation.model.Flight;

public interface IAirlineDao {
	void addPlane(Flight flight);

	void deletePlane(int flightNumber);
	
	void updatePlane(int flightNumber, double fare);
	
	List<Flight> getFlightInfo();
	
	List<Flight> findAll(String source, String destination);

	List<Flight> findBySpecialServices(String source, String destination, String service);

	List<Flight> findByClass(String source, String destination, String classType);
}

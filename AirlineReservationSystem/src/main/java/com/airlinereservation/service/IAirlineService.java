package com.airlinereservation.service;

import java.util.List;
import com.airlinereservation.exceptions.FlightNotFoundException;
import com.airlinereservation.exceptions.InvalidPnrException;
import com.airlinereservation.model.Flight;

public interface IAirlineService {
	void addPlane(Flight flight);
	
	void deletePlane(int flightNumber);
	
	void updatePlane(int flightNumber, double fare);

	List<Flight> getFlightInfo() throws FlightNotFoundException;

	List<Flight> findAll(String source, String destination) throws FlightNotFoundException;

	List<Flight> findBySpecialServices(String source, String destination, String service) throws FlightNotFoundException;

	List<Flight> findByClass(String source, String destination, String classType) throws FlightNotFoundException;
}

package com.airlinereservation.service;

import java.util.List;
import java.util.stream.Collectors;

import com.airlinereservation.dao.AirlineDaoImpl;
import com.airlinereservation.dao.IAirlineDao;
import com.airlinereservation.exceptions.FlightNotFoundException;
import com.airlinereservation.model.Flight;

public class AirlineServiceImpl implements IAirlineService{
	
	IAirlineDao flightRef = new AirlineDaoImpl();
	
	@Override
	public void addPlane(Flight flight) {
		flightRef.addPlane(flight);
	}
	
	@Override
	public void deletePlane(int flightNumber) {
		flightRef.deletePlane(flightNumber);
	}
	
	@Override
	public void updatePlane(int flightNumber, double fare) {
		flightRef.updatePlane(flightNumber, fare);
	}
	
	public List<Flight> getFlightInfo() throws FlightNotFoundException {
		List<Flight> flight = flightRef.getFlightInfo();
		if(flight!=null) {
			return flight;
		}
		else
			throw new FlightNotFoundException("Flight Not Found");
	}

	public List<Flight> findAll(String source, String destination) throws FlightNotFoundException {
		return flightRef.findAll(source, destination).stream().sorted((flight1,flight2)->flight1.getFlightName().compareTo(flight2.getFlightName())).collect(Collectors.toList());
	}

	public List<Flight> findBySpecialServices(String source, String destination, String service)
			throws FlightNotFoundException {
		List<Flight> flight = flightRef.findBySpecialServices(source, destination, service).stream().sorted((flight1,flight2)->flight1.getFlightName().compareTo(flight2.getFlightName())).collect(Collectors.toList());
		if(flight.isEmpty()) {
			throw new FlightNotFoundException("No Flights Available");
		}
		else
			return flight;
	}

	public List<Flight> findByClass(String source, String destination, String classType)
			throws FlightNotFoundException {
		List<Flight> flight = flightRef.findByClass(source, destination, classType).stream().sorted((flight1,flight2)->flight1.getFlightName().compareTo(flight2.getFlightName())).collect(Collectors.toList());
		if(flight.isEmpty()) {
			throw new FlightNotFoundException("No Flights Available");
		}
		else
			return flight;
	}
}

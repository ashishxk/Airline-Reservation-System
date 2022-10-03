package com.airlinereservation.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airlinereservation.model.Flight;

public class FlightMapper implements IRowMapper{
	
	@Override
	public List<Flight> rowMap(ResultSet resultset) throws SQLException {
		List<Flight> flights = new ArrayList<>();
		
		while(resultset.next()) {
			Flight flight = new Flight();
			flight.setFlightName(resultset.getString(1));
			flight.setSource(resultset.getString(2));
			flight.setDestination(resultset.getString(3));
			flight.setServiceType(resultset.getString(4));
			flight.setClassType(resultset.getString(5));
			flight.setFare(resultset.getDouble(6));
			flight.setDepartureDate(resultset.getDate(7).toLocalDate());
			flight.setDepartureTime(resultset.getTimestamp(8).toLocalDateTime());
			flights.add(flight);
		}
		return flights;
	}
	
	
}

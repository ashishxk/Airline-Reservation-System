package com.airlinereservation.service;

import java.util.List;

import com.airlinereservation.exceptions.FlightNotFoundException;
import com.airlinereservation.model.Flight;
import com.airlinereservation.model.User;

public interface IUserService {
	String addUser(User user);

	User login(String userName, String password);

	int changePassword(String oldPassword, String newPassword);

	void bookFlight(Flight flight);

	void cancelFlight(int pnrNumber);

	void flightStatus(int pnrNumber);

	List<Flight> findAll(String source, String destination) throws FlightNotFoundException;

	List<Flight> findBySpecialServices(String source, String destination, String service)
			throws FlightNotFoundException;

	List<Flight> findByClass(String source, String destination, String classType) throws FlightNotFoundException;
}

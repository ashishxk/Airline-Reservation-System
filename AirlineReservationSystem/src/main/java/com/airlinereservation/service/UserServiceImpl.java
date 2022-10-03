package com.airlinereservation.service;

import java.util.List;

import com.airlinereservation.dao.IUserDao;
import com.airlinereservation.dao.UserDaoImpl;
import com.airlinereservation.exceptions.FlightNotFoundException;
import com.airlinereservation.model.Flight;
import com.airlinereservation.model.User;

public class UserServiceImpl implements IUserService{
	
	IUserDao user = new UserDaoImpl();
	
	@Override
	public void bookFlight(Flight flight) {
		user.bookFlight(flight);
	}

	@Override
	public void cancelFlight(int pnrNumber) {
		user.cancelFlight(pnrNumber);
	}

	@Override
	public void flightStatus(int pnrNumber) {
		user.flightStatus(pnrNumber);
	}

	@Override
	public List<Flight> findAll(String source, String destination) throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findBySpecialServices(String source, String destination, String service)
			throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findByClass(String source, String destination, String classType)
			throws FlightNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUser(User user) {
		
		return null;
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

}

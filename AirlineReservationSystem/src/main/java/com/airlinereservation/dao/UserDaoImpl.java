package com.airlinereservation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.airlinereservation.exceptions.FlightNotFoundException;
import com.airlinereservation.model.Flight;
import com.airlinereservation.model.User;
import com.airlinereservation.util.DbConnection;
import com.airlinereservation.util.Queries;

public class UserDaoImpl implements IUserDao {
	
	Connection connection = DbConnection.openConnection();
	
	@Override
	public String addUser(User user) {
		String mobile = String.valueOf(user.getMobile());
		try{
			PreparedStatement statement = connection.prepareStatement(Queries.REGISTERQUERY);
			statement.setString(1, user.getName());
			statement.setString(2, mobile);
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getUsername());
			statement.setString(5,user.getPassword());
			statement.setInt(6, 0);
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user.getPassword();
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changePassword(String oldpassword, String newpassword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void bookFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelFlight(int pnrNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flightStatus(int pnrNumber) {
		// TODO Auto-generated method stub
		
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

	
}

package com.airlinereservation.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.airlinereservation.model.Flight;
import com.airlinereservation.util.DbConnection;
import com.airlinereservation.util.FlightMapper;
import com.airlinereservation.util.IRowMapper;
import com.airlinereservation.util.Queries;

public class AirlineDaoImpl implements IAirlineDao {

	PreparedStatement statement = null;
	ResultSet resultset = null;
	IRowMapper mapper = new FlightMapper();

	public void addPlane(Flight flight) {
		Date date = Date.valueOf(flight.getDepartureDate());
		Timestamp time = Timestamp.valueOf(flight.getDepartureTime());
		Connection connection = DbConnection.openConnection();

		try {
			statement = connection.prepareStatement(Queries.INSERTQUERY);
			statement.setInt(1, flight.getFlightId());
			statement.setString(2, flight.getFlightName());
			statement.setString(3, flight.getSource());
			statement.setString(4, flight.getDestination());
			statement.setString(5, flight.getServiceType());
			statement.setString(6, flight.getClassType());
			statement.setDate(7, date);
			statement.setTimestamp(8, time);
			statement.setInt(9, flight.getNumberOfPassengers());
			statement.setDouble(10, flight.getFare());
			statement.execute();
			System.out.println("Saved Successfully!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();
		}
	}

	public void deletePlane(int flightNumber) {
		Connection connection = DbConnection.openConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, flightNumber);
			statement.execute();
			System.out.println("Deleted Successfully!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			DbConnection.closeConnection();
		}
	}

	@Override
	public void updatePlane(int flightNumber, double fare) {
		Connection connection = DbConnection.openConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setInt(1, flightNumber);
			statement.setDouble(2, fare);
			statement.execute();
			System.out.println("Updated Successfully!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {
					statement.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			DbConnection.closeConnection();
		}
	}


	public List<Flight> findAll(String source, String destination) {
		Connection connection = DbConnection.openConnection();

		List<Flight> flight = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSOURCEANDDESTINATION);
			statement.setString(1, source);
			statement.setString(2, destination);
			ResultSet resultset = statement.executeQuery();
			flight = mapper.rowMap(resultset);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null && resultset != null) {

				try {
					resultset.close();
					statement.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();
		}
		return flight;
	}

	public List<Flight> findBySpecialServices(String source, String destination, String service) {
		
		Connection connection = DbConnection.openConnection();

		List<Flight> flight = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSERVICE);
			statement.setString(1, source);
			statement.setString(2, destination);
			statement.setString(3, service);
			ResultSet resultset = statement.executeQuery();
			flight = mapper.rowMap(resultset);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null && resultset != null) {

				try {
					resultset.close();
					statement.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();
		}
		return flight;
	}

	public List<Flight> findByClass(String source, String destination, String classType) {
		
		Connection connection = DbConnection.openConnection();

		List<Flight> flight = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYCLASS);
			statement.setString(1, source);
			statement.setString(2, destination);
			statement.setString(3, classType);
			ResultSet resultset = statement.executeQuery();
			flight = mapper.rowMap(resultset);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null && resultset != null) {

				try {
					resultset.close();
					statement.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();
		}
		return flight;
	}

	@Override
	public List<Flight> getFlightInfo() {
		
		Connection connection = DbConnection.openConnection();
		
		List<Flight> flight = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYFORALL);
			ResultSet resultset = statement.executeQuery();
			flight = mapper.rowMap(resultset);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null && resultset != null) {

				try {
					resultset.close();
					statement.close();

				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();
		}
		return flight;
		
		/*
		 * try { PreparedStatement statement =
		 * connection.prepareStatement(Queries.QUERYFORALL); resultset =
		 * statement.executeQuery(); while (resultset.next()) { Date date =
		 * resultset.getDate(7); LocalDate localDate = date.toLocalDate(); Timestamp
		 * time = resultset.getTimestamp(8); LocalDateTime localDateTime =
		 * time.toLocalDateTime(); flight = new Flight();
		 * flight.setFlightId(resultset.getInt(1));
		 * flight.setFlightName(resultset.getString(2));
		 * flight.setSource(resultset.getString(3));
		 * flight.setDestination(resultset.getString(4));
		 * flight.setServiceType(resultset.getString(5));
		 * flight.setClassType(resultset.getString(6));
		 * flight.setDepartureDate(localDate); flight.setDepartureTime(localDateTime);
		 * flight.setNumberOfPassengers(resultset.getInt(9));
		 * flight.setFare(resultset.getDouble(10)); } } catch (SQLException e) {
		 * e.printStackTrace(); } finally { if (statement != null && resultset != null)
		 * {
		 * 
		 * try { resultset.close(); statement.close();
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); } } DbConnection.closeConnection(); }
		 * 
		 * return flight;
		 */
	}

}

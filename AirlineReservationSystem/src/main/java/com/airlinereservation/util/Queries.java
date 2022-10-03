package com.airlinereservation.util;

public class Queries {
	public static final String INSERTQUERY = "INSERT INTO admin(FlightId,FlightName,Source,Destination,ServiceType,ClassType,DepartureDate,DepartureTime,Passenger,Fare) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATEQUERY = "UPDATE admin SET Fare = ? WHERE FlightId = ?";
	public static final String DELETEQUERY = "DELETE FROM admin where FlightId = ?";
	
	public static final String QUERYFORALL = "SELECT * FROM admin";
	public static final String QUERYBYSOURCEANDDESTINATION = "SELECT * FROM admin WHERE Source = ? AND Destination = ?";
	public static final String QUERYBYFARE = "SELECT * FROM admin WHERE Source = ? AND Destination = ? AND cost <= ?";
	public static final String QUERYBYSERVICE = "SELECT * FROM admin WHERE Source = ? AND Destination = ? AND ServiceType = ?";
	public static final String QUERYBYCLASS = "SELECT * FROM admin WHERE Source = ? AND Destination = ? AND ClassType = ?";
	public static final String QUERYBYDATEANDTIME = "SELECT * FROM admin WHERE Source = ? AND Destination = ? AND Date = ? AND Time = ?";
	
	public static final String LOGINQUERY = "select * from Users where UserName = ? and pass = ?";
	public static final String REGISTERQUERY = "insert into Users(Name,Mobile,Email,City,UserName,pass) values(?,?,?,?,?,?)";
	public static final String CHANGEPASSWORDQUERY = "update Users set pass = ? where pass = ?";

}

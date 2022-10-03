package com.airlinereservation.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.airlinereservation.model.Flight;

public interface IRowMapper {
	List<Flight> rowMap(ResultSet resultset) throws SQLException;
}

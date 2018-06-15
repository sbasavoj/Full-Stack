package com.cg.flight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cg.flight.beans.Flight;
public class FlightStub {
	private static Map<Integer, Flight> flights = new HashMap<Integer, Flight>();
	private static int idIndex = 3;
	static {
		Flight a=new Flight(1, "ASD123", 2000f, "26/6/2018", "Pune", "Hyderabad", 70, "ABCD", 150);
		Flight b=new Flight(2, "WEA871", 3000f, "14/7/2018", "Bangalore", "Pune", 55, "ABCD", 150);
		Flight c=new Flight(3, "ASD123", 2500f, "18/8/2018", "Mumbai", "Hyderabad", 68, "ABCD", 150);
		flights.put(1,a);
		flights.put(2,b);
		flights.put(3,c);
	}
	public static List<Flight> list() {
		List<Flight> flight= new ArrayList<Flight>(flights.values());
		System.out.println(flight);
		return flight;
	}
	public static Flight create(Flight flight) {
		idIndex += idIndex;
		flight.setId(idIndex);
		flights.put(idIndex, flight);
		return flight;
	}
	public static Flight get(Integer id) {
		return flights.get(id);
	}
	public static Flight delete(Integer id) {
		return flights.remove(id);
	}
	public static Flight update(int id, Flight flight) {
		flights.put(id, flight);
		return flight;
	}
}
package P2Testing;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import p2.Flight;

public class FlightTest {
	private Flight f1 = new Flight("232", "2015-11-13 11:42", "2015-11-13 15:15", "Sean Noble's Airline", "Toronto", "New York", 299.99);
	private Calendar cDeparture = new GregorianCalendar(2015, 11 - 1, 13, 11, 42);
	private Calendar cArrival = new GregorianCalendar(2015, 11 - 1, 13, 15, 15);
	
	@Before
	public void setup(){
		
		
	}

	@Test
	public void testGetFlightNum() {
		assertTrue(f1.getFlightNum().equals("232"));
	}
	@Test
	public void testGetCost() {
		assertTrue(f1.getCost() == 299.99);
	}
	@Test
	public void testGetAirline() {
		assertTrue(f1.getAirline().equals("Sean Noble's Airline"));
	}
	@Test
	public void testGetOrigin() {
		assertTrue(f1.getOrigin() == "Toronto");
	}
	@Test
	public void testGetDestination() {
		assertTrue(f1.getDestination() == "New York");
	}
	@Test
	public void testGetDepartureDateAndTime() {
		assertTrue(f1.getDepartureDateAndTime().equals(cDeparture));
	}
	@Test
	public void testGetArrivalDateAndTime() {
		assertTrue(f1.getArrivalDateAndTime().equals(cArrival));
	}

}

package P2Testing;

import p2.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItineraryTest {
	private Flight flight1, flight2;
	private Flight[] flights;
	private Itinerary itinerary;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		flight1 = new Flight("489","2016-09-09 09:27","2016-09-09 13:27","FlightsRUs","Chicago","Los Angelos",300.99);
		flight2 = new Flight("490","2016-09-09 15:27","2016-09-09 17:27","Go Airline","Los Angelos","Boston",532.00);
		flights = new Flight[] {flight1, flight2};
		itinerary = new Itinerary(flights);
	}

	/**
	 * Test method for {@link p2.Itinerary#getCost()}.
	 */
	@Test
	public void testGetCost() {
		Double actual = itinerary.getCost();
		Double expected = 300.99 + 532.00;
		assertEquals("Cost incorrectly calculated", expected, actual);
	}

	/**
	 * Test method for {@link p2.Itinerary#getTimeInMillis()}.
	 */
	@Test
	public void testGetTimeInMillis() {
		Long actual = itinerary.getTimeInMillis();
		int expected = 8 * 60 * 60 * 1000;
		Long expectedInLong = new Long(expected);
		assertEquals("Time incorrectly calculated", expectedInLong, actual);
	}

	@Test
	public void testToString() {
		String actual = itinerary.toString();
		String expected = "489,2016-09-09 09:27,2016-09-09 13:27,FlightsRUs,Chicago,Los Angelos\n" +
		"490,2016-09-09 15:27,2016-09-09 17:27,Go Airline,Los Angelos,Boston\n832.99\n08:00";
		assertEquals("Incorrect string representation of itinerary", expected, actual);
	}
}

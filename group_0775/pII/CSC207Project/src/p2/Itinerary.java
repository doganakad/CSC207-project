/**
 * An Itinerary.
 * 
 * An Itinerary is a list of flights that get from one city to another.
 * An Itinerary keeps track of its Flights, total cost, origin city,
 * destination city, and the total travel time.
 * An Itinerary can give all of this information as well as the total
 * travel time in milliseconds. Itinerary overrides the toString method.
 */

package p2;

import java.text.DecimalFormat;

public class Itinerary {
	private double totalCost = 0.0;
	private String totalTime;
	private String origin;
	private String destination;
	private Flight[] flights;

	/**
	 * Creates an Itinerary with an array of Flights, the flights must be in
	 * chronological order, i.e. if there are n Flights being added to this
	 * Itinerary the first Flight is in index 0, the second Flight is in index
	 * 1, ..., the last flight is in index n - 1.
	 * 
	 * @param flights
	 *            an array of Flights in chronological order
	 */
	public Itinerary(Flight[] flights) {
		for (Flight f : flights) {
			this.totalCost += f.getCost();
		}
		this.origin = flights[0].getOrigin();
		this.destination = flights[flights.length - 1].getDestination();
		this.flights = flights;
		long totalSeconds = 
				(flights[flights.length - 1].getArrivalDateAndTime()
						.getTimeInMillis()
				- flights[0].getDepartureDateAndTime()
				.getTimeInMillis()) / 1000;
		this.totalTime = 
				new DecimalFormat("00")
				.format(Math.floor((totalSeconds) / 3600)) + ":"
				+ new DecimalFormat("00")
				.format(Math.floor(((totalSeconds) / 60 % 60)));
	}

	/**
	 * Returns the overall cost of this Itinerary.
	 * 
	 * @return a double representing the cost of this Itinerary
	 */
	public double getCost() {
		return this.totalCost;
	}

	/**
	 * Return the total time of this Itinerary in milliseconds.
	 * 
	 * @return a long representing the Itinerary time in milliseconds
	 */
	public long getTimeInMillis() {
		return this.flights[flights.length - 1].getArrivalDateAndTime()
				.getTimeInMillis()
				- this.flights[0].getDepartureDateAndTime().getTimeInMillis();
	}

	/**
	 * Returns the total time this Itinerary takes.
	 * 
	 * @return totalTime a String representing the total time of this Itinerary
	 */
	public String getTime() {
		return totalTime;
	}

	/**
	 * Returns the string representation of this Itinerary.
	 * @return a string representation of this Itinerary in the format:
	 *         Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,
	 *         Destination followed by total price (on its own line, exactly
	 *         two decimal places), followed by total duration (on its own
	 *         line, in format HH:MM).
	 */
	@Override
	public String toString() {
		String result = "";
		for (Flight f : flights) {
			result += f.toStringNoCost();
			result += "\n";
		}
		result += new DecimalFormat(".00").format(this.getCost()) + "\n";
		result += this.getTime();
		return result;
	}

	/**
	 * Returns the total cost of this Itinerary.
	 * @return a double representing the total cost of this Itinerary
	 */
	public double getTotalCost() {
		return totalCost;
	}
	
	/**
	 * Returns the total time travel time of this Itinerary
	 * (including stop overs).
	 * @return a String representing the total travel time of this Itinerary
	 *  	   (including stop overs)
	 */
	public String getTotalTime() {
		return totalTime;
	}

	/**
	 * Returns the origin of this Itinerary.
	 * @return a String representing the origin of this Itinerary
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Returns the destination of this Itinerary.
	 * @return a String representing the destination of this Itinerary
	 */
	public String getDestination() {
		return destination;
	}

}

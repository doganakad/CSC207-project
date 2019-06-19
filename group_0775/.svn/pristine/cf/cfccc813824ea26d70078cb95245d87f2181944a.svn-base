package group_0775.flightbookingapp;

/**
 * Created by Jeremy on 25/11/2015.
 */
/**
 * A flight.
 *
 * A Flight keeps track of its flight number, cost, airline, origin city,
 * destination city, departure date and time, and arrival date and time.
 * A Flight can give all of this information as well as the total flight
 * time in milliseconds. Flight overrides the toString method.
 */


        import java.io.Serializable;
        import java.text.DecimalFormat;
        import java.util.GregorianCalendar;

public class Flight implements Serializable {
    private static final long serialVersionUID = 8641290543934831486L;
    private String flightNum;
    private double cost;
    private String airline;
    private String origin;
    private String destination;
    private GregorianCalendar departureDateAndTime;
    private GregorianCalendar arrivalDateAndTime;
    private int numSeats;
    private int remainingSeats;

    /**
     * Creates a Flight with flight number, cost, airline, origin, destination,
     * departure date, departure time, arrival date, and arrival time
     *
     * @param flightNum
     *            an integer representing this Flight
     * @param cost
     *            a double representing the cost of this Flight
     * @param airline
     *            a string representing the airline providing this Flight
     * @param origin
     *            a string representing the origin city of this Flight
     * @param destination
     *            a string representing the destination city of this Flight
     * @param departureDateAndTime
     *            an integer array representing the date of departure of this
     *            Flight (format: {YYYY, MM, DD, HH, MM})
     * @param arrivalDateAndTime
     *            an integer array representing the date of arrival of this
     *            Flight (format: {YYYY, MM, DD, HH, MM})
     */
    public Flight(String flightNum, GregorianCalendar departureDateAndTime,
                  GregorianCalendar arrivalDateAndTime,
                  String airline, String origin, String destination, double cost,
                  int numSeats) {
        this.flightNum = flightNum;
        this.cost = cost;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.departureDateAndTime = departureDateAndTime;
        this.arrivalDateAndTime = arrivalDateAndTime;
        this.numSeats = numSeats;
        this.remainingSeats = numSeats;

    }

    /**
     * This is an alternative constructor for a Flight that instead of taking
     * int arrays for all of the date and time information it takes a string
     * for the departure date and time, and another string for the arrival
     * date and time. These string are required to be in the same format as
     * in the flights csv file ("YYYY-MM-DD HH:MM").
     *
     * @param flightNum
     *            an integer representing this Flight
     * @param cost
     *            a double representing the cost of this Flight
     * @param airline
     *            a string representing the airline providing this Flight
     * @param origin
     *            a string representing the origin city of this Flight
     * @param destination
     *            a string representing the destination city of this Flight
     * @param departureDateAndTime
     *            a string of format "YYYY-MM-DD HH:MM"
     * @param arrivalDateAndTime
     *            a string of format "YYYY-MM-DD HH:MM"
     */
    public Flight(String flightNum, String departureDateAndTime,
                  String arrivalDateAndTime, String airline,
                  String origin, String destination, double cost,
                  int numSeats) {
        this.flightNum = flightNum;
        this.cost = cost;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.numSeats = numSeats;
        this.remainingSeats = numSeats;
        this.departureDateAndTime = new GregorianCalendar(
                Integer.parseInt(departureDateAndTime.substring(0, 4)),
                Integer.parseInt(departureDateAndTime.substring(5, 7)) - 1,
                Integer.parseInt(departureDateAndTime.substring(8, 10)),
                Integer.parseInt(departureDateAndTime.substring(11, 13)),
                Integer.parseInt(departureDateAndTime.substring(14)));
        this.arrivalDateAndTime = new GregorianCalendar(
                Integer.parseInt(arrivalDateAndTime.substring(0, 4)),
                Integer.parseInt(arrivalDateAndTime.substring(5, 7)) - 1,
                Integer.parseInt(arrivalDateAndTime.substring(8, 10)),
                Integer.parseInt(arrivalDateAndTime.substring(11, 13)),
                Integer.parseInt(arrivalDateAndTime.substring(14)));
    }

    /**
     * Returns the Flight number of this Flight.
     *
     * @return a String representing this Flight's Flight number
     */
    public String getFlightNum() {
        return flightNum;
    }

    /**
     * Returns this Flight's cost.
     *
     * @return a double representing this Flight's cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns this Flight's airline company.
     *
     * @return a String representing this Flight's airline.
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Returns the origin city of this Flight.
     *
     * @return origin a String representing a Flight's origin city
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin
     * @param origin the origin to set
     */
    public void setOrigin(String origin){
        this.origin = origin;
    }

    /**
     * Returns the number of seats in this flight
     * @return the number of seats in this flight
     */
    public int getNumSeats(){
        return this.numSeats;
    }

    /**
     * Returns the remaining seats in this flight
     * @return the remaining seats in this flight
     */
    public int getRemainingSeats(){
        return this.remainingSeats;
    }

    /**
     * Sets the number of remaining seats in this flight
     * @param seats the number of remaining seats to be set to
     */
    public void setRemainingSeats(int seats){
        this.remainingSeats = seats;
    }

    /**
     * Returns true iff there are no remaining seats left
     * @return true iff there are no remaining seats left
     */
    public boolean isFull() {
        return this.remainingSeats == 0;
    }

    /**
     * Returns whither or not a seat on this flight can be booked,
     * and books a seat if it can.
     *@return true iff there are seats remaining
     */
    public boolean bookFlight() {
        if( !this.isFull()){
            this.remainingSeats -= 1;
            return true;
        }
        return false;
    }

    /**
     * Returns the destination city of this Flight.
     *
     * @return destination a String representing a Flight's destination city
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Returns the Departure Date and Time of this Flight.
     *
     * @return departureDateAndTime a GregorianCalendar representing a Flight's
     *         Date and Time of Departure
     */
    public GregorianCalendar getDepartureDateAndTime() {
        return departureDateAndTime;
    }

    /**
     * Returns the Arrival Date and Time of this Flight.
     *
     * @return arrivalDateAndTime a GregorianCalendar representing a Flight's
     *         Date and Time of Arrival
     */
    public GregorianCalendar getArrivalDateAndTime() {
        return arrivalDateAndTime;
    }

    /**
     * Returns a String representation of this Flight.
     *
     * @return a String representing this Flight in format:
     * 		   Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,
     *         Destination,Price (the dates are in the format YYYY-MM-DD; the
     *         price has exactly two decimal places)
     */
    @Override
    public String toString() {
        String departureMonth = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.MONTH) + 1);
        String departureDay = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.DAY_OF_MONTH));
        String departureHour = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.HOUR_OF_DAY));
        String departureMinute = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.MINUTE));
        String arrivalMonth = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.MONTH) + 1);
        String arrivalDay = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.DAY_OF_MONTH));
        String arrivalHour = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.HOUR_OF_DAY));
        String arrivalMinute = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.MINUTE));
        String[] dateStrings = new String[] {
                departureMonth, departureDay, departureHour, departureMinute,
                arrivalMonth, arrivalDay, arrivalHour, arrivalMinute };
        for (int i = 0; i < dateStrings.length; i++) {
            if (dateStrings[i].length() == 1) {
                dateStrings[i] = "0" + dateStrings[i];
            }
        }


        return this.flightNum + "," + this.departureDateAndTime.get(
                GregorianCalendar.YEAR) + "-" + dateStrings[0] + "-"
                + dateStrings[1] + " " + dateStrings[2] + ":"
                + dateStrings[3] + ","
                + this.arrivalDateAndTime.get(GregorianCalendar.YEAR)
                + "-" + dateStrings[4] + "-" + dateStrings[5]
                + " " + dateStrings[6] + ":" + dateStrings[7]
                + "," + this.airline + "," + this.origin + ","
                + this.destination + ","
                + new DecimalFormat(".00").format(this.cost);
    }

    /**
     * Returns a string representation of departure date
     * @return a string representation of departure date
     */
    public String getDepartureDateString(){

        return String.format("%1$tY-%1$tm-%1$td",this.departureDateAndTime );

    }

    /**
     * Returns a string representation of departure time
     * @return a string representation of departure time
     */
    public String getDepartureTimeString(){

        return String.format("%1$tH:%1$tM",this.departureDateAndTime );

    }

    /**
     * Returns a string representation of arrival date
     * @return a string representation of arrival date
     */
    public String getArrivalDateString(){

        return String.format("%1$tY-%1$tm-%1$td",this.arrivalDateAndTime );

    }

    /**
     * Returns a string representation of arrival time
     * @return a string representation of arrival time
     */
    public String getArrivalTimeString(){

        return String.format("%1$tH:%1$tM",this.arrivalDateAndTime );

    }




    /**
     * Returns a String representation of this Flight without the Cost field.
     *
     * @return a String representing this Flight in format:
     * 		   Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,
     *         Destination (the dates are in the format YYYY-MM-DD; the
     *         price has exactly two decimal places)
     */
    public String toStringNoCost() {
        String departureMonth = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.MONTH) + 1);
        String departureDay = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.DAY_OF_MONTH));
        String departureHour = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.HOUR_OF_DAY));
        String departureMinute = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.MINUTE));
        String arrivalMonth = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.MONTH) + 1);
        String arrivalDay = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.DAY_OF_MONTH));
        String arrivalHour = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.HOUR_OF_DAY));
        String arrivalMinute = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.MINUTE));
        String[] dateStrings = new String[] {
                departureMonth, departureDay, departureHour, departureMinute,
                arrivalMonth, arrivalDay, arrivalHour, arrivalMinute };
        for (int i = 0; i < dateStrings.length; i++) {
            if (dateStrings[i].length() == 1) {
                dateStrings[i] = "0" + dateStrings[i];
            }
        }
        return this.flightNum + "," + this.departureDateAndTime.get(
                GregorianCalendar.YEAR) + "-" + dateStrings[0] + "-"
                + dateStrings[1] + " " + dateStrings[2] + ":" + dateStrings[3]
                + "," + this.arrivalDateAndTime.get(GregorianCalendar.YEAR)
                + "-" + dateStrings[4] + "-" + dateStrings[5]
                + " " + dateStrings[6] + ":" + dateStrings[7] + ","
                + this.airline + "," + this.origin + ","
                + this.destination;
    }

    /**
     * Returns a string representation of this flight to be shown on the front-end
     * @return the string representation of this flight for the User to see
     */
    public String toUIString(){
        String departureMonth = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.MONTH) + 1);
        String departureDay = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.DAY_OF_MONTH));
        String departureHour = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.HOUR_OF_DAY));
        String departureMinute = String.valueOf(this.departureDateAndTime.get(
                GregorianCalendar.MINUTE));
        String arrivalMonth = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.MONTH) + 1);
        String arrivalDay = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.DAY_OF_MONTH));
        String arrivalHour = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.HOUR_OF_DAY));
        String arrivalMinute = String.valueOf(this.arrivalDateAndTime.get(
                GregorianCalendar.MINUTE));
        String[] dateStrings = new String[] {
                departureMonth, departureDay, departureHour, departureMinute,
                arrivalMonth, arrivalDay, arrivalHour, arrivalMinute };
        for (int i = 0; i < dateStrings.length; i++) {
            if (dateStrings[i].length() == 1) {
                dateStrings[i] = "0" + dateStrings[i];
            }
        }
        return "Flight " + this.flightNum + " to " + this.destination
                + ", Departing from " + this.origin
                + " on " + + this.departureDateAndTime.get(
                GregorianCalendar.YEAR) + "-" + dateStrings[0] + "-"
                + dateStrings[1] + " at " + dateStrings[2] + ":" + dateStrings[3]
                + "\n" + this.airline
                + "\n$" + this.cost;

    }

    /**
     * Returns the length of time of this Flight in milliseconds.
     *
     * @return a Long representing the time between departure
     * 		   and arrival in milliseconds
     */
    public Long getTimeInMillis() {
        return this.arrivalDateAndTime.getTimeInMillis()
                - this.departureDateAndTime.getTimeInMillis();
    }

}


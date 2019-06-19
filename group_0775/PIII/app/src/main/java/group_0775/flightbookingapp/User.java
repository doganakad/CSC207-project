package group_0775.flightbookingapp;

/**
 * Created by Jeremy on 25/11/2015.
 */
/**
 * A user in a flight booking application.
 * Stores the personal and billing information about this user.
 * A user can search for available flights and itineraries after
 * providing departure date, travel origin, and travel destination.
 * A user can display the search results sorted by time or by cost.
 * A user can view the information of another user after providing
 * the email address of that user.
 * A user can upload information of other users or flights to be
 * stored in the system.
 *
 */
        import java.io.Serializable;
        import java.util.GregorianCalendar;
        import java.util.ArrayList;
        import java.util.Calendar;
public class User implements Serializable {
    private static final long serialVersionUID = 8641297418734831486L;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String creditCardNumber;
    private GregorianCalendar expiryDate;

    /**
     * Constructs a new User with its surname lastName, first name firstName,
     * email email, address address, and its credit card no creditCardNumber and expiry date expiryDate.
     *
     * @param lastName
     *            a String representing the last name of this User
     * @param firstName
     *            a String representing the first name of this User
     * @param email
     *            a String representing the email address of this User
     * @param address
     *            a String representing the street address of this User
     * @param creditCardNumber
     *            a Long representing the credit card number of this User
     * @param expiryDate
     *            a GregorianCalendar representing the expiry date of this
     *            User's credit card
     */
    public User(String lastName, String firstName, String email,String address,
                String creditCardNumber, GregorianCalendar expiryDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
    }

    /**
     * This is an alternative constructor for a User where instead of passing a
     * GregorianCalendar for the expiry date you pass a String of form:
     * "YYYY-MM-DD HH:MM"
     *
     * @param lastName
     *            a String representing the last name of this User
     * @param firstName
     *            a String representing the first name of this User
     * @param email
     *            a String representing the email address of this User
     * @param address
     *            a String representing the street address of this User
     * @param creditCardNumber
     *            a Long representing the credit card number of this User
     * @param expiryDate
     *            a String representing the expiry date of this User's credit
     *            card
     */
    public User(String lastName, String firstName, String email,String address,
                String creditCardNumber, String expiryDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = new GregorianCalendar(
                Integer.parseInt(expiryDate.substring(0, 4)),
                Integer.parseInt(expiryDate.substring(5, 7)),
                Integer.parseInt(expiryDate.substring(8, 10))
        );
    }

    /**
     * Returns the available flights given departure date, origin,
     * and destination.
     *
     * @param departureDate
     *            departure date of the flight
     * @param origin
     *            origin of the flight
     * @param destination
     *            destination of the flight
     * @return an ArrayList of flights available
     */
    public ArrayList<Flight> searchFlights(GregorianCalendar departureDate,
                                           String origin, String destination) {
        return BookingApp.searchFlights(departureDate, origin, destination);
    }

    /**
     * Returns the available itineraries given departure date, origin,
     * and destination
     *
     * @param departureDate
     *            departure date of the itinerary
     * @param origin
     *            origin of the itinerary
     * @param destination
     *            destination of the itinerary
     * @return list of Itineraries available in the given information.
     */
    public ArrayList<Itinerary> searchItineraries(
            GregorianCalendar departureDate, String origin,
            String destination) {
        return BookingApp.searchItineraries(departureDate, origin,
                destination);
    }

    /**
     * Returns a String representing a list of flights sorted
     * by total travel time.
     *
     * @param flights
     *            the list of flights to be sorted
     * @return a String representing a list of flights sorted
     *         by total travel time
     */
    public String displayTimeFlights(ArrayList<Flight> flights) {
        return BookingApp.displayTimeFlights(flights);
    }

    /**
     * Returns a String representing s list of flights sorted
     * by total cost.
     *
     * @param flights
     *            the list of flights to be sorted
     * @return a String representing a list of flights sorted
     * 		   by total cost
     */
    public String displayCostFlights(ArrayList<Flight> flights) {
        return BookingApp.displayCostFlights(flights);
    }

    /**
     * Returns a String representing a list of itineraries sorted
     * by total travel time.
     *
     * @param itineraries
     *            the itinerary list that is going to be sorted
     * @return a String representing s list of itineraries sorted
     * 		   by total travel time
     */
    public String displayTimeItineraries(ArrayList<Itinerary> itineraries) {
        return BookingApp.displayTimeItineraries(itineraries);
    }

    public String getExpiryDateString(){

        return String.format("%1$tY-%1$tm-%1$td", this.expiryDate);

    }

    /**
     * Returns a String representing a list of itineraries sorted
     * by total cost.
     *
     * @param itineraries
     *            the itinerary list that is going to be sorted
     * @return a String representing a list of itineraries sorted
     * 		   by total cost
     */
    public String displayCostItineraries(ArrayList<Itinerary> itineraries) {
        return BookingApp.displayCostItineraries(itineraries);
    }

    /**
     * Returns the email address of this User.
     *
     * @return  a String representing the email address of this User.
     */
    public String getEmail() {
        return email;
    }


    public String toUIString() {
        return this.firstName + " " + this.lastName
                + "\n" + this.email;
    }
    @Override
    public String toString() {
        String month = String.valueOf(this.expiryDate.get(Calendar.MONTH));
        String day = String.valueOf(
                this.expiryDate.get(Calendar.DAY_OF_MONTH));
        if (month.length() == 1) {
            month = 0 + month;
        }
        if (day.length() == 1) {
            day = 0 + day;
        }
        return this.lastName + "," + this.firstName + "," + this.email + ","
                + this.address + "," + this.creditCardNumber + ","
                + this.expiryDate.get(Calendar.YEAR) + "-" + month + "-" + day;

    }

    /**
     * Returns the expiry date of this User's credit card.
     *
     * @return expiry date (GregorianCalendar) of this
     * 		   User's credit card
     */
    public GregorianCalendar getExpiryDate() {
        return expiryDate;
    }
    /**
     * Returns the last name of this User.
     *
     * @return  a String representing the last name of this User
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the first name of this User.
     *
     * @return  a String representing the first name of this User.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the address of this User.
     *
     * @return a String representing the address of this User.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the credit card number of this User.
     *
     * @return a String representing credit card number of this User
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}

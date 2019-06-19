package group_0775.flightbookingapp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * Created by doganakad on 15-11-28.
 */
public class Client extends User{
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String creditCardNumber;
    private GregorianCalendar expiryDate;
    private ArrayList<Itinerary> bookedItineraries = new ArrayList<Itinerary>();

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
    public Client(String lastName, String firstName, String email, String address,
                  String creditCardNumber, GregorianCalendar expiryDate){
        super(lastName, firstName, email, address, creditCardNumber, expiryDate);
    }
    public Client(String lastName, String firstName, String email, String address,
                  String creditCardNumber, String expiryDate){
        super(lastName, firstName, email, address, creditCardNumber, expiryDate);
    }

    /**
     * Sets the cardNumber
     * @param cardNumber the card number to set
     */
    public void setCreditCardNumber(String cardNumber){this.creditCardNumber = cardNumber;}

    /**
     * Sets the last name
     * @param lastName1 the last name to set
     */
    public void setLastName(String lastName1){this.lastName = lastName1;}

    /**
     * Sets the first name
     * @param firstName1 the first name to set
     */
    public void setFirstName(String firstName1){this.firstName = firstName1;}

    /**
     * Sets the email address
     * @param email1 the email address to set
     */
    public void setEmail(String email1){this.email = email1;}

    /**
     * Sets the address
     * @param address1 the address to set
     */
    public void setAddress(String address1){this.address = address1;}

    /**
     * Sets the expiry date of the credit card
     * @param expiryDate1 the expiry date of the credit card to set
     */
    public void setExpiryDate(GregorianCalendar expiryDate1){this.expiryDate = expiryDate1;}

    /**
     * Returns an ArrayList of booked Itineraries
     * @return an ArrayList of booked Itineraries
     */
    public ArrayList<Itinerary> getBookedItinerary() {
        return this.bookedItineraries;
    }

    /**
     * Books the Itinerary itinerary
     * @param itinerary the Itinerary that is getting booked
     */
    public void bookItinerary(Itinerary itinerary) {
       this.bookedItineraries.add(itinerary);
    }
}



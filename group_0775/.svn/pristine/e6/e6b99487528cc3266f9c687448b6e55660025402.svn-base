package group_0775.flightbookingapp;

import java.util.GregorianCalendar;

/**
 * Created by doganakad on 15-11-28.
 */
public class Admin extends User{
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String creditCardNumber;
    private GregorianCalendar expiryDate;
    /**
     * Constructs a new Admin with its surname lastName, first name firstName,
     * email email, address address, and its credit card no creditCardNumber and expiry date expiryDate.
     *
     * @param lastName
     *            a String representing the last name of this Admin
     * @param firstName
     *            a String representing the first name of this Admin
     * @param email
     *            a String representing the email address of this Admin
     * @param address
     *            a String representing the street address of this Admin
     * @param creditCardNumber
     *            a Long representing the credit card number of this User
     * @param expiryDate
     *            a GregorianCalendar representing the expiry date of this
     *            User's credit card
     */
    public Admin(String lastName, String firstName, String email, String address,
                  String creditCardNumber, GregorianCalendar expiryDate){
        super(lastName, firstName, email, address, creditCardNumber, expiryDate);
    }
    public String getClientInfo(String email) {
        return BookingApp.getClientInfo(email);
    }

    /**
     * Uploads client information from a csv file to be stored in the system.
     *
     * @param clientFileName a String representing the path to a
     * 		 user csv file
     */
    public void uploadUsersInfo(String clientFileName) {
        BookingApp.loadClientsList(clientFileName);
    }

//    /**
//     * Uploads flight information from a csv file to be stored in the system.
//     *
//     * @param flightFileName a String representing the path to a
//     * 		 flight csv file
//     */
//    public void uploadFlightsInfo(String flightFileName) {
//        BookingApp.loadFlightsList(flightFileName);
//    }
}

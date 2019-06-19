package group_0775.flightbookingapp;

/**
 * Created by Jeremy on 25/11/2015.
 */
/**
 * BookingApp.
 *
 * BookingApp is the class that runs most of the back-end methods of the flight
 * booking application. Most of its methods are static as creating an instance
 * of BookingApp is not the intention of this class.
 *
 * BookingApp is responsible for uploading flight and user data from csv files,
 * keeping track of Flights and Users, searching for flights and itineraries,
 * sorting these searches, and displaying these results in the correct format
 * as per the driver.
 */
        import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TreeMap;

public class BookingApp {

    private static ArrayList<Flight> flights = new ArrayList<Flight>();
    private static ArrayList<Client> clients = new ArrayList<Client>();
    private static Client currentClient;

    /**
     * Creates Flights from a csv file of flight information with lines
     * in the format:
     *        Number,DepartureDateTime,ArrivalDateTime,Airline,Origin,
     *        Destination,Price (the dates are in the format YYYY-MM-DD; the
     *        price has exactly two decimal places)
     * and adds them to the ArrayList of Flights.
     *
     * @param path
     *            a String of the file path of the flights list
     */
 public static void loadFlights(String path) {

     try {
         BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                 new FileInputStream(new File(path))));
         String inputString;
         String[] flightToAdd;
         while ((inputString = inputReader.readLine()) != null) {
             flightToAdd = inputString.split(",");
             boolean unique = true;
             for(Flight f: flights){
                 if(f.getFlightNum().equals(flightToAdd[0])){
                     unique = false;
                 }
             }
             if(unique) {
                 flights.add(new Flight(flightToAdd[0], flightToAdd[1],
                         flightToAdd[2], flightToAdd[3], flightToAdd[4],
                         flightToAdd[5], Double.parseDouble(flightToAdd[6]),
                         Integer.parseInt(flightToAdd[7])));
             }
         }
     } catch (IOException e) {
         e.printStackTrace();
     }

  }



    /**
     * Creates Users from user info from a csv file containing  user
     * information in this format:
     *         LastName,FirstNames,Email,Address,CreditCardNumber,ExpiryDate
     *         (the ExpiryDate is stored in the format YYYY-MM-DD)
     *and adds them to the ArrayList of Users.
     * @param path
     *            a String of the file path of the users list
     */
    public static void loadClientsList(String path) {

        try {
            Scanner usersFile = new Scanner(new File(path));
            String[] userToAdd;
            while (usersFile.hasNextLine()) {
                userToAdd = usersFile.nextLine().split(",");
                boolean unique = true;
                for(Client c: clients){
                    if(c.getEmail().equals(userToAdd[2])){
                        unique = false;
                    }
                }
                if(unique){
                    clients.add(new Client(userToAdd[0], userToAdd[1], userToAdd[2],
                            userToAdd[3], userToAdd[4], userToAdd[5]));
                }

            }
            usersFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns an ArrayList of Flights that correspond with the departureDate,
     * origin and destination that the User inputs
     *
     * @param departureDate
     *            an integer array representing the date of departure of this
     *            Flight (format: {YYYY, MM, DD})
     * @param origin
     *            a string representing the origin city of this Flight
     * @param destination
     *            a string representing the destination city of this Flight
     * @return searchedFlights an ArrayList of Flights containing Flights with
     *         departureDate, origin and destination
     */
    public static ArrayList<Flight> searchFlights(
            GregorianCalendar departureDate,
            String origin, String destination) {
        ArrayList<Flight> searchedFlights = new ArrayList<Flight>();
        for (Flight f : flights) {
            f.getDepartureDateAndTime();
            f.getDepartureDateAndTime();
            if (departureDate.get(GregorianCalendar.YEAR)
                    == f.getDepartureDateAndTime().get(GregorianCalendar.YEAR)
                    && departureDate.get(GregorianCalendar.DAY_OF_YEAR)
                    == f.getDepartureDateAndTime()
                    .get(GregorianCalendar.DAY_OF_YEAR)
                    && f.getOrigin().contains(origin)
                    && f.getDestination().equals(destination)) {
                searchedFlights.add(f);
            }
        }
        return searchedFlights;
    }

    /**
     * An alternative method for searchFlights, takes a String for the departure
     * date instead of an integer array, returns an ArrayList of Flights that
     * correspond with the departureDate, origin and destination that the User
     * inputs
     *
     * @param departureDateString
     *            a string of format "YYYY-MM-DD"
     * @param origin
     *            a string representing the origin city of this Flight
     * @param destination
     *            a string representing the destination city of this Flight
     * @return searchedFlights an ArrayList of Flights containing Flights with
     *         departureDate, origin and destination
     */
    public static ArrayList<Flight> searchFlights(String departureDateString,
                                                  String origin, String destination) {
        ArrayList<Flight> searchedFlights = new ArrayList<Flight>();
        GregorianCalendar departureDate = new GregorianCalendar(
                Integer.parseInt(departureDateString.substring(0, 4)),
                Integer.parseInt(departureDateString.substring(5, 7)) - 1,
                Integer.parseInt(departureDateString.substring(8, 10)));
        for (Flight f : flights) {
            if (departureDate.get(GregorianCalendar.YEAR)
                    == f.getDepartureDateAndTime().get(GregorianCalendar.YEAR)
                    && departureDate.get(GregorianCalendar.DAY_OF_YEAR)
                    == f.getDepartureDateAndTime()
                    .get(GregorianCalendar.DAY_OF_YEAR)
                    && f.getOrigin().equals(origin)
                    && f.getDestination().equals(destination)) {
                searchedFlights.add(f);
            }
        }
        return searchedFlights;
    }

    /**
     * Returns an ArrayList of Itineraries that correspond with the
     * departureDate, origin and destination that the User inputs
     *
     * @param departureDate
     *            a GregorianCalendar representing the desired date of
     *            departure
     * @param origin
     *            a string representing the origin city of this Itinerary
     * @param destination
     *            a string representing the destination city of this Itinerary
     * @return itineraries an ArrayList of Itineraries that have departureDate,
     *         origin and destination
     */
    public static ArrayList<Itinerary> searchItineraries(
            GregorianCalendar departureDate, String origin,
            String destination) {
        ArrayList<Flight> firstVisited = new ArrayList<Flight>();
        ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
        for (Flight checkFlight : flights) {
            if (checkFlight.getDepartureDateAndTime().get(
                    GregorianCalendar.YEAR) == departureDate
                    .get(GregorianCalendar.YEAR)
                    && checkFlight.getDepartureDateAndTime().get(
                    GregorianCalendar.DAY_OF_YEAR) == departureDate
                    .get(GregorianCalendar.DAY_OF_YEAR)
                    && checkFlight.getOrigin().equals(origin)) {
                firstVisited.add(checkFlight);
            }
        }
        for (int f = 0; f < firstVisited.size(); f++) {
            ArrayList<String> visitedCities = new ArrayList<String>();
            ArrayList<Flight> flights = new ArrayList<Flight>();
            flights.add(firstVisited.get(f));
            visitedCities.add(firstVisited.get(f).getOrigin());
            itineraries.addAll(
                    searchItineraries(
                            firstVisited.get(f).getArrivalDateAndTime(),
                            firstVisited.get(f).getDestination(),
                            destination, visitedCities, flights));
        }
        return itineraries;

    }

    /**
     * An alternative method for searchFlights where the departure date is
     * a String.
     * Returns an ArrayList of Itineraries that correspond with the
     * departureDate, origin and destination that the User inputs.
     *
     * @param departureDateString
     *            a string of format "YYYY-MM-DD HH:MM"
     * @param origin
     *            a string representing the origin city of this Itinerary
     * @param destination
     *            a string representing the destination city of this Itinerary
     * @return itineraries an ArrayList of Itineraries that have departureDate,
     *         origin and destination
     */
    public static ArrayList<Itinerary> searchItineraries(
            String departureDateString, String origin,
            String destination) {
        GregorianCalendar departureDate = new GregorianCalendar(
                Integer.parseInt(departureDateString.substring(0, 4)),
                Integer.parseInt(departureDateString.substring(5, 7)) - 1,
                Integer.parseInt(departureDateString.substring(8, 10)));
        ArrayList<Flight> firstVisited = new ArrayList<Flight>();
        ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
        for (Flight checkFlight : flights) {
            if (checkFlight.getDepartureDateAndTime().get(
                    GregorianCalendar.YEAR) == departureDate
                    .get(GregorianCalendar.YEAR)
                    && checkFlight.getDepartureDateAndTime().get(
                    GregorianCalendar.DAY_OF_YEAR) == departureDate
                    .get(GregorianCalendar.DAY_OF_YEAR)
                    && checkFlight.getOrigin().equals(origin)) {
                firstVisited.add(checkFlight);
            }
        }
        for (int f = 0; f < firstVisited.size(); f++) {
            ArrayList<String> visitedCities = new ArrayList<String>();
            visitedCities.add(firstVisited.get(f).getOrigin());
            itineraries.addAll(
                    searchItineraries(
                            firstVisited.get(f).getArrivalDateAndTime(),
                            firstVisited.get(f).getDestination(),
                            destination, visitedCities,
                            new ArrayList<Flight>(
                                    firstVisited.subList(f, f + 1))));
        }
        return itineraries;

    }

    /**
     * This is a version of searchItineraries that is basically a helper
     * method. This is the recursive part of the search algorithm, and is
     * not meant to be called by anything but the initial searchItineraries
     * thus it is private.
     *
     * Returns an ArrayList of Itineraries that correspond with the
     * departureDate, origin and destination that the User inputs (This
     * is the recursive part of the search where the already visited )
     *
     * @param lastFlightArrival
     *            A GregorianCalendar representing the time the last flight
     *            arrives
     * @param currentCity
     *            a String representing the current city in recursion
     * @param destination
     *            a String representing the destination city of the Itinerary
     * @param visitedCities
     *            an ArrayList of Strings representing the cities that have
     *            already been visited
     * @param prevflights
     *            an ArrayList of Flights containing the flights that have
     *            already been visited
     * @return itineraries an ArrayList of Itineraries
     */
    private static ArrayList<Itinerary> searchItineraries(
            GregorianCalendar lastFlightArrival, String currentCity,
            String destination, ArrayList<String> visitedCities,
            ArrayList<Flight> prevflights) {
        ArrayList<Itinerary> itineraries = new ArrayList<Itinerary>();
        ArrayList<Flight> nextToVisit = new ArrayList<Flight>();
        if (currentCity.equals(destination)) {
            Flight[] flightsToItinerary = new Flight[prevflights.size()];
            prevflights.toArray(flightsToItinerary);
            itineraries.add(new Itinerary(flightsToItinerary));
        } else {
            for (Flight checkFlight : flights) {
                if (!visitedCities.contains(checkFlight.getDestination())
                        && checkFlight.getOrigin().equals(currentCity)
                        && (((((
                        checkFlight.getDepartureDateAndTime().getTimeInMillis()
                                - lastFlightArrival.getTimeInMillis())
                        / 1000) / 60) / 60) <= 6)
                        && (((((
                        checkFlight.getDepartureDateAndTime().getTimeInMillis()
                                - lastFlightArrival.getTimeInMillis())
                        / 1000) / 60) / 60) > 0)) {
                    nextToVisit.add(checkFlight);
                }
            }
            if (nextToVisit.isEmpty()) {
                return itineraries;
            } else {
                for (int f = 0; f < nextToVisit.size(); f++) {

                    ArrayList<String> newVisited =
                            new ArrayList<String>(visitedCities);
                    newVisited.add(nextToVisit.get(f).getDestination());
                    ArrayList<Flight> newFlights =
                            new ArrayList<Flight>(prevflights);
                    newFlights.add(nextToVisit.get(f));
                    itineraries.addAll(searchItineraries(
                            nextToVisit.get(f).getArrivalDateAndTime(),
                            nextToVisit.get(f).getDestination(), destination,
                            newVisited, newFlights));
                }

            }
        }

        return itineraries;
    }

    /**
     * Returns an ArrayList of all Flights.
     *
     * @return flights an ArrayList of Flights
     */
    public static ArrayList<Flight> getFlightList() {
        return flights;
    }

    /**
     * Returns an ArrayList of all Users.
     *
     * @return users an ArrayList of Users.
     */
    public static ArrayList<Client> getClientList() {
        return clients;
    }

    /**
     * Returns a String representing the information of a User that corresponds
     * with the given email.
     *
     * @param email
     *            a String representing the email of a User
     * @return a String representation of a User's information
     */
    public static String getClientInfo(String email) {
        for (Client c : clients) {
            if (c.getEmail().equals(email)) {
                return c.toString();
            }
        }
        return "";
    }

    /**
     * Return the list of items sorted by time.
     * @param list the list to be sorted
     * @param <E> generic list of items (Flight or Itinerary)
     * @return the list of items sorted by time.
     */
    public static <E> ArrayList<E> sortByTime(ArrayList<E> list) {
        TreeMap<Long, ArrayList<E>> timeToElements =
                new TreeMap<Long, ArrayList<E>>();
        for (E element : list) {
            Long travelTime;
            if (element instanceof Flight) {
                travelTime = ((Flight) element).getTimeInMillis();
            } else {
                travelTime = ((Itinerary) element).getTimeInMillis();
            }
            if (timeToElements.containsKey(travelTime)) {
                timeToElements.get(travelTime).add(element);
            } else {
                ArrayList<E> elementsOfThisTime = new ArrayList<E>();
                elementsOfThisTime.add(element);
                timeToElements.put(travelTime, elementsOfThisTime);
            }
        }
        Collection<ArrayList<E>> resultInLists = timeToElements.values();
        ArrayList<E> unwrappedList = unwrap(resultInLists);
        ArrayList<E> availableList = removeFullyBooked(unwrappedList);
        return availableList;
    }

    /**
     * Return the list of items sorted by cost.
     * @param list the list to be sorted
     * @param <E> generic list of items (Flight or Itinerary)
     * @return the list of items sorted by cost.
     */
    public static <E> ArrayList<E> sortByCost(ArrayList<E> list) {
        TreeMap<Double, ArrayList<E>> costToElements =
                new TreeMap<Double, ArrayList<E>>();
        for (E element : list) {
            Double cost;
            if (element instanceof Flight) {
                cost = ((Flight) element).getCost();
            } else {
                cost = ((Itinerary) element).getCost();
            }
            if (costToElements.containsKey(cost)) {
                costToElements.get(cost).add(element);
            } else {
                ArrayList<E> elementsOfThisCost = new ArrayList<E>();
                elementsOfThisCost.add(element);
                costToElements.put(cost, elementsOfThisCost);
            }
        }
        Collection<ArrayList<E>> resultInLists = costToElements.values();
        ArrayList<E> unwrappedList = unwrap(resultInLists);
        ArrayList<E> availableList = removeFullyBooked(unwrappedList);
        return availableList;
    }

    /**
     * Returns a list of objects sorted by cost.
     *
     * @param <E> either of type Flight or of type Itinerary
     * @param list
     *            the list of objects to be sorted
     * @return a list of objects sorted by price
     */
    private static <E> String displayByCost(ArrayList<E> list) {
        ArrayList<E> availableList = sortByCost(list);
        return convertArrayListToString(availableList);
    }

    /**
     * Returns a list of objects sorted by time.
     *
     * @param <E> either of type Flight or of type Itinerary
     * @param list
     *            the list of objects to be sorted
     * @return a list of objects sorted by time
     */
    private static <E> String displayByTime(ArrayList<E> list) {
        ArrayList<E> availableList = sortByTime(list);
        return convertArrayListToString(availableList);
    }

    /**
     * Returns the string representation of ArrayList<E> list
     * @param list the ArrayList that is going to be converted to a string
     * @param <E> any type of ArrayList
     * @return the string representation of ArrayList<E> list
     */
    private static <E> String convertArrayListToString(ArrayList<E> list) {
        String result = "";
        for (E element : list) {
            result += element.toString() + "\n";
        }
        return result;
    }

    /**
     * Returns a list that is created by merging lists inside a list,
     * and the order of elements in the new list is the same as the input list
     *
     * @param resultInLists
     *            the list of list that will have its elements merged
     * @return a list that merged its elements, which were lists
     */
    private static <E> ArrayList<E> unwrap(
            Collection<ArrayList<E>> resultInLists) {
        ArrayList<E> result = new ArrayList<E>();
        for (ArrayList<E> list : resultInLists) {
            for (E element : list) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Removes E if given ArrayList<E> results is full and returns the remaining ArrayList
     * @param results a generic ArrayList of E
     * @param <E> type of the ArrayList
     * @return the remaining ArrayList<E>
     */
    private static <E> ArrayList<E> removeFullyBooked(ArrayList<E> results) {
        for (E element: results) {
            if (element instanceof Flight) {
                if (((Flight) element).isFull()) {
                    results.remove(element);
                }
            } else {
                if (((Itinerary) element).isFull()) {
                    results.remove(element);
                }
            }
        }
        return results;
    }

    /**
     * Returns a string representation of a list of flights sorted
     * by total travel time.
     *
     * @param flights
     *            the flights list that is going to be sorted
     * @return a string representation of a list of flights sorted
     * 		   by total travel time
     */
    public static String displayTimeFlights(ArrayList<Flight> flights) {
        return displayByTime(flights);
    }

    /**
     * Returns a string representation of a list of flights sorted
     * by total cost.
     *
     * @param flights
     *            the flights list that is going to be sorted
     * @return a string representation of a list of flights
     * 	       sorted by total cost
     */
    public static String displayCostFlights(ArrayList<Flight> flights) {
        return displayByCost(flights);
    }

    /**
     * Returns a string representation of a list of itineraries
     * sorted by total travel time.
     *
     * @param itineraries
     *            the itinerary list that is going to be sorted
     * @return a string representation of a list of itineraries
     * 		   sorted by total travel time
     */
    public static String displayTimeItineraries(
            ArrayList<Itinerary> itineraries) {
        return displayByTime(itineraries);
    }

    /**
     * Returns a string representation of a list of itineraries
     * sorted by their total cost.
     *
     * @param itineraries
     *            the itinerary list that is going to be sorted
     * @return a string representation of a list of itineraries
     *         sorted by total cost
     */
    public static String displayCostItineraries(
            ArrayList<Itinerary> itineraries) {
        return displayByCost(itineraries);
    }

    /**
     * Return the user type of the combination of the email and password entered.
     * If the email is not registered, return "Email address entered is not registered".
     * If the password is incorrect, return "Incorrect password".
     * @param email the email entered by the User
     * @param password the password entered the by User
     * @param file the password file which stores all valid login combinations
     * @return Return the user type of the combination of the email and password entered,
     *          or the corresponding error messages.
     */
    public static String logIn(String email, String password, File file) {
        try {
            Scanner passwordFile = new Scanner(new FileInputStream(file));
            String[] userInfo;
            while (passwordFile.hasNextLine()) {
                userInfo = passwordFile.nextLine().split(" ");
                if (userInfo[1].equals(email)) {
                    if (userInfo[2].equals(password)) {
                        if(userInfo[0].equals("Admin")){
                            passwordFile.close();
                            return userInfo[0];
                        }
                        else {

                            // need to load some Users into BookingApp before testing this
                            for (Client user : clients) {

                                if (user.getEmail().equals(email)) {
                                    currentClient = user;
                                    System.out.println(currentClient);
                                    passwordFile.close();
                                    return userInfo[0];
                                }
                            }
                        }
                    } else {
                        passwordFile.close();
                        return "Incorrect Password.";
                    }
                }
            }
            passwordFile.close();
            return "Email address entered is not registered.";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       return "Something went wrong, check method.";
    }

    /**
     * Returns the current user using the program
     * @return currentClient using the program
     */
    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client client) {
         currentClient = client;
    }

    public static void book(Itinerary itineraryToBook){
        for(Flight f: itineraryToBook.getFlights()){
            f.bookFlight();
        }
        currentClient.bookItinerary(itineraryToBook);
    }

    /**
     * Sets clients and flights of this BookingApp to empty.
     */
    public static void flush() {
        clients.clear();
        flights.clear();
    }

}

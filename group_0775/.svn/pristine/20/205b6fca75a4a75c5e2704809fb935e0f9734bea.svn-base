package group_0775.flightbookingapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jeremy on 27/11/2015.
 */
public class FlightManager implements Serializable {

    private static final long serialVersionUID = 8641290543921861926L;
    private Map<String, Flight> flights;
    private String filePath;
    private static final Logger logger =
            Logger.getLogger(FlightManager.class.getPackage().getName());
    private static final ConsoleHandler consoleHandler = new ConsoleHandler();

    /**
     * Creates a new empty FlightManager.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public FlightManager(File file) throws ClassNotFoundException, IOException {
        flights = new HashMap<String, Flight>();

        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        if (file.exists()) {
            readFromFile(file.getPath());
        } else {
            file.createNewFile();
        }
        this.filePath = file.getPath();
    }

    /**
     * Adds record to this FlightManager.
     * @param record a record to be added.
     */
    public void add(Flight record) {
        boolean unique = true;
        for(Flight f: flights.values()){
          if(f.getFlightNum().equals(record.getFlightNum())){
                unique = false;
            }
        }
       if(unique){
            flights.put(record.getFlightNum(), record);
            logger.log(Level.FINE, "Added a new flight " + record.toString());

        }

    }
    public void remove(String recordNum) {

                 flights.remove(recordNum);
    }

    /**
     * Writes the flights to serialized data file.
     */
    public void saveToFile() {

        try {
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            output.writeObject(flights);
            logger.log(Level.FINE, "Serialized flight manager.");
            output.close();
        } catch(IOException ex) {
            logger.log(Level.SEVERE,
                    "Cannot perform output. File I/O failed.", ex);
        }
    }

    /**
     * Reads serialized flight data from file at path and populates
     * this FlightManager's map with that data.
     * @param path the file path to the flight data
     */
    private void readFromFile(String path) {

        try {
            InputStream file = new FileInputStream(path);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            flights = (Map<String,Flight>) input.readObject();
            input.close();
            for (Flight r : flights.values()) {
               BookingApp.getFlightList().add(r);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Cannot read from input.", ex);
        }  catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Cannot find class.", ex);
        }
    }

    /**
     * Returns a string representation of FlightManager
     * @return result the string representing a FlightManager
     */
    @Override
    public String toString() {
        String result = "";
        for (Flight r : flights.values()) {
            result += r.toString() + "\n";
        }
        return result;
    }
}

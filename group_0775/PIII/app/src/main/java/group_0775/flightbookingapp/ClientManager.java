package group_0775.flightbookingapp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.InputStream;

/**
 * Created by Ken on 11/29/2015.
 */
public class ClientManager implements Serializable {

    private Map<String, Client> clients;
    private String filePath;

    public ClientManager(File file) throws ClassNotFoundException, IOException {
        clients = new HashMap<String, Client>();

        if (file.exists()) {
            readFromFile(file.getPath());
        } else {
            file.createNewFile();
        }

        this.filePath = file.getPath();
    }

    public void add(Client record) {
        boolean unique = true;
        for (Client c: clients.values()) {
            if (c.getEmail().equals(record.getEmail())) {
                unique = false;
            }
        }
        if (unique) {
            clients.put(record.getEmail(), record);
        }
    }

    public void remove(String email){
        clients.remove(email);
    }

    public void saveToFile() {
        try {
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            output.writeObject(clients);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String path) {
        try {
            InputStream file = new FileInputStream(path);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);

            clients = (Map<String, Client>) input.readObject();
            input.close();
            for (Client c: clients.values()) {
                BookingApp.getClientList().add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns the string representation of the ClientManager
     * @return the string representation of the ClientManager
     */
    public String toString() {
        String result = "";
        for (Client c: clients.values()) {
            result += c.toString() + "\n";
        }
        return result;
    }
}

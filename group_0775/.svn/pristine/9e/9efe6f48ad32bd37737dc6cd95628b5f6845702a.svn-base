package group_0775.flightbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String FLIGHTS_FILENAME = "flights.ser";
    public static final String FLIGHT_DATA_DIR = "flightdata";
    public static final String CLIENT_FILENAME = "clients.ser";
    public static final String CLIENT_DATA_DIR = "clientdata";
    public static final String USER_PASS_FILENAME = "password.txt";
    public static final String USER_PASS_DIR = "user_password";
    public static final String FLIGHT_MANAGER_KEY = "fightManagerKey";
    public static final String CLIENT_MANAGER_KEY = "clientManagerKey";
    private static FlightManager flightManager;
    private static ClientManager clientManager;
    private static String userTypeN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BookingApp.loadFlightsList("");
        //FlightManager manager = (FlightManager) getIntent().getSerializableExtra(MainActivity.FLIGHT_MANAGER_KEY);
        File flightdata = this.getApplicationContext().getDir(FLIGHT_DATA_DIR, MODE_PRIVATE);
        File flightsFile = new File(flightdata, FLIGHTS_FILENAME);

        File clientData = this.getApplicationContext().getDir(CLIENT_DATA_DIR, MODE_PRIVATE);
        File clientFile = new File(clientData, CLIENT_FILENAME);

        try {
            flightManager = new FlightManager(flightsFile);
            clientManager = new ClientManager(clientFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * Changes activity from MainActivity to SearchActivity
     * @param view
     */
    public void goToFlightSearch(View view){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);

    }

    /**
     * Changes activity from MainActivity to AdminPanelActivity
     * @param view
     */
    public void goToUpload(View view){
        Intent intent = new Intent(this, AdminPanel.class);
        intent.putExtra(FLIGHT_MANAGER_KEY, flightManager);
        intent.putExtra(CLIENT_MANAGER_KEY, clientManager);
        startActivity(intent);


    }

    public static void save(){
        flightManager.saveToFile();
        clientManager.saveToFile();
    }

    /**
     * Logs in the user
     * @param view
     * @throws IOException
     */
    public void logIn(View view) throws IOException {
        EditText emailField = (EditText) findViewById(R.id.email_field);
        String email = emailField.getText().toString();
        EditText passwordField = (EditText) findViewById(R.id.password_field);
        String password = passwordField.getText().toString();

        File passwordDir = this.getApplicationContext().getDir(USER_PASS_DIR, MODE_PRIVATE);
        File passwordFile = new File(passwordDir, USER_PASS_FILENAME);


        FileWriter writer = new FileWriter(passwordFile);
        writer.append("Client jane@email.com 123\n");
        writer.append("Admin admin admin");
        writer.flush();
        writer.close();

        String userType = BookingApp.logIn(email, password, passwordFile);
        userTypeN = userType;

        if (userType.equals("Admin")) {
            Intent intent = new Intent(this, AdminMain.class);
            intent.putExtra(FLIGHT_MANAGER_KEY, flightManager);
            intent.putExtra(CLIENT_MANAGER_KEY, clientManager);
            startActivity(intent);
        } else if (userType.equals("Client")) {
            Intent intent = new Intent(this, ClientActivity.class);
            intent.putExtra(FLIGHT_MANAGER_KEY, flightManager);
            intent.putExtra(CLIENT_MANAGER_KEY, clientManager);
            startActivity(intent);
        } else {
            TextView invalidInput = (TextView) findViewById(R.id.invalid_input_field);
            invalidInput.setText(userType);
        }
    }
}

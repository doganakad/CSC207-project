package group_0775.flightbookingapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class AdminPanel extends AppCompatActivity {
    private FileDialog flightFileDialog;
    private FileDialog userFileDialog;
    private File selectedFlightFile;
    private File selectedClientFile;


    /**\
     * Opens the Admin Flight Manager screen
     * @param savedInstanceState the Bundle data for any previous Instance States of
     * AdminPanel
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        File mPath = new File(Environment.getExternalStorageDirectory()+"");
        flightFileDialog = new FileDialog(this, mPath);
        userFileDialog = new FileDialog(this, mPath);
        userFileDialog.setFileEndsWith(".TXT");
        flightFileDialog.setFileEndsWith(".TXT");
        flightFileDialog.addFileListener(new FileDialog.FileSelectedListener() {
            public void fileSelected(File file) {

                Log.d(getClass().getName(), "selected file " + file.toString());
                EditText filePath = (EditText) findViewById(R.id.editTextFlightFileName);
                filePath.setText(file.toString());
            }
        });
        userFileDialog.addFileListener(new FileDialog.FileSelectedListener() {
            public void fileSelected(File file) {

                Log.d(getClass().getName(), "selected file " + file.toString());
                EditText filePath = (EditText) findViewById(R.id.editTextUserFileName);
                filePath.setText(file.toString());
            }
        });
    }

    /**
     * Opens the file picker
     * @param view the display information for the file picker
     */
    public void showFlightFilePicker(View view){
        flightFileDialog.showDialog();
    }

    public void showUserFilePicker(View view){
        userFileDialog.showDialog();
    }

    /**
     * Opens a list of saved flights
     * @param view the display information for the list of saved flights
     */
    public void goToSavedFlights(View view){
        Intent intent = new Intent(this, SavedFlights.class);
        intent.putExtra(MainActivity.FLIGHT_MANAGER_KEY,
                        getIntent().getSerializableExtra(
                        MainActivity.FLIGHT_MANAGER_KEY));
        startActivity(intent);
    }

    /**
     * Opens a list of saved users
     * @param view the display information for the list of saved users
     */
    public void goToSavedUsers(View view){
        Intent intent = new Intent(this, SavedUsers.class);
        intent.putExtra(MainActivity.CLIENT_MANAGER_KEY,
                getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY));
        startActivity(intent);
    }


    /**
     * Adds the flight data from a CSV file to the main list of flights in the program
     * @param view the display information for the upload screen
     */
    public void uploadFlightData(View view){
        EditText filePath = (EditText) findViewById(R.id.editTextFlightFileName);
        selectedFlightFile = new File(filePath.getText().toString());
        System.out.println(selectedFlightFile.exists());
        if(selectedFlightFile.exists()) {
            BookingApp.loadFlights(selectedFlightFile.getPath());
            FlightManager manager = (FlightManager) getIntent().getSerializableExtra(MainActivity.FLIGHT_MANAGER_KEY);
            for (Flight f : BookingApp.getFlightList()) {
                manager.add(f);
            }
            manager.saveToFile();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("The given flight csv file could not be found.")
                    .setTitle("Invalid File");

            builder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();

            dialog.show();

        }
    }

    /**
     * Adds the user data from a CSV file to the main list of users in the program
     * @param view the display information for the upload screen
     */
    public void uploadUserData(View view){
        EditText filePath = (EditText) findViewById(R.id.editTextUserFileName);
        selectedClientFile = new File(filePath.getText().toString());

        if(selectedClientFile.exists()) {

            BookingApp.loadClientsList(selectedClientFile.getPath());
            ClientManager manager = (ClientManager) getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY);
            for (Client c : BookingApp.getClientList()) {
                manager.add(c);
            }
            manager.saveToFile();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("The given user csv file could not be found.")
                    .setTitle("Invalid File");

            builder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();

            dialog.show();

        }
    }




}

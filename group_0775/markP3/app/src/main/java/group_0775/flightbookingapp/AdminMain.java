package group_0775.flightbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdminMain extends AppCompatActivity {

    /**
     * Creates a menu screen for admins
     * @param savedInstanceState the stored data of previous instances of AdminMain
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        if(BookingApp.getCurrentClient() != null) {
            ((TextView) findViewById(R.id.textViewSelectedClient)).setText(BookingApp.getCurrentClient().getEmail());
        }
        else{
            ((TextView) findViewById(R.id.textViewSelectedClient)).setText("Unselected");
        }
    }

    /**
     * Sends the user to the Admin Panel screen
     * @param view the display information for AdminMain
     */
    public void goToAdminPanel(View view){
        Intent intent = new Intent(this, AdminPanel.class);
        intent.putExtra(MainActivity.FLIGHT_MANAGER_KEY, getIntent().getSerializableExtra(MainActivity.FLIGHT_MANAGER_KEY));
        intent.putExtra(MainActivity.CLIENT_MANAGER_KEY, getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY));
        startActivity(intent);
    }

    /**
     * Sends the user to the Search screen
     * @param view the display information for AdminMain
     */
    public void goToSearch(View view){
        if(BookingApp.getCurrentClient() != null) {
            Intent intent = new Intent(this, Search.class);
            startActivity(intent);
        }
        else{
            Toast toast = Toast.makeText( getApplicationContext(),"You Must First Select A Client", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    /**
     * Sends the user to the Client Selection screen
     * @param view the display information for AdminMain
     */
    public void selectClient(View view){
        Intent intent = new Intent(this, SelectClient.class);
        startActivity(intent);
    }

    /**
     * Sends the user to the Client information screen for the selected client
     * @param view the display information for AdminMain
     */
    public void viewClient(View view){
        if (BookingApp.getCurrentClient() != null) {
            Intent intent = new Intent(this, ClientInfo.class);
            intent.putExtra("CLIENT", BookingApp.getCurrentClient());
            intent.putExtra(MainActivity.CLIENT_MANAGER_KEY,
                    getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY));
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "You Must First Select A Client", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    /**
     * View the booked itineraries of the selected Client.
     * @param view
     */
    public void goToBookings(View view){

        if (BookingApp.getCurrentClient() != null) {
        Intent intent = new Intent(this, ViewBookedItineraries.class);
        startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "You Must First Select A Client", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}

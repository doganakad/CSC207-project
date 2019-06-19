package group_0775.flightbookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedFlights extends Activity {
    private ListView lv;

    /**
     * Creates a list of saved Flights for the User
     * @param savedInstanceState the stored data of previous instances of SavedFlights
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_flights);
        lv = (ListView) findViewById(R.id.listViewFlights);

        ArrayList<String> flightStrings = new ArrayList<String>();
        for(Flight f: BookingApp.getFlightList()){
            flightStrings.add(f.toUIString());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
               flightStrings);

        lv.setAdapter(arrayAdapter);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                displayFlight(position);
            }
        });
    }

    /**
     * Displays the flights
     * @param position index of the flight to be displayed
     */
    private void displayFlight(int position){
        Intent displayFlight = new Intent(this, FlightDisplay.class);
        displayFlight.putExtra("DISPLAY_FLIGHT", BookingApp.getFlightList().get(position));
        displayFlight.putExtra("USER_TYPE","Admin");
        displayFlight.putExtra(MainActivity.FLIGHT_MANAGER_KEY,
                               getIntent().getSerializableExtra(
                                       MainActivity.FLIGHT_MANAGER_KEY));
        startActivity(displayFlight);

    }





        }

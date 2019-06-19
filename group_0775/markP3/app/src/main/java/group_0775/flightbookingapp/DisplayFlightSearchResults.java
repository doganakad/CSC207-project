package group_0775.flightbookingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayFlightSearchResults extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();

    ArrayAdapter<String> adapter;
    private ListView lv;
    private ArrayList<Flight> flightSearchResults ;

    /**
     * Creates a list of Flight search results
     * @param savedInstanceState the stored data of previous instances of DisplayFlightSearchResults
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_flight_search_results);
        ArrayList<View> Flights = new ArrayList<View>();
        flightSearchResults = (ArrayList<Flight>) getIntent().getSerializableExtra("FLIGHTS");
        lv = (ListView) findViewById(R.id.listViewFlightSearchResults);

        ArrayList<String> flightStrings = new ArrayList<String>();
        for(Flight f: flightSearchResults){
            flightStrings.add(f.toUIString());

        }
        if( flightSearchResults.isEmpty()){
            flightStrings.add("There were no search results.");
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
     * Displays the flight
     * @param position index of the flight that is being displayed
     */
    private void displayFlight(int position){
        Intent displayFlight = new Intent(this, FlightDisplay.class);
        displayFlight.putExtra("DISPLAY_FLIGHT", flightSearchResults.get(position));
        displayFlight.putExtra("USER_TYPE", "Client");

        startActivity(displayFlight);

    }

    /**
     * Books the flight
     * @param view
     */
    public void book_a_Flight(View view){
        for(Flight f: flightSearchResults){
            f.bookFlight();
        }

    }
}

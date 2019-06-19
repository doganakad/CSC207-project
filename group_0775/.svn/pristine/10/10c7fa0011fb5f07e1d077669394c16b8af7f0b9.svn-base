package group_0775.flightbookingapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class ViewBookedItineraries extends Activity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_booked_itineraries);

        lv = (ListView) findViewById(R.id.listViewBookedItineraries);

        ArrayList<String> itineraryStrings = new ArrayList<String>();
        ArrayList<Itinerary> bookedItineraries = ((Client) BookingApp.getCurrentClient()).getBookedItinerary();
        for (Itinerary i: bookedItineraries) {
            itineraryStrings.add(i.toUIString());
        }
        if (bookedItineraries.isEmpty()) {
            itineraryStrings.add("There is no booked itineraries");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itineraryStrings
        );

        lv.setAdapter(arrayAdapter);
    }

}

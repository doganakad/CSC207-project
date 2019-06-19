package group_0775.flightbookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ItineraryDisplay extends Activity {
    private Itinerary itineraryToDisplay;

    /**
     * Displays the information about a particular itinerary
     * @param savedInstanceState the stored data of previous instances of ItineraryDisplay
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_display);
        itineraryToDisplay = (Itinerary) getIntent().getSerializableExtra("DISPLAY_ITINERARY");
        ((TextView) findViewById(R.id.textViewIOD)).setText(itineraryToDisplay.getOrigin());
        ((TextView) findViewById(R.id.textViewIdestD)).setText(itineraryToDisplay.getDestination());
        ((TextView) findViewById(R.id.textViewITTDisplay)).setText(itineraryToDisplay.getTime());
        ((TextView) findViewById(R.id.textViewITCDisplay)).setText(itineraryToDisplay.getCost()+"");
        boolean checkOriginScreen = getIntent().getBooleanExtra("FROM_SEARCH", false);

        if(checkOriginScreen){
            findViewById(R.id.buttonBook).setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.buttonBook).setVisibility(View.GONE);
        }
    }

    /**
     * Books the selected itinerary for the user
     * @param view the display information for ItineraryDisplay
     */
    public void book(View view){
        BookingApp.book((Itinerary) getIntent().getSerializableExtra("DISPLAY_ITINERARY"));
        Intent backToHome = new Intent(this, ClientActivity.class);
        Toast toast = Toast.makeText( getApplicationContext(),"Itinerary Booked!", Toast.LENGTH_LONG);
        toast.show();
        MainActivity.save();
        startActivity(backToHome);
    }

    public void displayFlights(View view){
        Intent intent = new Intent(this, DisplayFlightSearchResults.class);
        intent.putExtra("FLIGHTS",
                new ArrayList<Flight>(Arrays.asList(itineraryToDisplay.getFlights())));
        startActivity(intent);

    }

}

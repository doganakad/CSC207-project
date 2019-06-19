package group_0775.flightbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FlightDisplay extends AppCompatActivity {
    private Flight flight;
    private String userType;

    /**
     * Creates a FlightDisplay to show data for a flight
     * @param savedInstanceState the stored data of previous instances of FlightDisplay
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_display);
        flight = (Flight) getIntent().getSerializableExtra("DISPLAY_FLIGHT");
        userType = (String) getIntent().getSerializableExtra("USER_TYPE");

        ((TextView) findViewById(R.id.editTextFlightNumberDisplay)).setText(flight.getFlightNum());
        ((TextView) findViewById(R.id.editTextOriginCityDisplay)).setText(flight.getOrigin());
        ((TextView) findViewById(R.id.editTextDestinationCityDisplay)).setText(flight.getDestination());
        ((TextView) findViewById(R.id.editTextFlightDepartureDateDisplay)).setText(flight.getDepartureDateString());
        ((TextView) findViewById(R.id.editTextFlightDepartureTimeDisplay)).setText(flight.getDepartureTimeString());
        ((TextView) findViewById(R.id.editTextFlightArrivalDateDisplay)).setText(flight.getArrivalDateString());
        ((TextView) findViewById(R.id.editTextFlightArrivalTimeDisplay)).setText(flight.getArrivalTimeString());
        ((TextView) findViewById(R.id.TextTotalSeatsDisplay)).setText(flight.getNumSeats()+"");
        ((TextView) findViewById(R.id.editTextSeatsDisplay)).setText(flight.getRemainingSeats()+"");
        ((TextView) findViewById(R.id.editTextCostDisplay)).setText(flight.getCost()+"");
        ((TextView) findViewById(R.id.editTextAirlineDisplay)).setText(flight.getAirline());

        if(userType.equals("Admin")){
            ((Button)findViewById(R.id.optionButton)).setText("Edit Flight");
        }
        else{
            ((Button)findViewById(R.id.optionButton)).setVisibility(View.GONE);
        }


    }

    /**
     * Allows admins to edit Flight information
     * @param view the display information for FlightDisply
     */
    public void preformAction(View view){
        if(this.userType.equals("Admin")){
            Intent editFlight = new Intent(this, FlightEdit.class);
            editFlight.putExtra("FLIGHT", this.flight);
            editFlight.putExtra(MainActivity.FLIGHT_MANAGER_KEY,
                    getIntent().getSerializableExtra(
                            MainActivity.FLIGHT_MANAGER_KEY));
            startActivity(editFlight);
        }
        else{

        }
    }

}

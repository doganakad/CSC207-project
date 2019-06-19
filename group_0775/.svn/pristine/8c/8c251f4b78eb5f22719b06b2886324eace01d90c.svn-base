package group_0775.flightbookingapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FlightEdit extends Activity {
    private Flight flight;
    private EditText flightNum;
    private EditText origin;
    private EditText destination;
    private EditText departureDate;
    private EditText departureTime;
    private EditText arrivalDate;
    private EditText arrivalTime;
    private EditText numSeatsl;
    private EditText seatsRemaining;
    private EditText cost;

    /**
     * Opens a FlightEdit screen that allows an admin to edit Flight information
     * @param savedInstanceState the stored data of previous instances of FlightEdit
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_edit);
        this.flight = (Flight) getIntent().getSerializableExtra("FLIGHT");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please note that the flight information editing "
                         + "page assumes all entered information is correct "
                         + "and in the properly accepted format,")
                .setTitle("Message to Admin");

        builder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();


        ((EditText) findViewById(R.id.editTextFlightNumberDisplay)).setText(flight.getFlightNum());
        ((EditText) findViewById(R.id.editTextOriginCityDisplay)).setText(flight.getOrigin());
        ((EditText) findViewById(R.id.editTextDestinationCityDisplay)).setText(flight.getDestination());
        ((EditText) findViewById(R.id.editTextFlightDepartureDateDisplay)).setText(flight.getDepartureDateString());
        ((EditText) findViewById(R.id.editTextFlightDepartureTimeDisplay)).setText(flight.getDepartureTimeString());
        ((EditText) findViewById(R.id.editTextFlightArrivalDateDisplay)).setText(flight.getArrivalDateString());
        ((EditText) findViewById(R.id.editTextFlightArrivalTimeDisplay)).setText(flight.getArrivalTimeString());
        ((EditText) findViewById(R.id.editTextTotalSeatsDisplay)).setText(flight.getNumSeats()+"");
        ((EditText) findViewById(R.id.editTextSeatsDisplay)).setText(flight.getRemainingSeats()+"");
        ((EditText) findViewById(R.id.editTextCostDisplay)).setText(flight.getCost()+"");
        ((EditText) findViewById(R.id.editTextAirlineDisplay)).setText(flight.getAirline());

    }

    /**
     * Saves the edited Flight data
     * @param view the display information for FlightEdit
     */
    public void save(View view){
        FlightManager manager = (FlightManager)
                getIntent().getSerializableExtra(
                        MainActivity.FLIGHT_MANAGER_KEY);
        manager.remove(flight.getFlightNum());
        for(int f = 0; f < BookingApp.getFlightList().size(); f++){
           if( BookingApp.getFlightList().get(f).getFlightNum().equals(flight.getFlightNum())){
               BookingApp.getFlightList().remove(f);
           }
       }

        Flight editedFlight = new Flight(
                ((EditText) findViewById(R.id.editTextFlightNumberDisplay)).getText().toString(),
                ((EditText) findViewById(R.id.editTextFlightDepartureDateDisplay)).getText().toString() + " "
                        + ((EditText) findViewById(R.id.editTextFlightDepartureTimeDisplay)).getText().toString(),
                ((EditText) findViewById(R.id.editTextFlightArrivalDateDisplay)).getText().toString() + " "
        + ((EditText) findViewById(R.id.editTextFlightArrivalTimeDisplay)).getText().toString(),
                ((EditText) findViewById(R.id.editTextAirlineDisplay)).getText().toString(),
                ((EditText) findViewById(R.id.editTextOriginCityDisplay)).getText().toString(),
                ((EditText) findViewById(R.id.editTextDestinationCityDisplay)).getText().toString(),
                Double.parseDouble(((EditText) findViewById(R.id.editTextCostDisplay)).getText().toString()),
                Integer.parseInt(((EditText) findViewById(R.id.editTextTotalSeatsDisplay)).getText().toString()));
        editedFlight.setRemainingSeats(
                Integer.parseInt(((EditText) findViewById(R.id.editTextTotalSeatsDisplay)).getText().toString())
                        - (flight.getNumSeats() - flight.getRemainingSeats()));

        manager.add(editedFlight);
        BookingApp.getFlightList().add(editedFlight);
        manager.saveToFile();
        Intent intent = new Intent(this, AdminMain.class);
        intent.putExtra(MainActivity.FLIGHT_MANAGER_KEY,
                getIntent().getSerializableExtra(
                        MainActivity.FLIGHT_MANAGER_KEY));
        Toast toast = Toast.makeText( getApplicationContext(),"Flight Edit Successful", Toast.LENGTH_LONG);
        toast.show();
        startActivity(intent);


    }
}

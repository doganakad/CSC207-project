package group_0775.flightbookingapp;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Search extends AppCompatActivity {


    /**
     * Creates a search screen
     * @param savedInstanceState the stored data of previous instances of Search
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    /**
     * Opens a date picker box
     * @param v the display information for search
     */
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    /**
     * Searches for itineraries or flights based on the departure date, origin city and destination
     * city that were entered
     * @param view the display information for search
     */
    public void search(View view){
        String departureDate = ((EditText) findViewById(R.id.editTextDepartureDate)).getText().toString().trim();
        String originCity =  ((EditText) findViewById(R.id.editTextOriginCity)).getText().toString().trim();
        String destinationCity = ((EditText) findViewById(R.id.editTextDestinationCity)).getText().toString().trim();
        if(checkSearchTerms(departureDate, originCity, destinationCity)) {
            if (((RadioButton) findViewById(R.id.radioButtonSearchFlights)).isChecked()) {
                Intent displayFlights = new Intent(this, DisplayFlightSearchResults.class);
                displayFlights.putExtra("FLIGHTS", BookingApp.searchFlights(
                        departureDate, originCity, destinationCity));
                startActivity(displayFlights);
            } else {
                if (((RadioButton) findViewById(R.id.radioButtonSortCost)).isChecked()){

                    Intent displayItineraries = new Intent(this, DisplayItinerarySearchResults.class);
                    displayItineraries.putExtra("ITINERARIES", BookingApp.sortByCost(BookingApp.searchItineraries(
                            departureDate, originCity, destinationCity)));
                    startActivity(displayItineraries);

                }
                else{
                    Intent displayItineraries = new Intent(this, DisplayItinerarySearchResults.class);
                    displayItineraries.putExtra("ITINERARIES",(BookingApp.sortByTime(BookingApp.searchItineraries(
                            departureDate, originCity, destinationCity))));
                    startActivity(displayItineraries);

                }

            }
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("One or more of the entered search terms was/were invalid.")
                    .setTitle("Could Not Search");

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
     * Checks to make sure all the search criteria has been entered correctly
     * @param date the date of the itinerary or flight
     * @param origin the origin city of the itinerary or flight
     * @param destination the destination city of the itinerary or flight
     * @return true if all information was entered correctly and false otherwise
     */
    private boolean checkSearchTerms(String date, String origin, String destination){
        Pattern p = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        boolean dateCorrect = p.matcher(date).matches();
        return dateCorrect && !origin.isEmpty() && !destination.isEmpty();
    }

    /**
     * Makes the sorting options visible
     * @param view the display information for search
     */
    public void showSortOptions(View view){
        findViewById(R.id.radioGroupSort).setVisibility(view.VISIBLE);
    }

    /**
     * Hides the sorting options
     * @param view the display information for search
     */
    public void hideSortOptions(View view) {
        findViewById(R.id.radioGroupSort).setVisibility(view.GONE);
    }




    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        /**
         * Creates a new Date Picker Object
         * @param savedInstanceState the stored data of previous instances of DatePickerFragment
         * @return a new DatePickerDialog
         */
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        /**
         * Selects a date and converts it to a string format
         * @param view the display information for the Date Picker Object
         * @param year the year of the date
         * @param month the month of the date
         * @param day the day of the date
         */
        public void onDateSet(DatePicker view, int year, int month, int day) {
            String date = year + "-" + new DecimalFormat("00").format(month+ 1) + "-"
                    + new DecimalFormat("00").format(day);
            EditText showDate = (EditText)getActivity().findViewById(R.id.editTextDepartureDate);
            showDate.setText(date);


        }
    }

    }

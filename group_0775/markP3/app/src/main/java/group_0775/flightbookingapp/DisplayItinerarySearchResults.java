package group_0775.flightbookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayItinerarySearchResults extends Activity {
    private ListView lv;
    private ArrayList<Itinerary> searchedIteraries;

    /**
     * Creates a list of Itinerary search results
     * @param savedInstanceState the stored data of previous instances of
     *                           DisplayItinerarySearchResults
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_itinerary_search_results);

        lv = (ListView) findViewById(R.id.listViewItinerarySearchResults);

        searchedIteraries = (ArrayList<Itinerary>) getIntent().getSerializableExtra("ITINERARIES");

        ArrayList<String> itineraryStrings = new ArrayList<String>();
        for(Itinerary i: searchedIteraries){
            itineraryStrings.add(i.toUIString());

        }
        if( searchedIteraries.isEmpty()){
            itineraryStrings.add("There were no search results.");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itineraryStrings);

        lv.setAdapter(arrayAdapter);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                displayItinerary(position);
            }
        });
    }

    /**
     * Displays the itinerary
     * @param position index of the itinerary that is being displayed
     */
    private void displayItinerary(int position){
        Intent displayItinerary = new Intent(this, ItineraryDisplay.class);
        displayItinerary.putExtra("DISPLAY_ITINERARY", searchedIteraries.get(position));
        displayItinerary.putExtra("FROM_SEARCH", true);
        startActivity(displayItinerary);
    }
//
//    /**
//     * Books an itinerary
//     * @param view the View component
//     */
//    public void book_an_itinerary(View view){
//        User user = BookingApp.getCurrentClient();
//        for(Itinerary i: searchedIteraries){
//            ((Client) user).bookItinerary(i);
//        }
//    }
}

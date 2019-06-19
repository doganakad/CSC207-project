package group_0775.flightbookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectClient extends Activity {
    private ListView lv;

    /**
     * Creates a list of clients that can be selected
     * @param savedInstanceState the stored data of previous instances of SelectClient
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_client);
        lv = (ListView) findViewById(R.id.listViewSelectClient);

        ArrayList<String> userStrings = new ArrayList<String>();
        for(Client u : BookingApp.getClientList()){
            userStrings.add(u.toUIString());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                userStrings);

        lv.setAdapter(arrayAdapter);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                selectClient(position);
            }
        });
    }

    /**
     * Displays the users
     * @param position index of the user to be displayed
     */
    private void selectClient(int position){
        BookingApp.setCurrentClient(BookingApp.getClientList().get(position));
        Intent intent = new Intent (this, AdminMain.class);
        startActivity(intent);


    }



}

package group_0775.flightbookingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SavedUsers extends Activity {
    private ListView lv;

    /**
     * Creates a list of saved Users
     * @param savedInstanceState the stored data of previous instances of SavedUsers
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_users);
        lv = (ListView) findViewById(R.id.listViewSavedUsers);

        ArrayList<String> userStrings = new ArrayList<String>();
        for(User u : BookingApp.getClientList()){
            userStrings.add(u.toString());
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
                displayUser(position);
            }
        });
    }

    /**
     * Displays the users
     * @param position index of the user to be displayed
     */
    private void displayUser(int position){
        Intent intent = new Intent (this, ClientInfo.class);
        BookingApp.setCurrentClient(BookingApp.getClientList().get(position));
        intent.putExtra("CLIENT", BookingApp.getClientList().get(position));
        intent.putExtra(MainActivity.CLIENT_MANAGER_KEY,
                getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY));
        startActivity(intent);


    }





}


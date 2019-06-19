package group_0775.flightbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ClientActivity extends AppCompatActivity {
    private Client currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        currentUser = BookingApp.getCurrentClient();
    }

    /**
     * Changes activity from ClientActivity to SearchActivity
     * @param view the View component
     */
    public void goToSearch(View view) {
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }

    /**
     * Views the personal information of the user
     * @param view
     */
    public void viewPersonalInformation(View view) {
        Intent intent = new Intent(this, ClientInfo.class);
        intent.putExtra("CLIENT", currentUser);
        intent.putExtra(MainActivity.CLIENT_MANAGER_KEY,
                getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY));
        startActivity(intent);

    }

    /**
     * Changes activity from ClientActivity to ViewBookedItineraries
     * @param view
     */
    public void viewBookedItineraries(View view) {
        Intent intent = new Intent(this, ViewBookedItineraries.class);
        startActivity(intent);
    }
}
package group_0775.flightbookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ClientInfo extends AppCompatActivity {

    private User cur_user;
    private TextView first_name;
    private TextView last_name;
    private TextView credit_card_no;
    private TextView email;
    private TextView address;
    private TextView credit_card_expiry;
    private Client clientToDisplay;

    /**
     * Creates a new client info display
     * @param savedInstanceState the stored data of previous instances of ClientInfo
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_info);
        clientToDisplay = (Client) getIntent().getSerializableExtra("CLIENT");
        ((TextView) findViewById(R.id.textViewFirstNameDisplay)).setText(clientToDisplay.getFirstName());
        ((TextView) findViewById(R.id.textViewLastNameDisplay)).setText(clientToDisplay.getLastName());
        ((TextView) findViewById(R.id.textViewEmailDisplay)).setText(clientToDisplay.getEmail());
        ((TextView) findViewById(R.id.textViewAddressDisplay)).setText(clientToDisplay.getAddress());
        ((TextView) findViewById(R.id.textViewCreditCardDisplay)).setText(clientToDisplay.getCreditCardNumber());
        ((TextView) findViewById(R.id.textViewCreaditCardEDisplay)).setText(clientToDisplay.getExpiryDateString());
    }

    public void edit(View view){
        Intent editClient = new Intent(this, EditClientInfo.class);
        editClient.putExtra(MainActivity.CLIENT_MANAGER_KEY,
                getIntent().getSerializableExtra(MainActivity.CLIENT_MANAGER_KEY));
        startActivity(editClient);
    }
}

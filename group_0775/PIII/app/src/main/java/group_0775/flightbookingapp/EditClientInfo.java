package group_0775.flightbookingapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class EditClientInfo extends Activity {

    private Client clientToEdit;

    /**
     * Creates an screen where a client's information can be edited
     * @param savedInstanceState the stored data of previous instances of EditClientInfo
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client_info);
        clientToEdit = BookingApp.getCurrentClient();

        ((EditText) findViewById(R.id.editTextFirstName)).setText(clientToEdit.getFirstName());
        ((EditText) findViewById(R.id.editTextLastName)).setText(clientToEdit.getLastName());
        ((EditText) findViewById(R.id.editTextEmail)).setText(clientToEdit.getEmail());
        ((EditText) findViewById(R.id.editTextAddress)).setText(clientToEdit.getAddress());
        ((EditText) findViewById(R.id.editTextCreditCard)).setText(clientToEdit.getCreditCardNumber());
        ((EditText) findViewById(R.id.editTextCCExpiry)).setText(clientToEdit.getExpiryDateString());
    }

    /**
     * Saves the edited client information
     * @param view the display information for EditClientInfo
     */
    public void saveClient(View view){
        Client editedClient = clientToEdit;
        ClientManager manager = (ClientManager)
                getIntent().getSerializableExtra(
                        MainActivity.CLIENT_MANAGER_KEY);


        editedClient.setFirstName(((EditText) findViewById(R.id.editTextFirstName)).getText().toString());
        editedClient.setLastName(((EditText) findViewById(R.id.editTextLastName)).getText().toString());
        editedClient.setEmail(((EditText) findViewById(R.id.editTextEmail)).getText().toString());
        editedClient.setAddress(((EditText) findViewById(R.id.editTextAddress)).getText().toString());
        editedClient.setCreditCardNumber(((EditText) findViewById(R.id.editTextCreditCard)).getText().toString());
        String expiryDate = ((EditText) findViewById(R.id.editTextCCExpiry)).getText().toString();
        editedClient.setExpiryDate(new GregorianCalendar(
                Integer.parseInt(expiryDate.substring(0, 4)),
                Integer.parseInt(expiryDate.substring(5, 7)),
                Integer.parseInt(expiryDate.substring(8, 10))));

        manager.remove(clientToEdit.getEmail());
        for(int c = 0; c < BookingApp.getClientList().size(); c++){
            if( BookingApp.getClientList().get(c).getEmail().equals(clientToEdit.getEmail())){
                BookingApp.getClientList().remove(c);
            }
        }

        manager.add(editedClient);
        BookingApp.getClientList().add(editedClient);
        BookingApp.setCurrentClient(editedClient);
        manager.saveToFile();
        Toast toast = Toast.makeText( getApplicationContext(),"Information Saved!", Toast.LENGTH_LONG);
        toast.show();
    }
}

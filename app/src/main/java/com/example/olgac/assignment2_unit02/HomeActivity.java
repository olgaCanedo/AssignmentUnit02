package com.example.olgac.assignment2_unit02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getOrder()) {
            case 10:
                displayToast(getString(R.string.action_tutor));
                //final Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                //startActivity(intent);
                return true;

            case 20:
                displayToast(getString(R.string.action_favorites));
                Log.d(TAG, "You selected Favorites.");
                return true;

            case 15:
                displayToast(getString(R.string.action_campus));
                final Intent intentMain = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intentMain);
                return true;

            case 30:
                displayToast(getString(R.string.action_settings));
                Log.d(TAG, "You selected Settings.");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.btHialeah:
                if (checked) {
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Hialeah));
                }
                break;
            case R.id.btInterAmerican:
                if (checked) {
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.InterAmerican));
                }
                break;
            case R.id.btWest:
                if (checked){
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.West));
                }
                break;
            case R.id.btWolfson:
                if (checked) {
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Wolfson));
                }
                break;
            case R.id.btNorth:
                if (checked) {
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.North));
                }
                break;
            case R.id.btKendall:
                if (checked) {
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Kendall));
                }
                break;
            case R.id.btHomestead:
                if (checked) {
                    //Intent intent = new Intent(getApplicationContext(), TutorsActivity.class);
                    //startActivity(intent);
                    displayToast(getString(R.string.chosen) +
                            getString(R.string.Homestead));
                }
                break;
            default:
                Log.d(TAG, getString(R.string.nothing_clicked));
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

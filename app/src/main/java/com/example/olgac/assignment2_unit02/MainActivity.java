package com.example.olgac.assignment2_unit02;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSign(View view) {
        DialogFragment customFragment = SignInFragment.newInstance();
        customFragment.show(getSupportFragmentManager(), "custom");
    }
}

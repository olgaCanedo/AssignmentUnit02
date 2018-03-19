package com.example.olgac.assignment2_unit02;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInFragment extends DialogFragment {

    private View view;
    private EditText showUser;
    private String userSF;
    private EditText showPass;
    private String passwordSF;
    private SharedPreferences sharedPrefer;

    public SignInFragment() {
        // Required empty public constructor
    }

    public static SignInFragment newInstance() {
        SignInFragment fragment = new SignInFragment();
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        sharedPrefer = getActivity().getSharedPreferences("UserPrefer", Context.MODE_PRIVATE);
        //Reading the username from the shared preferences
        String  savedUserName = sharedPrefer.getString("userName", null);
        String  savedPassword = sharedPrefer.getString("password", null);

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        view = inflater.inflate(R.layout.dialog_signin, null);

        showUser = (EditText) view.findViewById(R.id.username);
        showPass = (EditText) view.findViewById(R.id.password);
        showUser.setText(savedUserName);
        showPass.setText(savedPassword);

        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        // sign in the user ...
                        userSF= showUser.getText().toString();
                        passwordSF= showPass.getText().toString();

                        SharedPreferences.Editor myEditor = sharedPrefer.edit();
                        myEditor.putString("userName",userSF);
                        myEditor.putString("password",passwordSF);
                        myEditor.apply();

                        if (passwordSF.equals("hardcoded")) {

                            // Create an Intent to start the second activity
                            Intent intent = new Intent(getContext(), HomeActivity.class);
                            // Start the new activity.
                            startActivity(intent);

                            Toast toast = Toast.makeText(getContext(), "Hello " + userSF + "! Your password is " + passwordSF, Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP, 10, 10);
                            toast.show();
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getActivity(), "Incorrect password ", Toast.LENGTH_LONG);
                            toast.show();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SignInFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
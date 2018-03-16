package com.example.olgac.assignment2_unit02;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

public class SignInFragment extends DialogFragment {

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
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_signin, null))
                // Add action buttons
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        final EditText showPass = (EditText) getDialog().findViewById(R.id.password);
                        if (showPass.getText().toString().equals("hardcoded")) {
                            // Create an Intent to start the second activity
                            Intent intent = new Intent(getContext(), HomeActivity.class);
                            // Start the new activity.
                            startActivity(intent);
                        }
                        else
                        {
                            Toast toast = Toast.makeText(getActivity(), "Incorrect password ", Toast.LENGTH_LONG);
                            toast.show();
                        }
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
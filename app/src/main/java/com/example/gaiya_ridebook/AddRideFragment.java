package com.example.gaiya_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddRideFragment extends DialogFragment {
    ListView ridesList;
    private EditText rideDate;
    private EditText rideTime;
    private EditText rideDistance;
    private EditText rideSpeed;
    private EditText rideCadance;
    private EditText rideComment;
//    private int rideID;

    private OnFragementInteractionListener listener;
    public interface OnFragementInteractionListener{
        void onOkPressed(Rides newRide);
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragementInteractionListener){
            listener = (OnFragementInteractionListener) context;
        }else {
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteraction Listener");
        }

    }
    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.hasText(rideCadance)) ret = false;
        if (!Validation.isPosDec(rideSpeed,true)) ret = false;
        if (!Validation.isPosDec(rideDistance,true)) ret = false;
        if (!Validation.isDate(rideDate, true)) ret = false;
        if (!Validation.isTime(rideTime, true)) ret = false;

        return ret;
    }

    @Nullable
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_ride_fragment,null);
//        rideID = (int)(Math.random() * 50 + 1);
        rideDate = view.findViewById(R.id.date);
        rideTime = view.findViewById(R.id.time);
        rideDistance = view.findViewById(R.id.distance);
        rideSpeed = view.findViewById(R.id.ave_speed);
        rideCadance = view.findViewById(R.id.ave_cadence);
        rideComment = view.findViewById(R.id.comment);

        //Check if Date is there and Valid
        rideDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                Validation.isDate(rideDate,true);
            }
        });

        //Check if Time is Valid and There
        rideTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Validation.isTime(rideTime,true);
            }
        });

        //Check if the Distance and Valid is there
        rideDistance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Validation.isPosDec(rideDistance,true);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Validation.isPosDec(rideDistance,true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Validation.isPosDec(rideDistance,true);
            }
        });

        //Check if the Speed  and Valid is there
        rideSpeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Validation.isPosDec(rideSpeed,true);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Validation.isPosDec(rideSpeed,true);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Validation.isPosDec(rideSpeed,true);
            }
        });


        //Check if the Cadence is there
        rideCadance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Validation.hasText(rideCadance);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Validation.hasText(rideCadance);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Validation.hasText(rideCadance);
            }
        });




        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Add Ride")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
//                                int id =rideID;

                                String d = rideDate.getText().toString();
                                String t = rideTime.getText().toString();
                                Double   dst = new Double(rideDistance.getText().toString());
                                Double   speed = new Double(rideSpeed.getText().toString());
                                String cadance = rideCadance.getText().toString();
                                String comment = rideComment.getText().toString();
                                if ( checkValidation () )
                                    listener.onOkPressed((new Rides(dst,speed,cadance,comment,d,t)));
                                else
                                    Toast.makeText(getActivity(), "Form contains Errors. Try Again", Toast.LENGTH_LONG).show();

                            }
                        }
                ).create();
    }

}

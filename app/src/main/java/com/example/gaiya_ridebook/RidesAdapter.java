package com.example.gaiya_ridebook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class RidesAdapter extends ArrayAdapter<Rides> {
    private Context context;
    private ArrayList<Rides> ridesModelArrayList;

    public RidesAdapter(Context context, ArrayList<Rides> ridesModelArrayList){
        super(context,0,ridesModelArrayList);
        this.context = context;
        this.ridesModelArrayList = ridesModelArrayList;
    }


    @Nullable
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        }
        Rides rides = ridesModelArrayList.get(position);
        TextView rideDistance = view.findViewById(R.id.distance);
        TextView rideDate = view.findViewById(R.id.date);
        TextView rideTime = view.findViewById(R.id.time);
        rideDistance.setText(Double.toString(rides.getRideDistance()));
        rideDate.setText(rides.getDate());
        rideTime.setText(rides.getTime());
        return view;

    }
}


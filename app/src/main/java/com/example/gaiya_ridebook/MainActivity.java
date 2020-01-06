package com.example.gaiya_ridebook;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaiya_ridebook.R;
import com.example.gaiya_ridebook.Rides;
import com.example.gaiya_ridebook.RidesAdapter;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AddRideFragment.OnFragementInteractionListener, EditRideFragment.OnFragementInteractionListener{


    ArrayList<Rides> ridesModelArrayList;
    ListView listView;
    ArrayAdapter<Rides> ridesAdapter;
    Rides selectedItem =null;
    Double get_distance;
    String get_date;
    String get_time;
    String get_cadance;
    String get_comment;
    Double get_speed;
    Double totalDist = 0.0;
    TextView totalView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        totalView =findViewById(R.id.total_distance);


        Double[] RideDistance = {};
        String[] Date = {};
        String[] Time = {};
        String[] Comment = {};
        Double[] Speed = {};
        String[] Cadance = {};
//        int[] id = {};

        ridesModelArrayList = new ArrayList<>();
        for (int i = 0; i < RideDistance.length; i++) {
            ridesModelArrayList.add((new Rides(RideDistance[i],Speed[i],Cadance[i],Comment[i], Date[i],Time[i])));
            addDist(RideDistance[i]);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Rides item = ridesModelArrayList.get(position);
                selectedItem = item;
                view.setSelected(true);

            }
        });

        ridesAdapter = new RidesAdapter(this,ridesModelArrayList);
        listView.setAdapter(ridesAdapter);
        Log.d("RideAdapter", ridesAdapter.toString());
        final FloatingActionButton addRideButton = findViewById(R.id.add_ride_button);
        addRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddRideFragment().show(getSupportFragmentManager(), "ADD_RIDE");
            }
        });
        final FloatingActionButton viewButton = findViewById(R.id.view_button);

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItem!=null){
                    Intent intent = new Intent(MainActivity.this, Display.class);
//                String rID = Integer.toString(selectedItem.getRideID());
                    //Rides s = selectedItem;
                    String rDistance = Double.toString(selectedItem.getRideDistance());
                    String rDate = selectedItem.getDate();
                    String rTime = selectedItem.getTime();
                    String rSpeed = Double.toString(selectedItem.getAverageSpeed());
                    String rCadence= selectedItem.getAverageCadence();
                    String rComment = selectedItem.getComment();

//                intent.putExtra("id", rID);
                    intent.putExtra("distance", rDistance);
                    intent.putExtra("date", rDate);
                    intent.putExtra("time", rTime);
                    intent.putExtra("speed", rSpeed);
                    intent.putExtra("cadence", rCadence);
                    intent.putExtra("comment", rComment);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "You have not selected anything", Toast.LENGTH_LONG).show();
                }



            }
        });
        final FloatingActionButton editRideButton = findViewById(R.id.edit_button);
        editRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItem != null){
                    get_distance = selectedItem.getRideDistance();
                    get_cadance = selectedItem.getAverageCadence();
                    get_date = selectedItem.getDate();
                    get_time = selectedItem.getTime();
                    get_speed = selectedItem.getAverageSpeed();
                    get_comment = selectedItem.getComment();


                    new EditRideFragment().show(getSupportFragmentManager(), "EDIT_RIDE");
                }else{
                    Toast.makeText(MainActivity.this, "You have not selected anything", Toast.LENGTH_LONG).show();
                }

//                selectedItem = null;

            }

        });

    }
    public void subDist( double dist){
        totalDist = totalDist - dist;
        totalView.setText("Total Distance  : "+ Double.toString(totalDist));

    }


    public void addDist( double dist){
        totalDist = totalDist + dist;
        totalView.setText("Total Distance  : "+ Double.toString(totalDist));

    }



    public void deleteRide(View view) {
        // Do something in response to button.class);
//        Log.d(ridesModelArrayList.)
        if (selectedItem != null) {
            subDist(selectedItem.getRideDistance());
            ridesAdapter.remove(selectedItem);
//            ridesAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(MainActivity.this, "You have not selected anything", Toast.LENGTH_LONG).show();
        }
    }



////

    @Override
    public void onOkPressed(Rides newRide) {
        ridesAdapter.add(newRide);
        addDist(newRide.getRideDistance());
    }


    @Override
    public void onEditPressed(Double distance, Double speed, String cadance, String comment, String date, String time) {
        subDist(selectedItem.getRideDistance());
        selectedItem.setTime(time);
        selectedItem.setDate(date);
        selectedItem.setRideDistance(distance);
        selectedItem.setAverageCadence(cadance);
        selectedItem.setComment(comment);
        selectedItem.setAverageSpeed(speed);
        ridesAdapter.notifyDataSetChanged();
        addDist(distance);


    }

    @Override
    public Double getDist() {
        return get_distance;
    }

    @Override
    public Double getSp() {
        return get_speed;
    }

    @Override
    public String  getC() {
        return get_cadance;
    }

    @Override
    public String getComm() {
        return get_comment;
    }

    @Override
    public String getT() {
        return get_time;
    }

    @Override
    public String getD() {
        return get_date;
    }
}
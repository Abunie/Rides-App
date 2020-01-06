package com.example.gaiya_ridebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Getting Selected Item
        ListView listView = findViewById(R.id.listView);



        //Ride Distance
        String rDistance = getIntent().getStringExtra("distance");
        TextView viewDistance = (TextView) findViewById(R.id.viewDistance);
        viewDistance.setText("Ride Distance: " + rDistance);

        //Ride Date
        String rDate = getIntent().getStringExtra("date");
        TextView viewDate = (TextView) findViewById(R.id.viewDate);
        viewDate.setText("Ride Date: " + rDate);

        //Ride Date
        String rTime = getIntent().getStringExtra("time");
        TextView viewTime = (TextView) findViewById(R.id.viewTime);
        viewTime.setText("Ride Time: " + rTime);

        //Ride Speed
        String rSpeed = getIntent().getStringExtra("speed");
        TextView viewSpeed = (TextView) findViewById(R.id.viewSpeed);
        viewSpeed.setText("Average Speed: " + rSpeed);

        //Ride Cadence
        String rCadence = getIntent().getStringExtra("cadence");
        TextView viewCadence = (TextView) findViewById(R.id.viewCadence);
        viewCadence.setText("Average Cadence: " + rCadence);

        //Ride Comment
        String rComment = getIntent().getStringExtra("comment");
        TextView viewComment = (TextView) findViewById(R.id.viewComment);
        viewComment.setText("Comment: " + rComment);




        //when cancel button is pressed, return to main activity
        Button back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(AppCompatActivity.RESULT_CANCELED);
                finish();
            }
        });


    }
}

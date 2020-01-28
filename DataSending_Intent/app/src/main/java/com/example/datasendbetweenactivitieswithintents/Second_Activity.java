package com.example.datasendbetweenactivitieswithintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {

    private TextView incomingData;
    private static final String TAG = "Second_Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        incomingData = (TextView) findViewById(R.id.tvIncomingdata);
        Log.d(TAG, "onCreate: Started");

        //gets data
        Intent incomingIntent = getIntent();
        //gets the extra with the key
        String incomingName = incomingIntent.getStringExtra("name");
        Log.d(TAG, "onCreate: Incoming name has taken");
        incomingData.setText(incomingName);

    }
}

package com.example.calendarview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCalendar;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalendar = (Button) findViewById(R.id.btnCalendar);
        tvDate = (TextView) findViewById(R.id.tvDate);

        Intent incomingIntent = getIntent();
        String date = incomingIntent.getStringExtra("date");
        tvDate.setText(date);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }
        });


    }
}

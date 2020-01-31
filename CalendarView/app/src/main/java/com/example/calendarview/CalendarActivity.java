package com.example.calendarview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {

    private CalendarView mcalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mcalendarView = (CalendarView) findViewById(R.id.calendarView);
        mcalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
               String date = month + "/" + dayOfMonth + "/" + year;
               Intent intent = new Intent(CalendarActivity.this ,MainActivity.class);
               intent.putExtra("date", date);
               startActivity(intent);
            }
        });
    }
}

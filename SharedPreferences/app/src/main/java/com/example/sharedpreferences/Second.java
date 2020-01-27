package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    private static final String TAG = "Second";
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mName = (TextView) findViewById(R.id.textView2);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        //it's pulling the data from sharedpreferences
        String name = mPreferences.getString(getString(R.string.name),"");
        //setting the data to textview have pulled before.
        mName.setText(name);

    }
}

package com.example.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnClick , btnReset ;
    TextView txtCount;
    int counter = 0;


    private void init ()
    {
        btnReset = (Button) findViewById(R.id.btnReset);
        btnClick = (Button) findViewById(R.id.btnClick);
        txtCount = (TextView) findViewById(R.id.counterText);
    }

    public void btnClick_Click(View view) {
        counter++;
        txtCount.setText("Clicked : " + counter);
    }

    public void btnReset_Click (View view)
    {
        counter = 0 ;
        txtCount.setText(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }
}

package com.example.togglebutto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView txtVW;
    private ToggleButton tb;

    private void init(){

        txtVW = (TextView) findViewById(R.id.textVW);
        tb = (ToggleButton) findViewById(R.id.tb);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void toggleButton_Click(View view){

        if(tb.isChecked()) txtVW.setVisibility(View.VISIBLE);
        else txtVW.setVisibility(View.GONE);
    }

}

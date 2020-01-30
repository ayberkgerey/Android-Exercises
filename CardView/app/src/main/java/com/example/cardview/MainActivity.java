package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView mCardImage;
    private TextView mCardTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardImage = (ImageView) findViewById(R.id.cardImage);
        mCardTitle = (TextView) findViewById(R.id.cardTitle);

        int imageResource = getResources().getIdentifier("@drawable/stockholm",null,this.getPackageName());
        mCardImage.setImageResource(imageResource);

        mCardTitle.setText("Stockholm");

    }
}
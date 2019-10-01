package com.example.exercise;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        LinearLayout layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.HORIZONTAL);

        TextView textView1 = new TextView(this);
        textView1.setText(R.string.name);
        textView1.setTextSize(17);
        textView1.setTextColor(Color.GREEN);
        textView1.setTypeface(Typeface.MONOSPACE , Typeface.BOLD);

        EditText editText1 = new EditText(this);
        editText1.setHint(R.string.hintname);
        editText1.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
        editText1.setTextColor(Color.GREEN);
        editText1.setTextSize(18);
        editText1.setHintTextColor(Color.GREEN);

        layout1.addView(textView1);
        layout1.addView(editText1);


        LinearLayout layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.HORIZONTAL);

        TextView textView2 = new TextView(this);
        textView2.setText(R.string.lastname);
        textView2.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
        textView2.setTextSize(17);
        textView2.setTextColor(Color.GREEN);

        EditText editText2 = new EditText(this);
        editText2.setHint(R.string.hintlastname);
        editText2.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
        editText2.setTextSize(18);
        editText2.setHintTextColor(Color.GREEN);

        layout2.addView(textView2);
        layout2.addView(editText2);

        container.addView(layout1);
        container.addView(layout2);
        setContentView(container);


    }






}
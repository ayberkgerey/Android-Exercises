package com.example.paramnsnscrolview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ScrollView sv;
    private LinearLayout pnl;
    private TextView txtview;
    private Button btn;
    private LinearLayout.LayoutParams txtLp , btnLp;

    private void init()
    {
        //Creating a scrollview a layout and figuring it as a vertical
        sv = new ScrollView(this);
        pnl = new LinearLayout(this);
        pnl.setOrientation(LinearLayout.VERTICAL);

        //params of textView
        txtLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txtLp.setMargins(0,100,0,0);
        txtLp.gravity = Gravity.CENTER;

        //params of Button
        btnLp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnLp.gravity = Gravity.CENTER;


      //creating textViews and buttons over here
        for(int i = 0 ; i <= 5 ; i++)
        {
            txtview = new TextView(this);
            txtview.setText(i+".TextView");
            txtview.setTextSize(20);
            txtview.setLayoutParams(txtLp);
            pnl.addView(txtview);

            btn = new Button(this);
            btn.setText(i+".Button");
            btn.setLayoutParams(btnLp);
            btn.setTextSize(20);
            pnl.addView(btn);
        }

        sv.addView(pnl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(sv);
    }
}

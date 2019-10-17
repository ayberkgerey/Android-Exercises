package com.example.toastmessageusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = (Button) findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Toast myToast = Toast.makeText(MainActivity.this, "TOAST MESSAGE", Toast.LENGTH_SHORT);
               myToast.setGravity(Gravity.CENTER,-500,-500);
               myToast.show();
            }
        });

    }
}

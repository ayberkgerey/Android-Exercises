package com.example.custom_dialog_box;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mButton1 , mButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.dialogbtn1);
        mButton2 = (Button) findViewById(R.id.dialogbtn2);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //2 options
        if(v == mButton1){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Dialog Box");
            builder.setIcon(R.mipmap.ic_notification);
            builder.setMessage("Would you like to see app information ?");
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "No clicked", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }
            });
            builder.show();

        }
        //3 options
        if(v == mButton2){

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Dialog Box 2");
            builder.setIcon(R.mipmap.ic_notification);
            builder.setMessage("Do you want to dance =");
            builder.setNegativeButton("No",null);
            builder.setNeutralButton("Remind me later",null);
            builder.setPositiveButton("Yes",null);

            builder.show();
        }

    }
}

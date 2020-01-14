package com.example.androidnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //1. Notification Channel
    //2. Notification Builder
    //3. Notification Manager


    private static final String CHANNEL_ID = "first_channel";
    private static final String CHANNEL_NAME = "first_channel";
    private static final String CHANNEL_DESC = "Notifications";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationChannel();


        Button btnNotification = (Button) findViewById(R.id.btnNotification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayNotification();

            }
        });
    }


    //Notification Builder
    private void displayNotification(){

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this , CHANNEL_ID)
                .setSmallIcon(R.drawable.bell)
                .setContentTitle("You have to know that;")
                .setContentText("You Are Great")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("You Are Great"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //notification notified
        NotificationManagerCompat mnotificationManager = NotificationManagerCompat.from(this);
        mnotificationManager.notify(1, mBuilder.build());
    }


    //Notification Channel
    private void notificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            //Notification Manager
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Log.d(TAG, "notificationChannel: Channel is created");

    }



}
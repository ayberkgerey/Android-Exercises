package com.example.checkpermissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    //private static final int REQUEST_CODE = 1;

    private static final String[] STORAGE_PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private static final String[] CALL_PERMISSIONS = {Manifest.permission.CALL_PHONE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verifyPermissions();
    }

    private void verifyPermissions(){
        Log.d(TAG, "verifyPermissions: Checking Permissions");

        int permissionCallPhone = ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE);
        int permissionExternalMemory = ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permissionCallPhone != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
         }

        if(permissionExternalMemory != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                     STORAGE_PERMISSIONS,
                    1
            );
        }
    }


}

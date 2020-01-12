package com.example.googlemaps_exercise;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //vars
    private GoogleMap mMap;

    private Boolean mLocationPermissionsGranted = false;

    private FusedLocationProviderClient mFusedLocationProviderClient;

    private static final float DEFAULT_ZOOM = 15f;

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    private static final String TAG = "MapsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        getLocationPermission();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this,"Map is Ready",Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: Ready");
        mMap = googleMap;

        if(mLocationPermissionsGranted){
            getDeviceLocation();
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
        }
    }


    private void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: getting the device's current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{

            if(mLocationPermissionsGranted){
                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful()){
                        Log.d(TAG, "onComplete: found location!");
                        Location currentLocation = (Location) task.getResult();

                        moveCamera(new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude()),DEFAULT_ZOOM);

                    }else{
                        Log.d(TAG, "onComplete: current location is null");
                        Toast.makeText(MapsActivity.this,"unable to get current location",Toast.LENGTH_SHORT).show();
                    }
                        
                    }
                });

            }

        }catch(SecurityException e){
            Log.e(TAG, "getDeviceLocation: Security Exception: "+ e.getMessage());

        }

    }

    private void moveCamera(LatLng latlng , float zoom){
        Log.d(TAG, "moveCamera: moving the camera to lat: "+ latlng.latitude + ", lng: "+ latlng.longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,zoom));


          /*  // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
       */
    }

    private void initMap(){

        Log.d(TAG, "initMap: initializing map");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
                initMap();
            }
            else{
                ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
            }
        }
        else{
            ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called");
        mLocationPermissionsGranted = false;

        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                for(int i = 0 ; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                        mLocationPermissionsGranted = false;
                        Log.d(TAG, "onRequestPermissionsResult: permission failed");
                        return;
                    }
                }
                Log.d(TAG, "onRequestPermissionsResult: permission granted");
                mLocationPermissionsGranted = true;
                //initialize the map
                initMap();
            }
        }
    }
}
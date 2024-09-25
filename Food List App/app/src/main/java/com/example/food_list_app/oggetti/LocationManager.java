package com.example.food_list_app.oggetti;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.food_list_app.R;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;


public class LocationManager extends AppCompatActivity implements View.OnClickListener {


    Location currentlocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    EditText editLocation;

    Button buttonLocation;

    Geocoder geo = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        android.location.LocationManager locationManager = (android.location.LocationManager) getSystemService(Context.LOCATION_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prova);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();

        //EDITEXT
        editLocation = findViewById(R.id.editLocation);
        //BOTTONI
        buttonLocation = findViewById(R.id.locationButton);
        buttonLocation.setOnClickListener(this);

    }

    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(location -> {
            if (location != null){
                currentlocation = location;

                Double latitudine = currentlocation.getLatitude();
                Double longitudine = currentlocation.getLatitude();

            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int request_code, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(request_code, permissions, grantResults);
        switch (request_code) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    fetchLocation();
                break;
        }
    }



    @Override
    public void onClick(View view) {

    }
}

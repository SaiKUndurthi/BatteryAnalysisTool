package com.example.saikrishna.gpslocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import android.location.LocationListener;
import com.google.android.gms.location.LocationServices;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity /*implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener*/ {
    private Button mButton;
    private TextView mText;
    private GoogleApiClient mGoogleApiClient;
    private LocationManager locationManager;
    private double mLongit;
    private double mLati;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
       /*if (mGoogleApiClient == null){
           mGoogleApiClient = new GoogleApiClient.Builder(this)
                   .addConnectionCallbacks(this)
                   .addOnConnectionFailedListener(this)
                   .addApi(LocationServices.API)
                   .build();
       }*/
         locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                mLongit = location.getLongitude();
                mLati   = location.getLatitude();
                String df = "Longi: "+mLongit+" Latitude: "+mLati;
                Log.d("LAT LONG",df);
                Toast.makeText(getBaseContext(),df,Toast.LENGTH_LONG).show();

            }

             @Override
             public void onStatusChanged(String s, int i, Bundle bundle) {

             }

             @Override
             public void onProviderEnabled(String s) {

             }

             @Override
             public void onProviderDisabled(String s) {

             }
         };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1800,3, locationListener);
        mButton = (Button) findViewById(R.id.location);
        mText = (TextView) findViewById(R.id.output);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ch = "Longitude: "+mLongit+" Latitude: "+mLati;
                Toast.makeText(getBaseContext(),ch,Toast.LENGTH_LONG).show();
            }
        });

    }

   /* @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/
}

package com.example.atulkumar.location_service;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    LocationManager locationManager;//Used for location based service ko use karne ke liye

    double latitude;
    double longitude;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btnget);

        //Lolipop me automatically allowed hota hai us se phele ke me bhi hota hai
        //lolipop ke baad wale version me hume allow karna padta hai

        //coarse :- current loacation.
        //fine loacation: jab location change hoga toh update karega.

        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION},0);
            return;
        }


        locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);

        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                        latitude=location.getLatitude();
                        longitude=location.getLongitude();

                        tv.setText("longitude:"+longitude+"\nlatitude:"+latitude);

                        Geocoder geocoder=new Geocoder(MainActivity.this);
                        //Address me change karne ke liye latitude and longitude ko


                        try {

                            List<Address> area=geocoder.getFromLocation(latitude,longitude,1);

                            String country=area.get(0).getCountryName();
                            String locality=area.get(0).getLocality();
                            String postalcode=area.get(0).getPostalCode();
                            String address=area.get(0).getAddressLine(0);

                            tv.append("\n\n"+"Country:"+country
                                    +"\nLocality:"+locality
                                    +"\nPostalCode:" +postalcode
                                    +"\nAddress:"+address);
                        }
                        catch (Exception e)
                        {

                        }



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
                });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tv2=tv.getText().toString();

                if (tv2.equals("TextView")) {

                    Toast.makeText(MainActivity.this, "Please Check Location First", Toast.LENGTH_SHORT).show();

                } else {

                    String lable = "Current Location";

                    String uriBegin = "geo:" + longitude + "," + latitude;

                    String query = latitude + "," + longitude + "{" + lable + "}";

                    String encodedquery = Uri.encode(query);

                    String uristring = uriBegin + "?q=" + encodedquery + "&r=16";

                    Uri uri = Uri.parse(uristring);

                    Intent i = new Intent(new Intent(Intent.ACTION_VIEW, uri));
                    startActivity(i);
                }
            }
        });







    }
}

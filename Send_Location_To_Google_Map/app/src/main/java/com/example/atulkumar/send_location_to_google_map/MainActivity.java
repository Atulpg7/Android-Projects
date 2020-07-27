package com.example.atulkumar.send_location_to_google_map;

import android.Manifest;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText etshow;
    TextView tvdetails;
    Button btnget, btnsend;
    LocationManager locationManager;

    double longitude,latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etshow = findViewById(R.id.etshow);
        btnget = findViewById(R.id.btnget);
        btnsend = findViewById(R.id.btnsend);
        tvdetails=findViewById(R.id.tvdetails);










        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                    return;
                }

                locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0,
                        new LocationListener() {
                            @Override
                            public void onLocationChanged(Location location) {


                                latitude=location.getLatitude();
                                longitude=location.getLongitude();

                                etshow.setText("lo: "+longitude+" , "+"la: "+latitude);
                              tvdetails.setText("");





                               Geocoder geocoder=new Geocoder(MainActivity.this);
                                //Address me change karne ke liye latitude and longitude ko


                                try {

                                    List<Address> area=geocoder.getFromLocation(latitude,longitude,1);

                                    String country=area.get(0).getCountryName();
                                    String locality=area.get(0).getLocality();
                                    String postalcode=area.get(0).getPostalCode();
                                    String address=area.get(0).getAddressLine(0);


                                    tvdetails.append("\n\n"+"Country:"+country
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








            }
        });



        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location=etshow.getText().toString();

                if(location.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please get the loation first", Toast.LENGTH_SHORT).show();
                    etshow.setText("");
                    etshow.requestFocus();
                }

                else
                {
                    String lable="Current Location";

                    String uriBegin="geo:"+longitude+","+latitude;

                    String query=latitude+","+longitude+"{"+lable+"}";

                    String encodedquery= Uri.encode(query);

                    //Toast.makeText(MainActivity.this, ""+encodedquery, Toast.LENGTH_SHORT).show();


                    String uristring=uriBegin+"?q="+encodedquery+"&r=16";

                   // Toast.makeText(MainActivity.this, ""+uristring, Toast.LENGTH_SHORT).show();

                    Uri uri=Uri.parse(uristring);

                    //Toast.makeText(MainActivity.this, ""+uri, Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(new Intent(Intent.ACTION_VIEW,uri));
                    startActivity(i);
                }
            }
        });

    }
}




/*

 */

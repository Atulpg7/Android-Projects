package com.example.atulkumar.brajservice;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Main2 extends AppCompatActivity {

    private ImageButton temple,hotel,cab,map,aboutus;
    private FirebaseAuth auth;
    private Button logout;
    private ProgressDialog progressDialog;

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Main2.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        temple= (ImageButton) findViewById(R.id.temple);
        hotel=(ImageButton) findViewById(R.id.hotels);
        cab=(ImageButton) findViewById(R.id.taxies);
        map=(ImageButton) findViewById(R.id.map);
        aboutus= (ImageButton) findViewById(R.id.aboutus);
        auth=FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);



        temple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Main2.this, Temple.class);
                startActivity(obj);

            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Main2.this, Hotels.class);
                startActivity(obj);

            }
        });

       cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Main2.this, cabs.class);
                startActivity(obj);

            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj = new Intent(Main2.this, Aboutus.class);
                startActivity(obj);

            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(Main2.this,Map.class);
                startActivity(obj);
            }
        });







    }


    private void Logout(){

    progressDialog.setMessage("Please Wait A Second");
    progressDialog.show();

    auth.signOut();
    finish();
    progressDialog.dismiss();
    startActivity(new Intent(Main2.this,MainActivity.class));

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){

            case R.id.logoutmenu:{
                Logout();

            }
        }
        return super.onOptionsItemSelected(item);
    }

}

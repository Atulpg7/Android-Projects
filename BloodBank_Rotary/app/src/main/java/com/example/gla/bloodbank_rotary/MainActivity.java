package com.example.gla.bloodbank_rotary;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView name,mbno,bldgrp,email;
   String name2,bloodgrp2,mobileno2,email2;

    Button donner,reciver,camp,rules;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Shared Prefrences
        Shared_Prefrences.preferences=getSharedPreferences("details",Context.MODE_PRIVATE);
        Shared_Prefrences.editor=Shared_Prefrences.preferences.edit();

         name2=Shared_Prefrences.preferences.getString("name","");
         mobileno2=Shared_Prefrences.preferences.getString("mobileno","");
         bloodgrp2=Shared_Prefrences.preferences.getString("bloodgroup","");




        donner = (Button) findViewById(R.id.doner);
        donner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(MainActivity.this,DonateActivity.class);
                startActivity(obj);
            }
        });



        reciver = (Button) findViewById(R.id.finddonor);
        reciver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(MainActivity.this, FindDonarActivity.class);
                startActivity(obj);
            }
        });

        rules = (Button) findViewById(R.id.rules);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(obj);
            }
        });

        camp = (Button) findViewById(R.id.camp);
        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(MainActivity.this, CampActivity.class);
                startActivity(obj);
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, request_blood.class);
                startActivity(intent);
            }
        });*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        /*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/

        name=header.findViewById(R.id.username);
        mbno=header.findViewById(R.id.usermobileno);
        bldgrp=header.findViewById(R.id.userbloodgrp);
       // email=header.findViewById(R.id.useremail);

        name.setText(name2);
        mbno.setText(mobileno2);
        bldgrp.setText(bloodgrp2);
       // email.setText(email2);








    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {







        // Handle navigation view item clicks here.

        int id = item.getItemId();



        if (id == R.id.nav_donate) 
        {
            Intent intent = new Intent(MainActivity.this, DonateActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.nav_finddoner) 
        {
            Intent intent = new Intent(MainActivity.this, FindDonarActivity.class);
            startActivity(intent);

        } 
        else if (id == R.id.nav_rules) {
            Intent intent = new Intent(MainActivity.this, RulesActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_camp_info) {
            Intent intent = new Intent(MainActivity.this, CampActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_logout) {

            Shared_Prefrences.editor.putString("status_key","inactive");
            Shared_Prefrences.editor.putString("name","");
            Shared_Prefrences.editor.putString("mobileno","");
            Shared_Prefrences.editor.putString("bloodgroup","");
            Shared_Prefrences.editor.commit();

            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,login.class);
            startActivity(intent);
            finish();

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

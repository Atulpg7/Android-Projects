package com.example.atulkumar.brajservice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    private static int splash_time_out= 2000;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

            new Handler().postDelayed(new Runnable() {


                @Override
                public void run() {
                    Intent i=new Intent(Splash.this,MainActivity.class);
                    startActivity(i);

                    finish();
                }
            },splash_time_out);



        }
}

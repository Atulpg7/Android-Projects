package com.example.atulkumar.lkg;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class splash extends Activity {

    private static int splash_time_out= 2000;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash2);

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                Intent i=new Intent(splash.this,MainActivity.class);
                startActivity(i);

                finish();
            }
        },splash_time_out);

    }
}

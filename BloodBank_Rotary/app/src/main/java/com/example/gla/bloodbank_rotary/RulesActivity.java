package com.example.gla.bloodbank_rotary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class RulesActivity extends AppCompatActivity {


    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        imageView=findViewById(R.id.rules);

    }
}

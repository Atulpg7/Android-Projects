package com.example.sakshi.new_notezzzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cs_sec_act extends AppCompatActivity {
    Button ds_sec,c_sec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs_sec_act);

        ds_sec= (Button) findViewById(R.id.ds_sec);
        c_sec= (Button) findViewById(R.id.c_sec);






        ds_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(cs_sec_act.this,ds_sec.class);
                startActivity(i);



            }
        });





        c_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(cs_sec_act.this,c_sec.class);
                startActivity(i);



            }
        });


    }
}

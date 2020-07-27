package com.example.atulkumar.glavisitorsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    TextView aboutus,login,rules,comming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        login=findViewById(R.id.login);
        rules=findViewById(R.id.rules);
        comming=findViewById(R.id.comming);
        aboutus=findViewById(R.id.aboutus);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(StartActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(StartActivity.this,RulesActivity.class);
                startActivity(intent);

            }
        });

        comming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(StartActivity.this, "This Feature Will Be Comming Soon .....", Toast.LENGTH_SHORT).show();
               // Intent intent=new Intent(StartActivity.this,GuardLogin.class);
               // startActivity(intent);

            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(StartActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }
}

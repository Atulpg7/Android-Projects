package com.example.atulkumar.brajservice;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class cabs extends AppCompatActivity {

    Button hktt, sgtt, dbtt, sltt, bbte, ltt, gt, ytb, rkt, cbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabs);

        hktt=(Button) findViewById(R.id.hktt);
        sgtt=(Button) findViewById(R.id.sgtt);
        dbtt=(Button) findViewById(R.id.dbtt);
        sltt=(Button) findViewById(R.id.sltt);
        bbte=(Button) findViewById(R.id.bbte);
        ltt=(Button) findViewById(R.id.ltt);
        gt=(Button) findViewById(R.id.gt);
        ytb=(Button) findViewById(R.id.ytb);
        rkt=(Button) findViewById(R.id.rkt);
        cbt=(Button) findViewById(R.id.cbt);

        hktt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_hktt.class);
                startActivity(obj);
            }
        });
        sgtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_sgtt.class);
                startActivity(obj);
            }
        });
        dbtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_dbtt.class);
                startActivity(obj);
            }
        });
        sltt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_sltt.class);
                startActivity(obj);
            }
        });
        bbte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_bbte.class);
                startActivity(obj);
            }
        });
        ltt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_ltt.class);
                startActivity(obj);
            }
        });
        gt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_gt.class);
                startActivity(obj);
            }
        });
        ytb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_ytb.class);
                startActivity(obj);
            }
        });
        rkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_rkt.class);
                startActivity(obj);
            }
        });
        cbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(cabs.this,C_cbt.class);
                startActivity(obj);
            }
        });


    }

}

package com.example.atulkumar.brajservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.atulkumar.brajservice.R;

public class Hotels extends AppCompatActivity {

     Button hsh,hkv,hbv,hdr,hts,hgg,htrb,kr,ssd,nsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        hsh=(Button) findViewById(R.id.hsh);
        hkv=(Button) findViewById(R.id.hkv);
        hbv=(Button) findViewById(R.id.hbv);
        hdr=(Button) findViewById(R.id.hdr);
        hts=(Button) findViewById(R.id.hts);
        hgg=(Button) findViewById(R.id.hgg);
        htrb=(Button) findViewById(R.id.htrb);
        kr=(Button) findViewById(R.id.kr);
        ssd=(Button) findViewById(R.id.ssd);
        nsp=(Button) findViewById(R.id.nsp);

        hsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,Hotel_Subham_Holidays.class);
                startActivity(obj);
            }
        });
        hkv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_k_v.class);
                startActivity(obj);
            }
        });
        hbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_b.class);
                startActivity(obj);
            }
        });
        hdr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_d.class);
                startActivity(obj);
            }
        });
        hts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_t_s.class);
                startActivity(obj);
            }
        });
        hgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_g_g.class);
                startActivity(obj);
            }
        });
        htrb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_t_r_b.class);
                startActivity(obj);
            }
        });
        kr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_k_r.class);
                startActivity(obj);
            }
        });
        ssd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_s_s_d.class);
                startActivity(obj);
            }
        });
        nsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Hotels.this,H_n_s_p.class);
                startActivity(obj);
            }
        });
    }
}

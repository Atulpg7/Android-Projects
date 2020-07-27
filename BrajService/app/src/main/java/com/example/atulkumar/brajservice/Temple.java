package com.example.atulkumar.brajservice;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Temple extends AppCompatActivity {


    Button kjm,bbm,pm,ddm,bm,rm,it,st,pbm,rdm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temple);

        kjm=(Button) findViewById(R.id.kjm);
        bbm=(Button) findViewById(R.id.bbm);
        pm=(Button) findViewById(R.id.pm);
        ddm=(Button) findViewById(R.id.ddm);
        bm=(Button) findViewById(R.id.bm);
        rm=(Button) findViewById(R.id.rm);
        it=(Button) findViewById(R.id.it);
        st=(Button) findViewById(R.id.st);
        pbm=(Button) findViewById(R.id.pbm);
        rdm=(Button) findViewById(R.id.rdm);


        kjm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Krishna_Janam_Bhumi.class);
                startActivity(obj);
            }
        });
        bbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Bankebihari.class);
                startActivity(obj);
            }
        });
        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Premmandir.class);
                startActivity(obj);
            }
        });
        ddm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Dwarkadheesh.class);
                startActivity(obj);
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Birlamandir.class);
                startActivity(obj);
            }
        });
        rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Rangji.class);
                startActivity(obj);
            }
        });
        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Isckon.class);
                startActivity(obj);
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Shahji.class);
                startActivity(obj);
            }
        });
        pbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Pagalbaba.class);
                startActivity(obj);
            }
        });
        rdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj= new Intent(Temple.this,Radhadamodar.class);
                startActivity(obj);
            }
        });

    }
}

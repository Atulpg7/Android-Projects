package com.example.gla.bloodbank_rotary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.common.math.BigIntegerMath;

import java.util.ArrayList;

public class FindDonarActivity extends AppCompatActivity {


    Spinner spblood,spstate,spcity,spdistrict;
    EditText etmobileno,etname;
    Button btnsearch;
    //ListView lvresult;


    String name2=null,mobile2=null,bloodgoup2=null,
            state2=null,city2=null,district2=null;

    String bloodgrparray[] = {"Blood Group", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String statearray[];
    String districtarray[];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_donar);


        getSupportActionBar().setTitle("Find Donor Here");


        spblood=findViewById(R.id.spbloodgrp);
        spstate=findViewById(R.id.spstate);
        spdistrict=findViewById(R.id.spdistrict);
        etmobileno=findViewById(R.id.etmobile);
        etname=findViewById(R.id.etname);
        btnsearch=findViewById(R.id.btnsearch);


        statearray=getResources().getStringArray(R.array.states);
        districtarray=getResources().getStringArray(R.array.district);



        ArrayAdapter<String> ad = new
                ArrayAdapter<String>(FindDonarActivity.this,
                android.R.layout.simple_list_item_1, bloodgrparray);
        spblood.setAdapter(ad);

        ArrayAdapter<String> ad2 = new
                ArrayAdapter<String>(FindDonarActivity.this,
                android.R.layout.simple_list_item_1, statearray);
        spstate.setAdapter(ad2);

       /* ArrayAdapter<String> ad3 = new
                ArrayAdapter<String>(FindDonarActivity.this,
                android.R.layout.simple_list_item_1, cityarray);
        spcity.setAdapter(ad3);*/

        ArrayAdapter<String> ad4 = new
                ArrayAdapter<String>(FindDonarActivity.this,
                android.R.layout.simple_list_item_1, districtarray);
        spdistrict.setAdapter(ad4);



         /*adminListView=new Custom_Adapter_Admin_ListView(this,names,gender,lastdonate,email,mobileno
        ,mobileoffice,weight,address);*/

         //lvresult.setVisibility(View.INVISIBLE);



        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                state2=spstate.getSelectedItem().toString();
                district2=spdistrict.getSelectedItem().toString();
                bloodgoup2=spblood.getSelectedItem().toString();
                name2=etname.getText().toString();
                mobile2=etmobileno.getText().toString();

                if (state2.equals("State*"))
                {
                    state2="";
                }
           /*     if (city2.equals("City"))
                {
                    city2="";
                }*/
                if (district2.equals("District*"))
                {
                    district2="";
                }
                if (bloodgoup2.equals("Blood Group"))
                {
                    bloodgoup2="";
                }
                if (name2.equals(""))
                {
                    name2="";
                }
                if (mobile2.equals(""))
                {
                    mobile2="";
                }

                Intent intent=new Intent(FindDonarActivity.this,ResultActivity.class);
                intent.putExtra("state",""+state2.trim());
                //intent.putExtra("city",city2);
                intent.putExtra("district",district2);
                intent.putExtra("bloodgroup",bloodgoup2);
                intent.putExtra("name",name2);
                intent.putExtra("mobile",mobile2);
                startActivity(intent);

            }
        });






    }
}

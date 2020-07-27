package com.example.atulkumar.dhabiee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ParatheActivity extends AppCompatActivity {

    ListView lvparathe;
    Custom_Adapter adapterparathe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parathe);


        lvparathe=findViewById(R.id.lvparathe);



        //Setting Values to The lists

        adapterparathe=new Custom_Adapter(this,Global.parathename,Global.paratheprice);
        lvparathe.setAdapter(adapterparathe);
        adapterparathe.notifyDataSetChanged();


    }
}

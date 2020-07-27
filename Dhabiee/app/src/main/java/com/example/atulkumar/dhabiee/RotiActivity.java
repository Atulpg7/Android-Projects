package com.example.atulkumar.dhabiee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class RotiActivity extends AppCompatActivity {


    ListView lvroti;
    Custom_Adapter adapterroti;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roti);

        //Id's Taking
        lvroti=findViewById(R.id.lvroti);


        //Setting Values to The lists
        adapterroti=new Custom_Adapter(this,Global.rotiname,Global.rotiprice);
        lvroti.setAdapter(adapterroti);
        adapterroti.notifyDataSetChanged();
    }
}

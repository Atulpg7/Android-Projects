package com.example.atulkumar.dhabiee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class FastfoodActivity extends AppCompatActivity {

    ListView lvfastfood;
    Custom_Adapter adapterfastfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood);


        //Id's Taking
        lvfastfood=findViewById(R.id.lvfastfood);


        //Setting Values to The lists
        adapterfastfood=new Custom_Adapter(this,Global.fastfoodname,Global.fastfoodprice);
        lvfastfood.setAdapter(adapterfastfood);
        adapterfastfood.notifyDataSetChanged();



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

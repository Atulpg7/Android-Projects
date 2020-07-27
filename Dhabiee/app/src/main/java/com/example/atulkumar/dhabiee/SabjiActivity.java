package com.example.atulkumar.dhabiee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SabjiActivity extends AppCompatActivity {


    ListView lvsabji;
    Custom_Adapter adaptersabji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabji);


        //Id's Taking
        lvsabji=findViewById(R.id.lvsabji);


        //Setting Values to The lists
        adaptersabji=new Custom_Adapter(this,Global.sabjiname,Global.sabjiprice);
        lvsabji.setAdapter(adaptersabji);
        adaptersabji.notifyDataSetChanged();

    }
}

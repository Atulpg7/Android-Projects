package com.example.atulkumar.autocomplete_textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView actv;

    String names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        actv=findViewById(R.id.autoCompleteTextView);
        names=getResources().getStringArray(R.array.names);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,names);

        actv.setAdapter(adapter);

        //phele character se sorting start kare
        actv.setThreshold(1);
    }
}

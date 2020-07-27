package com.example.atulkumar.glavisitorsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Old_RecordsActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old__records);
        getSupportActionBar().setTitle("My Old Records");

        lv=findViewById(R.id.listviewguardold);

    }
}

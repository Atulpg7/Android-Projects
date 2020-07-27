package com.example.atulkumar.calender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar ca=Calendar.getInstance();
    int day=ca.get(Calendar.DATE);//Day_Of_Month
    int month=ca.get(Calendar.MONTH);
    int year=ca.get(Calendar.YEAR);
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.date);
        tv.setText(day+"/"+(month+1)+"/"+year);
    }
}

package com.example.atulkumar.find_sensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList=new ArrayList<String>();
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this,
                android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        sm= (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> list=sm.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor:list)
        {
         arrayList.add(""+sensor.getName());
         adapter.notifyDataSetChanged();
        }
    }
}

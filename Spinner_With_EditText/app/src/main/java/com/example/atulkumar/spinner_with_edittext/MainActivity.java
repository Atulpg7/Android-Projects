package com.example.atulkumar.spinner_with_edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    EditText et;
    String courses[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sp=findViewById(R.id.spinner);
        et=findViewById(R.id.et);
        courses=getResources().getStringArray(R.array.courses);

        sp.requestFocus();

        ArrayAdapter<String> courseslist=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses);
        
        sp.setAdapter(courseslist);
        
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                
                if (position==0)
                {
                    et.setText("");
                    Toast.makeText(MainActivity.this, "Please Select Any 1 Course", Toast.LENGTH_LONG).show();
                }
                
                if(position==1)
                {
                    et.setText("");
                    et.setText("Mr. Lalit Thakur");
                }
                else  if(position==2)
                {
                    et.setText("");
                    et.setText("Mr. Rajiv Kumar");
                }
                else  if(position==3)
                {
                    et.setText("");
                    et.setText("Mr. Rajesh Singh");
                }
                else  if(position==4)
                {
                    et.setText("");
                    et.setText("Mr. Harshraj Singh");
                }
                else  if(position==5)
                {
                    et.setText("");
                    et.setText("Mr. Aditya Gautam");
                }
                else
                {
                    et.setText("");
                }
                
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}

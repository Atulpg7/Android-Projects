package com.example.atulkumar.tabview_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    CheckBox android,java,python,kotlin;
    TabHost tabhost;
    TextView textview;
    Button btn;




    String androidstring = "";
    String javastring = "";
    String kotlinstring = "";
    String pythonstring = "";
    String all = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android=findViewById(R.id.android);
        java=findViewById(R.id.java);
        kotlin=findViewById(R.id.kotlin);
        python=findViewById(R.id.python);
        tabhost=findViewById(R.id.tabhost);
        textview=findViewById(R.id.textview);
        btn=findViewById(R.id.btn);



        if(!(android.isChecked()&&java.isChecked()&&
                kotlin.isChecked()&&python.isChecked()))
        {
            textview.setText("");
            textview.setText("Please Select Something");
        }


        tabhost.setup();

        TabHost.TabSpec tabSpec= tabhost.newTabSpec("");

        tabSpec.setIndicator("Courses");
        tabSpec.setContent(R.id.tab1);
        tabhost.addTab(tabSpec);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                all = "";

                if (android.isChecked()) {
                    androidstring = "Android";

                }
                if (java.isChecked()) {
                    javastring = "Java";

                }
                if (kotlin.isChecked()) {
                    kotlinstring = "Kotlin";

                }
                if (python.isChecked()) {
                    pythonstring = "Python";

                }

                else {
                    all = androidstring + javastring +
                            kotlinstring + pythonstring;


                    Toast.makeText(MainActivity.this,
                            "Data Submitted Sucessfully", Toast.LENGTH_SHORT).show();
                }
            }
        });


        tabSpec=tabhost.newTabSpec("");
        tabSpec.setIndicator("Summary");
        tabSpec.setContent(R.id.tab2);
        tabhost.addTab(tabSpec);
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

                if (all.equals("")) {
                    textview.setText("");
                    textview.setText("Please Select Something");
                    Toast.makeText(MainActivity.this,
                            "Please Select Something", Toast.LENGTH_SHORT).show();
                } else {

                    textview.setText("");
                    textview.setText(all);
                }
            }
        });
    }
}

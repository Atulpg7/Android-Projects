package com.example.atulkumar.polydepartment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PlacementsActivity extends AppCompatActivity {

    String parent,branch;
    ListView listView;
    TextView textView;

    String names[]=
            {
                    "Atul Kumar",
                    "Sakshi Singh",
                    "Nikhil Gupta",
                    "Arti",
                    "Atul Kumar",
                    "Sakshi Singh",
                    "Nikhil Gupta",
                    "Arti",

            };
    String company[]=
            {
                    "Drive Digital",
                    "Drive Digital",
                    "UNO Minda",
                    "Robotech",
                    "Drive Digital",
                    "Drive Digital",
                    "UNO Minda",
                    "Robotech",
            };
    String session[]=
            {
                    "2018-2019",
                    "2018-2019",
                    "2018-2019",
                    "2018-2019",
                    "2018-2019",
                    "2018-2019",
                    "2018-2019",
                    "2018-2019",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placements);

        Bundle b= getIntent().getExtras();
        if (b != null)
        {
            parent=b.get("parent").toString();
            branch=b.get("branch").toString();
            Toast.makeText(this, "Parent is :- "+parent+" Branch is:- "+branch, Toast.LENGTH_SHORT).show();
        }

        listView=findViewById(R.id.lstviewplcmnt);
        textView=findViewById(R.id.txtname);

        textView.setText("Students Placed in "+branch.toUpperCase()+" Branch");


        Custom_Adapter_Placement adapter=new Custom_Adapter_Placement(this,names,company,session);

        listView.setAdapter(adapter);


    }
}

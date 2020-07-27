package com.example.atulkumar.notescorner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TopicsActivity extends AppCompatActivity {

    String sub;
    TextView topicnotes;

    ArrayList<String> name=new ArrayList<String>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);


        name.add("Introduction to IWT");
        name.add("Basics of IWT");
        name.add("History");
        name.add("Future Scope");
        name.add("Advantages");
        name.add("Disadvantages");
        name.add("Comparision in IWT and AI ");
        name.add("Benifits of AI over IWT");




        Bundle b=getIntent().getExtras();
        sub=b.getString("subject");

        Toast.makeText(this, "Subject Selected :- "+sub, Toast.LENGTH_SHORT).show();

        listView=findViewById(R.id.listviewtopics);


        Custom_Adapter_Topics adapter=new Custom_Adapter_Topics(TopicsActivity.this,name);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(TopicsActivity.this, "Topic Selected "+name.get(i), Toast.LENGTH_SHORT).show();

            }
        });

    }
}

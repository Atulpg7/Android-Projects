package com.example.atulkumar.notescorner;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NotesFragment extends Fragment {


    ArrayList<String> name=new ArrayList<String>();
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notes, container, false);

        name.add("IWT");
        name.add("C language");
        name.add("C++ LANGUAGE");
        name.add("Operating System");
        name.add("Computer Organization");
        name.add("Networking");
        name.add("Dot Net programing");
        name.add("Data Warehouse");
        name.add("Multimedia");

        name.add("IWT");
        name.add("C language");
        name.add("C++ LANGUAGE");
        name.add("Operating System");
        name.add("Computer Organization");
        name.add("Networking");
        name.add("Dot Net programing");
        name.add("Data Warehouse");
        name.add("Multimedia");





        listView=v.findViewById(R.id.listviewnotes);
        // listViewasgnmnt=findViewById(R.id.listviewasgnmnt);
        // listViewquize=findViewById(R.id.listviewquize);
        //listViewfdbk=findViewById(R.id.listviewfdbk);


        Custom_Adapter_Main adapter=new Custom_Adapter_Main(getActivity(),name);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent= new Intent(getContext(),TopicsActivity.class);
                intent.putExtra("subject",name.get(i));
                startActivity(intent);

            }
        });



        return v;
    }

}

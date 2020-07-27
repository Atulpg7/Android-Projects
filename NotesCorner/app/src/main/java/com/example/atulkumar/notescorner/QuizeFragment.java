package com.example.atulkumar.notescorner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class QuizeFragment extends Fragment {

    ArrayList<String> name=new ArrayList<String>();
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_quize, container, false);


        name.add("Multimedia");
        name.add("IWT");
        name.add("Dot Net programing");
        name.add("Data Warehouse");
        name.add("Computer Organization");
        name.add("Networking");





        listView=v.findViewById(R.id.listviewquize);


        Custom_Adapter_Main adapter=new Custom_Adapter_Main(getActivity(),name);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getContext(), ""+ name.get(i), Toast.LENGTH_SHORT).show();

            }
        });





        return v;
    }

}

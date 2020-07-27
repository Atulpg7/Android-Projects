package com.example.sakshi.new_notezzzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sakshi on 10/22/2018.
 */

public class SecondyearFragment extends Fragment {

    Button me_sec,ee_sec,ec_sec,cs_sec,ch_sec,ce_sec;




    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_second, container, false);

        me_sec= (Button) v.findViewById(R.id.me_sec);
        ee_sec= (Button) v.findViewById(R.id.ee_sec);
        ec_sec= (Button) v.findViewById(R.id.ec_sec);
        cs_sec= (Button) v.findViewById(R.id.cs_sec);
        ce_sec= (Button) v.findViewById(R.id.ce_sec);
        ch_sec= (Button) v.findViewById(R.id.ch_sec);


        me_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),me_sec_act.class);
                startActivity(intent);


            }
        });

        ee_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ee_sec_act.class);
                startActivity(intent);


            }
        });
        ec_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ec_sec_act.class);
                startActivity(intent);


            }
        });
        cs_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),cs_sec_act.class);
                startActivity(intent);


            }
        });
        ch_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),che_sec_act.class);
                startActivity(intent);


            }
        });
        ce_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ce_sec_act.class);
                startActivity(intent);


            }
        });




        return v;
    }

}
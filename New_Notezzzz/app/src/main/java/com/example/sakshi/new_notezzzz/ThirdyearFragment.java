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

public class ThirdyearFragment extends Fragment {

    Button me_th,ee_th,ec_th,cs_th,ch_th,ce_th;




    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_third, container, false);

        me_th= (Button) v.findViewById(R.id.me_th);
        ee_th= (Button) v.findViewById(R.id.ee_th);
        ec_th= (Button) v.findViewById(R.id.ec_th);
        cs_th= (Button) v.findViewById(R.id.cs_th);
        ce_th= (Button) v.findViewById(R.id.ce_th);
        ch_th= (Button) v.findViewById(R.id.ch_th);


        me_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),me_th_act.class);
                startActivity(intent);


            }
        });

        ee_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ee_th_act.class);
                startActivity(intent);


            }
        });
        ec_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ec_th_act.class);
                startActivity(intent);


            }
        });
        cs_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),cs_th_act.class);
                startActivity(intent);


            }
        });
        ch_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),che_th_act.class);
                startActivity(intent);


            }
        });
        ce_th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),ce_th_act.class);
                startActivity(intent);


            }
        });




        return v;
    }

}

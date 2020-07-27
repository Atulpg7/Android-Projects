package com.example.sakshi.new_notezzzz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sakshi on 10/22/2018.
 */

public class FirstyearFragment extends Fragment {

    Button english_i,math_i;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        english_i = (Button) v.findViewById(R.id.english_i);
        math_i = (Button) v.findViewById(R.id.math_i);


        english_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),english_i.class);
                startActivity(intent);


            }
        });

        math_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),Maths_i.class);
                startActivity(intent);


            }
        });






        return v;
    }

}

package com.example.atulkumar.multipain_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {



    Button btnclick;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_first, container, false);


        btnclick=v.findViewById(R.id.btnclick);


        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                SecondFragment secondFragment= (SecondFragment)
                        getFragmentManager().findFragmentById(R.id.fragment2);

                secondFragment.show("Hello Baby");




            }
        });


        return v;

    }

}

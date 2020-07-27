package com.example.atulkumar.dhabiee;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WriteForUs extends Fragment {


    EditText etprobtitle,etprobdescription;
    Button btnsubmit;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_write_for_us, container, false);

        etprobtitle = v.findViewById(R.id.probtitle);
        etprobdescription = v.findViewById(R.id.probdescription);
        btnsubmit = v.findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Thanks For Your Feedback :)", Snackbar.LENGTH_LONG).show();
            }
        });

        return v;


    }


}

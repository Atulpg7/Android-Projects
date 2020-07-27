package com.example.atulkumar.dhabiee;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OwnerFragment extends Fragment {


    TextView numsurajowner,numsonuowner,numthakurowner,numpanjabiowner,numgopalowner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_owner, container, false);



        numsurajowner=v.findViewById(R.id.numsurajowner);
        numsonuowner=v.findViewById(R.id.numsonuowner);
        numthakurowner=v.findViewById(R.id.numthakurowner);
        numpanjabiowner=v.findViewById(R.id.numpanjabiowner);
        numgopalowner=v.findViewById(R.id.numgopalowner);





        numsurajowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numsurajowner.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });



        numsonuowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numsonuowner.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });




        numthakurowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numthakurowner.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });




        numpanjabiowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numpanjabiowner.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });




        numgopalowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numgopalowner.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });



        return v;
    }

}

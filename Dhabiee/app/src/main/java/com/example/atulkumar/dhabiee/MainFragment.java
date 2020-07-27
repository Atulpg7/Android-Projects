package com.example.atulkumar.dhabiee;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    TextView numsuraj,numsonu,numthakur,numpanjabi,numgopal;


    Button ordersuraj,ordersonu,orderthakur,orderpunjabi,ordergopal;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_main, container, false);



        //TextViews

        numsuraj=v.findViewById(R.id.numsuraj);
        numsonu=v.findViewById(R.id.numsonu);
        numthakur=v.findViewById(R.id.numthakur);
        numpanjabi=v.findViewById(R.id.numpanjabi);
        numgopal=v.findViewById(R.id.numgopal);




        //Buttons


        ordersuraj=v.findViewById(R.id.ordersuraj);
        ordersonu=v.findViewById(R.id.ordersonu);
        orderthakur=v.findViewById(R.id.orderthakur);
        orderpunjabi=v.findViewById(R.id.orderpunjabi);
        ordergopal=v.findViewById(R.id.ordergopalji);



        //Buttons Set On Click

        ordersuraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(getActivity(),OrderActivity.class);
                i.putExtra("dhaba_name","Suraj Dhaba");
                startActivity(i);


            }
        });


        ordersonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(getActivity(),OrderActivity.class);
                i.putExtra("dhaba_name","Sonu Dhaba");
                startActivity(i);


            }
        });


        orderthakur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(getActivity(),OrderActivity.class);
                i.putExtra("dhaba_name","Thakur Dhaba");
                startActivity(i);


            }
        });



        orderpunjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(getActivity(),OrderActivity.class);
                i.putExtra("dhaba_name","Punjabi Dhaba");
                startActivity(i);


            }
        });


        ordergopal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(getActivity(),OrderActivity.class);
                i.putExtra("dhaba_name","Gopal Dhaba");
                startActivity(i);


            }
        });














        //TextView SetOnClick
        numsuraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numsuraj.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });



        numsonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numsonu.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });




        numthakur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numthakur.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });




        numpanjabi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numpanjabi.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });




        numgopal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number=numgopal.getText().toString();
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                startActivity(intent);
            }
        });


    return v;
    }

}

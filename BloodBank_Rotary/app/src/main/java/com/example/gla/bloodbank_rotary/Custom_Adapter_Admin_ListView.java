package com.example.gla.bloodbank_rotary;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Custom_Adapter_Admin_ListView extends ArrayAdapter {


    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> bloodgroup = new ArrayList<String>();
    ArrayList<String> lastdonate = new ArrayList<String>();
    ArrayList<String> email = new ArrayList<String>();
    ArrayList<String> mobileno = new ArrayList<String>();
    ArrayList<String> mobileoffice = new ArrayList<String>();
    ArrayList<String> weight = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> state = new ArrayList<String>();
    ArrayList<String> district = new ArrayList<String>();

    Activity activity;
    View v;



    public Custom_Adapter_Admin_ListView(Activity activity, ArrayList<String> name,
                                         ArrayList<String> bloodgroup,
                                         ArrayList<String> lastdonate,ArrayList<String> email,
                                         ArrayList<String> state,
                                         ArrayList<String> mobileno,
                                         ArrayList<String> mobileoffice,
                                         ArrayList<String> weight,
                                         ArrayList<String> address,
                                         ArrayList<String> district){

        super(activity, R.layout.custom_layout, name);

        this.activity = activity;
        this.name = name;
        this.bloodgroup=bloodgroup;
        this.lastdonate=lastdonate;
        this.email=email;
        this.mobileno=mobileno;
        this.mobileoffice=mobileoffice;
        this.weight=weight;
        this.address=address;
        this.state=state;
        this.district=district;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = activity.getLayoutInflater();
        v = inflater.inflate(R.layout.custom_layout, null);

        final TextView tvname = v.findViewById(R.id.name);
        final TextView tvbloodgroup = v.findViewById(R.id.bloodgroup);
        final TextView tvlastdonate = v.findViewById(R.id.lastdonate);
        final TextView tvemail= v.findViewById(R.id.email);
        final TextView tvmobileno = v.findViewById(R.id.mobileno);
        final TextView tvmobileoffice = v.findViewById(R.id.mobileoffice);
        final TextView tvweight = v.findViewById(R.id.weight);
        final TextView tvaddress = v.findViewById(R.id.address);
        final TextView tvstate = v.findViewById(R.id.state);
        final TextView tvdistrict = v.findViewById(R.id.district);

        tvname.setText(""+ name.get(position));
        tvbloodgroup.setText(""+ bloodgroup.get(position));
        tvlastdonate.setText(""+ lastdonate.get(position));
        tvemail.setText(""+ email.get(position));
        tvmobileno.setText(""+ mobileno.get(position));
        tvmobileoffice.setText(""+mobileoffice.get(position));
        tvweight.setText(""+ weight.get(position)+" Kg");
        tvaddress.setText(""+ address.get(position));
        tvstate.setText(""+ state.get(position));
        tvdistrict.setText(""+ district.get(position));


        tvmobileno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=mobileno.get(position);

                if (number.equals("NA"))
                {
                    Toast.makeText(activity, "Number not Available ?", Toast.LENGTH_SHORT).show();
                }
                else {
                    call(number);
                }

            }
        });

        tvmobileoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=mobileoffice.get(position);

                if (number.equals("NA"))
                {
                    Toast.makeText(activity, "No not Avalable ?", Toast.LENGTH_SHORT).show();
                }
                else {
                    call(number);
                }

            }
        });




        return v;
    }


    public void call(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(v.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) { return;        }
        activity.startActivity(intent);
    }
}


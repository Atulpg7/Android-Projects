package com.example.atulkumar.glavisitorsapp;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter_Admin_ListView extends ArrayAdapter {


    ArrayList<String> name = new ArrayList<String>();
    ArrayList<String> mobileno = new ArrayList<String>();
    ArrayList<String> work = new ArrayList<String>();
    ArrayList<String> gate = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();

    Activity activity;
    View v;



    public Custom_Adapter_Admin_ListView(Activity activity, ArrayList<String> name,
                          ArrayList<String> mobileno,
                          ArrayList<String> work,ArrayList<String> gate,ArrayList<String> address){

        super(activity, R.layout.custom_admin_listview, name);

        this.activity = activity;
        this.name = name;
        this.work=work;
        this.gate=gate;
        this.address=address;
        this.mobileno=mobileno;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = activity.getLayoutInflater();
        v = inflater.inflate(R.layout.custom_admin_listview, null);

        final TextView tvname = v.findViewById(R.id.name);
        final TextView tvmobile = v.findViewById(R.id.mobileno);
        final TextView tvwork = v.findViewById(R.id.work);
        final TextView tvgate= v.findViewById(R.id.gate);
        final TextView tvaddress = v.findViewById(R.id.address);

        tvname.setText(" "+ name.get(position));
        tvmobile.setText(" "+ mobileno.get(position));
        tvwork.setText(" "+ work.get(position));
        tvgate.setText(" "+ gate.get(position));
        tvaddress.setText(" "+ address.get(position));

        return v;
    }
}

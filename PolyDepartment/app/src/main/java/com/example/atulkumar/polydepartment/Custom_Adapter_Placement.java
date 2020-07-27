package com.example.atulkumar.polydepartment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_Adapter_Placement extends ArrayAdapter<String> {

    Activity activity;
    String names[];
    String company[];
    String session[];

    public Custom_Adapter_Placement(Activity activity, String names[],
                                    String company[], String session[])
    {
        super(activity,R.layout.custom_placements,names);

        //text :- Array ke parameterized constructor ko chalane ke liye

        //Passing local variable data in instance
        //jo aa rhe hai main se wo local hai jo upar declare hai wo instance hai
        this.activity=activity;
        this.names=names;
        this.company=company;
        this.session=session;


    }

//Automatically Called getview by the array adapter
    //if we want any change then we have to change in getview
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        LayoutInflater inflator=activity.getLayoutInflater();

        //Layout Infilator :-ek class hai jo allow karti hai ki hum kisi bhi
        //layout kar skte hai

        View v=inflator.inflate(R.layout.custom_placements,null);

      TextView tvname=v.findViewById(R.id.txtname);
      TextView tvcompany=v.findViewById(R.id.txtbranchplacmnt);
      TextView tvbranch=v.findViewById(R.id.txtsession);

        tvname.setText(names[position]);
        tvcompany.setText(company[position]);
        tvbranch.setText(session[position]);


        return v;
    }
}

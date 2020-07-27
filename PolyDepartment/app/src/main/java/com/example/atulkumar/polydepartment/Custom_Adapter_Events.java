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

public class Custom_Adapter_Events extends ArrayAdapter<String> {

    Integer images[];
    Activity activity;
    String names[];
    String dates[];
    String branchs[];

    public Custom_Adapter_Events(Activity activity, String names[],
                                 String dates[],String branchs[],Integer images[])
    {
        super(activity,R.layout.custom_events,names);

        //text :- Array ke parameterized constructor ko chalane ke liye

        //Passing local variable data in instance
        //jo aa rhe hai main se wo local hai jo upar declare hai wo instance hai
        this.activity=activity;
        this.images=images;
        this.names=names;
        this.dates=dates;
        this.branchs=branchs;


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

        View v=inflator.inflate(R.layout.custom_events,null);

      TextView tvname=v.findViewById(R.id.txtname);
      TextView tvdate=v.findViewById(R.id.txtdate);
      TextView tvbranch=v.findViewById(R.id.txtbranch);
      ImageView iv=v.findViewById(R.id.eventimgview);

        tvname.setText("Name: "+names[position]);
        tvdate.setText("Date: "+dates[position]);
        tvbranch.setText("Branch: "+branchs[position]);
        iv.setImageResource(images[position]);


        return v;
    }
}

package com.example.atulkumar.notescorner;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter_Topics extends ArrayAdapter {

   ArrayList<String> name;
   Activity activity;
   public Custom_Adapter_Topics(Activity activity, ArrayList<String> name)
   {

       super(activity,R.layout.custom_adapter_topics,name);
       this.activity=activity;
       this.name=name;;

   }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater=activity.getLayoutInflater();
        View v=inflater.inflate(R.layout.custom_adapter_topics,null );

        TextView tvname=v.findViewById(R.id.topicname);

        tvname.setText(" "+name.get(position));
       return v;
    }
}

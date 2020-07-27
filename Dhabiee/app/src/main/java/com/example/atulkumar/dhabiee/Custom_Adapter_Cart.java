package com.example.atulkumar.dhabiee;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter_Cart extends ArrayAdapter {



    ArrayList<String> itemarray = new ArrayList<String>();
    ArrayList<Integer> pricearray = new ArrayList<Integer>();
    ArrayList<Integer> quantityarray = new ArrayList<Integer>();
    ArrayList<Integer> totalarray = new ArrayList<Integer>();
    Activity activity;

    View v;



    public Custom_Adapter_Cart(Activity activity, ArrayList<String> itemarray,
                          ArrayList<Integer> pricearray,ArrayList<Integer> quantityarray
                               ,ArrayList<Integer> totalarray) {

        super(activity, R.layout.custom_layout, itemarray);

        this.activity = activity;
        this.itemarray = itemarray;
        this.pricearray = pricearray;
        this.quantityarray = quantityarray;
        this.totalarray = totalarray;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = activity.getLayoutInflater();
        v = inflater.inflate(R.layout.custom_cart, null);

        TextView item,price,quantity,total;

        item=v.findViewById(R.id.item);
        price=v.findViewById(R.id.price);
        quantity=v.findViewById(R.id.quantity);
        total=v.findViewById(R.id.total);


        item.setText("" + itemarray.get(position));
        price.setText("" + pricearray.get(position));
        quantity.setText("" + quantityarray.get(position));
        total.setText("" + totalarray.get(position));

        return v;

    }
}

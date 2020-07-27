package com.example.atulkumar.dhabiee;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {


    Spinner cartspinner;
    Button btnplaceorder;
    ListView listViewCart;


    String area[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartspinner=findViewById(R.id.spinnercart);
        btnplaceorder=findViewById(R.id.btnplaceorder);
        listViewCart=findViewById(R.id.listViewcart);

        area=getResources().getStringArray(R.array.gate);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,area);

        cartspinner.setAdapter(adapter);

        btnplaceorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String address=cartspinner.getSelectedItem().toString();


                if (address.equals("Delivery Gate"))
                {
                    View parentLayout = findViewById(android.R.id.content);
                    Snackbar.make(parentLayout, "Please Select Delivery Gate :(", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(CartActivity.this, ""+address, Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}

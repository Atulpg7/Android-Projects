package com.example.edu_app;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
public class fire_safty extends Activity {
	ImageView t1,t2;
	
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire_safty);
        
       
       t1 =(ImageView) findViewById(R.id.ragging);
      t2 =(ImageView) findViewById(R.id.fire);
        
      t1.setOnClickListener(new OnClickListener() 
      { 
    public void onClick(View v) 
    { 
    	Intent callIntent = new Intent(Intent.ACTION_CALL); 
    	callIntent.setData(Uri.parse("tel:08192815000")); 
    	startActivity(callIntent);}
    
      
      
      });

      t2.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09761888994"));startActivity(callIntent);}});
         
        
}


public void calling(){
    new AlertDialog.Builder(this)
           .setMessage("Are you sure you want call?")
           .setCancelable(false)
           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
            	  
               }
           })
           .setNegativeButton("No", null)
           .show();
}


}

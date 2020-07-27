package com.example.edu_app;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
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
public class directory extends Activity {
	
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directory); 
        
       
        TextView t1 =(TextView) findViewById(R.id.t1);
       TextView t2 =(TextView) findViewById(R.id.t2);
        TextView t3 =(TextView) findViewById(R.id.t3);
        TextView t4 =(TextView) findViewById(R.id.t4);
        TextView t5 =(TextView) findViewById(R.id.t5);
        TextView t6 =(TextView) findViewById(R.id.t6);
        TextView t7 =(TextView) findViewById(R.id.t7);
        TextView t8 =(TextView) findViewById(R.id.t8);
        TextView t9 =(TextView) findViewById(R.id.t9);
        TextView t10 =(TextView) findViewById(R.id.t10);
        TextView t11 =(TextView) findViewById(R.id.t11);
        TextView t12 =(TextView) findViewById(R.id.t12);
       
        TextView t14 =(TextView) findViewById(R.id.t14);
        TextView t15 =(TextView) findViewById(R.id.t15);
      
        TextView t17 =(TextView) findViewById(R.id.t17);
        TextView t18 =(TextView) findViewById(R.id.t18);
        TextView t19 =(TextView) findViewById(R.id.t19);
        TextView t20 =(TextView) findViewById(R.id.t20);
	TextView t21 =(TextView) findViewById(R.id.t21);
	TextView t22 =(TextView) findViewById(R.id.t22);
	TextView t23 =(TextView) findViewById(R.id.t23);
	TextView t24 =(TextView) findViewById(R.id.t24);
	TextView t25 =(TextView) findViewById(R.id.t25);
	TextView t26 =(TextView) findViewById(R.id.t26);
	TextView t27 =(TextView) findViewById(R.id.t27);
	
	TextView t29 =(TextView) findViewById(R.id.t29);
	TextView t30 =(TextView) findViewById(R.id.t30);
	
	TextView t31 =(TextView) findViewById(R.id.t31);
	TextView tt1 =(TextView) findViewById(R.id.tt1);
	TextView tt2 =(TextView) findViewById(R.id.tt2);
	TextView tt3 =(TextView) findViewById(R.id.tt3);

	

        t1.setOnClickListener(new OnClickListener() { public void onClick(View v) { Intent callIntent = new Intent(Intent.ACTION_CALL); callIntent.setData(Uri.parse("tel:08192815000")); startActivity(callIntent);}});
        t2.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09927064019"));startActivity(callIntent);}});
        t3.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09760077922"));startActivity(callIntent);}});   
        t4.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09927211500"));startActivity(callIntent);}});
        t5.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09927223500"));startActivity(callIntent);}});
        t6.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09450287452"));startActivity(callIntent);}});
        t7.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09897704988"));startActivity(callIntent);}});
        t8.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412624713"));startActivity(callIntent);}});
        t9.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09897065354"));startActivity(callIntent);}});
        t10.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412829763"));startActivity(callIntent);}});
        t11.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09997077388"));startActivity(callIntent);}});
        t12.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09897742100"));startActivity(callIntent);}});
       
        t14.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:07351817363"));startActivity(callIntent);}});
        t15.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412179820"));startActivity(callIntent);}});
       
        t17.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09012483500"));startActivity(callIntent);}});
        t18.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412353562"));startActivity(callIntent);}});
        t19.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09897436757"));startActivity(callIntent);}});
        t20.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09897040971"));startActivity(callIntent);}});
        t21.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412383869"));startActivity(callIntent);}});
        t22.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412280122"));startActivity(callIntent);}});
        t23.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:07895010874"));startActivity(callIntent);}});
        t24.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09412284009"));startActivity(callIntent);}});
        t25.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09359059129"));startActivity(callIntent);}});
        t26.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09411065400"));startActivity(callIntent);}});
        t27.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:07830775997"));startActivity(callIntent);}});
       
        t29.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09760929029"));startActivity(callIntent);}});
        t30.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09719431820"));startActivity(callIntent);}});
        t31.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09410424782"));startActivity(callIntent);}});
       

        tt1.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:0565-2471152"));startActivity(callIntent);}});
        tt2.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:0565-2471368"));startActivity(callIntent);}});
        tt3.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:09012359063"));startActivity(callIntent);}});
       



    
        
        
        
        
        
        
        
}
}


package com.example.edu_app;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import java.util.List;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.AdapterView.OnItemClickListener;
import android.net.ConnectivityManager;
import android.util.Log;
import android.os.Handler;
import android.view.Menu;
import org.ksoap2.serialization.PropertyInfo;
import com.example.edu_app.MainActivity;
import com.example.edu_app.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;

public class act_deact extends Activity {
	public final String METHOD_NAME =  "ActivateServices"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/ActivateServices"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	private Spinner spinner2, spinner3, spinner4;
	 @SuppressLint("NewApi")
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.act_deact);       
	  
	        addItemsOnSpinner2(); 
	        addItemsOnSpinner3();
	 
      addItemsOnSpinner4(); 
	 }
	 
	 public void subbtn(View v)
 	{

	//String rollno = getIntent().getExtras().getString("roll");
	
	spinner2 = (Spinner) findViewById(R.id.spinner2);
	spinner3 = (Spinner) findViewById(R.id.spinner3);
	spinner4 = (Spinner) findViewById(R.id.spinner4);
	
	
	//String dd2 = spinner2.toString();
	String dd2 = spinner2.getSelectedItem().toString();
	String dd3 = spinner3.getSelectedItem().toString();
	String dd4 = spinner4.getSelectedItem().toString();
//	String dd4 = spinner4.toString();

	 try
		{
		 
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("type",dd2);
		request.addProperty("activity", dd3 );
		request.addProperty("status",dd4 );
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION,envelope);
		Object result = envelope.getResponse();
		System.out.println("Result :" + result.toString());
	
		
			if(result.toString().equals("True"))
    	{
			Toast toto =  Toast.makeText(getApplicationContext(), " Successfully Activated  ", Toast.LENGTH_LONG);
			toto.show();
    	}
    	else
    	{
    		Toast otto =  Toast.makeText(getApplicationContext(), "Successfully DeActivated   ", Toast.LENGTH_LONG);
    		otto.show();
    	}			
	
   
		}
		catch (Exception E) {
		E.printStackTrace();		
		Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
		   t4.show();
		} 
 		
 	}
 		
	 

public void addItemsOnSpinner2() {

	spinner2 = (Spinner) findViewById(R.id.spinner2);
	List<String> list = new ArrayList<String>();
	list.add("");
	list.add("STUDENT");
	list.add("STAFF");
	
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}

public void addItemsOnSpinner3() {

	spinner3 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("");
	list.add("LOGIN");
	list.add("ATTENDANCE");
	list.add("RESULT");
	list.add("FEEDBACK");
	list.add("QUIZ");
	list.add("SALARY");
	list.add("SENDMESSAGE");
	
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner3.setAdapter(dataAdapter);
}

public void addItemsOnSpinner4() {

	spinner4 = (Spinner) findViewById(R.id.spinner4);
	List<String> list = new ArrayList<String>();
	list.add("");
	list.add("TRUE");
	list.add("FALSE");
	
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner4.setAdapter(dataAdapter);
}
}


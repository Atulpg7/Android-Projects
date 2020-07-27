package com.example.edu_app;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.media.MediaPlayer;
import com.example.edu_app.MainActivity;
import com.example.edu_app.R;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;

public class empforgetpassword extends Activity {
	
	public final String METHOD_NAME =  "empforget_pwd"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/empforget_pwd"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	/** Called when the activity is first created. */
	 private Button button1;
	 private static int myProgress;
	  private ProgressBar progressBar;
	  private Handler myHandler=new Handler();
	  private int progressStatus=0;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.empforgetpassword);		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		final TextView tv = (TextView) findViewById(R.id.txtAddition);
		final Button btn = (Button) findViewById(R.id.button1);

		btn.setOnClickListener(new OnClickListener() {	
			 
            public void onClick(View v) {
            	
     
            	final EditText et = (EditText) findViewById(R.id.editText1);
            	final EditText et1 = (EditText) findViewById(R.id.editText2);
            	
            	myProgress=0;
                progressBar=(ProgressBar)findViewById(R.id.myProgress);
                progressBar.setVisibility(0);
                /*Do some work in background thread*/ 
                new Thread(new Runnable() {
        			
        			@Override
        			public void run() {
        				// TODO Auto-generated method stub
        				while(progressStatus<10)
        				{
        					progressStatus=performTask();
        						
        				}
        				/*Hides the Progress bar*/
        				myHandler.post(new Runnable() {
        					
        					@Override
        					public void run() {
        						// TODO Auto-generated method stub
        						progressBar.setVisibility(6);
        					 //  Toast.makeText(getBaseContext(),"Task Completed",Toast.LENGTH_LONG).show();
        	                   progressStatus=0;        					
        					}       				
        				});       				
        			}
        			/* Do some task*/
        			private int performTask()
        			{
        				try {
        					//---simulate doing some work---
        					Thread.sleep(1000);
        					} catch (InterruptedException e)
        					{
        					e.printStackTrace();
        					}
        					return ++myProgress;	
        			}
        		}).start();	
 	    
		try
		{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("empid",et.getText().toString());
		request.addProperty("email",et1.getText().toString());
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION,envelope);
		Object result = envelope.getResponse();
		System.out.println("Result :" + result.toString());
		
			//((TextView) findViewById (R.id.txtAddition)).setText("invalid Username and password : "+result.toString());
			Toast t1 =  Toast.makeText(getApplicationContext(),result.toString(), Toast.LENGTH_LONG);
			t1.show();
			et.setText("");
			et1.setText("");
				} catch (Exception E) {
		E.printStackTrace();
		Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
		t1.show();
		}    
		   }       
    });
	}
}

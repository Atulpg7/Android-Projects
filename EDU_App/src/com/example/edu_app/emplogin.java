package com.example.edu_app;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Gravity;
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
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;

public class emplogin extends Activity {	
	//MediaPlayer song1;
	public final String METHOD_NAME =  "emplogin"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/emplogin"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/result.asmx";
	/** Called when the activity is first created. */
	 private Button button1;
	// private static int myProgress; 
	// private ProgressBar progressBar;
	 private Handler myHandler=new Handler();
	 //private int progressStatus=0;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		//song1=MediaPlayer.create(emplogin.this, R.raw.empn);
		setContentView(R.layout.emplogin);
		//song1.start();
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}		
		final TextView tv = (TextView) findViewById(R.id.txtAddition);
		final Button btn1 = (Button) findViewById(R.id.login235);	
		btn1.setOnClickListener(new OnClickListener() {	 
            public void onClick(View v) {
            	final EditText et = (EditText) findViewById(R.id.editText1);
            	final EditText et1 = (EditText) findViewById(R.id.editText2);           	
            	//myProgress=0;
               // progressBar=(ProgressBar)findViewById(R.id.myProgress);
                //progressBar.setVisibility(0);
                 /*Do some work in background thread*/ 
                // new Thread(new Runnable() {        			
         			//@Override
         			//public void run() {
         				// TODO Auto-generated method stub
         				/*while(progressStatus<10)
         				{
         					progressStatus=performTask();	
         				}*/
         				/*Hides the Progress bar*/
         				//myHandler.post(new Runnable() {        					
         				//	@Override
         				//	public void run() {
         						// TODO Auto-generated method stub
         						//progressBar.setVisibility(6);
         	                  // progressStatus=0;         					
         					//}
         				//});		
         			//}
         			/* Do some task*/
         			//private int performTask()
         			//{
         				//try {
         					//---simulate doing some work---
         					//Thread.sleep(5);
         					//} catch (InterruptedException e)
         					//{
         					//e.printStackTrace();
         					//}
         					//return myProgress;	
         			//}
         		//});//.start();	    
		try
		{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("empid",et.getText().toString());
		request.addProperty("pwd",et1.getText().toString());
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION,envelope);
		SoapObject result = (SoapObject) envelope.getResponse();
		
		String rest[] = new String[result.getPropertyCount()];
		//System.out.println("Result :" + result.toString());
	for(int i =0 ; i<result.getPropertyCount();++i)
	{
		rest[i]=result.getProperty(i).toString();
	}
		
		if(rest[0].equals("Invalid Credentials"))
		{
			//((TextView) findViewById (R.id.txtAddition)).setText("invalid Username and password : "+result.toString());
			Toast t2 =  Toast.makeText(getApplicationContext(), " EmpID & Password are invalid ", Toast.LENGTH_LONG);
			t2.setGravity(Gravity.CENTER, 0, 0);
			   t2.show();
		}
		else
		{	
			//song1.release();
			//new String[]
			
		((TextView) findViewById (R.id.txtAddition)).setText("Hello! : "+result.toString());
		//Intent intent = new Intent(emplogin.this, emphome.class);
		Intent intent = new Intent(emplogin.this, testing_page.class);
	// intent.putExtra("name",result.toString());
		intent.putExtra("name",rest[0]);
		intent.putExtra("type",rest[1]);
		intent.putExtra("deg",rest[2]);
	  intent.putExtra("id1",et.getText().toString());
		  startActivity(intent);	
		}
		et.setText("");
		et1.setText("");
		}
		catch (Exception E) {
		E.printStackTrace();		
		Toast t1 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
		   t1.show();
		}    
		   }       
    });
	}
	  public void forget(View v)
	    {   
		 // song1.release();
			Intent i=new Intent(this,empforgetpassword.class );
			startActivity(i);
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}


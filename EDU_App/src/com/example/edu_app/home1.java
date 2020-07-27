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
import android.view.Gravity;
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

public class home1 extends Activity {
	//MediaPlayer song;
	public final String METHOD_NAME =  "HelloWorld"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/HelloWorld"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/result.asmx";
	/** Called when the activity is first created. */
	 private Button button1;
	 // private static int myProgress;
	 // private ProgressBar progressBar;
	  private Handler myHandler=new Handler();
	 // private int progressStatus=0;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//song=MediaPlayer.create(home1.this, R.raw.jay);
		
		setContentView(R.layout.home);
		//song.start();
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		final TextView tv = (TextView) findViewById(R.id.txtAddition);
		//final Button btn = (Button) findViewById(R.id.button1);
		final Button btn = (Button) findViewById(R.id.login234);
		btn.setOnClickListener(new OnClickListener() {	
            public void onClick(View v) {
            	final EditText et = (EditText) findViewById(R.id.editText1);
            	final EditText et1 = (EditText) findViewById(R.id.editText2);           	
            	// myProgress=0;
                // progressBar=(ProgressBar)findViewById(R.id.myProgress);
                // progressBar.setVisibility(0);
                 /*Do some work in background thread*/ 
                 //new Thread(new Runnable() {        			
         		//	@Override
         			//public void run() {
         				// TODO Auto-generated method stub
         			//	while(progressStatus<10)
         				//{
         				//	progressStatus=performTask();
         						
         				//}
         				/*Hides the Progress bar*/
         				//myHandler.post(new Runnable() {      					
         				//	@Override
         					//public void run() {
         						// TODO Auto-generated method stub
         					//	progressBar.setVisibility(6);
         					 //  Toast.makeText(getBaseContext(),"Task Completed",Toast.LENGTH_LONG).show();
         	                 //  progressStatus=0; 
         					
         					//}       				
         				//});      				
         			//}
         			/* Do some task*/
         			//private int performTask()
         			//{
         				//try {
         					//---simulate doing some work---
         					//Thread.sleep(6);
         					//} catch (InterruptedException e)
         					//{
         					//e.printStackTrace();
         					//}
         					//return myProgress;	
         			//}
         		//});    
		try
		{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("rollno",et.getText().toString());
		request.addProperty("password",et1.getText().toString());
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
		System.out.println("Result :" + result.toString());

		if(rest[0].equals("Invalid"))
		{
			//((TextView) findViewById (R.id.txtAddition)).setText("invalid Username and password : "+result.toString());
			Toast t2 =  Toast.makeText(getApplicationContext(), "Roll. No. & Password are invalid ", Toast.LENGTH_LONG);
		t2.setGravity(Gravity.CENTER, 0, 0);
			   t2.show();
		}
		else
		{	   
			//song.release();
		((TextView) findViewById (R.id.txtAddition)).setText("Welcome! : "+result.toString());
		Intent intent = new Intent(home1.this, another1.class);
	  // intent.putExtra("name",result.toString());
		intent.putExtra("name",rest[0]);
		intent.putExtra("sem",rest[1]);
		   intent.putExtra("id1",et.getText().toString());
		   startActivity(intent);
		}
		et.setText("");
		et1.setText("");
		} catch (Exception E) {
		E.printStackTrace();
		
		
		}    
		   }       
    });
	}
	  public void forget(View v)
	    {   
		 // song.release();
			Intent i=new Intent(this,forget.class );
			startActivity(i);
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
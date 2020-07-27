package com.example.edu_app;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.net.ConnectivityManager;

import android.os.Handler;

import android.view.Menu;
import android.view.View.OnClickListener;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import com.example.edu_app.MainActivity;
import com.example.edu_app.R;


import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;



public class sylla extends Activity {
	
	private static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	  private ProgressDialog mProgressDialog;
	public final String METHOD_NAME =  "syllabus"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/syllabus"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sylla);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		String name1 = getIntent().getExtras().getString("attname");
		String rollno = getIntent().getExtras().getString("roll");
		String sem1 = getIntent().getExtras().getString("sem");
		((TextView) findViewById (R.id.name)).setText("Name - "+name1.toString());
		((TextView) findViewById (R.id.rollno)).setText("Univ. RollNo - "+rollno.toString());
		((TextView) findViewById (R.id.sem)).setText("Semester - "+sem1.toString());
		

    final ImageButton ibtn1 = (ImageButton) findViewById(R.id.syl);
  ibtn1.setOnClickListener(new OnClickListener() {					 
       
		
		public void onClick(View v) {
        	   	
  try
	{
	  String empcode1 =getIntent().getExtras().getString("roll");
    	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	request.addProperty("empid",empcode1);
    	request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		//request.addProperty("m",month4.toString());
		//request.addProperty("y",month5.toString());
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION,envelope);
		SoapObject result =(SoapObject) envelope.getResponse();
		String rest[] = new String[result.getPropertyCount()];
		for(int i =0 ; i<result.getPropertyCount();++i)
		{
			rest[i]=result.getProperty(i).toString();
		}
			

			if(rest[0].equals("Invalid Credentials"))
			{
				//((TextView) findViewById (R.id.txtAddition)).setText("invalid Username and password : "+result.toString());
				Toast t2 =  Toast.makeText(getApplicationContext(), "Contact To Admin For Correction", Toast.LENGTH_LONG);
				   t2.show();
			}
			else
			{
				String url = result.toString();
	       		startDownload(url) ;
				
			}
		
	}
    catch (Exception E) {
		E.printStackTrace();
		Toast t1 =  Toast.makeText(getApplicationContext(), " Syllabus not updated ", Toast.LENGTH_LONG);
		t1.show();
		}
  
        }
	});
	}
	 private void startDownload(String url) {	     
	        new DownloadFileAsync().execute(url);
	    }	    
	    @Override
	    protected Dialog onCreateDialog(int id) {
	      
			switch (id) {
	    	case DIALOG_DOWNLOAD_PROGRESS:
	    		mProgressDialog = new ProgressDialog(this);
	    		mProgressDialog.setMessage("Downloading file..");
	    		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	    		mProgressDialog.setCancelable(false);
	    		mProgressDialog.show();
	    		return mProgressDialog;
	    	default:
	    		return null;
	        }
	    }
	    class DownloadFileAsync extends AsyncTask<String, String, String> {

	    @Override
	    protected void onPreExecute() {
	    	super.onPreExecute();
	    	showDialog(DIALOG_DOWNLOAD_PROGRESS);
	    }

	    @Override
	    protected String doInBackground(String... aurl) {
	    	int count;
	    try {

	    URL url = new URL(aurl[0]);
	    URLConnection conexion = url.openConnection();
	    conexion.connect();
	    int lenghtOfFile = conexion.getContentLength();
	    Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);
	    InputStream input = new BufferedInputStream(url.openStream());
	    OutputStream output = new FileOutputStream("/sdcard/Syllabus.pdf");
	    byte data[] = new byte[1024];
	    long total = 0;

	    	while ((count = input.read(data)) != -1) {
	    		total += count;
	    		publishProgress(""+(int)((total*100)/lenghtOfFile));
	    		output.write(data, 0, count);
	    	}

	    	output.flush();
	    	output.close();
	    	input.close();
	    } catch (Exception e) {}
	    return null;

	    }
	    protected void onProgressUpdate(String... progress) {
	    	 Log.d("ANDRO_ASYNC",progress[0]);
	    	 mProgressDialog.setProgress(Integer.parseInt(progress[0]));
	    }

	    @Override
	    protected void onPostExecute(String unused) {
	    	dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
	    }
 }
	    
}
	

	
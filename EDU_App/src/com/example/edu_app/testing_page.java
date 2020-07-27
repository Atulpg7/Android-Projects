package com.example.edu_app;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.edu_app.another1.myWebClient;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.content.Context;
import android.view.View.OnClickListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;



public class testing_page extends Activity {
	public final String METHOD_NAME =  "statusmsg";
	public final String METHOD_NAME2 =  "ActivatedServices";// our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/statusmsg";
	public final String SOAP_ACTION2 = "http://tempuri.org/ActivatedServices";// NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	 String urlimg; 
	        
	    ImageView imageView;
	 
	
	WebView br;
	ProgressBar pbr;
	String url= "http://www.google.com";
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing_page); 
        
        setTitle("GLA University, Mathura");
        
    	String rolln=getIntent().getExtras().getString("id1");
        String name1=getIntent().getExtras().getString("name");
    	String type1=getIntent().getExtras().getString("type");
    	String deg1=getIntent().getExtras().getString("deg");
    	
    	urlimg = "http://glauniversity.in:8088//assets/profiles/" +rolln.toString() + ".jpg";
    	
    	((TextView) findViewById(R.id.namedede)).setText(name1.toString());
    	((TextView) findViewById(R.id.desig)).setText(deg1.toString());
    	
    	 imageView = (ImageView) findViewById(R.id.nd_drw);
    	// Create an object for subclass of AsyncTask
    	 
         GetXMLTask task = new GetXMLTask();
         // Execute the task
         task.execute(new String[] { urlimg });
    	
     	/*final Activity activity = this;
     	activity.setTitle("GLA University-"+name1);*/
         
         
         ActionBar actionbar = getActionBar();

     	 TextView textview = new TextView(testing_page.this);

     	 LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
     	 
     	 textview.setLayoutParams(layoutparams);

     	 textview.setText("Hi, "+ name1.toString());

     	 textview.setTextColor(Color.WHITE);
     	 
     	 textview.setGravity(Gravity.RIGHT);

     	 textview.setTextSize(13);

     	 actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

     	 actionbar.setCustomView(textview);
         
         
         
    	/*if(type1.equals("NON TEACHING")|| type1.equals("")) 
    			{
    		ImageButton btn17 = (ImageButton) findViewById(R.id.send_msg);
    		//TextView tx1 = (TextView) findViewById(R.id.txtsend);
    		//tx1.setVisibility(View.INVISIBLE);
    		btn17.setVisibility(View.INVISIBLE);
    			}*/
    	/*((TextView) findViewById(R.id.name)).setText("Hello, "+name1.toString());
    	
    	
    	TextView txt1 = (TextView) findViewById(R.id.logout);
    	txt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // do you work here
            	
            	Intent i=new Intent(testing_page.this,MainActivity.class );
            	startActivity(i);
            	
             }
            });*/
         String roll=getIntent().getExtras().getString("id1");
    	 try
    		{
    		
    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    		//request.addProperty("name",name.toString());//name.toString()
    		request.addProperty("id",roll);//rollno.toString()
    		request.addProperty("servicekey","thisismycommunicationapp");
    		request.addProperty("servicetype","SOFT");
    		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    		envelope.dotNet = true;
    		envelope.setOutputSoapObject(request);
    		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    		androidHttpTransport.call(SOAP_ACTION,envelope);
    		Object result = envelope.getResponse();
    		System.out.println("Result :" + result.toString());

    		String t1 = result.toString();
    		((TextView) findViewById(R.id.count)).setText(t1);
    		}
    		catch (Exception E) {
    		E.printStackTrace();	
    		
    		Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
    		   t4.show();
    		}    	

    	 
    	 // Notice For staff
      
    	 try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
    			request.addProperty("type","STAFF");//rollno.toString()
    			request.addProperty("activity","NOTICE");//rollno.toString()
    			request.addProperty("servicekey","thisismycommunicationapp");
    			request.addProperty("servicetype","SOFT");
    			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    			envelope.dotNet = true;
    			envelope.setOutputSoapObject(request);
    			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    			androidHttpTransport.call(SOAP_ACTION2,envelope);
    			Object result = envelope.getResponse();
    			System.out.println("Result :" + result.toString());

    				if(result.toString().equals("True"))
    		{
    					 br = (WebView) findViewById(R.id.webview);
    				        pbr = (ProgressBar) findViewById(R.id.progress1);
    				        br.setWebViewClient(new myWebClient());
    				        br.getSettings().setJavaScriptEnabled(true);
    				        br.getSettings().setPluginsEnabled(true);
    				        br.getSettings().setSupportZoom(true);
    				        br.getSettings().setBuiltInZoomControls(true);
    				        br.getSettings().setTextZoom(90);
    				        br.getSettings().setAllowFileAccess(true);
    				        br.loadUrl("http://glauniversity.in:8083/MyAppContent.aspx?RequestFor=StaffNotice&Univ="+roll.toString());

    		}
    		else
    		{
    			Toast t4 =  Toast.makeText(getApplicationContext(), " Sorry!! Notice Activity is Stoped by administrator for some time ", Toast.LENGTH_LONG);
    			   t4.show();
    			   br = (WebView) findViewById(R.id.webview);
			        pbr = (ProgressBar) findViewById(R.id.progress1);
			        br.setWebViewClient(new myWebClient());
			        br.getSettings().setJavaScriptEnabled(true);
			        br.getSettings().setSupportZoom(true);
			      	br.getSettings().setBuiltInZoomControls(true);
			      	br.getSettings().setTextZoom(90);
			        br.loadUrl("");
    			   
    		}
    		
    		}
    		catch (Exception E) {
    		E.printStackTrace();		
    		Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
    		   t4.show();
    		}
    	 
    	 
       
}

@Override
public void onBackPressed() {
    new AlertDialog.Builder(this)
           .setMessage("Are you sure you want to exit?")
           .setCancelable(false)
           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    testing_page.this.finish();
               }
           })
           .setNegativeButton("No", null)
           .show();
}


private class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap map = null;
        for (String url : urls) {
            map = downloadImage(url);
        }
        return map;
    }

    // Sets the Bitmap returned by doInBackground
    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }

    // Creates Bitmap from InputStream and returns it
    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        InputStream stream = null;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inSampleSize = 1;

        try {
            stream = getHttpConnection(url);
            bitmap = BitmapFactory.
                    decodeStream(stream, null, bmOptions);
            stream.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bitmap;
    }

    // Makes HttpURLConnection and returns InputStream
    private InputStream getHttpConnection(String urlString)
            throws IOException {
        InputStream stream = null;
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        try {
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            httpConnection.setRequestMethod("GET");
            httpConnection.connect();

            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                stream = httpConnection.getInputStream();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stream;
    }

}






String tv;
public void empsalary(View v)
{ 
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STAFF");//rollno.toString()
		request.addProperty("activity","SALARY");//rollno.toString()
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION2,envelope);
		Object result = envelope.getResponse();
		System.out.println("Result :" + result.toString());

			if(result.toString().equals("True"))
	{
				String name=getIntent().getExtras().getString("name");
				String rollno=getIntent().getExtras().getString("id1");
				String deg1=getIntent().getExtras().getString("deg");
					Intent i=new Intent(this,empsalary.class );
					 i.putExtra("attname",name.toString());
					i.putExtra("roll",rollno.toString());
					i.putExtra("deg",deg1.toString());
					startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " SALARY Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

	
	
}

public void home(View v)
{    	

	 br = (WebView) findViewById(R.id.webview);
	 br.reload();
	 
}

public void log_out(View v)
{    	
	 new AlertDialog.Builder(this)
     .setMessage("Are you sure you want to exit?")
     .setCancelable(false)
     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int id) {
              testing_page.this.finish();
         }
     })
     .setNegativeButton("No", null)
     .show();
	 
}

public void attendence(View v)
{   
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STAFF");//rollno.toString()
		request.addProperty("activity","ATTENDANCE");//rollno.toString()
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION2,envelope);
		Object result = envelope.getResponse();
		System.out.println("Result :" + result.toString());

			if(result.toString().equals("True"))
	{
				String name=getIntent().getExtras().getString("name");
				String rollno=getIntent().getExtras().getString("id1");
				String deg1=getIntent().getExtras().getString("deg");
					Intent i=new Intent(this,empattendance.class );
					  i.putExtra("attname",name.toString());
					  i.putExtra("roll",rollno.toString());
					  i.putExtra("deg",deg1.toString());
					startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " ATTENDANCE Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

	

}

public void time(View v)
{  
	String type1=getIntent().getExtras().getString("type");
	
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STAFF");//rollno.toString()
		request.addProperty("activity","TIMETABLE");//rollno.toString()
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION2,envelope);
		Object result = envelope.getResponse();
		System.out.println("Result :" + result.toString());

			if(result.toString().equals("True") || type1.equals("TEACHING"))
	{
				String rollno=getIntent().getExtras().getString("id1");
				 if (MainActivity.getInstance(this).isOnline()) {
					// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
			        //startActivity(browserIntent);
					 Intent i = new Intent(testing_page.this, fire.class);
			 		i.putExtra("urldata","http://glauniversity.in:8083/MyAppContent.aspx?RequestFor=STT&Univ="+rollno.toString());
			 		   startActivity(i);
			    } else {
			        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
			        t1.show(); 
			    }
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " Time Table Activity is Deactivated from your Account  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}
	
	
	
	
}
public void empfeedback(View v)
{    
//String name=getIntent().getExtras().getString("name");
String rollno=getIntent().getExtras().getString("id1");
	Intent i=new Intent(this,empfeedback.class );
	 // i.putExtra("attname",name.toString());
	  i.putExtra("roll",rollno.toString());
	  i.putExtra("type", "Employee");
	startActivity(i);
}

public void search_student(View v)
{    
	Intent i=new Intent(this,search_student.class );
	startActivity(i);
}

public void logout(View v)
{    	
	Intent i=new Intent(this,MainActivity.class );
	startActivity(i);
}

public void prep(View v)
{  
	String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://172.16.10.15:8080/output2.aspx?emp=" + rollno.toString()));
   // startActivity(browserIntent);
		
		 Intent i = new Intent(testing_page.this, fire.class);
 		//i.putExtra("urldata","http://172.16.10.15:8080/output2.aspx?emp=" + rollno.toString());
			i.putExtra("urldata","http://glauniversity.in:8103/TestOutput.aspx");
 		   startActivity(i);
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}

/*public void admin(View v)
{    
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STAFF");//rollno.toString()
		request.addProperty("activity","SENDMESSAGE");//rollno.toString()
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION2,envelope);
		Object result = envelope.getResponse();
		System.out.println("Result :" + result.toString());

			if(result.toString().equals("True"))
	{
				String rollno=getIntent().getExtras().getString("id1");
				Intent i=new Intent(this,demo.class );
				i.putExtra("roll",rollno.toString());
				startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " SENDMESSAGE Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

	
}
*/
/*public void empalert(View v)
{    String rollno=getIntent().getExtras().getString("id1");	
	Intent i=new Intent(this,empalert.class );
	i.putExtra("roll",rollno.toString());
	startActivity(i);
}*/
public void search(View v)
{   // String rollno=getIntent().getExtras().getString("id1");	
	Intent i=new Intent(this,search.class );
	//i.putExtra("roll",rollno.toString());
	startActivity(i);
}

public void car(View v)
{ 
	
	String rollno=getIntent().getExtras().getString("id1");   
	Intent i = new Intent(testing_page.this, fire.class);
		i.putExtra("urldata","http://hostel.glauniversity.in/grievance_login.aspx?emp=" + rollno.toString() + "&logintype=Transport");
		   startActivity(i);
}
public void house(View v)
{  String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hostel.glauniversity.in:88/login.aspx?emp="  + rollno.toString()));
    //startActivity(browserIntent);
		
		 Intent i = new Intent(testing_page.this, fire.class);
	 		i.putExtra("urldata","http://hostel.glauniversity.in:88/login.aspx?emp="  + rollno.toString());
	 		   startActivity(i);
		
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}
public void griv(View v)
{   String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hostel.glauniversity.in/grievance_login.aspx?emp=" + rollno.toString()));
    //startActivity(browserIntent);
		 Intent i = new Intent(testing_page.this, fire.class);
	 		i.putExtra("urldata","http://hostel.glauniversity.in/grievance_login.aspx?emp=" + rollno.toString());
	 		   startActivity(i);
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}

public void bus_scan(View v)
{    	
	Intent i=new Intent(this,bus_detail.class );
	startActivity(i);  
}

public void proc(View v)
{   String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
   // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hostel.glauniversity.in:85/pb_complaint_student.aspx?univroll=" + rollno.toString()));
    //startActivity(browserIntent);
		 Intent i = new Intent(testing_page.this, fire.class);
	 		i.putExtra("urldata","http://hostel.glauniversity.in:85/pb_complaint_student.aspx?univroll=" + rollno.toString());
	 		   startActivity(i);
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}


	public class myWebClient extends WebViewClient
	{

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			pbr.setVisibility(View.GONE);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}
		
		

	}

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if((keyCode == KeyEvent.KEYCODE_BACK) && br.canGoBack())
		{
			br.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	
	}

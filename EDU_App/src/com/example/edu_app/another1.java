package com.example.edu_app;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import com.example.edu_app.MainActivity.DownloadFileAsync;
import com.example.edu_app.testing_page.myWebClient;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.app.DownloadManager.Request;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.content.Context;
import android.view.View.OnClickListener;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

import android.view.Gravity;
import android.widget.RelativeLayout.LayoutParams;

public class another1 extends Activity {
	public final String METHOD_NAME =  "statusmsg"; 
	public final String METHOD_NAME2 =  "ActivatedServices";// our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/statusmsg";
	public final String SOAP_ACTION2 = "http://tempuri.org/ActivatedServices";// NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	 // for text view of count  (android:background="@drawable/rounded")
	 static Context context;
     ConnectivityManager connectivityManager;
     NetworkInfo wifiInfo, mobileInfo;
     boolean connected = false;
     private static MainActivity instance = new MainActivity();
	   public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	    private ProgressDialog mProgressDialog;
	    private Spinner spinner;
	    ExpandableListView expandableListView;
	    ExpandableListAdapter expandableListAdapter;
	    List<String> expandableListTitle;
	    HashMap<String, List<String>> expandableListDetail;
	String urlimg_s;
	ImageView imageView_s;
	WebView br_s;
	ProgressBar pbr_s;
@SuppressLint("NewApi")

protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.another);
	String name1=getIntent().getExtras().getString("name");
	String sem1=getIntent().getExtras().getString("sem");
	String rolln=getIntent().getExtras().getString("id1");
	
	urlimg_s = "http://glauniversity.in:8080/Exam_Photos/" +rolln.toString() + ".jpg";

 	((TextView) findViewById(R.id.laliu_s)).setText(name1.toString());
 	((TextView) findViewById(R.id.desig_s)).setText(sem1.toString());
 	
 	 imageView_s = (ImageView) findViewById(R.id.nd_drw_s);
 	// Create an object for subclass of AsyncTask
 	 
 	 GetXMLTask task1 = new GetXMLTask();
 	 task1.execute(new String[] {urlimg_s});

 	 
 	 
 	ActionBar actionbar = getActionBar();

 	 TextView textview = new TextView(another1.this);

 	 LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
 	 
 	 textview.setLayoutParams(layoutparams);

 	 textview.setText("Hi, "+ name1.toString());

 	 textview.setTextColor(Color.WHITE);
 	 
 	 textview.setGravity(Gravity.RIGHT);

 	 textview.setTextSize(13);

 	 actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

 	 actionbar.setCustomView(textview);
 	 
 	 
 	/*final Activity activity = this;
 	activity.setTitle("GLA University"); */	
    
	/*TextView txt1 = (TextView) findViewById(R.id.logout);
	
	txt1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
        	
        	SharedPreferences myPrefs = getSharedPreferences("Activity",
                    MODE_PRIVATE);
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.clear();
            editor.commit();
            //AppState.getSingleInstance().setLoggingOut(true);
            setLoginState(true);
            
        	Intent i=new Intent(another1.this,MainActivity.class );
        	 i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(i);
         }

        private void setLoginState(boolean status) {
            SharedPreferences sp = getSharedPreferences("LoginState",
                    MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putBoolean("setLoggingOut", status);
                ed.commit();
        }

        });*/
 	 
 
 	String roll=getIntent().getExtras().getString("id1");
	/* try
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
		//Toast t4 =  Toast.makeText(getApplicationContext(), " Read Current Updated news ", Toast.LENGTH_LONG);
		  // t4.show();
		} */
	 
	 
	 //Notice if Student
	 try
		{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
			request.addProperty("type","STUDENT");//rollno.toString()
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
					 br_s = (WebView) findViewById(R.id.webview_s);
				     pbr_s = (ProgressBar) findViewById(R.id.progress1_s);
				     br_s.setWebViewClient(new myWebClient());
				     br_s.getSettings().setJavaScriptEnabled(true);
				     br_s.getSettings().setPluginsEnabled(true);
				     br_s.getSettings().setSupportZoom(true);
				  	 br_s.getSettings().setBuiltInZoomControls(true);
				  	 br_s.getSettings().setTextZoom(90);
				  	 br_s.getSettings().setAllowFileAccess(true);
				  	  br_s.loadUrl("http://glauniversity.in:8083/MyAppContent.aspx?RequestFor=Notice&Univ="+roll.toString());
		}
		else
		{
			Toast t4 =  Toast.makeText(getApplicationContext(), " Sorry!! Notice Activity is Stoped by administrator for some time ", Toast.LENGTH_LONG);
			   t4.show();
			   br_s = (WebView) findViewById(R.id.webview_s);
			     pbr_s = (ProgressBar) findViewById(R.id.progress1_s);
			     br_s.setWebViewClient(new myWebClient());
			     br_s.getSettings().setJavaScriptEnabled(true);
			     br_s.getSettings().setSupportZoom(true);
			  	 br_s.getSettings().setBuiltInZoomControls(true);
			  	 br_s.getSettings().setTextZoom(90);
			  	 br_s.loadUrl("");
			
		}
		
		}
		catch (Exception E) {
				
		
		}
	
   
     
	 
	/*if(name1.equals("Administrator"))  //MyAppAdmin // ramlal@123321
	{
		Button btn9 = (Button) findViewById(R.id.button9);
		Button btn10 = (Button) findViewById(R.id.vis);
		Button btn11 = (Button) findViewById(R.id.upc);
		Button btn12 = (Button) findViewById(R.id.feed);
		Button btn13 = (Button) findViewById(R.id.Deletefeedback);
		Button btn14 = (Button) findViewById(R.id.act_deact1);
		
		//Button btn15 = (Button) findViewById(R.id.button12);
		//Button btn16 = (Button) findViewById(R.id.button13);
		//Button btn17 = (Button) findViewById(R.id.button8);
		
		btn9.setVisibility(View.VISIBLE);
		btn10.setVisibility(View.VISIBLE);
		btn11.setVisibility(View.VISIBLE);
		btn12.setVisibility(View.VISIBLE);
		btn13.setVisibility(View.VISIBLE);
		btn14.setVisibility(View.VISIBLE);

		//btn15.setVisibility(View.INVISIBLE);
		//btn16.setVisibility(View.INVISIBLE);
		//btn17.setVisibility(View.INVISIBLE);
	}*/
}




@Override
public void onBackPressed() {
    new AlertDialog.Builder(this)
           .setMessage("Are you sure you want to exit?")
           .setCancelable(false)
           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    another1.this.finish();
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
    protected void onPostExecute(Bitmap result_s) {
        imageView_s.setImageBitmap(result_s);
    }

    // Creates Bitmap from InputStream and returns it
    private Bitmap downloadImage(String urls) {
        Bitmap bitmap = null;
        InputStream stream = null;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inSampleSize = 1;

        try {
            stream = getHttpConnection(urls);
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
public void resultbut(View v)
{ 
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STUDENT");//rollno.toString()
		request.addProperty("activity","RESULT");//rollno.toString()
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
				String id2=getIntent().getExtras().getString("id1");
				String uname1=getIntent().getExtras().getString("name");
			Intent i=new Intent(this,resultButton1.class );
			   i.putExtra("id3",id2.toString());
			   i.putExtra("uname",uname1.toString());
			startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " Result Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

}
public void attendence(View v)
{ 
	 
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STUDENT");//rollno.toString()
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
				
				String rollno=getIntent().getExtras().getString("id1");	
				 if (MainActivity.getInstance(this).isOnline()) {
					// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
			         //startActivity(browserIntent);
					 Intent i = new Intent(another1.this, fire.class);
			  		i.putExtra("urldata","http://glauniversity.in:8083/MyAppContent.aspx?RequestFor=Attendance&Univ="+rollno.toString());
			  		   startActivity(i);
			     } else {
			         Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
			         t1.show(); 
			     }  
				
				/*String name=getIntent().getExtras().getString("name");
				String rollno=getIntent().getExtras().getString("id1");
				String sem1=getIntent().getExtras().getString("sem");
					Intent i=new Intent(this,attendence1.class );
					   i.putExtra("attname",name.toString());
					   i.putExtra("roll",rollno.toString());
					   i.putExtra("sem",sem1.toString());
					startActivity(i);*/
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

/*public void syll(View v)
{    String name=getIntent().getExtras().getString("name");
     String rollno=getIntent().getExtras().getString("id1");
     String sem1=getIntent().getExtras().getString("sem");
	 Intent i=new Intent(this,sylla.class );
	 i.putExtra("attname",name.toString());
	 i.putExtra("roll",rollno.toString());
	 i.putExtra("sem",sem1.toString());
	 startActivity(i);
	 
}*/

/*public void upcoming(View v)
{    	
	Intent i=new Intent(this,upcoming_upload.class );
	startActivity(i);
}*/

public void ord(View v)
{    	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
         //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/ordinances");
  		   startActivity(i);
     } else {
         Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
         t1.show(); 
     }   
}

public void home(View v)
{   

	
	String rollno=getIntent().getExtras().getString("id1");	
	 br_s = (WebView) findViewById(R.id.webview_s);
	 br_s.reload();
	 
   
}


public void time(View v)
{  
	
	
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STUDENT");//rollno.toString()
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

			if(result.toString().equals("True"))
	{
				
				String rollno=getIntent().getExtras().getString("id1");	
				 if (MainActivity.getInstance(this).isOnline()) {
					// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
			        //startActivity(browserIntent);
					 Intent i = new Intent(another1.this, fire.class);
			 		i.putExtra("urldata","http://glauniversity.in:8083/MyAppContent.aspx?" +"=TT&Univ="+rollno.toString());
			 		   startActivity(i);
			    } else {
			        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
			        t1.show(); 
			    }
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " Time Table Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

}

public void cpi(View v)
{    	
	String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
        //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
 		i.putExtra("urldata","http://glauniversity.in:8083/MyAppContent" +".aspx?RequestFor=CPI&Univ="+rollno.toString());
 		   startActivity(i);
    } else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}

public void rank(View v)
{    	
	String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
        //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
 		i.putExtra("urldata","http://glauniversity.in:8083/MyAppContent.aspx?RequestFor=Rank&Univ="+rollno.toString());
 		   startActivity(i);
    } else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}

public void marks(View v)
{    	
	String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
        //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
 		i.putExtra("urldata","http://glauniversity.in:8083/MyAppContent.aspx?RequestFor=Marks&Univ="+rollno.toString());
 		   startActivity(i);
    } else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}

public void prep(View v)
{    String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
         //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
  		i.putExtra("urldata","http://report.glauniversity.in/student_tracker2.aspx?rollno="+rollno.toString());
  		   startActivity(i);
     } else {
         Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
         t1.show(); 
     }   
}

public void hostal(View v)
{    String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
         //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
  		i.putExtra("urldata","http://hostel.glauniversity.in:82/librarylogin.aspx?univroll="+rollno.toString() + "&type=Hostel");
  		   startActivity(i);
     } else {
         Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
         t1.show(); 
     }   
}

public void bookhostel(View v)
{    String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
         //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
		 i.putExtra("urldata","http://hostel.glauniversity.in:82/librarylogin.aspx?univroll="+rollno.toString() + "&type=BookMyHostel");
  		   startActivity(i);
     } else {
         Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
         t1.show(); 
     }   
}

public void log_out(View v)
{    	
	 new AlertDialog.Builder(this)
     .setMessage("Are you sure you want to exit?")
     .setCancelable(false)
     .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
         public void onClick(DialogInterface dialog, int id) {
              another1.this.finish();
         }
     })
     .setNegativeButton("No", null)
     .show();
	 
}

public void library(View v)
{    String rollno=getIntent().getExtras().getString("id1");	
	 if (MainActivity.getInstance(this).isOnline()) {
		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/ordinances"));
         //startActivity(browserIntent);
		 Intent i = new Intent(another1.this, fire.class);
		 i.putExtra("urldata","http://192.168.1.7/");
		// i.putExtra("urldata","http://hostel.glauniversity.in:82/librarylogin.aspx?univroll="+rollno.toString() + "&type=Library");
  		   startActivity(i);
     } else {
         Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
         t1.show(); 
     }   
}

/*public void exit(View v)
{
	finish();
	moveTaskToBack(true);
}*/

/*public void sendnews(View v)
{
	Intent i=new Intent(this,sendnews1.class );
	startActivity(i);
}
public void visited(View v)
{
	Intent i=new Intent(this,visited_upload.class );
	startActivity(i);
}*/
/*public void logout(View v)
{    	
	Intent i=new Intent(this,MainActivity.class );
	startActivity(i);
}*/
public void feedback(View v)
{
	
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STUDENT");//rollno.toString()
		request.addProperty("activity","FEEDBACK");//rollno.toString()
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
				String name1=getIntent().getExtras().getString("name");
				String rollno1=getIntent().getExtras().getString("id1");
				
				Intent i=new Intent(this,feedback.class );
				   i.putExtra("attname",name1.toString());
				   i.putExtra("roll",rollno1.toString());
				   i.putExtra("type", "Student");
				startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " FEEDBACK Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

	
}

/*
public void show_feedback(View v)
{
	Intent i=new Intent(this,show_feedback.class );
	startActivity(i);
}*/
/*public void studentalert(View v)
{ 
	String rollno=getIntent().getExtras().getString("id1");
	Intent i=new Intent(this,empalert.class );
	i.putExtra("roll",rollno.toString());
	startActivity(i);
}*/
/*public void delete_feedback(View v)
{
	Intent i=new Intent(this,deletefeedback.class );
	startActivity(i);
}*/
/*
public void act_deact(View v)
{
	Intent i=new Intent(this,act_deact.class );
	startActivity(i);
}

public void delnews(View v)
{
	Intent i=new Intent(this,deletenews.class );
	startActivity(i);
}
*/
public void quiz(View v)
{
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STUDENT");//rollno.toString()
		request.addProperty("activity","QUIZ");//rollno.toString()
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
				String name1=getIntent().getExtras().getString("name");
				String rollno1=getIntent().getExtras().getString("id1");
				Intent i=new Intent(this,quiz.class );
				  i.putExtra("attname",name1.toString());
				  i.putExtra("roll",rollno1.toString());
				  startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " QUIZ Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}
	
	

}


public class myWebClient extends WebViewClient
{

	@Override
	public void onPageFinished(WebView view, String url) {
		// TODO Auto-generated method stub
		super.onPageFinished(view, url);
		pbr_s.setVisibility(View.GONE);
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
	
	if((keyCode == KeyEvent.KEYCODE_BACK) && br_s.canGoBack())
	{
		br_s.goBack();
		return true;
	}
	return super.onKeyDown(keyCode, event);
}


}

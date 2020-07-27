package com.example.edu_app;

import android.R.string;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
import android.app.AlertDialog;

import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;
import android.net.Uri;
import android.view.View.OnClickListener;
import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import android.view.Menu;
import android.net.NetworkInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.text.TextUtils.TruncateAt;

import android.widget.Spinner;


import com.example.edu_app.syllabus1.DownloadFileAsync;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;


public class Course_syllabus extends Activity {
	 public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	    private ProgressDialog mProgressDialog;
	    private Spinner spinner;
	    ConnectivityManager connectivityManager;
	    private static MainActivity instance = new MainActivity();
	    static Context context;
	    boolean connected = false;
@SuppressLint("NewApi")
@Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.course_syllabus); 
}


public void iet(View v)
{    	
	if (MainActivity.getInstance(this).isOnline()) {
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/department-of-computer-engineering-applications/course-curriculum-4"));
        //startActivity(browserIntent);
		 Intent i = new Intent(Course_syllabus.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/department-of-computer-engineering-applications/course-curriculum-4");
  		   startActivity(i);
    	} else {
            Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
            t1.show(); 
        }
}
public void ibm(View v)
{    	
	//String url = "http://www.gla.ac.in/institutes/institute-of-busines-management/course-curriculum";
	if (MainActivity.getInstance(this).isOnline()) {
        //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/institute-of-busines-management/course-curriculum"));
        //startActivity(browserIntent);
		 Intent i = new Intent(Course_syllabus.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/institute-of-busines-management/course-curriculum");
  		   startActivity(i);
    	} else {
            Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
            t1.show(); 
        }
}
public void ipr(View v)
{    	
	if (MainActivity.getInstance(this).isOnline()) {
      //  Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/institute-of-pharmaceutical-research/course-curriculum-8"));
       // startActivity(browserIntent);
		 Intent i = new Intent(Course_syllabus.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/institute-of-pharmaceutical-research/course-curriculum-8");
  		   startActivity(i);
    	} else {
            Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
            t1.show(); 
        }
}
public void iah(View v)
{    	
	if (MainActivity.getInstance(this).isOnline()) {
   // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/institute-of-applied-sciences-humanities/course-curriculum-10"));
    //startActivity(browserIntent);
		 Intent i = new Intent(Course_syllabus.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/institute-of-applied-sciences-humanities/course-curriculum-10");
  		   startActivity(i);
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}
public void foe(View v)
{    	
	if (MainActivity.getInstance(this).isOnline()) {
       // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/faculty-of-education-b-ed/course-curriculum-11"));
       // startActivity(browserIntent);
		 Intent i = new Intent(Course_syllabus.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/faculty-of-education-b-ed/course-curriculum-11");
  		   startActivity(i);
    	} else {
            Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
            t1.show(); 
        }
}
public void up(View v)
{    	
	if (MainActivity.getInstance(this).isOnline()) {
       // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/university-polytechnic/course-curriculum-6"));
       // startActivity(browserIntent);
		 Intent i = new Intent(Course_syllabus.this, fire.class);
  		i.putExtra("urldata","http://www.gla.ac.in/institutes/university-polytechnic/course-curriculum-6");
  		   startActivity(i);
    	} else {
            Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
            t1.show(); 
        }
}

public  boolean isOnline() {
    try {
        connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    connected = networkInfo != null && networkInfo.isAvailable() &&
            networkInfo.isConnected();
    return connected;
    } catch (Exception e) {
        System.out.println("CheckConnectivity Exception: " + e.getMessage());
        Log.v("connectivity", e.toString());
    }
    return connected;
}            
public static MainActivity getInstance(Context ctx) {
    context = ctx.getApplicationContext();
    return instance;
}
}
package com.example.edu_app;

import android.R.string;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.view.View.OnClickListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.view.Menu;
import android.net.NetworkInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.Toast;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import android.text.TextUtils.TruncateAt;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.content.Context;
import com.example.edu_app.syllabus1.DownloadFileAsync;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import android.net.NetworkInfo;
import android.util.Log;

public class MainActivity extends Activity {
	public final String METHOD_NAME =  "ActivatedServices"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/ActivatedServices"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	string [] rest;
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

	    @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
    expandableListDetail = ExpandableListDataPump.getData();
    expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
    expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
    expandableListView.setAdapter(expandableListAdapter);
    expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {
        @Override
        public void onGroupExpand(int groupPosition) {
            Toast.makeText(getApplicationContext()," Wait........",
                    Toast.LENGTH_SHORT).show();        
         
            switch(groupPosition)
            {

            case 0:
            	
            	/*Intent i = new Intent(MainActivity.this, fire.class);
			        		i.putExtra("urldata","http://172.16.10.15:8088/android_vi.aspx");
			        		   startActivity(i);*/
            	break;        
            case 1:
            	 Intent myIntent2 = new Intent(MainActivity.this, about_us.class);
	             startActivityForResult(myIntent2, 0);
            	
            	 break;
            case 2:
            	 Intent myIntent3 = new Intent(MainActivity.this, home1.class);
	             startActivityForResult(myIntent3, 0);
            	break;
            case 3:            	
            	break;
            case 4:
            	/* Intent i2 = new Intent(MainActivity.this, fire.class);
	        		i2.putExtra("urldata","http://172.16.10.15:8088/android_up.aspx");
	        		   startActivity(i2);*/
            	
            	break;
            case 5:
            	 Intent myIntent11 = new Intent(MainActivity.this, emplogin.class);
	             startActivityForResult(myIntent11, 0);
           	break;
            }           
        } 
       
    });

   
    expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

    	 @Override
        public void onGroupCollapse(int groupPosition) {
          Toast.makeText(getApplicationContext(),
                    expandableListTitle.get(groupPosition)+ "collapse",Toast.LENGTH_SHORT).show(); 
 
        }
    });

    expandableListView.setOnChildClickListener(new OnChildClickListener() {
    	
    
        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {
         
        

       	 Toast.makeText(
                   getApplicationContext(),
                   groupPosition
                           + " -> "
                           + 
                       
                           childPosition, Toast.LENGTH_SHORT                          
           )
                   .show();
       	 if(groupPosition== 3 && childPosition== 0 )//b.tech
       	 {
       		Intent i = new Intent(MainActivity.this, fire.class);
      		i.putExtra("urldata","http://www.gla.ac.in/institutes/department-of-computer-engineering-applications/course-curriculum-4");
      		   startActivity(i);	 
       	 }
       	 else if(groupPosition== 3 && childPosition== 1 )//mtech
       	 {
       		 Intent i = new Intent(MainActivity.this, fire.class);
       		i.putExtra("urldata","http://www.gla.ac.in/institutes/institute-of-busines-management/course-curriculum");
       		   startActivity(i);	
       	 }
       	else if(groupPosition== 3 && childPosition== 2 )
      	 {
       	 Intent i = new Intent(MainActivity.this, fire.class);
   		i.putExtra("urldata","http://www.gla.ac.in/institutes/institute-of-pharmaceutical-research/course-curriculum-8");
   		   startActivity(i);
       		 
      	 }
       	else if(groupPosition== 3 && childPosition== 3 )
      	 {
       	 Intent i = new Intent(MainActivity.this, fire.class);
   		i.putExtra("urldata","http://www.gla.ac.in/institutes/institute-of-applied-sciences-humanities/course-curriculum-10");
   		   startActivity(i);	
       		
      	 }
       	else if(groupPosition== 3 && childPosition== 4 )
      	 {
       	 Intent i = new Intent(MainActivity.this, fire.class);
   		i.putExtra("urldata","http://www.gla.ac.in/institutes/faculty-of-education-b-ed/course-curriculum-11");
   		   startActivity(i);	
       		
      	 }
       	else if(groupPosition== 3 && childPosition== 5 )
      	 {
       	 Intent i = new Intent(MainActivity.this, fire.class);
   		i.putExtra("urldata","http://www.gla.ac.in/institutes/university-polytechnic/course-curriculum-6");
   		   startActivity(i);	
       		
      	 }
      	
    	else
    	{    		
    	}   
            return false;
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
	    
	    @Override
	    public void onBackPressed() {
	        new AlertDialog.Builder(this)
	               .setMessage("Are you sure you want to exit?")
	               .setCancelable(false)
	               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                	   finish();
	                   }
	               })
	               
	               .setNegativeButton("No", null)
	               .show();
	    }
	    
	    
	    
	    public void student_corner(View v)
	    {    
	    	 /*if (android.os.Build.VERSION.SDK_INT > 9) {
	 		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	 		    StrictMode.setThreadPolicy(policy);
	 		}*/
	    	/*try
			{
	    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	    		request.addProperty("type","STUDENT");//rollno.toString()
				request.addProperty("activity","Login");//rollno.toString()
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
	    	{*/
						Intent i=new Intent(this,home1.class );
	    		
				    	startActivity(i);
	    	/*}
	    	else
	    	{
	    		Toast t4 =  Toast.makeText(getApplicationContext(), " Login Activity is Deactivated By Administrator for Some Time  ", Toast.LENGTH_LONG);
				   t4.show();
	    	}
			
			}
			catch (Exception E) {
			E.printStackTrace();		
			Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
			   t4.show();
			}*/
	    	
	    	
	
	    }
	    public void emp_login(View v)
	    {   
	    	/* if (android.os.Build.VERSION.SDK_INT > 9) {
	 		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	 		    StrictMode.setThreadPolicy(policy);
	 		}
	    	try
			{
	    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	    		request.addProperty("type","STAFF");//rollno.toString()
				request.addProperty("activity","Login");//rollno.toString()
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
	    	{*/
				Intent i=new Intent(this,emplogin.class );
				
		    	startActivity(i);
	    	/*}
	    	else
	    	{
	    		Toast t4 =  Toast.makeText(getApplicationContext(), " Login Activity is Deactivated By Administrator for Some Time  ", Toast.LENGTH_LONG);
				   t4.show();
	    	}
			
			}
			catch (Exception E) {
			E.printStackTrace();		
			Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
			   t4.show();
			}*/
	    	
	    	
	    }
	    	
	    public void chairman(View v)
	    {    	
	    	Intent i=new Intent(this,chairman.class );
	    	startActivity(i);  
	    }
	   /* public void directory(View v)
	    {    	
	    	Intent i=new Intent(this,directory.class );
	    	startActivity(i);
	    }*/
	    
	    public void fire_safty(View v)
	    {    	
	    	Intent i=new Intent(this,fire_safty.class );
	    	startActivity(i);
	    }
	    /*public void timetable(View v)
	    {    	
	    	Intent i=new Intent(this,timetable.class );
	    	startActivity(i);
	    	//Intent i=new Intent(this,testing_page.class );
	    	//startActivity(i);
	    		
	    	
	    }*/
	    
	   /* public void news(View v)
	    {   
        		   if (MainActivity.getInstance(this).isOnline()) {
      	    		 Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://172.16.10.15:8088/android_grid.aspx"));
                       startActivity(browserIntent);
        			   
        			  // Intent i = new Intent(MainActivity.this, fire.class);
   	        		//i.putExtra("urldata","http://172.16.10.15:8088/android_grid.aspx");
   	        		  // startActivity(i);
   	        		   
                   } else {
                       Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
                       t1.show(); 
                   } 
            //Intent i=new Intent(this,news1.class );
	    	//startActivity(i);
	    }*/
	    
	    public void fb(View v)
	            { 
	    	 if (MainActivity.getInstance(this).isOnline()) {
	    		// Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/glauniv"));
                // startActivity(browserIntent);
	    		 Intent i = new Intent(MainActivity.this, fire.class);
	        		i.putExtra("urldata","https://www.facebook.com/glauniv");
	        		   startActivity(i);
	    		 
             } else {
                 Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
                 t1.show(); 
             }    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/glauniv"));
	                //startActivity(browserIntent);
	            
	            }
	            public void youtube(View v)
	            {    
	                if (MainActivity.getInstance(this).isOnline()) {
	   	    		 //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/OfficialGLAuniv"));
	                   // startActivity(browserIntent);
	                	 Intent i = new Intent(MainActivity.this, fire.class);
			        		i.putExtra("urldata","https://www.youtube.com/user/OfficialGLAuniv");
			        		   startActivity(i);
	            
	                } 
	                else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }    
	            }
	           /* public void gmail(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"));
	                startActivity(browserIntent);
	            	 } else {

		                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
		                    t1.show(); 
		                }
	                    }*/
	         /*   public void glaacin(View v)
	            {  
	            	//Intent i=new Intent(this,Course_syllabus.class );
			    	//startActivity(i);
	            	if (MainActivity.getInstance(this).isOnline()) {
	               // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/"));
	               // startActivity(browserIntent);
	            		 Intent i = new Intent(MainActivity.this, fire.class);
			        		i.putExtra("urldata","http://172.16.10.15:8088/faculty_search.aspx");
			        		   startActivity(i);
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            	
	            }*/	    
	            // another 9
	            
	           /* public void glaacin(View v)
	            {  
	            	Intent i = new Intent(MainActivity.this, fire.class);
	          	  // intent.putExtra("name",result.toString());
	          		i.putExtra("urldata","http://www.gla.ac.in/");
	          		   startActivity(i);
	            	
	    	    	
	            }*/
	          /*  public void admission(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	               // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/study-with-us/download-forms"));
	               // startActivity(browserIntent);
	            		  Intent i = new Intent(MainActivity.this, fire.class);
	     	        		i.putExtra("urldata","http://www.gla.ac.in/study-with-us/download-forms");
	     	        		   startActivity(i);
	            		
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }*/	   
	            public void calendar(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/institutes/university-calendar"));
	               // startActivity(browserIntent);
	            		 Intent i = new Intent(MainActivity.this, fire.class);
	     	        		i.putExtra("urldata","http://www.gla.ac.in/institutes/university-calendar");
	     	        		   startActivity(i);
	            		
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }	   
	            public void prep(View v)
	            {  
   
	            	if (MainActivity.getInstance(this).isOnline()) {
	                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://prep.glauniversity.in/moodle/login/index.php"));
	                //startActivity(browserIntent);
	            		 Intent i = new Intent(MainActivity.this, fire.class);
			        		i.putExtra("urldata","http://prep.glauniversity.in/moodle/login/index.php");
			        		   startActivity(i);
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }	   
	            public void Faculty(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	               // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/faculty-staff"));
	               // startActivity(browserIntent);
	                Intent i = new Intent(MainActivity.this, fire.class);
	        		i.putExtra("urldata","http://www.gla.ac.in/faculty-staff");
	        		   startActivity(i);
	        		  
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }	   
	            public void tranning(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	               // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/training-and-placements/"));
	               // startActivity(browserIntent);
	            		
	            		 Intent i = new Intent(MainActivity.this, fire.class);
	     	        		i.putExtra("urldata","http://www.gla.ac.in/training-and-placements/");
	     	        		   startActivity(i);
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }	   
	            public void feestructure(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/study-with-us/fee-structure"));
	                //startActivity(browserIntent);
	            		
	            		 Intent i = new Intent(MainActivity.this, fire.class);
	     	        		i.putExtra("urldata","http://www.gla.ac.in/study-with-us/fee-structure");
	     	        		   startActivity(i);
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }	   
	         /*   public void glauniversity(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://glauniversity.in/EduwareHome/Home.aspx#"));
	               // startActivity(browserIntent);
	            		 Intent i = new Intent(MainActivity.this, fire.class);
			        		i.putExtra("urldata","http://glauniversity.in/EduwareHome/Home.aspx");
			        		   startActivity(i);
	            		
	            		
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            	
	            }	   
	            public void payroll(View v)
	            {  
	            if (MainActivity.getInstance(this).isOnline()) {
	                //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://glauniversity.in:8088/EduwareHome/Home.aspx#"));
	               // startActivity(browserIntent);
	            	 Intent i = new Intent(MainActivity.this, fire.class);
		        		i.putExtra("urldata","http://glauniversity.in:8088/EduwareHome/Home.aspx");
		        		   startActivity(i);
	            	
	            	} else {
	                    Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
	                    t1.show(); 
	                }
	            }*/	   
	            public void gallry(View v)
	            {  
	            	if (MainActivity.getInstance(this).isOnline()) {
	               // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gla.ac.in/campus-life/infrastructure-gallery"));
	                //startActivity(browserIntent);
	            		
	            		 Intent i = new Intent(MainActivity.this, fire.class);
	     	        		i.putExtra("urldata","http://www.gla.ac.in/campus-life/infrastructure-gallery");
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
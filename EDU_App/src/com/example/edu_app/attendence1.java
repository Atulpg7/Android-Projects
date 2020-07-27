package com.example.edu_app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.view.Menu;
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
import java.util.HashMap;
import java.util.List;
 
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class attendence1 extends Activity {
	
	public final String METHOD_NAME =  "attendence"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/attendence"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	String r="R",g="G",y="B";
	static final String[] totalheading = new String[] {

        "Code","Name","% Age","Ist","Mid","End"  
    };	
	String[] web = {
	          "1","2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21",
	          "1","2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21" 
	    } ;
	 String[] rest;
	GridView grid;	
	
	
	@SuppressLint("NewApi")
	@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.attendence);
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
			ListView list2 = (ListView) findViewById(R.id.athead);
	        ArrayList<HashMap<String, String>> mylistData2 =
	                           new ArrayList<HashMap<String, String>>();
	         
	        String[] columnTags2 = new String[] {"col1", "col2", "col3", "col4", "col5", "col6"};
	         
	        int[] columnIds2 = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5, R.id.column6};
	        int k=0;
	       //here finding length of array
	        for(int i=0;i<(totalheading.length)/6; i++)
	        {
	         HashMap<String,String> map = new HashMap<String, String>();
	         //initialize row data

	        //news only
	        for(int j=0; j<6; j++)
	         {

	          map.put(columnTags2[j],totalheading[k]);

	        k++;
	         
	        }
	       
	         mylistData2.add(map);
	        }
	        SimpleAdapter arrayAdapter2 =
	                       new SimpleAdapter(this, mylistData2, R.layout.attendencehead, columnTags2 , columnIds2);
	        list2.setAdapter(arrayAdapter2);
	       
	        try
			{
	        	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
				request.addProperty("roll",rollno);
				request.addProperty("servicekey","thisismycommunicationapp");
				request.addProperty("servicetype","SOFT");
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelope.dotNet = true;
				envelope.setOutputSoapObject(request);
				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
				androidHttpTransport.call(SOAP_ACTION,envelope);
				SoapObject result =(SoapObject) envelope.getResponse();
				rest= new String[result.getPropertyCount()];
				for(int i =0 ; i<result.getPropertyCount();++i)
				{
					rest[i]=result.getProperty(i).toString();
				}			
				
				
				/*if (g.equals(rest[3])) {
					 ListView list = (ListView) findViewById(R.id.gridView2);
					  String[] columnTags = new String[] {"col1"};
					     
				        int[] columnIds = new int[] {R.id.column1};
				        
	    	    	 Toast t5 =  Toast.makeText(getApplicationContext(), "hello every one", Toast.LENGTH_LONG);
		     			t5.show();
		     			
		     		   SimpleAdapter arrayAdapter =
		     			        new SimpleAdapter(this, mylistData, R.layout.attendencelist, columnTags , columnIds);
		     			        list.setAdapter(arrayAdapter); 
		     			
	    	    } */
					
				 
				 //Start Color Code
				 
				 ListView list = (ListView) findViewById(R.id.gridView2);
				/* ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
					        android.R.layout.simple_list_item_1, web) {
					    	  @Override
					    	  public View getView(int position, View convertView, ViewGroup parent) {
				    	 
					    		  View view = super.getView(position, convertView, parent);
				    	    int color = 0xffffc200; // Transparent
				    	    if (g.equals(rest[3])) {
				    	    	color = 0xFF800000;  //redcolor
				    	    	 
				    	    	 Toast t5 =  Toast.makeText(getApplicationContext(), "g na hero", Toast.LENGTH_LONG);
					     			t5.show();
				    	    }
				    	    
				    	    else if (r.toString().equals(rest[position *4 +4])) {
					    	      color = 0xffffc200; // orange
					    	    }
				    	    else if (y.toString().equals(rest[19])) {
					    	      color = 0xffffc200; // Orange
					    	    }
				    	
				    	    
				    	    view.setBackgroundColor(color);
				    	    return view;
				    	  }
				    	};
				    	
				    	  list.setAdapter(adapter1);
				    	 int k12=1;
						  String rest23[] = new String[rest.length/4];	
						  for(int i=0;i<rest.length/4; i++)
						  {
						  rest23[i]=rest[i*4];
						 
						  }							  
						  list = (ListView) findViewById(R.id.gridView2);
						    ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this,
						        android.R.layout.simple_list_item_1, rest) {
						    	  @Override
						    	  public View getView(int position, View convertView, ViewGroup parent) {
						    	    View view = super.getView(position, convertView, parent);

						    	    int color = 0x00FFFFFF; // Transparent
						    	   if (g.toString().equals(rest[3])) {
						    	    	color = 0xFF800000;  //redcolor
						    	    }
						    	    else if (r.toString().equals(rest[position *4 +4])) {
							    	      color = 0xffffc200; // orange
							    	    }
						    	    else if (y.toString().equals(rest[19])) {
							    	      color = 0xffffc200; // Orange
							    	    }

						    	    view.setBackgroundColor(color);
						    	    return view;
						    	  }
						    	};
						    	  list.setAdapter(adapter11);*/

				 // End Color code
				
							
				
				
		        ArrayList<HashMap<String, String>> mylistData =
		                           new ArrayList<HashMap<String, String>>();

		        
		        String[] columnTags = new String[] {"col1", "col2", "col3", "col4", "col5", "col6", "col7"};
		     
		        int[] columnIds = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5, R.id.column6, R.id.column7};
		        int gp1=0;
		       //here finding length of array
		        for(int i=0;i<(rest.length)/7; i++)
		        {
		         HashMap<String,String> map = new HashMap<String, String>();
		         //initialize row data

			      
		        //news only
		        for(int j=0; j<7; j++)
		         {

		          map.put(columnTags[j],rest[gp1]);
		          
		         
		        gp1++;
		       
		    	  
		    	  
		       
		       
		        }
		         mylistData.add(map);
		        }
		        SimpleAdapter arrayAdapter =
		        new SimpleAdapter(this, mylistData, R.layout.attendencelist, columnTags , columnIds);
		        list.setAdapter(arrayAdapter); 
		       
		       
		  
		        
		      
		        
			}

	        catch (Exception E) {
				E.printStackTrace();
				Toast t1 =  Toast.makeText(getApplicationContext(), " Attendence is not updated ", Toast.LENGTH_LONG);
				t1.show();
				}
	}



	
}





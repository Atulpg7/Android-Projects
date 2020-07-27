package com.example.edu_app;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
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
public class examresult1 extends Activity {
	
	public final String METHOD_NAME =  "result"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/result"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	
	static final String[] totalheading = new String[] {
        "STC", "SGP", "SPI", "CC","CGP","CPI"
    };
	
	static final String[] numbers2 = new String[] {


        "S.Code", "Grade", "GP", "Credit"

    };
	
static final String[] head1 = new String[] {


    "SCode","Grade", "GP", "Credit",
};

@SuppressLint("NewApi")
@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.examresult);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		String roll =getIntent().getExtras().getString("name");
		String sem =getIntent().getExtras().getString("sem");
		String name =getIntent().getExtras().getString("uname");
		((TextView) findViewById (R.id.rollno)).setText("Univ. RollNo - "+roll.toString());
		((TextView) findViewById (R.id.name)).setText("Name -"+name.toString());
		((TextView) findViewById (R.id.semester)).setText("Semester  - "+sem.toString());
		
	/*	GridView gridView=(GridView)findViewById(R.id.gphead);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,  totalheading);
 
        gridView.setAdapter(adapter);
 
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                int position, long id) {
               Toast.makeText(getApplicationContext(),
                ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }

           
        });*/
		// cgp heading
		ListView list = (ListView) findViewById(R.id.gphead);
        ArrayList<HashMap<String, String>> mylistData =
                           new ArrayList<HashMap<String, String>>();
         
        String[] columnTags = new String[] {"col1", "col2","col3", "col4","col5", "col6"};
         
        int[] columnIds = new int[] {R.id.column1, R.id.column2,R.id.column3, R.id.column4,R.id.column5, R.id.column6};
        int gp1=0;
       //here finding length of array
        for(int i=0;i<(totalheading.length)/6; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data
        
     
      
        //news only
        for(int j=0; j<6; j++)
         {
        
         
       
          map.put(columnTags[j],totalheading[gp1]);
         
          
        gp1++;
         
        }
       
         mylistData.add(map);
        }
        SimpleAdapter arrayAdapter =
                       new SimpleAdapter(this, mylistData, R.layout.cgpheading, columnTags , columnIds);
        list.setAdapter(arrayAdapter);
       
		
		
		try
		{
		
	        
	        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			request.addProperty("roll",roll);
			request.addProperty("sem",sem);
			request.addProperty("type","cgpi");
			request.addProperty("servicekey","thisismycommunicationapp");
			request.addProperty("servicetype","SOFT");
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
			
			//for cgp
			
			ListView list2 = (ListView) findViewById(R.id.mylist1);
	        ArrayList<HashMap<String, String>> mylistData2 =
	                           new ArrayList<HashMap<String, String>>();
	         
	        String[] columnTags2 = new String[] {"col1", "col2","col3", "col4","col5", "col6"};
	         
	        int[] columnIds2 = new int[] {R.id.column1, R.id.column2,R.id.column3, R.id.column4,R.id.column5, R.id.column6};
	        int k=0;
	       //here finding length of array
	        for(int i=0;i<(rest.length)/6; i++)
	        {
	         HashMap<String,String> map = new HashMap<String, String>();
	         //initialize row data
	        
	     
	      
	        //news only
	        for(int j=0; j<6; j++)
	         {
	        
	         
	       
	          map.put(columnTags2[j],rest[k]);
	         
	          
	        k++;
	         
	        }
	       
	         mylistData2.add(map);
	        }
	        SimpleAdapter arrayAdapter2 =
	                       new SimpleAdapter(this, mylistData2, R.layout.gridrow, columnTags2 , columnIds2);
	        list2.setAdapter(arrayAdapter2);
	       
			
	      /*  GridView gridView1=(GridView)findViewById(R.id.gridView1);  
	        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rest);
	        gridView1.setAdapter(adapter1);
	        gridView1.setOnItemClickListener(new OnItemClickListener() {
	            public void onItemClick(AdapterView<?> parent, View v,
	                int position, long id) {
	               Toast.makeText(getApplicationContext(),
	                ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
	            }

	           
	        });
	        */
	        
	      
	       
}
		catch (Exception E) {
			E.printStackTrace();
			Toast t1 =  Toast.makeText(getApplicationContext(), "no result ", Toast.LENGTH_LONG);
			t1.show();
			}
	
	        
	        //result heading
		ListView list3 = (ListView) findViewById(R.id.gridView2);
        ArrayList<HashMap<String, String>> mylistData3 =
                           new ArrayList<HashMap<String, String>>();
         
        String[] columnTags3 = new String[] {"col1", "col2","col3", "col4"};
         
        int[] columnIds3 = new int[] {R.id.column1, R.id.column2,R.id.column3, R.id.column4};
        int h2=0;
       //here finding length of array
        for(int i=0;i<(numbers2.length)/4; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data

        //news only
        for(int j=0; j<4; j++)
         {

          map.put(columnTags3[j],numbers2[h2]);
         
          
        h2++;
         
        }
       
         mylistData3.add(map);
        }
        SimpleAdapter arrayAdapter3 =
                       new SimpleAdapter(this, mylistData3, R.layout.resultheading, columnTags3 , columnIds3);
        list3.setAdapter(arrayAdapter3);

	        try
	        {
	        	  SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME);
	  			request1.addProperty("roll",roll);
	  			request1.addProperty("sem",sem);
	  			request1.addProperty("type","result");
	  			request1.addProperty("servicekey","thisismycommunicationapp");
	  			request1.addProperty("servicetype","SOFT");
	  			SoapSerializationEnvelope envelope1 = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	  			envelope1.dotNet = true;
	  			envelope1.setOutputSoapObject(request1);
	  			HttpTransportSE androidHttpTransport1 = new HttpTransportSE(URL);
	  			androidHttpTransport1.call(SOAP_ACTION,envelope1);
	  			SoapObject result1 =(SoapObject) envelope1.getResponse();
	  			String rest1[] = new String[result1.getPropertyCount()];
	  			for(int j =0 ; j<result1.getPropertyCount();++j)
	  			{
	  				rest1[j]=result1.getProperty(j).toString();
	  			}
	  			
	// for result
	  			
	  			ListView list4 = (ListView) findViewById(R.id.result3);
	  		
		        ArrayList<HashMap<String, String>> mylistData4 =
		                           new ArrayList<HashMap<String, String>>();
		         
		        String[] columnTags4 = new String[] {"col1", "col2","col3", "col4"};
		         
		        int[] columnIds4 = new int[] {R.id.column1, R.id.column2,R.id.column3, R.id.column4};
		        int k=0;
		       //here finding length of array
		        for(int i=0;i<(rest1.length)/4; i++)
		        {
		         HashMap<String,String> map = new HashMap<String, String>();
		         //initialize row data

		        //news only
		        for(int j=0; j<4; j++)
		         {

		          map.put(columnTags[j],rest1[k]);
 
		        k++;
		         
		        }
		       
		         mylistData4.add(map);
		        }
		        SimpleAdapter arrayAdapter4 =
		                       new SimpleAdapter(this, mylistData4, R.layout.gridresult, columnTags4 , columnIds4);
		        list4.setAdapter(arrayAdapter4);
   
	  	        
	  	   /*     GridView gridView3=(GridView)findViewById(R.id.gridView3);
	  	         
	  	        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
	  	                android.R.layout.simple_list_item_1, rest1);
	  	 
	  	        gridView3.setAdapter(adapter3);
	  	        gridView3.setOnItemClickListener(new OnItemClickListener() {
	  	            public void onItemClick(AdapterView<?> parent, View v,
	  	                int position, long id) {
	  	               Toast.makeText(getApplicationContext(),
	  	                ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
	  	            }

	  	        });*/
	  		
	        }
	  		
	        catch (Exception E) {
				E.printStackTrace();
				Toast t1 =  Toast.makeText(getApplicationContext(), " no result ", Toast.LENGTH_LONG);
				t1.show();
				}
	        
	       
}
}

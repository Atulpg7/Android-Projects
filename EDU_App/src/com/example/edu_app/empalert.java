package com.example.edu_app;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;        
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
import android.view.ContextThemeWrapper;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.AlertDialog;

import android.widget.AdapterView.OnItemClickListener;
public class empalert extends Activity{
	public final String METHOD_NAME =  "showmsg"; // our webservice method name
	public final String METHOD_NAME1 =  "readmsg"; 
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/showmsg";
	public final String SOAP_ACTION1 = "http://tempuri.org/readmsg";// NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
String heading[];
String news1[];

int position=0;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empalert); 
       
        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
        String rollno = getIntent().getExtras().getString("roll");
// for news
         try
         {      
         	SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME);
         	request1.addProperty("id",rollno);//rollno.toString()
         	request1.addProperty("servicekey","thisismycommunicationapp");
    		request1.addProperty("servicetype","SOFT");
 			SoapSerializationEnvelope envelope1 = new SoapSerializationEnvelope(SoapEnvelope.VER11);
 			envelope1.dotNet = true;
 			envelope1.setOutputSoapObject(request1);
 			HttpTransportSE androidHttpTransport1 = new HttpTransportSE(URL);
 			androidHttpTransport1.call(SOAP_ACTION,envelope1);
 			SoapObject result1 =(SoapObject) envelope1.getResponse();
 			 news1 = new String[result1.getPropertyCount()];

 			for(int j=0 ; j<=result1.getPropertyCount();j++)
 			{
 				news1[j]=result1.getProperty(j).toString();
 			}
         }
         catch (Exception E) {
         	E.printStackTrace();
         	}
        // list view Coding for news

        ListView list = (ListView) findViewById(R.id.mylist);
        ArrayList<HashMap<String, String>> mylistData =
                           new ArrayList<HashMap<String, String>>();
         
        String[] columnTags = new String[] {"col1", "col4", "col3", "col2"};
        int[] columnIds = new int[] {R.id.column1, R.id.column4, R.id.column3, R.id.column2};
        int k=0;
       //here finding length of array
        for(int i=0;i<(news1.length)/4; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data
        //news only
        for(int j=0; j<4; j++)
         {
          map.put(columnTags[j],news1[k]);
        k++;
        }
         mylistData.add(map);
        }
        SimpleAdapter arrayAdapter =
                       new SimpleAdapter(this, mylistData, R.layout.messagelist,
                                     columnTags , columnIds);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {
           
            	//String msg = parent.getItemAtPosition(position+1).toString().substring(1,parent.getItemAtPosition(position).toString().length() -1);
            	//String dat = parent.getItemAtPosition(position).toString().substring(12,(position));
            	//String rollno = getIntent().getExtras().getString("roll");
            	//ListView lst1 = (ListView) findViewById(R.id.mylist);
            	String tranid2 = parent.getItemAtPosition(position).toString().substring(6,11);
            	String tranid = parent.getItemAtPosition(position).toString();
            	
            	int intIndex1 = tranid.indexOf("col2");
            	String ab = String.valueOf(intIndex1);
            	String abc= parent.getItemAtPosition(position).toString().substring(intIndex1+5,parent.getItemAtPosition(position).toString().length() -1);
            	 //lst1.setBackgroundColor(0xFFFFFF);
            	//new AlertDialog.Builder(this).setTitle("Message").setMessage(msg).setNeutralButton("Close", null).show();
            	//Toast t2 =  Toast.makeText(getApplicationContext(), abc, Toast.LENGTH_LONG);
				// t2.show();
            	try
                 {
                 	SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME1);
                 	//request1.addProperty("id",rollno);//rollno.toString()
                 	//request1.addProperty("msg",msg);//rollno.toString()
                 	//request1.addProperty("date",dat);//rollno.toString()
                 	request1.addProperty("transid",tranid2);//rollno.toString()
                 	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        			envelope.dotNet = true;
        			envelope.setOutputSoapObject(request1);
        			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        			androidHttpTransport.call(SOAP_ACTION1,envelope);
        			Object result = envelope.getResponse();
        			System.out.println("Result :" + result.toString());
        		//	if(result.toString().equals("Successfully Uploaded"))
        			//{
        				//((TextView) findViewById (R.id.txtAddition)).setText("invalid Username and password : "+result.toString());
        		
        				//TextView txt1 = (TextView) findViewById(R.id.column1);
        				//TextView txt2 = (TextView) findViewById(R.id.column2);
        				//ListView lst1 = (ListView) findViewById(R.id.mylist);
						//txt1.setTextColor(Color.parseColor("#008000"));
        				//txt2.setTextColor(Color.parseColor("#008000"));
        				//txt1.setBackgroundColor(0xFFFFFF);
        				//txt2.setBackgroundColor(0xFFFFFF);
        			//}
        			//else
        			//{	
        				//song1.release();
        				//Toast t3 =  Toast.makeText(getApplicationContext(), "Problem to select Type ", Toast.LENGTH_LONG);
        				 //  t3.show();	
        			//}
                 }
                 catch (Exception E) {
                 	E.printStackTrace();
                 	}
            }
        });
       /* list.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
           Object o = prestListView.getItemAtPosition(position);
           prestationEco str=(prestationEco)o;//As you are using Default String Adapter
           Toast.makeText(getBaseContext(),str.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });*/
       }
}
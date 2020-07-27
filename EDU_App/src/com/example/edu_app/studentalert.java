package com.example.edu_app;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;        
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
public class studentalert extends Activity {
	public final String METHOD_NAME =  "shownews"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/shownews"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
String heading[];
String news1[];

int position=0;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentalert); 
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
// for news
         try
         {
         	SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME);
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
         
        String[] columnTags = new String[] {"col1", "col2"};
         
        int[] columnIds = new int[] {R.id.column1, R.id.column2};
        int k=0;
       //here finding length of array
        for(int i=0;i<(news1.length)/2; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data
        //news only
        for(int j=0; j<2; j++)
         {

          map.put(columnTags[j],news1[k]);
  
        k++;
        }
         mylistData.add(map);
        }
        SimpleAdapter arrayAdapter =
                       new SimpleAdapter(this, mylistData, R.layout.mylistrow, columnTags , columnIds);
        list.setAdapter(arrayAdapter);
       }
}
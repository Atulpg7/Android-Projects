package com.example.edu_app;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import android.widget.Spinner;
import java.util.List;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.AdapterView.OnItemClickListener;
import android.net.ConnectivityManager;
import android.util.Log;
import android.os.Handler;
import android.view.Menu;
import org.ksoap2.serialization.PropertyInfo;
import com.example.edu_app.MainActivity;
import com.example.edu_app.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class search_student extends Activity {
	public final String METHOD_NAME =  "SerachStudent"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/SerachStudent"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	static final String[] totalheading = new String[] {

        "Year","Rollno"," Name","","" ,"Branch","","","Sec"
        };
	  //android:screenOrientation="portrait" 
	
	//Successfully Uploaded
 private Spinner spinner2, spinner3;
 @SuppressLint("NewApi")
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_student);       
  
        addItemsOnSpinner2(); 
        addItemsOnSpinner3();
      
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
        //final Button btn1 = (Button) findViewById(R.id.btnSubmit);
        ListView list2 = (ListView) findViewById(R.id.athead);
        ArrayList<HashMap<String, String>> mylistData2 =
                           new ArrayList<HashMap<String, String>>();
         
        String[] columnTags2 = new String[] {"col1", "col2", "col3", "col4", "col5", "col6", "col7", "col8", "col9"};
       
        int[] columnIds2 = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5, R.id.column6, R.id.column7, R.id.column8, R.id.column9};
        int k=0;
       //here finding length of array
        for(int i=0;i<(totalheading.length)/9; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data

        //news only
        for(int j=0; j<9; j++)
         {

          map.put(columnTags2[j],totalheading[k]);
        k++;
        }
       
         mylistData2.add(map);
        }
        SimpleAdapter arrayAdapter2 =
                       new SimpleAdapter(this, mylistData2, R.layout.searchstudent_head, columnTags2 , columnIds2);
        list2.setAdapter(arrayAdapter2);
 
 }
        
        //btn1.setOnClickListener(new OnClickListener() {	 
       // public void onClick(View v) {	
 

 
        	public void subbtn(View v)
        	{
		//String rollno = getIntent().getExtras().getString("roll");
		
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		//spinner4 = (Spinner) findViewById(R.id.spinner4);
		
		final EditText edt1 = (EditText) findViewById(R.id.name);
		final EditText edt2 = (EditText) findViewById(R.id.rollno);
		final EditText edt3 = (EditText) findViewById(R.id.lib);
		final EditText edt4 = (EditText) findViewById(R.id.s_mob);
		//String dd2 = spinner2.toString();
		String dd2 = spinner2.getSelectedItem().toString();
		String dd3 = spinner3.getSelectedItem().toString();
		if(dd2 == "Select Branch")
		{
			dd2 = "";
		}
		if(dd3 == "Select Sem")
		{
			dd3="";
		}
		//String dd3 = spinner3.toString();
	//	String dd4 = spinner4.toString();

		 try
			{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			request.addProperty("name",edt1.getText().toString());
			request.addProperty("fathername","" );
			request.addProperty("mname","" );
			request.addProperty("branch",dd2 );
			request.addProperty("sem",dd3);
			request.addProperty("rollno",edt2.getText().toString());
			request.addProperty("fileno", "");
			request.addProperty("regno","" );
			request.addProperty("libcode",edt3.getText().toString());
			request.addProperty("smob",edt4.getText().toString());
			request.addProperty("fmob","");
			request.addProperty("servicekey","thisismycommunicationapp");
			request.addProperty("servicetype","SOFT");
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION,envelope);
			SoapObject result = (SoapObject) envelope.getResponse();
			String rest[] = new String[result.getPropertyCount()];
			 

			for(int i =0 ; i<result.getPropertyCount();++i)
			{
				rest[i]=result.getProperty(i).toString();
			}		
			// cgp heading
			ListView list = (ListView) findViewById(R.id.gridView2);

	        ArrayList<HashMap<String, String>> mylistData =
	                           new ArrayList<HashMap<String, String>>();
	         
	        String[] columnTags = new String[] {"col5", "col2", "col3", "col4", "col1", "col6", "col7", "col8", "col9"};
	         
	        int[] columnIds = new int[] {R.id.column5, R.id.column2, R.id.column3, R.id.column4, R.id.column1, R.id.column6, R.id.column7, R.id.column8, R.id.column9};
	        int gp1=0;
	       //here finding length of array
	        for(int i=0;i<(rest.length)/9; i++)
	        {
	         HashMap<String,String> map = new HashMap<String, String>();
	         //initialize row data

	        //news only
	        for(int j=0; j<9; j++)
	         {

	          map.put(columnTags[j],rest[gp1]);

	        gp1++;
	         
	        }
	      
	         mylistData.add(map);
	        }
	        SimpleAdapter arrayAdapter =new SimpleAdapter(this, mylistData, R.layout.searchstudent_head, columnTags , columnIds);
	        list.setAdapter(arrayAdapter); 
	        
	       
	        
	        list.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position,
	                    long id) {
	            	/*PhoneCallListener phoneListener = new PhoneCallListener();
	    			TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
	    			telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);*/
	            	String phn = parent.getItemAtPosition(position).toString().substring(6,15);
	            	String phn2 = parent.getItemAtPosition(position).toString();

						 Intent i = new Intent(search_student.this, fire.class);
			        		i.putExtra("urldata","http://glauniversity.in/studentinformation.aspx?Stu_ID="  + phn);
			        		   startActivity(i);

						    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://glauniversity.in/studentinformation.aspx?Stu_ID="  + phn));
						   // startActivity(browserIntent);		
	            }
	            });
	      
			}
			catch (Exception E) {
			E.printStackTrace();		
			Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
			   t4.show();
			} 
        		
        	//	Toast t4 =  Toast.makeText(getApplicationContext(), " welcome to check this masg app ", Toast.LENGTH_LONG);
 			  // t4.show();
			   }
		/*private void ert() {
			// TODO Auto-generated method stub
			 Intent i=new Intent(demo.this,emphome.class);
				startActivity(i);
		}  */  
		//});
        
//}
        /*	private class PhoneCallListener extends PhoneStateListener {
        		 
        		private boolean isPhoneCalling = false;
         
        		String LOG_TAG = "LOGGING 123";
         
        		@Override
        		public void onCallStateChanged(int state, String incomingNumber) {
         
        			if (TelephonyManager.CALL_STATE_RINGING == state) {
        				// phone ringing
        				Log.i(LOG_TAG, "RINGING, number: " + incomingNumber);
        			}
         
        			if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
        				// active
        				Log.i(LOG_TAG, "OFFHOOK");
         
        				isPhoneCalling = true;
        			}
         
        			if (TelephonyManager.CALL_STATE_IDLE == state) {
        				// run when class initial and phone call ended, 
        				// need detect flag from CALL_STATE_OFFHOOK
        				Log.i(LOG_TAG, "IDLE");
         
        				if (isPhoneCalling) {
         
        					Log.i(LOG_TAG, "restart app");
         
        					// restart app
        					Intent i = getBaseContext().getPackageManager()
        						.getLaunchIntentForPackage(
        							getBaseContext().getPackageName());
        					i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        					startActivity(i);
         
        					isPhoneCalling = false;
        				}
        			}
        		}
        	}*/
        		
public void addItemsOnSpinner2() {

	spinner2 = (Spinner) findViewById(R.id.spinner2);
	List<String> list = new ArrayList<String>();
	list.add("Select Branch");
	list.add("B.Tech. - CS");
	list.add("B.Tech. - ME");
	list.add("B.Tech. - EC");
	list.add("B.Tech. - EE");
	list.add("B.Tech. - EN");
	list.add("B.Tech. - CE");
	list.add("MCA");
	list.add("BCA");
	list.add("BBA - FB");
	list.add("BBA");
	list.add("MBA");
	list.add("M.Pharm.");
	list.add("B.Pharm.");
	list.add("Dip-Pharma");
	list.add("M.Sc. (Bio)");
	list.add("Diploma - EE");
	list.add("Diploma - CE");
	list.add("Diploma - CS");
	list.add("Diploma - ME");
	list.add("Diploma - EC");
	list.add("Diploma - EN");
	list.add("B.Ed");

	
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}

public void addItemsOnSpinner3() {

	spinner3 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("Select Sem");
	list.add("I");
	list.add("II");
	list.add("III");
	list.add("IV");
	list.add("V");
	list.add("VI");
	list.add("VII");
	list.add("VIII");

	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner3.setAdapter(dataAdapter);
}
    
}

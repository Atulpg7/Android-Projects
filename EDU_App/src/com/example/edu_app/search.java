package com.example.edu_app;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class search extends Activity {
	public final String METHOD_NAME =  "searchemployee"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/searchemployee"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	static final String[] totalheading = new String[] {

        "Name"," Dept","Deg.","Type" ,"  Mob" 
    };
	  //android:screenOrientation="portrait" 
	
	//Successfully Uploaded
 private Spinner spinner2, spinner3, spinner4;
 
 @SuppressLint("NewApi")
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);       
  
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
         
        String[] columnTags2 = new String[] {"col1", "col2", "col3", "col4", "col5"};
       
        int[] columnIds2 = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5};
        int k=0;
       //here finding length of array
        for(int i=0;i<(totalheading.length)/5; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data

        //news only
        for(int j=0; j<5; j++)
         {

          map.put(columnTags2[j],totalheading[k]);

        k++;
         
        }
       
         mylistData2.add(map);
        }
        SimpleAdapter arrayAdapter2 =
                       new SimpleAdapter(this, mylistData2, R.layout.searchhead, columnTags2 , columnIds2);
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
		
		final EditText edt1 = (EditText) findViewById(R.id.editText2);
		final EditText edt2 = (EditText) findViewById(R.id.editText1);
		//String dd2 = spinner2.toString();
		String dd2 = spinner2.getSelectedItem().toString();
		String dd3 = spinner3.getSelectedItem().toString();
		
		if(dd2 == "Select Department")
		{
		dd2 ="";	
		}
		
		if(dd3 == "Select Designation")
		{
			dd3="";
		}
		
		//String dd3 = spinner3.toString();
	//	String dd4 = spinner4.toString();

		 try
			{
			 Toast t4 =  Toast.makeText(getApplicationContext(), dd2, Toast.LENGTH_LONG);
			   t4.show();
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			request.addProperty("name",edt1.getText().toString());
			request.addProperty("depart", dd2 );
			request.addProperty("desg",dd3 );
			//request.addProperty("stafftype",dd3 );
			//request.addProperty("mob",edt1.getText().toString());
			
			//request.addProperty("name","Lalit");
			//request.addProperty("depart", "");
			//request.addProperty("desg","" );
			request.addProperty("stafftype","");
			request.addProperty("mob",edt2.getText().toString());
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
	         
	        String[] columnTags = new String[] {"col1", "col2", "col3", "col4", "col5"};
	         
	        int[] columnIds = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5};
	        int gp1=0;
	       //here finding length of array
	        for(int i=0;i<(rest.length)/5; i++)
	        {
	         HashMap<String,String> map = new HashMap<String, String>();
	         //initialize row data

	        //news only
	        for(int j=0; j<5; j++)
	         {

	          map.put(columnTags[j],rest[gp1]);

	        gp1++;
	         
	        }
	      
	         mylistData.add(map);
	        }
	        SimpleAdapter arrayAdapter =new SimpleAdapter(this, mylistData, R.layout.searchhead, columnTags , columnIds);
	        list.setAdapter(arrayAdapter); 
	        
	        
	        list.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position,
	                    long id) {
	            	/*PhoneCallListener phoneListener = new PhoneCallListener();
	    			TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
	    			telephonyManager.listen(phoneListener,PhoneStateListener.LISTEN_CALL_STATE);*/
	            	String phn = parent.getItemAtPosition(position).toString().substring(6,16);
	            	String phn2 = parent.getItemAtPosition(position).toString();
	            	
	
					 Intent callIntent = new Intent(Intent.ACTION_CALL);
						callIntent.setData(Uri.parse("tel:"+phn));
						startActivity(callIntent);
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
	list.add("Select Department");
	list.add("ACCOUNT SECTION");
	list.add("B.Ed.");
	list.add("CONTROLLER OFFICE");
	list.add("ADMISSION SECTION");
	list.add("EXAMINATION SECTION");
	list.add("CHANCELLOR SECRETARY");
	list.add("CATERING");
	list.add("TRAINING AND DEVELOPMENT");
	list.add("FACULTY OF EDUCATION");
	list.add("HEALTH CARE");
	list.add("BIOTECHNOLOGY");
	list.add("CHEMISTRY");
	list.add("ENGLISH");
	list.add("ENVIRONMENTAL SCIENCE");
	list.add("FINE ARTS");
	list.add("MATHEMATICS");
	list.add("PHYSICS");
	list.add("MANAGEMENT");
	list.add("CIVIL ENGG.");
	list.add("COMPUTER ENGG. AND APPLICATIONS");
	list.add("ELECTRONICS AND COMMUNICATION ENGG.");
	list.add("ELECTRICAL ENGINEERING");
	list.add("MECHANICAL ENGINEERING");
	list.add("PHARMACEUTICAL RESEARCH");
	list.add("CENTRAL LIBRARY");
	list.add("CONSTRUCTION MAINTENANCE - CIVIL");
	list.add("CONSTRUCTION MAINTENANCE - ELEC.");
	list.add("COMPUTER SECTION");
	list.add("ESTABLISHMENT SECTION");
	list.add("HOUSE KEEPING");
	list.add("HOSTEL");
	list.add("HORTICULTURE");
	list.add("PURCHASE SECTION");
	list.add("REGISTRAR OFFICE");
	list.add("SECURITY");
	list.add("TRANSPORT SECTION");
	list.add("ACADEMIC SECTION");
	list.add("STORE KEEPER");
	list.add("STORE (SPORTS)");
	list.add("TRAINING & PLACEMENT");
	list.add("TREASURER OFFICE");
	list.add("UNIVERSITY POLYTECHNIC");
	list.add("VICE CHANCELLOR OFFICE");

	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}

public void addItemsOnSpinner3() {

	spinner3 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("Select Designation");
	list.add("A C PLANT OFFICER");
	list.add("A N M");
	list.add("AC OPERATOR");
	list.add("AC TECHNICIAN");
	list.add("ACADEMIC ADVISOR");
	list.add("ACCOUNT OFFICER");
	list.add("ACCOUNTANT");
	list.add("ACCOUNTS CLERK");
	list.add("ADMIN. OFFICER");
	list.add("ADVOCATE");
	list.add("ANIMAL HOUSE ATTENDANT");
	list.add("ARTIST");
	list.add("ASSISTANT");
	list.add("ASSISTANT ADMINISTRATIVE OFFICER");
	list.add("ASSISTANT CATERING MANAGER");
	list.add("ASSISTANT DRUG STORE");
	list.add("ASSISTANT EDITOR");
	list.add("ASSISTANT ELECTRICIAN");
	list.add("ASSISTANT ENGINEER");
	list.add("ASSISTANT ENGINEER - ELECTRICAL");
	list.add("ASSISTANT GENERATOR OPERATOR");
	list.add("ASSISTANT HOUSE KEEPING INCHARGE");
	list.add("ASSISTANT LIBRARIAN");
	list.add("ASSISTANT MACHINE MAN");
	list.add("ASSISTANT MANAGER");
	list.add("ASSISTANT MESS MANAGER");
	list.add("ASSISTANT PLUMBER");
	list.add("ASSISTANT PROFESSOR");
	list.add("ASSISTANT REGISTRAR");
	list.add("ASSISTANT TELEPHONE OPERATOR");
	list.add("ASSISTANT WARDEN");
	list.add("ASSOCIATE CHIEF ADMINISTRATIVE OFFICER");
	list.add("ASSOCIATE EXAMINATION CELL");
	list.add("ASSOCIATE PROFESSOR");
	list.add("ASSOSCIATE GM - CORPORATE RELATIONS");
	list.add("ATTAR");
	list.add("ATTAR INCHARGE");
	list.add("ATTENDANT");
	list.add("AYA");
	list.add("BADMINTON COACH");
	list.add("BINDER");
	list.add("BIO CHEMIST");
	list.add("BOOK-BINDER");
	list.add("CALLIGRAPHER");
	list.add("CARETAKER");
	list.add("CARPENTER");
	list.add("CASUALITY MEDICAL OFFICER");
	list.add("CATERING MANAGER");
	list.add("CERCULATION OFFICER");
	list.add("CHANCELLOR");
	list.add("CHANCELLOR SIR");
	list.add("CHIEF ADMINISTRATIVE OFFICER");
	list.add("CHIEKF ADMINISTRATIVE OFFICER");
	list.add("CIVIL ENGINEER");
	list.add("CIVIL SUPERVISOR");
	list.add("CLERK");
	list.add("CLERK CUM STORE KEEPER");
	list.add("CLINICAL INSTRUCTOR");
	list.add("COMMUNICATION EXECUTIVE");
	list.add("COMPOUNDER");
	list.add("COMPUTER LABRORATORY ATTENDANT");
	list.add("COMPUTER OPERATOR");
	list.add("COMPUTER PROGRAMMER");
	list.add("CONSULTANT HON. PROFESSOR");
	list.add("COOK");
	list.add("COORDINATOR");
	list.add("COURSE DIRECTOR");
	list.add("D T P OPERATOR");
	list.add("DATA ENTRY OPERATOR");
	list.add("DEMONSTRATOR");
	list.add("DEPUTY GENERAL MANAGER - CORPORATE RELATIONS");
	list.add("DEPUTY LIBRARIAN");
	list.add("DEPUTY MEDICAL SUPRITENDENT");
	list.add("DEPUTY REGISTRAR");
	list.add("DEPUTY SYSTEM ADMINISTRATOR");
	list.add("DG OPERATOR");
	list.add("DIRECTOR");
	list.add("DRIVER");
	list.add("DRIVER GR - I");
	list.add("DRIVER GR - II");
	list.add("ELECTRICAL ENGINEER");
	list.add("ELECTRICAL SUPERVISOR");
	list.add("ELECTRICIAN");
	list.add("ELECTRICIAN CUM OPERATOR");
	list.add("EMERITUS PROFESSOR");
	list.add("ENGLISH");
	list.add("ESTATE OFFICER");
	list.add("EXECUTIVE - CORPORATE RELATIONS");
	list.add("EXECUTIVE ASSISTANT");
	list.add("EXECUTIVE OFFICER");
	list.add("FIELD WORKER");
	list.add("FINANCE OFFICER");
	list.add("FRONT OFFICE EXECUTIVE");
	list.add("GARDENER");
	list.add("GENERATOR OPERATOR");
	list.add("GLAZIER");
	list.add("GM - CORPORATE RELATIONS");
	list.add("GRAPHIC DESIGNER");
	list.add("GUESS LECTURER");
	list.add("GUNMAN");
	list.add("HARDWARE ENGINEER");
	list.add("HELPER");
	list.add("HELPER ELECTRICIAN");
	list.add("HELPER GENERATOR OPERATOR");
	list.add("HELPER MOTOR WINDER MAN");
	list.add("HORTICULTURE OFFICER");
	list.add("HORTICULTURE SUPERVISOR");
	list.add("HOSTEL INCHARGE");
	list.add("HOUSE KEEPING INCHARGE");
	list.add("HOUSE KEEPING MANAGER");
	list.add("HOUSE KEEPING SUPERVISOR");
	list.add("IMAM");
	list.add("JUNIOR ASSISTANT");
	list.add("JUNIOR DATA ENTRY OPERATOR");
	list.add("JUNIOR ENGINEER");
	list.add("JUNIOR ENGINEER CIVIL");
	list.add("LAB ASSISTANT");
	list.add("LAB ATTENDANT");
	list.add("LAB INSTRUCTOR");
	list.add("LAB TECHNICIAN");
	list.add("LABORATORY ASSISTANT");
	list.add("LABORATORY ATTENDANT");
	list.add("LADY HEALTH VISITOR");
	list.add("LADY MEDICAL OFFICER");
	list.add("LECTURER");
	list.add("LECTURER (DIPLOMA)");
	list.add("LIBRARY ASSISTANT");
	list.add("LIBRARY ATTENDANT");
	list.add("LIBRARY CLERK");
	list.add("MAINTENANCE ENGINEER");
	list.add("MAINTENANCE SUPERVISOR");
	list.add("MALIMEDICAL SUPRITENDENT");
	list.add("MANAGEMENT TRAINEE");
	list.add("MANAGER - ACADEMIC INITIATIVE");
	list.add("MANAGER COMMUNICATION");
	list.add("MANAGER CORPORATE RELATIONS");
	list.add("MANGER - MAINTENANCE");
	list.add("MECHANIC");
	list.add("MECHANIC CUM GENERATOR OPERATOR");
	list.add("MEDICAL ATTENDANT");
	list.add("MEDICAL OFFICER");
	list.add("MEMBER EXECUTIVE COUNCIL");
	list.add("MESS ATTENDANT");
	list.add("MESS MANAGER");
	list.add("MESS SUPERVISOR");
	list.add("MIS ANALYST");
	list.add("MONO CASTER");
	list.add("MOTOR WINDER MAN");
	list.add("MUSIC TEACHER");
	list.add("NETWORK ENGINEER");
	list.add("NETWORKING ASSISTANT");
	list.add("NURSE");
	list.add("OFFICE ASSISTANT");
	list.add("OFFICE ATTENDANT");
	list.add("OFFICE CLERK");
	list.add("OFFICE EXECUTIVE");
	list.add("OFFICE STAFF");
	list.add("P.A TO H.O.D");
	list.add("PA TO DIRECTOR");
	list.add("PAINTER");
	list.add("PANEL OPERATOR");
	list.add("PATENT CARE OFFICER");
	list.add("PDP TRAINER");
	list.add("PEON");
	list.add("PERSONAL ASSISTANT");
	list.add("PERSONAL SECRETARY TO VC");
	list.add("PERSONAL SECURITY OFFICER");
	list.add("PHOTOGRAPHER");
	list.add("PHYSIOTHERAPIST");
	list.add("PLUMBER");
	list.add("PRE TIB TEACHER");
	list.add("PRINCIPAL");
	list.add("PRO VICE CHANCELLOR");
	list.add("PRO-TERM LECTURER");
	list.add("PROFESSIONAL ASSISTANT");
	list.add("PROFESSOR");
	list.add("PROFESSOR AND CONTROLLER EXAMS AND ADMISSION");
	list.add("PROOF READER");
	list.add("PS TO VICE CHANCELLOR");
	list.add("PUBLIC RELATION OFFICER");
	list.add("READER");
	list.add("RECEPTIONIST");
	list.add("REGISTRAR");
	list.add("RESEARCH ASSISTANT");
	list.add("RESIDENT MEDICAL OFFICER");
	list.add("SAFAI KARMCHARI");
	list.add("SECREATARY");
	list.add("SECTION OFFICER");
	list.add("SECURITY GUARD");
	list.add("SECURITY INSPECTOR");
	list.add("SECURITY SUPERVISOR");
	list.add("SEMI PROFESSIONAL ASSISTANT");
	list.add("SENIOR ASSISTANT");
	list.add("SENIOR COMPOSITOR");
	list.add("SENIOR EXECUTIVE - ALUMINI RELATIONS");
	list.add("SENIOR EXECUTIVE - ALUMNI RELATIONS");
	list.add("SENIOR LAB TECHNICIAN");
	list.add("SENIOR LIBRARY ASSISTANT");
	list.add("SENIOR LIBRARY INFORMATION ASSISTANT");
	list.add("SENIOR MANAGER - CORPORATE RELATIONS");
	list.add("SENIOR PERSONAL ASSISTANT");
	list.add("SITE SUPERVISOR");
	list.add("SOFTWARE ENGINEER");
	list.add("SPECIAL GRADE - I");
	list.add("SPORTS COACH");
	list.add("SPORTS OFFICER");
	list.add("SR. EXECUTIVE CORPORATE RELATIONS");
	list.add("STAFF NURSE");
	list.add("STENOGRAPHER");
	list.add("STORE CLERK");
	list.add("STORE INCHARGE");
	list.add("STORE KEEPER");
	list.add("STORE MANAGER");
	list.add("STUDENT WELFARE OFFICER");
	list.add("SUPERVISOR");
	list.add("SUPERVISOR - FIRE & SAFETY");
	list.add("SYSTEM ADMINISTRATOR");
	list.add("SYSTEM ANALYST");
	list.add("SYSTEM ENGINEER");
	list.add("TEACHER");
	list.add("TEACHING ASSISTANT");
	list.add("TECHNICAL ASSISTANT");
	list.add("TECHNICIAN");
	list.add("TECHNICIAN ASSISTANT");
	list.add("TELEPHONE OPERATOR");
	list.add("TELEPHONE TECHNICIAN");
	list.add("TRAINEE ENGINEER");
	list.add("TRAINER");
	list.add("TRANSPORT INCHARGE ASSISTANT");
	list.add("TREASUSER");
	list.add("VICE CHAIRMAN");
	list.add("VICE CHANCELLOR");
	list.add("VOLLEYBALL COACH");
	list.add("WARD SISTER");
	list.add("WARDEN");
	list.add("WELDER");
	list.add("WORKSHOP INSTRUCTOR");
	list.add("WORKSHOP SUPERINTENDENT");
	list.add("YOGA INSTRUCTOR");
		

	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner3.setAdapter(dataAdapter);
}









}

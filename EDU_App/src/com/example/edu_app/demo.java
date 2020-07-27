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
public class demo extends Activity {
	public final String METHOD_NAME =  "storemsg"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/storemsg"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	//Successfully Uploaded
 private Spinner spinner1, spinner2,spinner21,spinner3,spinner4;
 
 @SuppressLint("NewApi")
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);       
   // addItemsOnSpinner2();
        addListenerOnSpinnerItemSelection();  
        addListenerOnSpinnerItemSelection1();  
        
        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
        final Button btn1 = (Button) findViewById(R.id.btnSubmit);
        final EditText edt1 = (EditText) findViewById(R.id.editText1);
        btn1.setOnClickListener(new OnClickListener() {	 
        public void onClick(View v) {	
        final EditText et1 = (EditText) findViewById(R.id.editText1);  
		String rollno = getIntent().getExtras().getString("roll");
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		String dd1 = spinner1.getSelectedItem().toString();
		String dd2 = spinner2.getSelectedItem().toString();
		String dd3 = spinner3.getSelectedItem().toString();
		String dd4 = spinner4.getSelectedItem().toString();
		 try
			{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			//request.addProperty("name",name.toString());//name.toString()
			request.addProperty("id",rollno);//rollno.toString()
			request.addProperty("type",dd1);
			request.addProperty("course", dd2 );
			request.addProperty("branch",dd3 );
			request.addProperty("semester",dd4);
			request.addProperty("msg",et1.getText().toString());
			request.addProperty("servicekey","thisismycommunicationapp");
			request.addProperty("servicetype","SOFT");
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION,envelope);
			Object result = envelope.getResponse();
			System.out.println("Result :" + result.toString());
			if(result.toString().equals("Success"))
			{
				//((TextView) findViewById (R.id.txtAddition)).setText("invalid Username and password : "+result.toString());
				Toast t2 =  Toast.makeText(getApplicationContext(), "  your message Uploaded successfully ", Toast.LENGTH_LONG);
				   t2.show();
				  // Intent i=new Intent(demo.this,emphome.class);
					//startActivity(i);
				  // ert();
			}
			else
			{	
				//song1.release();
				
				Toast t3 =  Toast.makeText(getApplicationContext(),result.toString() , Toast.LENGTH_LONG);
				   t3.show();	
			}
			}
			catch (Exception E) {
			E.printStackTrace();		
			Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
			   t4.show();
			}    
			   }

		/*private void ert() {
			// TODO Auto-generated method stub
			 Intent i=new Intent(demo.this,emphome.class);
				startActivity(i);
		}  */  
		});
        
}
public void addListenerOnSpinnerItemSelection() {
	spinner2 = (Spinner) findViewById(R.id.spinner1);
	spinner2.setOnItemSelectedListener(new CustomOnItemSelected(){
		  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
			  Toast t3 = Toast.makeText(parent.getContext(),parent.getItemAtPosition(pos).toString(),Toast.LENGTH_SHORT);
			 // t3.show();
			  if("Employee".equals(parent.getItemAtPosition(pos).toString()))
				 {
					 addItemsOnSpinner2(); 
					 addItemsOnSpinnerdefault1(); 
				 }
			  else if("All".equals(parent.getItemAtPosition(pos).toString()))
			  {
				  addItemsOnSpinner4();
				  addItemsOnSpinnerdefault1(); 
			  }
			  else
			  {
				  addItemsOnSpinner3();
				  addItemsOnSpinneryear();
			  }
		  }
 });
}

public void addListenerOnSpinnerItemSelection1() {
	spinner21 = (Spinner) findViewById(R.id.spinner2);
	spinner21.setOnItemSelectedListener(new CustomOnItemSelected(){
		  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
			  Toast t4 = Toast.makeText(parent.getContext(),parent.getItemAtPosition(pos).toString(),Toast.LENGTH_SHORT);
			 t4.show();
	  if("B.Tech.".equals(parent.getItemAtPosition(pos).toString()))
				 {
		  addItemsOnSpinnerbranch();
					
				 }
			  else if("M.Tech.".equals(parent.getItemAtPosition(pos).toString()))
			  {
				  addItemsOnSpinnerbranch();
			  }
			  else if("Diploma".equals(parent.getItemAtPosition(pos).toString()))
			  {
				  addItemsOnSpinnerbranch();
			  }
			  else
			  {
				  addItemsOnSpinnerdefault();
			  }
		  }
 });
}


/*public void sub(View v)
{
	Spinner spinner = (Spinner)findViewById(R.id.spinner1); 
	String text = spinner.getSelectedItem().toString();
Toast t2 =  Toast.makeText(getApplicationContext(),text.toString(), Toast.LENGTH_LONG);
t2.show();
addItemsOnSpinner2();
Spinner spinner2 = (Spinner)findViewById(R.id.spinner2); 

}*/
//add items into spinner dynamically

/*public void CustomOnItemSelectedListener(AdapterView<?> parent, View view, int pos,long id) 
{
	 Toast t2 =  Toast.makeText(parent.getContext(), 
				"value : " + parent.getItemAtPosition(pos).toString(),
				Toast.LENGTH_SHORT);
			  t2.show();
			
}*/
public void addItemsOnSpinner2() {

	spinner2 = (Spinner) findViewById(R.id.spinner2);
	List<String> list = new ArrayList<String>();
	list.add("None");
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

	spinner2 = (Spinner) findViewById(R.id.spinner2);
	List<String> list = new ArrayList<String>();
	list.add("None");
	list.add("B.Tech.");
	list.add("B.Tech. (First Year Only)");
	list.add("Diploma");
	list.add("Diploma (First Year Only)");
	list.add("Diploma in Pharmacy");
	list.add("Bachelor of Business Administration");
	list.add("Bachelor of Computer Applications");
	list.add("B. Sc. (Hons.)");
	list.add("Bachelor of Pharmacy");
	list.add("B.Com.(Hons.)");
	list.add("Bachelor of Business Administration in Family Business");
	list.add("Bachelor of Education");
	list.add("Master of Business Administration");
	list.add("Master of Computer Applications");
	list.add("Master of Pharmacy");
	list.add("M.Tech.");
	list.add("Ph.D.");

	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}
public void addItemsOnSpinner4() {

	spinner2 = (Spinner) findViewById(R.id.spinner2);
	List<String> list = new ArrayList<String>();

	list.add("None");
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}
public void addItemsOnSpinnerbranch() {

	spinner2 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("None");
	list.add("Civil Engineering");
	list.add("Electrical Engineering");
	list.add("Mechanical Engineering");
	list.add("Electronics & Communication Engineering");
	
	list.add("Electrical & Electronics Engineering");
	list.add("Computer Science & Engineering");
	list.add("Engineering in Information Technology");

	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}

public void addItemsOnSpinnerdefault() {

	spinner2 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("None");
	
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}
public void addItemsOnSpinnertechdept() {

	spinner2 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("None");
   
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}
public void addItemsOnSpinnernontechdept() {

	spinner2 = (Spinner) findViewById(R.id.spinner3);
	List<String> list = new ArrayList<String>();
	list.add("None");
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}
public void addItemsOnSpinnerdefault1() {
	spinner2 = (Spinner) findViewById(R.id.spinner4);
	List<String> list = new ArrayList<String>();
	list.add("None");	
	ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
}
public void addItemsOnSpinneryear() {

	spinner2 = (Spinner) findViewById(R.id.spinner4);
	List<String> list = new ArrayList<String>();
	list.add("None");
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
	spinner2.setAdapter(dataAdapter);
}
}


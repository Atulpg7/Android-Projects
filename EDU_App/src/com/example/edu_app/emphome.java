package com.example.edu_app;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
public class emphome extends Activity {	
	public final String METHOD_NAME =  "statusmsg";
	public final String METHOD_NAME2 =  "ActivatedServices";// our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/statusmsg";
	public final String SOAP_ACTION2 = "http://tempuri.org/ActivatedServices";// NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	private WebView wv;

	
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.emphome);
	String name1=getIntent().getExtras().getString("name");
	String type1=getIntent().getExtras().getString("type");
	String deg1=getIntent().getExtras().getString("deg");
	
	if(type1.equals("NON TEACHING")|| type1.equals("")) 
			{
		ImageButton btn17 = (ImageButton) findViewById(R.id.admin);
		//TextView tx1 = (TextView) findViewById(R.id.txtsend);
		//tx1.setVisibility(View.INVISIBLE);
		btn17.setVisibility(View.INVISIBLE);
			}
	((TextView) findViewById(R.id.name)).setText("Hello, "+name1.toString());
	
	
	TextView txt1 = (TextView) findViewById(R.id.logout);
	txt1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // do you work here
        	
        	Intent i=new Intent(emphome.this,MainActivity.class );
        	startActivity(i);
        	
         }
        });
	
	 try
		{
		String roll=getIntent().getExtras().getString("id1");
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
		
		Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
		   t4.show();
		}    	
}

String tv;
public void empsalary(View v)
{ 
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STAFF");//rollno.toString()
		request.addProperty("activity","SALARY");//rollno.toString()
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
				String name=getIntent().getExtras().getString("name");
				String rollno=getIntent().getExtras().getString("id1");
				String deg1=getIntent().getExtras().getString("deg");
					Intent i=new Intent(this,empsalary.class );
					 i.putExtra("attname",name.toString());
					i.putExtra("roll",rollno.toString());
					i.putExtra("deg",deg1.toString());
					startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " SALARY Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
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
		request.addProperty("type","STAFF");//rollno.toString()
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
				String name=getIntent().getExtras().getString("name");
				String rollno=getIntent().getExtras().getString("id1");
				String deg1=getIntent().getExtras().getString("deg");
					Intent i=new Intent(this,empattendance.class );
					  i.putExtra("attname",name.toString());
					  i.putExtra("roll",rollno.toString());
					  i.putExtra("deg",deg1.toString());
					startActivity(i);
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

public void empfeedback(View v)
{    
//String name=getIntent().getExtras().getString("name");
String rollno=getIntent().getExtras().getString("id1");
	Intent i=new Intent(this,empfeedback.class );
	 // i.putExtra("attname",name.toString());
	  i.putExtra("roll",rollno.toString());
	  i.putExtra("type", "Employee");
	startActivity(i);
}

public void search_student(View v)
{    
	Intent i=new Intent(this,search_student.class );
	startActivity(i);
}

public void logout(View v)
{    	
	Intent i=new Intent(this,MainActivity.class );
	startActivity(i);
}

public void prep(View v)
{  
	String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://172.16.10.15:8080/output2.aspx?emp=" + rollno.toString()));
   // startActivity(browserIntent);
		
		 Intent i = new Intent(emphome.this, fire.class);
 		i.putExtra("urldata","http://172.16.10.15:8088/TestOutput.aspx");
 		   startActivity(i);
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}

public void admin(View v)
{    
	try
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("type","STAFF");//rollno.toString()
		request.addProperty("activity","SENDMESSAGE");//rollno.toString()
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
				Intent i=new Intent(this,demo.class );
				i.putExtra("roll",rollno.toString());
				startActivity(i);
	}
	else
	{
		Toast t4 =  Toast.makeText(getApplicationContext(), " SENDMESSAGE Activity is Deactivated for Some Time  ", Toast.LENGTH_LONG);
		   t4.show();
	}
	
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
	   t4.show();
	}

	
}

public void empalert(View v)
{    String rollno=getIntent().getExtras().getString("id1");	
	Intent i=new Intent(this,empalert.class );
	i.putExtra("roll",rollno.toString());
	startActivity(i);
}
public void search(View v)
{   // String rollno=getIntent().getExtras().getString("id1");	
	Intent i=new Intent(this,search.class );
	//i.putExtra("roll",rollno.toString());
	startActivity(i);
}

public void car(View v)
{ 
	
	String rollno=getIntent().getExtras().getString("id1");   
	Intent i = new Intent(emphome.this, fire.class);
		i.putExtra("urldata","http://hostel.glauniversity.in/grievance_login.aspx?emp=" + rollno.toString() + "&logintype=Transport");
		   startActivity(i);
}
public void house(View v)
{  String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hostel.glauniversity.in:88/login.aspx?emp="  + rollno.toString()));
    //startActivity(browserIntent);
		
		 Intent i = new Intent(emphome.this, fire.class);
	 		i.putExtra("urldata","http://hostel.glauniversity.in:88/login.aspx?emp="  + rollno.toString());
	 		   startActivity(i);
		
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}
public void griv(View v)
{   String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
    //Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hostel.glauniversity.in/grievance_login.aspx?emp=" + rollno.toString()));
    //startActivity(browserIntent);
		 Intent i = new Intent(emphome.this, fire.class);
	 		i.putExtra("urldata","http://hostel.glauniversity.in/grievance_login.aspx?emp=" + rollno.toString());
	 		   startActivity(i);
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}
public void proc(View v)
{   String rollno=getIntent().getExtras().getString("id1");
	if (MainActivity.getInstance(this).isOnline()) {
   // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://hostel.glauniversity.in:85/pb_complaint_student.aspx?univroll=" + rollno.toString()));
    //startActivity(browserIntent);
		 Intent i = new Intent(emphome.this, fire.class);
	 		i.putExtra("urldata","http://hostel.glauniversity.in:85/pb_complaint_student.aspx?univroll=" + rollno.toString());
	 		   startActivity(i);
		
	} else {
        Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
        t1.show(); 
    }
}
}

package com.example.edu_app;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
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
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
public class resultButton1 extends Activity {
	
	public final String METHOD_NAME =  "course"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/course"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	@SuppressLint("NewApi")
	@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.resultbutton);
	if (android.os.Build.VERSION.SDK_INT > 9) {
	    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	}
String name1=getIntent().getExtras().getString("id3");

	try
	{
	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	request.addProperty("roll",name1);
	request.addProperty("servicekey","thisismycommunicationapp");
	request.addProperty("servicetype","SOFT");
	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.dotNet = true;
	envelope.setOutputSoapObject(request);
	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	androidHttpTransport.call(SOAP_ACTION,envelope);
	Object result = envelope.getResponse();
	System.out.println("Result :" + result.toString());
	
	if(result.toString().equals("1"))
	{ 
		Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);
	Button btn7 = (Button) findViewById(R.id.sem7);
	btn7.setVisibility(View.INVISIBLE);
		Button btn6 = (Button) findViewById(R.id.sem6);
	btn6.setVisibility(View.INVISIBLE);
	Button btn5 = (Button) findViewById(R.id.sem5);
	btn5.setVisibility(View.INVISIBLE);
		Button btn4 = (Button) findViewById(R.id.sem4);
	btn4.setVisibility(View.INVISIBLE);
	Button btn3 = (Button) findViewById(R.id.sem3);
	btn3.setVisibility(View.INVISIBLE);
	Button btn2 = (Button) findViewById(R.id.sem2);
	btn2.setVisibility(View.INVISIBLE);
	}
	
	else if(result.toString().equals("2"))
	{
		Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);
	Button btn7 = (Button) findViewById(R.id.sem7);
	btn7.setVisibility(View.INVISIBLE);
		Button btn6 = (Button) findViewById(R.id.sem6);
	btn6.setVisibility(View.INVISIBLE);
	Button btn5 = (Button) findViewById(R.id.sem5);
	btn5.setVisibility(View.INVISIBLE);
		Button btn4 = (Button) findViewById(R.id.sem4);
	btn4.setVisibility(View.INVISIBLE);
	Button btn3 = (Button) findViewById(R.id.sem3);
	btn3.setVisibility(View.INVISIBLE);
}
	else if(result.toString().equals("3"))
	{ Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);
	Button btn7 = (Button) findViewById(R.id.sem7);
	btn7.setVisibility(View.INVISIBLE);
		Button btn6 = (Button) findViewById(R.id.sem6);
	btn6.setVisibility(View.INVISIBLE);
	Button btn5 = (Button) findViewById(R.id.sem5);
	btn5.setVisibility(View.INVISIBLE);
		Button btn4 = (Button) findViewById(R.id.sem4);
	btn4.setVisibility(View.INVISIBLE);
}
	else if(result.toString().equals("4"))
	{ Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);
	Button btn7 = (Button) findViewById(R.id.sem7);
	btn7.setVisibility(View.INVISIBLE);
		Button btn6 = (Button) findViewById(R.id.sem6);
	btn6.setVisibility(View.INVISIBLE);
	Button btn5 = (Button) findViewById(R.id.sem5);
	btn5.setVisibility(View.INVISIBLE);
		
}
	else if(result.toString().equals("5"))
	{ Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);
	Button btn7 = (Button) findViewById(R.id.sem7);
	btn7.setVisibility(View.INVISIBLE);
		Button btn6 = (Button) findViewById(R.id.sem6);
	btn6.setVisibility(View.INVISIBLE);
	
}	
	else if(result.toString().equals("6"))
	{ Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);
	Button btn7 = (Button) findViewById(R.id.sem7);
	btn7.setVisibility(View.INVISIBLE);		
}
	else if(result.toString().equals("7"))
	{ Button btn8 = (Button) findViewById(R.id.sem8);
	btn8.setVisibility(View.INVISIBLE);		
}	
	
	} catch (Exception E) {
		E.printStackTrace();
		}
}
public void examresult(View v)
{ String id4=getIntent().getExtras().getString("id3");
	String uname1 =getIntent().getExtras().getString("uname");
	switch (v.getId()) {
    case R.id.sem1:
    	 Intent i=new Intent(this,examresult1.class );
     	i.putExtra("name",id4.toString());
     	i.putExtra("sem", "I");
     	i.putExtra("uname", uname1);
     	startActivity(i);
         break;
     case R.id.sem2:
    	 Intent j=new Intent(this,examresult1.class );
    	j.putExtra("name",id4.toString());
    	j.putExtra("sem", "II");
    	j.putExtra("uname", uname1);
    	startActivity(j);
         break;
     case R.id.sem3:
    	 Intent k=new Intent(this,examresult1.class );
    	 k.putExtra("name",id4.toString());
    	k.putExtra("sem", "III");
    	k.putExtra("uname", uname1);
    	startActivity(k);
         break;
     case R.id.sem4:
    	 Intent l=new Intent(this,examresult1.class );
    	 l.putExtra("name",id4.toString());
    	l.putExtra("sem", "IV");
    	l.putExtra("uname", uname1);
    	startActivity(l);
         break;
     case R.id.sem5:
    	 Intent m=new Intent(this,examresult1.class );
    	m.putExtra("name",id4.toString());
    	 m.putExtra("sem", "V");
    	 m.putExtra("uname", uname1);
    	startActivity(m);
         break;
     case R.id.sem6:
    	 Intent n=new Intent(this,examresult1.class );
    	n.putExtra("name",id4.toString());
    	n.putExtra("sem", "VI");
    	n.putExtra("uname", uname1);
    	startActivity(n);
         break;
     case R.id.sem7:
    	 Intent o=new Intent(this,examresult1.class );
    	 o.putExtra("name",id4.toString());
     o.putExtra("sem", "VII");
     o.putExtra("uname", uname1);
    	startActivity(o);
         break;
     case R.id.sem8:
    	 Intent p=new Intent(this,examresult1.class );
    	 p.putExtra("name",id4.toString());
    	p.putExtra("sem", "VIII");
    	p.putExtra("uname", uname1);
    	startActivity(p);
         break;
         
 }	 
	
}

public void term(View v)
{ 
	String id4=getIntent().getExtras().getString("id3");
	String uname1 =getIntent().getExtras().getString("uname");
	Intent n=new Intent(this,term.class );
	n.putExtra("name",id4.toString());
	n.putExtra("uname", uname1);
	startActivity(n);
}




}

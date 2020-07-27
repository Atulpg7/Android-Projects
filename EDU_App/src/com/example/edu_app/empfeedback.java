package com.example.edu_app;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.media.MediaPlayer;
import com.example.edu_app.MainActivity;
import com.example.edu_app.R;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
public class empfeedback extends Activity {
	
	public final String METHOD_NAME =  "addfeedback"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/addfeedback"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	private RadioGroup radioSexGroup;
	private RadioButton radioSexButton;
	private Button btnDisplay;

 @SuppressLint("NewApi")
 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empfeedback);	
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		final Button btn1 = (Button) findViewById(R.id.submit1);
		final TextView tv1 = (TextView) findViewById(R.id.name11);

		btn1.setOnClickListener(new OnClickListener() {	 
            public void onClick(View v) {		
		//String name = getIntent().getExtras().getString("attname");
		String rollno = getIntent().getExtras().getString("roll");
		String type1 = getIntent().getExtras().getString("type");
		final EditText ed1 =(EditText) findViewById(R.id.msg);
		 radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		 btnDisplay = (Button) findViewById(R.id.submit1);		    
		 int selectedId = radioSexGroup.getCheckedRadioButtonId();		 
		 radioSexButton = (RadioButton) findViewById(selectedId);		
		// Toast t1 =  Toast.makeText(getApplicationContext(),"Feedback has been submitted successfully:", Toast.LENGTH_LONG);
		//t1.show();
		//Intent i=new Intent(this,MainActivity.class );
		 Toast t1 =   Toast.makeText(empfeedback.this,
	     radioSexButton.getText(), Toast.LENGTH_SHORT);	
		// t1.show();		 
		 try
			{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			//request.addProperty("name",name.toString());//name.toString()
			request.addProperty("userid",rollno);//rollno.toString()
			request.addProperty("usertype",type1);
			request.addProperty("ques","How you feel to use GLAapp");
			request.addProperty("ans", radioSexButton.getText());//t1.toString()
			request.addProperty("cmt",ed1.getText().toString());
			request.addProperty("servicekey","thisismycommunicationapp");
			request.addProperty("servicetype","SOFT");
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION,envelope);
			Object result = envelope.getResponse();
			System.out.println("Result :" + result.toString());
			if(result.toString().equals("Valid"))
			{
					Toast t2 =  Toast.makeText(getApplicationContext(), "  your Feedback submitted successfully ", Toast.LENGTH_LONG);
				   t2.show();  
				   finish();
				  // Intent i=new Intent(empfeedback.this,testing_page.class );
		        	//startActivity(i); 
			}
			else
			{	 
				
				Toast t3 =  Toast.makeText(getApplicationContext(), "Problem to select Type ", Toast.LENGTH_LONG);
				   t3.show();	
			}
			}
			catch (Exception E) {
			E.printStackTrace();		
			Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
			   t4.show();
			}    
			   }    
		});
	}
}

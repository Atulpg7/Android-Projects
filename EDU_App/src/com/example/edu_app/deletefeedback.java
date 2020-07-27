package com.example.edu_app;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
public class deletefeedback extends Activity {
	public final String METHOD_NAME =  "deletefeedback"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/deletefeedback"; // NAMESPACE + method name
	public final String URL ="http://glauniversity.in/Result.asmx";
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletefeedback); 
        final Button btn = (Button) findViewById(R.id.button1);
		 btn.setOnClickListener(new OnClickListener() {	 	
		 public void onClick(View v) {
		 	final EditText et = (EditText) findViewById(R.id.editText1);	 	
		 	try{
		 		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		 		request.addProperty("transid",et.getText().toString());
		 		request.addProperty("servicekey","thisismycommunicationapp");
				request.addProperty("servicetype","SOFT");
		 		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		 		envelope.dotNet = true;
		 		envelope.setOutputSoapObject(request);
		 		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		 		androidHttpTransport.call(SOAP_ACTION,envelope);
		 		Object result = envelope.getResponse();
		 		System.out.println("Result :" + result.toString());		 		
		 		Toast t2 =  Toast.makeText(getApplicationContext(), "  your Feedback Deleted successfully ", Toast.LENGTH_LONG);
				   t2.show();		 			
		 		}
		 catch (Exception E) {
		 		E.printStackTrace();
		 		Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
		 		t1.show();
		 		} 
		 	}	         
		 });
}       
}

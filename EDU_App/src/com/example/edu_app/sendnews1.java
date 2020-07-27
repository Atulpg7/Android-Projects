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
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class sendnews1 extends Activity  implements OnClickListener {
	public final String METHOD_NAME =  "news"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/news"; // NAMESPACE + method name
	public final String URL ="http://glauniversity.in/Result.asmx";	
		ImageView imageView;
	private ImageButton ib;
private Calendar cal;
private int day;
private int month;
private int year;
private EditText et;
String month1;
@SuppressLint("NewApi")
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sendnews);
		ib = (ImageButton) findViewById(R.id.imageButton1);
		 cal = Calendar.getInstance();
		//day = cal.get(Calendar.DAY_OF_MONTH);
		 month = cal.get(Calendar.MONTH);
		 year = cal.get(Calendar.YEAR);
		 et = (EditText) findViewById(R.id.editText);
		 ib.setOnClickListener(this);	
				 
		 DatePickerDialog dpd = new DatePickerDialog(this, datePickerListener, year, month, day);
		 dpd.setTitle("Please selecet Month only");
			    		    
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		//final TextView tv = (TextView) findViewById(R.id.txtAddition);
		 final Button btn = (Button) findViewById(R.id.button1);
		 btn.setOnClickListener(new OnClickListener() {	 	
		 public void onClick(View v) {
		 	final EditText et = (EditText) findViewById(R.id.editText);
		 	final EditText et1 = (EditText) findViewById(R.id.editText2);		 	
		 	try{
		 		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		 		request.addProperty("date",et.getText().toString());
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
		 			Toast t1 =  Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG);
		 			t1.show();		 			
		 		} 
		 catch (Exception E) {
		 		E.printStackTrace();
		 		Toast t1 =  Toast.makeText(getApplicationContext(),"No Internet Connection:", Toast.LENGTH_LONG);
		 		t1.show();
		 		} 
		 	}	         
		 });
}
@Override
public void onClick(View v) {
showDialog(0);
}
@Override
@Deprecated
protected Dialog onCreateDialog(int id) {
return new DatePickerDialog(this, datePickerListener, year, month, day);
}
private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
public void onDateSet(DatePicker view, int selectedYear,
int selectedMonth, int selectedDay) {
	 if(selectedMonth==0)
	  {
		 selectedMonth=1;
				  
	  }
	  else  if(selectedMonth==1)
	  {
		  selectedMonth=2;
	  }
	  else  if(selectedMonth==2)
	  {
		  selectedMonth=3;
	  }
	  else  if(selectedMonth==3)
	  {
		  selectedMonth=4;
	  }
	  else  if(selectedMonth==4)
	  {
		  selectedMonth=5;
	  }
	  else  if(selectedMonth==5)
	  { 
		  selectedMonth=6;
	  }
	  else  if(selectedMonth==6)
	  {
		  selectedMonth=7;
	  }
	  else  if(selectedMonth==7)
	  {
		  selectedMonth=8;
	  }
	  else  if(selectedMonth==8)
	  {
		  selectedMonth=9;
	  }
	  else  if(selectedMonth==9)
	  { selectedMonth=10;
	  }
	  else  if(selectedMonth==10)
	  {selectedMonth=11;
	  }
	  else  if(selectedMonth==11)
	  {selectedMonth=12;
	  }	
et.setText(selectedMonth+"/"+selectedDay + "/ " +selectedYear);
}
};
}

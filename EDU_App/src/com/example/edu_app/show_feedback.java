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

public class show_feedback extends Activity  implements OnClickListener {
	public final String METHOD_NAME =  "showfeedback"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/showfeedback"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	static final String[] totalheading = new String[] {
        "no","type","RollNO.","name","branch","qus","ans","comments"  
    };
ImageView imageView;
private ImageButton ib;
private Calendar cal;
private int day;
private int month;
private String month3;
private String month6;
private String month7;
private int year;
private EditText et;
String month1;
private EditText etn;
String heading[];
String news1[];
int position=0;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_feedback); 
        ib = (ImageButton) findViewById(R.id.imageButton1);
		 cal = Calendar.getInstance();
		//day = cal.get(Calendar.DAY_OF_MONTH);
		 month = cal.get(Calendar.MONTH);
		 year = cal.get(Calendar.YEAR);
		  etn= (EditText) findViewById(R.id.month);
		 ib.setOnClickListener(this);	
				 
		 DatePickerDialog dpd = new DatePickerDialog(this, datePickerListener, year, month, day);
		 dpd.setTitle("Please selecet Month only");
        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
// for news
        ListView list2 = (ListView) findViewById(R.id.athead);
        ArrayList<HashMap<String, String>> mylistData2 =
                           new ArrayList<HashMap<String, String>>();
        String[] columnTags2 = new String[] {"col1", "col2", "col3", "col4", "col5", "col6", "col7","col8"};
         
        int[] columnIds2 = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5, R.id.column6, R.id.column7, R.id.column8};
        int k=0;
       //here finding length of array
        for(int i=0;i<(totalheading.length)/8; i++)
        {
         HashMap<String,String> map = new HashMap<String, String>();
         //initialize row data
        //news only
        for(int j=0; j<8; j++)
         {
          map.put(columnTags2[j],totalheading[k]);
        k++; 
        }
         mylistData2.add(map);
        }
        SimpleAdapter arrayAdapter2 =
                       new SimpleAdapter(this, mylistData2, R.layout.show_feedback, columnTags2 , columnIds2);
        list2.setAdapter(arrayAdapter2);  
}


		 	public void trt(View v)
		 	{
		 		try
				{
		        	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		        	request.addProperty("month",month6.toString());
					request.addProperty("year",month7.toString());
					request.addProperty("servicekey","thisismycommunicationapp");
					request.addProperty("servicetype","SOFT");
					SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
					envelope.dotNet = true;
					envelope.setOutputSoapObject(request);
					HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
					androidHttpTransport.call(SOAP_ACTION,envelope);
					SoapObject result =(SoapObject) envelope.getResponse();
					String rest[] = new String[result.getPropertyCount()];
					for(int i =0 ; i<result.getPropertyCount();++i)
					{
						rest[i]=result.getProperty(i).toString();
					}			
					// cgp heading
					ListView list = (ListView) findViewById(R.id.mylist);
			        ArrayList<HashMap<String, String>> mylistData =
			                           new ArrayList<HashMap<String, String>>();
			         
			        String[] columnTags = new String[] {"col1", "col2", "col3", "col4", "col5", "col6", "col7", "col8"};
			         
			        int[] columnIds = new int[] {R.id.column1, R.id.column2, R.id.column3, R.id.column4, R.id.column5, R.id.column6, R.id.column7, R.id.column8};
			        int gp1=0;
			       //here finding length of array
			        for(int i=0;i<(rest.length)/8; i++)
			        {
			         HashMap<String,String> map = new HashMap<String, String>();
			         //initialize row data
			        //news only
			        for(int j=0; j<8; j++)
			         {
			          map.put(columnTags[j],rest[gp1]);

			        gp1++;
			        }
			         mylistData.add(map);
			        }
			        SimpleAdapter arrayAdapter =
			                       new SimpleAdapter(this, mylistData, R.layout.showfeedbacklist, columnTags , columnIds);
			        list.setAdapter(arrayAdapter);
				}
		        catch (Exception E) {
					E.printStackTrace();
					Toast t1 =  Toast.makeText(getApplicationContext(), " Attendence is not updated ", Toast.LENGTH_LONG);
					t1.show();
					}
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
		  month3="Jan";
		  month6="1";
	  }
	  else  if(selectedMonth==1)
	  {
		  month3="Feb"; 
		  month6="2";
	  }
	  else  if(selectedMonth==2)
	  {
		  month3="March";
		  month6="3";
	  }
	  else  if(selectedMonth==3)
	  {
		  month3="April";
		  month6="4";
	  }
	  else  if(selectedMonth==4)
	  {
		  month3="May";
		  month6="5";
	  }
	  else  if(selectedMonth==5)
	  {
		  month3="Jun";
		  month6="6";
	  }
	  else  if(selectedMonth==6)
	  {
		  month3="July";
		  month6="7";
	  }
	  else  if(selectedMonth==7)
	  {
		  month3="Aug";
		  month6="8";
	  }
	  else  if(selectedMonth==8)
	  {
		  month3="Sept";
		  month6="9";
	  }
	  else  if(selectedMonth==9)
	  {
		  month3="Oct";
		  month6="10";
	  }
	  else  if(selectedMonth==10)
	  {
		  month3="Nov";
		  month6="11";
	  }
	  else  if(selectedMonth==11)
	  {
		  month3="Dec";
		  month6="12";
	  }			  
  etn.setText(month3+" "+selectedYear);
// month3=selectedMonth+"/"+selectedDay+"/"+selectedYear;
 month7=selectedYear+"";
//et.setText(selectedMonth+"/"+selectedDay + "/ " +selectedYear);
}
};
}

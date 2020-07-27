package com.example.edu_app;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import android.view.View;
import android.view.View.OnClickListener;

public class empsalary extends Activity implements OnClickListener {
	public final String METHOD_NAME =  "empsalary"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/empsalary"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	String month1;
	
	static final String[] totalheading = new String[] {

        "Deductions/Contributions","Amount"
    };
@SuppressLint("NewApi")	
	private ImageButton ib;
	 private Calendar cal;
	 private int day;
	 private int month;
	 private int year;
	 private String month3;
	 private String month4;
	 private String month5;
	 private EditText et;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empsalary);
		
		String empcode1 = getIntent().getExtras().getString("roll");
		String name1 = getIntent().getExtras().getString("attname");
		String deg1 = getIntent().getExtras().getString("deg");
		
		((TextView) findViewById (R.id.name)).setText("Emp.Name - "+name1.toString());
		((TextView) findViewById (R.id.empcode)).setText("Emp. Code - "+empcode1.toString());
		((TextView) findViewById (R.id.deg)).setText("Designation - "+deg1.toString());
	
		// mDateButton = (Button) findViewById(R.id.date_button);
		  ib = (ImageButton) findViewById(R.id.imageButton1);
		  cal = Calendar.getInstance();
		//  day = cal.get(Calendar.DAY_OF_MONTH);
		  month = cal.get(Calendar.MONTH);	  
		  year = cal.get(Calendar.YEAR);
		  et = (EditText) findViewById(R.id.month);
		  ib.setOnClickListener(this);

		  ListView list2 = (ListView) findViewById(R.id.athead);
	        ArrayList<HashMap<String, String>> mylistData2 =
	                           new ArrayList<HashMap<String, String>>();
	         
	        String[] columnTags2 = new String[] {"col1", "col2"};
	         
	        int[] columnIds2 = new int[] {R.id.column1, R.id.column2};
	        int k=0;
	       //here finding length of array
	        for(int i=0;i<(totalheading.length)/2; i++)
	        {
	         HashMap<String,String> map = new HashMap<String, String>();
	         //initialize row data

	        //news only
	        for(int j=0; j<2; j++)
	         {

	          map.put(columnTags2[j],totalheading[k]);

	        k++;
	         
	        }
	       
	         mylistData2.add(map);
	        }
	        SimpleAdapter arrayAdapter2 =
	                       new SimpleAdapter(this, mylistData2, R.layout.morehead, columnTags2 , columnIds2);
	        list2.setAdapter(arrayAdapter2);

	        final ImageButton ibtn1 = (ImageButton) findViewById(R.id.imageButton2);
		  final Button btn1 = (Button) findViewById(R.id.button1);
			btn1.setOnClickListener(new OnClickListener() {					 
	           
				
				public void onClick(View v) {
	            	
	            	 RelativeLayout rl2 = (RelativeLayout) findViewById(R.id.detail1);
	 		        rl2.setVisibility(View.VISIBLE);
	            	
	            	//ibtn1.setVisibility(View.VISIBLE);
	            	
		  try
			{
			  String empcode1 = getIntent().getExtras().getString("roll");
	        	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	        	request.addProperty("empid",empcode1);
				request.addProperty("m",month4.toString());
				request.addProperty("y",month5.toString());
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
				((TextView) findViewById (R.id.workingdays)).setText("Total Working Days       : "+rest[0]);
				((TextView) findViewById (R.id.totalearn)).setText("Total Earning (Rs.)        : "+rest[1]);
				((TextView) findViewById (R.id.deduction)).setText("Total Deductions (Rs.) : "+rest[2]);
				
				((TextView) findViewById (R.id.grosssalary)).setText("Gross Salary (Rs.)       : "+rest[3]);
				((TextView) findViewById (R.id.netsalary)).setText("Net Payable (Rs.)          : "+rest[4]);
				
			}
	        catch (Exception E) {
				E.printStackTrace();
				Toast t1 =  Toast.makeText(getApplicationContext(), " Salary not updated ", Toast.LENGTH_LONG);
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
				  month3="Jan";
				  month4="1";
						  
			  }
			  else  if(selectedMonth==1)
			  {
				  month3="Feb";
				  month4="2";
			  }
			  else  if(selectedMonth==2)
			  {
				  month3="March";
				  month4="3";
			  }
			  else  if(selectedMonth==3)
			  {
				  month3="April";
				  month4="4";
			  }
			  else  if(selectedMonth==4)
			  {
				  month3="May";
				  month4="5";
			  }
			  else  if(selectedMonth==5)
			  { month4="6";
				  month3="Jun";
			  }
			  else  if(selectedMonth==6)
			  {
				  month4="7";
				  month3="July";
			  }
			  else  if(selectedMonth==7)
			  {
				  month4="8";
				  month3="Aug";
			  }
			  else  if(selectedMonth==8)
			  {
				  month4="9";
				  month3="Sept";
			  }
			  else  if(selectedMonth==9)
			  { month4="10";
				  month3="Oct";
			  }
			  else  if(selectedMonth==10)
			  { month4="11";
				  month3="Nov";
			  }
			  else  if(selectedMonth==11)
			  { month4="12";
				  month3="Dec ";
			  }
			
		   et.setText(month3+""+selectedYear);
		   month3=selectedMonth+"/"+selectedDay+"/"+selectedYear;
		month5=selectedYear+"";
		  }
		 };
		
		
		 /*public void moredetails(View v)
		    { 
			 
			
				 RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.more);
			        rl1.setVisibility(View.VISIBLE); 
			
			  final String METHOD_NAME2 =  "salarymore";
			 final String SOAP_ACTION2 = "http://tempuri.org/salarymore";
		        try
				{
		        	String empcode1 = getIntent().getExtras().getString("roll");
		        	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		        	request.addProperty("empid",empcode1);
					request.addProperty("m",month4.toString());
					request.addProperty("y",month5.toString());
					SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
					envelope.dotNet = true;
					envelope.setOutputSoapObject(request);
					HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
					androidHttpTransport.call(SOAP_ACTION2,envelope);
					SoapObject result =(SoapObject) envelope.getResponse();
					String rest[] = new String[result.getPropertyCount()];
					for(int i =0 ; i<result.getPropertyCount();++i)
					{
						rest[i]=result.getProperty(i).toString();
					}

					// cgp heading
					ListView list = (ListView) findViewById(R.id.gridView1);
			        ArrayList<HashMap<String, String>> mylistData =
			                           new ArrayList<HashMap<String, String>>();
			         
			        String[] columnTags = new String[] {"col1", "col2"};
			         
			        int[] columnIds = new int[] {R.id.column1, R.id.column2};
			        int gp1=0;
			       //here finding length of array
			        for(int i=0;i<(rest.length)/2; i++)
			        {
			         HashMap<String,String> map = new HashMap<String, String>();
			         //initialize row data

			        //news only
			        for(int j=0; j<2; j++)
			         {
			          map.put(columnTags[j],rest[gp1]);

			        gp1++;
			         
			        } 
			         mylistData.add(map);
			        }
			        SimpleAdapter arrayAdapter =
			        new SimpleAdapter(this, mylistData, R.layout.morelist, columnTags , columnIds);
			        list.setAdapter(arrayAdapter);

				}
		        catch (Exception E) {
					E.printStackTrace();
					Toast t1 =  Toast.makeText(getApplicationContext(), " wrong ", Toast.LENGTH_LONG);
					t1.show();
					}
		        
		    }*/
		}

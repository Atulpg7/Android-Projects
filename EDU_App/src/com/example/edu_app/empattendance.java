package com.example.edu_app;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.ViewGroup;


import android.view.View.OnClickListener;

public class empattendance extends Activity implements OnClickListener {
	public final String METHOD_NAME =  "empattendance"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/empattendance"; // NAMESPACE + method name
	public final String URL ="http://glauniversity.in/Result.asmx";
	String h="H",p="P",wo="WO",mp="MP",wop="WOP",cl="CL";
	
 static final String[] totalheading = new String[] {

        "Deductions/Contributions","Amount"
    };
	GridView grid;	
	static final String[] numbers2 = new String[] {

        "In", "Out ", "LateIn", "EarlyOut"
    };	
	  String[] web = {
	          "1","2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21",
	          "1","2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21" 
	    } ;

	 String[] att;
		
@SuppressLint("NewApi")
	private ImageButton ib,subm;
	 private Calendar cal;
	 private int day;
	 private int month;
	 private int year;
	 private String month3;
	 private String month4;
	 private String month5;
	 private String month6;
	 private String month7;
	 String monthu="";
	 //private EditText et;
	 private EditText etn;
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.empattendance);
		String date1 []= new String[20];
		
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
		  //et = (EditText) findViewById(R.id.month);
		  etn= (EditText) findViewById(R.id.month);
		  ib.setOnClickListener(this);
		 DateFormat df = new SimpleDateFormat("MM");
	       Date dateobj = new Date();
	       DateFormat df1 = new SimpleDateFormat("yyyy");
	       Date dateobj1 = new Date();	       
		String datec=df.format(dateobj)+""+df1.format(dateobj1);
		String month1=df.format(dateobj);
		String year1=df1.format(dateobj1);
		
		  if(month1.toString().equals("01"))
		  {
			  monthu="Jan";
			  month4="1";
		  }
		  else  if(month1.toString().equals("02"))
		  {
			  monthu="Feb";
			  month4="2";
		  }
		  else  if(month1.toString().equals("03"))
		  {
			  monthu="March";
			  month4="3";
		  }
		  else  if(month1.toString().equals("04"))
		  {
			  monthu="April";
			  month4="4";
		  }
		  else  if(month1.toString().equals("05"))
		  {
			  monthu="May";
			  month4="5";
		  }
		  else  if(month1.toString().equals("06"))
		  {
			  monthu="Jun";
			  month4="6";
		  }
		  else  if(month1.toString().equals("07"))
		  {
			  monthu="July";
			  month4="7";
		  }
		  else  if(month1.toString().equals("08"))
		  {
			  monthu="Aug";
			  month4="8";
		  }
		  else  if(month1.toString().equals("09"))
		  {
			  monthu="Sept";
			  month4="9";
		  }
		  else  if(month1.toString().equals("10"))
		  {
			  monthu="Oct";
			  month4="10";
		  }
		  else  if(month1.toString().equals("11"))
		  {
			  monthu="Nov";
			  month4="11";
		  }
		  else  if(month1.toString().equals("12"))
		  {
			  monthu="Dec";
			  month4="12";
		  }
		
		((EditText) findViewById (R.id.month)).setText(monthu.toString()+" "+year1.toString());
		month5=year1+"";
		 try
			{			 
			  String empid = getIntent().getExtras().getString("roll");
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
				//String data[]= new String[result.getPropertyCount()];
				att =new String[result.getPropertyCount()];
				for(int i =0 ; i<result.getPropertyCount();++i)
				{
					att[i]=result.getProperty(i).toString();
				}
				//((EditText) findViewById (R.id.month)).setText(att[0]);
				  grid = (GridView)findViewById(R.id.grid);
				    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				        android.R.layout.simple_list_item_1, web) {
				    	  @Override
				    	  public View getView(int position, View convertView, ViewGroup parent) {
				    	    View view = super.getView(position, convertView, parent);

				    	    int color = 0x00FFFFFF; // Transparent
				    	    if (mp.toString().equals(att[position *8 +3])) {
				    	    	color = 0xFF800000;  //redcolor
				    	    }
				    	    else if (wo.toString().equals(att[position *8 +1])) {
					    	      color = 0xffffc200; // orange
					    	    }
				    	    else if (h.toString().equals(att[position *8 +1])) {
					    	      color = 0xffffc200; // Orange
					    	    }
				    	    else if (p.toString().equals(att[position *8 +1])) {
				    	    	color = 0xFF111111; //green
					    	    }
				    	    else if (wop.toString().equals(att[position *8 +1])) {
					    	      color = 0xFF300E92; // Orange
					    	    }
				    	  
				    	    else if (cl.toString().equals(att[position *8 +1])) {
					    	      color = 0xAFAFAFAA; // Orange
					    	    }
				    	    view.setBackgroundColor(color);
				    	    return view;
				    	  }
				    	};			    	
				    	//change here att
				    	  grid.setAdapter(adapter);
				    	  int k=1;
						  String rest[] = new String[att.length/8];	
						  for(int i=0;i<att.length/8; i++)
						  {
						  rest[i]=att[i*8];						  
						  }					  
						  grid = (GridView)findViewById(R.id.grid);
						    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
						        android.R.layout.simple_list_item_1, rest) {
						    	  @Override
						    	  public View getView(int position, View convertView, ViewGroup parent) {
						    	    View view = super.getView(position, convertView, parent);

						    	    int color = 0x00FFFFFF; // Transparent
						    	    if (mp.toString().equals(att[position *8 +3])) {
						    	    	color = 0xFF800000;  //redcolor
						    	    }
						    	    else if (wo.toString().equals(att[position *8 +1])) {
							    	      color = 0xffffc200; // orange
							    	    }
						    	    else if (h.toString().equals(att[position *8 +1])) {
							    	      color = 0xffffc200; // Orange
							    	    }

						    	    else if (p.toString().equals(att[position *8 +1])) {
						    	    	color = 0xCC11AA11;//green
							    	    }
						    	    else if (wop.toString().equals(att[position *8 +1])) {
							    	      color = 0xFF300E92; // Orange
							    	    }
						    	    else if (cl.toString().equals(att[position *8 +1])) {
							    	      color = 0xAFAFAFAA; // Orange
							    	    }
						    	    view.setBackgroundColor(color);
						    	    return view;
						    	  }
						    	};
						    	  grid.setAdapter(adapter1);

						    grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						            @Override
						            public void onItemClick(AdapterView<?> parent, View view,
						                                    int position, long id) {
						               // Toast.makeText(empattendance.this, "You Clicked at " + position, Toast.LENGTH_SHORT).show();
						            	((TextView) findViewById (R.id.status1)).setText("\t\t\t\t"+ "Status: "+att[position * 8 + 1]);
							            
						            	((TextView) findViewById (R.id.at1)).setText("In Time : "+att[position * 8 + 2]+"\t\t\t"+"Out Time:"+att[position * 8  +3]);
						            	((TextView) findViewById (R.id.duration1)).setText("Duration :"+att[position * 8 +4]);		
						            	((TextView) findViewById (R.id.at2)).setText("Late In :"+att[position * 8 +5]+"\t\t\t"+"Early Out :"+att[position *8 +6]);						            	
						            	SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
						            //	Date d = new Date(att[position * 8]);
						            	//String day1= sdf.format(d);
						            ((TextView) findViewById (R.id.ath)).setText("\t Selected Date :"+att[position * 8]+" "+monthu+" "+month5);
			
						    			
							     						            
						            }  
						        }); 
			}
	        catch (Exception E) {
				E.printStackTrace();
				Toast t1 =  Toast.makeText(getApplicationContext(), " Attendance Not Found ", Toast.LENGTH_LONG);
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
		  }
		 };		
		 public void attendance(View v)
		    { 
				((TextView) findViewById (R.id.at2)).setText("");
				((TextView) findViewById (R.id.status1)).setText("");
	            
            	((TextView) findViewById (R.id.at1)).setText("");
            	((TextView) findViewById (R.id.duration1)).setText("");
     
				try
				{				 
				  String empid = getIntent().getExtras().getString("roll");
		        	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		        	request.addProperty("empid",empid);
					request.addProperty("m",month6.toString());
					request.addProperty("y",month7.toString());
					request.addProperty("servicekey","thisismycommunicationapp");
					request.addProperty("servicetype","SOFT");
					SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
					envelope.dotNet = true;
					envelope.setOutputSoapObject(request);
					HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
					androidHttpTransport.call(SOAP_ACTION,envelope);
					SoapObject result =(SoapObject) envelope.getResponse();
					//String data[]= new String[result.getPropertyCount()];
					att =new String[result.getPropertyCount()];
					for(int i =0 ; i<result.getPropertyCount();++i)
					{
						att[i]=result.getProperty(i).toString();
					}
					//etn.setText(att[0]);
				/*	for(int i =0 ; i<data.length;++i)
					{
						att[i]=data[i];
					}*/		     
					  grid = (GridView)findViewById(R.id.grid);
					    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					        android.R.layout.simple_list_item_1, web) {
					    	  @Override
					    	  public View getView(int position, View convertView, ViewGroup parent) {
					    	    View view = super.getView(position, convertView, parent);
					    	    int color = 0x00FFFFFF; // Transparent
					    	    if (mp.toString().equals(att[position *8 +3])) {
					    	    	color = 0xFF800000;  //redcolor
					    	    }
					    	    else if (wo.toString().equals(att[position *8 +1])) {
						    	      color = 0xffffc200; // orange
						    	    }
					    	    else if (h.toString().equals(att[position *8 +1])) {
						    	      color = 0xffffc200; // Orange
						    	    }
					    	    else if (wop.toString().equals(att[position *8 +1])) {
						    	      color = 0xFF300E92; // Orange
						    	    }
					    	    else if (p.toString().equals(att[position *8 +1])) {
					    	    	color = 0xCC11AA11; //green
						    	    }
					    	    else if (cl.toString().equals(att[position *8 +1])) {
						    	      color = 0xAFAFAFAA; // Orange
						    	    }
					    	    view.setBackgroundColor(color);
					    	    return view;
					    	  }
					    	};
					    	  grid.setAdapter(adapter);
					    	  int k=1;
							  String rest[] = new String[att.length/8];	
							  for(int i=0;i<att.length/8; i++)
							  {
							  rest[i]=att[i*8];
							 
							  }							  
							  grid = (GridView)findViewById(R.id.grid);
							    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
							        android.R.layout.simple_list_item_1, rest) {
							    	  @Override
							    	  public View getView(int position, View convertView, ViewGroup parent) {
							    	    View view = super.getView(position, convertView, parent);

							    	    int color = 0x00FFFFFF; // Transparent
							    	    if (mp.toString().equals(att[position *8 +3])) {
							    	    	color = 0xFF800000;  //redcolor
							    	    }
							    	    else if (wo.toString().equals(att[position *8 +1])) {
								    	      color = 0xffffc200; // orange
								    	    }
							    	    else if (h.toString().equals(att[position *8 +1])) {
								    	      color = 0xffffc200; // Orange
								    	    }


							    	    else if (p.toString().equals(att[position *8 +1])) {
							    	    	 color = 0xCC11AA11; //green
								    	    }
							    	    else if (wop.toString().equals(att[position *8 +1])) {
								    	      color = 0xFF300E92; // Orange
								    	    }
							    	    else if (cl.toString().equals(att[position *8 +1])) {
								    	      color = 0xAFAFAFAA; // Orange
								    	    }

							    	    view.setBackgroundColor(color);
							    	    return view;
							    	  }
							    	};
							    	  grid.setAdapter(adapter1);

							    
							    grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
							            @Override
							            public void onItemClick(AdapterView<?> parent, View view,
							                                    int position, long id) {
							                // Toast.makeText(empattendance.this, "You Clicked at " + position, Toast.LENGTH_SHORT).show();
							            	((TextView) findViewById (R.id.status1)).setText("\t\t\t"+ "Status: "+att[position * 8 + 1]);
							            	((TextView) findViewById (R.id.duration1)).setText("Duration :"+att[position * 8 +4]);
							            	((TextView) findViewById (R.id.at1)).setText("In Time : "+att[position * 8 + 2]+"\t\t\t"+"Out Time :"+att[position * 8  +3]);
							          
							             	((TextView) findViewById (R.id.at2)).setText("Late In :"+att[position * 8 +5]+"\t\t\t\t"+"Early Out :"+att[position *8 +6]);						            	
									            	
							          
							          
							            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
							            //	Date d = new Date(att[position * 8]);
							            	//String day1= sdf.format(d);
							            	((TextView) findViewById (R.id.ath)).setText("\t Selected Date :"+att[position * 8]+ " "+month3+" "+month7);
		
							    								            }  
							        }); 
				}
		        catch (Exception E) {
					E.printStackTrace();
					Toast t1 =  Toast.makeText(getApplicationContext(), " attendence not updated ", Toast.LENGTH_LONG);
					t1.show();
					}
		    }
		}
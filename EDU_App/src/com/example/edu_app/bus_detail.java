package com.example.edu_app;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class bus_detail extends Activity {
	public final String METHOD_NAME =  "BusFeeStatus"; // our webservice method name
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION = "http://tempuri.org/BusFeeStatus"; // NAMESPACE + method name
	public final String URL = "http://glauniversity.in/Result.asmx";
	
	public final String METHOD_NAME2 =  "DetailsForTest"; // our webservice method name
	public final String SOAP_ACTION2 = "http://tempuri.org/DetailsForTest"; // NAMESPACE + method name
	public final String URL2 = "http://glauniversity.in/myservices.asmx";
	
	
	static final String[] totalheading = new String[] {

        "Name"," Dept","Deg.","Type" ,"  Mob" 
    };
	String urlimg_s,rollno,name,branch,course,mob;
	ImageView imageView_s,t2;
	static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//set the main content layout of the Activity
		setContentView(R.layout.bus_detail);
		
		RelativeLayout one = (RelativeLayout) findViewById(R.id.second);
		one.setVisibility(View.INVISIBLE);
		
			}

	//product barcode mode
	/*public void scanBar(View v) {
		try {
			//start the scanning activity from the com.google.zxing.client.android.SCAN intent
			Intent intent = new Intent(ACTION_SCAN);
			intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
			startActivityForResult(intent, 0);
		} catch (ActivityNotFoundException anfe) {
			//on catch, show the download dialog
			showDialog(bus_detail.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
		}
	}*/
	
	//product qr code mode
	public void scanQR(View v) {
		try {
			//start the scanning activity from the com.google.zxing.client.android.SCAN intent
			Intent intent = new Intent(ACTION_SCAN);
			//intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(intent, 0);
		} catch (ActivityNotFoundException anfe) {
			//on catch, show the download dialog
			showDialog(bus_detail.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
		}
	}

	//alert dialog for downloadDialog
	private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
		AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
		downloadDialog.setTitle(title);
		downloadDialog.setMessage(message);
		downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialogInterface, int i) {
				Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				try {
					act.startActivity(intent);
				} catch (ActivityNotFoundException anfe) {

				}
			}
		});
		downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialogInterface, int i) {
			}
		});
		return downloadDialog.show();
	}

	//on ActivityResult method
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				//get the extras that are returned from the intent
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				
				
				
				call_second(contents);
				
				RelativeLayout one = (RelativeLayout) findViewById(R.id.second);
				one.setVisibility(View.VISIBLE);
				//Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
				//toast.show();
				//((TextView) findViewById (R.id.textView2)).setText(contents);
				
				/*Intent inre = new Intent(bus_detail.this, bus_summary.class);
				inre.putExtra("rollno",contents);
				startActivity(inre);*/	
			}
		}
	}
	
	public void sub(View v)
	{   
		
		final EditText et = (EditText) findViewById(R.id.editText1);
		
		call_second(et.getText().toString());
		//RelativeLayout one = (RelativeLayout) findViewById(R.id.second);
		//one.setVisibility(View.VISIBLE);

		//toast.show();
		/*Intent i=new Intent(this,bus_summary.class );
		i.putExtra("rollno",et.getText().toString());
		startActivity(i);*/
	}
	
	public void call_second(String value )
	{
		 rollno = value; //getIntent().getExtras().getString("rollno");
		/* name = "lalit kumar";
			course = "B.tech.";
			branch ="CS";
			mob = "8273195106";*/   
	         try
				{
		        	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		        	request.addProperty("unirno",rollno.toString());
					request.addProperty("key","@1@");
					
					SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
					envelope.dotNet = true;
					envelope.setOutputSoapObject(request);
					HttpTransportSE androidHttpTransport = new HttpTransportSE(URL2);
					androidHttpTransport.call(SOAP_ACTION2,envelope);
					SoapObject result =(SoapObject) envelope.getResponse();
					String rest[] = new String[result.getPropertyCount()];
					for(int i =0 ; i<result.getPropertyCount();++i)
					{
						rest[i]=result.getProperty(i).toString();
					}
					
					Toast t4 =  Toast.makeText(getApplicationContext(), rest[0].toString(), Toast.LENGTH_LONG);
					t4.show();
					if(rest[0].toString()!="Invalid Roll No.")
					{

					String nam [] = rest[4].toString().split(":");
					String cou [] = rest[2].toString().split(":");
					String bra [] = rest[3].toString().split(":");
					String mo [] = rest[23].toString().split(":");
					
					name = nam[1];
					course = cou[1];
					branch = bra[1];
					mob = mo[1];
					
					 t2 =(ImageView) findViewById(R.id.call1);
					 
					 t2.setOnClickListener(new OnClickListener() {public void onClick(View v) {Intent callIntent = new Intent(Intent.ACTION_CALL);callIntent.setData(Uri.parse("tel:"+mob.toString()));startActivity(callIntent);}});
					 
					 
					
					}
					else
					{
						RelativeLayout one = (RelativeLayout) findViewById(R.id.second);
						one.setVisibility(View.INVISIBLE);
						Toast t41 =  Toast.makeText(getApplicationContext(), " Student not matched from GLA University students contact to Admin ", Toast.LENGTH_LONG);
						   t41.show();
					}
				}
		        catch (Exception E) {
					E.printStackTrace();
					Toast t1 =  Toast.makeText(getApplicationContext(), " Student detail not found, Contact to Admin ", Toast.LENGTH_LONG);
					t1.show();
					}
	         
	         se_grid();

	         //final Button btn1 = (Button) findViewById(R.id.btnSubmit);
	        /* ListView list2 = (ListView) findViewById(R.id.athead);
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
	         list2.setAdapter(arrayAdapter2);*/
	         
	        
	}
	
	public void se_grid()
	{
		 if (android.os.Build.VERSION.SDK_INT > 9) {
	 		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	 		    StrictMode.setThreadPolicy(policy);
	 		}
		 
		 try
			{
			   SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
				request.addProperty("roll",rollno.toString());
				request.addProperty("servicekey","thisismycommunicationapp");
				request.addProperty("servicetype","SOFT");
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelope.dotNet = true;
				envelope.setOutputSoapObject(request);
				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
				androidHttpTransport.call(SOAP_ACTION,envelope);
				Object result = envelope.getResponse();
				System.out.println("Result :" + result.toString());

				String [] parts = result.toString().split(",");

				if(parts[0].toString()!="Invalid")
				{
					RelativeLayout one = (RelativeLayout) findViewById(R.id.second);
					one.setVisibility(View.VISIBLE);
					 urlimg_s = "http://glauniversity.in:8080/Exam_Photos/" +rollno.toString() + ".jpg";
			        imageView_s = (ImageView) findViewById(R.id.nd_drw_s);
			        GetXMLTask task1 = new GetXMLTask();
			    	 task1.execute(new String[] {urlimg_s});
			    	 
			    	((TextView) findViewById (R.id.name)).setText(" Rollno - "+rollno.toString());
			  		((TextView) findViewById (R.id.empcode)).setText(" Name - "+name.toString());
			  		((TextView) findViewById (R.id.deg)).setText(" Course - "+course.toString());
			  		((TextView) findViewById (R.id.bran)).setText(" Branch - "+branch.toString());
			  		((TextView) findViewById (R.id.mobi)).setText(" Mobile - "+mob.toString());
			  		
			  		/*for(int i =0 ; i<result.getPropertyCount();++i)
					{
						rest[i]=result.getProperty(i).toString();
					}*/	
			  		
						    ((TextView) findViewById (R.id.stopage)).setText("Bus Stopage :- "+parts[0].toString());
					  		((TextView) findViewById (R.id.ttfees)).setText("Total Fee :- "+parts[1].toString());
					  		((TextView) findViewById (R.id.deposit)).setText("Fee Deposit :- "+parts[2].toString());
					  		((TextView) findViewById (R.id.balance)).setText("Fee Balance :- "+parts[3].toString());

					// cgp heading
				/*	ListView list = (ListView) findViewById(R.id.gridView2);
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
			         	
			         	String phn = parent.getItemAtPosition(position).toString().substring(6,16);
			         	String phn2 = parent.getItemAtPosition(position).toString();
			         	

							 Intent callIntent = new Intent(Intent.ACTION_CALL);
								callIntent.setData(Uri.parse("tel:"+phn));
								startActivity(callIntent);
			         }
			         });*/
				}
				
				else
				{
					RelativeLayout one = (RelativeLayout) findViewById(R.id.second);
					one.setVisibility(View.INVISIBLE);
					Toast t41 =  Toast.makeText(getApplicationContext(), " Student not matched from GLA University students contact to Admin ", Toast.LENGTH_LONG);
					   t41.show();
				}
				

	   
			}
			catch (Exception E) {
			E.printStackTrace();		
			Toast t4 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
			   t4.show();
			} 

	}

	private class GetXMLTask extends AsyncTask<String, Void, Bitmap> {
	    @Override
	    protected Bitmap doInBackground(String... urls) {
	        Bitmap map = null;
	        for (String url : urls) {
	            map = downloadImage(url);
	        }
	        return map;
	    }

	    // Sets the Bitmap returned by doInBackground
	    @Override
	    protected void onPostExecute(Bitmap result_s) {
	        imageView_s.setImageBitmap(result_s);
	    }

	    // Creates Bitmap from InputStream and returns it
	    private Bitmap downloadImage(String urls) {
	        Bitmap bitmap = null;
	        InputStream stream = null;
	        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
	        bmOptions.inSampleSize = 2;

	        try {
	            stream = getHttpConnection(urls);
	            bitmap = BitmapFactory.
	                    decodeStream(stream, null, bmOptions);
	            stream.close();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        return bitmap;
	    }

	    // Makes HttpURLConnection and returns InputStream
	    private InputStream getHttpConnection(String urlString)
	            throws IOException {
	        InputStream stream = null;
	        URL url = new URL(urlString);
	        URLConnection connection = url.openConnection();

	        try {
	            HttpURLConnection httpConnection = (HttpURLConnection) connection;
	            httpConnection.setRequestMethod("GET");
	            httpConnection.connect();

	            if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	                stream = httpConnection.getInputStream();
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return stream;
	    }

	}

	public void calling(){
	    new AlertDialog.Builder(this)
	           .setMessage("Are you sure you want call?")
	           .setCancelable(false)
	           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	  
	               }
	           })
	           .setNegativeButton("No", null)
	           .show();
	}


	


}
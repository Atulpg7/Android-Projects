package com.example.quize;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NavUtils;
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

public class quiz_main extends Activity implements
TextToSpeech.OnInitListener  {
	public String data;
	 private TextToSpeech textToSpeech;
	public final String METHOD_NAME1 =  "question"; // our webservice method name
	public final String METHOD_NAME =  "storequizresult";
	public final String NAMESPACE = "http://tempuri.org/";
	public final String SOAP_ACTION1 = "http://tempuri.org/question"; // NAMESPACE + method name
	public final String SOAP_ACTION = "http://tempuri.org/storequizresult";
	//public final String URL = "http://aspspider.info/lalitgla/WebService.asmx";
	public final String URL = "http://glauniversity.in/Result.asmx";
	TextView text1;
	 int seconds , minutes;
	 int clickcount=1;
	 int scor = 0;
	 private static final String FORMAT = "%02d:%02d";
	 public String tt12 =null;
	 public String butt1 =null;
	 ImageView imageView;

// String name1=getIntent().getExtras().getString("attname");	
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_main);
      String name1=getIntent().getExtras().getString("attname");
      textToSpeech = new TextToSpeech(this, this);
      String p = String.valueOf(clickcount);
      ((TextView) findViewById (R.id.qus)).setText("Q: "+p.toString());
    	((TextView) findViewById (R.id.name)).setText("Hello!:"+name1.toString());
    	
    	 Button btn1 = (Button) findViewById(R.id.conti);
    	 btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // do you work here
            	
            	Intent i=new Intent(quiz_main.this,selectquiz.class );
            	startActivity(i);
             }
            });

        if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
        called();
        ImageButton b1 = (ImageButton)findViewById(R.id.next);
         b1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
              clickcount=clickcount+1;
              String s = String.valueOf(clickcount);
                  //check how many times clicked and so on 
               
            // Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
             if(s.toString().equals("21")) 
             {
            	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                  	ib1.setVisibility(View.INVISIBLE); 
                  	
                  	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                  	ib2.setVisibility(View.VISIBLE); 	
                  	suquiz(v);
             }
             else
             {
            	 called(); 
          }
          }
      }); 

         Button bt1 = (Button)findViewById(R.id.button13);
         bt1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  String bt1 = "A";
        	//  Toast t3 =  Toast.makeText(getApplicationContext(), "A", Toast.LENGTH_LONG);
   		  // t3.show();
        	  if(butt1.toString().equals("A")) 
        	  { data = "wright answer";
              convertTextToSpeech2(data);
        		  scor=scor+1;
        		  String scor1 = String.valueOf(scor);
        		  ((TextView) findViewById (R.id.deg)).setText("Your Score:"+scor1.toString());
        		  clickcount=clickcount+1;
                  String s = String.valueOf(clickcount);
                      //check how many times clicked and so on 
                  ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
                // Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                 if(s.toString().equals("21")) 
                 {
                	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                      	ib1.setVisibility(View.INVISIBLE); 
                      	
                      	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                      	ib2.setVisibility(View.VISIBLE); 	
                      	suquiz(v);
                 }
                 else
                 {

                	 called(); 
              } 
        	  }

        	  else
        	  {
        		  clickcount=clickcount+1;
                  String s = String.valueOf(clickcount);
                  ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
                 data = "wrong answer";
                 convertTextToSpeech2(data);
                      //check how many times clicked and so on 
                	  
              //   Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                 if(s.toString().equals("21")) 
                 {
                	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                      	ib1.setVisibility(View.INVISIBLE); 
                      	
                      	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                      	ib2.setVisibility(View.VISIBLE); 	
                      	suquiz(v);
                 }
                 else
                 {
 
                	 called(); 
              } 
        	  }
          }
         });
        	
        Button bt2 = (Button)findViewById(R.id.Button01);
         bt2.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        		  if(butt1.toString().equals("B")) 
        	  { data = "wright answer";
              convertTextToSpeech2(data);
        			  scor=scor+1;
        			  String scor1 = String.valueOf(scor);
            		  ((TextView) findViewById (R.id.deg)).setText("Your Score:"+scor1.toString());
            		  clickcount=clickcount+1;
                      String s = String.valueOf(clickcount);
                          //check how many times clicked and so on 
                      ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
                  //   Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                     if(s.toString().equals("21")) 
                     {
                    	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                          	ib1.setVisibility(View.INVISIBLE); 
                          	
                          	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                          	ib2.setVisibility(View.VISIBLE); 	
                          	suquiz(v);
                     }
                     else
                     {
 
                    	 called(); 
                  } 
        	  }
        		  
        		  else
        		  {
        			  clickcount=clickcount+1;
                      String s = String.valueOf(clickcount);
                      ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
                      data = "wrong answer";
                      convertTextToSpeech2(data);
                //     Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                     if(s.toString().equals("21")) 
                     {
                    	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                          	ib1.setVisibility(View.INVISIBLE); 
                          	
                          	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                          	ib2.setVisibility(View.VISIBLE); 	
                          	suquiz(v);
                     }
                     else
                     {
                    	 
                    	 called(); 
                  }
        		  }
          }
         });
         
         Button bt3 = (Button)findViewById(R.id.Button02);
         bt3.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  String bt1 = "C";
        	  if(butt1.toString().equals("C")) 
        	  { data = "wright answer";
              convertTextToSpeech2(data);
        		  scor=scor+1;
        		  String scor1 = String.valueOf(scor);
        		  ((TextView) findViewById (R.id.deg)).setText("Your Score:"+scor1.toString());
        		  clickcount=clickcount+1;
                  String s = String.valueOf(clickcount);
                      //check how many times clicked and so on 
                  ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
               //  Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                 if(s.toString().equals("21")) 
                 {
                	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                      	ib1.setVisibility(View.INVISIBLE); 
                      	
                      	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                      	ib2.setVisibility(View.VISIBLE); 	
                      	suquiz(v);
                 }
                 else
                 {
 
                	 called(); 
              } 
        	  }
        	  else
        	  {
        		  clickcount=clickcount+1;
                  String s = String.valueOf(clickcount);
                  ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
                  data = "wrong answer";
                  convertTextToSpeech2(data);
              //   Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                 if(s.toString().equals("21")) 
                 {
                	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                      	ib1.setVisibility(View.INVISIBLE); 
                      	
                      	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                      	ib2.setVisibility(View.VISIBLE); 	
                      	suquiz(v);
                 }
                 else
                 {
                	 
                	 called(); 
              }
        	  }
          }
         });
         
         Button bt4 = (Button)findViewById(R.id.Button03);
         bt4.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  String bt1 = "D";
        	  if(butt1.toString().equals("D")) 
        	  {
        		  data = "wright answer";
                  convertTextToSpeech2(data);
        		  scor=scor+1;
        		  String scor1 = String.valueOf(scor);
        		  ((TextView) findViewById (R.id.deg)).setText("Your Score:"+scor1.toString());
        		  clickcount=clickcount+1;
                  String s = String.valueOf(clickcount);
                      //check how many times clicked and so on 
                  ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString()); 
               //  Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                 if(s.toString().equals("21")) 
                 {
                	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                      	ib1.setVisibility(View.INVISIBLE); 
                      	
                      	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                      	ib2.setVisibility(View.VISIBLE); 	
                      	suquiz(v);
                 }
                 else
                 { 
                	 called(); 
              } 
        	  }
        	  
        	  else
        	  {
        		  clickcount=clickcount+1;
                  String s = String.valueOf(clickcount);
                  ((TextView) findViewById (R.id.qus)).setText("Q: "+s.toString());
                  data = "wrong answer";
                  convertTextToSpeech2(data);
               //  Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
                 if(s.toString().equals("21")) 
                 {
                	 ImageButton ib1 =(ImageButton) findViewById(R.id.next);
                      	ib1.setVisibility(View.INVISIBLE); 
                      	
                      	ImageButton ib2 =(ImageButton) findViewById(R.id.submit);
                      	ib2.setVisibility(View.VISIBLE); 	
                     	suquiz(v);
                 }
                 else
                 {              	 
                	 called(); 
              }
        	  }
          }
         });
          
       /* new CountDownTimer(1199900, 1000) {

        	 public void onTick(long millisUntilFinished) {
        		 TextView t1 = (TextView) findViewById(R.id.timey);
        	     t1.setText("seconds remaining: " + millisUntilFinished / 1000);
 }

        	 public void onFinish() {
        		 TextView t1 = (TextView) findViewById(R.id.timey);
        	     t1.setText("done!");
        	 }
        	  }.start();  */      
      /*  text1=(TextView)findViewById(R.id.timey);
        new CountDownTimer(16069000, 1000) { // adjust the milli seconds here
            public void onTick(long millisUntilFinished) {

                text1.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
      TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                          TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));              
            }

            public void onFinish() {
                text1.setText("done!");
            }
         }.start();  */
        
        text1=(TextView)findViewById(R.id.timey);
        new CountDownTimer(1199900, 1000) { // adjust the milli seconds here
            public void onTick(long millisUntilFinished) {

                text1.setText("Time remaining: " +String.format(FORMAT,
                    
    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
      TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                          TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));              
            }

            public void onFinish() {
                text1.setText("Quiz Completed!");
            	suquiz(null);
                
             /*   RelativeLayout r1 =(RelativeLayout) findViewById(R.id.rel2);
               	r1.setVisibility(View.VISIBLE);
               	
               // RelativeLayout r2 =(RelativeLayout) findViewById(R.id.relativeLayout1);
            	//r2.setVisibility(View.INVISIBLE);
            	
              	Button b1 =(Button) findViewById(R.id.button13);
              	b1.setVisibility(View.INVISIBLE);
             	Button b2 =(Button) findViewById(R.id.Button01);
              	b2.setVisibility(View.INVISIBLE);
             	Button b3 =(Button) findViewById(R.id.Button02);
              	b3.setVisibility(View.INVISIBLE);
             	Button b4 =(Button) findViewById(R.id.Button03);
              	b4.setVisibility(View.INVISIBLE);
              	TextView t2 =(TextView) findViewById(R.id.TextView01);
              	t2.setVisibility(View.INVISIBLE);
              	EditText ed1 =(EditText) findViewById(R.id.editText);
              	ed1.setVisibility(View.INVISIBLE);              	
            	ImageButton i1 =(ImageButton) findViewById(R.id.next);
              	i1.setVisibility(View.INVISIBLE); */
                
                
            }
         }.start();  
}


@Override
public void onInit(int status) {
 if (status == TextToSpeech.SUCCESS) {
  int result = textToSpeech.setLanguage(Locale.US);
  if (result == TextToSpeech.LANG_MISSING_DATA
    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
   Log.e("error", "This Language is not supported");
  } else {
   convertTextToSpeech();
  }
 } else {
  Log.e("error", "Initilization Failed!");
 }
}

/**
 * Releases the resources used by the TextToSpeech engine. It is good
 * practice for instance to call this method in the onDestroy() method of an
 * Activity so the TextToSpeech engine can be cleanly stopped.
 * 
 * @see Activity#onDestroy()
 */
@Override
public void onDestroy() {
 textToSpeech.shutdown();
}

/**
 * Speaks the string using the specified queuing strategy and speech
 * parameters.
 */

private void convertTextToSpeech() {
 String text = "Welcome to Quiz World";
 textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
}

private void convertTextToSpeech2(String data) {
	 String text = data.toString();
	 textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}


public void called() {

	try
		{	
		String quz=getIntent().getExtras().getString("quiz");
		String s = String.valueOf(clickcount);
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
		request.addProperty("category",s.toString());
		request.addProperty("type", quz.toString());
		request.addProperty("servicekey","thisismycommunicationapp");
		request.addProperty("servicetype","SOFT");
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.call(SOAP_ACTION1,envelope);
		SoapObject result =(SoapObject) envelope.getResponse();
		System.out.println("Result :" + result.toString());
		String rest[] = new String[result.getPropertyCount()];	
	for(int i =0 ; i<result.getPropertyCount();++i)
	{
		rest[i]=result.getProperty(i).toString();
	}
			//song1.release();
			//new String[]
	((Button) findViewById (R.id.button13)).setText(rest[1].toString());
	((Button) findViewById (R.id.Button01)).setText(rest[2].toString());
	((Button) findViewById (R.id.Button02)).setText(rest[3].toString());
	((Button) findViewById (R.id.Button03)).setText(rest[4].toString());
	((EditText) findViewById (R.id.editText)).setText(rest[0].toString());
	((TextView) findViewById (R.id.answe)).setText("Your Score :"+rest[5].toString());
	 tt12 = rest[5].toString();
	butt1=rest[5].toString();	
		}
		catch (Exception E) {
		E.printStackTrace();		
		Toast t3 =  Toast.makeText(getApplicationContext(), " Internet not connecteds ", Toast.LENGTH_LONG);
		   t3.show();
		}   
}

public void suquiz(View v)
{
	try
	{	
		  String scor1 = String.valueOf(scor);
		String rollno1=getIntent().getExtras().getString("roll");
		String quz=getIntent().getExtras().getString("quiz");
	SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME);
	request1.addProperty("rollno",rollno1.toString());
	request1.addProperty("score",scor1.toString());
	request1.addProperty("type", quz.toString());
	request1.addProperty("servicekey","thisismycommunicationapp");
	request1.addProperty("servicetype","SOFT");
	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	envelope.dotNet = true;
	envelope.setOutputSoapObject(request1);
	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	androidHttpTransport.call(SOAP_ACTION,envelope);
	Object result1 =(Object) envelope.getResponse();
	//System.out.println("Result :" + result1.toString());
	String t1 = result1.toString();
	if(t1.toString().equals("Success"))
	{

	     TextView t12 =(TextView) findViewById(R.id.timey);
	     	t12.setVisibility(View.INVISIBLE);
	  
     RelativeLayout r1 =(RelativeLayout) findViewById(R.id.rel2);
    	r1.setVisibility(View.VISIBLE);
    	
    // RelativeLayout r2 =(RelativeLayout) findViewById(R.id.relativeLayout1);
 //	r2.setVisibility(View.INVISIBLE);
 	
   	Button b1 =(Button) findViewById(R.id.button13);
   	b1.setVisibility(View.INVISIBLE);
  	Button b2 =(Button) findViewById(R.id.Button01);
   	b2.setVisibility(View.INVISIBLE);
  	Button b3 =(Button) findViewById(R.id.Button02);
   	b3.setVisibility(View.INVISIBLE);
  	Button b4 =(Button) findViewById(R.id.Button03);
   	b4.setVisibility(View.INVISIBLE);
   	TextView t2 =(TextView) findViewById(R.id.TextView01);
   	t2.setVisibility(View.INVISIBLE);
   	EditText ed1 =(EditText) findViewById(R.id.editText);
   	ed1.setVisibility(View.INVISIBLE);              
 	ImageButton i1 =(ImageButton) findViewById(R.id.next);
   	i1.setVisibility(View.INVISIBLE); 
   	ImageButton i2 =(ImageButton) findViewById(R.id.submit);
   	i2.setVisibility(View.INVISIBLE); 
}
	else
	{
		Toast t3 =  Toast.makeText(getApplicationContext(), "Quiz Not Updated , Contact Web Admin Cell", Toast.LENGTH_LONG);
		   t3.show();	
	}
	}
	catch (Exception E) {
	E.printStackTrace();		
	Toast t3 =  Toast.makeText(getApplicationContext(), "Quiz Not Updated , Contact Web Admin Cell", Toast.LENGTH_LONG);
	   t3.show();
	}  
	 
}

public void onClick(View arg0) {
	// TODO Auto-generated method stub

}



}

package com.example.edu_app;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast; 
import android.app.PendingIntent;   
import android.telephony.SmsManager; 
public class quiz extends Activity {  
	  
   // EditText mobileno,message;  
   // Button sendsms;  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.quiz); 

    } 

    public void start(View v)
    {
    	String name1=getIntent().getExtras().getString("attname");
    	String rollno1=getIntent().getExtras().getString("roll");
    	Intent i=new Intent(this,selectquiz.class);
		  i.putExtra("attname",name1.toString());
		  i.putExtra("roll",rollno1.toString());
		  startActivity(i);
    }
    
    public void showscr(View v)
    {
    	String name1=getIntent().getExtras().getString("attname");
    	String rollno1=getIntent().getExtras().getString("roll");
    	Intent i=new Intent(this,quizscore.class);
		  i.putExtra("attname",name1.toString());
		  i.putExtra("roll",rollno1.toString());
		  startActivity(i);
    }
  
    
}

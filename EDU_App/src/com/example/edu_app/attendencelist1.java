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
public class attendencelist1 extends Activity {
	@SuppressLint("NewApi")
	@Override

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.attendencelist);
			if (android.os.Build.VERSION.SDK_INT > 9) {
			    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			    StrictMode.setThreadPolicy(policy);
			}
        TextView t1 =(TextView) findViewById(R.id.column1);
        TextView t2 =(TextView) findViewById(R.id.column2);
        TextView t3 =(TextView) findViewById(R.id.column3); 
        
        t1.setBackgroundColor(0xFF800000);
        
        t2.setBackgroundColor(0xAFAFAFAA);
        t3.setTextColor(this.getResources().getColor(R.color.orange));

        String content1=t1.getText().toString();
        String content3=t3.getText().toString(); 
        
        Toast t4 =  Toast.makeText(getApplicationContext(), " testing mail only for data", Toast.LENGTH_LONG);
		   t4.show();
		   t1.setVisibility(View.INVISIBLE);
        if(content3.equals("75"))
        {
        	Toast t5 =  Toast.makeText(getApplicationContext(), " Attendence is not updated ", Toast.LENGTH_LONG);
			t5.show();
        	t1.setVisibility(View.INVISIBLE);
        	t2.setVisibility(View.INVISIBLE);
        	t3.setTextColor(this.getResources().getColor(R.color.orange));
        }    
}
}

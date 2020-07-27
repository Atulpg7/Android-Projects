package com.example.gla.bloodbank_rotary;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Calendar;

public class DonateActivity extends AppCompatActivity {


    Spinner rdyspn;
    String array[]={"Ready to donate","Yes","No"};
    TextView ldonate,fdonate,tdonate;
    Button btnready;

    String fromtext="null",totext="null",lasttext="null",ready="null",mobileno2="";

    Calendar ca = Calendar.getInstance();
    int year = ca.get(Calendar.YEAR);
    int month = ca.get(Calendar.MONTH);
    int dayofmonth = ca.get(Calendar.DAY_OF_MONTH);



    public final String METHOD_NAME = "donate"; // our webservice method name
    public final String NAMESPACE = "http://tempuri.org/";
    public final String SOAP_ACTION = "http://tempuri.org/donate"; // NAMESPACE + method name
    public final String URL = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    String task="false";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);


        getSupportActionBar().setTitle("Donate Here");


        rdyspn=findViewById(R.id.rdysp);
        ldonate=findViewById(R.id.lastdonate);
        fdonate=findViewById(R.id.fromdate);
        tdonate=findViewById(R.id.todate);
        btnready=findViewById(R.id.rdydonate);
        progressDialog=new ProgressDialog(DonateActivity.this);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(DonateActivity.this, android.R.layout.simple_list_item_1, array);
        rdyspn.setAdapter(ad);


        //Shared Prefrences
        Shared_Prefrences.preferences=getSharedPreferences("details",Context.MODE_PRIVATE);
        Shared_Prefrences.editor=Shared_Prefrences.preferences.edit();

        mobileno2=Shared_Prefrences.preferences.getString("mobileno","");



        ldonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DonateActivity.this,
                        date, year, month, dayofmonth).show();
            }
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                    ldonate.setText(year + "-" + (month + 1) + "-" + dayofmonth);
                    lasttext=year+"-"+(month+1)+"-"+dayofmonth;
                }
            };
        });

        fdonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DonateActivity.this,
                        date, year, month, dayofmonth).show();
            }
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                    fdonate.setText(year + "-" + (month + 1) + "-" + dayofmonth);
                    fromtext=year+"-"+(month+1)+"-"+dayofmonth;
                }
            };
        });

        tdonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DonateActivity.this,
                        date, year, month, dayofmonth).show();
            }
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                    tdonate.setText(year + "-" + (month + 1) + "-" + dayofmonth);
                    totext=year+"-"+(month+1)+"-"+dayofmonth;
                }
            };
        });


        btnready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ready=rdyspn.getSelectedItem().toString();

                String lasttext2=ldonate.getText().toString();
                String fromtext2=fdonate.getText().toString();
                String totext2=tdonate.getText().toString();


                if (lasttext2.equals(" Select Date"))
                {

                    lasttext=year+"-"+(month+1)+"-"+dayofmonth;
                    // Toast.makeText(DonateActivity.this, "Please select Last Donate Date ?", Toast.LENGTH_SHORT).show();
                }

                if (ready.equals("Ready to donate")||ready.equals("No"))
                {
                    Toast.makeText(DonateActivity.this,
                            "Please select yes if you want to Donate ?",
                            Toast.LENGTH_SHORT).show();
                }
                else if (fromtext2.equals(" From"))
                {
                    Toast.makeText(DonateActivity.this, "Please select From Donate Date ?", Toast.LENGTH_SHORT).show();
                }
                else if (totext2.equals(" To"))
                {
                    Toast.makeText(DonateActivity.this, "Please select To Donate Date ?", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   // Toast.makeText(DonateActivity.this, ""+lasttext, Toast.LENGTH_SHORT).show();
                    new Data_Process_Donate().execute();
                }




            }
        });





    }


    class Data_Process_Donate extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {

            progressDialog.setTitle("Submitting Request");
            progressDialog.setMessage("Please Wait While We Submitting Your Request");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("username",""+mobileno2);
                request.addProperty("mobile",""+mobileno2);
                request.addProperty("readytodonate", ""+ready);
                request.addProperty("lastdonate",""+lasttext);
                request.addProperty("donatefrom", ""+fromtext);
                request.addProperty("donateto ", ""+totext);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                StrictMode.setThreadPolicy(policy);
                androidHttpTransport.call(SOAP_ACTION, envelope);
                Object result = envelope.getResponse();

                if (result.toString().equals("Successfully")) {

                    task="Sucessfully";
                }
                else {
                    task="true";
                }
            } catch (Exception E) {
                E.printStackTrace();

               /* Toast t4 = Toast.makeText(getApplicationContext(), " You Are in Catch ", Toast.LENGTH_LONG);
                t4.show();*/
            }




            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            if (task.equals("true")) {

                task="false";
                Toast.makeText(DonateActivity.this, "Please try again ???", Toast.LENGTH_SHORT).show();

            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(DonateActivity.this, "Please check Your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else
            {
                task="false";
                Toast.makeText(DonateActivity.this, "Request Successfully Registered... Thanks !!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(DonateActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }

}

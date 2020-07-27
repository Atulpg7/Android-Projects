package com.example.gla.bloodbank_rotary;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Calendar;

public class NewCampActivity extends AppCompatActivity {


    EditText campname, campaddress, cperson, cpersonmob;
    TextView starting, closing;
    Calendar ca = Calendar.getInstance();
    int year = ca.get(Calendar.YEAR);
    int month = ca.get(Calendar.MONTH);
    int dayofmonth = ca.get(Calendar.DAY_OF_MONTH);
    Button btnadd;


    String startingtext = "", closingtext = "", cname = "", caddress = "", cpname = "", cpmob = "";


    //Server Setting Data
    public final String METHOD_NAME_SET = "camp"; // our webservice method name
    public final String NAMESPACE_SET = "http://tempuri.org/";
    public final String SOAP_ACTION_SET = "http://tempuri.org/camp"; // NAMESPACE + method name
    public final String URL_SET = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    ProgressDialog progressDialog;
    private String task = "false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_camp);

        getSupportActionBar().setTitle("Add New Camp");

        campname = findViewById(R.id.campname);
        campaddress = findViewById(R.id.campaddress);
        cperson = findViewById(R.id.cpersonname);
        cpersonmob = findViewById(R.id.cpersonmob);
        starting = findViewById(R.id.startingdate);
        closing = findViewById(R.id.closingdate);
        btnadd = findViewById(R.id.btnadd);
        progressDialog = new ProgressDialog(NewCampActivity.this);


        starting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NewCampActivity.this,
                        date, year, month, dayofmonth).show();
            }

            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                    starting.setText(year + "-" + (month + 1) + "-" + dayofmonth);
                    startingtext = year + "-" + (month + 1) + "-" + dayofmonth;
                }
            };
        });


        closing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NewCampActivity.this,
                        date, year, month, dayofmonth).show();
            }

            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                    closing.setText(year + "-" + (month + 1) + "-" + dayofmonth);
                    closingtext = year + "-" + (month + 1) + "-" + dayofmonth;
                }
            };
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cname = campname.getText().toString();
                caddress = campaddress.getText().toString();
                cpname = cperson.getText().toString();
                cpmob = cpersonmob.getText().toString();

                if (cname.equals("") && campaddress.equals("") && cpname.equals("")
                        && cpmob.equals("") && startingtext.equals("") && closingtext.equals("")) {

                    Toast.makeText(NewCampActivity.this, "All Are Required ?", Toast.LENGTH_SHORT).show();

                } else if (cname.equals("")) {
                    campname.setError("Please Enter Camp Name ?");
                    campname.requestFocus();

                } else if (startingtext.equals("")) {
                    Toast.makeText(NewCampActivity.this, "Please Select Starting Date ?", Toast.LENGTH_SHORT).show();
                }
                else if (closingtext.equals("")) {
                    Toast.makeText(NewCampActivity.this, "Please Select Closing Date ?", Toast.LENGTH_SHORT).show();
                }
                else if (caddress.equals("")) {
                    campaddress.setError("Please Enter Camp Address ?");
                    campaddress.requestFocus();

                } else if (cpname.equals("")) {
                    cperson.setError("Please Enter Contact Person Name ?");
                    cperson.requestFocus();

                } else if (cpmob.equals("")) {
                    cpersonmob.setError("Please Enter Contact Person Mobile No ?");
                    cpersonmob.requestFocus();

                } else if (cpmob.length() < 10) {
                    cpersonmob.setError("Please Enter Valid Mobile No ?");
                    cpersonmob.requestFocus();
                } else {
                        new Data_Process_NewCamp().execute();

                }


            }
        });


    }


    class Data_Process_NewCamp extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {


            progressDialog.setTitle("Adding Camp");
            progressDialog.setMessage("Please Wait a Second...");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            try {

                SoapObject request = new SoapObject(NAMESPACE_SET, METHOD_NAME_SET);
                request.addProperty("camp_name", "" + cname);//rollno.toString()
                request.addProperty("start_date", "" + startingtext);//rollno.toString()
                request.addProperty("close_date", "" + closingtext);//t1.toString()
                request.addProperty("address", "" + caddress);
                request.addProperty("contact_person", "" + cpname);
                request.addProperty("mob", "" + cpmob);
                request.addProperty("appkey", "1245");
                request.addProperty("key", "215");

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL_SET);
                StrictMode.setThreadPolicy(policy);
                androidHttpTransport.call(SOAP_ACTION_SET, envelope);
                Object result = envelope.getResponse();


                if (result.toString().equals("Successfully")) {

                    task = "Sucessfully";

                } else {

                    task = "true";
                }
            } catch (Exception E) {
                E.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            if (task.equals("true")) {
                task = "false";
                Toast.makeText(NewCampActivity.this, "Something went wrong try again ? ", Toast.LENGTH_SHORT).show();
            } else if (task.equals("false")) {
                task = "false";
                Toast.makeText(NewCampActivity.this, "Please check your Internet Connection ??", Toast.LENGTH_SHORT).show();
            } else {
                task = "false";
                Toast.makeText(NewCampActivity.this, "Camp Added Successfully ", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
            }

        }
    }
}
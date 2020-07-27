package com.example.gla.bloodbank_rotary;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class register extends AppCompatActivity {


    public final String METHOD_NAME = "Registration"; // our webservice method name
    public final String NAMESPACE = "http://tempuri.org/";
    public final String SOAP_ACTION = "http://tempuri.org/Registration"; // NAMESPACE + method name
    public final String URL = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();



    Spinner spb, spm, sps, spc, spocc, spques, spdistrict;

    String question[] = {"Select Option", "Yet to Donate", "Regular Donar", "On Need Basis", "Not Understand"};
    String occupation[] = {"Occupation*", "Service", "Goverment Job", "Bussiness Men", "Student","Other"};
    String c[] = {"Blood Group*", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    String d[] = {"Gender*", "Male", "Female"};
    String e[];
   // String f[] = {"City*", "Vrindavan", "Sector 18", "Chata", "Kosi", "Chauma", "Sunahri", "Bhagwan Takies","Not present in List"};
    String district[];
    private ProgressDialog progressDialog;



    ArrayList<String> arrayList=new ArrayList<String>();

    private EditText name, email, pass, cpass, mobile, pincode, address, weight, mobileoffice,city;
    TextView dob;
    private Button register;
    String newtext="null";


    String genderspi = "", occupationspi = "", bloodgrpspi = "",
            statespi = "", cityspi = "", questionspi = "", districtspi = "";

    String uname = "null", uemail = "null", upass = "null", ucpass = "null",
            udob = "null", umobile = "null", upincode = "null", uaddress = "null",
            uweight = "null", umobileoffice = "null";
     String task="false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        getSupportActionBar().setTitle("Register Yourself");

        progressDialog = new ProgressDialog(this);

        //EditTexts
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        cpass = (EditText) findViewById(R.id.cpassword);
        dob = findViewById(R.id.dob);
        mobile = (EditText) findViewById(R.id.mobile);
        address = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        weight = findViewById(R.id.weight);
        city=findViewById(R.id.city);
        mobileoffice = findViewById(R.id.mobileoffice);

        //Spinners
        spb = (Spinner) findViewById(R.id.bloodgroupsp);
        spm = (Spinner) findViewById(R.id.malesp);
        sps = (Spinner) findViewById(R.id.statesp);
        spocc = findViewById(R.id.occupation);
        spques = findViewById(R.id.questionsp);
        spdistrict = findViewById(R.id.district);

        //Button
        register = (Button) findViewById(R.id.signup_btn);



        //Shared Prefrences
        Shared_Prefrences.preferences=getSharedPreferences("details",Context.MODE_PRIVATE);
        Shared_Prefrences.editor=Shared_Prefrences.preferences.edit();


        e=getResources().getStringArray(R.array.states);
        district=getResources().getStringArray(R.array.district);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(register.this, android.R.layout.simple_list_item_1, c);
        spb.setAdapter(ad);
        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(register.this, android.R.layout.simple_list_item_1, d);
        spm.setAdapter(ad2);
        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(register.this, android.R.layout.simple_list_item_1, e);
        sps.setAdapter(ad3);
        ArrayAdapter<String> ad5 = new ArrayAdapter<String>(register.this, android.R.layout.simple_list_item_1, question);
        spques.setAdapter(ad5);
        ArrayAdapter<String> ad6 = new ArrayAdapter<String>(register.this, android.R.layout.simple_list_item_1, occupation);
        spocc.setAdapter(ad6);
        ArrayAdapter<String> ad7 = new ArrayAdapter<String>(register.this, android.R.layout.simple_list_item_1, district);
        spdistrict.setAdapter(ad7);



        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar ca = Calendar.getInstance();
                int year = ca.get(Calendar.YEAR);
                int month = ca.get(Calendar.MONTH);
                int dayofmonth = ca.get(Calendar.DAY_OF_MONTH);


                new DatePickerDialog(register.this,
                        date, year, month, dayofmonth).show();

            }


            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

                    dob.setText(year + "-" + (month + 1) + "-" + dayofmonth);

                    newtext=year+"-"+(month+1)+"-"+dayofmonth;


                }
            };
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                genderspi = spm.getSelectedItem().toString();
                occupationspi = spocc.getSelectedItem().toString();
                bloodgrpspi = spb.getSelectedItem().toString();
                statespi = sps.getSelectedItem().toString();
                questionspi = spques.getSelectedItem().toString();
                districtspi = spdistrict.getSelectedItem().toString();


                uname = name.getText().toString();
                udob = dob.getText().toString();
                cityspi = city.getText().toString();
                uemail = email.getText().toString();
                upass = pass.getText().toString();
                ucpass = cpass.getText().toString();
                umobile = mobile.getText().toString();
                upincode = pincode.getText().toString();
                uaddress = address.getText().toString();
                uweight = weight.getText().toString();
                umobileoffice = mobileoffice.getText().toString();


                if (uname.isEmpty() && uemail.isEmpty() && upass.isEmpty() && ucpass.isEmpty() && umobile.isEmpty()
                        && udob.equals("DOB*") && upincode.isEmpty()) {
                    Toast.makeText(register.this, "All Are Required", Toast.LENGTH_SHORT).show();


                }
                if (uname.isEmpty()) {

                    name.setError("Name Required");
                    name.requestFocus();

                } else if (udob.equals("DOB*")) {
                    dob.setError("Dob Required");
                    dob.requestFocus();
                }
                else if (newtext.equals("null")) {
                    Toast.makeText(register.this, "Please Select Date Of Birth ?", Toast.LENGTH_SHORT).show();

                }
                else if (genderspi.equals("Gender*")) {
                    Toast.makeText(register.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                } else if (occupationspi.equals("Occupation*")) {
                    Toast.makeText(register.this, "Please Select Occupation", Toast.LENGTH_SHORT).show();
                } else if (bloodgrpspi.equals("Blood Group*")) {
                    Toast.makeText(register.this, "Please Select Blood Group", Toast.LENGTH_SHORT).show();
                } else if (umobile.isEmpty()) {
                    mobile.setError("Mobile No Required");
                    mobile.requestFocus();
                }
                else if (umobile.length()<10)
                {
                    mobile.setError("Please Enter Valid Mobile No ?");
                    mobile.requestFocus();

                }
/*                else if (umobileoffice.length()>15)
                {
                    mobileoffice.setError("Please Enter Valid Mobile No ?");
                    mobileoffice.requestFocus();

                }*//* else if (uemail.isEmpty()) {
                    email.setError("Email Required");
                    email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(uemail).matches()) {
                    email.setError("Please Enter Valid Email");
                    email.requestFocus();
                }*/ else if (statespi.equals("State*")) {
                    Toast.makeText(register.this, "Please Select State", Toast.LENGTH_SHORT).show();
                } else if (cityspi.isEmpty()) {
                    city.setError("Please Select City");
                    city.requestFocus();
                } else if (districtspi.equals("District*")) {
                    Toast.makeText(register.this, "Please Select District", Toast.LENGTH_SHORT).show();
                } else if (uaddress.equals("")) {
                    address.setError("Address Required");
                    address.requestFocus();
                } else if (upincode.isEmpty()) {
                    pincode.setError("Pincode Required");
                    pincode.requestFocus();
                } else if (upincode.length() < 6 || upincode.length() > 6) {
                    pincode.setError("Please Select Valid Pincode");
                    pincode.requestFocus();
                } else if (upass.isEmpty()) {
                    pass.setError("Password Required");
                    pass.requestFocus();

                } else if (!ucpass.equals(upass)) {
                    cpass.setError("Password Didn't Match");
                    cpass.requestFocus();
                } else {

                    //register_user();

                   new Data_Process_Register().execute();

                }


            }
        });

    }



    class Data_Process_Register extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {

            progressDialog.setTitle("Registering You");
            progressDialog.setMessage("Please Wait While We Registering You");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {



            try {

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("username", umobile);//rollno.toString()
                request.addProperty("password", upass);
                request.addProperty("repet_password", ucpass);
                request.addProperty("name", uname);//t1.toString()
                request.addProperty("dob",""+newtext);
                request.addProperty("blood_group", bloodgrpspi);
                request.addProperty("email", uemail);
                request.addProperty("mob", umobile);
                request.addProperty("office_mob", umobileoffice);
                request.addProperty("state", statespi);
                request.addProperty("distic", districtspi);
                request.addProperty("city", cityspi);
                request.addProperty("address", uaddress);
                request.addProperty("occupation", occupationspi);
                request.addProperty("pincode", upincode);
                request.addProperty("gender", genderspi);
                request.addProperty("weight", uweight);
                request.addProperty("donate_user", questionspi);
                request.addProperty("appkey", "1245");
                request.addProperty("key", "215");

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                StrictMode.setThreadPolicy(policy);
                androidHttpTransport.call(SOAP_ACTION, envelope);
                Object result = envelope.getResponse();


                if (result.toString().equals("Successfully")) {

                    task="Successfully";


                }
                else if ( result.toString().equals("already Registered"))
                {
                    task="already";

                } else {

                    task="true";

                }
            } catch (Exception E) {
                E.printStackTrace();
                Toast t4 = Toast.makeText(getApplicationContext(), " You Are in Catch ", Toast.LENGTH_SHORT);
                t4.show();
            }




            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            if (task.equals("true")) {

                task="false";
                Toast.makeText(register.this, "Please try again ???", Toast.LENGTH_SHORT).show();

            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(register.this, "Please check your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else if (task.equals("already"))
            {

                task="false";
                Toast.makeText(register.this, "You have already Registered please try to Login ?", Toast.LENGTH_LONG).show();

            }
            else
            {
                task="false";
                Toast.makeText(register.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(register.this, login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                // Shared_Prefrences.editor.putString("status_key", "active");
                Shared_Prefrences.editor.putString("name",uname);
                Shared_Prefrences.editor.putString("mobileno",umobile);
                Shared_Prefrences.editor.putString("bloodgroup",bloodgrpspi);
                Shared_Prefrences.editor.commit();
                startActivity(intent);
                finish();
            }

        }
    }

}
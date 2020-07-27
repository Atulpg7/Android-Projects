package com.example.gla.bloodbank_rotary;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity {


    private EditText name,email,pass,cpass,mobile,pincode,address,weight,mobileoffice;
    TextView dob;
    Spinner spb,spm,sps,spd,spocc,spques,spdistrict;
    Button update;


    String genderspi = "", occupationspi = "", bloodgrpspi = "",
            statespi = "", cityspi = "", questionspi = "", districtspi = "";

    String uname = "null", uemail = "null", upass = "null", ucpass = "null",
            udob = "null", umobile = "null", upincode = "null", uaddress = "null",
            uweight = "null", umobileoffice = "null";

     String e[],f[],d[],occupation[],c[],question[];

    private ProgressDialog progressDialog;



     //Server data Getting
    public final String METHOD_NAME_GET = "userdetails"; // our webservice method name
    public final String NAMESPACE_GET = "http://tempuri.org/";
    public final String SOAP_ACTION_GET = "http://tempuri.org/userdetails"; // NAMESPACE + method name
    public final String URL_GET = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    String username,mobileno2,genderserver,occserver,bloodgroupserver,stateserver,districtserver,cityserver,questionserver;

    //Server Setting Data
    public final String METHOD_NAME_SET = "Registration"; // our webservice method name
    public final String NAMESPACE_SET = "http://tempuri.org/";
    public final String SOAP_ACTION_SET = "http://tempuri.org/Registration"; // NAMESPACE + method name
    public final String URL_SET = Shared_Prefrences.URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //EditTexts
        name = (EditText) findViewById(R.id.pname);
        email = (EditText) findViewById(R.id.pemail);
        pass = (EditText) findViewById(R.id.ppassword);
        cpass = (EditText) findViewById(R.id.pcpassword);
        dob =findViewById(R.id.pdob);
        mobile = (EditText) findViewById(R.id.pmobile);
        address=findViewById(R.id.paddress);
        pincode=findViewById(R.id.ppincode);
        weight=findViewById(R.id.pweight);
        mobileoffice=findViewById(R.id.pmobileoffice);
        spdistrict=findViewById(R.id.pdistrict);

        //Spinners
        spb = (Spinner) findViewById(R.id.pbloodgroupsp);
        spm = (Spinner) findViewById(R.id.pmalesp);
        sps = (Spinner) findViewById(R.id.pstatesp);
        spd = (Spinner) findViewById(R.id.pdisticsp);
        spocc=findViewById(R.id.poccupation);
        spques=findViewById(R.id.pquestionsp);

        //Button
        update = (Button) findViewById(R.id.pupdate);


        //Shared Prefrences
        Shared_Prefrences.preferences=getSharedPreferences("details",Context.MODE_PRIVATE);
        Shared_Prefrences.editor=Shared_Prefrences.preferences.edit();

        username=Shared_Prefrences.preferences.getString("name","");
        mobileno2=Shared_Prefrences.preferences.getString("mobileno","");

        //Spinners Arrays
        String question[] = {""+questionserver, "Yet to Donate", "Regular Donar", "On Need Basis", "Not Understand"};
        String occupation[] = {""+occserver, "Service"};
        String c[] = {""+bloodgroupserver, "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        String d[] = {""+genderserver, "Male", "Female"};
        String e[] = {""+stateserver, "UP", "MP", "HR", "RJ", "HP"};
        String f[] = {""+cityserver, "Vrindavan", "Sector 18", "Chata", "Kosi", "Chauma", "Sunahri", "Bhagwan Takies"};
        String district[] = {""+districtserver, "Mathura", "Noida", "Bharatpur", "Palwal", "Ghaziyabad", "Agra", "Delhi"};









        get_data();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genderspi = spm.getSelectedItem().toString();
                occupationspi = spocc.getSelectedItem().toString();
                bloodgrpspi = spb.getSelectedItem().toString();
                statespi = sps.getSelectedItem().toString();
                cityspi = spd.getSelectedItem().toString();
                questionspi = spques.getSelectedItem().toString();
                districtspi = spdistrict.getSelectedItem().toString();


                uname = name.getText().toString();
                udob = dob.getText().toString();
                uemail = email.getText().toString();
                upass = pass.getText().toString();
                ucpass = cpass.getText().toString();
                umobile = mobile.getText().toString();
                upincode = pincode.getText().toString();
                uaddress = address.getText().toString();
                uweight = weight.getText().toString();
                umobileoffice = mobileoffice.getText().toString();


               final ProgressDialog progressDialog=new ProgressDialog(ProfileActivity.this);
                progressDialog.setTitle("Updating Details");
                progressDialog.setMessage("Please Wait Updating Your Details");
                progressDialog.show();


                set_data();


            }
            });



        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Calendar ca = Calendar.getInstance();
                int year = ca.get(Calendar.YEAR);
                int month = ca.get(Calendar.MONTH);
                int dayofmonth = ca.get(Calendar.DAY_OF_MONTH);


                new DatePickerDialog(ProfileActivity.this,
                        date, year, month, dayofmonth).show();

            }


            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

                    dob.setText(year + "-" + (month + 1) + "" + dayofmonth);


                }
            };
        });
    }




    //Getting Data From Server
    private void get_data() {

        try
        {
            SoapObject request = new SoapObject(NAMESPACE_GET, METHOD_NAME_GET);
            request.addProperty("username",""+username);
            request.addProperty("mobileno",""+mobileno2);
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL_GET);
            StrictMode.setThreadPolicy(policy);
            androidHttpTransport.call(SOAP_ACTION_GET,envelope);

            SoapObject result = (SoapObject) envelope.getResponse();

            //Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();

            String rest[]= new String[result.getPropertyCount()];


            for(int i =0 ; i<result.getPropertyCount();++i)
            {
                rest[i]=result.getProperty(i).toString();
            }



            if(rest[0].equals("No"))
            {
                Toast.makeText(getApplicationContext(), "Something Went Wrong Try Again ?", Toast.LENGTH_LONG).show();
            }

            else
            {

                name.setText(""+rest[0]);
                dob.setText(""+rest[1]);
                genderserver=""+rest[2];
                occserver=""+rest[3];
                bloodgroupserver=""+rest[4];
                weight.setText(""+rest[5]);
                mobile.setText(""+rest[6]);
                mobileoffice.setText(""+rest[7]);
                email.setText(""+rest[8]);
                stateserver=""+rest[9];
                districtserver=""+rest[10];
                cityserver=""+rest[11];
                address.setText(""+rest[12]);
                pincode.setText(""+rest[13]);
                pass.setText(""+rest[14]);
                cpass.setText(""+rest[15]);
                questionserver=""+rest[16];

            }
        } catch (Exception E) {
            E.printStackTrace();


        }
    }


    //Uploading Data to the server
    private void set_data() {
        try {

            SoapObject request = new SoapObject(NAMESPACE_SET, METHOD_NAME_SET);
            request.addProperty("username", umobile);//rollno.toString()
            request.addProperty("password", upass);
            request.addProperty("repet_password", ucpass);
            request.addProperty("name", uname);//t1.toString()
            request.addProperty("dob",""+udob);
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
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL_SET);
            StrictMode.setThreadPolicy(policy);
            androidHttpTransport.call(SOAP_ACTION_SET, envelope);
            Object result = envelope.getResponse();


            if (result.toString().equals("Successfully")) {

                progressDialog.dismiss();

                Toast.makeText(ProfileActivity.this, "Data updated Successfully", Toast.LENGTH_SHORT).show();


            } else {

                progressDialog.dismiss();
                Toast.makeText(ProfileActivity.this, "Something went wrong ???", Toast.LENGTH_SHORT).show();

            }
        } catch (Exception E) {
            E.printStackTrace();
            Toast t4 = Toast.makeText(getApplicationContext(), " You Are in Catch ", Toast.LENGTH_SHORT);
            t4.show();
        }
    }



}

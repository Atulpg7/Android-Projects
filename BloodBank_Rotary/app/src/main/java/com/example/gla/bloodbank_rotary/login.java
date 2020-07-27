package com.example.gla.bloodbank_rotary;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Objects;

public class login extends AppCompatActivity {

    private EditText username,pass;
    private Button login,register;
    private FirebaseAuth mAuth;
    private DatabaseReference mUserdatabase;
    TextView forgetpass,addnewcamp;


    String email,password;


    String task="false";



    public final String METHOD_NAME = "Login"; // our webservice method name
    public final String NAMESPACE = "http://tempuri.org/";
    public final String SOAP_ACTION = "http://tempuri.org/Login"; // NAMESPACE + method name
    public final String URL = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    ProgressDialog progressDialog;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getSupportActionBar().setTitle("Welcome To Subros Blood Bank");

        username=(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);
        register=(Button) findViewById(R.id.register2);
        //forgetpass=findViewById(R.id.forgetpass);
        addnewcamp=findViewById(R.id.addnewcamp);
        progressDialog=new ProgressDialog(login.this);


        if (ActivityCompat.checkSelfPermission(login.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(login.this,
                    new String[]{
                            android.Manifest.permission.CALL_PHONE,}, 0);
        }


        addnewcamp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog dialog2=new Dialog(login.this);
                dialog2.setContentView(R.layout.custom_dialog);
                Button btnsubmit=dialog2.findViewById(R.id.btnsubmit);
                final EditText etpassword=dialog2.findViewById(R.id.etpassword);

                dialog2.show();
                
                btnsubmit.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        String password=etpassword.getText().toString();
                        
                        if (password.equals("glausub@1"))
                        {
                            dialog2.dismiss();
                            Intent intent=new Intent(login.this,AdminActivity.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(login.this, "You Are Not Authorized ???", Toast.LENGTH_LONG).show();
                            dialog2.dismiss();
                        }
                        
                    }
                });


            }
        });

       /* forgetpass.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(login.this,ForPassActivity.class);
                startActivity(intent);
            }
        });*/


        //Shared Prefrences
        Shared_Prefrences.preferences=getSharedPreferences("details",Context.MODE_PRIVATE);
        Shared_Prefrences.editor=Shared_Prefrences.preferences.edit();


        String status=Shared_Prefrences.preferences.getString("status_key",null);

        if(Objects.equals(status, "active"))
        {
            Intent intent=new Intent(login.this,MainActivity.class);
            startActivity(intent);
            finish();

        }



        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);


            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 email=username.getText().toString();
                 password=pass.getText().toString();

                if(email.isEmpty() && password.isEmpty())
                {
                    Toast.makeText(login.this,"Please fill your details",Toast.LENGTH_SHORT).show();
                }
                else  if (email.isEmpty())
                {
                    username.setError("Mobile No Required");
                    username.requestFocus();
                }
                else if (email.length()>12)
                {
                    username.setError("Please Enter Valid Mobile No ?");
                    username.requestFocus();

                }
                else if (password.isEmpty())
                {
                    pass.setError("Password Required");
                    pass.requestFocus();
                }
                else
                {

                    new Data_Process_login().execute();
                    

                }



            }
        });

    }


    class Data_Process_login extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {


            progressDialog.setTitle("Logging In");
            progressDialog.setMessage("Please wait while we checking your Credentials...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {



            try
            {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("username",email);
                request.addProperty("password",password);
                request.addProperty("appkey","1245");
                request.addProperty("key","215");
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                StrictMode.setThreadPolicy(policy);
                androidHttpTransport.call(SOAP_ACTION,envelope);
                SoapObject result = (SoapObject) envelope.getResponse();
                String rest[]= new String[result.getPropertyCount()];


                for(int i =0 ; i<result.getPropertyCount();++i)
                {
                    rest[i]=result.getProperty(i).toString();
                }


                if(rest[0].equals("No"))
                {
                    task="true";
                    //progressDialog.dismiss();
                    //Toast.makeText(login.this, "Mobile No or Password is Incorrect ??", Toast.LENGTH_LONG).show();
                }

                else
                {
                    progressDialog.dismiss();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    Shared_Prefrences.editor.putString("status_key","active");
                    Shared_Prefrences.editor.putString("name",rest[0]);
                    Shared_Prefrences.editor.putString("mobileno",rest[1]);
                    Shared_Prefrences.editor.putString("bloodgroup",rest[2]);
                    Shared_Prefrences.editor.commit();
                    startActivity(intent);
                    finish();
                    task="Successful";
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

                task="false";
                Toast.makeText(login.this, "Mobile No or Password is Incorrect ??", Toast.LENGTH_SHORT).show();
            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(login.this, "Please check your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else
            {
                task="false";
                Toast.makeText(login.this, "Login Successfull", Toast.LENGTH_SHORT).show();


            }
            }
    }






    }




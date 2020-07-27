package com.example.atulkumar.dhabiee;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText etuser, etpass, etmobile;
    Button btncreate;
    String username, mobileno, password;


    String jsondata;
    String status;

    String url = "https://atulpg7.000webhostapp.com/setuserdata_signup_dhabiee.php";

    String url2="https://atulpg7.000webhostapp.com/getmobileverification_dhabiee.php";



    String id;
    String name;
    String mobile;


    public static final String TAG_RESULT="result";
    public static final String TAG_MOBILENO="mobileno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();



        Details.preferences = getSharedPreferences("details", Context.MODE_PRIVATE);
        Details.editor = Details.preferences.edit();


        etuser = findViewById(R.id.usersignup);
        etpass = findViewById(R.id.passsignup);
        etmobile = findViewById(R.id.mobilesignup);
        btncreate = findViewById(R.id.btncreateacc);


        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = etuser.getText().toString();
                password = etpass.getText().toString();
                mobileno = etmobile.getText().toString();


                if (check(username, password, mobileno))
                {

                    new Data_Process2().execute();

                }
            }
        });


    }


    //Checking All Details Entered By User
    private boolean check(String name, String password, String mobile) {

        boolean result = false;


        if (name.equals("")) {
            etuser.setError("Please Enter Username :(");
            etuser.requestFocus();
        } else if (mobile.equals("")) {
            etmobile.setError("Please Enter Mobile No :(");
            etmobile.requestFocus();
        } else if (mobile.length() < 10) {
            etmobile.setError("Please Enter Valid Mobile No :(");
            etmobile.requestFocus();
        } else if (password.equals("")) {
            etpass.setError("Please Choose Password :(");
            etpass.requestFocus();
        } else {
            result = true;
        }
        return result;
    }




    //Sending Data To The Server
    class Data_Process extends AsyncTask<String, String, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(SignupActivity.this);
            dialog.setTitle("Reistering You");
            dialog.setMessage("Please wait we are registering you....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();

                parms.add(new BasicNameValuePair("username", username));
                parms.add(new BasicNameValuePair("mobileno", mobileno));
                parms.add(new BasicNameValuePair("password", password));
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(parms));
                httpClient.execute(httpPost);


            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();


            Details.editor.putString("status_key", "active");
            Details.editor.putString("name",name);
            Details.editor.putString("mobileno",mobileno);
            Details.editor.commit();
            Toast.makeText(SignupActivity.this, "You are registered sucessfully :)", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignupActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
            // Toast.makeText(MainActivity.this, "Data Uploaded Sucessfully", Toast.LENGTH_SHORT).show();
        }
    }





    //checking old records
    class Data_Process2 extends AsyncTask<String, String, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(SignupActivity.this);
            dialog.setTitle("Checking Details");
            dialog.setMessage("Please wait while we check you are already Registered or Not ?");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            InputStream inputStream = null;
            String result = null;

            try {

                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("mobileno", mobileno));
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url2);
                httpPost.setEntity(new UrlEncodedFormEntity(parms));
                httpClient.execute(httpPost);
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();

                inputStream = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder builder = new StringBuilder();
                String line = null;


                while ((line = reader.readLine()) != null) {
                    builder.append(line);

                }

                result = builder.toString();


            } catch (Exception e) {

                e.printStackTrace();

            } finally {

                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return result;
        }


        //fir yeh
        @Override
        protected void onPostExecute(String s) {

            jsondata = s;
            showrecord();
            dialog.dismiss();
            super.onPostExecute(s);

        }
    }


    public void showrecord() {

        status = null;

        try {

            JSONObject jsonObject = new JSONObject(jsondata);
            JSONArray people = jsonObject.getJSONArray(TAG_RESULT);

            for (int i = 0; i < people.length(); i++) {

                status = "found";
                JSONObject obj = people.getJSONObject(i);
                mobile = obj.getString(TAG_MOBILENO);

               // Toast.makeText(this, ""+mobile, Toast.LENGTH_LONG).show();
               // Toast.makeText(this, ""+mobileno, Toast.LENGTH_LONG).show();

            }

            //Toast.makeText(this, ""+mobile, Toast.LENGTH_LONG).show();
          // Toast.makeText(this, ""+mobileno, Toast.LENGTH_LONG).show();

           if(mobile==null)
            {


                new Data_Process().execute();

            }

            if (mobile.equals(mobileno))
            {
                final Dialog dialog2=new Dialog(SignupActivity.this);
                dialog2.setContentView(R.layout.custom_dialog_error_signup);

                Button btntrydiffrentno=dialog2.findViewById(R.id.btntrydifferentno);
                Button btnlogiagain=dialog2.findViewById(R.id.btnloginagain);


                btntrydiffrentno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog2.dismiss();
                    }
                });

                btnlogiagain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog2.dismiss();
                        Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                dialog2.show();
            }


        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}





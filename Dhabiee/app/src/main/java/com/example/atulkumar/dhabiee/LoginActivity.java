package com.example.atulkumar.dhabiee;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class LoginActivity extends AppCompatActivity {


    EditText etmobile,etpass;
    Button btnlogin;
    String jsondata;
    String number;
    String password;
    String status;



    String name;
    String mobileno;
    String pass;



    //Variables For Async Data
    String url="https://atulpg7.000webhostapp.com/getuserdata_dhabiee.php";



    public static final String TAG_RESULT="result";
    public static final String TAG_Name="username";
    //public static final String TAG_PASSWORD="password";
    public static final String TAG_MOBILENO="mobileno";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        etmobile=findViewById(R.id.mobilelogin);
        etpass=findViewById(R.id.passlogin);
        btnlogin=findViewById(R.id.btnlogin);

        Details.preferences=getSharedPreferences("details",MODE_PRIVATE);
        Details.editor=Details.preferences.edit();



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number=etmobile.getText().toString();
                password=etpass.getText().toString();

                if(check(number,password)) {
                    //Toast.makeText(LoginActivity.this, "Sucessfull :)", Toast.LENGTH_SHORT).show();

                    new Data_Process().execute();

/*
                    Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                    startActivity(intent);
                    finish();*/


                }


            }
        });








    }



    class Data_Process extends AsyncTask<String,String,String> {

        ProgressDialog dialog;


        //sabse phele chalne ke baad preexecute ko karega
        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setTitle("Loging In");
            dialog.setMessage("Please wait while we checking your Credentials");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... strings) {

            InputStream inputStream=null;
            String result = null;

            try {

                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("mobileno", number));
                parms.add(new BasicNameValuePair("password", password));
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(parms));
                httpClient.execute(httpPost);

                HttpResponse response=httpClient.execute(httpPost);
                HttpEntity entity=response.getEntity();
                inputStream=entity.getContent();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"),8);
                StringBuilder builder=new StringBuilder();
                String line = null;


                while((line=reader.readLine())!=null)
                {
                    builder.append(line);

                }

                result=builder.toString();





            }
            catch (Exception e) {

                e.printStackTrace();

            }

            finally {

                try
                {
                    if (inputStream !=null)
                    {
                        inputStream.close();
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return result;
        }


        //fir yeh
        @Override
        protected void onPostExecute(String s) {

            jsondata=s;
            showrecord();
            dialog.dismiss();
            super.onPostExecute(s);

        }
    }



    public void showrecord()
    {

        status=null;

        try {

            JSONObject jsonObject=new JSONObject(jsondata);
            JSONArray people=jsonObject.getJSONArray(TAG_RESULT);

            for (int i=0;i<people.length();i++)
            {

                status="found";

                JSONObject obj=people.getJSONObject(i);

                name = obj.getString(TAG_Name);
                mobileno = obj.getString(TAG_MOBILENO);

                //Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
               // Toast.makeText(this, ""+mobileno, Toast.LENGTH_SHORT).show();


            }


            if (status==null)
            {

                final Dialog dialog=new Dialog(LoginActivity.this);
                dialog.setContentView(R.layout.custom_dialog_error);

                Button btntryagain=dialog.findViewById(R.id.btntryagain);
                Button btnsignup=dialog.findViewById(R.id.btnsignupagain);


                btntryagain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                    }
                });

                btnsignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                        Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                dialog.show();

            }
            else if (status.equals("found"))
            {
               // View parentLayout = findViewById(android.R.id.content);
               // Snackbar.make(parentLayout, "Login Sucessfull :)", Snackbar.LENGTH_LONG).show();

                Details.editor.putString("status_key","active");
                Details.editor.putString("name",name);
                Details.editor.putString("mobileno",mobileno);
                Details.editor.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
                finish();

            }

            else {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Server Not Responding Try Again ?", Snackbar.LENGTH_LONG).show();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }





    }




    //Verifying Data
    private boolean check(String number,String password) {

        boolean result=false;

        if (number.equals("")) {
            etmobile.setError("Please Enter Mobile No :(");
            etmobile.requestFocus();
        }
        else if(number.length()<10) {
            etmobile.setError("Please Enter Valid Mobile No :(");
            etmobile.requestFocus();
        }
        else if (password.equals("")) {
            etpass.setError("Please Enter Password :(");
            etpass.requestFocus();
        }
        else {

            result = true;

        }

        return result;
    }
}

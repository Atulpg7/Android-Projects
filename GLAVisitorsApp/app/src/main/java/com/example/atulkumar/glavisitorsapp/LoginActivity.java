package com.example.atulkumar.glavisitorsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import java.security.Guard;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Button btn;
    TextInputEditText username,password;
    TextView forgetpass;



    //Server data
    String username2;
    String password2;
    String name;
    String type;
    String role;
    String dept1;
    String dept2;
    String dept3;



    String url="https://atulpg7.000webhostapp.com/V_Login.php";
    public static final String TAG_RESULT="result";
    public static final String TAG_NAME="name";
    public static final String TAG_TYPE="type";
    public static final String TAG_ROLE="role";
    public static final String TAG_DEPT1="dept1";
    public static final String TAG_DEPT2="dept2";
    public static final String TAG_DEPT3="dept3";

    boolean task=false;
    String jsondata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        getSupportActionBar().setTitle("Login Area");


        btn=findViewById(R.id.btnlogin);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        forgetpass=findViewById(R.id.forgetpass);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                username2=username.getText().toString();
                password2=password.getText().toString();

                if (true)//check(username2,password2))
                {

                    new Data_Process().execute();
/*                    Intent intent=new Intent(LoginActivity.this,GuardArea.class);
                    startActivity(intent);
                    finish();*/


                }



            }
        });

    }



    //Validating Data
    class Data_Process extends AsyncTask<String, String, String> {

        ProgressDialog dialog;


        //sabse phele chalne ke baad preexecute ko karega
        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setTitle("Checking Credentials");
            dialog.setMessage("Please Wait....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {


            InputStream inputStream = null;
            String result = null;

            try {

                //Sending name of database
                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("username",username2));
                parms.add(new BasicNameValuePair("password",password2));
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
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


        try {

            JSONObject jsonObject = new JSONObject(jsondata);
            JSONArray people = jsonObject.getJSONArray(TAG_RESULT);


            for (int i = 0; i < people.length(); i++) {


                JSONObject obj = people.getJSONObject(i);

                task = true;

                 name = obj.getString(TAG_NAME);
                 type= obj.getString(TAG_TYPE);
                 role= obj.getString(TAG_ROLE);
                 dept1= obj.getString(TAG_DEPT1);
                 dept2= obj.getString(TAG_DEPT2);
                 dept3= obj.getString(TAG_DEPT3);



            }





            if (type.equals("active")&&role.equals("guard")&&task)
            {

                Intent intent=new Intent(LoginActivity.this,GuardArea.class);
                startActivity(intent);
                task = false;

            }
            else if(type.equals("active")&&task)
            {
                Intent intent=new Intent(LoginActivity.this,MainArea.class);
                startActivity(intent);
                task = false;
            }
            else if (type.equals("inactive"))
            {
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "You are now not a part of GLA University ?? ", Snackbar.LENGTH_LONG).show();
                task = false;
            }
            else {

                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Please Try Again ? ", Snackbar.LENGTH_LONG).show();
                task = false;

            }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }










    //Validating Data
    private boolean check(String username2, String password2) {

        boolean result=false;

        if (username2.equals(""))
        {
            username.setError("Please Enter Username :(");
            username.requestFocus();

        }
        else if (password2.equals(""))
        {
            password.setError("Please Enter Password :(");
            password.requestFocus();
        }
        else
        {
            result=true;
        }


        return result;
    }
}

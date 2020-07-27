package com.example.gla.bloodbank_rotary;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class AllUserActivity extends AppCompatActivity {


    String state="",city="",district="",name="",mobile="",bloodgroup="";

    ListView lv;


    public final String METHOD_NAME = "searchdonner"; // our webservice method name
    public final String NAMESPACE = "http://tempuri.org/";
    public final String SOAP_ACTION = "http://tempuri.org/searchdonner"; // NAMESPACE + method name
    //public final String URL = "http://hostel.glauniversity.in/bloodbank.asmx";
    public final String URL = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();


    ArrayList<String> namesarray=new ArrayList<>();
    ArrayList<String> bloodgrouparray=new ArrayList<>();
    ArrayList<String> lastdonatearray=new ArrayList<>();
    ArrayList<String> emailarray=new ArrayList<>();
    ArrayList<String> statearray=new ArrayList<>();
    ArrayList<String> mobnoarray=new ArrayList<>();
    ArrayList<String> officemobnoarray=new ArrayList<>();
    ArrayList<String> weightarray=new ArrayList<>();
    ArrayList<String> addressarray=new ArrayList<>();
    ArrayList<String> districtarray=new ArrayList<>();

    String task="false";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);

        getSupportActionBar().setTitle("All Users");


        state=getIntent().getStringExtra("state");
        district=getIntent().getStringExtra("district");
        // city=getIntent().getStringExtra("city");
        bloodgroup=getIntent().getStringExtra("bloodgroup");
        name=getIntent().getStringExtra("name");
        mobile=getIntent().getStringExtra("mobile");

        lv=findViewById(R.id.lvresult);
        progressDialog=new ProgressDialog(this);

        //get_data();

        new Data_Process_AllUser().execute();



    }

    class Data_Process_AllUser extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {


            progressDialog.setTitle("Loading Results");
            progressDialog.setMessage("Please Wait While We Loading Results For You...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try
            {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("blood_group","");
                request.addProperty("distic","");
                request.addProperty("city","");
                request.addProperty("state","");
                request.addProperty("mob","");
                request.addProperty("name","");
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
                }

                else
                {
                    for (int i=0;i<rest.length - 1;i+=10)
                    {

                        namesarray.add(rest[i]);
                    }

                    for (int i=1;i<rest.length - 1;i+=10)
                    {

                        bloodgrouparray.add(rest[i]);
                    }
                    for (int i=2;i<rest.length - 1;i+=10) {

                        if (rest[i].equals("10-Oct-2018"))
                        {
                            lastdonatearray.add("NA");
                        } else {
                            lastdonatearray.add(rest[i]);
                        }
                    }
                    for (int i=3;i<rest.length - 1;i+=10)
                    {
                        if (rest[i].equals("anyType{}"))
                        {
                            emailarray.add("NA");
                        }
                        else
                            {
                            emailarray.add(rest[i]);
                        }
                    }
                    for (int i=4;i<rest.length - 1;i+=10)
                    {

                        if (rest[i].equals("anyType{}"))
                        {
                            mobnoarray.add("NA");
                        }
                        else {
                            mobnoarray.add(rest[i]);
                        }
                    }
                    for (int i=5;i<rest.length - 1;i+=10)
                    {

                        if (rest[i].equals("anyType{}"))
                        {
                            officemobnoarray.add("NA");
                        }
                        else {
                            officemobnoarray.add(rest[i]);
                        }
                    }
                    for (int i=6;i<rest.length - 1;i+=10)
                    {

                        weightarray.add(rest[i]);
                    }
                    for (int i=7;i<rest.length - 1;i+=10)
                    {

                        addressarray.add(rest[i]);
                    }
                    for (int i=8;i<rest.length - 1;i+=10)
                    {

                        statearray.add(rest[i]);
                    }
                    for (int i=9;i<rest.length - 0;i+=10)
                    {

                        districtarray.add(rest[i]);
                    }

                    task="Sucessfully";

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
                Toast.makeText(AllUserActivity.this, "No result found ?", Toast.LENGTH_SHORT).show();
            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(AllUserActivity.this, "Please check your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else
            {
                task="false";
                Toast.makeText(AllUserActivity.this, "Result Loaded", Toast.LENGTH_SHORT).show();
                Custom_Adapter_AllUser adapter_admin_listView=new Custom_Adapter_AllUser(AllUserActivity.this,
                        namesarray,bloodgrouparray,
                        lastdonatearray,emailarray,statearray,mobnoarray,
                        officemobnoarray,weightarray,addressarray
                        ,districtarray);
                lv.setAdapter(adapter_admin_listView);
                adapter_admin_listView.notifyDataSetChanged();
            }

        }
    }
}

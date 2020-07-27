package com.example.gla.bloodbank_rotary;

import android.app.ProgressDialog;
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

public class CampActivity extends AppCompatActivity {


    ListView lv;

    ArrayList<String> campid=new ArrayList<>();
    ArrayList<String> campname=new ArrayList<>();
    ArrayList<String> startingdate=new ArrayList<>();
    ArrayList<String> closingdate=new ArrayList<>();
    ArrayList<String> address=new ArrayList<>();
    ArrayList<String> contactname=new ArrayList<>();
    ArrayList<String> contactmob=new ArrayList<>();
    ArrayList<String> contactmobt=new ArrayList<>();



    //Server Data
    public final String METHOD_NAME = "searchcamp"; // our webservice method name
    public final String NAMESPACE = "http://tempuri.org/";
    public final String SOAP_ACTION = "http://tempuri.org/searchcamp"; // NAMESPACE + method name
    public final String URL = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    String task="false";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);

        lv=findViewById(R.id.lvcampresult);
        progressDialog=new ProgressDialog(CampActivity.this);

        new Data_Process_Camp().execute();
        

    }





    class Data_Process_Camp extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {


            progressDialog.setTitle("Loading Camps");
            progressDialog.setMessage("Please Wait While We Loading Camps...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try
            {
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
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
                    for (int i=0;i<rest.length - 1;i+=8)
                    {

                        campid.add(rest[i]);
                    }
                    for (int i=1;i<rest.length - 1;i+=8)
                    {

                        campname.add(rest[i]);
                    }

                    for (int i=2;i<rest.length - 1;i+=8)
                    {

                        startingdate.add(rest[i]);
                    }
                    for (int i=3;i<rest.length - 1;i+=8)
                    {

                        closingdate.add(rest[i]);
                    }
                    for (int i=4;i<rest.length - 1;i+=8)
                    {

                        address.add(rest[i]);
                    }
                    for (int i=5;i<rest.length - 1;i+=8) {

                        contactname.add(rest[i]);
                    }
                    for (int i=6;i<rest.length - 1;i+=8) {

                        contactmob.add(rest[i]);
                    }
                    for (int i=7;i<rest.length - 0;i+=8) {

                        contactmob.add(rest[i]);
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
                Toast.makeText(CampActivity.this, "No Camp available ?", Toast.LENGTH_SHORT).show();
            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(CampActivity.this, "Please check your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else
            {
                task="false";
                Toast.makeText(CampActivity.this, "Camps Loaded Successfully", Toast.LENGTH_SHORT).show();
                Custom_Camp_Info adapter=new Custom_Camp_Info(CampActivity.this,campid,campname,startingdate,closingdate,address,contactname,contactmob);
                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        }
    }

}

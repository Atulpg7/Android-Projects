package com.example.gla.bloodbank_rotary;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class Custom_Camp_Info extends ArrayAdapter {


    ArrayList<String> campid = new ArrayList<String>();
    ArrayList<String> campname = new ArrayList<String>();
    ArrayList<String> startdate = new ArrayList<String>();
    ArrayList<String> closedate = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> contactpname = new ArrayList<String>();
    ArrayList<String> contactpmob = new ArrayList<String>();

    String name2,mobileno2,camphostmob,camphostname;

    Activity activity;
    View v;

    Object result;
    //Server Setting Data
    public final String METHOD_NAME_SET = "intersted_camp"; // our webservice method name
    public final String NAMESPACE_SET = "http://tempuri.org/";
    public final String SOAP_ACTION_SET = "http://tempuri.org/intersted_camp"; // NAMESPACE + method name
    public final String URL_SET = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    String campnamet,campidt;

    private ProgressDialog progressDialog;
    private String task="false";


    public Custom_Camp_Info(Activity activity,ArrayList campid, ArrayList<String> campname,
                                         ArrayList<String> startdate,
                                         ArrayList<String> closedate,
                                         ArrayList<String> address,
                                         ArrayList<String> contactpname,
                                         ArrayList<String> contactpmob){

        super(activity, R.layout.custom_layout, campid);

        this.activity = activity;
        this.campid = campid;
        this.campname = campname;
        this.startdate=startdate;
        this.closedate=closedate;
        this.address=address;
        this.contactpname=contactpname;
        this.contactpmob=contactpmob;





    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = activity.getLayoutInflater();
        v = inflater.inflate(R.layout.custom_camp_info, null);

        final TextView tvcampid = v.findViewById(R.id.campid);
        final TextView tvcampname = v.findViewById(R.id.campname);
        final TextView tvstartdate = v.findViewById(R.id.startingdate);
        final TextView tvclosedate = v.findViewById(R.id.closingdate);
        final TextView tvaddress= v.findViewById(R.id.address);
        final TextView tvcontactp = v.findViewById(R.id.contactperson);
        final TextView tvcontactpmob = v.findViewById(R.id.contactpersonmobileno);
        final Button btn=v.findViewById(R.id.interest);

        tvcampid.setText("Camp Id: "+ campid.get(position));
        tvcampname.setText(""+ campname.get(position));
        tvstartdate.setText(""+ startdate.get(position));
        tvclosedate.setText(""+ closedate.get(position));
        tvaddress.setText(""+ address.get(position));
        tvcontactp.setText(""+ contactpname.get(position));
        tvcontactpmob.setText(""+contactpmob.get(position));


        tvcontactpmob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=contactpmob.get(position);

                if (number.equals("NA"))
                {
                    Toast.makeText(activity, "Number not Available ?", Toast.LENGTH_SHORT).show();
                }
                else {
                    call(number);
                }

            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Shared Prefrences
                Shared_Prefrences.editor=Shared_Prefrences.preferences.edit();
                name2=Shared_Prefrences.preferences.getString("name","");
                mobileno2=Shared_Prefrences.preferences.getString("mobileno","");

                campidt=campid.get(position);
                campnamet=campname.get(position);
                camphostmob=contactpmob.get(position);
                camphostname=contactpname.get(position);



                //Toast.makeText(v.getContext(), "Coming Soon...", Toast.LENGTH_SHORT).show();

                new Data_Process_Camp_Info().execute();


            }
        });

        return v;

    }




    //Uploading Data to the server

    class Data_Process_Camp_Info extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {


            progressDialog=new ProgressDialog(v.getContext());

            progressDialog.setTitle("Submitting Request");
            progressDialog.setMessage("Please wait a second...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {



            try {

                SoapObject request = new SoapObject(NAMESPACE_SET, METHOD_NAME_SET);
                request.addProperty("camp_name", ""+campnamet);
                request.addProperty("camp_id", ""+campidt);
                request.addProperty("contact_person",""+ camphostname);
                request.addProperty("contactper_mob", ""+camphostmob);
                request.addProperty("emp_name",""+name2);
                request.addProperty("emp_mobile", ""+mobileno2);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL_SET);
                StrictMode.setThreadPolicy(policy);
                androidHttpTransport.call(SOAP_ACTION_SET, envelope);

                result = envelope.getResponse();


                if (result.toString().equals("Successfully")) {

                    task="Successfully";

                } else if (result.toString().equals("already submitted"))
                {
                    task="already";
                }
                else {
                    task = "true";

                }
            } catch (Exception E) {
                E.printStackTrace();

                /*Toast t4 = Toast.makeText(v.getContext()," You Are in Catch ", Toast.LENGTH_SHORT);
                t4.show();*/
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            //Toast.makeText(v.getContext(), ""+result, Toast.LENGTH_SHORT).show();


            if (task.equals("true")) {

                task="false";
                Toast.makeText(v.getContext(), "Something went wrong try again ? ", Toast.LENGTH_SHORT).show();
                //Toast.makeText(v.getContext(), "Clicked Laugh Vote", Toast.LENGTH_SHORT).show();
            }
            else if (task.equals("already"))
            {
                task="false";
                Toast.makeText(v.getContext(), "Your request already taken... Thanks !!", Toast.LENGTH_SHORT).show();
            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(v.getContext(), "Please check your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else
            {
                task="false";
                Toast.makeText(v.getContext(), "Thanks for your Interest ", Toast.LENGTH_SHORT).show();
            }

        }
    }


    public void call(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(v.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) { return;        }
        activity.startActivity(intent);
    }


}



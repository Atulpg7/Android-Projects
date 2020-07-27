package com.example.gla.bloodbank_rotary;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class Custom_Active_Camp extends ArrayAdapter{


    ArrayList<String> campid = new ArrayList<String>();
    ArrayList<String> campname = new ArrayList<String>();
    ArrayList<String> startdate = new ArrayList<String>();
    ArrayList<String> closedate = new ArrayList<String>();
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> contactpname = new ArrayList<String>();
    ArrayList<String> contactpmob = new ArrayList<String>();

    String id;
    Activity activity;
    View v;

    Object result;
    Context context;



    //Server Setting Data
    public final String METHOD_NAME= "delete_camp"; // our webservice method name
    public final String NAMESPACE = "http://tempuri.org/";
    public final String SOAP_ACTION = "http://tempuri.org/delete_camp"; // NAMESPACE + method name
    public final String URL = Shared_Prefrences.URL;
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    String task="false";
    ProgressDialog progressDialog;



    public Custom_Active_Camp(Activity activity, ArrayList campid, ArrayList<String> campname,
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
        v = inflater.inflate(R.layout.custom_active_camp, null);

       // final TextView tvedit = v.findViewById(R.id.edit);
       // final TextView tvreview = v.findViewById(R.id.respond);
        final TextView tvdelete = v.findViewById(R.id.delete);

        final TextView tvcampid = v.findViewById(R.id.campid);
        final TextView tvcampname = v.findViewById(R.id.campname);
        final TextView tvstartdate = v.findViewById(R.id.startingdate);
        final TextView tvclosedate = v.findViewById(R.id.closingdate);
        final TextView tvaddress= v.findViewById(R.id.address);
        final TextView tvcontactp = v.findViewById(R.id.contactperson);
        final TextView tvcontactpmob = v.findViewById(R.id.contactpersonmobileno);

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





       /* tvedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=campid.get(position);
                Toast.makeText(activity, "Coming Soon...", Toast.LENGTH_SHORT).show();
            }
        });

        tvreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=campid.get(position);
                Toast.makeText(activity, "Coming Soon...", Toast.LENGTH_SHORT).show();
            }
        });*/

        tvdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id=campid.get(position);

                new Data_Process_Delete_Camp().execute();
            }
        });

        return v;

    }

    public void call(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(v.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) { return;        }
        activity.startActivity(intent);
    }





    class Data_Process_Delete_Camp extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {

            progressDialog=new ProgressDialog(v.getContext());

            progressDialog.setTitle("Submitting Request");
            progressDialog.setMessage("Please Wait While We Submitting Your Request");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("id",""+id);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                StrictMode.setThreadPolicy(policy);
                androidHttpTransport.call(SOAP_ACTION, envelope);
                result = envelope.getResponse();

                if (result.toString().equals("Successfully")) {

                    task="Successfully";
                }
                else {
                    task="true";
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

            //Toast.makeText(v.getContext(), ""+result, Toast.LENGTH_SHORT).show();

            if (task.equals("true")) {

                task="false";
                Toast.makeText(v.getContext(), "Please try again ???", Toast.LENGTH_SHORT).show();

            }
            else if(task.equals("false")){

                task="false";
                Toast.makeText(v.getContext(), "Please check Your Internet Connection ??", Toast.LENGTH_SHORT).show();

            }
            else
            {
                task="false";
                Toast.makeText(v.getContext(), "Camp Deleted Successfully", Toast.LENGTH_SHORT).show();
                Toast.makeText(v.getContext(), "Press Back and Restart the activity to refresh the list...", Toast.LENGTH_LONG).show();


            }

        }
    }





}



package com.example.atulkumar.glavisitorsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.InputStream;
import java.util.ArrayList;

public class GuardArea extends AppCompatActivity {


    TextInputEditText nameet,mobilenoet,addresset,vehiclenoet,noofpersonset;
    Spinner workspinner,districtspinner,searchdetailsspinner,lunchfacilityspinner;

    //Adapters
    ArrayAdapter<String> adwork,addistrict,adsearch,adfood;

    String[] worksarray;
    String[] districtarray;
    String[] searchspinnerarray={"Search Details","Employee","Student"};
    String[] lunchfacilityarray={"Do you want Lunch ?","Yes","No"};
    Button btnsubmit;
    Button clickphoto;
    ImageView image;
    Bitmap bitmap;




    //Values
    String name2;
    String mobileno2;
    String address2;
    String work2;
    String district2;
    String search2;
    String food2;

    boolean task=false;

    //Server Values
//    String url = "https://atulpg7.000webhostapp.com/Set_Visitor_Data.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guard_area);

        getSupportActionBar().setTitle("Welcome: ");


        workspinner=findViewById(R.id.workspinner);
        districtspinner=findViewById(R.id.district);
        searchdetailsspinner=findViewById(R.id.searchdetails);
        lunchfacilityspinner=findViewById(R.id.lunchfacility);
        btnsubmit=findViewById(R.id.btnsubmit);








        nameet=findViewById(R.id.name);
        mobilenoet=findViewById(R.id.mobileno);
        addresset=findViewById(R.id.address);
        vehiclenoet=findViewById(R.id.vehicleno);
        noofpersonset=findViewById(R.id.noofpersons);
        image=findViewById(R.id.image);
        clickphoto=findViewById(R.id.captureimage);

        worksarray=getResources().getStringArray(R.array.work);
        districtarray=getResources().getStringArray(R.array.district);





        //Adapters
        adwork=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,worksarray);
        addistrict=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,districtarray);
        adsearch=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,searchspinnerarray);
        adfood=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lunchfacilityarray);


        workspinner.setAdapter(adwork);
        districtspinner.setAdapter(addistrict);
        searchdetailsspinner.setAdapter(adsearch);
        lunchfacilityspinner.setAdapter(adfood);



        workspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {


               /* if (position==0)
                {
                    linearstaff.setVisibility(View.GONE);
                    linearstudentmeet.setVisibility(View.GONE);
                }
                else if (position==1)
                {
                    linearstaff.setVisibility(View.GONE);
                    linearstudentmeet.setVisibility(View.GONE);
                    linearstaff.setVisibility(View.VISIBLE);

                }

                if (position==2)
                {

                    linearstaff.setVisibility(View.GONE);
                    linearstudentmeet.setVisibility(View.GONE);
                    linearstudentmeet.setVisibility(View.VISIBLE);

                }*/


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





/*
        if (work2.equals("Student Meet")) {

            exlenlayout.setVisibility(View.VISIBLE);

        }

        */

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name2=nameet.getText().toString();
                mobileno2=mobilenoet.getText().toString();
                address2=addresset.getText().toString();
                work2=workspinner.getSelectedItem().toString();
                district2=districtspinner.getSelectedItem().toString();
                search2=searchdetailsspinner.getSelectedItem().toString();
                food2=lunchfacilityspinner.getSelectedItem().toString();


                Toast.makeText(GuardArea.this, ""+work2, Toast.LENGTH_SHORT).show();

                /*if (check(name2,mobileno2,address2,explanation2))
                {
                    if (work2.equals("Select Work"))
                    {
                        Toast.makeText(GuardArea.this, "Please Select Work :(", Toast.LENGTH_SHORT).show();
                    }
                    else if (gate2.equals("Select Gate"))
                    {
                        Toast.makeText(GuardArea.this, "Please Select Gate :(", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        new Data_Process().execute();
                    }


                }*/


               // exlenlayout.setVisibility(View.VISIBLE);


            }
        });



        //Capturing Photo

        clickphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,101);
            }
        });







        //End
    }





    //Sending Value To The Server
/*    class Data_Process extends AsyncTask<String, String, String> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(GuardArea.this);
            dialog.setTitle("Uploading Details");
            dialog.setMessage("Please wait we are sending details....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();

                parms.add(new BasicNameValuePair("username", name2));
                parms.add(new BasicNameValuePair("mobileno", mobileno2));
                parms.add(new BasicNameValuePair("address", address2));
                parms.add(new BasicNameValuePair("work", work2));
                parms.add(new BasicNameValuePair("gate", gate2));
                parms.add(new BasicNameValuePair("explanation", explanation2));
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(parms));
                httpClient.execute(httpPost);

                task=true;

            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();


            View parentLayout = findViewById(android.R.id.content);

            if (task==true) {

                Snackbar.make(parentLayout, "Data Uploaded Sucessfully :)", Snackbar.LENGTH_LONG).show();
                nameet.setText("");
                mobilenoet.setText("");
                addresset.setText("");
                explanationet.setText("");
                nameet.requestFocus();
                workspinner.refreshDrawableState();
                gatespinner.refreshDrawableState();
            }
            else
            {
                Snackbar.make(parentLayout, "Data Not Uploaded  :(", Snackbar.LENGTH_LONG).show();
            }

        }
    }*/





    //Validating Data
    private boolean check(String name, String mobileno, String address,String explanation) {

        boolean result = false;


        if (name.equals("")) {
            nameet.setError("Please Enter Username :(");
            nameet.requestFocus();
        }
        else if (mobileno.equals("")) {
            mobilenoet.setError("Please Enter Mobile No :(");
            mobilenoet.requestFocus();
        } else if (mobileno.length() < 10) {
            mobilenoet.setError("Please Enter Valid Mobile No :(");
            mobilenoet.requestFocus();
        } else if (address.equals("")) {
            addresset.setError("Please Enter Address :(");
            addresset.requestFocus();
        }
        else {
            result = true;
        }
        return result;
    }









    //Setting Image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==101 &&
                resultCode==RESULT_OK &&
                data!=null) {

            Bundle b=data.getExtras();
            bitmap = (Bitmap) b.get("data");
            image.setImageBitmap(bitmap);
        }
        else {
            Toast.makeText(this, "No image clicked or selected", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }










//Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuguard, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id==R.id.oldentries)
        {
            Intent intent=new Intent(GuardArea.this,Old_RecordsActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.logout) {

            Toast.makeText(this, "Guard Logout", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    //Final End
}

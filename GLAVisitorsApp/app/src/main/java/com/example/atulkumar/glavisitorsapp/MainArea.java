package com.example.atulkumar.glavisitorsapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
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
import java.util.ArrayList;
import java.util.Calendar;

public class MainArea extends AppCompatActivity {

    TextView from,to;
    TextInputEditText name,mobileno;
    Spinner workspinner;
    Button btnsearch;
    String[] workarray;
    ListView lv;
    Custom_Adapter_Admin_ListView adapter2;

    Calendar ca=Calendar.getInstance();

    int day=ca.get(Calendar.DATE);//Day_Of_Month
    int month=ca.get(Calendar.MONTH);
    int year=ca.get(Calendar.YEAR);


    //Server Variables
    String name2="null";
    String mobileno2="null";
    String work2="null";
    String from2="null";
    String to2="null";
    public static final String TAG_RESULT="result";
    public static final String TAG_NAME="username";
    public static final String TAG_MOBILENO="mobileno";
    public static final String TAG_ADDRESS="address";
    public static final String TAG_WORK="work";
    public static final String TAG_GATE="gate";

    boolean task=false;

    String url="https://atulpg7.000webhostapp.com/Get_Visitor_Data.php";
    String jsondata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainarea);

        getSupportActionBar().setTitle("Welcome: ");

        from=findViewById(R.id.textviewfrom);
        to=findViewById(R.id.textviewto);
        name=findViewById(R.id.name);
        mobileno=findViewById(R.id.mobileno);
        workspinner=findViewById(R.id.workspinner);
        btnsearch=findViewById(R.id.btnsearch);
        lv=findViewById(R.id.listView);

        workarray=getResources().getStringArray(R.array.work);
        ArrayAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,workarray);

        workspinner.setAdapter(adapter);



        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                new DatePickerDialog(MainArea.this,
                        datefrom,year,month,day).show();

            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DatePickerDialog(MainArea.this,
                        dateto,year,month,day).show();

            }
        });



        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 name2=name.getText().toString();
                 mobileno2=mobileno.getText().toString();
                 work2=workspinner.getSelectedItem().toString();
                 from2=from.getText().toString();

                 if (name2.equals(""))
                 {
                     name2="null";
                 }
                 if (from2.equals(" From"))
                 {
                     from2="null";
                 }
                 to2=to.getText().toString();

                 if (to2.equals(" To"))
                 {
                     to2="null";
                 }
                 if (work2.equals("Work"))
                 {
                     work2="null";
                 }



                Global_Data.username.clear();
                Global_Data.mobileno.clear();
                Global_Data.address.clear();
                Global_Data.work.clear();
                Global_Data.gate.clear();
                new Data_Process().execute();
            }
        });





        //End
    }



//Fetching Details From The Server

    class Data_Process extends AsyncTask<String,String,String> {

        ProgressDialog dialog;


        //sabse phele chalne ke baad preexecute ko karega
        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(MainArea.this);
            dialog.setTitle("Loading Results");
            dialog.setMessage("Please Wait Results Are Loading For You....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            super.onPreExecute();
        }


        //fir yeh jab tak chalega jab tak humara task khatam nhi ho jata uske baad post execut
        @Override
        protected String doInBackground(String... strings) {


            InputStream inputStream=null;
            String result = null;

            try {

                //Sending name of database
                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("username",name2));
                parms.add(new BasicNameValuePair("mobileno",mobileno2));
                parms.add(new BasicNameValuePair("work",work2));
                parms.add(new BasicNameValuePair("from",from2));
                parms.add(new BasicNameValuePair("to",to2));

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





        try {

            JSONObject jsonObject=new JSONObject(jsondata);
            JSONArray people=jsonObject.getJSONArray(TAG_RESULT);


            for (int i=0;i<people.length();i++) {
                JSONObject obj = people.getJSONObject(i);

                task =true;
                String name = obj.getString(TAG_NAME);
                String mobileno = obj.getString(TAG_MOBILENO);
                String address = obj.getString(TAG_ADDRESS);
                String work = obj.getString(TAG_WORK);
                String gate = obj.getString(TAG_GATE);

                    Global_Data.username.add(name);
                    Global_Data.mobileno.add(mobileno);
                    Global_Data.address.add(address);
                    Global_Data.work.add(work);
                    Global_Data.gate.add(gate);


    try {
    adapter2 = new Custom_Adapter_Admin_ListView(this,
            Global_Data.username,
            Global_Data.mobileno, Global_Data.work, Global_Data.gate, Global_Data.address);

    lv.setAdapter(adapter2);
    adapter2.notifyDataSetChanged();
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }


            }

            adapter2.notifyDataSetChanged();

            if (task) {

                adapter2.notifyDataSetChanged();
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "Result Loaded :)", Snackbar.LENGTH_LONG).show();
                task=false;
            }
            else
            {
                adapter2.notifyDataSetChanged();
                View parentLayout = findViewById(android.R.id.content);
                Snackbar.make(parentLayout, "No Record Found :(", Snackbar.LENGTH_LONG).show();
                task=false;

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }





    }











    //Date Picking

    DatePickerDialog.OnDateSetListener datefrom=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

            from.setText(year+"-"+(month+1)+"-"+dayofmonth);
        }
    };
    DatePickerDialog.OnDateSetListener dateto=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

            to.setText(year+"-"+(month+1)+"-"+dayofmonth);
        }
    };







    //Menu

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuadmin, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


         if (id == R.id.logout)
         {

            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
            return true;
         }

        return super.onOptionsItemSelected(item);
    }




    //final End
}

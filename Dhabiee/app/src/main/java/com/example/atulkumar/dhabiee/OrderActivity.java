package com.example.atulkumar.dhabiee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

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

public class OrderActivity extends AppCompatActivity {


    String dhabaname;
    String jsondata;
    TextView tvheading;
    CardView cardfast,cardparathe,cardroti,cardsabji;
    GridLayout gridLayoutorder;


    //Tags

    public static final String TAG_RESULT="result";
    public static final String TAG_ID="id";
    public static final String TAG_FASTFOOD="fastfood";
    public static final String TAG_FASTFOOD_PRICE="fastfood_price";
    public static final String TAG_PARATHE="parathe";
    public static final String TAG_PARATHE_PRICE="parathe_price";
    public static final String TAG_ROTI="roti";
    public static final String TAG_ROTI_PRICE="roti_price";
    public static final String TAG_SABJI="sabji";
    public static final String TAG_SABJI_PRICE="sabji_price";


    String url="https://atulpg7.000webhostapp.com/getdata_meals_dhabiee.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        cardfast=findViewById(R.id.cardfast);
        cardparathe=findViewById(R.id.cardparathe);
        cardroti=findViewById(R.id.cardroti);
        cardsabji=findViewById(R.id.cardsabji);
        tvheading=findViewById(R.id.orderheading);
        gridLayoutorder=findViewById(R.id.gridlayoutorder);



        tvheading.setVisibility(View.INVISIBLE);
        gridLayoutorder.setVisibility(View.INVISIBLE);


        cardfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(OrderActivity.this,FastfoodActivity.class);
                startActivity(intent);
            }
        });


        cardparathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(OrderActivity.this,ParatheActivity.class);
                startActivity(intent);
            }
        });

        cardroti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(OrderActivity.this,RotiActivity.class);
                startActivity(intent);
            }
        });

        cardsabji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(OrderActivity.this,SabjiActivity.class);
                startActivity(intent);
            }
        });


        //Getting Dhaba Name
        Bundle b=getIntent().getExtras();
        dhabaname=b.getString("dhaba_name");
       // Toast.makeText(this, ""+dhabaname, Toast.LENGTH_SHORT).show();



        //getting data from the server as per the dhaba nameselected
        new Data_Process().execute();



    }


    @Override
    public void onBackPressed() {


        Global.fastfoodname.clear();
        Global.fastfoodprice.clear();
        Global.parathename.clear();
        Global.paratheprice.clear();
        Global.rotiname.clear();
        Global.rotiprice.clear();
        Global.sabjiname.clear();
        Global.sabjiprice.clear();
        super.onBackPressed();
    }

    class Data_Process extends AsyncTask<String,String,String> {

        ProgressDialog dialog;


        //sabse phele chalne ke baad preexecute ko karega
        @Override
        protected void onPreExecute() {


            dialog = new ProgressDialog(OrderActivity.this);
            dialog.setTitle("Getting Menu");
            dialog.setMessage("Please Wait Menu's Are Loading For You....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
            super.onPreExecute();
        }


        //fir yeh jab tak chalega jab tak humara task khatam nhi ho jata uske baad post execut
        @Override
        protected String doInBackground(String... strings) {


            //getting result process
           /* DefaultHttpClient httpClientget=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(url);
            httpPost.setHeader("content-type","application/json");
           */
           InputStream inputStream=null;
            String result = null;

            try {

                //Sending name of database
               ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("dhabaname", dhabaname));
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





        try {

            JSONObject jsonObject=new JSONObject(jsondata);
            JSONArray people=jsonObject.getJSONArray(TAG_RESULT);

            // Toast.makeText(GetData.this, ""+people, Toast.LENGTH_SHORT).show();

            for (int i=0;i<people.length();i++)
            {
                JSONObject obj=people.getJSONObject(i);


                String fastfoodname = obj.getString(TAG_FASTFOOD);
                String fastfoodprice = obj.getString(TAG_FASTFOOD_PRICE);
                String parathename = obj.getString(TAG_PARATHE);
                String paratheprice = obj.getString(TAG_PARATHE_PRICE);
                String rotiname = obj.getString(TAG_ROTI);
                String rotiprice = obj.getString(TAG_ROTI_PRICE);
                String sabjiname = obj.getString(TAG_SABJI);
                String sabjiprice = obj.getString(TAG_SABJI_PRICE);


                Global.fastfoodname.add(fastfoodname);
                Global.fastfoodprice.add(+Integer.valueOf(fastfoodprice));
                Global.parathename.add(parathename);
                Global.paratheprice.add(+Integer.valueOf(paratheprice));
                Global.rotiname.add(rotiname);
                Global.rotiprice.add(+Integer.valueOf(rotiprice));
                Global.sabjiname.add(sabjiname);
                Global.sabjiprice.add(+Integer.valueOf(sabjiprice));



                }

            View parentLayout = findViewById(android.R.id.content);
            Snackbar.make(parentLayout, "Menu's Are Loaded Enjoy :)", Snackbar.LENGTH_LONG).show();

           // Toast.makeText(this, ""+Global.fastfoodprice.size(), Toast.LENGTH_SHORT).show();

            tvheading.setVisibility(View.VISIBLE);
            gridLayoutorder.setVisibility(View.VISIBLE);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }





    }






}

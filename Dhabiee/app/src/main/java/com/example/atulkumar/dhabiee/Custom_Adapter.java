package com.example.atulkumar.dhabiee;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class Custom_Adapter extends ArrayAdapter {


    ArrayList<String> name = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    Activity activity;
    String item;
    String priceitem;
    String qty;
    View v;
    String url = "https://atulpg7.000webhostapp.com/setcart_dhabiee.php";
    String url2 = "https://atulpg7.000webhostapp.com/getcart_dhabiee.php";
    Dialog dialog;

    String userid=Details.preferences.getString("mobileno",null);



    public Custom_Adapter(Activity activity, ArrayList<String> name,
                          ArrayList<Integer> price) {

        super(activity, R.layout.custom_layout, name);

        this.activity = activity;
        this.name = name;
        this.price = price;


    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = activity.getLayoutInflater();
        v = inflater.inflate(R.layout.custom_layout, null);

        final TextView tvname = v.findViewById(R.id.title);
        final TextView tvprice = v.findViewById(R.id.price);
        Button btncart = v.findViewById(R.id.cartbtn);


        tvname.setText("" + name.get(position));
        tvprice.setText("" + price.get(position));




        btncart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                item=tvname.getText().toString();
                priceitem= tvprice.getText().toString();


                    dialog = new Dialog(getContext());
                    dialog.setContentView(R.layout.custom_layout_qty);

                    Button submit=dialog.findViewById(R.id.btnsubmit);
                    final EditText quantity=dialog.findViewById(R.id.etquantity);

                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            qty= quantity.getText().toString();

                            Integer qtycheck= Integer.valueOf(quantity.getText().toString());

                            if(qtycheck>200)
                            {

                                quantity.requestFocus();
                                quantity.setError("Quantity should be less than or equal to 200");

                            }

                            else

                                {
                                    dialog.dismiss();
                                    new Data_Process().execute();
                            }

                        }
                    });
                    dialog.setCancelable(false);
                    dialog.show();




                }
        });

                return v;
    }





    class Data_Process extends AsyncTask<String,String,String>
    {
        Dialog dialog2;


        //sabse phele chalne ke baad preexecute ko karega
        @Override
        protected void onPreExecute() {


            dialog2=new Dialog(getContext());
            dialog2.setContentView(R.layout.progress_layout);
            dialog2.setCanceledOnTouchOutside(false);
            dialog2.show();

            super.onPreExecute();
        }



        //fir yeh jab tak chalega jab tak humara task khatam nhi ho jata uske baad post execut
        @Override
        protected String doInBackground(String... strings) {

            //forcumunicating server we need three thing
            //1.url 2.method get or post 3. kya bhejoge

            try {

                ArrayList<NameValuePair> parms = new ArrayList<NameValuePair>();
                parms.add(new BasicNameValuePair("userid",userid));
                parms.add(new BasicNameValuePair("itemname",item));
                parms.add(new BasicNameValuePair("price", priceitem));
                parms.add(new BasicNameValuePair("quantity", qty));

                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpPost httpPost = new HttpPost(url);

                httpPost.setEntity(new UrlEncodedFormEntity(parms));
                httpClient.execute(httpPost);


            }
            catch (Exception e)
            {

            }
            return null;
        }


        //fir yeh
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            dialog2.dismiss();
            Snackbar.make(v, "Added To Cart Sucessfully :)", Snackbar.LENGTH_LONG).show();

        }
    }

}

package com.example.atulkumar.polydepartment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class FormActivity extends AppCompatActivity {


    Spinner spgender, spstate, spdistrict;

    String g[] = {"Gender*", "Male", "Female"};
    String district[];
    String state[];
    ArrayList<String> arrayList=new ArrayList<String>();

    EditText name, stumob, stumobwhat, fathername, fathermob, emailid ,pincode, address, city;
    TextView dob;

    String sname="", sdob="", sgender="",sstumob="", sstumobwhat="", sfathername="", sfathermob="", semailid="" ,sstate="",sdistrict="",spincode="",
            saddress="", scity="" ,scourse="",newtext="DOB";
    int selectedyr;
    Calendar ca = Calendar.getInstance();
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        //spinners
        spgender=findViewById(R.id.gendersp);
        spstate=findViewById(R.id.statesp);
        spdistrict=findViewById(R.id.districtsp);

        //Edittexts
        name=findViewById(R.id.name);
        stumob=findViewById(R.id.mobile);
        stumobwhat=findViewById(R.id.whatsappmobile);
        fathername=findViewById(R.id.fname);
        fathermob=findViewById(R.id.fmobno);
        emailid=findViewById(R.id.emailid);
        city=findViewById(R.id.city);
        pincode=findViewById(R.id.pincode);
        address=findViewById(R.id.address);

        //textview
        dob=findViewById(R.id.dob);

        //Button
        register=findViewById(R.id.registerbtn);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int year = ca.get(Calendar.YEAR);
                int month = ca.get(Calendar.MONTH);
                int dayofmonth = ca.get(Calendar.DAY_OF_MONTH);


                new DatePickerDialog(FormActivity.this,
                        date, year, month, dayofmonth).show();

            }


            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

                    dob.setText(dayofmonth + "-" + (month + 1) + "-" + year);
                    selectedyr=year;
                    newtext=year+"-"+(month+1)+"-"+dayofmonth;


                }
            };
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sname=name.getText().toString();
                sdob=newtext;
                sgender=spgender.getSelectedItem().toString();
                sstumob=stumob.getText().toString();
                sstumobwhat=stumobwhat.getText().toString();
                sfathername=fathername.getText().toString();
                sfathermob=fathermob.getText().toString();
                semailid=emailid.getText().toString();
                sstate=spstate.getSelectedItem().toString();
                sdistrict=spdistrict.getSelectedItem().toString();
                scity=city.getText().toString();
                spincode=pincode.getText().toString();
                saddress=address.getText().toString();
                scourse="Hello";

                int currentyr=ca.get(Calendar.YEAR);
                int requiredyr=currentyr-selectedyr;


/*
                if (requiredyr<15)
                {
                    Toast.makeText(FormActivity.this, "Minimum Age Should Be 15 For Taking Admission "+currentyr, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(FormActivity.this, "Name :" + sname
                            + "\n Dob: " + sdob
                            + "\n Gender: " + sgender
                            + "\n Student Mob: " + sstumob
                            + "\n Student WhatsApp: " + sstumobwhat
                            + "\n Father Name: " + sfathername
                            + "\n Father Mob: " + sfathermob
                            + "\n Email Id: " + semailid
                            + "\n State: " + sstate
                            + "\n District: " + sdistrict
                            + "\n City: " + scity
                            + "\n Pincode: " + spincode
                            + "\n Address: " + saddress
                            + "\n Course: " + scourse, Toast.LENGTH_LONG).show();
                }*/


                    if (sname.isEmpty()) {

                        name.setError("Name Required");
                        name.requestFocus();

                    }
                    else if (newtext.equals("DOB")) {
                        Toast.makeText(FormActivity.this, "Please Select Date Of Birth ?", Toast.LENGTH_SHORT).show();
                    }
                    else if (requiredyr<15)
                    {
                        Toast.makeText(FormActivity.this, "Minimum Age Should Be 15 For Taking Admission ?", Toast.LENGTH_SHORT).show();
                    }
                    else if (sgender.equals("Gender*"))
                    {
                        Toast.makeText(FormActivity.this, "Please Select Gender ?", Toast.LENGTH_SHORT).show();
                    }

                    else if (sstumob.isEmpty()) {

                        stumob.setError("Mobile Number Required");
                        stumob.requestFocus();
                    }
                    else if (sstumob.length()<10)
                    {
                        stumob.setError("Please Enter Valid Mobile No ?");
                        stumob.requestFocus();

                    }
                    else if (sstumobwhat.isEmpty())
                    {
                        stumobwhat.setError("WhatsApp Number Required ");
                        stumobwhat.requestFocus();

                    }
                    else if (sstumobwhat.length()<10)
                    {
                    stumobwhat.setError("Please Enter Valid Mobile No ?");
                    stumobwhat.requestFocus();
                    }

                    else if (sfathername.isEmpty()) {

                        fathername.setError("Father Name Required");
                        fathername.requestFocus();
                    }
                    else if (sfathermob.isEmpty()) {

                        fathermob.setError("Father Mobile No Required");
                        fathermob.requestFocus();
                    }
                    else if (sfathermob.length()<10)
                    {
                        fathermob.setError("Please Enter Valid Mobile No ?");
                        fathermob.requestFocus();

                    }
                    else if (semailid.isEmpty())
                    {
                        emailid.setError("Please Enter Email Id");
                        emailid.requestFocus();
                    }
                    else if (!Patterns.EMAIL_ADDRESS.matcher(semailid).matches())
                    {
                    emailid.setError("Please Enter Valid Email Id");
                    emailid.requestFocus();
                    }
                    else if (sstate.equals("State*"))
                    {
                        Toast.makeText(FormActivity.this, "Please Select State ?", Toast.LENGTH_SHORT).show();
                    }
                    else if (sdistrict.equals("District*"))
                    {
                        Toast.makeText(FormActivity.this, "Please Select District ?", Toast.LENGTH_SHORT).show();
                    }
                    else if (scity.isEmpty()) {

                        city.setError("City Required");
                        city.requestFocus();
                    }
                    else if (spincode.isEmpty()) {

                        pincode.setError("Pincode Required");
                        pincode.requestFocus();
                    }
                    else if (spincode.length() < 6) {
                        pincode.setError("Please Enter Valid Pincode");
                        pincode.requestFocus();
                    }
                    else if (saddress.isEmpty()) {

                        address.setError("Address Required");
                        address.requestFocus();
                    }
                    else {
                        Toast.makeText(FormActivity.this, "All Are Successfull", Toast.LENGTH_SHORT).show();
                    }
                    
                   




            }
        });




        state=getResources().getStringArray(R.array.states);
        district=getResources().getStringArray(R.array.district);



        ArrayAdapter<String> ad = new ArrayAdapter<String>(FormActivity.this, android.R.layout.simple_list_item_1, g);
        spgender.setAdapter(ad);

        ArrayAdapter<String> ad2 = new ArrayAdapter<String>(FormActivity.this, android.R.layout.simple_list_item_1, state);
        spstate.setAdapter(ad2);

        ArrayAdapter<String> ad3 = new ArrayAdapter<String>(FormActivity.this, android.R.layout.simple_list_item_1, district);
        spdistrict.setAdapter(ad3);

    }
}

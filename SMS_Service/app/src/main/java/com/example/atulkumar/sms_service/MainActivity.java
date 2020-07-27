package com.example.atulkumar.sms_service;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {


    EditText et,etno;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);
        btn=findViewById(R.id.btn);
        etno=findViewById(R.id.etmobileno);

        if(ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.SEND_SMS},0);
            return;

        }





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String query=et.getText().toString();
                String number=etno.getText().toString();

                SmsManager smsManager =SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,query,null,null);

                Toast.makeText(MainActivity.this, "SMS Sent Successfull ...!", Toast.LENGTH_SHORT).show();
                
                

            }
        });
    }
}

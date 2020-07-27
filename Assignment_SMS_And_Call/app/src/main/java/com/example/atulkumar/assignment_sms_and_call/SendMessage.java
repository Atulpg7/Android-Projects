package com.example.atulkumar.assignment_sms_and_call;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessage extends AppCompatActivity {

    EditText etquery;
    Button btnsend;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        etquery=findViewById(R.id.etquery);
        btnsend=findViewById(R.id.btnsend);


        Bundle b=getIntent().getExtras();

         number=b.getString("number");




        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(ActivityCompat.checkSelfPermission(SendMessage.this,
                        Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(SendMessage.this,
                            new String[]{Manifest.permission.SEND_SMS},1);
                    return;
                }

                String message= etquery.getText().toString();
                SmsManager sm=SmsManager.getDefault();
                sm.sendTextMessage(number,null,message,null,null);
                Toast.makeText(SendMessage.this, "Message Sent Sucessfull", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SendMessage.this,MainActivity.class);
                finish();
                startActivity(i);



            }
        });



    }
}

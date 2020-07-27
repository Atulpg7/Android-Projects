package com.example.atulkumar.assignment_sms_and_call;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvnumber);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                number = tv.getText().toString();

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom_layout);
                ImageButton btncall = dialog.findViewById(R.id.btncall);
                ImageButton btnmessage = dialog.findViewById(R.id.btnmessage);

                btncall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + number));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                                Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED)
                        {

                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{
                                    Manifest.permission.CALL_PHONE
                                    },0);

                            return;
                        }
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });



                btnmessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        number=tv.getText().toString();

                        Intent intent=new Intent(MainActivity.this,SendMessage.class);
                        intent.putExtra("number",number);
                        finish();
                        startActivity(intent);
                    }
                });
                dialog.show();


            }
        });
    }
}

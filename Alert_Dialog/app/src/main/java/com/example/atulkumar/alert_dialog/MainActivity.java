package com.example.atulkumar.alert_dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnsubmit;
    AlertDialog.Builder ad;

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Start Ho Gayi Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit=findViewById(R.id.btn);
        
        
        

      btnsubmit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              ad= new AlertDialog.Builder(MainActivity.this);
              ad.setTitle("Ghar Jana Hai");
              ad.setMessage("Pakka Jana Hai Ya Nahi....!!!!");
              ad.setIcon(R.mipmap.ic_launcher);
              ad.setPositiveButton("Yes Jana Hai", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {

                      finish();


                  }
              });
              ad.setNegativeButton("No Nahi Jana Hai", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {



                  }
              });
              ad.setNeutralButton("Dont Know", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      
                      
                  }
              });
              ad.setCancelable(false);

              ad.show();
          }
      });
    
    
      
    
    
      
    }
    
}


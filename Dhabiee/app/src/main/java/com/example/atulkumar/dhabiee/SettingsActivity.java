package com.example.atulkumar.dhabiee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText etusername,etmobileno,etpassword;
    Button btnverify,btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //getActionBar().setTitle("Settings");
       // getSupportActionBar().setTitle("Settings");
       // getSupportActionBar().setLogo(R.drawable.ic_menu_manage);


        etusername=findViewById(R.id.etusername);
        etmobileno=findViewById(R.id.etmobile);
        etpassword=findViewById(R.id.etpassword);
        btnverify=findViewById(R.id.btnverify);
        btnupdate=findViewById(R.id.btnupdate);
    }
}

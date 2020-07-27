package com.example.atulkumar.bluetooth_and_wifi;

import android.bluetooth.BluetoothAdapter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    ToggleButton toggleButton;
    Switch switchbtn;

    BluetoothAdapter ba;
    WifiManager wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toggleButton=findViewById(R.id.togglebtn);
        switchbtn=findViewById(R.id.switchbtn);


        ba=BluetoothAdapter.getDefaultAdapter();
        wifi= (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if (b==true)
                {
                    wifi.setWifiEnabled(true);


                }
                else
                {
                    wifi.setWifiEnabled(false);

                }

            }
        });


        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                if (b==true)
                {
                    ba.enable();
                }
                else
                {
                    ba.disable();
                }


            }
        });



    }
}

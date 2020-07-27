package com.subham.ducat.torchapp;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
ToggleButton tb;

    private String cameraId;
    CameraManager obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb= (ToggleButton) findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked==true)
                {
                    lightON();
                }
                else
                {
                        lightOFF();
                }


            }
        });
    }

    public void lightON()
    {
        try {
            obj= (CameraManager) getSystemService(Context.CAMERA_SERVICE);

            cameraId=obj.getCameraIdList()[0];

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                obj.setTorchMode(cameraId,true);
            }
        } catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void lightOFF()
    {
        try {
            obj= (CameraManager)getSystemService(Context.CAMERA_SERVICE);
            cameraId=obj.getCameraIdList()[0];
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                obj.setTorchMode(cameraId,false);
            }
        } catch (Exception e) {
            Toast.makeText(getApplication(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}

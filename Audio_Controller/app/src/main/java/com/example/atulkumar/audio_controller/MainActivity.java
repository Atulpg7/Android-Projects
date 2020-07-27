package com.example.atulkumar.audio_controller;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnplay,btnpause,btnstop;
    MediaPlayer mp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnplay=findViewById(R.id.btnplay);
        btnpause=findViewById(R.id.btnpause);
        btnstop=findViewById(R.id.btnstop);


        mp=MediaPlayer.create(this,R.raw.wada);


        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.start();
                Toast.makeText(MainActivity.this, "Song Started", Toast.LENGTH_SHORT).show();

            }
        });


        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.pause();
                Toast.makeText(MainActivity.this, "Song Paused", Toast.LENGTH_SHORT).show();

            }
        });


        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp.stop();

                mp=MediaPlayer.create(getApplicationContext(),R.raw.wada);
                Toast.makeText(MainActivity.this, "Song Stoped", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

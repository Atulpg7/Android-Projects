package com.example.atulkumar.audio_video_both;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnaudio,btnvideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnaudio=findViewById(R.id.btnaudio);
        btnvideo=findViewById(R.id.btnvideo);



        btnaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Android.provider.mediastore.audio.media.Record_sound_action
                Intent i=new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                startActivity(i);
            }
        });


        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //android.provider.Mediastore.Action_Vidio_
                //
                // Capture
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(i);
            }
        });


    }
}

package com.example.moviesinfo;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {


    //Image view for thumbnail of movie
    ImageView imageView;

    //Play button image view
    ImageView play;

    //Player for playing audio
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Setting toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Getting url of movie's thumbnail
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");


        //Setting thumbnail of movie
        imageView = findViewById(R.id.image);
        Glide.with(this).load(url).into(imageView);


        //Creating audio file
        mediaPlayer = MediaPlayer.create(DetailActivity.this, R.raw.audio);


        //Getting reference of play ImageView and playing audio.
        play = findViewById(R.id.btnplay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Starting media player
                mediaPlayer.start();
                Toast.makeText(DetailActivity.this, "Starting Music :)", Toast.LENGTH_SHORT).show();


                //Setting button to disable to prevent multiple playing's of audio
                play.setEnabled(false);
            }
        });


        //Performing toolbar back button's functionality
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Checking for audio is playing or not is yes then stopping it.
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    Toast.makeText(DetailActivity.this, "Music Stopped :(", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

    }
    //Overriding the onBackPressed function to stop audio.
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //Checking for audio is playing or not is yes then stopping it.
        if(mediaPlayer.isPlaying()){
        Toast.makeText(this, "Music Stopped :(", Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
        }

    }
}

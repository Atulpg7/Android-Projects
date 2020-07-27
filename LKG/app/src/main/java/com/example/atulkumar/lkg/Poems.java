package com.example.atulkumar.lkg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class Poems extends YouTubeBaseActivity {


    YouTubePlayerView Ytp1,Ytp2,Ytp3,Ytp4,Ytp5;
    Button btnp,btnp2,btnp3,btnp4,btnp5;
    YouTubePlayer.OnInitializedListener Il,Il2,Il3,Il4,Il5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);


        btnp=(Button) findViewById(R.id.btnplay);
        Ytp1=(YouTubePlayerView) findViewById(R.id.youtubeplay);
        btnp2=(Button) findViewById(R.id.btnplay2);
        Ytp2=(YouTubePlayerView) findViewById(R.id.youtubeplay2);
        btnp3=(Button) findViewById(R.id.btnplay3);
        Ytp3=(YouTubePlayerView) findViewById(R.id.youtubeplay3);
        btnp4=(Button) findViewById(R.id.btnplay4);
        Ytp4=(YouTubePlayerView) findViewById(R.id.youtubeplay4);
        btnp5=(Button) findViewById(R.id.btnplay5);
        Ytp5=(YouTubePlayerView) findViewById(R.id.youtubeplay5);


        Il=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("yCjJyiqpAuU");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(Poems.this,"Please Try Again",Toast.LENGTH_LONG).show();

            }
        };

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnp.setVisibility(View.GONE);
                btnp2.setVisibility(View.VISIBLE);
                btnp3.setVisibility(View.VISIBLE);
                btnp4.setVisibility(View.VISIBLE);
                btnp5.setVisibility(View.VISIBLE);

                Ytp1.initialize(Youtube.getApiKey(),Il);



            }
        });



        Il2=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("F4tHL8reNCs");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(Poems.this,"Please Try Again",Toast.LENGTH_LONG).show();

            }

        };

        btnp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnp2.setVisibility(View.GONE);
                btnp.setVisibility(View.VISIBLE);
                btnp3.setVisibility(View.VISIBLE);
                btnp4.setVisibility(View.VISIBLE);
                btnp5.setVisibility(View.VISIBLE);

                Ytp2.initialize(Youtube.getApiKey(),Il2);




            }
        });



        Il3=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("SvVrs6jkc_w");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(Poems.this,"Please Try Again",Toast.LENGTH_LONG).show();

            }
        };

        btnp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnp3.setVisibility(View.GONE);
                btnp2.setVisibility(View.VISIBLE);
                btnp.setVisibility(View.VISIBLE);
                btnp4.setVisibility(View.VISIBLE);
                btnp5.setVisibility(View.VISIBLE);

                Ytp3.initialize(Youtube.getApiKey(),Il3);


            }
        });



        Il4=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("Zu6o23Pu0Do");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(Poems.this,"Please Try Again",Toast.LENGTH_LONG).show();

            }
        };

        btnp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnp4.setVisibility(View.GONE);
                btnp2.setVisibility(View.VISIBLE);
                btnp3.setVisibility(View.VISIBLE);
                btnp.setVisibility(View.VISIBLE);
                btnp5.setVisibility(View.VISIBLE);

                Ytp4.initialize(Youtube.getApiKey(),Il4);


            }
        });

        Il5=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo("7X0Q4F--g0s");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Toast.makeText(Poems.this,"Please Try Again",Toast.LENGTH_LONG).show();

            }
        };

        btnp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnp5.setVisibility(View.GONE);
                btnp2.setVisibility(View.VISIBLE);
                btnp3.setVisibility(View.VISIBLE);
                btnp4.setVisibility(View.VISIBLE);
                btnp.setVisibility(View.VISIBLE);

                Ytp5.initialize(Youtube.getApiKey(),Il5);


            }
        });





    }
}

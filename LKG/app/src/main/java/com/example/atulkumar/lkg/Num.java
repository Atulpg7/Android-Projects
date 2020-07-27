package com.example.atulkumar.lkg;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class Num extends AppCompatActivity {

    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9;
    TextView o,t,th,f,fi,s,se,e,ni;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num);

        o= (TextView) findViewById(R.id.tone);
        t = (TextView) findViewById(R.id.ttw);
        th = (TextView) findViewById(R.id.tth);
        f= (TextView) findViewById(R.id.tfo);
        fi = (TextView) findViewById(R.id.tfi);
        s = (TextView) findViewById(R.id.tsi);
        se = (TextView) findViewById(R.id.tse);
        e = (TextView) findViewById(R.id.tei);
        ni = (TextView) findViewById(R.id.tni);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if(status!=TextToSpeech.ERROR)
                {

                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });

        img1= (ImageButton) findViewById(R.id.ione);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=o.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img2= (ImageButton) findViewById(R.id.itw);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=t.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img3= (ImageButton) findViewById(R.id.ith);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=th.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img4= (ImageButton) findViewById(R.id.ifo);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=f.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img5= (ImageButton) findViewById(R.id.ifi);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=fi.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img6= (ImageButton) findViewById(R.id.isi);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=s.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img7= (ImageButton) findViewById(R.id.ise);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=se.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img8= (ImageButton) findViewById(R.id.iei);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=e.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        img9= (ImageButton) findViewById(R.id.ini);
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ab=ni.getText().toString();


                t1.speak(ab,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
    }
}
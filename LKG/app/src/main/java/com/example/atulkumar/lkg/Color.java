package com.example.atulkumar.lkg;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class Color extends AppCompatActivity {

    ImageButton r,g,b,y,p,w,o,gr,bl,pu;
    //TextViews
    TextView r2,g2,b2,y2,p2,w2,o2,gr2,bl2,pu2;
    //Texttospeech
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);


        r2=(TextView) findViewById(R.id.r);
        g2=(TextView) findViewById(R.id.g);
        b2=(TextView) findViewById(R.id.b);
        y2=(TextView) findViewById(R.id.y);
        p2=(TextView) findViewById(R.id.p);
        w2=(TextView) findViewById(R.id.w);
        o2=(TextView) findViewById(R.id.o);
        gr2=(TextView) findViewById(R.id.gr);
        bl2=(TextView) findViewById(R.id.bl);
        pu2=(TextView) findViewById(R.id.pu);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status != TextToSpeech.ERROR) {

                    tts.setLanguage(new Locale("Eng"));
                }
            }
        });

        r = (ImageButton) findViewById(R.id.imgred);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = r2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        g = (ImageButton) findViewById(R.id.imggreen);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = g2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        b = (ImageButton) findViewById(R.id.imgblack);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = b2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        y = (ImageButton) findViewById(R.id.imgyellow);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = y2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        p = (ImageButton) findViewById(R.id.imgpink);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = p2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        w = (ImageButton) findViewById(R.id.imgwhite);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = w2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        o = (ImageButton) findViewById(R.id.imgorange);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = o2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        gr = (ImageButton) findViewById(R.id.imggray);
        gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = gr2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        bl= (ImageButton) findViewById(R.id.imgblue);
        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = bl2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        pu = (ImageButton) findViewById(R.id.imgpurple);
        pu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = pu2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}
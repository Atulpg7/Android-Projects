package com.example.atulkumar.lkg;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class H1 extends AppCompatActivity {

    ImageButton img, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13;
    TextView a, aa, i, ii, u, uu, ri, e, ee, o, oo, an, ah;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h1);

        a = (TextView) findViewById(R.id.txtanar2);
        aa = (TextView) findViewById(R.id.txtaam);
        i = (TextView) findViewById(R.id.txtimli);
        ii = (TextView) findViewById(R.id.txtikh);
        u = (TextView) findViewById(R.id.txtullu);
        uu = (TextView) findViewById(R.id.txtuun);
        ri = (TextView) findViewById(R.id.txtrisi);
        ee = (TextView) findViewById(R.id.txtainak);
        e = (TextView) findViewById(R.id.txtaedi);
        o = (TextView) findViewById(R.id.txtaokhli);
        oo = (TextView) findViewById(R.id.txtaurat);
        an = (TextView) findViewById(R.id.txtangoor);
        ah = (TextView) findViewById(R.id.txtkhali);


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status != TextToSpeech.ERROR) {

                    tts.setLanguage(new Locale("hin"));
                }
            }
        });

        img = (ImageButton) findViewById(R.id.anar);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = a.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img2 = (ImageButton) findViewById(R.id.aa);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = aa.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img3 = (ImageButton) findViewById(R.id.i);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = i.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img4 = (ImageButton) findViewById(R.id.ii);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = ii.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        img5 = (ImageButton) findViewById(R.id.u);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = u.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        img6 = (ImageButton) findViewById(R.id.uu);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = uu.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img7 = (ImageButton) findViewById(R.id.ri);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = ri.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img8 = (ImageButton) findViewById(R.id.ae);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = e.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img9 = (ImageButton) findViewById(R.id.aee);
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = ee.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img10 = (ImageButton) findViewById(R.id.oo);
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = o.getText().toString();


                tts.speak(st, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img11 = (ImageButton) findViewById(R.id.au);
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String at = oo.getText().toString();


                tts.speak(at, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img12 = (ImageButton) findViewById(R.id.ang);
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = an.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        img13= (ImageButton) findViewById(R.id.aha);
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=ah.getText().toString();


                tts.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
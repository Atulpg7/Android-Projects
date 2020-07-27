package com.example.atulkumar.lkg;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class Shapes extends AppCompatActivity {

    TextView ci,re,tr,ov,sq,st,oc,he;
    ImageButton cir,rec,tri,ova,squ,sta,oca,hex;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        cir=(ImageButton) findViewById(R.id.ca);
        rec=(ImageButton) findViewById(R.id.re);
        tri=(ImageButton) findViewById(R.id.tr);
        ova=(ImageButton) findViewById(R.id.ov);
        squ=(ImageButton) findViewById(R.id.sq);
        sta=(ImageButton) findViewById(R.id.st);
        oca=(ImageButton) findViewById(R.id.oc);
        hex=(ImageButton) findViewById(R.id.he);
        ci=(TextView)findViewById(R.id.textView6);
        re=(TextView)findViewById(R.id.textView32);
        tr=(TextView)findViewById(R.id.textView33);
        ov=(TextView)findViewById(R.id.textView34);
        oc=(TextView)findViewById(R.id.textView37);
        sq=(TextView)findViewById(R.id.textView36);
        st=(TextView)findViewById(R.id.textView38);
        he=(TextView)findViewById(R.id.textView35);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if(status!=TextToSpeech.ERROR)
                {

                    t1.setLanguage(Locale.US);
                }
            }
        });


        cir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=ci.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=re.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=tr.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        ova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=ov.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=he.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        squ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=sq.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=st.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        oca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=oc.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });








    }

    public void onpause()
    {
        if(t1!=null)
        {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}
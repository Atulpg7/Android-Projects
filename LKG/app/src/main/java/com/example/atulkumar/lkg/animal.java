package com.example.atulkumar.lkg;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class animal extends AppCompatActivity {



    TextView ca,d,c,h,p,r,t,e,g,b,gor,l,cr,dol,tu,wh,oc,sh;
    ImageButton cam,dog,cat,hor,pig,rat,tig,ele,gi,be,go,lo,cro,dolp,tur,wha,oct,sha;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
//Domestic Aminal
        cam=(ImageButton) findViewById(R.id.ca);
        dog=(ImageButton) findViewById(R.id.dogi);
        cat=(ImageButton) findViewById(R.id.cat);
        hor=(ImageButton) findViewById(R.id.ho);
        pig=(ImageButton) findViewById(R.id.pi);
        rat=(ImageButton) findViewById(R.id.ra);
        ca=(TextView)findViewById(R.id.cam);
        d=(TextView)findViewById(R.id.d);
        c=(TextView)findViewById(R.id.c);
        h=(TextView)findViewById(R.id.h);
        p=(TextView)findViewById(R.id.p);
        r=(TextView)findViewById(R.id.rt);
//Wild Animal
        tig=(ImageButton) findViewById(R.id.ti);
        ele=(ImageButton) findViewById(R.id.ele);
        gi=(ImageButton) findViewById(R.id.gi);
        be=(ImageButton) findViewById(R.id.be);
        go=(ImageButton) findViewById(R.id.go);
        lo=(ImageButton) findViewById(R.id.li);
        t=(TextView)findViewById(R.id.t);
        e=(TextView)findViewById(R.id.e);
        g=(TextView)findViewById(R.id.gr);
        b=(TextView)findViewById(R.id.b);
        gor=(TextView)findViewById(R.id.grr);
        l=(TextView)findViewById(R.id.l);
//Sea Animals

        cro=(ImageButton) findViewById(R.id.cr);
        dolp=(ImageButton) findViewById(R.id.dol);
        tur=(ImageButton) findViewById(R.id.tu);
        wha=(ImageButton) findViewById(R.id.wh);
        oct=(ImageButton) findViewById(R.id.oc);
        sha=(ImageButton) findViewById(R.id.sh);
        cr=(TextView)findViewById(R.id.cro);
        dol=(TextView)findViewById(R.id.dolp);
        tu=(TextView)findViewById(R.id.tur);
        wh=(TextView)findViewById(R.id.w);
        oc=(TextView)findViewById(R.id.o);
        sh=(TextView)findViewById(R.id.s);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if(status!=TextToSpeech.ERROR)
                {

                    t1.setLanguage(Locale.ENGLISH );
                }
            }
        });

//Domestic Animal
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=ca.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=d.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=c.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=h.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=p.getText().toString();

                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        rat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=r.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });



//Wild Animal
        tig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=t.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=e.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        gi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=g.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=b.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=gor.getText().toString();

                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=l.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
//Sea Animals
        cro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=cr.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        dolp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=dol.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        tur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=tu.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        wha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=wh.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=oc.getText().toString();

                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        sha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=sh.getText().toString();


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
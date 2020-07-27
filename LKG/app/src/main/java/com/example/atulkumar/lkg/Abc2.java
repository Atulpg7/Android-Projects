package com.example.atulkumar.lkg;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Abc2 extends AppCompatActivity {

    ImageButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    TextView a2,b2,c2,d2,e2,f2,g2,h2,i2,j2,k2,l2,m2,n2,o2,p2,q2,r2,s2,t2,u2,v2,w2,x2,y2,z2;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);

        a2=(TextView) findViewById(R.id.a);
        b2=(TextView) findViewById(R.id.b);
        c2=(TextView) findViewById(R.id.c);
        d2=(TextView) findViewById(R.id.d);
        e2=(TextView) findViewById(R.id.e);
        f2=(TextView) findViewById(R.id.f);
        g2=(TextView) findViewById(R.id.gr);
        h2=(TextView) findViewById(R.id.h);
        i2=(TextView) findViewById(R.id.i);
        j2=(TextView) findViewById(R.id.j);
        k2=(TextView) findViewById(R.id.k);
        l2=(TextView) findViewById(R.id.l);
        m2=(TextView) findViewById(R.id.m);
        n2=(TextView) findViewById(R.id.n);
        o2=(TextView) findViewById(R.id.o);
        p2=(TextView) findViewById(R.id.p);
        q2=(TextView) findViewById(R.id.q);
        r2=(TextView) findViewById(R.id.r);
        s2=(TextView) findViewById(R.id.s);
        t2=(TextView) findViewById(R.id.t);
        u2=(TextView) findViewById(R.id.u);
        v2=(TextView) findViewById(R.id.v);
        w2=(TextView) findViewById(R.id.w);
        x2=(TextView) findViewById(R.id.x);
        y2=(TextView) findViewById(R.id.y);
        z2=(TextView) findViewById(R.id.z);



        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status != TextToSpeech.ERROR) {

                    tts.setLanguage(new Locale("Eng"));
                }
            }
        });

        a = (ImageButton) findViewById(R.id.imga);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String o = a2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        b = (ImageButton) findViewById(R.id.imgb);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = b2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        c = (ImageButton) findViewById(R.id.imgc);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = c2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        d= (ImageButton) findViewById(R.id.imgd);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = d2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        e = (ImageButton) findViewById(R.id.imge);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = e2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        f = (ImageButton) findViewById(R.id.imgf);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = f2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        g = (ImageButton) findViewById(R.id.imgg);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = g2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        h = (ImageButton) findViewById(R.id.imgh);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = h2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        i = (ImageButton) findViewById(R.id.imgi);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = i2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        j= (ImageButton) findViewById(R.id.imgj);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = j2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        k= (ImageButton) findViewById(R.id.imgk);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = k2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        l= (ImageButton) findViewById(R.id.imgl);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = l2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        m= (ImageButton) findViewById(R.id.imgm);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = m2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        n= (ImageButton) findViewById(R.id.imgn);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = n2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        o= (ImageButton) findViewById(R.id.imgo);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = o2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        p= (ImageButton) findViewById(R.id.imgp);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = p2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        q= (ImageButton) findViewById(R.id.imgq);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = q2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        r= (ImageButton) findViewById(R.id.imgr);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = r2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        s= (ImageButton) findViewById(R.id.imgs);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = s2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        t= (ImageButton) findViewById(R.id.imgt);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = t2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        u= (ImageButton) findViewById(R.id.imgu);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = u2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        v= (ImageButton) findViewById(R.id.imgv);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = v2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        w= (ImageButton) findViewById(R.id.imgw);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = w2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        x= (ImageButton) findViewById(R.id.imgx);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = x2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        y= (ImageButton) findViewById(R.id.imgy);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = y2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        z= (ImageButton) findViewById(R.id.imgz);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = z2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });



    }
}

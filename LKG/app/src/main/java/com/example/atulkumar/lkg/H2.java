package com.example.atulkumar.lkg;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class H2 extends AppCompatActivity {


    //ImageButtons
    ImageButton k,kh,g,gh,d,ch,cha,j,jh,nch,t,th,da,dha,n,ta,tha,daa,dh,na,p,fa,b,bha,m,y,r,l,v,sh,sha,sa,h,chha,tra,gya;
    //TextViews
    TextView k1,kh2,g2,gh2,d2,ch2,cha2,j2,jh2,nch2,t2,th2,da2,dha2,n2,ta2,tha2,daa2,dh2,na2,p2,fa2,b2,bha2,m2,y2,r2,l2,v2,sh2,sha2,sa2,h2,chha2,tra2,gya2;
    //Texttospeech
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h2);

        k1=(TextView) findViewById(R.id.k);
        kh2=(TextView) findViewById(R.id.kh);
        g2=(TextView) findViewById(R.id.gr);
        gh2=(TextView) findViewById(R.id.gh);
        d2=(TextView) findViewById(R.id.dakhali);
        ch2=(TextView) findViewById(R.id.ch);
        cha2=(TextView) findViewById(R.id.cha);
        j2=(TextView) findViewById(R.id.jh);
        jh2=(TextView) findViewById(R.id.jha);
       nch2=(TextView) findViewById(R.id.nchkhali);
        t2= (TextView) findViewById(R.id.t);
        th2=(TextView) findViewById(R.id.th);
        da2=(TextView) findViewById(R.id.dm);
        dha2=(TextView) findViewById(R.id.dha);
        n2=(TextView) findViewById(R.id.nakhali);

        ta2=(TextView) findViewById(R.id.ta);
        tha2=(TextView) findViewById(R.id.tharmas);
        daa2=(TextView) findViewById(R.id.dawat);
        dh2=(TextView) findViewById(R.id.dh);
        na2=(TextView) findViewById(R.id.na);
        p2=(TextView) findViewById(R.id.pt);
        fa2=(TextView) findViewById(R.id.fa);
        b2=(TextView) findViewById(R.id.ba);
        bha2=(TextView) findViewById(R.id.bh);
        m2=(TextView) findViewById(R.id.ma);
        y2=(TextView) findViewById(R.id.yg);
        r2=(TextView) findViewById(R.id.r);
        l2=(TextView) findViewById(R.id.l);
        v2=(TextView) findViewById(R.id.v);
        sh2=(TextView) findViewById(R.id.she);
        sha2=(TextView) findViewById(R.id.sa);
        sa2=(TextView) findViewById(R.id.sp);
        h2=(TextView) findViewById(R.id.hn);
        chha2=(TextView) findViewById(R.id.sh);
        tra2=(TextView) findViewById(R.id.tr);
        gya2=(TextView) findViewById(R.id.gy);


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status != TextToSpeech.ERROR) {

                    tts.setLanguage(new Locale("hin"));
                }
            }
        });

        k = (ImageButton) findViewById(R.id.imga);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = k1.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        kh = (ImageButton) findViewById(R.id.imgb);
        kh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = kh2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        g= (ImageButton) findViewById(R.id.imgc);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =g2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        gh= (ImageButton) findViewById(R.id.imgd);
        gh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = gh2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        d = (ImageButton) findViewById(R.id.imge);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = d2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        ch = (ImageButton) findViewById(R.id.imgf);
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = ch2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        cha = (ImageButton) findViewById(R.id.imgg);
        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = cha2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        j = (ImageButton) findViewById(R.id.imgh);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = j2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        jh = (ImageButton) findViewById(R.id.imgi);
        jh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = jh2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        nch= (ImageButton) findViewById(R.id.imgj);
        nch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = nch2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        t = (ImageButton) findViewById(R.id.imgk);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = t2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        th = (ImageButton) findViewById(R.id.imgl);
        th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = th2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        da = (ImageButton) findViewById(R.id.imgm);
        da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =da2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        dha = (ImageButton) findViewById(R.id.imgn);
        dha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =dha2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        n = (ImageButton) findViewById(R.id.imgo);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =n2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        ta= (ImageButton) findViewById(R.id.imgp);
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =ta2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        tha = (ImageButton) findViewById(R.id.imgq);
        tha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =tha2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        daa = (ImageButton) findViewById(R.id.imgr);
        daa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =daa2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        dh = (ImageButton) findViewById(R.id.imgs);
        dh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =dh2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        na = (ImageButton) findViewById(R.id.imgt);
        na.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =na2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        p = (ImageButton) findViewById(R.id.imgu);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =p2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        fa= (ImageButton) findViewById(R.id.imgv);
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =fa2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        b = (ImageButton) findViewById(R.id.imgw);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =b2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        bha = (ImageButton) findViewById(R.id.imgx);
        bha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =bha2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        m = (ImageButton) findViewById(R.id.imgy);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =m2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        y = (ImageButton) findViewById(R.id.imgz);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =y2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        r = (ImageButton) findViewById(R.id.imgrassi);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =r2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        l = (ImageButton) findViewById(R.id.imglattu);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =l2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        v = (ImageButton) findViewById(R.id.imgvak);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =v2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        sh = (ImageButton) findViewById(R.id.imgsher);
        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =sh2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        sha = (ImageButton) findViewById(R.id.imgshatkon);
        sha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =sha2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

         sa= (ImageButton) findViewById(R.id.imgsapera);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =sa2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        h = (ImageButton) findViewById(R.id.imghans);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =h2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        chha = (ImageButton) findViewById(R.id.imgchatriya);
        chha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =chha2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        tra= (ImageButton) findViewById(R.id.imgtrishul);
        tra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =tra2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        gya = (ImageButton) findViewById(R.id.imggyani);
        gya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o =gya2.getText().toString();


                tts.speak(o, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

}
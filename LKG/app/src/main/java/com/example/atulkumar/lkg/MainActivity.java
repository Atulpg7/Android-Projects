package com.example.atulkumar.lkg;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
ImageButton img,img2,img3,img4,img5,img6,img7,img8;
    TextView ab,n,h1,h2,s,a,p,c;
    TextToSpeech t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ab=(TextView)findViewById(R.id.atoz);
        n=(TextView)findViewById(R.id.onetonine);
        h1=(TextView)findViewById(R.id.hindi);
        h2=(TextView)findViewById(R.id.hindi2);
        s=(TextView)findViewById(R.id.shape);
        a=(TextView)findViewById(R.id.animaln);
        p=(TextView)findViewById(R.id.poems);
        c=(TextView) findViewById(R.id.txtcolours) ;



        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if(status!=TextToSpeech.ERROR)
                {

                    t1.setLanguage(Locale.US);
                }
            }
        });

        t2=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if(status!=TextToSpeech.ERROR)
                {

                    t2.setLanguage(new Locale("hin"));
                }
            }
        });

        img= (ImageButton) findViewById(R.id.abc);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=ab.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
                Intent obj=new Intent(MainActivity.this,Abc2.class);
                startActivity(obj);

            }
        });

        img3= (ImageButton) findViewById(R.id.num);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=n.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
                Intent obj=new Intent(MainActivity.this,Num.class);
                startActivity(obj);

            }
        });

        img2= (ImageButton) findViewById(R.id.h1);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=h1.getText().toString();


                t2.speak(o,TextToSpeech.QUEUE_FLUSH,null);
                Intent obj=new Intent(MainActivity.this,H1.class);
                startActivity(obj);

            }
        });

        img4= (ImageButton) findViewById(R.id.h2);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String o=h2.getText().toString();


                t2.speak(o,TextToSpeech.QUEUE_FLUSH,null);
                Intent obj=new Intent(MainActivity.this,H2.class);
                startActivity(obj);

            }
        });

        img5= (ImageButton) findViewById(R.id.shapes);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=s.getText().toString();

                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);
                Intent obj=new Intent(MainActivity.this,Shapes.class);
                startActivity(obj);

            }
        });

        img6= (ImageButton) findViewById(R.id.animals);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=a.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);

                Intent obj=new Intent(MainActivity.this,animal.class);
                startActivity(obj);

            }
        });
        img7= (ImageButton) findViewById(R.id.Poem);
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=p.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);

                Intent obj=new Intent(MainActivity.this,Poems.class);
                startActivity(obj);

            }
        });

        img8= (ImageButton) findViewById(R.id.Colours);
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o=c.getText().toString();


                t1.speak(o,TextToSpeech.QUEUE_FLUSH,null);

                Intent obj=new Intent(MainActivity.this,Color.class);
                startActivity(obj);

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

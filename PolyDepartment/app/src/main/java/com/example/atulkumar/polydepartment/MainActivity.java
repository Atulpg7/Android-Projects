package com.example.atulkumar.polydepartment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Vector;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    TextView admsn,evnts,labs,prjcts,onlnexm,placmnt;
    RecyclerView rvcs,rvee,rvec,rvme,rvce,rvch;
    Vector<YoutubeVideo> yvcs=new Vector<YoutubeVideo>();
    Vector<YoutubeVideo> yvee=new Vector<YoutubeVideo>();
    Vector<YoutubeVideo> yvec=new Vector<YoutubeVideo>();
    Vector<YoutubeVideo> yvme=new Vector<YoutubeVideo>();
    Vector<YoutubeVideo> yvcv=new Vector<YoutubeVideo>();
    Vector<YoutubeVideo> yvch=new Vector<YoutubeVideo>();
    ViewFlipper flipper;
    GifImageView imcs,imee,imec,imme,imcv,imch;


    String csalumini="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fWJ1RDORU_s\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
    String eealumini="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/H_Qlfk-MIco\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
    String ecalumini="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Wv88RNxB0Ig\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
    String mealumini="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/G1clF3Wc6X8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
    String cvalumini="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TB6LGsPOUws\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
    String chalumini="<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/BRYiRugkt60\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admsn=findViewById(R.id.admsnprcstxt);
        evnts=findViewById(R.id.evntstxt);
        labs=findViewById(R.id.labstxt);
        prjcts=findViewById(R.id.prjctstxt);
        onlnexm=findViewById(R.id.onlnexmtxt);
        placmnt=findViewById(R.id.plcmenttxt);

        imcs=findViewById(R.id.clickcs);
        imee=findViewById(R.id.clickee);
        imec=findViewById(R.id.clickec);
        imme=findViewById(R.id.clickme);
        imcv=findViewById(R.id.clickcv);
        imch=findViewById(R.id.clickch);

        rvcs=findViewById(R.id.recyclerviewcs);
        rvee=findViewById(R.id.recyclerviewee);
        rvec=findViewById(R.id.recyclerviewec);
        rvme=findViewById(R.id.recyclerviewme);
        rvce=findViewById(R.id.recyclerviewce);
        rvch=findViewById(R.id.recyclerviewch);

        flipper=findViewById(R.id.flipper);




        //Images
        int images[]={R.drawable.im1,R.drawable.im2,R.drawable.im3};

        for (int i=0;i<images.length;i++)
        {
            flipperimages(images[i]);
        }






        imcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqpxKUasPG1jMx9zreK6PC6g");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        imee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqppofiV-n9QfvP0ZGtoPN_S");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        imec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqoJR3GzF45vHLB75jEexKio");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        imme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqowLl2VnvqSJq219Hknyuu");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


        imcv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqpDUeM6wX0lmELS8GBBvlxB");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        imch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqpAoFBOnGUnfhnSKcVTez1Y");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        rvcs.setHasFixedSize(true);
        rvcs.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvee.setHasFixedSize(true);
        rvee.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvec.setHasFixedSize(true);
        rvec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvme.setHasFixedSize(true);
        rvme.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvce.setHasFixedSize(true);
        rvce.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvch.setHasFixedSize(true);
        rvch.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



        admsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*
                Intent intent=new Intent(MainActivity.this,EventsActivity.class);
                startActivity(intent);*/

            }
        });

        evnts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,EventsActivity.class);
                intent.putExtra("parent","events");
                startActivity(intent);

            }
        });

        labs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,BranchSelectionActivity.class);
                intent.putExtra("parent","labs");
                startActivity(intent);

            }
        });

        prjcts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,BranchSelectionActivity.class);
                intent.putExtra("parent","projects");
                startActivity(intent);

            }
        });


        onlnexm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,FormActivity.class);
                startActivity(intent);

            }
        });


        placmnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,BranchSelectionActivity.class);
                intent.putExtra("parent","placements");
                startActivity(intent);

            }
        });


        yvcs.add(new YoutubeVideo(csalumini));
        yvee.add(new YoutubeVideo(eealumini));
        yvec.add(new YoutubeVideo(ecalumini));
        yvme.add(new YoutubeVideo(mealumini));
        yvcv.add(new YoutubeVideo(cvalumini));
        yvch.add(new YoutubeVideo(chalumini));

        VideoAdapter vc=new VideoAdapter(yvcs);
        VideoAdapter vee=new VideoAdapter(yvee);
        VideoAdapter vec=new VideoAdapter(yvec);
        VideoAdapter vme=new VideoAdapter(yvme);
        VideoAdapter vcv=new VideoAdapter(yvcv);
        VideoAdapter vch=new VideoAdapter(yvch);

        rvcs.setAdapter(vc);
        rvee.setAdapter(vee);
        rvec.setAdapter(vec);
        rvme.setAdapter(vme);
        rvce.setAdapter(vcv);
        rvch.setAdapter(vch);
    }


    public void flipperimages(int images){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(images);

        flipper.addView(imageView);
        flipper.setFlipInterval(4000);
        flipper.setAutoStart(true);


        flipper.setInAnimation(this,android.R.anim.fade_in);
        flipper.setOutAnimation(this,android.R.anim.fade_out);



    }
}

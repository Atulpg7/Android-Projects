package com.example.atulkumar.polydepartment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class EventsActivity extends AppCompatActivity {

    ListView lstview;
    String parent;
    Integer images[]={
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img,
            R.drawable.img};

    String names[]=
            {
                    "B.R Ambedkar",
                    "C.V raman",
                    "C Rajagopalachari",
                    "Gurucharan das",
                    "Harivansh Rai Bachchan",
                    "Kamla Suryya",
            };
    String dates[]=
            {
                    "00/00/00",
                    "00/00/00",
                    "00/00/00",
                    "00/00/00",
                    "00/00/00",
                    "00/00/00",
            };
    String branches[]=
            {
                    "All",
                    "CS",
                    "ME",
                    "CS",
                    "EE",
                    "All",
            };


    GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        gifImageView=findViewById(R.id.clickevents);
        lstview=findViewById(R.id.lstviewevent);

        Bundle b=getIntent().getExtras();
        if (b!=null) {

            parent = b.get("parent").toString();
            Toast.makeText(this, "Parent Is: "+parent, Toast.LENGTH_SHORT).show();
        }




        gifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });



        Custom_Adapter_Events adapter=new Custom_Adapter_Events(this,names,dates,branches,images);

        lstview.setAdapter(adapter);

    }
}

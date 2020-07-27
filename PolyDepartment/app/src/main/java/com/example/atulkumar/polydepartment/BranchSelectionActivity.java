package com.example.atulkumar.polydepartment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BranchSelectionActivity extends AppCompatActivity {


    TextView cs,ee,ec,me,ce,ch;
    String parent,branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branchselection);


        cs=findViewById(R.id.cstxt);
        ee=findViewById(R.id.eetxt);
        ec=findViewById(R.id.ectxt);
        me=findViewById(R.id.metxt);
        ce=findViewById(R.id.cetxt);
        ch=findViewById(R.id.chtxt);



        Bundle b=getIntent().getExtras();
        if (b!=null) {

             parent = b.get("parent").toString();
            Toast.makeText(this, "Parent Is: "+parent, Toast.LENGTH_SHORT).show();

        }



        cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (parent.equals("placements"))
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                else if (parent.equals("labs")){

                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }


            }
        });

        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (parent.equals("placements"))
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                else if (parent.equals("labs")){

                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });

        ec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (parent.equals("placements"))
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                else if (parent.equals("labs")){

                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });

        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (parent.equals("placements"))
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                else if (parent.equals("labs")){

                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }


            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (parent.equals("placements"))
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                else if (parent.equals("labs")){

                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }

            }
        });


        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (parent.equals("placements"))
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
                else if (parent.equals("labs")){

                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else
                {
                    Uri uri = Uri.parse("https://www.youtube.com/playlist?list=PLOLsDxswPJqqk-ORGt-9U5GepU-urwhrL");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }


            }
        });




    }
}

package com.example.atulkumar.polydepartment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class VideosActivity extends AppCompatActivity {

    String parent,branch;
    TextView t;
    RecyclerView recyclerView;
    Vector<YoutubeVideo> youtubeVideo=new Vector<YoutubeVideo>();

    ArrayList<String> urls=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        t=findViewById(R.id.branch);

        Bundle b= getIntent().getExtras();
        if (b != null)
        {
            parent=b.get("parent").toString();
            branch=b.get("branch").toString();
            Toast.makeText(this, "Parent is :- "+parent+" Branch is:- "+branch, Toast.LENGTH_SHORT).show();
        }

        if (parent.equals("placements"))
        {
            t.setText(""+branch.toUpperCase()+" Branch Placement Videos");
        }
        else if (parent.equals("events"))
        {
            t.setText(""+branch.toUpperCase()+" Branch Events Videos");
        }
        else if (parent.equals("labs"))
        {
            t.setText(""+branch.toUpperCase()+" Branch Labs Videos");
        }
        else if (parent.equals("projects"))
        {
            t.setText(""+branch.toUpperCase()+" Branch Projects Videos");
        }

        loadvideos();

        VideoAdapter videoAdapter=new VideoAdapter(youtubeVideo);
        recyclerView.setAdapter(videoAdapter);


    }

    public void loadvideos()
    {

        String url[]={"BLjMNkUsDXY","BLjMNkUsDXY","U5iN4DWWK3w","U5iN4DWWK3w"};

        for (int i=0;i<url.length;i++)
        {
            urls.add(""+url[i]);
        }

        for (int i=0;i<urls.size();i++) {
            youtubeVideo.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + urls.get(i) + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        }

    }



}

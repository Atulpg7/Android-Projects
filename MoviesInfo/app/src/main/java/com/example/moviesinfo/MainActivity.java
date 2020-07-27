package com.example.moviesinfo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moviesinfo.API.API;
import com.example.moviesinfo.Model.MovieDetails;
import com.example.moviesinfo.Model.MovieModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    //Customised adapter for showing movies in recycle view
    CustomAdapterMain adapter;

    //Recycle view for movies
    RecyclerView recyclerView;

    //arrayLists for title
    ArrayList<String> titleList;

    //List for sort title for api
    ArrayList<String> sortTitle;

    //Title
    String title="";

    //Movies Model
    ArrayList<MovieModel> movies;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //Arraylists
        titleList=new ArrayList<>();
        sortTitle=new ArrayList<>();
        movies=new ArrayList<>();


        //Getting reference and Setting layout manager for recycler view
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        manager.setSmoothScrollbarEnabled(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(manager);


        //Adding Titles
       // titleList.add("Top Rated");
       // sortTitle.add("top_rated");
       // titleList.add("Popular");
       // sortTitle.add("popular");

        titleList.add("Now Playing");
        sortTitle.add("now_playing");
/*        titleList.add("Upcoming");
        sortTitle.add("upcoming");*/


        //Fetchin json data
        fetchData();

        //Setting Adapter
        setAdapter();

    }

    private void setAdapter() {

        adapter=new CustomAdapterMain(this,movies);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    public  void fetchData() {

        // For URL's
        API api = new API();

       // for (int i = 0; i < titleList.size(); i++) {

            String url = api.getMovieUrl() + sortTitle.get(0) + api.getApiKey();
            title = titleList.get(0);

            StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {

                        MovieModel model=new MovieModel();
                        model.setTitle(title);

                        //getting the whole json object from the response
                        JSONObject objectRespone = new JSONObject(response);


                        //we have the array named hero inside the object
                        //so here we are getting that json array
                        JSONArray array = objectRespone.getJSONArray("results");

                        ArrayList<MovieDetails> moviesDetails=new ArrayList<>();

                        for (int i = 0; i < array.length(); i++) {

                            JSONObject obj = array.getJSONObject(i);

                            MovieDetails movie = new MovieDetails();

                            movie.setTitle(obj.getString("title"));
                            movie.setPoster_path(obj.getString("poster_path"));
                            movie.setVote_average(obj.getString("vote_average"));
                            movie.setOverview(obj.getString("overview"));
                            movie.setRelease_date(obj.getString("release_date"));
                            moviesDetails.add(movie);

                        }

                        model.setArrayList(moviesDetails);

                        movies.add(model);

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Exception: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

            //creating a request queue
            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            //adding the string request to request queue
            requestQueue.add(request);
        }


}
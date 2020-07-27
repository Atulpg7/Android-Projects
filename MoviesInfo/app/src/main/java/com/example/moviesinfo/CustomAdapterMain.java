package com.example.moviesinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesinfo.Model.MovieDetails;
import com.example.moviesinfo.Model.MovieModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapterMain extends RecyclerView.Adapter<CustomAdapterMain.MyCustomAdapter> {

    //Context for getting reference of calling activity
    Context context;

    //ArrayLists for storing titles and Movies list according to titles
    ArrayList<MovieModel> movies;

    //Setting the values
    public CustomAdapterMain(Context context, ArrayList<MovieModel> movies) {
        this.context = context;
        this.movies=movies;

    }

    @NonNull
    @Override
    public MyCustomAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Setting the custom View for vertical list.
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view_main,parent,false);
        return new MyCustomAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomAdapter holder, int position) {

        //Setting Title in custom view
        MovieModel movie=movies.get(position);
        holder.title.setText(movie.getTitle());


        //Adapter for Inserting movies list according to title.
        CustomAdapterMovies moviesAdapter=new CustomAdapterMovies(context,movie.getArrayList());


        //Setting properties of recycler view.
        holder.recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        manager.setSmoothScrollbarEnabled(true);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setNestedScrollingEnabled(false);
        holder.recyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }




    public  class MyCustomAdapter extends RecyclerView.ViewHolder{

        //Text view and Recycle view for titles and list of movies
        TextView title;
        RecyclerView recyclerView;

        public MyCustomAdapter(@NonNull View itemView) {
            super(itemView);


            //Getting reference of TextViews from custom view main.
            title=itemView.findViewById(R.id.title);
            recyclerView=itemView.findViewById(R.id.recycler_view);

        }
    }

}

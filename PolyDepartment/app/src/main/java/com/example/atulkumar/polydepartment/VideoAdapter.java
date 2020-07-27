package com.example.atulkumar.polydepartment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YoutubeVideo> youtubeVideoList;

    public VideoAdapter() {
    }

    public VideoAdapter(List<YoutubeVideo> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        holder.videoweb.loadData(youtubeVideoList.get(position).getVideourl(),"text/html","utf-8");

    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public  class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoweb;


        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoweb=itemView.findViewById(R.id.webvideoview);
            videoweb.getSettings().setJavaScriptEnabled(true);
            videoweb.setWebChromeClient(new WebChromeClient(){

            });
        }
    }
}

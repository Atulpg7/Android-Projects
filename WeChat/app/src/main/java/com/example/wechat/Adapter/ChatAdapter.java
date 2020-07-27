package com.example.wechat.Adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechat.R;

import java.util.List;

public class ChatAdapter extends  RecyclerView.Adapter<ChatAdapter.Viewholder> {


    private Context mContext;
    private List<ChatMessage> mList;


    public ChatAdapter(Context mContext, List<ChatMessage> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.custom_msges,parent,false);
        return new ChatAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {


        ChatMessage chatMessage=mList.get(position);

        holder.email.setText(""+chatMessage.getMessageUser());
        holder.time.setText(DateFormat.format("dd-MM-yyyy HH:mm",chatMessage.getMessageTime()));
        holder.message.setText(""+chatMessage.getMessageText());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{


        TextView email,time,message;

        public Viewholder(@NonNull View itemView) {
            super(itemView);


            email=itemView.findViewById(R.id.message_user);
            message=itemView.findViewById(R.id.message_text);
            time=itemView.findViewById(R.id.message_time);
        }
    }
}

package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wechat.Adapter.ChatAdapter;
import com.example.wechat.Adapter.ChatMessage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    View parentLayout;
    private FirebaseAuth auth;
    String user;
    EditText message;
    ImageView send;
    String userName;
    TextView tv_nc;
    ProgressBar pb;
    RecyclerView recyclerView;
    ChatAdapter adapter;
    List<ChatMessage> messageList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        message=findViewById(R.id.message);
        send=findViewById(R.id.send);
        auth=FirebaseAuth.getInstance();
        parentLayout = findViewById(android.R.id.content);
        pb=findViewById(R.id.progress_circular);
        tv_nc=findViewById(R.id.tv_nc);
        pb.setVisibility(View.VISIBLE);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        messageList=new ArrayList<>();
        adapter=new ChatAdapter(this,messageList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        //user=auth.getCurrentUser().getEmail();







        displayMessages();



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg=message.getText().toString();

                if (msg.equals(""))
                {
                    Snackbar.make(parentLayout,"Cant send empty Message !!",Snackbar.LENGTH_SHORT).show();
                }
                else {

                    long messageTime = new Date().getTime();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("messageText", msg);
                    hashMap.put("messageUser", userName);
                    hashMap.put("messageTime", messageTime);
                    FirebaseDatabase.getInstance().getReference("Messages").push().setValue(hashMap);

                    message.setText("");

                }



            }
        });



    }

    private void displayMessages() {



        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Messages");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                messageList.clear();
                pb.setVisibility(View.GONE);

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    ChatMessage message=snapshot.getValue(ChatMessage.class);
                    messageList.add(message);
                    adapter.notifyDataSetChanged();
                }

                if(adapter.getItemCount()!=0) {

                    tv_nc.setVisibility(View.GONE);
                    recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                        }
                    });
                }
                else
                {
                    tv_nc.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users")
                .child(auth.getCurrentUser().getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userName = String.valueOf(dataSnapshot.child("name").getValue());
                Toolbar toolbar=findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Welcome: "+userName);
                Snackbar.make(parentLayout,"Welcome: "+userName,Snackbar.LENGTH_LONG).show();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==R.id.logout)
        {
            auth.signOut();
            Intent intent=new Intent(MainActivity.this,StartActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);


    }




}

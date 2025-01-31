package com.example.cleanchitkaraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cleanchitkaraapp.Adapter.CommentAdapter;
import com.example.cleanchitkaraapp.Adapter.PostAdapter;
import com.example.cleanchitkaraapp.Model.Comment;
import com.example.cleanchitkaraapp.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentsActivity extends AppCompatActivity {
    
    ImageView image_profile;


    private RecyclerView recyclerView;
    private CommentAdapter commentAdapter;
    private List<Comment> commentList;

    EditText addcomment;
    TextView post;
    
    String postid;
    String publisher;
    
    FirebaseUser firebaseUser;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Comments");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                finish();
                
            }
        });


        Intent intent=getIntent();
        postid=intent.getStringExtra("postid");
        publisher=intent.getStringExtra("publisherid");


        
        
        image_profile=findViewById(R.id.image_profile);


        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        commentList=new ArrayList<>();
        commentAdapter=new CommentAdapter(this,commentList,postid);
        recyclerView.setAdapter(commentAdapter);

        addcomment=findViewById(R.id.comment);
        post=findViewById(R.id.post);



        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        
        
        
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (addcomment.getText().toString().equals(""))
                {
                    Toast.makeText(CommentsActivity.this, "You can't send empty comment !", Toast.LENGTH_SHORT).show();
                }
                else {
                    addComment();
                }
                
            }
        });

        getImage();
        readComments();
        
        
    }


    private void addComment() {

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Comments")
                .child(postid);


        String commentid=reference.push().getKey();

        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("comment",addcomment.getText().toString());
        hashMap.put("publisher",firebaseUser.getUid());
        hashMap.put("commentid",commentid);

        reference.child(commentid).setValue(hashMap);

        addNotifications();
        addcomment.setText("");
        Toast.makeText(this, "Comment Added Successfully...", Toast.LENGTH_SHORT).show();
    }

    private void addNotifications() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Notifications").child(publisher);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userid", firebaseUser.getUid());
        hashMap.put("text", "commented: "+addcomment.getText());
        hashMap.put("postid", postid);
        hashMap.put("ispost", true);

        reference.push().setValue(hashMap);
    }


    public void getImage()
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                User user=dataSnapshot.getValue(User.class);
                Glide.with(getApplicationContext())
                        .load(user.getImageurl())
                        .into(image_profile);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



    private void readComments()
    {

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Comments").child(postid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                commentList.clear();

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {

                    Comment comment= dataSnapshot1.getValue(Comment.class);
                    commentList.add(comment);

                }

                commentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}

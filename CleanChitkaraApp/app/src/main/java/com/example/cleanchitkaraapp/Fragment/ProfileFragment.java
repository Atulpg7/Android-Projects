package com.example.cleanchitkaraapp.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.cleanchitkaraapp.Adapter.MyFotoAdapter;
import com.example.cleanchitkaraapp.EditProfileActivity;
import com.example.cleanchitkaraapp.FollowersActivity;
import com.example.cleanchitkaraapp.Model.Post;
import com.example.cleanchitkaraapp.Model.User;
import com.example.cleanchitkaraapp.OptionsActivity;
import com.example.cleanchitkaraapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ProfileFragment extends Fragment {



    ImageView image_profile,options;
    TextView posts,following,followers,fullname,bio,username,txtposts,txtfollowing,txtfollowers;
    Button edit_profile;
    ProgressBar progressBar;

    private List<String> mySaves;

    RecyclerView recyclerView_saves;
    MyFotoAdapter myFotoAdapter_saves;
    List<Post> postList_saves;

    FirebaseUser firebaseUser;
    String profileid;

    RecyclerView recyclerView;
    MyFotoAdapter myFotoAdapter;
    List<Post> postList;



    ImageButton my_fotos,saved_fotos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);





        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        SharedPreferences prefs=getContext().getSharedPreferences("PREFS",Context.MODE_PRIVATE);
        profileid=prefs.getString("profileid","none");


        image_profile=view.findViewById(R.id.image_profile);
        options=view.findViewById(R.id.options);

        posts=view.findViewById(R.id.posts);
        following=view.findViewById(R.id.following);
        followers=view.findViewById(R.id.followers);

        txtposts=view.findViewById(R.id.txtposts);
        txtfollowing=view.findViewById(R.id.txtfollowing);
        txtfollowers=view.findViewById(R.id.txtfollowers);


        fullname=view.findViewById(R.id.fullname);
        bio=view.findViewById(R.id.bio);
        username=view.findViewById(R.id.username);
        edit_profile=view.findViewById(R.id.edit_profile);
        my_fotos=view.findViewById(R.id.my_fotos);
        saved_fotos=view.findViewById(R.id.saved_fotos);
        progressBar=view.findViewById(R.id.progress_circular);


        //Posts
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(linearLayoutManager);
        postList=new ArrayList<>();
        myFotoAdapter=new MyFotoAdapter(getContext(),postList);
        recyclerView.setAdapter(myFotoAdapter);

        //Saves
        recyclerView_saves=view.findViewById(R.id.recyclerview_save);
        recyclerView_saves.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager_saves=new GridLayoutManager(getContext(),3);
        recyclerView_saves.setLayoutManager(linearLayoutManager_saves);
        postList_saves=new ArrayList<>();
        myFotoAdapter_saves=new MyFotoAdapter(getContext(),postList_saves);
        recyclerView_saves.setAdapter(myFotoAdapter_saves);

        recyclerView.setVisibility(View.VISIBLE);
        recyclerView_saves.setVisibility(View.GONE);




        mysaves();
        myFotos();
        userInfo();
        getFollowers();
        getFollowing();
        getNrPosts();






        if (profileid.equals(firebaseUser.getUid()))
        {
            edit_profile.setText("Edit Profile");

        }
        else {
            checkFollow();
            saved_fotos.setVisibility(View.GONE);
        }



        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String btn=edit_profile.getText().toString();


                if (btn.equals("Edit Profile"))
                {
                    startActivity(new Intent(getContext(), EditProfileActivity.class));

                }
                else if(btn.equals("follow"))
                {

                    FirebaseDatabase.getInstance().getReference().child("Follow").child(firebaseUser.getUid()).
                            child("following").child(profileid).setValue(true);
                    FirebaseDatabase.getInstance().getReference().child("Follow").child(profileid).
                            child("followers").child(firebaseUser.getUid()).setValue(true);


                    addNotifications();

                }
                else if (btn.equals("following"))
                {
                    FirebaseDatabase.getInstance().getReference().child("Follow").child(firebaseUser.getUid()).
                            child("following").child(profileid).removeValue();
                    FirebaseDatabase.getInstance().getReference().child("Follow").child(profileid).
                            child("followers").child(firebaseUser.getUid()).removeValue();

                }


            }
        });



        my_fotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerView.setVisibility(View.VISIBLE);
                recyclerView_saves.setVisibility(View.GONE);

            }
        });

        saved_fotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recyclerView.setVisibility(View.GONE);
                recyclerView_saves.setVisibility(View.VISIBLE);
            }
        });


        followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getContext(), FollowersActivity.class);
                intent.putExtra("id",profileid);
                intent.putExtra("title","Followers");
                startActivity(intent);

            }
        });


        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getContext(), FollowersActivity.class);
                intent.putExtra("id",profileid);
                intent.putExtra("title","Following");
                startActivity(intent);

            }
        });



        txtfollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getContext(), FollowersActivity.class);
                intent.putExtra("id",profileid);
                intent.putExtra("title","Followers");
                startActivity(intent);

            }
        });


        txtfollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getContext(), FollowersActivity.class);
                intent.putExtra("id",profileid);
                intent.putExtra("title","Following");
                startActivity(intent);

            }
        });



        followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getContext(), FollowersActivity.class);
                intent.putExtra("id",profileid);
                intent.putExtra("title","Followers");
                startActivity(intent);

            }
        });


        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               Intent intent=new Intent(getContext(), OptionsActivity.class);
               startActivity(intent);


            }
        });

        return view;
    }


    private void addNotifications() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Notifications").child(profileid);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userid", firebaseUser.getUid());
        hashMap.put("text", "started follow you");
        hashMap.put("postid", "");
        hashMap.put("ispost", false);

        reference.push().setValue(hashMap);
    }




    private void userInfo()
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Users").child(profileid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (getContext()==null)
                {
                    return;
                }

                User user=dataSnapshot.getValue(User.class);
                Glide.with(getContext()).load(user.getImageurl()).into(image_profile);
                username.setText(user.getUsername());
                fullname.setText(user.getFullname());
                bio.setText(user.getBio());




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    private void checkFollow()
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference()
                .child("Follow").child(firebaseUser.getUid()).child("following");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.child(profileid).exists())
                {
                    edit_profile.setText("following");
                }
                else
                {
                    edit_profile.setText("follow");
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private  void getFollowers()
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference()
                .child("Follow").child(profileid).child("followers");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                followers.setText(""+dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    private void getFollowing()
    {
        DatabaseReference reference1=FirebaseDatabase.getInstance().getReference()
                .child("Follow").child(profileid).child("following");

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                following.setText(""+dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void getNrPosts()
    {

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference()
                .child("Posts");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int i=0;

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Post post=dataSnapshot1.getValue(Post.class);

                    if (post.getPublisher().equals(profileid))
                    {
                        i++;
                    }
                }
                posts.setText(""+i);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void myFotos()
    {

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Posts");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Post post=snapshot.getValue(Post.class);

                    if (post.getPublisher().equals(profileid))
                    {
                        postList.add(post);
                    }
                }

                Collections.reverse(postList);

                myFotoAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private  void mysaves()
    {

        mySaves=new ArrayList<>();
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Saves")
                .child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    mySaves.add(snapshot.getKey());
                }
                readSaves();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void readSaves() {

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("Posts");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList_saves.clear();

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Post post=snapshot.getValue(Post.class);

                    for (String id: mySaves)
                    {
                        assert post != null;
                        if (post.getPostid().equals(id))
                        {
                            postList_saves.add(post);
                        }
                    }
                }

                progressBar.setVisibility(View.GONE);
                myFotoAdapter_saves.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}

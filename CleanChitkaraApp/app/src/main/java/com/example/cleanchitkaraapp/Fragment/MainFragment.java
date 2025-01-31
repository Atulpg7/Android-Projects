package com.example.cleanchitkaraapp.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cleanchitkaraapp.Adapter.PostAdapter;
import com.example.cleanchitkaraapp.Adapter.StoryAdapter;
import com.example.cleanchitkaraapp.Model.Post;
import com.example.cleanchitkaraapp.Model.Story;
import com.example.cleanchitkaraapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {


    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postList;
    private List<String> followingList;



    private RecyclerView recyclerView_story;
    private StoryAdapter storyAdapter;
    private  List<Story> mStoryList;

    ProgressBar progressBar;
    static int i=0;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_main,container,false);

        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        progressBar=view.findViewById(R.id.progress_circular);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        postList=new ArrayList<>();
        postAdapter=new PostAdapter(getContext(),postList);
        recyclerView.setAdapter(postAdapter);


        /*recyclerView_story=view.findViewById(R.id.recycler_view_story);
        recyclerView_story.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getContext(),
            LinearLayoutManager.HORIZONTAL,false);
        recyclerView_story.setLayoutManager(linearLayoutManager1);
        mStoryList=new ArrayList<>();
        storyAdapter=new StoryAdapter(getContext(),mStoryList);
        recyclerView_story.setAdapter(storyAdapter);
*/
         checkFollowing();
        return view;
    }




    private void checkFollowing()
    {
        followingList=new ArrayList<>();

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("Follow")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("following");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                followingList.clear();

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    followingList.add(snapshot.getKey());
                }

                readPost();
                //readStory();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


    private void readPost()
    {

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Posts");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                postList.clear();

                for (DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    Post post=snapshot.getValue(Post.class);

                    //Toast.makeText(getContext(), ""+post.getDescription(), Toast.LENGTH_SHORT).show();


                    for (String id:followingList)
                    {
                        if (post.getPublisher().equals(id))
                        {
                            postList.add(post);
                            postAdapter.notifyDataSetChanged();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }





    /*private void readStory()
    {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Story");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                long timeCurrent=System.currentTimeMillis();
                mStoryList.clear();

                mStoryList.add(new Story("",0,0,"",FirebaseAuth.getInstance().getCurrentUser().getUid()));

                for (String id:followingList) {
                    int countStory = 0;

                    Story story=null;
                    for (DataSnapshot snapshot : dataSnapshot.child(id).getChildren()) {
                         story = snapshot.getValue(Story.class);

                        if (timeCurrent > story.getTimestart() && timeCurrent < story.getTimeend()) {
                            countStory++;
                        }
                    }

                    if (countStory > 0) {
                        mStoryList.add(story);
                    }
                }

                storyAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

}

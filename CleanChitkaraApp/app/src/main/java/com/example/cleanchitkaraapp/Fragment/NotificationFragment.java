package com.example.cleanchitkaraapp.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.cleanchitkaraapp.Adapter.NotificationAdapter;
import com.example.cleanchitkaraapp.Model.Notification;
import com.example.cleanchitkaraapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationFragment extends Fragment {


    RecyclerView recyclerView;
    NotificationAdapter notificationAdapter;
    List<Notification> notificationlist;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notification, container, false);


        progressBar=view.findViewById(R.id.progress_circular);
        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        notificationlist=new ArrayList<>();
        notificationAdapter=new NotificationAdapter(getContext(),notificationlist);
        recyclerView.setAdapter(notificationAdapter);




        return view;

    }

    private void readNotifications() {

        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Notifications").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                notificationlist.clear();

                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Notification notification=snapshot.getValue(Notification.class);
                    notificationlist.add(notification);
                }

                Collections.reverse(notificationlist);
                notificationAdapter.notifyDataSetChanged();

                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        readNotifications();


    }
}
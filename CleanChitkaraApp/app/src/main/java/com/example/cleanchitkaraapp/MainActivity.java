package com.example.cleanchitkaraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cleanchitkaraapp.Fragment.MainFragment;
import com.example.cleanchitkaraapp.Fragment.NotificationFragment;
import com.example.cleanchitkaraapp.Fragment.ProfileFragment;
import com.example.cleanchitkaraapp.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);



        Bundle intent=getIntent().getExtras();
        if (intent!=null)
        {
            String publisherid= intent.getString("publisherid");


            SharedPreferences.Editor editor=getSharedPreferences("PREFS",MODE_PRIVATE).edit();
            editor.putString("profileid",publisherid);
            editor.apply();

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ProfileFragment()).commit();

        }else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MainFragment()).commit();

        }





    }


    private  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId())
            {
                case R.id.nav_home:

                    selectedFragment= new MainFragment();

                    break;
                case R.id.nav_search:

                    selectedFragment=new SearchFragment();

                    break;

                case R.id.nav_add:

                    selectedFragment=null;
                    startActivity(new Intent(MainActivity.this,PostActivity.class));

                    break;
                case R.id.nav_heart:
                    selectedFragment=new NotificationFragment();
                    break;

                case R.id.nav_person:
                    SharedPreferences.Editor editor=getSharedPreferences("PREFS",MODE_PRIVATE).edit();
                    editor.putString("profileid", FirebaseAuth.getInstance().getCurrentUser().getUid());
                    editor.apply();

                    selectedFragment=new ProfileFragment();

                    break;
            }


            if (selectedFragment!=null)
            {
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();*/

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, selectedFragment);
                transaction.commit();
            }


            return true;
        }
    };


    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


}

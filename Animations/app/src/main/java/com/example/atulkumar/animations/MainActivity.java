package com.example.atulkumar.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView iv;
    Animation animation,animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.imageview);


        animation=AnimationUtils.loadAnimation(this,R.anim.fourth);
        //animation2=AnimationUtils.loadAnimation(this,R.anim.second);

        iv.startAnimation(animation);
        //iv.startAnimation(animation2);
    }
}

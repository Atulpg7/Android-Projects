package com.example.edu_app;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.support.v4.app.NavUtils;
public class about_us extends Activity {
	 ImageView imageView;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us); 

       // imageView = (ImageView)findViewById(R.id.imageView2);
                    
     /* imageView = (ImageView)findViewById(R.id.imageView2);

        imageView.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                int eid = event.getAction();
                switch (eid) {
                case MotionEvent.ACTION_MOVE:

                    RelativeLayout.LayoutParams mParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    int x = (int) event.getRawX();
                    int y = (int) event.getRawY();
                    mParams.leftMargin = x-50;
                    mParams.topMargin = y-50;
                    imageView.setLayoutParams(mParams);
                    break;
                default:
                    break;
                }
                return true;
            }
        });*/        
}
}

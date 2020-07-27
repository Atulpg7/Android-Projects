package com.example.atulkumar.use_of_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageButton clickimage,setbkb;
    ImageView imageview;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        clickimage=findViewById(R.id.btnphoto);
        setbkb=findViewById(R.id.btnbackground);
        imageview=findViewById(R.id.imageView);


        clickimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //Request code is an identity jese 3 log request kare camere ke liye
                startActivityForResult(intent,101);
            }
        });


        setbkb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try
                {
                    getApplicationContext().setWallpaper(bitmap);
                }

                //Exeption parent class hai jisme har tarha ki exeption ka
                //code and use hota hai
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    //Jab bhi hum startactivity for result use karte hai and capture karte hai image
    //to yeh method call hota hai  (Internally Hota Hai).
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {




        if (requestCode==101 &&
                resultCode==RESULT_OK &&
                data!=null) {

            Bundle b=data.getExtras();
            bitmap = (Bitmap) b.get("data");
            imageview.setImageBitmap(bitmap);
        }
        else {
            Toast.makeText(this, "No image clicked or selected", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}

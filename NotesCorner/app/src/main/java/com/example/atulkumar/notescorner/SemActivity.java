package com.example.atulkumar.notescorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SemActivity extends AppCompatActivity {

    Button fsem,ssem,tsem,fosem,fisem,sisem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem);


        fsem=findViewById(R.id.fsembtn);
        ssem=findViewById(R.id.ssembtn);
        tsem=findViewById(R.id.tsembtn);
        fosem=findViewById(R.id.fosembtn);
        fisem=findViewById(R.id.fisembtn);
        sisem=findViewById(R.id.sisembtn);


        fsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SemActivity.this,StudentMainActivity.class);
                intent.putExtra("sem","I");
                startActivity(intent);

            }
        });

        ssem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SemActivity.this,StudentMainActivity.class);
                intent.putExtra("sem","II");
                startActivity(intent);

            }
        });

        tsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SemActivity.this,StudentMainActivity.class);
                intent.putExtra("sem","III");
                startActivity(intent);

            }
        });

        fosem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SemActivity.this,StudentMainActivity.class);
                intent.putExtra("sem","IV");
                startActivity(intent);

            }
        });

        fisem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SemActivity.this,StudentMainActivity.class);
                intent.putExtra("sem","V");
                startActivity(intent);

            }
        });

        sisem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(SemActivity.this,StudentMainActivity.class);
                intent.putExtra("sem","VI");
                startActivity(intent);

            }
        });
    }
}

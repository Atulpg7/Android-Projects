package com.example.atulkumar.popup_menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu=new PopupMenu(MainActivity.this,tv);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int id=menuItem.getItemId();


                        switch (id)
                        {
                            case R.id.menuredcolor:
                                tv.setTextColor(Color.RED);
                                break;

                            case R.id.menugrren:
                                tv.setTextColor(Color.GREEN);
                                break;

                            case R.id.menubluecolor:
                                tv.setTextColor(Color.BLUE);
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();



            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PopupMenu popupMenu=new PopupMenu(MainActivity.this,btn);

                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int id=menuItem.getItemId();


                        switch (id)
                        {
                            case R.id.menuredcolor:
                               btn.setBackgroundColor(Color.RED);
                               break;

                            case R.id.menugrren:
                                btn.setBackgroundColor(Color.GREEN);
                                break;

                            case R.id.menubluecolor:
                                btn.setBackgroundColor(Color.BLUE);
                                break;
                        }

                        return false;
                    }
                });

                popupMenu.show();



            }
        });


    }

}

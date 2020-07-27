package com.example.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView sl1, sl2, sl3, sl4;
    Button btn;

    String a[] = {"Select Location", "Parking 1", "Parking 2"};
    Spinner spinner;
    public static int vl1, vl2, vl3, vl4;
    LinearLayout layout;

    ProgressDialog progressDoalog;


    DatabaseReference dbref1,dbref2,dbref3,dbref4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        sl1=findViewById(R.id.slot1);
        sl2=findViewById(R.id.slot2);
        sl3=findViewById(R.id.slot3);
        sl4=findViewById(R.id.slot4);
        spinner=findViewById(R.id.spinner);
        layout=findViewById(R.id.result);


        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, a);
        spinner.setAdapter(ad);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String r=spinner.getSelectedItem().toString();
                String s="";
                
                if(r.equals("Select Location"))
                {
                    Toast.makeText(MainActivity.this, "Please Select Location !!", Toast.LENGTH_SHORT).show();
                    layout.setVisibility(View.INVISIBLE);
                }
                else if(r.equals("Parking 1"))
                {
                  s="Parking1";
                }
                else
                {
                    s="Parking2";
                }

                if(!s.equals(""))
                {
                    progressDoalog = new ProgressDialog(MainActivity.this);
                    progressDoalog.setMessage("Getting available slots....");
                    progressDoalog.setTitle("Loading Result");
                    progressDoalog.show();

                    getResult(s);



                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressDoalog.dismiss();
                            layout.setVisibility(View.VISIBLE);

                        }
                    }, 2000);
                    //Toast.makeText(MainActivity.this, "Loaded", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please Select Location !!", Toast.LENGTH_SHORT).show();
                    layout.setVisibility(View.INVISIBLE);
                }
                
                
                
            }
        });

    }

    public void getResult(String s)
    {
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference(s);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Data d=dataSnapshot.getValue(Data.class);

                if(d!=null)
                {
                    vl1 = d.slot1;
                    vl2 = d.slot2;
                    vl3 = d.slot3;
                    vl4 = d.slot4;

                    if(vl1==1)
                    {
                        sl1.setText("Available");
                        sl1.setTextColor(Color.parseColor("#4ed442"));
                    }
                    else
                    {
                        sl1.setText("Booked");
                        sl1.setTextColor(Color.parseColor("#de1818"));
                    }


                    if(vl2==1)
                    {
                        sl2.setText("Available");
                        sl2.setTextColor(Color.parseColor("#4ed442"));
                    }
                    else
                    {
                        sl2.setText("Booked");
                        sl2.setTextColor(Color.parseColor("#de1818"));
                    }

                    if(vl3==1)
                    {
                        sl3.setText("Available");
                        sl3.setTextColor(Color.parseColor("#4ed442"));
                    }
                    else
                    {
                        sl3.setText("Booked");
                        sl3.setTextColor(Color.parseColor("#de1818"));
                    }

                    if(vl4==1)
                    {
                        sl4.setText("Available");
                        sl4.setTextColor(Color.parseColor("#4ed442"));
                    }
                    else
                    {
                        sl4.setText("Booked");
                        sl4.setTextColor(Color.parseColor("#de1818"));
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No record Found....", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
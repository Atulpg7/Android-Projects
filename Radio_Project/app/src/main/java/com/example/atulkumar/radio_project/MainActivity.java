package com.example.atulkumar.radio_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    RadioButton male,female,married,unmarried;
    Button btn;
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);
        male=findViewById(R.id.radiomale);
        female=findViewById(R.id.radiofemale);
        married=findViewById(R.id.radiomarried);
        unmarried=findViewById(R.id.radiounmarried);
        btn=findViewById(R.id.btn);
        ans=findViewById(R.id.ans);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=et.getText().toString();

                if(name.equals(""))
                {
                    ans.setText("");
                    et.requestFocus();
                    et.setError("Please Enter Name ");

                }
                else if(male.isChecked()&&unmarried.isChecked())
                {
                    ans.setText("");
                    ans.setText("Hello Master "+name);

                }
                else if(male.isChecked()&&married.isChecked())
                {
                    ans.setText("");
                    ans.setText("Hello Mr. "+name);


                }

                else if(female.isChecked()&&unmarried.isChecked())
                {
                    ans.setText("");
                    ans.setText("Hello Miss "+name);

                }
                else if(female.isChecked()&&married.isChecked())
                {
                    ans.setText("");
                    ans.setText("Hello Mrs. "+name);


                }



            }
        });
    }
}

package com.example.wechat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    TextView register;
    private FirebaseAuth auth;

    View parentLayout;

    ProgressDialog pd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        register=findViewById(R.id.txt_register);
        auth=FirebaseAuth.getInstance();

        parentLayout = findViewById(android.R.id.content);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,RegisterActivty.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd=new ProgressDialog(LoginActivity.this);
                pd.setMessage("Please Wait...");
                pd.setCanceledOnTouchOutside(false);
                pd.setCancelable(false);

                String emailid=email.getText().toString();
                String pass=password.getText().toString();

                if (email.equals("")||pass.equals(""))
                {
                    Snackbar.make(parentLayout,"All fields required !!",Snackbar.LENGTH_SHORT).show();
                }
                else if (pass.length()<6)
                {
                    Snackbar.make(parentLayout,"Password must be 6 Character Long !!",Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    pd.show();
                    Login(emailid,pass);
                }
            }
        });


    }

    private void Login(String emailid, String pass) {

        auth.signInWithEmailAndPassword(emailid,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful())
                {
                    pd.dismiss();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    pd.dismiss();
                    Snackbar.make(parentLayout,"You are not registered !",Snackbar.LENGTH_SHORT).show();
                }


            }
        });


    }
}

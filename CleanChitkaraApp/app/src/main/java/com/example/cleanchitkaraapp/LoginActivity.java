package com.example.cleanchitkaraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    
    EditText email,password;
    Button btn_login;
    TextView txt_signup;
    
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        btn_login=findViewById(R.id.login);
        txt_signup=findViewById(R.id.txt_register);

        auth=FirebaseAuth.getInstance();

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });
        
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog pd=new ProgressDialog(LoginActivity.this);
                pd.setMessage("Please wait....");
                pd.setCanceledOnTouchOutside(false);
                pd.setCancelable(false);

                
                String str_email=email.getText().toString();
                String str_password=password.getText().toString();
                
                if (TextUtils.isEmpty(str_email)||TextUtils.isEmpty(str_password))
                {
                    Toast.makeText(LoginActivity.this, "All fields are required !! ", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                        pd.show();
                        auth.signInWithEmailAndPassword(str_email,str_password)
                                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (task.isSuccessful())
                                        {
                                            DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Users")
                                                    .child(auth.getCurrentUser().getUid());

                                            reference.addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                    pd.dismiss();
                                                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                    startActivity(intent);
                                                    finish();
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
                                            });
                                        }
                                        else {
                                            pd.dismiss();
                                            Toast.makeText(LoginActivity.this, "Incorrect Email or Password !!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                }
                
            }
        });
    }
}

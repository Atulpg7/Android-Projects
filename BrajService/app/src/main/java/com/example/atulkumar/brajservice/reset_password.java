package com.example.atulkumar.brajservice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class reset_password extends AppCompatActivity {

   private EditText passwordEmail;
  private   Button resetPassword;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);




            progressDialog= new ProgressDialog(this);
            passwordEmail = (EditText)findViewById(R.id.resetemail);
            resetPassword = (Button)findViewById(R.id.resetbtn);
            firebaseAuth = FirebaseAuth.getInstance();

            resetPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String useremail = passwordEmail.getText().toString().trim();

                    if(useremail.equals("")){
                        Toast.makeText(reset_password.this, "Please enter your registered email ID", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        progressDialog.setMessage("Please Wait A Second");
                        progressDialog.show();
                        firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    progressDialog.dismiss();
                                    Toast.makeText(reset_password.this, "Password reset email sent!", Toast.LENGTH_SHORT).show();
                                    finish();
                                    startActivity(new Intent(reset_password.this, MainActivity.class));
                                }else{
                                    progressDialog.dismiss();
                                    Toast.makeText(reset_password.this, "Error in sending password reset email", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });

        }

    }


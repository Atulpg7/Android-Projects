package com.example.atulkumar.brajservice;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private Button signup,forgot,login;
private EditText lname,lpass;
private FirebaseAuth auth;
    private ProgressDialog progressDialog;
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth=FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);

       FirebaseUser user=auth.getCurrentUser();

        if(user !=null)
        {
            finish();
            startActivity(new Intent(MainActivity.this,Main2.class));
        }

        signup=(Button) findViewById(R.id.create);
        forgot=(Button)findViewById(R.id.forget);
        login=(Button)findViewById(R.id.login);
       lname=(EditText) findViewById(R.id.loguser);
        lpass=(EditText) findViewById(R.id.logpass);

      login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(lname.getText().toString(),lpass.getText().toString());
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(MainActivity.this,reset_password.class);
                startActivity(obj);

            }
        });



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(MainActivity.this,Signup.class);
                startActivity(obj);
                finish();

            }
        });


    }

    private void validate(String name,String pass)
    {

        progressDialog.setMessage("Please Wait A Second");
        progressDialog.show();
        auth.signInWithEmailAndPassword(name,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {

                    progressDialog.dismiss();
                    //Toast.makeText(MainActivity.this,"Login Successfull" , Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(MainActivity.this,Main2.class));
                    checkEmailVerification();
                }
                else
                {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login Failed Try Again" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser=auth.getInstance().getCurrentUser();
        Boolean emailFlag=firebaseUser.isEmailVerified();

        if(emailFlag)
        {
            finish();
            startActivity(new Intent(MainActivity.this,Main2.class));

        }

        else
        {
            Toast.makeText(this, "Your Email Not Verified Yet !!", Toast.LENGTH_SHORT).show();
            auth.signOut();
        }
    }
}

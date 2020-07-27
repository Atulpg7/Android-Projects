package com.example.atulkumar.brajservice;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

Button login;
    private EditText name , email, pass,cpass;
    private Button create;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;
    String uname,uemail,upass,ucpass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setUp();
        auth= FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate())
                {
//Data Upload
                    String uemail=email.getText().toString().trim();
                    String upass=pass.getText().toString().trim();
                    progressDialog.setMessage("Please Wait A Second");
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                senddata();
                               sendEmailVerification();
                                auth.signOut();
                            }else{
                                progressDialog.dismiss();
                                Toast.makeText(Signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });

        login=(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent obj=new Intent(Signup.this,MainActivity.class);
                finish();
                startActivity(obj);

            }
        });

    }

    private void setUp()
    {
        name=(EditText) findViewById(R.id.user);
        email=(EditText) findViewById(R.id.uemail);
        pass=(EditText) findViewById(R.id.upass);
        cpass=(EditText) findViewById(R.id.cpass);
        create=(Button) findViewById(R.id.create);
    }


private boolean validate(){

    Boolean result=false;
    uname= name.getText().toString();
     uemail= email.getText().toString();
     upass= pass.getText().toString();
    ucpass=cpass.getText().toString();

    if(uname.isEmpty() && uemail.isEmpty() && upass.isEmpty() && ucpass.isEmpty())
    {
        Toast.makeText(Signup.this,"All Are Required",Toast.LENGTH_SHORT).show();
    }


 else if(uname.isEmpty())
    {

        name.setError("Name Required");
        name.requestFocus();

    }
   else  if (uemail.isEmpty())
    {
        email.setError("Email Required");
        email.requestFocus();
    }
   else if(!Patterns.EMAIL_ADDRESS.matcher(uemail).matches())
    {
        email.setError("Please Enter Valid Email");
        email.requestFocus();
    }
   else if (upass.isEmpty())
    {
        pass.setError("Password Required");
        pass.requestFocus();
    }
   else if(upass.length()<8){

        pass.setError("Minimun Length 8");
        pass.requestFocus();
    }
  else  if(!ucpass.equals(upass)){
        cpass.setError("Password Didn't Match");
        cpass.requestFocus();
    }



 else
 {

     result = true;
 }

return result;
}


public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Signup.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();

    }

    private void sendEmailVerification(){
        FirebaseUser firebaseUser=auth.getInstance().getCurrentUser();
        if(firebaseUser !=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful())
                    {

                        Toast.makeText(Signup.this,"Successfully Sent Verification Email !",Toast.LENGTH_LONG).show();
                        auth.signOut();
                        finish();
                        startActivity(new Intent(Signup.this,MainActivity.class));
                    }

                    else
                    {
                        Toast.makeText(Signup.this,"Email Not Verified ?",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void senddata()
    {

      FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
      DatabaseReference myRef=firebaseDatabase.getReference(auth.getUid());
       Userprofile userprofile=new Userprofile(uname,uemail);
      myRef.setValue(userprofile);
    }

    }


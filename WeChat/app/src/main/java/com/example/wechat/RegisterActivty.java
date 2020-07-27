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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivty extends AppCompatActivity {

    EditText email,password,fullname;
    TextView login;
    Button register;
    private FirebaseAuth auth;
    View parentLayout;

    ProgressDialog pd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        fullname=findViewById(R.id.fullname);
        register=findViewById(R.id.register);
        login=findViewById(R.id.txt_login);
        auth=FirebaseAuth.getInstance();

        //Snack Bar
        parentLayout = findViewById(android.R.id.content);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RegisterActivty.this,LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pd=new ProgressDialog(RegisterActivty.this);
                pd.setMessage("Please Wait...");
                pd.setCanceledOnTouchOutside(false);
                pd.setCancelable(false);

                String emailid=email.getText().toString();
                String pass=password.getText().toString();
                String fname=fullname.getText().toString();

                if (email.equals("")||pass.equals("")||fullname.equals(""))
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
                    Register(emailid,pass,fname);
                }
            }
        });





    }

    private void Register(final String emailid, final String pass,final String fname) {




        auth.createUserWithEmailAndPassword(emailid,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {

                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users")
                            .child(auth.getCurrentUser().getUid());

                    HashMap<String,Object> hashMap=new HashMap<>();
                    hashMap.put("name",fname);
                    hashMap.put("email",emailid);
                    hashMap.put("password",pass);

                    reference.setValue(hashMap);

                    pd.dismiss();
                    Intent intent=new Intent(RegisterActivty.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    pd.dismiss();
                    Snackbar.make(parentLayout,"Already registered..! ",Snackbar.LENGTH_SHORT).show();
                }


            }
        });
    }
}

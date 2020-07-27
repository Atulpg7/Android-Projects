package com.example.cleanchitkaraapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.theartofdev.edmodo.cropper.CropImage;

import org.w3c.dom.Text;

import java.util.HashMap;

public class PostActivity extends AppCompatActivity {

    Uri imgUri;
    String myUrl="";
    StorageTask uploadTask;
    StorageReference storageReference;

    ImageView close,image_added;
    TextView post;
    EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


        close=findViewById(R.id.close);
        image_added=findViewById(R.id.image_post);
        post=findViewById(R.id.txtpost);
        description=findViewById(R.id.description_post);

        storageReference= FirebaseStorage.getInstance().getReference().child("Posts");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(PostActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadImage();
            }
        });

        CropImage.activity()
                .setAspectRatio(1,1)
                .start(PostActivity.this);
    }




    private void uploadImage()
    {
        final ProgressDialog pd= new ProgressDialog(this);
        pd.setMessage("Posting...");
        pd.show();


        if (imgUri!=null)
        {

            String path= String.valueOf(imgUri);
            String extension = path.substring(path.lastIndexOf("."));
            final StorageReference filerefrence=storageReference.child(System.currentTimeMillis()+extension);

            uploadTask= filerefrence.putFile(imgUri);
            uploadTask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {

                    if (!task.isComplete())
                    {
                        throw task.getException();
                    }

                    return filerefrence.getDownloadUrl();

                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {


                    if (task.isSuccessful())
                    {
                        Uri dowanloadUri= task.getResult();

                        myUrl=dowanloadUri.toString();


                        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Posts");

                        String postid=reference.push().getKey();

                        HashMap<String, Object> hashMap=new HashMap<>();
                        hashMap.put("postid",postid);
                        hashMap.put("postimage",myUrl);
                        hashMap.put("description",description.getText().toString());
                        hashMap.put("publisher", FirebaseAuth.getInstance().getCurrentUser().getUid());


                        reference.child(postid).setValue(hashMap);
                        pd.dismiss();
                        Toast.makeText(PostActivity.this, "Post Sucessfull...", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(PostActivity.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    }

                    else
                    {
                        Toast.makeText(PostActivity.this, "Failed to upload !", Toast.LENGTH_SHORT).show();

                    }

                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
        else
        {

            Toast.makeText(this, "No Image Selected !!", Toast.LENGTH_SHORT).show();
            
        }
    }






    //Getting mage
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE&&
        resultCode==RESULT_OK)
        {
            CropImage.ActivityResult result=CropImage.getActivityResult(data);
            imgUri=result.getUri();

            image_added.setImageURI(imgUri);

        }
        else
        {
            Intent intent=new Intent(PostActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

        }
    }
}

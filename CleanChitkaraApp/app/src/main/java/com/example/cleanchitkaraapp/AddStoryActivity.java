package com.example.cleanchitkaraapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.HashMap;

public class AddStoryActivity extends AppCompatActivity {


    private Uri mImageUri;
    String myUrl="";
    private StorageTask storageTask;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story);


        storageReference= FirebaseStorage.getInstance().getReference("story");

        CropImage.activity()
                .setAspectRatio(9,16)
                .start(AddStoryActivity.this);
    }


    private void publishStory()
    {
        final ProgressDialog pd=new ProgressDialog(AddStoryActivity.this);
        pd.setMessage("Posting Story");
        pd.setCanceledOnTouchOutside(false);
        pd.setCancelable(false);
        pd.show();


        if (mImageUri!=null)
        {
            String path= String.valueOf(mImageUri);
            String extension = path.substring(path.lastIndexOf("."));
            final StorageReference imageReference=storageReference.child(System.currentTimeMillis()
            +"."+extension);


            storageTask=imageReference.putFile(mImageUri);
            storageTask.continueWithTask(new Continuation() {
                @Override
                public Task<Uri> then(@NonNull Task task) throws Exception {

                    if (!task.isSuccessful())
                    {
                        throw task.getException();
                    }

                    return imageReference.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {

                    if (task.isSuccessful())
                    {
                        Uri downloadUri=task.getResult();
                        myUrl=downloadUri.toString();


                        String myid= FirebaseAuth.getInstance().getCurrentUser().getUid();

                        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Story").child(myid);


                        String storyid=reference.push().getKey();
                        long timeend=System.currentTimeMillis()+86400000;

                        HashMap<String, Object> hashMap=new HashMap<>();
                        hashMap.put("imageurl",myUrl);
                        hashMap.put("timestart", ServerValue.TIMESTAMP);
                        hashMap.put("timeend",timeend);
                        hashMap.put("storyid",storyid);
                        hashMap.put("userid",myid);

                        reference.child(storyid).setValue(hashMap);
                        pd.dismiss();

                        Toast.makeText(AddStoryActivity.this, "Story Updated Sucessfull...", Toast.LENGTH_SHORT).show();
                        /*Intent intent=new Intent(AddStoryActivity.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);*/

                    }else
                    {

                        Toast.makeText(AddStoryActivity.this, "Failed to Upload!", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(AddStoryActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        {
            Toast.makeText(this, "No image Selected !", Toast.LENGTH_SHORT).show();
            
        }



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE&&
                resultCode==RESULT_OK)
        {
            CropImage.ActivityResult result=CropImage.getActivityResult(data);
            mImageUri=result.getUri();

            publishStory();

        }
        else
        {
            Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(AddStoryActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }


    }
}

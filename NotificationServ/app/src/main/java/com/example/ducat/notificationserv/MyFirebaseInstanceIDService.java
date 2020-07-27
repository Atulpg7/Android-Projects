package com.example.ducat.notificationserv;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import static android.content.ContentValues.TAG;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService
{

    @Override
    public void onTokenRefresh()
    {
    String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refresh token: "+refreshToken);
        sendRegistrationToServer(refreshToken);
    }

    public void sendRegistrationToServer(String token)
    {

    }


}

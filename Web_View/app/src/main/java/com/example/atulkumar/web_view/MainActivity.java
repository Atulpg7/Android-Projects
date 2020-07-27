package com.example.atulkumar.web_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webview;
    EditText et;
    Button btn,btnback,btnforward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    webview=findViewById(R.id.webview);
   et=findViewById(R.id.et);
   btn=findViewById(R.id.btn);
   btnback=findViewById(R.id.btnback);
   btnforward=findViewById(R.id.btnforward);

   btn.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {


           String http="https://";
           String website=et.getText().toString();
           String finalwebsite=http+website;
           webview.getSettings().setJavaScriptEnabled(true);
           webview.setWebViewClient(new WebViewClient());
           webview.loadUrl(finalwebsite);
           et.setText("");
           et.setHint("Enter Website");


       }
   });

   btnback.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           webview.goBack();
       }
   });

   btnforward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webview.goForward();
            }
        });


    }
}

package com.example.edu_app;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;


public class fire extends Activity {
	WebView br;
	ProgressBar pbr;
	String url= "http://www.google.com";
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fire); 
        
        String url=getIntent().getExtras().getString("urldata");
        br = (WebView) findViewById(R.id.webview);
        pbr = (ProgressBar) findViewById(R.id.progress1);
        
        br.setWebViewClient(new myWebClient());
        br.getSettings().setJavaScriptEnabled(true);
        br.getSettings().setSupportZoom(true);
      	br.getSettings().setBuiltInZoomControls(true);
      	br.getSettings().setTextZoom(90);
        br.loadUrl(url);
        	
        	
    	/*String url=getIntent().getExtras().getString("urldata");
        WebView br = (WebView) findViewById(R.id.webview);
        br.loadUrl(url);*/
}

	public class myWebClient extends WebViewClient
	{

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			pbr.setVisibility(View.GONE);
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}
		
		
	/*@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
	// TODO Auto-generated method stub
	super.onPageStarted(view, url, favicon);
	}

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
	// TODO Auto-generated method stub

	view.loadUrl(url);
	return true;

	}*/
	}

	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if((keyCode == KeyEvent.KEYCODE_BACK) && br.canGoBack())
		{
			br.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/*@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
	if ((keyCode == KeyEvent.KEYCODE_BACK) && br.canGoBack()) {
	br.goBack();
	return true;
	}
	return super.onKeyDown(keyCode, event);
	}
*/
	}

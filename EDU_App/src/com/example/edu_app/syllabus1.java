package com.example.edu_app;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.view.View.OnClickListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.view.Menu;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.Toast;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class syllabus1 extends Activity {	
	    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	    private Button startBtn;
	    private ProgressDialog mProgressDialog;
	    private Spinner spinner;
	    private static final String[]paths = {"item 1", "item 2", "item 3"};
	    @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.syllabus);
	ListView list = (ListView) findViewById(R.id.listView1);
	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
			syllabus1.this, R.layout.slider_row);
	arrayAdapter.add("News");
	arrayAdapter.add("Visited Company");
	arrayAdapter.add("Upcoming Company");
	arrayAdapter.add("Placement");
	arrayAdapter.add("Events");
	arrayAdapter.add("Workshop");
	arrayAdapter.add("Syllabus");
	arrayAdapter.add("Student Corner");
	arrayAdapter.add("Admin");
	arrayAdapter.add("About Us");
	
	list.setAdapter(arrayAdapter);
	list.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Toast.makeText(syllabus1.this, "Row " + arg2 + "clicked",
					Toast.LENGTH_LONG).show();
		}
	});
	startBtn = (Button)findViewById(R.id.startBtn);
    startBtn.setOnClickListener(new OnClickListener(){
        public void onClick(View v) {
            startDownload();
        }
    });

	    SlidingDrawer slider = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
		slider.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {

			}
		});
		slider.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {

			}
		});
	    }
private void startDownload() {
    String url = "http://farm1.static.flickr.com/114/298125983_0e4bf66782_b.jpg";
    new DownloadFileAsync().execute(url);
}
@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
	case DIALOG_DOWNLOAD_PROGRESS:
		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setMessage("Downloading file..");
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(false);
		mProgressDialog.show();
		return mProgressDialog;
	default:
		return null;
    }
}

class DownloadFileAsync extends AsyncTask<String, String, String> {

@Override
protected void onPreExecute() {
	super.onPreExecute();
	showDialog(DIALOG_DOWNLOAD_PROGRESS);
}

@Override
protected String doInBackground(String... aurl) {
	int count;

try {

URL url = new URL(aurl[0]);
URLConnection conexion = url.openConnection();
conexion.connect();

int lenghtOfFile = conexion.getContentLength();
Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

InputStream input = new BufferedInputStream(url.openStream());
OutputStream output = new FileOutputStream("/sdcard/some_photo_from_gdansk_poland.jpg");

byte data[] = new byte[1024];

long total = 0;

	while ((count = input.read(data)) != -1) {
		total += count;
		publishProgress(""+(int)((total*100)/lenghtOfFile));
		output.write(data, 0, count);
	}

	output.flush();
	output.close();
	input.close();
} catch (Exception e) {}
return null;

}
protected void onProgressUpdate(String... progress) {
	 Log.d("ANDRO_ASYNC",progress[0]);
	 mProgressDialog.setProgress(Integer.parseInt(progress[0]));
}

@Override
protected void onPostExecute(String unused) {
	dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
}
}
}

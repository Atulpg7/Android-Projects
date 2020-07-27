package com.example.edu_app;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
import android.app.AlertDialog;

import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Context;
import android.net.Uri;
import android.view.View.OnClickListener;
import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import android.view.Menu;
import android.net.NetworkInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.text.TextUtils.TruncateAt;

import android.widget.Spinner;


import com.example.edu_app.syllabus1.DownloadFileAsync;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;




public class timetable extends Activity {
	 public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
	    private ProgressDialog mProgressDialog;
	    private Spinner spinner;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable); 
}



public void btechfirstyear(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}

public void cs(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void me(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void ec(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void ce(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void ee(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mcs(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mec(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void men(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mme(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mee(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mce(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mca(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void mba(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void bba(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void bca(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void msc(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void bsc(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void bed(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void bcom(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void bph(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void dph(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void dcs(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}

public void mph(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
		//startDownload(url) ;
}
public void dce(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void dec(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
public void dee(View v)
{    	
	//String url = "http://student.gla.ac.in:8081/syllabus/B_Pharm.pdf";
		//startDownload(url) ;
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
}
private void startDownload(String url) {	     
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
OutputStream output = new FileOutputStream("/sdcard/Syllabus.pdf");
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


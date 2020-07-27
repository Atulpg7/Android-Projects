package com.example.quize;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.support.v4.app.NavUtils;
public class selectquiz extends Activity {
	 ImageView imageView;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectquiz); 
      
}

public void gk(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","GK");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
	
}

public void quant(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","QUANT");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
	
}

public void resoning(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","RESONING");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}

public void verbal(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","VERBAL");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();	
}

public void tech(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","TECH");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();	
}

public void english(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","ENGLISH");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}

public void dbms1(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","DBMS");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}
public void c(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","C");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}
public void c_plus(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","C_PLUS");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}
public void java(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","JAVA");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}
public void c_sharp(View v)
{
	new AlertDialog.Builder(this)
	.setTitle("Start Quiz")
	.setMessage("Do you want to attempt This Quiz ?")
	.setIcon(android.R.drawable.ic_dialog_alert)
	.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

	    public void onClick(DialogInterface dialog, int whichButton) {
	    	String name1=getIntent().getExtras().getString("attname");
	    	String rollno1=getIntent().getExtras().getString("roll");
	    	Intent i=new Intent(selectquiz.this,quiz_main.class );
	    	  i.putExtra("attname",name1.toString());
	    	  i.putExtra("roll",rollno1.toString());
	    	  i.putExtra("quiz","C_SHARP");
	    	startActivity(i);
	    }})
	 .setNegativeButton(android.R.string.no, null).show();
}
public void me(View v)
{
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
	
}
public void civ(View v)
{
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
	
}
public void ec(View v)
{
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
	
}
public void en(View v)
{
	new AlertDialog.Builder(this).setTitle("Message").setMessage("  Comming Soon !!!!!!").setNeutralButton("Close", null).show();
	
}



}


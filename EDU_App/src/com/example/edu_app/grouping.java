package com.example.edu_app;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.graphics.Color;
import android.widget.SimpleAdapter;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
public class grouping extends Activity {
	   private Spinner spinner;
	    ExpandableListView expandableListView;
	    ExpandableListAdapter expandableListAdapter;
	    List<String> expandableListTitle;
	    HashMap<String, List<String>> expandableListDetail;
@SuppressLint("NewApi")
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grouping);
    	expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = expendgroup.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext()," Wait........",
                        Toast.LENGTH_SHORT).show();        
              /*  if( expandableListTitle.get(groupPosition).equals("Student Corner")) 
    			{
    				 Intent myIntent = new Intent(MainActivity.this, home1.class);
    	             startActivityForResult(myIntent, 0);
    		    	 Intent i=new Intent(this,news1.class );
       //i.putExtra("attname",name.toString());
      // i.putExtra("roll",rollno.toString());
    startActivity(i);
    			}*/
                switch(groupPosition)
                {
                case 0:
                	
                	break;        
                case 1:
                	
                	 break;
                case 2:
                	// Intent myIntent3 = new Intent(grouping.this, home1.class);
    	            // startActivityForResult(myIntent3, 0);
                	break;
               
                }           
            }
        });

        expandableListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

        	 @Override
            public void onGroupCollapse(int groupPosition) {
              Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition)+ "collapse",Toast.LENGTH_SHORT).show(); 
     
            }
        });

     //   expandableListView.setOnChildClickListener(new OnChildClickListener() {
         //   @Override
           /* public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {*/
             
            	/*        	
            	 Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                                
                )
                        .show();*/

       /*    	 Toast.makeText(
                       getApplicationContext(),
                       groupPosition
                               + " -> "
                               + 
                           
                               childPosition, Toast.LENGTH_SHORT                          
               )
                       .show();
            }*/
        //});
    }

}

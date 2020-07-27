package com.example.atulkumar.context_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String names[];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names=getResources().getStringArray(R.array.names);
        listView=findViewById(R.id.listview);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);


        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //menu info :konsa select hua hai
        //view : kispe lagana hai
        //menue :conext menu
        menu.add("Delete");
        menu.add("Rename");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String title=item.getTitle().toString();

        switch (title)
        {
            case "Delete":
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                break;

            case "Rename":
                Toast.makeText(this, "Renamed", Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onContextItemSelected(item);
    }
}

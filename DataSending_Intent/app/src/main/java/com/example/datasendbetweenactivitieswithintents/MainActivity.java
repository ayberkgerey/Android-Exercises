package com.example.datasendbetweenactivitieswithintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView list;
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listViewNames);

        final ArrayList <String> names = new ArrayList<>();
        names.add("Ayberk");
        names.add("Jack");
        names.add("Sharon");
        names.add("Connor");
        names.add("Avery");
        names.add("Mike");


        adapter = new ArrayAdapter(this ,R.layout.item_names_layout,names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: "+ names.get(position));
                Toast.makeText(MainActivity.this,"Clicked on: "+ names.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , Second_Activity.class);
                intent.putExtra("name" , names.get(position));

                startActivity(intent);


            }
        });



    }
}

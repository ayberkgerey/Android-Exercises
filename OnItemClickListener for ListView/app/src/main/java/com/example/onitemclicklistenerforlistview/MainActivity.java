package com.example.onitemclicklistenerforlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.list);

        final ArrayList<String> names = new ArrayList<>();
        names.add("Shelby");
        names.add("Carol");
        names.add("Mathilda");
        names.add("Harrison");
        names.add("Viola");
        names.add("Hannah");

        adapter = new ArrayAdapter(this , R.layout.list_item_layout,names);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: " + names.get(position));
                Toast.makeText(MainActivity.this, names.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}

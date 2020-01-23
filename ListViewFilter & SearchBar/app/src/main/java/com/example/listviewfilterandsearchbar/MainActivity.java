package com.example.listviewfilterandsearchbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> cars = new ArrayList<>();
        cars.add("Mustang");
        cars.add("Chevelle");
        cars.add("Camaro");
        cars.add("Charger");
        cars.add("Satellite");
        cars.add("Superbee");
        cars.add("RoadRunner");
        cars.add("Duster");
        cars.add("DeVille");
        cars.add("Falcon");
        cars.add("Challanger");
        cars.add("Stingray");
        cars.add("Impala");
        cars.add("Delorian");
        cars.add("Belair");
        cars.add("Biarritz");
        cars.add("Nova");
        cars.add("Chevy");
        cars.add("Corvette");
        cars.add("GTO");
        cars.add("Gran Torino");
        cars.add("Thunderbolt");
        cars.add("GTX 440");
        cars.add("Firebird");

        ListView listView = (ListView) findViewById(R.id.listView);
        EditText theFilter = (EditText) findViewById(R.id.edittextSearch);


        adapter = new ArrayAdapter(this ,R.layout.list_item_layout,cars);
        listView.setAdapter(adapter);

       theFilter.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

              (MainActivity.this).adapter.getFilter().filter(charSequence);
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });

    }
}

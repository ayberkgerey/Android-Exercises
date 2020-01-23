package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView myListView = (ListView) findViewById(R.id.listviewOne);

    //Person objects
        Person mert = new Person("Mert","12-20-1997","Male");
        Person muco = new Person("Mucahit","06-13-1997","Male");
        Person john = new Person("Mert","12-20-1978","Male");
        Person mike = new Person("Mike","06-13-1945","Male");
        Person avery = new Person("Avery","07-06-1993","Male");
        Person connor = new Person("Connor","03-13-1996","Male");
        Person sarah = new Person("Sarah","09-20-2001","Female");
        Person anna = new Person("Anna","08-18-2002","Female");
        Person marry = new Person("Marry","12-20-2000","Female");
        Person ayberk = new Person("Ayberk","08-16-2000","Male");
        Person carol = new Person("Carol","08-18-1997","Female");
        Person philip = new Person("Philip","12-20-1967","Nale");
        Person jason = new Person("Jason","08-16-1991","Male");

        //add them in ArrayList
     ArrayList<Person> peopleList = new ArrayList<>();

        peopleList.add(mert);
        peopleList.add(muco);
        peopleList.add(john);
        peopleList.add(mike);
        peopleList.add(avery);
        peopleList.add(connor);
        peopleList.add(sarah);
        peopleList.add(anna);
        peopleList.add(marry);
        peopleList.add(ayberk);
        peopleList.add(carol);
        peopleList.add(philip);
        peopleList.add(jason);

        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_view_layout, peopleList);
        myListView.setAdapter(adapter);
    }
}

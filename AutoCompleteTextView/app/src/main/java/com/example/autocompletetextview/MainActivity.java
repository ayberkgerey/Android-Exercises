package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView actv;

    private static final String COUNTRIES[] = new String[]{
"Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia", "Austria", "Austrian Empire", "Azerbaijan",
"Baden", "Bahamas", "Bahrain ","Bangladesh ","Barbados","Bavaria","Belarus","Belgium","Belize","Benin (Dahomey)","Bolivia","Bosnia and Herzegovina","Botswana","Brazil",
"Brunei","Brunswick and Lüneburg","Bulgaria","Burkina Faso (Upper Volta)","Burma","Burundi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actv = findViewById(R.id.actv);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,COUNTRIES);

        actv.setAdapter(adapter);

    }
}

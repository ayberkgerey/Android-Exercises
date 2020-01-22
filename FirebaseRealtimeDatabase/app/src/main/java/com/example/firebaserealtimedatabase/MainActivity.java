package com.example.firebaserealtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonAdd;
    private Spinner spinnerGenres;

    DatabaseReference databaseArtist;

    void init(){
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAddArtist);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);

        databaseArtist = FirebaseDatabase.getInstance().getReference("artists");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void addArtist(){
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenres.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){

          String id = databaseArtist.push().getKey();

          Artist artist = new Artist(id,name,genre);

          databaseArtist.child(id).setValue(artist);

          Toast.makeText(this ,"Artist added", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Enter a name", Toast.LENGTH_LONG).show();
        }


    }


}

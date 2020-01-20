package com.example.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView emailTV;
    private Button logOutBtn, saveBtn ;
    private EditText editTextName , editTextAddress;

    private DatabaseReference databaseReference;



    private void init(){

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this , LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();

        emailTV = (TextView) findViewById(R.id.textViewUserEmail);
        logOutBtn = (Button) findViewById(R.id.buttonLogout);
        saveBtn = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);

        emailTV.setText("Welcome " + user.getEmail());

        logOutBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    @Override
    public void onClick(View v) {
        if( v == logOutBtn){
            firebaseAuth.signOut();
            startActivity(new Intent(this , LoginActivity.class));
            finish();
        }

        if(v == saveBtn){
            saveUserInformation();
        }
    }

    private void saveUserInformation(){
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name , address);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        //every user has a unique id
        databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this,"Information Saved",Toast.LENGTH_LONG).show();
    }

}

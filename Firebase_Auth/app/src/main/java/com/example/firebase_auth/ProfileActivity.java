package com.example.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView emailTV;
    private Button logOutBtn;

    private void init(){

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this , LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        emailTV = (TextView) findViewById(R.id.textViewUserEmail);
        logOutBtn = (Button) findViewById(R.id.buttonLogout);

        emailTV.setText("Welcome "+ user.getEmail());

        logOutBtn.setOnClickListener(this);

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
    }
}

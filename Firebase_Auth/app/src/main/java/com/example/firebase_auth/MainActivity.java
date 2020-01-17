package com.example.firebase_auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registerBtn;
    private EditText emailET , passwordET;
    private TextView textViewSignin;

    private void init(){
        registerBtn = (Button) findViewById(R.id.buttonRegister);
        emailET = (EditText) findViewById(R.id.editTextEmail);
        passwordET = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        registerBtn.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }


    @Override
    public void onClick(View v) {
        if(v == registerBtn){
            registerUser();
        }
        if(v == textViewSignin){
           //will open login place
        }

    }


    private void registerUser() {
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

    }

}

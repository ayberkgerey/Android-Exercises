package com.example.firebase_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailEditText , passwordEditText;
    private Button loginBtn;
    private TextView registerTextView;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    private void init(){

        emailEditText = (EditText) findViewById(R.id.editTextEmail);
        passwordEditText = (EditText)findViewById(R.id.editTextPassword);
        loginBtn = (Button) findViewById(R.id.buttonLogin);
        registerTextView = (TextView) findViewById(R.id.textViewSignup);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        loginBtn.setOnClickListener(this);
        registerTextView.setOnClickListener(this);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        if(firebaseAuth.getCurrentUser() != null){
            //profile activity here
            startActivity(new Intent(getApplicationContext() , ProfileActivity.class));
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        if(v == loginBtn){
            loginUser();
        }
        if(v == registerTextView){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }

    }


    private void loginUser() {

        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        //if validations are ok, we will first show a progressbar
        progressDialog.setMessage("Please wait");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()){
                    //start the profile Activity
                    startActivity(new Intent(getApplicationContext() , ProfileActivity.class));
                    finish();
                }

            }
        });
    }

}
package com.example.firebase_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registerBtn;
    private EditText emailET , passwordET;
    private TextView textViewSignin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    private void init(){
        registerBtn = (Button) findViewById(R.id.buttonRegister);
        emailET = (EditText) findViewById(R.id.editTextEmail);
        passwordET = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

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
        progressDialog.setMessage("Registering...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    //user successfully registered and logged in , we will start the new activity here.
                    Toast.makeText(MainActivity.this,"Registered Succesfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Could not registered, please try again",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}

package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName , mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.editTextName);
        mPassword = (EditText)findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.btnlogin);
        mCheckBox = (CheckBox) findViewById(R.id.remembercheckbox);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the checkbox preference
                if(mCheckBox.isChecked()){
                    mEditor.putString(getString(R.string.checkbox),"True");
                    mEditor.commit();

                    //save the name
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();

                    //save the password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();

                }else{
                    //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit();

                    //save the name
                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();

                    //save the password
                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();
                }
            }
        });

    }

    /**
     * check the shared preferences and set them accordingly
     */

    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox),"False");
        String name = mPreferences.getString(getString(R.string.name),"");
        String password = mPreferences.getString(getString(R.string.password),"");

        mName.setText(name);
        mPassword.setText(password);

        if(checkbox.equals("True")){
            mCheckBox.setChecked(true);
        }else{
            mCheckBox.setChecked(false);
        }

    }

}

package com.example.accesstocontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtInput = (EditText) this.findViewById(R.id.txtInput);
        final TextView nameNsurname = (TextView) this.findViewById(R.id.nameNsurname);
        Button btnSave = (Button) this.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameSurname = txtInput.getText().toString();
                nameNsurname.setText(nameSurname);
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
            }
        });

    }
}

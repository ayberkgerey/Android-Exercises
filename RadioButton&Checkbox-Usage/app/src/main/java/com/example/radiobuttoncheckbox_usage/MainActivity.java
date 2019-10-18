package com.example.radiobuttoncheckbox_usage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton rdoMr , rdoMrs;
    private CheckBox chckBox;
    private Button btnRegister;


    private void init()
    {
        rdoMr = (RadioButton) findViewById(R.id.rdoMr);
        rdoMrs = (RadioButton) findViewById(R.id.rdoMrs);
        chckBox = (CheckBox) findViewById(R.id.chckBox);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chckBox.isChecked()){

                    if(rdoMr.isChecked())
                        Toast.makeText(MainActivity.this,"Cinsiyet Bay , Kayıt Tamamlandı!",Toast.LENGTH_SHORT).show();
                    else if(rdoMrs.isChecked())
                        Toast.makeText(MainActivity.this,"Cinsiyet Bayan , Kayıt Tamamlandı!",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this,"Lütfen Cinsiyet Seçiniz",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Kullanım Koşullarını Kabul Etmelisiniz",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}

package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnOpen);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView1 = (WebView) findViewById(R.id.webview1);
                WebSettings webSettings = webView1.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webView1.loadUrl("https://github.com/ayberkgerey");


            }
        });

    }
}

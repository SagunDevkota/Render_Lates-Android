package com.sd2.latexhow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import ru.noties.jlatexmath.JLatexMathView;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    Button next;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    /*
    initialize all components and call latex function to add to webView
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        next = findViewById(R.id.button);
        LatexParser latex = new LatexParser();
        latex.setText(this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    webView.loadData(latex.getHtml(),"text/html","UTF-8");
            }
        });
    }
}
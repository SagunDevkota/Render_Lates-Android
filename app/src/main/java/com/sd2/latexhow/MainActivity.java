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
    ImageView iv;
    WebView webView;
    JLatexMathView mv2;
    Button next;
    int i = 0;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.imageView);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        mv2 = findViewById(R.id.j_latex_math_view);
        next = findViewById(R.id.button);
        LatexParser latex = new LatexParser();
        latex.setText("physics","1",this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    latex.setText(question[i]);
//                    String data = null;
//                    try {
//                        data = latex.getURL();
//                        Log.d("TAG", "onClick: "+latex);
//                    } catch (MalformedURLException | URISyntaxException e) {
//                        e.printStackTrace();
//                    }
//                    Glide.with(getApplicationContext())
//                            .load(data)
//                            .into(iv);
//                    Log.d("TAG", "onClick: "+data);
                    webView.loadData(latex.getHtml(),"text/html","UTF-8");
            }
        });
    }
}
package com.example.multipleactivitiesnovember12021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

public class Insights extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebClient());
        webView.loadUrl("https://github.com/mali-ai/Unit-Converter/graphs/commit-activity");
       // imageView = findViewById(R.id.imageView);
       // textView = findViewById(R.id.repoForks);
    }
}


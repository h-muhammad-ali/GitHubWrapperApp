package com.example.multipleactivitiesnovember12021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Insights extends AppCompatActivity {

    WebView commitView;
    WebView pulseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);
        commitView = findViewById(R.id.pulseView);
        commitView.getSettings().setJavaScriptEnabled(true);
        commitView.setWebViewClient(new PulseView());
        commitView.loadUrl("https://github.com/mali-ai/Unit-Converter/pulse/monthly");
        commitView = findViewById(R.id.commitView);
        commitView.getSettings().setJavaScriptEnabled(true);
        commitView.setWebViewClient(new CommitView());
        commitView.loadUrl("https://github.com/mali-ai/Unit-Converter/graphs/commit-activity");
    }
}


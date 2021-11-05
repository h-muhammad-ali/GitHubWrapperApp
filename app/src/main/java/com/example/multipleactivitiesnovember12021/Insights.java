package com.example.multipleactivitiesnovember12021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Insights extends AppCompatActivity {

    WebView commitView;
    WebView pulseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        String repo = intent.getStringExtra("repoName");
        setContentView(R.layout.activity_insights);
        pulseView = findViewById(R.id.pulseView);
        pulseView.getSettings().setJavaScriptEnabled(true);
        pulseView.setWebViewClient(new PulseView());
        pulseView.loadUrl("https://github.com/" + user + "/" + repo + "/pulse/monthly");
        commitView = findViewById(R.id.commitView);
        commitView.getSettings().setJavaScriptEnabled(true);
        commitView.setWebViewClient(new CommitView());
        commitView.loadUrl("https://github.com/" + user + "/" + repo + "/graphs/commit-activity");
    }
}


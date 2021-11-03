package com.example.multipleactivitiesnovember12021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<RepoModel> repos = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Github Repositories");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rc_view1);
        GithubReposDataService githubReposDataService = new GithubReposDataService(this);
        githubReposDataService.getMyRepos(new GithubReposDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<RepoModel> response) {
                repos = response;
                //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                RepoAdapter repoAdapter = new RepoAdapter(MainActivity.this, repos);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                // in below two lines we are setting layoutmanager and adapter to our recycler view.
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(repoAdapter);
            }
        });
    }


}
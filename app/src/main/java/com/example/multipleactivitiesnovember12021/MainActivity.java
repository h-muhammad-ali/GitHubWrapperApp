package com.example.multipleactivitiesnovember12021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
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
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Github Repositories");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rc_view1);
//        searchView = findViewById(R.id.search);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                GithubReposDataService githubReposDataService = new GithubReposDataService(MainActivity.this, query);
//                githubReposDataService.getMyRepos(new GithubReposDataService.VolleyResponseListener() {
//                    @Override
//                    public void onError(String message) {
//                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onResponse(List<RepoModel> response) {
//                        repos = response;
//                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
//                        RepoAdapter repoAdapter = new RepoAdapter(MainActivity.this, repos, query);
//                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
//                        // in below two lines we are setting layoutmanager and adapter to our recycler view.
//                        recyclerView.setLayoutManager(linearLayoutManager);
//                        recyclerView.setAdapter(repoAdapter);
//                    }
//                });
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                //    adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        MenuItem myActionMenuItem = menu.findItem( R.id.search);
        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                GithubReposDataService githubReposDataService = new GithubReposDataService(MainActivity.this, query);
                githubReposDataService.getMyRepos(new GithubReposDataService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(List<RepoModel> response) {
                        repos = response;
                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        RepoAdapter repoAdapter = new RepoAdapter(MainActivity.this, repos, query);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                        // in below two lines we are setting layoutmanager and adapter to our recycler view.
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(repoAdapter);
                    }
                });
                myActionMenuItem.collapseActionView();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                // UserFeedback.show( "SearchOnQueryTextChanged: " + s);
                return false;
            }
        });
        return true;
    }

}
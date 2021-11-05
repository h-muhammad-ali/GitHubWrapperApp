package com.example.multipleactivitiesnovember12021;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class GithubReposDataService {

    String url = "https://api.github.com/users/";
    Context context;

    public GithubReposDataService(Context context) {
        this.context = context;
    }

    public GithubReposDataService(Context context, String username) {
        this.context = context;
        url = url + username +"/repos";
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(List<RepoModel> response);
    }

    public void getMyRepos(VolleyResponseListener volleyResponseListener) {
        String url = this.url;
        List<RepoModel> reposInfo = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(context, String.valueOf(response.length()), Toast.LENGTH_SHORT).show();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject repo = response.getJSONObject(i);

                                RepoModel repoModel = new RepoModel(repo.getString("name"), repo.getString("clone_url"), repo.getInt("forks"), repo.getInt("watchers"), repo.getInt("open_issues"));
                                reposInfo.add(repoModel);
                            } catch (JSONException e) {
                                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        //Toast.makeText(context, reposInfo.toString(), Toast.LENGTH_SHORT).show();
                        volleyResponseListener.onResponse(reposInfo);
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                                volleyResponseListener.onError(error.getMessage());
                            }
                        });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
        //return reposInfo;
    }
}

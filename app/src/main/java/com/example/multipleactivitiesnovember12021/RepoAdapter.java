package com.example.multipleactivitiesnovember12021;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.Viewholder> {

    private Context context;
    private List<RepoModel> repos;

    public RepoAdapter(Context context, List<RepoModel> repos) {
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public RepoAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        RepoModel model = repos.get(position);
        holder.repoName.setText(model.getName());
        holder.repoForks.setText(String.valueOf(model.getForks()));
        holder.repoWatchers.setText(String.valueOf(model.getWatchers()));
        holder.repoIssues.setText(String.valueOf(model.getIssues()));
        //holder.courseIV.setImageResource(model.getCourse_image());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        //private ImageView courseIV;
        private TextView repoName;
        private TextView repoForks;
        private TextView repoWatchers;
        private TextView repoIssues;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            repoName = itemView.findViewById(R.id.repoName);
            repoForks = itemView.findViewById(R.id.repoForks);
            repoWatchers = itemView.findViewById(R.id.repoWatchers);
            repoIssues = itemView.findViewById(R.id.repoIssues);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //openWebPage(repoURL.getText().toString());
                    Intent myIntent = new Intent(view.getContext(), Insights.class);
                    //myIntent.putExtra("key", value); //Optional parameters
                    view.getContext().startActivity(myIntent);
                }
            });
        }
        public void openWebPage(String link) {
            try {
                Uri webpage = Uri.parse(link);
                Intent myIntent = new Intent(Intent.ACTION_VIEW, webpage);
                itemView.getContext().startActivity(myIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(context, "No application can handle this request. Please install a web browser or check your URL.",  Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }


    }
}


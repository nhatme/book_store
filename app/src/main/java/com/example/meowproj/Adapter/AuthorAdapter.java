package com.example.meowproj.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.Author;
import com.example.meowproj.R;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {

    private List<Author> authorList;

    public void setData(List<Author> authorList) {
        this.authorList = authorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_author, parent, false);
        return new AuthorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        Author author = authorList.get(position);
        if (author == null) {
            return;
        }

        holder.imageView.setImageResource(author.getResourceId());
        holder.author_name.setText(author.getAuthor_name());
        holder.author_Occup.setText(author.getAuthor_Occup());
    }

    @Override
    public int getItemCount() {
        if (authorList != null) {
            return authorList.size();
        }
        return 0;
    }

    public class AuthorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView author_name, author_Occup;

        public AuthorViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.author_img);
            author_name = itemView.findViewById(R.id.author_name);
            author_Occup = itemView.findViewById(R.id.author_Occup);
        }
    }
}

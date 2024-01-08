package com.example.meowproj.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.Author;
import com.example.meowproj.databinding.ActivityHomeAuthorBinding;

import java.util.List;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder> {
    private ActivityHomeAuthorBinding binding;
    private List<Author> authorList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Author author);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<Author> authorList) {
        this.authorList = authorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ActivityHomeAuthorBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new AuthorViewHolder(binding);
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

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(author);
                }
            }
        });
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

        public AuthorViewHolder(@NonNull ActivityHomeAuthorBinding binding) {
            super(binding.getRoot());
            imageView = binding.authorImg;
            author_name = binding.authorName;
            author_Occup = binding.authorOccup;
        }
    }
}

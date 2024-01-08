package com.example.meowproj.ui.AuthorDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.Author;
import com.example.meowproj.databinding.AuthorItemListBinding;

import java.util.List;

public class AuthorItemListAdapter extends RecyclerView.Adapter<AuthorItemListAdapter.AuthorItemListViewHolder> {
    private AuthorItemListBinding binding;
    private List<Author> mAuthorList;
    private Context context;

    public AuthorItemListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Author> mAuthorList) {
        this.mAuthorList = mAuthorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AuthorItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = AuthorItemListBinding.inflate(inflater, parent, false);
        return new AuthorItemListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorItemListViewHolder holder, int position) {
        Author author = mAuthorList.get(position);
        if (mAuthorList == null) {
            return;
        }
        holder.authorImg.setImageResource(author.getResourceId());
        holder.authorName.setText(author.getAuthor_name());
        holder.authorDescription.setText(author.getDescription());
    }

    @Override
    public int getItemCount() {
        if (mAuthorList != null) {
            return mAuthorList.size();
        }
        return 0;
    }

    public class AuthorItemListViewHolder extends RecyclerView.ViewHolder {
        private ImageView authorImg;
        private TextView authorName, authorDescription;

        public AuthorItemListViewHolder(@NonNull AuthorItemListBinding binding) {
            super(binding.getRoot());
            authorImg = binding.authorImg;
            authorName = binding.tvAuthor;
            authorDescription = binding.tvDescription;
        }
    }
}

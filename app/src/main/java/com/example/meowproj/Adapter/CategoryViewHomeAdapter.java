package com.example.meowproj.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.CategoryViewHome;
import com.example.meowproj.R;

import java.util.List;

public class CategoryViewHomeAdapter extends RecyclerView.Adapter<CategoryViewHomeAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<CategoryViewHome> mCategoryListViewHome;

    public CategoryViewHomeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<CategoryViewHome> list) {
        this.mCategoryListViewHome = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryViewHome categoryViewHome = mCategoryListViewHome.get(position);
        if (categoryViewHome == null) {
            return;
        }

        holder.rcvTopWeek.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        holder.rcvVendor.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        holder.rcvAuthor.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));

        TopWeekAdapter topWeekAdapter = new TopWeekAdapter();
        topWeekAdapter.setData(categoryViewHome.getTopWeekList());

        VendorAdapter vendorAdapter = new VendorAdapter();
        vendorAdapter.setData(categoryViewHome.getVendorList());

        AuthorAdapter authorAdapter = new AuthorAdapter();
        authorAdapter.setData(categoryViewHome.getAuthorList());

        holder.rcvTopWeek.setAdapter(topWeekAdapter);
        holder.rcvVendor.setAdapter(vendorAdapter);
        holder.rcvAuthor.setAdapter(authorAdapter);
    }

    @Override
    public int getItemCount() {
        if (mCategoryListViewHome != null) {
            return mCategoryListViewHome.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rcvTopWeek, rcvVendor, rcvAuthor;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            rcvTopWeek = itemView.findViewById(R.id.rcv_top_week);
            rcvVendor = itemView.findViewById(R.id.rcv_vendors);
            rcvAuthor = itemView.findViewById(R.id.rcv_authors);
        }
    }
}
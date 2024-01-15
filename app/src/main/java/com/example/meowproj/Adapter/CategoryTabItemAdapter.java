package com.example.meowproj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ItemCategoryBinding;

import java.util.List;

public class CategoryTabItemAdapter extends RecyclerView.Adapter<CategoryTabItemAdapter.CategoryTabItemViewHolder> {
    private ItemCategoryBinding binding;
    private Context mContext;
    private List<ItemBook> mListBook;

    public CategoryTabItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<ItemBook> mListBook) {
        this.mListBook = mListBook;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryTabItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemCategoryBinding.inflate(inflater, parent, false);
        return new CategoryTabItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryTabItemViewHolder holder, int position) {
        ItemBook itemBook = mListBook.get(position);
        if (itemBook == null) {
            return;
        }
        holder.imgProd.setImageResource(itemBook.getResourceId());
        holder.nameProd.setText(itemBook.getTitle());
        holder.priceProd.setText(itemBook.getPrice());
    }

    @Override
    public int getItemCount() {
        if (mListBook != null) {
            return mListBook.size();
        }
        return 0;
    }

    public class CategoryTabItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProd;
        private TextView nameProd, priceProd;

        public CategoryTabItemViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            imgProd = binding.imgCategory;
            nameProd = binding.categoryNameProd;
            priceProd = binding.categoryPriceProd;

        }
    }
}

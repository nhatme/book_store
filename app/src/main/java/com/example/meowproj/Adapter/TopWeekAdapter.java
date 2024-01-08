package com.example.meowproj.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityHomeTopWeekBinding;

import java.util.List;

public class TopWeekAdapter extends RecyclerView.Adapter<TopWeekAdapter.TopWeekViewHolder> {
    private ActivityHomeTopWeekBinding binding;
    private List<ItemBook> mItemBooks;
    private OnItemClickListener mItemClickListener;

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(ItemBook item);
    }

    // Method to set the click listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public void setData(List<ItemBook> list) {
        this.mItemBooks = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopWeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ActivityHomeTopWeekBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TopWeekViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopWeekViewHolder holder, int position) {
        ItemBook itemBook = mItemBooks.get(position);
        if (itemBook == null) {
            return;
        }

        holder.imgItem.setImageResource(itemBook.getResourceId());
        holder.tvTitle.setText(itemBook.getTitle());
        holder.tvPrice.setText(itemBook.getPrice());

        // Set click listener on the item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(itemBook);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mItemBooks != null) {
            return mItemBooks.size();
        }
        return 0;
    }

    public class TopWeekViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView tvTitle, tvPrice;

        public TopWeekViewHolder(@NonNull ActivityHomeTopWeekBinding binding) {
            super(binding.getRoot());
            imgItem = binding.itemImg;
            tvTitle = binding.itemTitle;
            tvPrice = binding.itemPrice;
        }
    }
}

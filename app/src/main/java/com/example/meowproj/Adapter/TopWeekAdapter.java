package com.example.meowproj.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meowproj.HomeScreen.BottomNavigation.HomeScreen;
import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.databinding.ActivityHomeTopWeekBinding;

import java.util.List;

public class TopWeekAdapter extends RecyclerView.Adapter<TopWeekAdapter.TopWeekViewHolder> {
    private Context context;
    private ActivityHomeTopWeekBinding binding;
    private List<ItemBook> mItemBooks;
    private OnItemClickListener mItemClickListener;

    public TopWeekAdapter(Context context) {
        this.context = context;
    }

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(ItemBook item, String itemId);
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
        final ItemBook itemBook = mItemBooks.get(position);
        if (itemBook == null) {
            return;
        }

        //Log.e("NHATEEE", "http://10.0.2.2:3002/" + itemBook.getImage());
        //Log.e("NHATEEE", itemBook.getId());

        if (context != null) {
            String imageUrl = "https://api-book-store-78sd.onrender.com/" + itemBook.getImage();
            Glide.with(context).load(imageUrl).into(holder.imgItem);
        } else {
            Log.e("NHATEEEEEE", "Seem like context wrong");
        }
        holder.tvTitle.setText(itemBook.getTitle());
        holder.tvPrice.setText(itemBook.getPrice());

        // Set click listener on the item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(itemBook, itemBook.getId());
                    Log.e("NHATEEE", itemBook.getId());
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

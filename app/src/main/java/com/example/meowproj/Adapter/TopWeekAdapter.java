package com.example.meowproj.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.R;

import java.util.List;

public class TopWeekAdapter extends RecyclerView.Adapter<TopWeekAdapter.TopWeekViewHolder> {
    private List<ItemBook> mItemBooks;

    public void setData(List<ItemBook> list) {
        this.mItemBooks = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopWeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_top_week, parent, false);
        return new TopWeekViewHolder(view);
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

        public TopWeekViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.item_img);
            tvTitle = itemView.findViewById(R.id.item_title);
            tvPrice = itemView.findViewById(R.id.item_price);
        }
    }
}

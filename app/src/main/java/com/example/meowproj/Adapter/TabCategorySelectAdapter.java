package com.example.meowproj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.R;

public class TabCategorySelectAdapter extends RecyclerView.Adapter<TabCategorySelectAdapter.TabCategorySelectViewHolder> {
    private Context context;
    private String[] selectedList;

    public TabCategorySelectAdapter(Context context) {
        this.context = context;
    }

    public void setData(String[] selectedList) {
        this.selectedList = selectedList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TabCategorySelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_category_selected, parent, false);
        return new TabCategorySelectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabCategorySelectViewHolder holder, int position) {
        String sof = selectedList[position];
        if (sof == null) {
            return;
        }
        holder.nameSelected.setText(sof);
    }

    @Override
    public int getItemCount() {
        if (selectedList != null) {
            return selectedList.length;
        }
        return 0;
    }

    public class TabCategorySelectViewHolder extends RecyclerView.ViewHolder {
        private TextView nameSelected;

        public TabCategorySelectViewHolder(@NonNull View itemView) {
            super(itemView);
            nameSelected = itemView.findViewById(R.id.tvCategorySelected);
        }
    }
}

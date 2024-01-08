package com.example.meowproj.ui.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.databinding.TabLayoutBinding;

public class TabLayoutAdapter extends RecyclerView.Adapter<TabLayoutAdapter.TabCategorySelectViewHolder> {
    private Context context;
    private String[] selectedList;
    private TabLayoutBinding binding;

    public TabLayoutAdapter(Context context) {
        this.context = context;
    }

    public void setData(String[] selectedList) {
        this.selectedList = selectedList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TabCategorySelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = TabLayoutBinding.inflate(inflater, parent, false);
        return new TabCategorySelectViewHolder(binding);
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

        public TabCategorySelectViewHolder(@NonNull TabLayoutBinding binding) {
            super(binding.getRoot());
            nameSelected = binding.tvTab;
        }
    }
}

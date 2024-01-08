package com.example.meowproj.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.Vendor;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityHomeVendorBinding;

import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.VendorViewHolder> {
    private ActivityHomeVendorBinding binding;
    private List<Vendor> vendorList;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Vendor vendor);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<Vendor> vendorList) {
        this.vendorList = vendorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ActivityHomeVendorBinding.inflate(inflater, parent, false);
        return new VendorViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        Vendor vendor = vendorList.get(position);
        if (vendor == null) {
            return;
        }

        holder.imageView.setImageResource(vendor.getResourceId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(vendor);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (vendorList != null) {
            return vendorList.size();
        }
        return 0;
    }

    public class VendorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public VendorViewHolder(@NonNull ActivityHomeVendorBinding binding) {
            super(binding.getRoot());
            imageView = binding.logoVendor;
        }
    }
}

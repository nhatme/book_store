package com.example.meowproj.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.Vendor;
import com.example.meowproj.R;

import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.VendorViewHolder> {
    private List<Vendor> vendorList;

    public void setData(List<Vendor> vendorList) {
        this.vendorList = vendorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VendorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_vendor, parent, false);
        return new VendorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorViewHolder holder, int position) {
        Vendor vendor = vendorList.get(position);
        if (vendor == null) {
            return;
        }

        holder.imageView.setImageResource(vendor.getResourceId());
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

        public VendorViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.logo_vendor);
        }
    }
}

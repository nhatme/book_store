package com.example.meowproj.ui.VendorDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.databinding.VendorItemGridMoreBinding;

import java.util.List;

public class VendorGridAdapter extends RecyclerView.Adapter<VendorGridAdapter.VendorGridViewHolder> {

    private VendorItemGridMoreBinding binding;
    private List<VendorsItem> mVendorsItems;
    private Context context;

    public VendorGridAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<VendorsItem> mVendorsItems) {
        this.mVendorsItems = mVendorsItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VendorGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = VendorItemGridMoreBinding.inflate(inflater, parent, false);
        return new VendorGridViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorGridViewHolder holder, int position) {
        VendorsItem vendorsItem = mVendorsItems.get(position);
        if (vendorsItem == null) {
            return;
        }
        holder.logoVendor.setImageResource(vendorsItem.getResourceId());
        holder.vendorName.setText(vendorsItem.getNameVendor());
        setReview(holder, vendorsItem.getReview(), vendorsItem.getBlackStarId(), vendorsItem.getFilledStarId());
    }

    public void setReview(@NonNull VendorGridViewHolder holder, int review, int blackStar, int filledStar) {
        ImageView[] stars = {holder.star1, holder.star2, holder.star3, holder.star4, holder.star5};

        for (int i = 0; i < stars.length; i++) {
            stars[i].setImageResource(i < review ? filledStar : blackStar);
        }
    }

    @Override
    public int getItemCount() {
        if (mVendorsItems != null) return mVendorsItems.size();
        return 0;
    }

    public class VendorGridViewHolder extends RecyclerView.ViewHolder {
        private ImageView logoVendor, star1, star2, star3, star4, star5;
        private TextView vendorName;

        public VendorGridViewHolder(@NonNull VendorItemGridMoreBinding binding) {
            super(binding.getRoot());
            logoVendor = binding.logoVendor;
            star1 = binding.star1;
            star2 = binding.star2;
            star3 = binding.star3;
            star4 = binding.star4;
            star5 = binding.star5;
            vendorName = binding.vendorName;
        }
    }
}

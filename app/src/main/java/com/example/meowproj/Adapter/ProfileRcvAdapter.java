package com.example.meowproj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.ProfileRcv;
import com.example.meowproj.databinding.ProfileFolderBinding;

import java.util.List;

public class ProfileRcvAdapter extends RecyclerView.Adapter<ProfileRcvAdapter.ProfileRcvViewHolder> {
    private List<ProfileRcv> mProfileFolderList;
    private Context context;

    public ProfileRcvAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ProfileRcv> mProfileFolderList) {
        this.mProfileFolderList = mProfileFolderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProfileRcvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProfileFolderBinding binding = ProfileFolderBinding.inflate(inflater, parent, false);
        return new ProfileRcvViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileRcvViewHolder holder, int position) {
        ProfileRcv profileRcv = mProfileFolderList.get(position);
        if (mProfileFolderList == null) {
            return;
        }
        holder.icImg.setImageResource(profileRcv.getIcProfileId());
        holder.icRight.setImageResource(profileRcv.getIcRightId());
        holder.nameFolder.setText(profileRcv.getNameFolder());
    }

    @Override
    public int getItemCount() {
        if (mProfileFolderList != null) {
            return mProfileFolderList.size();
        }
        return 0;
    }

    public class ProfileRcvViewHolder extends RecyclerView.ViewHolder {
        private ProfileFolderBinding binding;
        private ImageView icImg, icRight;
        private TextView nameFolder;

        public ProfileRcvViewHolder(@NonNull ProfileFolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            icImg = binding.profileFolderIcon;
            icRight = binding.profileFolderIconRight;
            nameFolder = binding.profileFolderName;
        }
    }
}

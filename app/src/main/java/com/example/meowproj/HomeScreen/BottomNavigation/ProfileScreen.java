package com.example.meowproj.HomeScreen.BottomNavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Adapter.ProfileRcvAdapter;
import com.example.meowproj.Model.ProfileRcv;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class ProfileScreen extends Fragment {
    private ActivityProfileBinding binding;
    private ProfileRcvAdapter profileRcvAdapter;
    public ProfileScreen() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityProfileBinding.inflate(inflater, container, false);

        profileRcvAdapter = new ProfileRcvAdapter(getActivity());
        binding.profileFolderRcv.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        profileRcvAdapter.setData(getListProfileFolder());
        binding.profileFolderRcv.setAdapter(profileRcvAdapter);

        return binding.getRoot();
    }

    private List<ProfileRcv> getListProfileFolder() {
        List<ProfileRcv> profileRcvList = new ArrayList<>();

        profileRcvList.add(new ProfileRcv(R.drawable.ic_profile, R.drawable.ic_right_rounded, "My Account"));
        profileRcvList.add(new ProfileRcv(R.drawable.ic_location, R.drawable.ic_right_rounded, "Address"));
        profileRcvList.add(new ProfileRcv(R.drawable.ic_fire, R.drawable.ic_right_rounded, "Offers & Promos"));
        profileRcvList.add(new ProfileRcv(R.drawable.ic_heart, R.drawable.ic_right_rounded, "Your Favorites"));
        profileRcvList.add(new ProfileRcv(R.drawable.ic_document, R.drawable.ic_right_rounded, "Order History"));
        profileRcvList.add(new ProfileRcv(R.drawable.ic_chat, R.drawable.ic_right_rounded, "Help Center"));

        return profileRcvList;
    }

}

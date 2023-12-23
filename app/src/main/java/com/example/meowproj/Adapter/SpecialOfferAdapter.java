package com.example.meowproj.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.meowproj.HomeScreen.special_offer1;
import com.example.meowproj.HomeScreen.special_offer2;
import com.example.meowproj.HomeScreen.special_offer3;

public class SpecialOfferAdapter extends FragmentStateAdapter {
    public SpecialOfferAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new special_offer1();
            case 1:
                return new special_offer2();
            case 2:
                return new special_offer3();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

package com.example.meowproj.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.meowproj.HomeScreen.BottomNavigation.CartScreen;
import com.example.meowproj.HomeScreen.BottomNavigation.CategoryScreen;
import com.example.meowproj.HomeScreen.BottomNavigation.HomeScreen;
import com.example.meowproj.HomeScreen.BottomNavigation.ProfileScreen;

public class BottomNavAdapter extends FragmentStateAdapter {

    public BottomNavAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeScreen();
            case 1:
                return new CategoryScreen();
            case 2:
                return new CartScreen();
            case 3:
                return new ProfileScreen();
            default:
                return new HomeScreen();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

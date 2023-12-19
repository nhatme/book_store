package com.example.meowproj.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.meowproj.Onboarding.Fragment.onboarding1Fragment;
import com.example.meowproj.Onboarding.Fragment.onboarding2Fragment;
import com.example.meowproj.Onboarding.Fragment.onboarding3Fragment;

public class OnboardingAdapter extends FragmentStatePagerAdapter {
    public OnboardingAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new onboarding1Fragment();
            case 1:
                return new onboarding2Fragment();
            case 2:
                return new onboarding3Fragment();
            default:
                return new onboarding1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

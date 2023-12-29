package com.example.meowproj.HomeScreen;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.meowproj.Adapter.BottomNavAdapter;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityViewpagerHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

public class ViewPagerHome extends AppCompatActivity {
    private ActivityViewpagerHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewpagerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setStatusBarAppearance();

        BottomNavAdapter bottomNavAdapter = new BottomNavAdapter(this);
        binding.viewpagerBottomNavigationView.setAdapter(bottomNavAdapter);

        binding.viewpagerBottomNavigationView.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        binding.bottomViewNav.getMenu().findItem(R.id.action_home).setChecked(true);
                        binding.titleTab.setText(getResources().getText(R.string.home));
                        break;
                    case 1:
                        binding.bottomViewNav.getMenu().findItem(R.id.action_category).setChecked(true);
                        binding.titleTab.setText(getResources().getText(R.string.category));
                        break;
                    case 2:
                        binding.bottomViewNav.getMenu().findItem(R.id.action_cart).setChecked(true);
                        binding.titleTab.setText(getResources().getText(R.string.cart));
                        break;
                    case 3:
                        binding.bottomViewNav.getMenu().findItem(R.id.action_profile).setChecked(true);
                        binding.titleTab.setText(getResources().getText(R.string.profile));
                        break;
                }
            }
        });

        binding.bottomViewNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.action_home) {
                binding.viewpagerBottomNavigationView.setCurrentItem(0);
                binding.titleTab.setText(getResources().getText(R.string.home));
            } else if (itemId == R.id.action_category) {
                binding.viewpagerBottomNavigationView.setCurrentItem(1);
                binding.titleTab.setText(getResources().getText(R.string.category));
            } else if (itemId == R.id.action_cart) {
                binding.viewpagerBottomNavigationView.setCurrentItem(2);
                binding.titleTab.setText(getResources().getText(R.string.cart));
            } else if (itemId == R.id.action_profile) {
                binding.viewpagerBottomNavigationView.setCurrentItem(3);
                binding.titleTab.setText(getResources().getText(R.string.profile));
            }
            return true;
        });
    }

    public void setStatusBarAppearance() {
        ActionBar actBar = getSupportActionBar();
        if (actBar != null) {
            actBar.hide();
        }

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color._gray_50));
    }
}

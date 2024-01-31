package com.example.meowproj.HomeScreen;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.meowproj.HomeScreen.BottomNavigation.CartScreen;
import com.example.meowproj.HomeScreen.BottomNavigation.CategoryScreen;
import com.example.meowproj.HomeScreen.BottomNavigation.HomeScreen;
import com.example.meowproj.HomeScreen.BottomNavigation.ProfileScreen;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityViewpagerHomeBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityViewpagerHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewpagerHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setStatusBarAppearance();
        replaceFragment(new HomeScreen());

        binding.bottomViewNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.action_home) {
                replaceFragment(new HomeScreen());
                binding.titleTab.setText(getResources().getText(R.string.home));
            } else if (itemId == R.id.action_category) {
                replaceFragment(new CategoryScreen());
                binding.titleTab.setText(getResources().getText(R.string.category));
            } else if (itemId == R.id.action_cart) {
                replaceFragment(new CartScreen());
                binding.titleTab.setText(getResources().getText(R.string.cart));
            } else if (itemId == R.id.action_profile) {
                replaceFragment(new ProfileScreen());
                binding.titleTab.setText(getResources().getText(R.string.profile));
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceFragmentFullPage(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(
                R.anim.slide_in_right,  // enter
                R.anim.slide_out_left,  // exit
                R.anim.slide_in_left,   // popEnter
                R.anim.slide_out_right  // popExit
        );
        fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment); // the id is where layout do you want to replace ?
        fragmentTransaction.commit();
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

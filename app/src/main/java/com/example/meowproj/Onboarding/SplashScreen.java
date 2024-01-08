package com.example.meowproj.Onboarding;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.meowproj.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        setStatusBarAppearance();
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, Onboarding.class);
            startActivity(intent);
            finish();
        }, 800);
    }

    public void setStatusBarAppearance() {
        ActionBar actBar = getSupportActionBar();
        if (actBar != null) {
            actBar.hide();
        }

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color._primary_500));
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color._primary_500));
    }
}
package com.example.meowproj.Onboarding;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.meowproj.Adapter.OnboardingAdapter;
import com.example.meowproj.Account.Signin;
import com.example.meowproj.R;

import me.relex.circleindicator.CircleIndicator;

public class Onboarding extends AppCompatActivity {

    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private Button btnNext, btnSignin, btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        setStatusBarAppearance();
        onBoardingFragment();
        nextToSigninScreen();
    }

    private void nextToSigninScreen() {
        btnSkip = findViewById(R.id.skipBtn);
        btnSignin = findViewById(R.id.signin_id);
        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onboarding.this, Signin.class);
                startActivity(intent);
            }
        };

        btnSkip.setOnClickListener(commonClickListener);
        btnSignin.setOnClickListener(commonClickListener);
    }

    private void onBoardingFragment() {
        mViewPager = findViewById(R.id.view_pager);
        mCircleIndicator = findViewById(R.id.circle_indicator);
        btnNext = findViewById(R.id.continue_next);

        OnboardingAdapter onboardingAdapter = new OnboardingAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(onboardingAdapter);
        mCircleIndicator.setViewPager(mViewPager);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextFrag = mViewPager.getCurrentItem() + 1;
                if (nextFrag > 2) {
                    nextFrag = 0;
                }
                mViewPager.setCurrentItem(nextFrag, true);
            }
        });
    }

    private void setStatusBarAppearance() {
        ActionBar actBar = getSupportActionBar();
        if (actBar != null) {
            actBar.hide();
        }

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.white));
    }
}
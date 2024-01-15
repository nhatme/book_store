package com.example.meowproj.Account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.meowproj.HomeScreen.ViewPagerHome;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivitySigninBinding;

public class Signin extends AppCompatActivity {

    private static String userEmail;
    private static String userPassword;
    private ActivitySigninBinding binding;
    private static Boolean checked = true;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Signin(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Signin() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setStatusBarAppearance();

        binding.btnBack.setOnClickListener(v -> {
            onBackPressed();
        });
        signinReq();
    }

    public void signinReq() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.idEmail.getText().toString();
                String password = binding.idPassword.getText().toString();
                Signin signin = new Signin(email, password);

                Intent intent = new Intent(Signin.this, ViewPagerHome.class);
                startActivity(intent);

//                if (userEmail.isEmpty()) {
//                    Toast.makeText(Signin.this, "Please enter your email", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (!regExEmail(userEmail)) {
//                        binding.textInputLayoutEmail.setError("email invalid !");
//                        checked = false;
//                    } else {
//                        Intent intent = new Intent(Signin.this, ViewPagerHome.class);
//                        startActivity(intent);
//                    }
//                }
            }
        });

        binding.idEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.e("HAHA", s.toString());
//                Log.e("HAHA", Integer.toString(start + 1));
//                Log.e("HAHA", Integer.toString(before));
//                Log.e("HAHA", Integer.toString(count));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!checked) {
                    if (regExEmail(s.toString())) {
                        binding.textInputLayoutEmail.setError(null);
                        checked = true;
                    }
                }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private static boolean regExEmail(String uEmail) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        boolean isOk = uEmail.matches(regexPattern);
        return isOk;
    }
}

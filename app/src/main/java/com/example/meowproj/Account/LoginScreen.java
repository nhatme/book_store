package com.example.meowproj.Account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.meowproj.Api.ApiService;
import com.example.meowproj.Api.Model.Login;
import com.example.meowproj.Api.Model.LoginRequest;
import com.example.meowproj.HomeScreen.MainActivity;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivitySigninBinding;
import com.google.android.gms.common.api.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends AppCompatActivity {
    private ActivitySigninBinding binding;
    private static Boolean checked = true;
    private String email;
    private String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setStatusBarAppearance();

        binding.btnBack.setOnClickListener(v -> {
            finish();
        });

        signinReq();
    }

    public void signinReq() {
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = binding.idEmail.getText().toString();
                password = binding.idPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginScreen.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else {
                    if (!regExEmail(email)) {
                        binding.textInputLayoutEmail.setError("email invalid !");
                        checked = false;
                    } else {
                        requestApiLogin();
                    }
                }
            }
        });

        binding.idEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

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
    private void requestApiLogin() {
        ApiService.apiService.login(new LoginRequest(binding.idEmail.getText().toString(), binding.idPassword.getText().toString())).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {
                    Login login = response.body();
                    if (login != null && login.isStatus()) {
                        Toast.makeText(LoginScreen.this, "Authentication successful", Toast.LENGTH_SHORT).show();
                        Log.e("NHATE",login.getToken());
                        ApiService.interceptorToken.setAuthToken(login.getToken());
                        Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        // Unsuccessful login, handle other status codes
                        int statusCode = response.code();
                        if (statusCode == 401) {
                            Toast.makeText(LoginScreen.this, "Unauthorized access. Please check your credentials.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginScreen.this, "Error: " + statusCode, Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(LoginScreen.this, "Email or password incorrect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginScreen.this, "call api error / check your internet / server offline", Toast.LENGTH_SHORT).show();
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

    private static boolean regExEmail(String uEmail) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        boolean isOk = uEmail.matches(regexPattern);
        return isOk;
    }
}

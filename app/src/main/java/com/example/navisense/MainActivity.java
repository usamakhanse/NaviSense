package com.example.navisense;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navisense.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initial state: Show Login, hide SignUp and ForgotPassword
        showLoginScreen();

        // Switch to Sign Up screen
        binding.btnShowSignUp.setOnClickListener(v -> showSignUpScreen());

        // Back to Login from Sign Up
        binding.tvBackToLogin.setOnClickListener(v -> showLoginScreen());

        // Switch to Forgot Password screen
        binding.tvForgotPassword.setOnClickListener(v -> showForgotPasswordScreen());

        // Back to Login from Forgot Password
        binding.tvForgotBackToLogin.setOnClickListener(v -> showLoginScreen());

        // Login Button Click
        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                navigateToHome();
            }
        });

        // Sign Up Button Click
        binding.btnSignUp.setOnClickListener(v -> {
            String name = binding.etFullName.getText().toString().trim();
            String email = binding.etSignUpEmail.getText().toString().trim();
            String password = binding.etNewPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all required fields", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Account Created Successfully!", Toast.LENGTH_SHORT).show();
                navigateToHome();
            }
        });

        // Reset Password Button Click
        binding.btnResetPassword.setOnClickListener(v -> {
            String resetEmail = binding.etResetEmail.getText().toString().trim();
            if (resetEmail.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Password reset link sent to " + resetEmail, Toast.LENGTH_LONG).show();
                showLoginScreen();
            }
        });
    }

    private void showLoginScreen() {
        binding.loginSection.setVisibility(View.VISIBLE);
        binding.signUpSection.setVisibility(View.GONE);
        binding.forgotPasswordSection.setVisibility(View.GONE);
    }

    private void showSignUpScreen() {
        binding.loginSection.setVisibility(View.GONE);
        binding.signUpSection.setVisibility(View.VISIBLE);
        binding.forgotPasswordSection.setVisibility(View.GONE);
    }

    private void showForgotPasswordScreen() {
        binding.loginSection.setVisibility(View.GONE);
        binding.signUpSection.setVisibility(View.GONE);
        binding.forgotPasswordSection.setVisibility(View.VISIBLE);
    }

    private void navigateToHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
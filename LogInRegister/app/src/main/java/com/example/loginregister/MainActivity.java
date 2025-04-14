package com.example.loginregister;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout emailLayout, passwordLayout, confirmPasswordLayout;
    private TextInputEditText emailInput, passwordInput, confirmPasswordInput;
    private MaterialButton loginButton, registerButton;
    private boolean isLoginMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        emailLayout = findViewById(R.id.emailLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        confirmPasswordLayout = findViewById(R.id.confirmPasswordLayout);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        loginButton = (MaterialButton) findViewById(R.id.loginButton);
        registerButton = (MaterialButton) findViewById(R.id.registerButton);
    }

    private void setupListeners() {
        loginButton.setOnClickListener(v -> handleLoginClick());
        registerButton.setOnClickListener(v -> toggleMode());
    }

    private void toggleMode() {
        isLoginMode = !isLoginMode;
        confirmPasswordLayout.setVisibility(isLoginMode ? View.GONE : View.VISIBLE);
        loginButton.setText(isLoginMode ? "Login" : "Register");
        registerButton.setText(isLoginMode ? "Register" : "Back to Login");
    }

    private void handleLoginClick() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isLoginMode) {
            String confirmPassword = confirmPasswordInput.getText().toString().trim();
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        Toast.makeText(this, isLoginMode ? "Login Successful" : "Registration Successful", 
            Toast.LENGTH_SHORT).show();
    }
}
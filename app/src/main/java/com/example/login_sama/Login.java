package com.example.login_sama;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("أدخل إيميل صحيح");
                return;
            }

            if (password.length() > 6) {
                etPassword.setError("كلمة المرور يجب أن لا تزيد عن 6 أحرف/أرقام");
                return;
            }

            // حفظ حالة الدخول
            sharedPreferences.edit().putBoolean(KEY_LOGGED_IN, true).apply();

            Toast.makeText(this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, basic_screen.class));
            finish();
        });
    }
}

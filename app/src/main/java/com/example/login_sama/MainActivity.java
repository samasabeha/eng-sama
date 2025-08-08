package com.example.login_sama;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "MyPrefs";
    private static final String KEY_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // تصميم بسيط للشاشة الترحيبية

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(KEY_LOGGED_IN, false);

        // بعد ثانية واحدة يتم الانتقال
        new Handler().postDelayed(() -> {
            if (isLoggedIn) {
                startActivity(new Intent(MainActivity.this, basic_screen.class));
            } else {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
            finish();
        }, 1000); // 1000 ملي ثانية = ثانية واحدة
    }
}

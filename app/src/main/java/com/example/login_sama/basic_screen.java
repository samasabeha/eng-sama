package com.example.login_sama;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class basic_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("Welcom to CORAL");
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);

        setContentView(tv);
    }
}

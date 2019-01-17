package com.rowsun.helloworld.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rowsun.helloworld.R;

public class SecondActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvResult = findViewById(R.id.tv_result);
        Intent i = getIntent();
        String name = "";
        int age = 10;

        boolean isMale = false;
        if (i.hasExtra("name")) {
            name = i.getStringExtra("name");
        }
        if (i.hasExtra("age")) {
            age = i.getIntExtra("age", 0);
        }
        if (i.hasExtra("isMale")) {
            isMale = i.getBooleanExtra("isMale", false);
        }

        tvResult.setText("NAME " + name +
                " AGE " + age +
                " Gender " + (isMale ? "Male" : "Female"));

    }
}

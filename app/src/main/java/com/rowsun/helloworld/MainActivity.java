package com.rowsun.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin, btnRegister;
    EditText etInput;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        etInput = findViewById(R.id.et_input);
        tvDisplay = findViewById(R.id.tv_display);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etInput.getText().toString();
                if (email.equals("admin@broadway.com")) {

                } else {
                    etInput.setError("Invalid email");
                    return;
                }

                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        tvDisplay.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    public int add(int a, int b){
        return a + b;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_register) {
            tvDisplay.setText("Register clicked");
        } else if (view.getId() == R.id.tv_display) {
            tvDisplay.setText("Display text clicked");
        }
    }
}

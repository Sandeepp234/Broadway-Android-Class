package com.rowsun.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rowsun.helloworld.test.SecondActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    Spinner spnCountry;
    EditText etName;
    Button btnSubmit;
    RadioButton rbMale, rbFemale;
    RadioGroup radioGroup;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnCountry = findViewById(R.id.spn_country);
        btnSubmit = findViewById(R.id.btn_display);
        rbFemale = findViewById(R.id.rb_female);
        rbMale = findViewById(R.id.rb_male);
        radioGroup = findViewById(R.id.rg_gender);
        spnCountry.setOnItemSelectedListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        etName = findViewById(R.id.et_name);
     //   preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences = getSharedPreferences("myapp", MODE_PRIVATE);
        editor = preferences.edit();
        etName.setText(preferences.getString("name",""));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                editor.putString("name", name).commit();
//                Intent i = new Intent(MainActivity.this, SecondActivity.class);
//                i.putExtra("name", name);
//                i.putExtra("age", 19);
//                i.putExtra("isMale", true);
//                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_rate){
            Toast.makeText(this, "Action Rate", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.action_setting){
            Toast.makeText(this, "Action setting", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//   f      Toast.makeText(MainActivity.this, "ITEM SELECTED " +  spnCountry.getSelectedItem(), Toast.LENGTH_SHORT  ).show();
           }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        String gender = "";
        gender = rbMale.isChecked() ? "Male" : "Female";
        Toast.makeText(MainActivity.this, "Gender = " + gender, Toast.LENGTH_SHORT).show();
    }
}

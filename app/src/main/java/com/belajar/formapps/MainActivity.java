package com.belajar.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    final public static String EXTRA_NAME = "extra_name";
    final public static String EXTRA_EMAIL = "extra_email";
    final public static String EXTRA_PHONE = "extra_phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Inputname = (EditText) findViewById(R.id.InputName);
        EditText InputEmail = (EditText) findViewById(R.id.InputEmail);
        EditText InputPhone = (EditText) findViewById(R.id.InputPhone);
        EditText InputPassword = (EditText) findViewById(R.id.InputPassword);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener( v ->{
                Intent loginIntent = new Intent( MainActivity.this, DashboardActivity.class);
                loginIntent.putExtra(EXTRA_NAME, Inputname.getText().toString());
                loginIntent.putExtra(EXTRA_EMAIL, InputEmail.getText().toString());
                loginIntent.putExtra(EXTRA_PHONE, InputPhone.getText().toString());
                startActivity(loginIntent);


            }
        );

    }
}
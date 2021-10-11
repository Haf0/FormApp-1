package com.belajar.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText Inputname = (EditText) findViewById(R.id.InputName);
        EditText InputEmail = (EditText) findViewById(R.id.InputEmail);
        EditText InputPhone = (EditText) findViewById(R.id.InputPhone);
        EditText InputPassword = (EditText) findViewById(R.id.InputPassword);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("nama ",Inputname.getText().toString());
                Log.d("email ",InputEmail.getText().toString());
                Log.d("Phome ",InputPhone.getText().toString());
                Log.d("pass ",InputPassword.getText().toString());

            }
        });

    }
}
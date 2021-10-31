package com.belajar.formapps;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvPhone = (TextView) findViewById(R.id.tvPhone);


        tvName.setText(getIntent().getStringExtra(MainActivity.EXTRA_NAME));
        tvEmail.setText(getIntent().getStringExtra(MainActivity.EXTRA_EMAIL));
        tvPhone.setText(getIntent().getStringExtra(MainActivity.EXTRA_PHONE));


        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener( v -> {
            String number = "*123#";
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(callIntent);
        });
        Button btnQuiz = (Button) findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(v -> {
            Intent QuizIntent = new Intent(DashboardActivity.this, QuizActivity.class);
            resultLauncher.launch(QuizIntent);
        });
        Button btnlang = (Button) findViewById(R.id.btnlang);
        btnlang.setOnClickListener( v -> {
            Intent LangIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(LangIntent);
        });

        TextView tvhasil = (TextView) findViewById(R.id.tvHasil);
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == QuizActivity.RESULT_CODE && result.getData() != null){
                        int answer = result.getData().getIntExtra(QuizActivity.EXTRA_ANSWER,0);
                        if(answer == 1 ){
                            tvhasil.setText(getResources().getString(R.string.true_answer));
                        }
                        else tvhasil.setText(getResources().getString(R.string.wrong_answer));
                    }

                });


    }
}
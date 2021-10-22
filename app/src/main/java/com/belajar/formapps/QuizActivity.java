package com.belajar.formapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER = "extra_answer";
    public static final int RESULT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        RadioGroup rgAnswer = (RadioGroup) findViewById(R.id.rgAnswer);
        Button btnKirim = (Button) findViewById(R.id.btnKirim);
        btnKirim.setOnClickListener(v -> {
            int answer = 0;
            if(rgAnswer.getCheckedRadioButtonId() != 0){
                int id =rgAnswer.getCheckedRadioButtonId();
                if(id == R.id.rb_1)
                    answer = 1;
            }
            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_ANSWER,answer);
            setResult(RESULT_CODE, resultIntent);
            finish();
        });
    }
}
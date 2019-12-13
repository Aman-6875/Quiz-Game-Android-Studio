package com.example.aman.geneousquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Start_Activity extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;





    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_);


        Button buttonStartQuiz = findViewById(R.id.start_btn);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        Intent intent = new Intent(Start_Activity.this, Question_Activity.class);
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
        Intent i = new Intent(Start_Activity.this,wellcome.class);
        startActivity(i);
    }








    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }
}

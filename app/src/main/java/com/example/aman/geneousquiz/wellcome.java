package com.example.aman.geneousquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import static java.lang.Thread.sleep;

public class wellcome extends AppCompatActivity {
    LinearLayout l1,l2;
    Animation uptodown,downtoup;
    private static final int REQUEST_CODE_QUIZ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);


        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);


        Thread mythread =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep (3000);

                    Intent intent = new Intent(wellcome.this, Question_Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_QUIZ);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        mythread.start();
    }
}

package com.example.aman.geneousquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    RelativeLayout r;
    TextView scoreview;
    private Soundplay soundplay;
    Button btn;
    int yourscore;
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyscore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreview = (TextView) findViewById(R.id.yourscore_view);
        r=(RelativeLayout)findViewById(R.id.r1);
        Animation uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        r.setAnimation(uptodown);
        btn= (Button)findViewById(R.id.btnok);
        soundplay = new Soundplay(this);
        soundplay.playcorrectsound();
        Intent mIntent = getIntent();
        final int intValue = mIntent.getIntExtra("intVariableName", 0);
        scoreview.setText("  "+intValue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent( ScoreActivity.this, Start_Activity.class);
                myIntent.putExtra("intVariableName", intValue);
                startActivity(myIntent);
            }
        });
    }

}

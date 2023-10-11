package com.cs2340.armadillo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;

public class GameActivity extends AppCompatActivity {

    private Button endBtn;
    private Button nxtBtn;
    private static final long startScore = 300000;
    private CountDownTimer countDown;
    private static long currentScore;

    ConstraintLayout gameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Player player = ConfigActivity.getPlayer();

        TextView playerHp = (TextView) findViewById(R.id.player_hp);
        TextView playerName = (TextView) findViewById(R.id.player_name);
        TextView difficulty = (TextView) findViewById(R.id.difficulty);
        TextView score = (TextView) findViewById(R.id.score);

        playerHp.setText("PlayerHP: " + player.getHP());
        playerName.setText(player.getName());
        difficulty.setText("Difficulty: " + player.getDifficulty());

        gameLayout = findViewById(R.id.game_screen);
        gameLayout.addView(player);
        endBtn = (Button) findViewById(R.id.end_button);
        nxtBtn = (Button) findViewById(R.id.next_button);

        currentScore = startScore;
        startScoreTimer(score);

        nxtBtn.setOnClickListener(v -> {
            gameLayout.removeAllViews();
            Intent next = new Intent(GameActivity.this, GameActivity2.class);
            next.putExtra("currentScore", currentScore);
            startActivity(next);
            finish();
        });

        endBtn.setOnClickListener(v -> {
            Intent end = new Intent(GameActivity.this, EndActivity.class);
            startActivity(end);
            finish();
        });
    }

    public void startScoreTimer(TextView tView) {
        countDown = new CountDownTimer(currentScore, 1000) {
            @Override
            public void onTick(long untilFinish) {
                currentScore = untilFinish;
                updateScore(tView, currentScore);
            }

            @Override
            public void onFinish() {
                currentScore = 0;
                updateScore(tView, currentScore);
            }
        }.start();
    }

    public void updateScore(TextView text, long num) {
        int newScore = (int) num;
        text.setText("Score: " + newScore);
    }

    public static long getCurrentScore() {
        return currentScore;
    }

}
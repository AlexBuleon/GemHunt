package com.crystalgems.gemhunt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Game;
import com.crystalgems.gemhunt.view.ScoreCardView;

import java.util.Arrays;

public class ScoreActivity extends Activity {

    private Game game;
    private ScoreCardView[] scoreCardViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_score);

        Intent i = getIntent();
        game = i.getParcelableExtra("game");

        scoreCardViews = new ScoreCardView[6];
        scoreCardViews[0] = (ScoreCardView) findViewById(R.id.scoreCardView0);
        scoreCardViews[1] = (ScoreCardView) findViewById(R.id.scoreCardView1);
        scoreCardViews[2] = (ScoreCardView) findViewById(R.id.scoreCardView2);
        scoreCardViews[3] = (ScoreCardView) findViewById(R.id.scoreCardView3);
        scoreCardViews[4] = (ScoreCardView) findViewById(R.id.scoreCardView4);
        scoreCardViews[5] = (ScoreCardView) findViewById(R.id.scoreCardView5);

        initScoreList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void initScoreList() {
        Arrays.sort(game.getPlayers());
        for (int i = 0; i < scoreCardViews.length; i++) {
            if (i < game.getPlayers().length)
                scoreCardViews[i].setPlayer(game.getPlayers()[i]);
            else {
                scoreCardViews[i].setVisibility(View.GONE);
            }
        }
    }
}

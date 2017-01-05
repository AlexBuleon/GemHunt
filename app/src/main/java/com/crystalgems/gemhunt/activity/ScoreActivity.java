package com.crystalgems.gemhunt.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.database.Database;
import com.crystalgems.gemhunt.model.Game;
import com.crystalgems.gemhunt.model.Player;
import com.crystalgems.gemhunt.view.ScoreCardView;

import java.util.Arrays;

public class ScoreActivity extends Activity implements View.OnClickListener {
    private static Database database;
    private Game game;
    private ScoreCardView[] scoreCardViews;
    private Button homeButton;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_score);

        Intent i = getIntent();
        game = i.getParcelableExtra("game");

        TextView scoreTitle = (TextView) findViewById(R.id.scoreTitleTextView);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/rimouski_sb.ttf");
        scoreTitle.setTypeface(font);

        homeButton = (Button) findViewById(R.id.scoreHomeButton);
        homeButton.setOnClickListener(this);
        restartButton = (Button) findViewById(R.id.scoreRestartButton);
        restartButton.setOnClickListener(this);

        scoreCardViews = new ScoreCardView[6];
        scoreCardViews[0] = (ScoreCardView) findViewById(R.id.scoreCardView0);
        scoreCardViews[1] = (ScoreCardView) findViewById(R.id.scoreCardView1);
        scoreCardViews[2] = (ScoreCardView) findViewById(R.id.scoreCardView2);
        scoreCardViews[3] = (ScoreCardView) findViewById(R.id.scoreCardView3);
        scoreCardViews[4] = (ScoreCardView) findViewById(R.id.scoreCardView4);
        scoreCardViews[5] = (ScoreCardView) findViewById(R.id.scoreCardView5);

        initScoreList();
        saveData();
    }

    private void saveData() {
        database = new Database(this);
        database.open();

        Player[] players = game.getPlayers();

        //save each player of the game
        for (int i = 0; i < players.length; i++) {
            //if the player does not exists on database, we create it

            if (!Database.getPlayerDAO().exists(players[i].getName())) {
                Database.getPlayerDAO().addPlayer(players[i]);
            } else {
                //get the concerned player on the database
                Player player = Database.getPlayerDAO().findPlayerByName(players[i].getName());

                //update the global values of the player
                players[i].setGlobalScore(players[i].getGlobalScore() + player.getGlobalScore());
                players[i].setGlobalPenalty(players[i].getGlobalPenalty() + player.getGlobalPenalty());

                //save the player
                Database.getPlayerDAO().updatePlayer(player.getId(), players[i]);
            }
        }

        //save the game
        Database.getGameDAO().addGame(game);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onStop() {
        database.close();
        super.onStop();
    }

    private void initScoreList() {
        Arrays.sort(game.getPlayers());
        for (int i = 0; i < scoreCardViews.length; i++) {
            if (i < game.getPlayers().length) {
                game.getPlayers()[game.getPlayers().length - 1 - i].setRank(i + 1);
                scoreCardViews[i].setPlayer(game.getPlayers()[game.getPlayers().length - 1 - i]);
            } else {
                scoreCardViews[i].setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v == homeButton) {
            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }

        if (v == restartButton) {
            game.resetGame();
            Intent i = new Intent(this, InGameActivity.class);
            i.putExtra("players", game.getPlayers());
            this.finish();
            startActivity(i);
        }
    }
}

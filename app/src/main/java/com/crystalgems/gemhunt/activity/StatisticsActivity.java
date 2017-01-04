package com.crystalgems.gemhunt.activity;

import java.util.List;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.database.Database;
import com.crystalgems.gemhunt.model.Player;
import com.crystalgems.gemhunt.view.StatisticsCardView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StatisticsActivity extends Activity implements View.OnClickListener{

	private StatisticsCardView[] statsCardViews;
    private Button homeButton;
    
    public static Database database;
    
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_statistics);
	        
	        database = new Database(this);
	        database.open();

	        TextView scoreTitle = (TextView) findViewById(R.id.statisticsTitleTextView);
	        Typeface font = Typeface.createFromAsset(getAssets(), "font/rimouski_sb.ttf");
	        scoreTitle.setTypeface(font);

	        homeButton = (Button) findViewById(R.id.statisticsHomeButton);
	        homeButton.setOnClickListener(this);

	        statsCardViews = new StatisticsCardView[14];
	        statsCardViews[0] = (StatisticsCardView) findViewById(R.id.statisticsCardView0);
	        statsCardViews[1] = (StatisticsCardView) findViewById(R.id.statisticsCardView1);
	        statsCardViews[2] = (StatisticsCardView) findViewById(R.id.statisticsCardView2);
	        statsCardViews[3] = (StatisticsCardView) findViewById(R.id.statisticsCardView3);
	        statsCardViews[4] = (StatisticsCardView) findViewById(R.id.statisticsCardView4);
	        statsCardViews[5] = (StatisticsCardView) findViewById(R.id.statisticsCardView5);
	        statsCardViews[6] = (StatisticsCardView) findViewById(R.id.statisticsCardView6);
	        statsCardViews[7] = (StatisticsCardView) findViewById(R.id.statisticsCardView7);
	        statsCardViews[8] = (StatisticsCardView) findViewById(R.id.statisticsCardView8);
	        statsCardViews[9] = (StatisticsCardView) findViewById(R.id.statisticsCardView9);
	        statsCardViews[10] = (StatisticsCardView) findViewById(R.id.statisticsCardView10);
	        statsCardViews[11] = (StatisticsCardView) findViewById(R.id.statisticsCardView11);
	        statsCardViews[12] = (StatisticsCardView) findViewById(R.id.statisticsCardView12);
	        statsCardViews[13] = (StatisticsCardView) findViewById(R.id.statisticsCardView13);

	        initStatsList();
	    }
	 
	 @Override
	    protected void onStart() {
	        super.onStart();
	        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
	                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	    }
	 
	 private void initStatsList() {
	        List<Player> players = database.getPlayerDAO().findAllPlayer();
	        for(int i = 0; i < Math.min(players.size(),14); i++){
	        	statsCardViews[i].setPlayer(players.get(i));
	        }
	        for(int i = players.size(); i < 14; i++){
	        	statsCardViews[i].setVisibility(View.GONE);
	        }
	    }
	 
	 @Override
	    public void onClick(View v) {
	        if (v == homeButton) {
	            Intent i = new Intent(this, MainActivity.class);
	            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(i);
	        }
	    }
	 
	 @Override
	 protected void onStop(){
		 super.onStop();
		 database.close();
	 }
}

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

public class PauseActivity extends Activity implements View.OnClickListener {

    private Button returnButton;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pause);

        TextView txt = (TextView) findViewById(R.id.pauseTextView);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/odin_rounded.otf");
        txt.setTypeface(font);

        returnButton = (Button) findViewById(R.id.returnButton);
        homeButton = (Button) findViewById(R.id.homeButton);
        returnButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onClick(View v) {
        if (v == returnButton) {
            this.finish();
        }
        if (v == homeButton) {
            /*Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);*/
            Intent i = new Intent(this, ScoreActivity.class);
            startActivity(i);
        }
    }
}

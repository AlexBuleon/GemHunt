package com.crystalgems.gemhunt.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Game;

public class InGameActivity extends FragmentActivity {

    private int playersNumber;
    private Game game;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.in_game_activity);

        Intent intent = getIntent();
        playersNumber = intent.getIntExtra("playersNumber", 1);
    }
}

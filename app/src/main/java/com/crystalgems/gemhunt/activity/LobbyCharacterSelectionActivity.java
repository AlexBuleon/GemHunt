package com.crystalgems.gemhunt.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.apps.su.gemhunt.R;

public class LobbyCharacterSelectionActivity extends Activity implements View.OnClickListener {

    private Button steven;
    private Button garnet;
    private Button amethyst;
    private Button pearl;
    private Button connie;
    private Button stevonnie;
    private Button lapis;
    private Button peridot;
    private Button ruby;
    private Button sapphire;
    private Button rose;
    private Button lion;
    private Button jasper;
    private Button alexandrite;

    private Intent intent;
    private String characterChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_select_activity);

        intent = getIntent();

        steven = (Button) findViewById(R.id.stevenButton);

        steven.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();

        if (view == steven) {
            intent.putExtra("pictureID", R.drawable.character_steven);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == garnet) {
            intent.putExtra("pictureID", R.drawable.character_garnet);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == amethyst) {
            intent.putExtra("pictureID", R.drawable.character_amethyst);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == pearl) {
            intent.putExtra("pictureID", R.drawable.character_pearl);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == connie) {
            intent.putExtra("pictureID", R.drawable.character_connie);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == stevonnie) {
            intent.putExtra("pictureID", R.drawable.character_stevonnie);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == lapis) {
            intent.putExtra("pictureID", R.drawable.character_lapis);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == peridot) {
            intent.putExtra("pictureID", R.drawable.character_peridot);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == ruby) {
            intent.putExtra("pictureID", R.drawable.character_ruby);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == sapphire) {
            intent.putExtra("pictureID", R.drawable.character_sapphire);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == rose) {
            intent.putExtra("pictureID", R.drawable.character_rose);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == lion) {
            intent.putExtra("pictureID", R.drawable.character_lion);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == jasper) {
            intent.putExtra("pictureID", R.drawable.character_jasper);
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == alexandrite) {
            intent.putExtra("pictureID", R.drawable.character_alexandrite);
            setResult(RESULT_OK, intent);
            finish();
        }

    }
}

package com.crystalgems.gemhunt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        garnet = (Button) findViewById(R.id.garnetButton);
        amethyst = (Button) findViewById(R.id.amethystButton);
        pearl = (Button) findViewById(R.id.pearlButton);
        connie = (Button) findViewById(R.id.connieButton);
        stevonnie = (Button) findViewById(R.id.stevonnieButton);
        lapis = (Button) findViewById(R.id.lapisButton);
        peridot = (Button) findViewById(R.id.peridotButton);
        ruby = (Button) findViewById(R.id.rubyButton);
        sapphire = (Button) findViewById(R.id.sapphireButton);
        rose = (Button) findViewById(R.id.roseButton);
        lion = (Button) findViewById(R.id.lionButton);
        jasper = (Button) findViewById(R.id.jasperButton);
        alexandrite = (Button) findViewById(R.id.alexandriteButton);

        steven.setOnClickListener(this);
        garnet.setOnClickListener(this);
        amethyst.setOnClickListener(this);
        pearl.setOnClickListener(this);
        connie.setOnClickListener(this);
        stevonnie.setOnClickListener(this);
        lapis.setOnClickListener(this);
        peridot.setOnClickListener(this);
        ruby.setOnClickListener(this);
        sapphire.setOnClickListener(this);
        rose.setOnClickListener(this);
        lion.setOnClickListener(this);
        jasper.setOnClickListener(this);
        alexandrite.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onClick(View view) {
        if (view == steven) {
            intent.putExtra("pictureID", R.drawable.character_steven);
            intent.putExtra("name", "Steven");
            setResult(RESULT_OK, intent);
            finish();
        }
        else if (view == garnet) {
            intent.putExtra("pictureID", R.drawable.character_garnet);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Garnet");
            finish();
        }
        else if (view == amethyst) {
            intent.putExtra("pictureID", R.drawable.character_amethyst);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Amethyst");
            finish();
        }
        else if (view == pearl) {
            intent.putExtra("pictureID", R.drawable.character_pearl);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Pearl");
            finish();
        }
        else if (view == connie) {
            intent.putExtra("pictureID", R.drawable.character_connie);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Connie");
            finish();
        }
        else if (view == stevonnie) {
            intent.putExtra("pictureID", R.drawable.character_stevonnie);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Stevonnie");
            finish();
        }
        else if (view == lapis) {
            intent.putExtra("pictureID", R.drawable.character_lapis);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Lapis");
            finish();
        }
        else if (view == peridot) {
            intent.putExtra("pictureID", R.drawable.character_peridot);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Peridot");
            finish();
        }
        else if (view == ruby) {
            intent.putExtra("pictureID", R.drawable.character_ruby);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Ruby");
            finish();
        }
        else if (view == sapphire) {
            intent.putExtra("pictureID", R.drawable.character_sapphire);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Sapphire");
            finish();
        }
        else if (view == rose) {
            intent.putExtra("pictureID", R.drawable.character_rose);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Rose");
            finish();
        }
        else if (view == lion) {
            intent.putExtra("pictureID", R.drawable.character_lion);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Lion");
            finish();
        }
        else if (view == jasper) {
            intent.putExtra("pictureID", R.drawable.character_jasper);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Jasper");
            finish();
        }
        else if (view == alexandrite) {
            intent.putExtra("pictureID", R.drawable.character_alexandrite);
            setResult(RESULT_OK, intent);
            intent.putExtra("name", "Alexandrite");
            finish();
        }

    }
}

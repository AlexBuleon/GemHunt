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

            /*bundle.putString("character", "steven");
            LobbyScreenSlidePageFragment fragment = new LobbyScreenSlidePageFragment();
            fragment.setArguments(bundle);*/

            /*Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("character", 1);
            startActivity(intent);*/
        }
        //characterChosen = view.toString();
    }
}

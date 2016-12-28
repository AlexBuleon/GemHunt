package com.crystalgems.gemhunt.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.su.gemhunt.R;

public class CharacterCardView extends LinearLayout {
    private ImageView character;
    private TextView playerName;
    private TextView score;

    public CharacterCardView(Context context) {
        super(context);
        init(context);
    }

    public CharacterCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CharacterCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_character_card, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        character = (ImageView) findViewById(R.id.characterImageView);
        playerName = (TextView) findViewById(R.id.playerName);
        score = (TextView) findViewById(R.id.score);
        character.setImageResource(R.drawable.character_garnet1);
    }
}

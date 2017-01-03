package com.crystalgems.gemhunt.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apps.su.gemhunt.R;

public class CharacterCardView extends LinearLayout {
    private ImageView characterImageView;
    private TextView playerNameTextView;
    private TextView scoreTextView;
    private ImageView penaltyImageView;
    private LinearLayout backgroundLayout;

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
        characterImageView = (ImageView) findViewById(R.id.characterImageView);
        playerNameTextView = (TextView) findViewById(R.id.nameTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        penaltyImageView = (ImageView) findViewById(R.id.penaltyImageView);
        backgroundLayout = (LinearLayout) findViewById(R.id.characterCardLayout);
    }

    public ImageView getCharacterImageView() {
        return characterImageView;
    }

    public TextView getPlayerNameTextView() {
        return playerNameTextView;
    }

    public TextView getScoreTextView() {
        return scoreTextView;
    }

    public ImageView getPenaltyImageView() {
        return penaltyImageView;
    }
    
    public LinearLayout getBackgroundLayout(){
    	return backgroundLayout;
    }
}

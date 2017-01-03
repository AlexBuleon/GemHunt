package com.crystalgems.gemhunt.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apps.su.gemhunt.R;

public class CharacterProfileView extends LinearLayout {
    private ImageView characterImageView;
    private TextView characterNameTextView;

    public CharacterProfileView(Context context) {
        super(context);
        init(context);
    }

    public CharacterProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CharacterProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_character_profile, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        characterImageView = (ImageView) findViewById(R.id.profileImageView);
        characterNameTextView = (TextView) findViewById(R.id.characterNameTextView);
    }

    public ImageView getCharacterImageView() {
        return characterImageView;
    }

    public TextView getCharacterNameTextView() {
        return characterNameTextView;
    }
}
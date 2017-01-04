package com.crystalgems.gemhunt.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Player;

public class ScoreCardView extends RelativeLayout {
    private ImageView characterImageView;
    private TextView playerNameTextView;
    private TextView totalScoreTextView;
    private TextView penaltyCounterTextView;
    private TextView rollCounterTextView;

    public ScoreCardView(Context context) {
        super(context);
        init(context);
    }

    public ScoreCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScoreCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_scrore_card, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        characterImageView = (ImageView) findViewById(R.id.scoreCardCharacterImageView);
        playerNameTextView = (TextView) findViewById(R.id.scoreCardPlayerName);
        totalScoreTextView = (TextView) findViewById(R.id.scoreCardTotalScore);
        penaltyCounterTextView = (TextView) findViewById(R.id.scoreCardPenaltyCounter);
        rollCounterTextView = (TextView) findViewById(R.id.scoreCardRollCounter);
    }

    public void setPlayer(Player p) {
        characterImageView.setImageResource(p.getPictureId());
        playerNameTextView.setText(p.getName());
        totalScoreTextView.setText("Score : " + String.valueOf(p.getTotalScore()));
        penaltyCounterTextView.setText("Penalty : " + String.valueOf(p.getPenaltyCounter()));
        rollCounterTextView.setText("Roll : " + String.valueOf(p.getRollCounter()));
    }
}

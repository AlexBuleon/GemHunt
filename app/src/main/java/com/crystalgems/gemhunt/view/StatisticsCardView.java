package com.crystalgems.gemhunt.view;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StatisticsCardView extends RelativeLayout {
    private ImageView characterImageView;
    private TextView playerNameTextView;
    private TextView globalScoreTextView;
    private TextView globalPenaltyTextView;

    public StatisticsCardView(Context context) {
        super(context);
        init(context);
    }

    public StatisticsCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StatisticsCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_statistics_card, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        characterImageView = (ImageView) findViewById(R.id.statisticsCardCharacterImageView);
        playerNameTextView = (TextView) findViewById(R.id.statisticsCardPlayerName);
        globalScoreTextView = (TextView) findViewById(R.id.statisticsCardGlobalScore);
        globalPenaltyTextView = (TextView) findViewById(R.id.statisticsCardGlobalPenalty);
    }

    public void setPlayer(Player p) {
        // TODO : configure the right pictureId
        //characterImageView.setImageResource(p.getPictureId());
        playerNameTextView.setText(p.getName());
        globalScoreTextView.setText("Score : " + String.valueOf(p.getGlobalScore()));
        globalPenaltyTextView.setText("Penalties : " + String.valueOf(p.getGlobalPenalty()));
    }

}

package com.crystalgems.gemhunt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.apps.su.gemhunt.R;

public class SettingsScreenSlidePageFragment extends Fragment implements View.OnClickListener {

    private Button creditButton;
    private Button statsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_settings_screen_slide_page, container, false);

        creditButton = (Button) rootView.findViewById(R.id.credits_button);
        creditButton.setOnClickListener(this);
        statsButton = (Button) rootView.findViewById(R.id.stats_button);
        statsButton.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (v == creditButton) {
            startActivity(new Intent(this.getActivity(), CreditsActivity.class));
        }
        if (v == statsButton){
        	startActivity(new Intent(this.getActivity(), StatisticsActivity.class));
        }
    }
}

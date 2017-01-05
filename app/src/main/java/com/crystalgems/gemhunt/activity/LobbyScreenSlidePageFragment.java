package com.crystalgems.gemhunt.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Player;

import java.util.Random;

public class LobbyScreenSlidePageFragment extends Fragment implements OnClickListener {
    private Button player1;
    private Button player2;
    private Button player3;
    private Button player4;
    private Button player5;
    private Button player6;
    private Button suppress;
    private Button launch;

    private Player[] players = new Player[6];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_lobby_screen_slide_page, container, false);

        TextView lobbyTitle = (TextView) rootView.findViewById(R.id.lobbyTitleTextView);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "font/rimouski_sb.ttf");
        lobbyTitle.setTypeface(font);

        players[0] = new Player("Steven", R.drawable.character_steven);
        players[1] = new Player("Connie", R.drawable.character_connie);

        player1 = (Button) rootView.findViewById(R.id.player1);
        player1.setOnClickListener(this);
        player1.setBackgroundResource(R.drawable.character_steven);

        player2 = (Button) rootView.findViewById(R.id.player2);
        player2.setOnClickListener(this);
        player2.setBackgroundResource(R.drawable.character_connie);

        player3 = (Button) rootView.findViewById(R.id.player3);
        player3.setOnClickListener(this);

        player4 = (Button) rootView.findViewById(R.id.player4);
        player4.setOnClickListener(this);

        player5 = (Button) rootView.findViewById(R.id.player5);
        player5.setOnClickListener(this);

        player6 = (Button) rootView.findViewById(R.id.player6);
        player6.setOnClickListener(this);

        suppress = (Button) rootView.findViewById(R.id.suppress_button);
        suppress.setOnClickListener(this);
        suppress.setEnabled(false);

        launch = (Button) rootView.findViewById(R.id.launch_button);
        launch.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        Intent intent = new Intent(LobbyScreenSlidePageFragment.this.getActivity(), LobbyCharacterSelectionActivity.class);

        switch (viewId) {
            case R.id.player1:
                intent.putExtra("buttonID", R.id.player1);
                startActivityForResult(intent, 1);
                break;

            case R.id.player2:
                intent.putExtra("buttonID", R.id.player2);
                startActivityForResult(intent, 2);

                break;

            case R.id.player3:
                if (!player3.getText().equals("+")) {
                    intent.putExtra("buttonID", R.id.player3);
                    startActivityForResult(intent, 3);
                } else {
                    suppress.setEnabled(true);
                    player3.setBackgroundResource(R.drawable.character_connie);
                    player4.setVisibility(View.VISIBLE);
                    player3.setText(R.string.player3);
                    players[2] = new Player("Connie", R.drawable.character_connie);
                }
                break;

            case R.id.player4:
                if (!player4.getText().equals("+")) {
                    intent.putExtra("buttonID", R.id.player4);
                    startActivityForResult(intent, 4);
                } else {
                    player4.setBackgroundResource(R.drawable.character_connie);
                    player5.setVisibility(View.VISIBLE);
                    player4.setText(R.string.player4);
                    players[3] = new Player("Connie", R.drawable.character_connie);
                }
                break;

            case R.id.player5:
                if (!player5.getText().equals("+")) {
                    intent.putExtra("buttonID", R.id.player5);
                    startActivityForResult(intent, 5);
                } else {
                    player5.setBackgroundResource(R.drawable.character_connie);
                    player6.setVisibility(View.VISIBLE);
                    player5.setText(R.string.player5);
                    players[4] = new Player("Connie", R.drawable.character_connie);
                }
                break;

            case R.id.player6:
                if (!player6.getText().equals("+")) {
                    intent.putExtra("buttonID", R.id.player6);
                    startActivityForResult(intent, 6);
                } else {
                    player6.setBackgroundResource(R.drawable.character_connie);
                    player6.setText(R.string.player6);
                    players[5] = new Player("Connie", R.drawable.character_connie);
                }
                break;

            case R.id.suppress_button:
                suppress();
                break;

            case R.id.launch_button:
                launch();
                break;

            default:
                break;
        }

    }


    private void suppress() {
        if (player6.getVisibility() == View.VISIBLE && !player6.getText().equals(getResources().getString(R.string.add))) {
            player6.setText(R.string.add);
            player6.setBackgroundResource(android.R.drawable.btn_default);
            players[5] = null;
        } else if (player5.getVisibility() == View.VISIBLE && !player5.getText().equals(getResources().getString(R.string.add))) {
            player6.setVisibility(View.INVISIBLE);
            player5.setText(R.string.add);
            player5.setBackgroundResource(android.R.drawable.btn_default);
            players[4] = null;
        } else if (player4.getVisibility() == View.VISIBLE && !player4.getText().equals(getResources().getString(R.string.add))) {
            player5.setVisibility(View.INVISIBLE);
            player4.setText(R.string.add);
            player4.setBackgroundResource(android.R.drawable.btn_default);
            players[3] = null;
        } else {
            player4.setVisibility(View.INVISIBLE);
            player3.setText(R.string.add);
            player3.setBackgroundResource(android.R.drawable.btn_default);
            players[2] = null;
            suppress.setEnabled(false);
        }
    }

    private int getPlayersNumber() {
        if (player6.getVisibility() == View.VISIBLE && !player6.getText().equals(getResources().getString(R.string.add))) {
            return 6;
        } else if (player5.getVisibility() == View.VISIBLE && !player5.getText().equals(getResources().getString(R.string.add))) {
            return 5;
        } else if (player4.getVisibility() == View.VISIBLE && !player4.getText().equals(getResources().getString(R.string.add))) {
            return 4;
        } else if (player3.getVisibility() == View.VISIBLE && !player3.getText().equals(getResources().getString(R.string.add))) {
            return 3;
        } else {
            return 2;
        }
    }

    private void launch() {
        int playerNum = 0;
        while (playerNum < players.length && players[playerNum] != null)
            playerNum++;
        Player[] p = new Player[playerNum];
        System.arraycopy(players, 0, p, 0, p.length);
        // Shuffle players
        Random rnd = new Random();
        for (int i = p.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Player a = p[index];
            p[index] = p[i];
            p[i] = a;
        }
        Intent intent = new Intent(LobbyScreenSlidePageFragment.this.getActivity(), InGameActivity.class);
        intent.putExtra("players", p);
        startActivity(intent);
    }

    public void setCharacter(int buttonID, int pictureID, String name) {
        switch (buttonID) {
            case R.id.player1:
                player1.setBackgroundResource(pictureID);
                players[0].setName(name);
                players[0].setPictureId(pictureID);
                break;
            case R.id.player2:
                player2.setBackgroundResource(pictureID);
                players[1].setName(name);
                players[1].setPictureId(pictureID);
                break;
            case R.id.player3:
                player3.setBackgroundResource(pictureID);
                players[2].setName(name);
                players[2].setPictureId(pictureID);
                break;
            case R.id.player4:
                player4.setBackgroundResource(pictureID);
                players[3].setName(name);
                players[3].setPictureId(pictureID);
                break;
            case R.id.player5:
                player5.setBackgroundResource(pictureID);
                players[4].setName(name);
                players[4].setPictureId(pictureID);
                break;
            case R.id.player6:
                player6.setBackgroundResource(pictureID);
                players[5].setName(name);
                players[5].setPictureId(pictureID);
                break;
        }
    }
}

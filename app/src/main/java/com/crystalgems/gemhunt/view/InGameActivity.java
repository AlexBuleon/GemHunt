package com.crystalgems.gemhunt.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Dice;
import com.crystalgems.gemhunt.model.DicePool;
import com.crystalgems.gemhunt.model.Game;
import com.crystalgems.gemhunt.model.Player;

public class InGameActivity extends FragmentActivity {

    private int playersNumber;
    private Game game;

    private Button rollButton;
    private Button passTurnButton;

    private ImageView[] dicesViews = new ImageView[3];
    private CharacterCardView[] characterCardViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.in_game_activity);

        Intent intent = getIntent();
        playersNumber = intent.getIntExtra("playersNumber", 2);

        initGameActivity();


        Player[] players = new Player[6];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("player " + i);
        }
        final DicePool dicePool = new DicePool(new Dice[]{Dice.GreenDice, Dice.GreenDice, Dice.GreenDice, Dice.GreenDice, Dice.GreenDice, Dice.GreenDice,
                Dice.OrangeDice, Dice.OrangeDice, Dice.OrangeDice, Dice.OrangeDice, Dice.RedDice, Dice.RedDice,
                Dice.RedDice});

        game = new Game(0, players, dicePool);

        rollButton = (Button) findViewById(R.id.rollButton);
        passTurnButton = (Button) findViewById(R.id.passTurnButton);
        dicesViews[0] = (ImageView) findViewById(R.id.diceView1);
        dicesViews[1] = (ImageView) findViewById(R.id.diceView2);
        dicesViews[2] = (ImageView) findViewById(R.id.diceView3);

        characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
        characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView1);

        characterCardViews[1].getPlayerNameImageView().setText("Antoine");

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.pickDice(3);
                for (int i = 0; i < 3; i++) {
                    switch (game.getDicePicked().get(i).roll()) {
                        case Dice.GEM_FACE:
                            dicesViews[i].setImageResource(R.drawable.item_dice_green_0);
                            break;
                        case Dice.ESCAPE_FACE:
                            dicesViews[i].setImageResource(R.drawable.item_dice_green_1);
                            break;
                        case Dice.MONSTER_FACE:
                            dicesViews[i].setImageResource(R.drawable.item_dice_green_2);
                            break;
                    }
                }
                game.getDicePicked().moveTo(game.getDiceBin());
            }
        });
    }

    private void initGameActivity() {
        characterCardViews = new CharacterCardView[playersNumber];
        switch (playersNumber) {
            case 6:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView1);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView2);
                characterCardViews[3] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[4] = (CharacterCardView) findViewById(R.id.characterCardView4);
                characterCardViews[5] = (CharacterCardView) findViewById(R.id.characterCardView5);
                break;
            case 5:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView2);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[3] = (CharacterCardView) findViewById(R.id.characterCardView4);
                characterCardViews[4] = (CharacterCardView) findViewById(R.id.characterCardView5);
                (findViewById(R.id.characterCardView1)).setVisibility(View.INVISIBLE);
                break;
            case 4:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView2);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[3] = (CharacterCardView) findViewById(R.id.characterCardView5);
                (findViewById(R.id.characterCardView1)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView4)).setVisibility(View.INVISIBLE);
                break;
            case 3:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView1);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView5);
                (findViewById(R.id.characterCardView0)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView4)).setVisibility(View.INVISIBLE);
                break;
            case 2:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView5);
                (findViewById(R.id.characterCardView0)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView1)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView4)).setVisibility(View.INVISIBLE);
                break;
            default:
                System.err.println("Incorrect number player : " + playersNumber);
                break;
        }
    }


}

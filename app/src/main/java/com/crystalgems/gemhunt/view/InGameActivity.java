package com.crystalgems.gemhunt.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.apps.su.gemhunt.R;
import com.crystalgems.gemhunt.model.Dice;
import com.crystalgems.gemhunt.model.DicePool;
import com.crystalgems.gemhunt.model.Game;
import com.crystalgems.gemhunt.model.Player;

public class InGameActivity extends FragmentActivity implements OnClickListener{

    private int playersNumber;
    private boolean victory;
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

        characterCardViews[1].getPlayerNameTextView().setText("Antoine");
        
        rollButton.setOnClickListener(this);
        passTurnButton.setOnClickListener(this);

        /*rollButton.setOnClickListener(new View.OnClickListener() {
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
        });*/
        
        victory = false;
		game.setDuration(System.currentTimeMillis()); // init time
		start();
    }

    private void initGameActivity() {
        characterCardViews = new CharacterCardView[playersNumber];
        switch (playersNumber) {
            case 6:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
                characterCardViews[0].getPlayerNameTextView().setText("P1");
                characterCardViews[0].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView1);
                characterCardViews[1].getPlayerNameTextView().setText("P2");
                characterCardViews[1].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView2);
                characterCardViews[2].getPlayerNameTextView().setText("P3");
                characterCardViews[2].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[3] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[3].getPlayerNameTextView().setText("P4");
                characterCardViews[3].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[4] = (CharacterCardView) findViewById(R.id.characterCardView4);
                characterCardViews[4].getPlayerNameTextView().setText("P5");
                characterCardViews[4].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[5] = (CharacterCardView) findViewById(R.id.characterCardView5);
                characterCardViews[5].getPlayerNameTextView().setText("P6");
                characterCardViews[5].getCharacterImageView().setImageResource(R.drawable.character_garnet);                
                for (int i=0;i<6;i++){
                	characterCardViews[i].getPenaltyImageView().setImageResource(R.drawable.misc_card_penalty0);
                	characterCardViews[i].getScoreTextView().setText("0");
                }
                break;
            case 5:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
                characterCardViews[0].getPlayerNameTextView().setText("P1");
                characterCardViews[0].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView2);
                characterCardViews[1].getPlayerNameTextView().setText("P2");
                characterCardViews[1].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[2].getPlayerNameTextView().setText("P3");
                characterCardViews[2].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[3] = (CharacterCardView) findViewById(R.id.characterCardView4);
                characterCardViews[3].getPlayerNameTextView().setText("P4");
                characterCardViews[3].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[4] = (CharacterCardView) findViewById(R.id.characterCardView5);
                characterCardViews[4].getPlayerNameTextView().setText("P5");
                characterCardViews[4].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                (findViewById(R.id.characterCardView1)).setVisibility(View.INVISIBLE);
                for (int i=0;i<5;i++){
                	characterCardViews[i].getPenaltyImageView().setImageResource(R.drawable.misc_card_penalty0);
                	characterCardViews[i].getScoreTextView().setText("0");
                }
                break;
            case 4:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView0);
                characterCardViews[0].getPlayerNameTextView().setText("P1");
                characterCardViews[0].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView2);
                characterCardViews[1].getPlayerNameTextView().setText("P2");
                characterCardViews[1].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[2].getPlayerNameTextView().setText("P3");
                characterCardViews[2].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[3] = (CharacterCardView) findViewById(R.id.characterCardView5);
                characterCardViews[3].getPlayerNameTextView().setText("P4");
                characterCardViews[3].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                (findViewById(R.id.characterCardView1)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView4)).setVisibility(View.INVISIBLE);
                for (int i=0;i<4;i++){
                	characterCardViews[i].getPenaltyImageView().setImageResource(R.drawable.misc_card_penalty0);
                	characterCardViews[i].getScoreTextView().setText("0");
                }
                break;
            case 3:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView1);
                characterCardViews[0].getPlayerNameTextView().setText("P1");
                characterCardViews[0].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[1].getPlayerNameTextView().setText("P2");
                characterCardViews[1].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[2] = (CharacterCardView) findViewById(R.id.characterCardView5);
                characterCardViews[2].getPlayerNameTextView().setText("P3");
                characterCardViews[2].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                (findViewById(R.id.characterCardView0)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView4)).setVisibility(View.INVISIBLE);
                for (int i=0;i<3;i++){
                	characterCardViews[i].getPenaltyImageView().setImageResource(R.drawable.misc_card_penalty0);
                	characterCardViews[i].getScoreTextView().setText("0");
                }
                break;
            case 2:
                characterCardViews[0] = (CharacterCardView) findViewById(R.id.characterCardView3);
                characterCardViews[0].getPlayerNameTextView().setText("P1");
                characterCardViews[0].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                characterCardViews[1] = (CharacterCardView) findViewById(R.id.characterCardView5);
                characterCardViews[1].getPlayerNameTextView().setText("P2");
                characterCardViews[1].getCharacterImageView().setImageResource(R.drawable.character_garnet);
                (findViewById(R.id.characterCardView0)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView1)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView2)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.characterCardView4)).setVisibility(View.INVISIBLE);
                for (int i=0;i<2;i++){
                	characterCardViews[i].getPenaltyImageView().setImageResource(R.drawable.misc_card_penalty0);
                	characterCardViews[i].getScoreTextView().setText("0");
                }
                break;
            default:
                System.err.println("Incorrect number player : " + playersNumber);
                break;
        }
    }
        
        /**
    	 * start the game, end when one player win (dedicated thread)
    	 */
    	public void start() { //TODO : complete and thread
    		if(!victory){	//victory value only update at the end on a turn, can't trigger between rolls
    			playDice();		//play a dice
    		}
    		else{
    			game.setDuration(System.currentTimeMillis() - game.getDuration()); //final duration of the game
    			// TODO : add game recap screen
    			saveData();
    		}
    		
    	}
    	
    	/**
    	 * pick and play the 3 Dices
    	 */
    	private void playDice(){ 
    		DicePool pool = game.getDicePicked();
    		game.pickDice(3-pool.size());
    		for(int i=0; i<game.getDicePicked().size(); i++){ 
    			switch (pool.get(i)) {
				case GreenDice:
					//diceAnimation(i,0);
					switch (pool.get(i).roll()) {
					case Dice.GEM_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_green_0);
						break;
					case Dice.ESCAPE_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_green_1);
						break;
					case Dice.MONSTER_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_green_2);
						break;
					default:
						break;
					}
					break;
				case OrangeDice:
					//diceAnimation(i,1);
					switch (pool.get(i).roll()) {
					case Dice.GEM_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_orange_0);
						break;
					case Dice.ESCAPE_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_orange_1);
						break;
					case Dice.MONSTER_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_orange_2);
						break;
					default:
						break;
					}
					break;
				case RedDice:
					//diceAnimation(i,2);
					switch (pool.get(i).roll()) {
					case Dice.GEM_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_red_0);
						break;
					case Dice.ESCAPE_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_red_1);
						break;
					case Dice.MONSTER_FACE:
						dicesViews[i].setImageResource(R.drawable.item_dice_red_2);
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
    		}
    		passRoll();
    	}
    	
    	/**
    	 * check victory and update player datas before passing to next player turn
    	 */
    	private void passTurn() { // TODO : link with activity animation (passing turn to X)
    		if(checkVictory())
    			victory = true;
    		updatePlayerTurn();
    		game.setTurnCounter(game.getTurnCounter()+1);
    		game.resetDicePool();
    	}
    	
    	/**
    	 * check penalty and update player datas before possible next dice roll
    	 */
    	private void passRoll(){ // TODO : link with activity animation (3 penalty => turn pass)
    		updatePlayerRoll();
    		game.toBin();
    		if(checkPenalty()){
    			game.getActivePlayer().setTurnScore(0);
    			passTurn();
    		}
    	}
    	
    	/**
    	 * update player's turn-ended datas
    	 */
    	private void updatePlayerTurn() { //TODO : link with activity animation (update total score)
    		Player activePlayer = game.getActivePlayer();
    		activePlayer.setTotalScore(activePlayer.getTotalScore() + activePlayer.getTurnScore());
    		activePlayer.setTurnScore(0);
    		activePlayer.setPenaltyCounter(activePlayer.getPenaltyCounter() + activePlayer.getPenalty());
    		activePlayer.setPenalty(0);
    		start();
    	}
    	
    	/**
    	 * update player's post-roll datas
    	 */
    	private void updatePlayerRoll(){ //TODO : link with activity animation (update penalty, turn score)
    		Player activePlayer = game.getActivePlayer();
    		DicePool pool = game.getDicePicked();
    		for(int i = 0; i<3; i++){
    			if (pool.get(i).getResult() == Dice.MONSTER_FACE)
    				activePlayer.setPenalty(activePlayer.getPenalty() + 1);
    			else if(pool.get(i).getResult() == Dice.GEM_FACE)
    				activePlayer.setTurnScore(activePlayer.getTurnScore() + 1);
    		}
    		activePlayer.setRollCounter(activePlayer.getRollCounter() + 1);
    	}

    	/**
    	 * check if the player have 3 penalties
    	 * @return player have 3 penalties and must pass turn
    	 */
    	private boolean checkPenalty() {
    		if(game.getActivePlayer().getPenalty() >= 3){
    			return true;
    		}
    		return false;
    	}

    	/**
    	 * check if the player won
    	 * @return the player won the game
    	 */
    	private boolean checkVictory() {
    		if(game.getActivePlayer().getTotalScore() >= 13){
    			return true;
    		}
    		return false;

    	}

    	/**
    	 * save game datas to the database
    	 * @return query success
    	 */
    	private boolean saveData() { //TODO : everything
    		return false;

    	}

		@Override
		public void onClick(View v) {
			if(v == rollButton){
				start();
			}
			
			if(v == passTurnButton){
				passTurn();
			}
		}
		
		/*private void diceAnimation(int pos, int color){ //SHINEY ANIMATIONS
			int x = -1;
			int y = 0;
			for(int i = 0; i < 5; i++){
				android.os.SystemClock.sleep(300);
				do{
					y = (int)Math.random()*3;
				} while(x == y);
				x = y;
				switch (y) {
				case 0:
					switch (color) {
					case 0:
						dicesViews[pos].setImageResource(R.drawable.item_dice_green_0);
						break;
					case 1:
						dicesViews[pos].setImageResource(R.drawable.item_dice_green_1);
						break;
					case 2:
						dicesViews[pos].setImageResource(R.drawable.item_dice_green_2);
						break;
					default:
						break;
					}
					break;
				case 1:
					switch (color) {
					case 0:
						dicesViews[pos].setImageResource(R.drawable.item_dice_orange_0);
						break;
					case 1:
						dicesViews[pos].setImageResource(R.drawable.item_dice_orange_1);
						break;
					case 2:
						dicesViews[pos].setImageResource(R.drawable.item_dice_orange_2);
						break;
					default:
						break;
					}
					break;
				case 2:
					switch (color) {
					case 0:
						dicesViews[pos].setImageResource(R.drawable.item_dice_red_0);
						break;
					case 1:
						dicesViews[pos].setImageResource(R.drawable.item_dice_red_1);
						break;
					case 2:
						dicesViews[pos].setImageResource(R.drawable.item_dice_red_2);
						break;
					default:
						break;
					}
					break;
					
				default:
					break;
				}
			}
			
		}*/
}

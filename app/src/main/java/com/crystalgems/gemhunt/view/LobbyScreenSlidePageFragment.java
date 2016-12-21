package com.crystalgems.gemhunt.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.apps.su.gemhunt.R;

public class LobbyScreenSlidePageFragment extends Fragment implements OnClickListener{
	Button player1;
	Button player2;
	Button player3;
	Button player4;
	Button player5;
	Button player6;
	Button suppress;
	Button launch;
	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_lobby_screen_slide_page, container, false);
        player1 = (Button)rootView.findViewById(R.id.player1);
        player1.setOnClickListener(this);
        player2 = (Button)rootView.findViewById(R.id.player2);
        player2.setOnClickListener(this);
        player3 = (Button)rootView.findViewById(R.id.player3);
        player3.setOnClickListener(this);
        player4 = (Button)rootView.findViewById(R.id.player4);
        player4.setOnClickListener(this);
        player5 = (Button)rootView.findViewById(R.id.player5);
        player5.setOnClickListener(this);
        player6 = (Button)rootView.findViewById(R.id.player6);
        player6.setOnClickListener(this);
        suppress = (Button)rootView.findViewById(R.id.suppress_button);
        suppress.setOnClickListener(this);
        launch = (Button)rootView.findViewById(R.id.launch_button);
        launch.setOnClickListener(this);

        return rootView;
    }


	@Override
	public void onClick(View v) { //TODO : add pop-up when click on a player (choose name + appareance ?)
		int x = v.getId();
		switch (x) {
		case R.id.player1:
			
			break;
		
		case R.id.player2:
			player3.setVisibility(View.VISIBLE);
			player2.setText(R.string.player2);
			break;
			
		case R.id.player3:
			player4.setVisibility(View.VISIBLE);
			player3.setText(R.string.player3);
			break;
	
		case R.id.player4:
			player5.setVisibility(View.VISIBLE);
			player4.setText(R.string.player4);
			break;
			
		case R.id.player5:
			player6.setVisibility(View.VISIBLE);
			player5.setText(R.string.player5);
			break;
			
		case R.id.player6:
			player6.setText(R.string.player6);
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
	
	private void suppress(){
		if(player6.getVisibility() == View.VISIBLE && !player6.getText().equals(getResources().getString(R.string.add))){
			player6.setText(R.string.add);
		}
		else if(player5.getVisibility() == View.VISIBLE && !player5.getText().equals(getResources().getString(R.string.add))){
			player6.setVisibility(View.INVISIBLE);
			player5.setText(R.string.add);
		}
		else if(player4.getVisibility() == View.VISIBLE && !player4.getText().equals(getResources().getString(R.string.add))){
			player5.setVisibility(View.INVISIBLE);
			player4.setText(R.string.add);
		}
		else if(player3.getVisibility() == View.VISIBLE && !player3.getText().equals(getResources().getString(R.string.add))){
			player4.setVisibility(View.INVISIBLE);
			player3.setText(R.string.add);
		}
		else if(player2.getVisibility() == View.VISIBLE && !player2.getText().equals(getResources().getString(R.string.add))){
			player3.setVisibility(View.INVISIBLE);
			player2.setText(R.string.add);
		}
	}
	
	private void launch(){//TODO : create controller with array of players in arg, create in game activity to link with
		
	}

}

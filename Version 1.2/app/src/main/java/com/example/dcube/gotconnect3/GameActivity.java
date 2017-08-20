package com.example.dcube.gotconnect3;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    int playerId;
    MediaPlayer sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        playerId = intent.getIntExtra("player" , -1);

    }

    public void playerSelect(){

        switch (playerId){
            case 0:
                counter.setImageResource(R.drawable.stark);
                break;
            case 1:
                counter.setImageResource(R.drawable.lanister);
                break;
            case 2:
                counter.setImageResource(R.drawable.targarian);
                break;
            case 3:
                counter.setImageResource(R.drawable.bolton);
                break;
            case 4:
                counter.setImageResource(R.drawable.martel);
                break;
            case 5:
                counter.setImageResource(R.drawable.tyrell);
                break;
            case 6:
                counter.setImageResource(R.drawable.greyjoy);
                break;
            case 7:
                counter.setImageResource(R.drawable.boratheon);
                break;
        }

    }

    int activePlayer = 0;
    int[] gameState= {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameIsActive = true;
    ImageView counter;

    public void dropIn (View view) {

        sp = MediaPlayer.create(this, R.raw.sword);

        counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                playerSelect(); // user input
                sp.start();

                activePlayer = 1;
            } else {

                counter.setImageResource(R.drawable.stark); //computer input

                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(500);

            for (int[] winningPosition : winningPositions){

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2 ){

                    gameIsActive = false;

                    String winner = "VALAR MORGHULIS ";
                    if (winningPosition[0] == 0){
                        winner = "YOU WON THE BATTLE ";
                    }

                    new AlertDialog.Builder(this)
                            .setIcon(android.R.drawable.btn_star)
                            .setTitle("RESULT")
                            .setMessage(winner)
                            .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    playAgain();
                                }
                            })
                            .show();

                } else {
                    boolean gameIsOver = true;
                    for (int counterState : gameState) {
                        if (counterState == 2) {
                            gameIsOver = false;
                        }
                    }
                    if(gameIsOver ){
                        new AlertDialog.Builder(this)
                                .setIcon(android.R.drawable.btn_star)
                                .setTitle("RESULT")
                                .setMessage("Its a Draw")
                                .setNegativeButton("Play Again", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        playAgain();
                                    }
                                })
                                .show();
                    }
                }
            }
        }
    }
    public void playAgain(){
        gameIsActive = true;
        activePlayer = 0;
        for (int i=0;i<gameState.length;i++){
            gameState[i] = 2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

}

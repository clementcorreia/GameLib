package com.b3espi.gamelib.morpion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.b3espi.gamelib.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Morpion extends AppCompatActivity {

    private ImageButton[] cases;

    private String [] grille;

    private int caseChoisie;
    private int [] idCase;

    private String joueur1;
    private String joueur2;

    private int joueur1Coup;
    private int joueur2Coup;

    private boolean joueur; // true : joueur 1 // false : joueur 2

    final private static int taille = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morpion_game);

        this.grille = new String [taille];

        Intent noms = getIntent();
        this.joueur1 = noms.getStringExtra(morpionPlay.JOUEUR1);
        this.joueur2 = noms.getStringExtra(morpionPlay.JOUEUR2);


        // Affichage du joueur qui doit jouer
        this.joueur = choixJoueur();
        TextView displayPlayer = (TextView) findViewById(R.id.textPlayerName);
        if(this.joueur) displayPlayer.setText(this.joueur1);
        else displayPlayer.setText(this.joueur2);
        this.joueur = !this.joueur;

        this.caseChoisie = -2;

        this.cases = new ImageButton[taille];

        // Grille
        this.idCase = new int[9];
        idCase[0] = R.id.case1;
        idCase[1] = R.id.case2;
        idCase[2] = R.id.case3;
        idCase[3] = R.id.case4;
        idCase[4] = R.id.case5;
        idCase[5] = R.id.case6;
        idCase[6] = R.id.case7;
        idCase[7] = R.id.case8;
        idCase[8] = R.id.case9;


        // Set Listener pour case et pions
        for(int i=0; i< idCase.length; i++){
            final int j = i;
            this.cases[i] = (ImageButton) findViewById(idCase[i]) ;
            this.cases[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    choixCase(j);
                }
            });

            }

    }


    private boolean choixJoueur(){
        Random rand = new Random();
        int i = rand.nextInt(2);
        if(i == 1) return true;
        else return false;
    }


    private void choixCase (int caseChoisie){
            if (caseChoisie != -1) {


                ImageButton caseMorpion = (ImageButton) findViewById(idCase[caseChoisie]);
                if (this.joueur) {
                    caseMorpion.setImageResource(R.drawable.croix_morpion);
                    this.grille[caseChoisie] = "X";
                }
                else {
                    caseMorpion.setImageResource(R.drawable.rond_morpion);
                    this.grille[caseChoisie] = "O";
                }
                caseMorpion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        choixCase(-1);
                    }
                });

                changementJoueur();
            }
    }

    private void changementJoueur(){
        TextView displayPlayer = (TextView) findViewById(R.id.textPlayerName);
        if(this.joueur) displayPlayer.setText(this.joueur1);
        else displayPlayer.setText(this.joueur2);
        this.joueur = !this.joueur;
    }

    public boolean testGagne() {
        boolean gagnant = false;
        if (this.grille[0] == this.grille [1] && this.grille [1] == this.grille [2]){
            gagnant = true;
        } else if (this.grille[0] == this.grille [1] && this.grille [1] == this.grille [2]){
            gagnant = true;
        } else if (this.grille[0] == this.grille [3] && this.grille [3] == this.grille [6]){
            gagnant = true;
        } else if (this.grille[3] == this.grille [4] && this.grille [4] == this.grille [5]){
            gagnant = true;
        } else if (this.grille[6] == this.grille [7] && this.grille [7] == this.grille [8]){
            gagnant = true;
        } else if (this.grille[1] == this.grille [4] && this.grille [4] == this.grille [7]){
            gagnant = true;
        } else if (this.grille[2] == this.grille [5] && this.grille [5] == this.grille [8]){
            gagnant = true;
        } else if (this.grille[0] == this.grille [4] && this.grille [4] == this.grille [8]){
            gagnant = true;
        } else if (this.grille[2] == this.grille [4] && this.grille [4] == this.grille [6]){
            gagnant = true;
        }
        return gagnant;
    }
}

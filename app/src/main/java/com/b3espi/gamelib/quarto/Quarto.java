package com.b3espi.gamelib.quarto;

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

public class Quarto extends AppCompatActivity {

    private ImageButton[] pions;
    private int[] idPion;

    private ImageButton[] cases;

    private int pionChoisit;
    private int caseChoisie;

    private String joueur1;
    private String joueur2;
    private boolean joueur; // true : joueur 1 // false : joueur 2

    private QuartoGrille quarto;

    final private static int taille = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_game);

        Intent noms = getIntent();
        this.joueur1 = noms.getStringExtra(QuartoPlay.JOUEUR1);
        this.joueur2 = noms.getStringExtra(QuartoPlay.JOUEUR2);


        this.quarto = new QuartoGrille();

        // Affichage du joueur qui doit jouer
        this.joueur = choixJoueur();
        TextView displayPlayer = (TextView) findViewById(R.id.textPlayerName);
        if(this.joueur) displayPlayer.setText(this.joueur1);
        else displayPlayer.setText(this.joueur2);
        this.joueur = !this.joueur;

        this.pionChoisit = -1;
        this.caseChoisie = -2;

        this.pions = new ImageButton[taille];
        this.cases = new ImageButton[taille];

        // Grille
        int[] idCase = new int[16];
        idCase[0] = R.id.case1;
        idCase[1] = R.id.case2;
        idCase[2] = R.id.case3;
        idCase[3] = R.id.case4;
        idCase[4] = R.id.case5;
        idCase[5] = R.id.case6;
        idCase[6] = R.id.case7;
        idCase[7] = R.id.case8;
        idCase[8] = R.id.case9;
        idCase[9] = R.id.case10;
        idCase[10] = R.id.case11;
        idCase[11] = R.id.case12;
        idCase[12] = R.id.case13;
        idCase[13] = R.id.case14;
        idCase[14] = R.id.case15;
        idCase[15] = R.id.case16;

        // Pions
        idPion = new int[16];
        idPion[0] = R.id.pion1;
        idPion[1] = R.id.pion2;
        idPion[2] = R.id.pion3;
        idPion[3] = R.id.pion4;
        idPion[4] = R.id.pion5;
        idPion[5] = R.id.pion6;
        idPion[6] = R.id.pion7;
        idPion[7] = R.id.pion8;
        idPion[8] = R.id.pion9;
        idPion[9] = R.id.pion10;
        idPion[10] = R.id.pion11;
        idPion[11] = R.id.pion12;
        idPion[12] = R.id.pion13;
        idPion[13] = R.id.pion14;
        idPion[14] = R.id.pion15;
        idPion[15] = R.id.pion16;

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

            this.pions[i] = (ImageButton) findViewById(idPion[i]);
            this.pions[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choixPion(j);
                }
            });
        }

    }

    public void boucleJeu() {

        QuartoGrille quarto = new QuartoGrille();

        ArrayList<String> gagne = quarto.gagne();
        while(gagne.isEmpty()){
            // ------ Choix du pion et de la case
            this.pion = this.choixPion(quarto);
            this.joueur = !this.joueur;
            this.cases = this.choixCase(quarto);

            quarto.setPionRestantI(this.pionChoisit, false); // effacement du pion dans this.pionRestant[]
            quarto.modifCase(quarto.getPion(this.pionChoisit-1), this.caseChoisie); // inscription dans la QuartoGrille.case[indiceC]
            quarto.setNulli(pionChoisit-1); // effacement du pion dans la grille
            gagne = quarto.gagne(); // vérification si un joueur a gagné

            if(!gagne.isEmpty()){
                System.out.println("Bravo, vous avez gagné ! Les caractéristiques qui gagnent sont les suivantes :");
                StringBuilder str = new StringBuilder();

                while(!gagne.isEmpty()){
                    str.append(gagne.remove(0));
                    str.append(" : ligne [");
                    int j = Integer.parseInt(gagne.remove(0)); // On dépile le premier indice de la ligne gagnante
                    str.append(QuartoGrille.getListeComb(j));
                    str.append(", ");
                    str.append(QuartoGrille.getListeComb(j+1));
                    str.append(", ");
                    str.append(QuartoGrille.getListeComb(j+2));
                    str.append(", ");
                    str.append(QuartoGrille.getListeComb(j+3));
                    str.append("]\n");
                }
            }
        }
    }

    private boolean choixJoueur(){
        Random rand = new Random();
        int i = rand.nextInt(2);
        if(i == 1) return true;
        else return false;
    }

    private void choixPion (int pionChoisit){
        if(this.pionChoisit == -1) {
            this.caseChoisie = -1;
            this.pionChoisit = pionChoisit;
            changementJoueur();
        }
    }

    private void choixCase (int caseChoisie){
        if(this.caseChoisie == -1) {
            ImageButton pion = (ImageButton) findViewById(idPion[this.pionChoisit]);
            pion.setImageResource(R.id);
            this.pions[this.pionChoisit].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choixPion(-2);
                }
            });

            this.pionChoisit = -1;
            this.caseChoisie = caseChoisie;
            if(!this.quarto.gagne().isEmpty()){
                // Start new activity partie finie
            }
            changementJoueur();
        }
    }

    private void changementJoueur(){
        TextView displayPlayer = (TextView) findViewById(R.id.textPlayerName);
        if(this.joueur) displayPlayer.setText(this.joueur1);
        else displayPlayer.setText(this.joueur2);
        this.joueur = !this.joueur;
    }
}

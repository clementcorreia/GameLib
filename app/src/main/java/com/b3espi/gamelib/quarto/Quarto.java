package com.b3espi.gamelib.quarto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.b3espi.gamelib.R;

import java.util.ArrayList;
import java.util.Random;

public class Quarto extends AppCompatActivity {

    private ImageButton[] pions;
    private int[] idPion;
    private int[] idCase;
    private int[] idPionDraw;


    private ImageButton[] cases;

    private int pionChoisit;
    private int caseChoisie;

    private String joueur1;
    private String joueur2;
    private boolean joueur; // true : joueur 1 // false : joueur 2

    private QuartoGrille quarto;

    public final static String GAGNANT = "com.b3espi.gamelib.quarto.GAGNANT";
    public final static String COMBINAISONS = "com.b3espi.gamelib.quarto.COMBINAISONS";

    private final static int taille = 16;

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
        this.idCase = new int[16];
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


        // Pions
        idPionDraw = new int[16];
        idPionDraw[0] = R.drawable.ligne_blanc_creux_carre;
        idPionDraw[1] = R.drawable.ligne_blanc_creux_rond;
        idPionDraw[2] = R.drawable.ligne_blanc_plein_carre;
        idPionDraw[3] = R.drawable.ligne_blanc_plein_rond;
        idPionDraw[4] = R.drawable.ligne_marron_creux_carre;
        idPionDraw[5] = R.drawable.ligne_marron_creux_rond;
        idPionDraw[6] = R.drawable.ligne_marron_plein_carre;
        idPionDraw[7] = R.drawable.ligne_marron_plein_rond;
        idPionDraw[8] = R.drawable.simple_blanc_creux_carre;
        idPionDraw[9] = R.drawable.simple_blanc_creux_rond;
        idPionDraw[10] = R.drawable.simple_blanc_plein_carre;
        idPionDraw[11] = R.drawable.simple_blanc_plein_rond;
        idPionDraw[12] = R.drawable.simple_marron_creux_carre;
        idPionDraw[13] = R.drawable.simple_marron_creux_rond;
        idPionDraw[14] = R.drawable.simple_marron_plein_carre;
        idPionDraw[15] = R.drawable.simple_marron_plein_rond;

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
            changementJoueur(true);
        }
    }

    private void choixCase (int caseChoisie){
        if(this.caseChoisie == -1) {
            ImageButton pion = (ImageButton) findViewById(idPion[this.pionChoisit]);
            pion.setImageResource(R.drawable.case_quarto);
            this.pions[this.pionChoisit].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choixPion(-2);
                }
            });

            // inscription dans la QuartoGrille.case[caseChoisie]
            this.quarto.modifCase(this.pionChoisit, caseChoisie);

            ImageButton caseQuarto = (ImageButton) findViewById(idCase[caseChoisie]);
            caseQuarto.setImageResource(this.idPionDraw[this.pionChoisit]);

            this.pionChoisit = -1;
            this.caseChoisie = caseChoisie;

            ArrayList<String> combinaisonGagnante = this.quarto.gagne();
            if(!combinaisonGagnante.isEmpty()){
                Intent intent = new Intent(Quarto.this, QuartoGagne.class);

                String nomGagnant;
                if (this.joueur) nomGagnant = this.joueur2;
                else  nomGagnant = this.joueur1;

                intent.putExtra(Quarto.GAGNANT, nomGagnant);
                intent.putStringArrayListExtra(Quarto.COMBINAISONS, combinaisonGagnante);
                startActivity(intent);
            }
            changementJoueur(false);
        }
    }

    private void changementJoueur(boolean changement){
        if(changement) {
            TextView displayPlayer = (TextView) findViewById(R.id.textPlayerName);
            if (this.joueur) displayPlayer.setText(this.joueur1);
            else displayPlayer.setText(this.joueur2);
            this.joueur = !this.joueur;
        }
    }
}

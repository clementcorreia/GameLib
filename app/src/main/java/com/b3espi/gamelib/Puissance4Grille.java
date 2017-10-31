package com.b3espi.gamelib;

import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by clementcorreia on 31/10/2017.
 */

public class Puissance4Grille extends Puissance4Play {

    /**
     * Grille représentant le puissance 4.
     * Si la case est à -1 alors c'est qu'elle est vide.
     * Sinon 0 pour rouge et 1 pour jaune.
     */
    private ImageButton[][] grille;

    public Puissance4Grille() {
        this.grille = new ImageButton[6][7];
        this.initialise();
    }

    public void initialise() {
        this.grille[0][0] = (ImageButton) findViewById(R.id.case00);
        this.grille[0][1] = (ImageButton) findViewById(R.id.case01);
        this.grille[0][2] = (ImageButton) findViewById(R.id.case02);
        this.grille[0][3] = (ImageButton) findViewById(R.id.case03);
        this.grille[0][4] = (ImageButton) findViewById(R.id.case04);
        this.grille[0][5] = (ImageButton) findViewById(R.id.case05);
        this.grille[0][6] = (ImageButton) findViewById(R.id.case06);
        this.grille[1][0] = (ImageButton) findViewById(R.id.case10);
        this.grille[1][1] = (ImageButton) findViewById(R.id.case11);
        this.grille[1][2] = (ImageButton) findViewById(R.id.case12);
        this.grille[1][3] = (ImageButton) findViewById(R.id.case13);
        this.grille[1][4] = (ImageButton) findViewById(R.id.case14);
        this.grille[1][5] = (ImageButton) findViewById(R.id.case15);
        this.grille[1][6] = (ImageButton) findViewById(R.id.case16);
        this.grille[2][0] = (ImageButton) findViewById(R.id.case20);
        this.grille[2][1] = (ImageButton) findViewById(R.id.case21);
        this.grille[2][2] = (ImageButton) findViewById(R.id.case22);
        this.grille[2][3] = (ImageButton) findViewById(R.id.case23);
        this.grille[2][4] = (ImageButton) findViewById(R.id.case24);
        this.grille[2][5] = (ImageButton) findViewById(R.id.case25);
        this.grille[2][6] = (ImageButton) findViewById(R.id.case26);
        this.grille[3][0] = (ImageButton) findViewById(R.id.case30);
        this.grille[3][1] = (ImageButton) findViewById(R.id.case31);
        this.grille[3][2] = (ImageButton) findViewById(R.id.case32);
        this.grille[3][3] = (ImageButton) findViewById(R.id.case33);
        this.grille[3][4] = (ImageButton) findViewById(R.id.case34);
        this.grille[3][5] = (ImageButton) findViewById(R.id.case35);
        this.grille[3][6] = (ImageButton) findViewById(R.id.case36);
        this.grille[4][0] = (ImageButton) findViewById(R.id.case40);
        this.grille[4][1] = (ImageButton) findViewById(R.id.case41);
        this.grille[4][2] = (ImageButton) findViewById(R.id.case42);
        this.grille[4][3] = (ImageButton) findViewById(R.id.case43);
        this.grille[4][4] = (ImageButton) findViewById(R.id.case44);
        this.grille[4][5] = (ImageButton) findViewById(R.id.case45);
        this.grille[4][6] = (ImageButton) findViewById(R.id.case46);
        this.grille[5][0] = (ImageButton) findViewById(R.id.case50);
        this.grille[5][1] = (ImageButton) findViewById(R.id.case51);
        this.grille[5][2] = (ImageButton) findViewById(R.id.case52);
        this.grille[5][3] = (ImageButton) findViewById(R.id.case53);
        this.grille[5][4] = (ImageButton) findViewById(R.id.case54);
        this.grille[5][5] = (ImageButton) findViewById(R.id.case55);
        this.grille[5][6] = (ImageButton) findViewById(R.id.case56);
        for(int row=0; row<6; row++) {
            for(int col=0; col<7; col++) {
                this.grille[row][col].setImageResource(R.drawable.boutonrouge);
            }
        }
    }

    public void playRouge(int col) {
        boolean trouve = false;
        for(int row=0; row<6 && !trouve; row++) {
            Integer resource = (Integer) this.grille[row][col].getTag();
            if(resource == R.drawable.boutonblanc) {
                trouve = true;
                this.grille[row][col].setImageResource(R.drawable.boutonrouge);
            }
        }
    }

    public void playJaune(int col) {
        boolean trouve = false;
        for(int row=0; row<6 && !trouve; row++) {
            Integer resource = (Integer) this.grille[row][col].getTag();
            if(resource == R.drawable.boutonblanc) {
                trouve = true;
                this.grille[row][col].setImageResource(R.drawable.boutonjaune);
            }
        }
    }

}

package com.b3espi.gamelib;

/**
 * Created by clementcorreia on 31/10/2017.
 */

public class Puissance4Grille {

    private int[][] grille;

    public Puissance4Grille() {
        this.grille = new int[6][7];
        this.initialise();
    }

    public void initialise() {
        for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                this.grille[i][j] = -1;
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b3espi.gamelib.morpion;

/**
 *
 * @author Thomas
 */
public class Grille {

    private final static int x = 3; // Taille des colonnes et lignes
    private char[][] tableau;

    public Grille() {
        initGrille();
    }

    public void initGrille(){
        this.tableau = new char[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                this.tableau[i][j] = ' ';
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("   0  1  2\n");
        str.append("0 (");
        str.append(this.tableau[0][0]);
        str.append(")(");
        str.append(this.tableau[0][1]);
        str.append(")(");
        str.append(this.tableau[0][2]);
        str.append(")\n");
        str.append("1 (");
        str.append(this.tableau[1][0]);
        str.append(")(");
        str.append(this.tableau[1][1]);
        str.append(")(");
        str.append(this.tableau[1][2]);
        str.append(")\n");
        str.append("2 (");
        str.append(this.tableau[2][0]);
        str.append(")(");
        str.append(this.tableau[2][1]);
        str.append(")(");
        str.append(this.tableau[2][2]);
        str.append(")\n");

        return str.toString();
    }

    /**
     * Ajoute @param choix à la position @param x et @param y du tableau
     * position [0] = x position [1] = y
     */
    public void ajouter(char choix, int x, int y) {
        this.tableau[x][y] = choix;
    }

    private boolean nonNul(int x, int y, int x2, int y2) {
        return this.tableau[x][y] != ' ' && this.tableau[x2][y2] != ' ';
    }

    private boolean testGagnant(int x, int y, int x2, int y2) {
        return nonNul(x, y, x2, y2) && this.tableau[x][y] == this.tableau[x2][y2];
    }

    public boolean testGagne() {
        boolean gagnant = false;
        if (testGagnant(0, 0, 0, 1) && testGagnant(0, 1, 0, 2)){
            gagnant = true;
        } else if (testGagnant(1, 0, 1, 1) && testGagnant(1, 1, 1, 2)){
            gagnant = true;
        } else if (testGagnant(2, 0, 2, 1) && testGagnant(2, 1, 2, 2)){
            gagnant = true;
        } else if (testGagnant(0, 0, 1, 0) && testGagnant(1, 0, 2, 0)){
            gagnant = true;
        } else if (testGagnant(0, 1, 1, 1) && testGagnant(1, 1, 2, 1)){
            gagnant = true;
        } else if (testGagnant(0, 2, 1, 2) && testGagnant(1, 2, 2, 2)){
            gagnant = true;
        } else if (testGagnant(0, 0, 1, 1) && testGagnant(1, 1, 2, 2)){
            gagnant = true;
        } else if (testGagnant(2, 2, 1, 1) && testGagnant(1, 1, 0, 0)){
            gagnant = true;
        } else if (testGagnant(0, 2, 1, 1) && testGagnant(1, 1, 2, 0)){
            gagnant = true;
        }
        return gagnant;
    }
}

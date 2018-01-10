/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

/**
 *
 * @author Thomas
 */
public class Grille {

    private final static int x = 3;
    private char[][] tableau;

    public Grille() {
        this.tableau = new char[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                this.tableau[i][j] = ' ';
            }
        }
    }

    public String toString() {
        String str = "";

        str += "(" + this.tableau[0][0] + ")(" + this.tableau[0][1] + ")(" + this.tableau[0][2] + ")\n";
        str += "(" + this.tableau[1][0] + ")(" + this.tableau[1][1] + ")(" + this.tableau[1][2] + ")\n";
        str += "(" + this.tableau[2][0] + ")(" + this.tableau[2][1] + ")(" + this.tableau[2][2] + ")\n";

        return str;
    }

    public void ajouter(char choix, int x, int y) { // position [0] = x position [1] = y
        this.tableau[x][y] = choix;
    }

    public boolean nonNul(int x, int y, int x2, int y2) {
        boolean bool = false;
        if (this.tableau[x][y] != ' ' && this.tableau[x2][y2] != ' ') {
            if (this.tableau[x][y] == this.tableau[x2][y2]) {
                bool = true;
            }
        }
        return bool;

    }

    public boolean testGagnant(int x, int y, int x2, int y2) {
        boolean gagnant = false;
        if (nonNul(x, y, x2, y2) == true) {

            if ((this.tableau[x][y] == 'X' || this.tableau[x][y] == 'O') && (this.tableau[x2][y2] == 'X' || this.tableau[x2][y2] == 'O')) {
                if (this.tableau[x][y] == this.tableau[x2][y2]) {
                    gagnant = true;
                }
            } else {
                gagnant = false;
            }
            return gagnant;
        }
        return gagnant;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tableau[i][j] = ' ';
            }
        }
    }
}

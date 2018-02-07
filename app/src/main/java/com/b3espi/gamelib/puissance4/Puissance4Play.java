package com.b3espi.gamelib.puissance4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.b3espi.gamelib.R;

public class Puissance4Play extends AppCompatActivity {

    /**
     * Grille représentant le puissance 4.
     * Si la case est à -1 alors c'est qu'elle est vide.
     * Sinon 0 pour rouge et 1 pour jaune.
     */
    private ImageButton[][] grille;
    private int[][] grilleValue;
    private String currentPlayer;
    private LinearLayout gagnant, indication, gagnantR, gagnantJ, egalite;
    private ImageButton boutonGagnantR, boutonGagnantJ;
    private Button retryButton;
    private static int cpt = 0;

    public void initialise() {
        System.out.println("Initialise");
        setContentView(R.layout.activity_puissance4_play);
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
                final int colIndex = col;
                this.grille[row][col].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        colorButton(colIndex);
                    }

                });
                this.grille[row][col].setClickable(true);
                this.grille[row][col].setImageResource(R.drawable.boutonblanc);
                this.grilleValue[row][col] = -1;
            }
        }

        ImageButton playerButton = (ImageButton) findViewById(R.id.casePlayer);
        if(Puissance4Play.cpt%2 == 0) {
            this.currentPlayer = "rouge";
            playerButton.setImageResource(R.drawable.boutonrouge);
        }
        else {
            this.currentPlayer = "jaune";
            playerButton.setImageResource(R.drawable.boutonjaune);
        }

        this.gagnant = (LinearLayout) findViewById(R.id.indicationGagnant);
        this.gagnantR = (LinearLayout) findViewById(R.id.indicationGagnantR);
        this.gagnantJ = (LinearLayout) findViewById(R.id.indicationGagnantJ);
        this.egalite = (LinearLayout) findViewById(R.id.indicationEgalite);
        this.indication = (LinearLayout) findViewById(R.id.indicationPartie);

        this.gagnant.setVisibility(LinearLayout.GONE);

        this.boutonGagnantR = (ImageButton) findViewById(R.id.caseGagnantR);
        this.boutonGagnantJ = (ImageButton) findViewById(R.id.caseGagnantJ);
    }

    public void fin() {
        for(int row=0; row<6; row++) {
            for(int col=0; col<7; col++) {
                this.grille[row][col].setClickable(false);
            }
        }
    }

    public boolean isTie() {
        boolean ok = false, abort = false;
        for(int row=0; row<6 && !abort; row++) {
            for(int col=0; col<7 && !abort; col++) {
                abort = (this.grilleValue[row][col] == -1);
            }
        }
        if(!abort) {
            ok = true;
        }
        return ok;
    }

    public void playRouge(int col) {
        boolean trouve = false;
        for(int row=0; row<6 && !trouve; row++) {
            int resource = this.grilleValue[row][col];
            if(resource == -1) {
                trouve = true;
                this.grille[row][col].setImageResource(R.drawable.boutonrouge);
                this.grilleValue[row][col] = 0;
                ImageButton playerButton = (ImageButton) findViewById(R.id.casePlayer);
                if(isColWin(row,col) || isRowWin(row,col) || isDiagonaleCroissanteWin(row,col) || isDiagonaleDecroissanteWin(row,col) || isTie()) {
                    if(isTie()) {
                        this.gagnantR.setVisibility(LinearLayout.GONE);
                        this.gagnantJ.setVisibility(LinearLayout.GONE);
                        this.egalite.setVisibility(LinearLayout.VISIBLE);
                        this.indication.setVisibility(LinearLayout.GONE);
                    }
                    else {
                        this.gagnantR.setVisibility(LinearLayout.VISIBLE);
                        this.gagnantJ.setVisibility(LinearLayout.GONE);
                        this.egalite.setVisibility(LinearLayout.GONE);
                        this.indication.setVisibility(LinearLayout.GONE);
                    }
                    this.gagnant.setVisibility(LinearLayout.VISIBLE);
                    this.boutonGagnantR.setImageResource(R.drawable.boutonrouge);
                    fin();
                }
                else {
                    playerButton.setImageResource(R.drawable.boutonjaune);
                }
                this.currentPlayer = "jaune";
            }
        }
    }

    public void playJaune(int col) {
        boolean trouve = false;
        for(int row=0; row<6 && !trouve; row++) {
            int resource = this.grilleValue[row][col];
            if(resource == -1) {
                trouve = true;
                this.grille[row][col].setImageResource(R.drawable.boutonjaune);
                this.grilleValue[row][col] = 1;
                ImageButton playerButton = (ImageButton) findViewById(R.id.casePlayer);
                if(isColWin(row,col) || isRowWin(row,col) || isDiagonaleCroissanteWin(row,col) || isDiagonaleDecroissanteWin(row,col) || isTie()) {
                    if(isTie()) {
                        this.gagnantR.setVisibility(LinearLayout.GONE);
                        this.gagnantJ.setVisibility(LinearLayout.GONE);
                        this.egalite.setVisibility(LinearLayout.VISIBLE);
                        this.indication.setVisibility(LinearLayout.GONE);
                    }
                    else {
                        this.gagnantR.setVisibility(LinearLayout.GONE);
                        this.gagnantJ.setVisibility(LinearLayout.VISIBLE);
                        this.egalite.setVisibility(LinearLayout.GONE);
                        this.indication.setVisibility(LinearLayout.GONE);
                    }
                    this.gagnant.setVisibility(LinearLayout.VISIBLE);
                    this.boutonGagnantJ.setImageResource(R.drawable.boutonjaune);
                    fin();
                }
                else {
                    playerButton.setImageResource(R.drawable.boutonrouge);
                }
                this.currentPlayer = "rouge";
            }
        }
    }

    public void colorButton(int col) {
        if(this.currentPlayer == "rouge") {
            playRouge(col);
        }
        else {
            playJaune(col);
        }
    }

    public boolean isColWin(int row, int col) {
        int cpt = 1, value = this.grilleValue[row][col];
        boolean ok = false, abort = false;
        for(int rowIndex = row-1; (rowIndex>(row-4) && rowIndex >= 0 && !ok && !abort); rowIndex--) {
            if(this.grilleValue[rowIndex][col] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        return ok;
    }

    public boolean isRowWin(int row, int col) {
        int cpt = 1, value = this.grilleValue[row][col];
        boolean ok = false, abort = false;
        for(int colIndex = col+1; (colIndex<(col+4) && colIndex < 7 && !ok && !abort); colIndex++) {
            if(this.grilleValue[row][colIndex] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        abort = false;
        for(int colIndex = col-1; (colIndex>(col-4) && colIndex >= 0 && !ok && !abort); colIndex--) {
            if(this.grilleValue[row][colIndex] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        return ok;
    }

    public boolean isDiagonaleCroissanteWin(int row, int col) {
        int cpt = 1, rowIndex = row, value = this.grilleValue[row][col];
        boolean ok = false, abort = false;
        for(int colIndex = col+1; (colIndex<(col+4) && colIndex < 7 && !ok && !abort && rowIndex < 5); colIndex++) {
            rowIndex++;
            if(this.grilleValue[rowIndex][colIndex] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        abort = false;
        rowIndex = row;
        for(int colIndex = col-1; (colIndex>(col-4) && colIndex >= 0 && !ok && !abort && rowIndex > 0); colIndex--) {
            rowIndex--;
            if(this.grilleValue[rowIndex][colIndex] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        return ok;
    }

    public boolean isDiagonaleDecroissanteWin(int row, int col) {
        int cpt = 1, rowIndex = row, value = this.grilleValue[row][col];
        boolean ok = false, abort = false;
        for(int colIndex = col+1; (colIndex<(col+4) && colIndex < 7 && !ok && !abort && rowIndex > 0); colIndex++) {
            rowIndex--;
            if(this.grilleValue[rowIndex][colIndex] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        abort = false;
        rowIndex = row;
        for(int colIndex = col-1; (colIndex>(col-4) && colIndex >= 0 && !ok && !abort && rowIndex < 5); colIndex--) {
            rowIndex++;
            if(this.grilleValue[rowIndex][colIndex] == value) {
                cpt++;
            }
            else {
                abort = true;
            }
            if(cpt == 4)
                ok = true;
        }
        return ok;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puissance4_play);

        this.currentPlayer = "jaune";

        this.grille = new ImageButton[6][7];
        this.grilleValue = new int[6][7];
        this.initialise();

        this.retryButton = (Button) findViewById(R.id.buttonRetryPuissance4);
        this.retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Puissance4Play.cpt++;
                finish();
                //Intent intent = new Intent(Puissance4Play.this, Puissance4Play.class);
                startActivity(getIntent());
            }
        });

    }
}

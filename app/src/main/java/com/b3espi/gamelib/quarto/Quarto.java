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
    private ImageButton[] cases;

    private int pionChoisit;
    private int caseChoisie;

    private String joueur1;
    private String joueur2;
    private boolean joueur; // true : joueur 1 // false : joueur 2

    final private static int taille = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_game);

        Intent noms = getIntent();
        this.joueur1 = noms.getStringExtra(QuartoPlay.JOUEUR1);
        this.joueur2 = noms.getStringExtra(QuartoPlay.JOUEUR2);
        this.joueur = choixJoueur();

        this.pionChoisit = -1;
        this.caseChoisie = -2;

        this.pions = new ImageButton[taille];
        this.cases = new ImageButton[taille];

        // Grille
        this.cases[0] = (ImageButton) findViewById(R.id.case1) ;
        this.cases[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(0);
            }
        });

        this.cases[1] = (ImageButton) findViewById(R.id.case2) ;
        this.cases[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(1);
            }
        });

        this.cases[2] = (ImageButton) findViewById(R.id.case3) ;
        this.cases[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(2);
            }
        });

        this.cases[3] = (ImageButton) findViewById(R.id.case4) ;
        this.cases[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(3);
            }
        });

        this.cases[4] = (ImageButton) findViewById(R.id.case5) ;
        this.cases[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(4);
            }
        });

        this.cases[5] = (ImageButton) findViewById(R.id.case6) ;
        this.cases[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(5);
            }
        });

        this.cases[6] = (ImageButton) findViewById(R.id.case7) ;
        this.cases[6].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(6);
            }
        });

        this.cases[7] = (ImageButton) findViewById(R.id.case8) ;
        this.cases[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(7);
            }
        });

        this.cases[8] = (ImageButton) findViewById(R.id.case9) ;
        this.cases[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(8);
            }
        });

        this.cases[9] = (ImageButton) findViewById(R.id.case10) ;
        this.cases[9].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(9);
            }
        });

        this.cases[10] = (ImageButton) findViewById(R.id.case11) ;
        this.cases[10].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(10);
            }
        });

        this.cases[11] = (ImageButton) findViewById(R.id.case12) ;
        this.cases[11].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(11);
            }
        });

        this.cases[12] = (ImageButton) findViewById(R.id.case13) ;
        this.cases[12].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(12);
            }
        });

        this.cases[13] = (ImageButton) findViewById(R.id.case14) ;
        this.cases[13].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(13);
            }
        });

        this.cases[14] = (ImageButton) findViewById(R.id.case15) ;
        this.cases[14].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(14);
            }
        });

        this.cases[15] = (ImageButton) findViewById(R.id.case16) ;
        this.cases[15].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choixCase(15);
            }
        });

        // Pions
        this.pions[0] = (ImageButton) findViewById(R.id.pion1);
        this.pions[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(0);
            }
        });

        this.pions[1] = (ImageButton) findViewById(R.id.pion2);
        this.pions[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(1);
            }
        });

        this.pions[2] = (ImageButton) findViewById(R.id.pion3);
        this.pions[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(2);
            }
        });

        this.pions[3] = (ImageButton) findViewById(R.id.pion4);
        this.pions[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(3);
            }
        });

        this.pions[4] = (ImageButton) findViewById(R.id.pion5);
        this.pions[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(4);
            }
        });

        this.pions[5] = (ImageButton) findViewById(R.id.pion6);
        this.pions[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(5);
            }
        });

        this.pions[6] = (ImageButton) findViewById(R.id.pion7);
        this.pions[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(6);
            }
        });

        this.pions[7] = (ImageButton) findViewById(R.id.pion8);
        this.pions[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(7);
            }
        });

        this.pions[8] = (ImageButton) findViewById(R.id.pion9);
        this.pions[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(8);
            }
        });

        this.pions[9]= (ImageButton) findViewById(R.id.pion10);
        this.pions[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(9);
            }
        });

        this.pions[10] = (ImageButton) findViewById(R.id.pion11);
        this.pions[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(10);
            }
        });

        this.pions[11] = (ImageButton) findViewById(R.id.pion12);
        this.pions[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(11);
            }
        });

        this.pions[12] = (ImageButton) findViewById(R.id.pion13);
        this.pions[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(12);
            }
        });

        this.pions[13] = (ImageButton) findViewById(R.id.pion14);
        this.pions[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(13);
            }
        });

        this.pions[14] = (ImageButton) findViewById(R.id.pion15);
        this.pions[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(14);
            }
        });

        this.pions[15] = (ImageButton) findViewById(R.id.pion16);
        this.pions[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choixPion(15);
            }
        });

    }

    public void boucleJeu() {

        QuartoGrille quarto = new QuartoGrille();
/*
        ArrayList<String> gagne = quarto.gagne();
        while(gagne.isEmpty()){
            // ------ Choix du pion et de la case
            this.pion = this.choixPion(quarto);
            this.joueur = !this.joueur;
            this.cases = this.choixCase(quarto);

            quarto.setPionRestantI(this.pion, false); // effacement du pion dans this.pionRestant[]
            quarto.modifCase(quarto.getPion(this.pion-1), this.cases); // inscription dans la QuartoGrille.case[indiceC]
            quarto.setNulli(pion-1); // effacement du pion dans la grille
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
                System.out.println("[0 ][1 ][2 ][3 ]\n[4 ][5 ][6 ][7 ]\n[8 ][9 ][10][11]\n[12][13][15][16]\n");
                System.out.println(str);
            }
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.print(quarto.construction());
        }*/
    }

    private boolean choixJoueur(){
        Random rand = new Random();
        int i = rand.nextInt(2);
        if(i == 1) return true;
        else return false;
    }

    private void choixPion (int pion){
        if(this.pionChoisit == -1) {
            this.pionChoisit = pion;
            this.caseChoisie = -1;
        }
    }

    private void choixCase (int caseChoisie){
        if(this.caseChoisie == -1) {
            this.pionChoisit = -1;
            this.caseChoisie = caseChoisie;
        }
    }
}

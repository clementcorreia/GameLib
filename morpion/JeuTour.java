/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.b3espi.gamelib.morpion;

import java.util.Scanner;

/**
 *
 * @author Thomas
 */
public class JeuTour {

    private Grille grilleMorpion;

    private Joueur joueur1;
    private Joueur joueur2;

    private char choix1;
    private char choix2;

    public JeuTour() {

        initJoueur();
        grilleMorpion = new Grille();
        System.out.println(grilleMorpion.toString());

        boucleJeu();
    }

    // Initialise les joueurs
    private void initJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Joueur 1 : ");
        this.joueur1 = new Joueur(sc.nextLine());
        System.out.print("Joueur 2 : ");
        this.joueur2 = new Joueur(sc.nextLine());
    }

    public void boucleJeu(){
        boolean rejouer = false;
        do {
            rejouer = false;
            choixDepart();
            choixTypePion();
            do{
                if(joueur1.isCommence()){
                    emplacement(joueur1);
                    System.out.println(this.grilleMorpion.toString());
                    if(!testGagne()){
                        emplacement(joueur2);
                        if(testGagne()){
                            joueur2.incrementeScore();
                            System.out.println(joueur2.getNom()+" a gagné !\nScore :\n"+joueur1.getNom()+" = "+joueur1.getScore()+"\n"+joueur2.getNom()+" = "+joueur2.getScore());
                        }
                    }
                    else{
                        joueur1.incrementeScore();
                        System.out.println(joueur1.getNom()+" a gagné !\nScore :\n"+joueur1.getNom()+" = "+joueur1.getScore()+"\n"+joueur2.getNom()+" = "+joueur2.getScore());
                    }
                }else{
                    emplacement(joueur2);
                    System.out.println(this.grilleMorpion.toString());
                    if(!testGagne()) {
                        emplacement(joueur1);
                        if(testGagne()) {
                            joueur1.incrementeScore();
                            System.out.println(joueur1.getNom()+" a gagné !\nScore :\n"+joueur1.getNom()+" = "+joueur1.getScore()+"\n"+joueur2.getNom()+" = "+joueur2.getScore());
                        }
                    }
                    else{
                        joueur2.incrementeScore();
                        System.out.println(joueur2.getNom()+" a gagné !\nScore :\n"+joueur1.getNom()+" = "+joueur1.getScore()+"\n"+joueur2.getNom()+" = "+joueur2.getScore());
                    }
                }
                System.out.println(this.grilleMorpion.toString());
            }while(!testGagne());

            System.out.println("Souhaitez-vous rejouez ? [O/N]");
            Scanner sc = new Scanner(System.in);
            String choixRejouer = sc.nextLine().toUpperCase();
            if (choixRejouer.equals("O")) {
                this.grilleMorpion.initGrille();
                rejouer = true;
            }
        }while(rejouer);
        System.out.println("Merci au revoir.");
    }

    /*
     * Choisit aléatoirement qui commence
     */
    public void choixDepart() {
        int temp;
        temp = (Math.random() <= 0.5) ? 1 : 2;
        if (temp == 1) {
            joueur1.setCommence(true);
            System.out.println(joueur1.getNom() + " commence la partie.");
        } else {
            joueur2.setCommence(false);
            System.out.println(joueur2.getNom() + " commence la partie.");
        }
    }

    /*
     * Choix du type de pion des deux joueurs
     */
    public void choixTypePion() {
        Scanner sc = new Scanner(System.in);

        System.out.println(joueur1.getNom()+" choissisez vos pions pour cette manche ['X' ou 'O' ou autre]");
        String str = sc.nextLine();
        joueur1.setTypePion(str.charAt(0));
        System.out.println(joueur1.getNom() + " jouera avec les " + joueur1.getTypePion());

        System.out.println(joueur2.getNom()+" choissisez vos pions pour cette manche ['X' ou 'O' ou autre]");
        joueur2.setTypePion(sc.nextLine().charAt(0));
        System.out.println(joueur2.getNom() + " jouera avec les " + joueur2.getTypePion());
    }

    /**
     * Demande au @param joueur de jouer et inscrit le choix dans la grille
     */
    private void emplacement(Joueur joueur) {
        Scanner sc = new Scanner(System.in);
        System.out.println(joueur.getNom() + " jouez");
        System.out.println("Choisissez une case x");
        int x1 = sc.nextInt();
        System.out.println("Choisissez une case y");
        int y1 = sc.nextInt();

        this.grilleMorpion.ajouter(joueur.getTypePion(), x1, y1);
    }

    /*
     * Return true si il y a une combinaison gagnante dans la grille
     * TODO : Retourner la combinaison gagnante et le joueur qui gagne
     */
    private boolean testGagne() {
        return this.grilleMorpion.testGagne();
    }
}

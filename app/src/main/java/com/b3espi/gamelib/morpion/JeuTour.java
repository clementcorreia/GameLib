/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

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

        choix();
    }

    // Initialise les joueurs
    private void initJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Joueur 1 : ");
        this.joueur1 = new Joueur(sc.nextLine());
        System.out.print("Joueur 2 : ");
        this.nomJoueur2 = new Joueur(sc.nextLine());
        sc.close();
    }

    public void boucleJeu(){

        do {
            boolean rejouer = false;
            choixDepart();
            choixTypePion();

            do{
                if(joueur1.isCommence()){
                    emplacement(joueur1);
                    if(!testGagne()) emplacement(joueur2);
                    else{
                        System.out.println(joueur1.getNom()+" a gagné !\nScore :\n"+joueur1.getNom()+" = "+joueur1.getScore()+"\n"+joueur1.getNom()+" = "+joueur1.getScore());
                    }
                }else{
                    emplacement(joueur2);
                    if(!testGagne()) emplacement(joueur1);
                    else{
                        System.out.println(joueur2.getNom()+" a gagné !\nScore :\n"+joueur1.getNom()+" = "+joueur1.getScore()+"\n"+joueur1.getNom()+" = "+joueur1.getScore());
                    }
                }
                joueur1.setCommence(!joueur1.isCommence());
                joueur2.setCommence(!joueur2.isCommence());
            }while(!testGagne());

            System.out.println("Souhaitez-vous rejouez ? [O/N]");
            Scanner sc = new Scanner(System.in);
            String choixRejouer = sc.nextLine().toUpperCase();
            if (choixRejouer == "O") {
                this.grilleMorpion.clear();
                rejouer = true;
            }
        }while(rejouer)
    }

    //  CHOISIS ALEATOIREMENT QUI COMMENCE LA PARTIE
    //
    public void choixDepart() {
        int temp;
        temp = (Math.random() <= 0.5) ? 1 : 2;
        if (temp == 1) {
            joueur1.setCommence(true);
            System.out.println(joueur1.getNom() + " commence la partie et choisis ses pions ");
        } else {
            joueur2.setCommence(false);
            System.out.println(joueur2.getNom() + " commence la partie et choisis ses pions ");
        }
    }

    //  CHOIX PION
//
    public void choixTypePion() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" Choissisez vos pions pour cette manche ['X' ou 'O' ou autre]");
        joueur1.setTypePion(sc.nextLine().charAt(0));
        System.out.println(joueur2.getNom() + " jouera avec les " + joueur1.getTypePion());

        System.out.println(" Choissisez vos pions pour cette manche ['X' ou 'O' ou autre]");
        joueur2.setTypePion(sc.nextLine().charAt(0));
        System.out.println(joueur2.getNom() + " jouera avec les " + joueur2.getTypePion());
    }

    private void emplacement(Joueur joueur) {
        Scanner sc = new Scanner(System.in);
        System.out.println(joueur.getNom() + " jouez");
        System.out.println("Choisissez une case x");
        int x1 = sc.nextInt();
        System.out.println("Choisissez une case y");
        int y1 = sc.nextInt();

        this.grilleMorpion.ajouter(joueur.getTypePion(), x1, y1);
    }

    // // gagnant == toujours true
    //
    private boolean testGagne() {
        if (grilleMorpion.testGagnant(0, 0, 0, 1)) {
            if (grilleMorpion.testGagnant(0, 1, 0, 2)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(1, 0, 1, 1)) {
            if (grilleMorpion.testGagnant(1, 1, 1, 2)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(2, 0, 2, 1)) {
            if (grilleMorpion.testGagnant(2, 1, 2, 2)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(0, 0, 1, 0)) {
            if (grilleMorpion.testGagnant(1, 0, 2, 0)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(0, 1, 1, 1)) {
            if (grilleMorpion.testGagnant(1, 1, 2, 1)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(0, 2, 1, 2)) {
            if (grilleMorpion.testGagnant(1, 2, 2, 2)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(0, 0, 1, 1)) {
            if (grilleMorpion.testGagnant(1, 1, 2, 2)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(2, 2, 1, 1)) {
            if (grilleMorpion.testGagnant(1, 1, 0, 0)) {
                gagnant = true;
            }
        } else if (grilleMorpion.testGagnant(0, 2, 1, 1)) {
            if (grilleMorpion.testGagnant(1, 1, 2, 0)) {
                gagnant = true;
            }
        } else {
            gagnant = false;
        }
        return gagnant;
    }
}

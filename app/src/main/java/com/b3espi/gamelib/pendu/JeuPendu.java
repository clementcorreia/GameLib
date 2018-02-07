package com.b3espi.gamelib.pendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class JeuPendu {

    private String joueur;
    private String motADeviner;
    private String[] motCourant;
    private int nombreEssais;

    /* A faire :
     *  Finir boucle while ligne 31 => condition si pas gagne ni nombre d'essai
     */


    public JeuPendu(){
        boucleJeu();
    }

    public void boucleJeu(){
        Scanner sc = new Scanner(System.in);
        this.nombreEssais = 10;
        this.motADeviner = choixMot();

        this.motCourant = new String[this.motADeviner.length()];
        for(int i =0; i<this.motCourant.length; i++){
            this.motCourant[i] = " _ ";
        }

        while(true) {
            System.out.println(affichage());
            System.out.println("Entrez une lettre (Vous avez "+this.nombreEssais+" essais) :");
            String choix = sc.nextLine().toUpperCase();

            if(this.motADeviner.contains(choix)){
                remplacer(choix);
                System.out.println(affichage());
            }else{
                this.nombreEssais--;
                System.out.println("Perdu, recommencez");
            }
            System.out.println(this.motADeviner);
        }

    }

    /*
     * Prérequis : choix est contenu dans this.motADeviner
     */
    public void remplacer(String choix){
        for(int i=0; i<this.motADeviner.length(); i++){
            if(choix.equals(this.motADeviner.substring(i,i+1))){
                this.motCourant[i] = choix;
            }
        }
    }

    public String choixMot() {
        //Random rand = new Random();
        //int i = rand.nextInt(2);
        int nb = (int)(Math.random() * 835);
        try {
            BufferedReader br = new BufferedReader(new FileReader("dico.txt"));
            String line = "";
            for(int i=0; i<nb; i++){
                line = br.readLine();
            }
            br.close();
            return line;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Echec";
    }

    public String affichage (){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<this.motCourant.length; i++){
            str.append(this.motCourant[i]);
        }
        return str.toString();
    }
}

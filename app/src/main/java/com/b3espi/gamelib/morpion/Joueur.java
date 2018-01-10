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
public class Joueur {

    private String nom;
    private int score;
    private boolean commence;
    private char typePion;

    public Joueur(String nom){
        this.nom = nom;
    }

    public char getTypePion() {
        return typePion;
    }

    public void setTypePion(char typePion) {
        this.typePion = typePion;
    }

    public boolean isCommence() {
        return commence;
    }

    public void setCommence(boolean commence) {
        this.commence = commence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

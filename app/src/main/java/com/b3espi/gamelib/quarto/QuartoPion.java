package com.b3espi.gamelib.quarto;

public class QuartoPion {

	private String taille;    // Moyen / Grand
	private String couleur;   // Blanc / Noir
	private String interieur; // Vide / Plein
	private String forme;     // Rond / Carré
	
	public QuartoPion(String t, String c, String i, String f){
		
		this.taille = t;
		this.couleur = c;
		this.interieur = i;
		this.forme = f;
	}

	public String getTaille() {
		return taille;
	}

	public String getCouleur() {
		return couleur;
	}

	public String getInterieur() {
		return interieur;
	}

	public String getForme() {
		return forme;
	}
	
	public boolean memeTaille(QuartoPion a, QuartoPion b, QuartoPion c){
		if(a.getTaille().equals(b.getTaille()) && a.getTaille().equals(c.getTaille()) && a.getTaille().equals(this.getTaille())) return true;
		else return false;
	}
	
	public boolean memeCouleur(QuartoPion a, QuartoPion b, QuartoPion c){
		if(a.getCouleur().equals(b.getCouleur()) && a.getCouleur().equals(c.getCouleur()) && a.getCouleur().equals(this.getCouleur())) return true;
		else return false;
	}
	
	public boolean memeInterieur(QuartoPion a, QuartoPion b, QuartoPion c){
		if(a.getInterieur().equals(b.getInterieur()) && a.getInterieur().equals(c.getInterieur()) && a.getInterieur().equals(this.getInterieur())) return true;
		else return false;
	}
	
	public boolean memeForme(QuartoPion a, QuartoPion b, QuartoPion c){
		if(a.getForme().equals(b.getForme()) && a.getForme().equals(c.getForme()) && a.getForme().equals(this.getForme())) return true;
		else return false;
	}
}

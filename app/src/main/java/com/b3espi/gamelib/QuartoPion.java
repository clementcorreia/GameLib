package com.b3espi.gamelib;

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
	
	public String toStringPion(){
		StringBuilder str = new StringBuilder();
		str.append(taille);
		str.append(couleur);
		str.append(" ");
		str.append(interieur);
		str.append(forme);
		return str.toString();
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
	
	public void setTaille(String taille) {
		this.taille = taille;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setInterieur(String interieur) {
		this.interieur = interieur;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}
	
	public void setNull() {
		
		this.taille = " ";
		this.couleur = " ";
		this.interieur = " ";
		this.forme = " ";
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

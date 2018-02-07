package com.b3espi.gamelib.quarto;

import java.util.ArrayList;

public class QuartoGrille {
	
	// Attributs --------------------------------------------------------
	private QuartoPion[] pions; // tableau des pions de la grille
	private QuartoPion[] listeCase; // tableau des cases épurées pour calculer siGagne()

	private static final int taille = 16; // taille des différents tableaux
	private static final int[] listeComb = new int[40]; // Liste des combinaisons a tester pour le gain
	
	// ------------------------------------------------------------------

	public QuartoGrille() {
		
		pions = new QuartoPion[taille];
		listeCase = new QuartoPion[taille];

		// --------------- PIONS ---------------
		pions[0] = new QuartoPion("G", "B", "V", "C");
		pions[1] = new QuartoPion("G", "B", "V", "R");
		pions[2] = new QuartoPion("G", "B", "P", "C");
		pions[3] = new QuartoPion("G", "B", "P", "R");

		pions[4] = new QuartoPion("G", "N", "V", "C");
		pions[5] = new QuartoPion("G", "N", "V", "R");
		pions[6] = new QuartoPion("G", "N", "P", "C");
		pions[7] = new QuartoPion("G", "N", "P", "R");

		pions[8] = new QuartoPion("M", "B", "V", "C");
		pions[9] = new QuartoPion("M", "B", "V", "R");
		pions[10] = new QuartoPion("M", "B", "P", "C");
		pions[11] = new QuartoPion("M", "B", "P", "R");

		pions[12] = new QuartoPion("M", "N", "V", "C");
		pions[13] = new QuartoPion("M", "N", "V", "R");
		pions[14] = new QuartoPion("M", "N", "P", "C");
		pions[15] = new QuartoPion("M", "N", "P", "R");

		// INITIALISATION LISTE GAIN ------------
		// Lignes
		for(int i=0; i<16; i++){
			QuartoGrille.listeComb[i] = i;
		}
		
		// Colonnes
		QuartoGrille.listeComb[16] = 0;
		QuartoGrille.listeComb[17] = 4;
		QuartoGrille.listeComb[18] = 8;
		QuartoGrille.listeComb[19] = 12;
		
		QuartoGrille.listeComb[20] = 1;
		QuartoGrille.listeComb[21] = 5;
		QuartoGrille.listeComb[22] = 9;
		QuartoGrille.listeComb[23] = 13;
		
		QuartoGrille.listeComb[24] = 2;
		QuartoGrille.listeComb[25] = 6;
		QuartoGrille.listeComb[26] = 10;
		QuartoGrille.listeComb[27] = 14;
		
		QuartoGrille.listeComb[28] = 3;
		QuartoGrille.listeComb[29] = 7;
		QuartoGrille.listeComb[30] = 11;
		QuartoGrille.listeComb[31] = 15;
		
		// Diagonales
		QuartoGrille.listeComb[32] = 0;
		QuartoGrille.listeComb[33] = 5;
		QuartoGrille.listeComb[34] = 10;
		QuartoGrille.listeComb[35] = 15;
		
		QuartoGrille.listeComb[36] = 3;
		QuartoGrille.listeComb[37] = 6;
		QuartoGrille.listeComb[38] = 9;
		QuartoGrille.listeComb[39] = 12;
	}
	
	// ----------------------------------------------------------------------------------------------------------
	// ---------------------------------------------METHODES UTILES----------------------------------------------
	// ----------------------------------------------------------------------------------------------------------
	public static int getListeComb(int i){
		return QuartoGrille.listeComb[i];
	}

	public QuartoPion getPion (int i){ // retourne un String du pion à l'indice i
		return this.pions[i];
	}
	
	public void setListeCase(QuartoPion p, int i){
		this.listeCase[i] = new QuartoPion(p.getTaille(), p.getCouleur(), p.getInterieur(), p.getForme());
	}
	
	public void modifCase (int pion, int caseChoisie){ // Effectue les modifications dans les attributs pour que la case ne soit plus dispo
		this.setListeCase(getPion(pion), caseChoisie); // Pour gestion de gain
	}
	
	/*
	 * retourne une ArrayList<String> selon : [0]: le critère qui fait gagner
	 * 							  			 [1]: listeComb[j]
	 */
	public ArrayList<String> gagne (){
		
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i = 0; i< QuartoGrille.listeComb.length; i+=4){
			if(this.listeCase[QuartoGrille.listeComb[i]] != null && this.listeCase[QuartoGrille.listeComb[i+1]] != null && this.listeCase[QuartoGrille.listeComb[i+2]] != null && this.listeCase[QuartoGrille.listeComb[i+3]] != null){
				if( this.listeCase[QuartoGrille.listeComb[i]].memeCouleur(this.listeCase[QuartoGrille.listeComb[i+1]], this.listeCase[QuartoGrille.listeComb[i+2]], this.listeCase[QuartoGrille.listeComb[i+3]])){
					// Gain par les couleurs, case j à j+4
					res.add("couleur");
					res.add(Integer.toString(i));
				}
			
				if( this.listeCase[QuartoGrille.listeComb[i]].memeTaille(this.listeCase[QuartoGrille.listeComb[i+1]], this.listeCase[QuartoGrille.listeComb[i+2]], this.listeCase[QuartoGrille.listeComb[i+3]])){
					// Gain par les Tailles, case j à j+4
					res.add("taille");
					res.add(Integer.toString(i));
				}
			
				if( this.listeCase[QuartoGrille.listeComb[i]].memeInterieur(this.listeCase[QuartoGrille.listeComb[i+1]], this.listeCase[QuartoGrille.listeComb[i+2]], this.listeCase[QuartoGrille.listeComb[i+3]])){
					// Gain par les Interieur, case j à j+4
					res.add("interieur");
					res.add(Integer.toString(i));
				}
			
				if( this.listeCase[QuartoGrille.listeComb[i]].memeForme(this.listeCase[QuartoGrille.listeComb[i+1]], this.listeCase[QuartoGrille.listeComb[i+2]], this.listeCase[QuartoGrille.listeComb[i+3]])){
					// Gain par les Forme, case j à j+4
					res.add("forme");
					res.add(Integer.toString(i));
				}
			}
		}
		return res;
	}
}

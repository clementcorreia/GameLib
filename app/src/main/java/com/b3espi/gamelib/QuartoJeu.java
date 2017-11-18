package com.b3espi.gamelib;

import java.util.ArrayList;
import java.util.Scanner;

public class QuartoJeu {
	
	private int pion; // pion : numéro du pion choisit
	private String cases;
	private boolean joueur; // true : joueur 1 // false : joueur 2
	
	public QuartoJeu(){
		this.joueur = true;
		this.boucleJeu();
	}
	
	public void boucleJeu() {
		System.out.println("Règles :\nLa colonne de droite vous donne la liste des pions disponibles.\nChaque pion est caractérisé par 4 caractéristiques :\n- M/G : Moyen ou Grand\n- B/N : Blanc ou Noir\n- V/P : Vide ou Plein\n- R/C : Rond ou Carré\n\nLe but est de former un ligne ou colonne ou diagonale de quatre pions respectants un de ces critères en commun.\nL'adversaire choisit le pion que vous allez placer.\n\n\n");
		
		QuartoGrille quarto = new QuartoGrille();
		System.out.println(quarto.construction());
		
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
		}
	}
	
	private int choixPion (QuartoGrille g){
		int pion;
		boolean boucle = false;
		String question = "Choisissez un pion (1 à 16)";
		Scanner sc = new Scanner(System.in);

		if (this.joueur) question += " (JOUEUR 1)";
		else question += " (JOUEUR 2)";
		
		do { // vérification du pion
			System.out.println(question);
			pion = sc.nextInt();
		
			if (pion<1) {System.out.println("Erreur : QuartoPion négatif"); boucle = true;}
			else if (pion>16) {System.out.println("Erreur : QuartoPion supérieur à 16"); boucle = true;}
			else if (!g.getPionRestant(pion)) {System.out.println("Erreur : QuartoPion non disponible"); boucle = true;}
			else boucle = false;
			
		} while (boucle);
		sc.close();
		return pion;
	}
	
	private String choixCase (QuartoGrille g){
		String cases;
		String question = "Ou voulez-vous le placer ? (Par ex : 'A1')";
		Scanner sc = new Scanner(System.in);

		if (this.joueur) question += " (JOUEUR 1)";
		else question += " (JOUEUR 2)";
		
		do {
			System.out.println(question);
			cases = sc.nextLine();
		} while (!g.caseOk(cases));
		sc.close();
		return cases;
	}
}

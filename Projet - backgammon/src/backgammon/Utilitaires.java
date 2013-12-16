/**
 * @author Amellal Ibrahim & Jonathan Seynaeve
 */
package backgammon;
import java.util.Random;


public class Utilitaires {

	/**
	 * Initialisateur 
	 * @return Retour un plateau avec des pions places sur chaque colonne
	 */
	public static Colonne [] initialisation () 
	{
		Colonne [] plateau = new Colonne[26];

		for (int i = 0; i < 26; i++)
		{
			plateau[i] = new Colonne(i);
		}
		plateau[1].addPion(new Pion(1),1);
		plateau[1].addPion(new Pion(1),1);

		plateau[6].addPion(new Pion(2),2);
		plateau[6].addPion(new Pion(2),2);
		plateau[6].addPion(new Pion(2),2);
		plateau[6].addPion(new Pion(2),2);
		plateau[6].addPion(new Pion(2),2);

		plateau[8].addPion(new Pion(2),2);
		plateau[8].addPion(new Pion(2),2);
		plateau[8].addPion(new Pion(2),2);

		plateau[12].addPion(new Pion(1),1);
		plateau[12].addPion(new Pion(1),1);
		plateau[12].addPion(new Pion(1),1);
		plateau[12].addPion(new Pion(1),1);
		plateau[12].addPion(new Pion(1),1);

		plateau[13].addPion(new Pion(1),2);
		plateau[13].addPion(new Pion(1),2);
		plateau[13].addPion(new Pion(1),2);
		plateau[13].addPion(new Pion(1),2);
		plateau[13].addPion(new Pion(1),2);


		plateau[17].addPion(new Pion(1),1);
		plateau[17].addPion(new Pion(1),1);
		plateau[17].addPion(new Pion(1),1);

		plateau[19].addPion(new Pion(1),1);
		plateau[19].addPion(new Pion(1),1);
		plateau[19].addPion(new Pion(1),1);
		plateau[19].addPion(new Pion(1),1);
		plateau[19].addPion(new Pion(1),1);


		plateau[24].addPion(new Pion(2),2);
		plateau[24].addPion(new Pion(2),2);


		return plateau;
	}
	/**
	 * Methode generant un nombre entre 1 et 6
	 * @return un nombre entre 1 et 6 compris
	 */
	public static int roll() 
	{
		Random rnd = new Random();
		return (rnd.nextInt(6) + 1);
	}
	/**
	 * Methode dŽterminant si le joueur peut avancer a la colonne a
	 * @param a Numero de la colonne
	 * @param plateau plateau de jeu
	 * @param joueur Joueur en question
	 * @return true si il peut y aller false sinon
	 */
	public static boolean avancable (int a, Colonne [] plateau, Joueur joueur) 
	{
		if (a > 25) {return joueur.isArrivable();} 
		if (a < 0) {return joueur.isArrivable();} 
		return plateau[(a)].getDisponible(plateau[a].getCouleur());
	}
	/**
	 * Methode retournant un plateau avec le pion avance a la place demandee
	 * @param colonne Numero de la colonne actuelle
	 * @param cases Nombre de cases desirees
	 * @param plateau plateau
	 * @param joueur joueur en cours
	 * @return plateau mis a jour
	 */
	public static Colonne[] avance(int colonne, int cases, Colonne [] plateau, Joueur joueur) 
	{

		Colonne[] plateau1 = plateau;
		switch (joueur.getCouleur())
		{
		case 1 : 	if(colonne + cases - 1 > 24 && joueur.isArrivable()) 
		{
			plateau1[colonne].deletePion();
			joueur.setPionsRetraites(joueur.getPionsRetraites() + 1); 
			break;
		}
		if (plateau1[colonne + cases - 1].getCompteur() == 1 && plateau1[colonne + cases - 1].getCouleur() != joueur.getCouleur())
		{
			caseDepart(plateau1, colonne + cases - 1, joueur.getCouleur());

		}
		plateau1[colonne + cases -1].addPion(plateau[colonne].getPion(),joueur.getCouleur());
		plateau1[colonne].deletePion(); break;
		case 2 :  	if(colonne - cases  < 0 && joueur.isArrivable()) 
		{
			plateau1[colonne].deletePion();
			joueur.setPionsRetraites(joueur.getPionsRetraites() + 1); 
			break;}
		if(colonne - cases  < 0 && !joueur.isArrivable()) {break;}
		if (plateau1[colonne - cases + 1].getCompteur() == 1 && plateau1[colonne - cases + 1].getCouleur() != joueur.getCouleur())
		{
			caseDepart(plateau1, colonne - cases + 1, joueur.getCouleur());
		} 
		plateau1[colonne - cases +1].addPion(plateau[colonne].getPion(),joueur.getCouleur());
		plateau1[colonne].deletePion();
		}
		return plateau1;
	}
	/**
	 * Methode renvoyant un plateau avec les colonnes jouables mises a jour apres coup de des
	 * @param plateau plateau de 26 colonnes
	 * @param joueur joueur
	 * @param roll1 Score du de 1
	 * @param roll2 Score du de 2
	 * @return plateau mis a jour
	 */
	public static Colonne [] scannage (Colonne [] plateau, Joueur joueur, int roll1, int roll2) 
	{
		Colonne[] retour = plateau;
		int a = joueur.getCouleur();
		switch(a) {
		case 1 : 
			for (int i  = 0; i < 26; i++) 
			{
				if (retour[i].getCouleur() == joueur.getCouleur() && retour[i].getCompteur() != 0)
				{
					if (i + roll1 >= 24) {if (joueur.isArrivable()) {retour[i].setCol1(-1);}}
					else {

						if (retour[i + roll1].getDisponible(joueur.getCouleur())) 
						{
							retour[i].setCol1(i + roll1);
						}
					}
					if (i + roll2 >= 24) {if (joueur.isArrivable()) {retour[i].setCol1(-1);}}
					else {

						if ( retour[i + roll2].getDisponible(joueur.getCouleur()))
						{
							retour[i].setCol2(i + roll2);

						}

					}
				}
			}
			break;

		case 2 : 
			for (int i  = 0; i < 26; i++) 
			{
				if (retour[i].getCouleur() == joueur.getCouleur() && retour[i].getCompteur() != 0)
				{
					if (i - roll1 <= 0) { if (joueur.isArrivable()) {retour[i].setCol1(-1);}}
					else {

						if (retour[i - roll1].getDisponible(joueur.getCouleur())) 
						{
							retour[i].setCol1(i - roll1);
						}
					}
					if (i - roll2 <= 0) { if (joueur.isArrivable()) {retour[i].setCol2(-1);}}
					else {

						if ( retour[i - roll2].getDisponible(joueur.getCouleur()))
						{
							retour[i].setCol2(i - roll2);
						}
					}
				}
			}

		}
		return retour;
	}
	/**
	 * Methode renvoyant un tableau avec le pion renvoye a la case depart sans passer par la prison et sans toucher les 20000 Francs
	 * @param plateau plateau de 26 colonnes
	 * @param colonne colonne sur laquelle se trouve le pion a ejecter
	 * @param couleur couleur du joueur
	 * @return le plaeau mis a jour
	 */
	public static  Colonne[] caseDepart(Colonne [] plateau, int colonne, int couleur) 
	{
		Colonne [] plateau1 = plateau;
		switch (couleur) 
		{
		case 1 : plateau1[25].addPion(plateau1[colonne].getPion(), 2); plateau1[colonne].deletePion(); break;
		case 2 : plateau1[0].addPion(plateau1[colonne].getPion(), 1); plateau1[colonne].deletePion();
		}
		return plateau1;
	} 
}

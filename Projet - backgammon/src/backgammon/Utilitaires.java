package backgammon;
import java.util.Random;


public class Utilitaires {

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

	public static int roll() 
	{
		Random rnd = new Random();
		return (rnd.nextInt(6) + 1);
	}

	public static boolean avancable (int a, Colonne [] plateau) 
	{
		if (a > 24) {return true;}
		if (a <0) {return true;}
		return plateau[(a)].getDisponible(plateau[a].getCouleur());

	}


	public static Colonne[] avance2(int colonne, int cases, Colonne [] plateau, Joueur joueur) 
	{

		Colonne[] plateau1 = plateau;

		switch (joueur.getCouleur())
		{
		case 1 : 	if(colonne + cases - 1 > 24 ) 
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

		case 2 :  	if(colonne - cases  < 0 ) 
					{
					plateau1[colonne].deletePion();
					joueur.setPionsRetraites(joueur.getPionsRetraites() + 1); 
					break;}
		
					if (plateau1[colonne - cases + 1].getCompteur() == 1 && plateau1[colonne - cases + 1].getCouleur() != joueur.getCouleur())
					{
					caseDepart(plateau1, colonne - cases + 1, joueur.getCouleur());
					
					
					} 
		plateau1[colonne - cases +1].addPion(plateau[colonne].getPion(),joueur.getCouleur());
		plateau1[colonne].deletePion();
		}
		
		return plateau1;

	}

	public static Colonne[] avance2(int colonne, int cases, Colonne [] plateau, int couleur) 
	{

		Colonne[] plateau1 = plateau;

		switch (couleur)
		{
		case 1 : 	
			plateau1[colonne + cases -1].addPion(plateau[colonne].getPion(),couleur);
			plateau1[colonne].deletePion(); break;

		case 2 :  	plateau1[colonne - cases +1].addPion(plateau[colonne].getPion(),couleur);
		plateau1[colonne].deletePion();
		System.out.println(plateau[colonne - cases +1].getCompteur());
		}
		System.out.println("Pions en place : " + plateau[colonne + cases - 1].getCompteur() + plateau[colonne + cases - 1].getDisponible(couleur));
		System.out.println("Colonnes dispos : " + plateau[colonne + cases - 1].getCol1() + " " +  plateau[colonne + cases - 1].getCol1());

		return plateau1;

	}
	public static void affiche (Colonne [] plateau) 
	{
		for (int i = 0; i < 26; i++) 
		{
			String couleur = "";
			if (plateau[i].getCompteur() == 0) {couleur = "";}
			if (plateau[i].getCouleur() == 1 ) {couleur = "blancs";}
			if (plateau[i].getCouleur() == 2 ) {couleur = "noirs";}
			System.out.println("Colonne " + (plateau[i].getNumero() +1) + " : " + plateau[i].getCompteur() + " pions " + couleur);
		}
	}


	public static Colonne [] scannage (Colonne [] plateau, int couleur, int roll1, int roll2) 
	{
		Colonne[] retour = plateau;

		switch(couleur) {
		case 1 : 
			for (int i  = 0; i < 26; i++) 
			{
				if (retour[i].getCouleur() == couleur && retour[i].getCompteur() != 0)
				{
					if (i + roll1 >= 24) {retour[i].setCol1(25);}
					else {

						if (retour[i + roll1].getDisponible(couleur)) 
						{
							retour[i].setCol1(i + roll1);
						}
					}
					if (i + roll2 >= 24) {retour[i].setCol2(25);}
					else {

						if ( retour[i + roll2].getDisponible(couleur))
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
				if (retour[i].getCouleur() == couleur && retour[i].getCompteur() != 0)
				{
					if (i - roll1 <= 0) {retour[i].setCol1(-1);}
					else {

						if (retour[i - roll1].getDisponible(couleur)) 
						{
							retour[i].setCol1(i - roll1);
						}
					}
					if (i - roll2 <= 0) {retour[i].setCol2(-1);}
					else {

						if ( retour[i - roll2].getDisponible(couleur))
						{
							retour[i].setCol2(i - roll2);

						}

					}
				}
			}

		}
		return retour;
	}
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

/*
 * @author Amellal Ibrahim & Seynaeve Jonathan
 * 
 * Classe colonne, elle modélise chacune des 24 colonnes et aussi les colonnes "case départ"
 */
package backgammon;

public class Colonne {

	private int numero = 0;
	private Pion [] pions = new Pion[10];
	private int compteur = 0;
	private int couleur;
	private int col1 = 0, col2 = 0;
	private boolean amovible = false;

	public Colonne (int numero)
	{
		this.numero = numero;
	}

	public boolean getDisponible(int a) 
	{
		return (compteur <= 1 || a == couleur);
	}

	public void addPion(Pion pion,int couleur) 
	{
		pions[compteur] = pion;
		compteur ++;
		setCouleur(couleur);

	}

	public void deletePion()
	{
		pions[compteur - 1] = null;
		compteur--;
		if(compteur == 0) 
		{
			couleur = 0;
			amovible = false;
		}
	}


	public int getNumero() 
	{
		return numero;
	}

	public int getCouleur() 
	{
		return couleur;
	}

	public void setCouleur(int couleur)
	{
		this.couleur = couleur;
	}

	public int getCompteur() 
	{
		return compteur;
	}

	public int getCol1() {
		return col1;
	}

	public void setCol1(int col1) {
		this.col1 = col1;
	}

	public int getCol2() {
		return col2;
	}

	public void setCol2(int col2) {
		this.col2 = col2;
	}

	public Pion getPion () 
	{
		return pions[compteur - 1];
	}

	public String toString() 
	{
		if (numero == 0) {return "Colonne de départ des blancs";}
		if (numero == 25) {return "Colonne de départ des noirs";}

		return "Colonne " + numero;
	}
	public String colonnesPossibles (Colonne [] plateau, Joueur joueur) 
	{
		String retour = "Colonnes possibles : ";
		if (col1 == -1) { retour = retour + " arrivée ";}
		if (col1 == - 1) {retour = retour + " arrivée ";}
		else {
			if (Utilitaires.avancable(col1, plateau, joueur) && col1 != numero && this.couleur == joueur.getCouleur()) { retour = retour + col1 + " ";}
			if (Utilitaires.avancable(col2, plateau, joueur) && col2 != numero && this.couleur == joueur.getCouleur()) { retour = retour + col2;}
		}
		return retour;
	}

	public boolean isAmovible(Joueur joueur) {

		if(compteur == 0) {return false;}
		if (this.couleur != joueur.getCouleur() || col1 == numero && col2 == numero) {return false;}
		if (col1 < 0 || col2 < 0 || (col1 < 0 && col2 < 0)) {return joueur.isArrivable();}
		return true;
	}

	public void setAmovible(boolean amovible) {
		this.amovible = amovible;
	}

	public void arrivabilite(Joueur joueur) 
	{
		boolean retour = true;
		if (joueur.getCouleur() == 1) 
		{
			for (int i = 0; i < 19; i++) 
			{
				if (couleur == joueur.getCouleur() && compteur != 0) {retour = false;}
			}
		}
		if (joueur.getCouleur() == 2)
		{
			for(int i = 24; i > 6; i--)
			{
				if (couleur == joueur.getCouleur() &&  compteur != 0) {retour = false;}
			}
		}
		joueur.setArrivable(retour);
	}


}

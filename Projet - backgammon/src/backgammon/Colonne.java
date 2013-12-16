/**
 * @author Amellal Ibrahim & Seynaeve Jonathan
 * 
 * Classe colonne, elle modalise chacune des 24 colonnes et aussi les colonnes "case depart"
 */
package backgammon;

public class Colonne {

	private int numero = 0;
	private Pion [] pions = new Pion[10];
	private int compteur = 0;
	private int couleur;
	private int col1 = 0, col2 = 0;
	private boolean amovible = false;

	/**
	 * Constructeur 
	 * 
	 * @param numero : Numero de la colonne en question
	 */
	public Colonne (int numero)
	{
		this.numero = numero;
	}

	/**
	 * Methode renseignant si un pion peut y atterrir
	 * @return si la case est disponible pour y atterir
	 */
	public boolean getDisponible(int a) 
	{
		return (compteur <= 1 || a == couleur);
	}

	/**
	 * Methode ajoutant un pion ˆ la colonne
	 * @param pion : On lui passe le pion a ajouter
	 * @param couleur : Il s'agit de la couleur du pion
	 */
	public void addPion(Pion pion,int couleur) 
	{
		pions[compteur] = pion;
		compteur ++;
		setCouleur(couleur);

	}

	/**
	 * Supprime un pion de la colonne
	 */
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
	/**
	 * Methode renvoyant le numero
	 * @return numero de la colonne
	 */

	public int getNumero() 
	{
		return numero;
	}

	/**
	 * Methode renvoyant la couleur du ou des pions squattant la colonne
	 * @return couleur du ou des pions de la colonne
	 */
	public int getCouleur() 
	{
		return couleur;
	}
	/**
	 * Mutateur permettant de changer la couleur associee
	 * @param couleur a mettre
	 */

	public void setCouleur(int couleur)
	{
		this.couleur = couleur;
	}
	/**
	 * Accesseur de compteur
	 * @return le nombre de pions sur la colonne
	 */
	
	public int getCompteur() 
	{
		return compteur;
	}
	/**
	 * Accesseur de colonne possible
	 * @return la ou une des colonnes sur lesquels un pion pourrait etre envoye
	 */

	public int getCol1() {
		return col1;
	}
	/**
	 * Mutateur de colonne possible
	 * @param col1 la colonne sur laquelle pourrait se poser un des pions
	 */

	public void setCol1(int col1) {
		this.col1 = col1;
	}
	/**
	 * Accesseur de colonne possible
	 * @return la ou une des colonnes sur lesquels un pion pourrait tre envoyŽ
	 */
	
	public int getCol2() {
		return col2;
	}
	/**
	 * Mutateur de colonne possible
	 * @param col2 la ou une des colonnes sur lesquels un pion pourrait tre envoyŽ
	 */

	public void setCol2(int col2) {
		this.col2 = col2;
	}

	/**
	 * Methode renvoyant un pion
	 * @return Retourn le dernier pion sur la colonne
	 */
	public Pion getPion () 
	{
		return pions[compteur - 1];
	}
	/**
	 * Methode toString()
	 * 
	 * @return "Colonne " suivi du numŽro de la colonne 
	 */
	public String toString() 
	{
		if (numero == 0) {return "Colonne de dŽpart des blancs";}
		if (numero == 25) {return "Colonne de dŽpart des noirs";}

		return "Colonne " + numero;
	}
	/**
	 * Methode renvoyant les colonnes susceptibles d'accueillir un pion provenant de la colonne-ci.
	 * @return Une chaine "Colonnes possibles " suivi du numŽro de la ou des colonnes possibles et arrivŽe si il peut arriver ˆ bon port.
	 */
	
	public String colonnesPossibles (Colonne [] plateau, Joueur joueur) 
	{
		String retour = "Colonnes possibles : ";
		if (col1 == -1) { retour = retour + " arrivŽe ";}
		if (col1 == - 1) {retour = retour + " arrivŽe ";}
		else {
			if (Utilitaires.avancable(col1, plateau, joueur) && col1 != numero && this.couleur == joueur.getCouleur()) { retour = retour + col1 + " ";}
			if (Utilitaires.avancable(col2, plateau, joueur) && col2 != numero && this.couleur == joueur.getCouleur()) { retour = retour + col2;}
		}
		return retour;
	}
	/**
	 * @param joueur On met en paramtre un joueur
	 * @return si le joueur peut avancer un pion place sur cette colonne-ci.
	 * 
	 */
	
	public boolean isAmovible(Joueur joueur) {

		if(compteur == 0) {return false;}
		if (this.couleur != joueur.getCouleur() || col1 == numero && col2 == numero) {return false;}
		if (col1 < 0 || col2 < 0 || (col1 < 0 && col2 < 0)) {return joueur.isArrivable();}
		return true;
	}
	/**
	 * Mutateur de l'amovibilite
	 * @param amovible C'est une la le booleen a mettre
	 */
	
	public void setAmovible(boolean amovible) {
		this.amovible = amovible;
	}
	/**
	 * Methode determinant si un joueur peut commencer a extraire ses pions des 24 colonnes vers la colonne finale
	 * @param joueur Joueur en cours
	 * 
	 */

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

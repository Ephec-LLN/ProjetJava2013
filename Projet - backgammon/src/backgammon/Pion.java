package backgammon;
/**
 * Classe Pion modelisant les pions
 * @author Amellal Ibrahim & Seynaeve Jonathan
 *
 */
public class Pion {

	private int couleur;
	private int colonne;
	
	/**
	 * Constructeur
	 * @param couleur Couleur du Pion
	 */
	public Pion(int couleur) 
	{
		this.setCouleur(couleur);
	}
	/**
	 * Accesseur retournant la colonne sur laquelle il est
	 * @return Retourn le numero de colonne
	 */
	
	public int getColonne() 
	{
		return colonne;
	}
	/**
	 * Mutateur permettant de changer le numero de colonne
	 * @param colonne le numéro de colonne à insérer
	 */
	public void setColonne(int colonne) 
	{
		this.colonne = colonne;
	}
	/**
	 * Accesseur renvoyant la couleur
	 * @return Retourne la couleur
	 */

	public int getCouleur() 
	{
		return couleur;
	}
	/**
	 * Mutateur de couleur
	 * @param couleur Couleur desiree
	 */
	public void setCouleur(int couleur)
	{
		this.couleur = couleur;
	}
	
	
}

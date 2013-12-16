/**
 * 
 * @author Amellal Ibrahim & Seynaeve Jonathan
 * Classe modelisant un joueur
 *
 */
package backgammon;

public class Joueur 
{

	private String pseudonyme;
	private int pionsActifs;
	private int pionsRetraites;
	private int couleur;
	private boolean jouable;
	private boolean arrivable = false;
	
	/**
	 * Constructeur
	 * @param pseudonyme Nom du joueur
	 * @param couleur NumŽro de sa couleur, 1 pour les blancs, 2 pour les noirs
	 */
	public Joueur (String pseudonyme, int couleur) 
	{
		this.setPseudonyme(pseudonyme);
		this.couleur = couleur;
		
	}
	/**
	 * Accesseur renvoyant la couleur
	 * @return Retourne la couleur du joueur
	 */
	public int getCouleur() {
		return couleur;
	}
	/**
	 * Mutateur de couleur
	 * @param couleur
	 */
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	/**
	 * Accesseur renvoyant le pseudonyme utilisŽ par le joueur
	 * @return le pseudonyme
	 */
	public String getPseudonyme() {
		return pseudonyme;
	}
	/**
	 * Mutateur du pseudonyme
	 * @param pseudonyme pseudo remplaant l'ancien
	 */
	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	/**
	 * Acceseur du nombre pions actifs
	 * @return Nombre de pion(s) restant(s) sur le plateau
	 */
	public int getPionsActifs() {
		return pionsActifs;
	}
	/**
	 * Mutateur de pions actifs
	 * @param pionsActifs
	 */
	public void setPionsActifs(int pionsActifs) {
		this.pionsActifs = pionsActifs;
	}
	/**
	 * Accesseur de pions arrivŽs
	 * @return
	 */
	public int getPionsRetraites() {
		return pionsRetraites;
	}
	/**
	 * Mutateur de pions retraites
	 * @param pionsRetraites
	 */
	public void setPionsRetraites(int pionsRetraites) {
		this.pionsRetraites = pionsRetraites;
	}
	/**
	 * Methode renvoyant un booleen si le joueur peut jouer
	 * @param plateau
	 * @return true si il peut jouer ou false sinon.
	 */
	public boolean isJouable(Colonne [] plateau) {
		jouable = false;
		
		  if (couleur == 1 && plateau[0].getCompteur() > 0) {jouable = plateau[0].isAmovible(this);} 
		else {
		for(int i = 0; i < 26; i++)
		{
			if(plateau[i].isAmovible(this)) {jouable = true; break;}
			
		}}
		if (couleur == 2 && plateau[25].getCompteur() > 0) {jouable = plateau[25].isAmovible(this);} 
		else {
		for(int i = 0; i < 26; i++)
		{
			if(plateau[i].isAmovible(this)) {jouable = true; break;}
			
		}}
		 
		
		return jouable;
	}
	/**
	 * Mutateur informant si le joueur peut jouer ou si il doit cŽder son tour
	 * @param jouable 
	 */
	public void setJouable(boolean jouable) {
		this.jouable = jouable;
	}
	/**
	 * Accesseur de l'arrivabilitŽ, c'est-ˆ-dire, est-ce que le joueur peut commencer ˆ envoyer des pions sur la colonne de fin.
	 * @return
	 */
	public boolean isArrivable() {
		return arrivable;
	}
	/**
	 * Mutateur d'arrivabilitŽ
	 * @param arrivable
	 */
	public void setArrivable(boolean arrivable) {
		this.arrivable = arrivable;
	}

}

/*
 * @author : Amellal Ibrahim & Seynaeve Jonathan
 * 
 * Classe Jeu, contenant les données nécessaires pour démarrer une partie.
 */
package backgammon;

public class Jeu {

	public  Colonne[] plateau;
	public Graphisme g;
	public int couleur;
	private Joueur joueur1, joueur2;

	/*
 	* Constructeur de classe Jeu
 	*  @param plateau : Tableau de 26 colonnes
 	*  @param joueur1 : Premier joueur, couleur blanche
 	*  @param joueur2 : Second joueur, couleur noire
 	*  
 	*  La méthode instancie une instance de la classe Graphisme
 	*/
	public Jeu (Colonne [] plateau, Joueur joueur1, Joueur joueur2) 
	{
		
		this.plateau = plateau;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		 g = new Graphisme(plateau, joueur1, joueur2);
	}

	/*
	 * Méthode static void main 
	 * 
	 * Initialise 2 joueurs, un plateau de jeu, ainis qu'une instance de Jeu
	 */
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("Amellal Lecteur", 1);
		Joueur joueur2 = new Joueur("John, attends", 2);
		Colonne [] plateau = Utilitaires.initialisation();
		Jeu jeu = new Jeu(plateau, joueur1, joueur2);
	}
}

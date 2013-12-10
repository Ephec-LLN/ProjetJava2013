package backgammon;



public class Jeu {

	public  int a,b;
	public  Colonne[] plateau;
	public Graphisme g;
	public int couleur;
	private Joueur joueur1, joueur2;
	
	public Jeu (int a, int b, Colonne [] plateau, Joueur joueur1, Joueur joueur2) 
	{
		this.a = a;
		this.b = b;
		this.plateau = plateau;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		
	    g = new Graphisme(a,b,plateau, joueur1, joueur2);
		
	}
	public int getCouleur() {
		return couleur;
	}
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		Joueur joueur1 = new Joueur("Amellal Lecteur", 1);
		Joueur joueur2 = new Joueur("John, attends", 2);
		
		int a,b,c;
		a = 1;
		b = 1;
		Colonne [] plateau = Utilitaires.initialisation();
		Jeu jeu = new Jeu(a,b,plateau, joueur1, joueur2);
	
		Utilitaires.affiche(plateau);
	
		
		
	}
	public Graphisme getG() {
		return g;
	}
	public void setG(Graphisme g) {
		this.g = g;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

	public Colonne[] getPlateau() {
		return plateau;
	}
	public void setPlateau(Colonne[] plateau) {
		this.plateau = plateau;
	}

	
	
	
}

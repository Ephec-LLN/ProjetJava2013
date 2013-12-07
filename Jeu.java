package backgammon;



public class Jeu {

	public  int a,b,c;
	public  Colonne[] plateau;
	public Graphisme g;
	public int couleur;
	public Jeu (int a, int b, int c, Colonne [] plateau) 
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.plateau = plateau;
	    g = new Graphisme(a,b,c,plateau);
		
	}
	public int getCouleur() {
		return couleur;
	}
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		
		int a,b,c;
      
		
		a = Utilitaires.roll();
		b = Utilitaires.roll();
		c = 1;
		a = 0;
		b = 0;
		Colonne [] plateau = Utilitaires.initialisation();
		Jeu jeu = new Jeu(a,b,c,plateau);
	
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
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public Colonne[] getPlateau() {
		return plateau;
	}
	public void setPlateau(Colonne[] plateau) {
		this.plateau = plateau;
	}

	
	
	
}

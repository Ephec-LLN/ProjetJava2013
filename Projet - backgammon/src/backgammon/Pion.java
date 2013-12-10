package backgammon;

public class Pion {

	private int couleur;
	private int colonne;
	
	
	public Pion(int couleur) 
	{
		this.setCouleur(couleur);
	}
	
	
	public int getColonne() 
	{
		return colonne;
	}
	public void setColonne(int colonne) 
	{
		this.colonne = colonne;
	}

	public int getCouleur() 
	{
		return couleur;
	}

	public void setCouleur(int couleur)
	{
		this.couleur = couleur;
	}
	
	
}

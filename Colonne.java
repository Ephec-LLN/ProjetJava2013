package backgammon;

public class Colonne {

	private int num�ro = 0;
	private Pion [] pions = new Pion[5];
	private int compteur = 0;
	private int couleur;
	private int col1 = 0, col2 = 0;
	
	public Colonne (int num�ro)
	{
		this.setNum�ro(num�ro);
	}
	
	public boolean getDisponible(int a) 
	{
		return (compteur <= 1 || a == couleur);
	}
	
	public void addPion(Pion pion) 
	{
		pions[compteur] = pion;
		compteur ++;
		setCouleur(pion.getCouleur());
		
	}
	
	public void deletePion()
	{
		pions[compteur -1] = null;
		compteur--;
		if(compteur == 0) 
		{
			couleur = 0;
		}
	}
	
	public boolean libre(Pion pion)
	{
		return compteur == 0 || compteur <= 5 && couleur == pion.getCouleur();
	}

	public int getNum�ro() 
	{
		return num�ro;
	}

	public void setNum�ro(int num�ro) 
	{
		this.num�ro = num�ro;
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
		return pions[compteur -1];
	}

}

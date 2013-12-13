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
		this.setNumero(numero);
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
	
	public boolean libre(Pion pion)
	{
		return compteur == 0 || compteur <= 5 && couleur == pion.getCouleur();
	}

	public int getNumero() 
	{
		return numero;
	}

	public void setNumero(int numero) 
	{
		this.numero = numero;
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
		if (numero == 0) {return "Colonne de dŽpart des blancs";}
		if (numero == 25) {return "Colonne de dŽpart des noirs";}
		
		return "Colonne " + numero;
	}
	public String colonnesPossibles (Colonne [] plateau, int couleur) 
	{
		String retour = "Colonnes possibles : ";
		if (Utilitaires.avancable(col1, plateau) && col1 != numero && this.couleur == couleur) { retour = retour + col1 + " ";}
		if (Utilitaires.avancable(col2, plateau) && col2 != numero && this.couleur == couleur) { retour = retour + col2;}
		
		
		
		return retour;
		
	}

	public boolean isAmovible(int couleur) {
		
		if(compteur == 0) {return false;}
		if (this.couleur != couleur || col1 == numero && col2 == numero) {return false;}
		return true;
	}

	public void setAmovible(boolean amovible) {
		this.amovible = amovible;
	}
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	
}

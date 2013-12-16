package backgammon;

public class Joueur 
{

	private String pseudonyme;
	private int pionsActifs;
	private int pionsRetraites;
	private int couleur;
	private boolean jouable;
	private boolean arrivable = false;
	
	public Joueur (String pseudonyme, int couleur) 
	{
		this.setPseudonyme(pseudonyme);
		this.couleur = couleur;
		
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public int getPionsActifs() {
		return pionsActifs;
	}

	public void setPionsActifs(int pionsActifs) {
		this.pionsActifs = pionsActifs;
	}
	
	public int getPionsRetraites() {
		return pionsRetraites;
	}

	public void setPionsRetraites(int pionsRetraites) {
		this.pionsRetraites = pionsRetraites;
	}

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

	public void setJouable(boolean jouable) {
		this.jouable = jouable;
	}

	public boolean isArrivable() {
		return arrivable;
	}

	public void setArrivable(boolean arrivable) {
		this.arrivable = arrivable;
	}

}

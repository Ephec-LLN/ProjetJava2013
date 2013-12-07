package backgammon;

public class Joueur 
{

	private String pseudonyme;
	private int pionsActifs;
	private int couleur;
	
	public Joueur (String pseudonyme, int couleur) 
	{
		this.setPseudonyme(pseudonyme);
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
	
	
}

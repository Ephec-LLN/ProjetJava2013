package backgammon;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Graphisme extends JFrame implements ActionListener{

	public JButton bouton1 = new JButton("Lancer les dés");
	public JButton[] colonnes = new JButton[26];
	public JButton bouton2 = new JButton("Bouton2");
	JLabel des;
	JTextArea plateauGraphique = new JTextArea();
	public Jeu jeu;
	private int a,b,c;
	private Colonne[] plateau;
	private JFrame fen;
	private int couleur = 1;
	private Joueur[] joueurs = new Joueur[2];
	
	public Graphisme (int a, int b, Colonne[] plateau, Joueur joueur1, Joueur joueur2)
	{
		this.a = a;
		this.b = b;
		this.plateau = plateau;
		fen = new JFrame("Backgammon");		
		fen.setVisible(true);
		joueurs[0] = joueur1;
		joueurs[1] = joueur2;
		
		

		// Boutons 

		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		JPanel boutonsColonnes = new JPanel();
		GridLayout boutonsLayout = new GridLayout(13,2);
		boutonsColonnes.setLayout(boutonsLayout);
		
		for (int i = 0; i< 26; i++)
		{
			colonnes[i] = new JButton("Colonne : " + i);
			boutonsColonnes.add(colonnes[i]);
			colonnes[i].addActionListener(this);
			colonnes[i].setEnabled(false);
		}
		
		plateauGraphique.setText(affichage(plateau));

		des = new JLabel(a + " " + b);
		JPanel pan = new JPanel();
		BorderLayout layout = new BorderLayout();
		pan.setLayout(layout);
		pan.add(bouton1,BorderLayout.NORTH);

		pan.add(des,BorderLayout.SOUTH);
		pan.add(plateauGraphique,BorderLayout.CENTER);
		pan.add(boutonsColonnes,BorderLayout.EAST);

		fen.add(pan);
		fen.setSize(1024, 768);
		fen.setResizable(false);
		this.pack();
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

	public  String affichage (Colonne [] plateau) 
	{
		String retour = "C'est au tour de : " + joueurs[couleur - 1].getPseudonyme() + " de jouer \n";
		for (int i = 0; i < 26; i++) 
		{
			String couleur = "";
			if (plateau[i].getCompteur() == 0) {couleur = "";}
			if (plateau[i].getCouleur() == 1 ) {couleur = "blancs";}
			if (plateau[i].getCouleur() == 2 ) {couleur = "noirs";}
			String ligne = plateau[i].toString() + " : " + 
			plateau[i].getCompteur() + " pions " + couleur + plateau[i].colonnesPossibles(plateau, this.couleur) + "\n" ;
			retour = retour + ligne;
		}
		return retour;
	}
	public void actionPerformed(ActionEvent arg0) {      
		if (arg0.getSource() == bouton1) {

			plateau = Utilitaires.scannage(plateau, 1, 0, 0);
			a = Utilitaires.roll();
			b = Utilitaires.roll();
			des.setText(a + " " + b);
			System.out.println("Clic");
			
			plateau = Utilitaires.scannage(plateau, 1, a, b);
			boutonsAdaptation();
			plateauGraphique.setText(affichage(plateau));
			bouton1.setEnabled(false);
		}
	
		for (int i = 1; i < 25; i++)
		{
			if (arg0.getSource() == colonnes[i])
			{
				Object[] options = {"Colonne " + plateau[i].getCol1(), "Colonne " + plateau[i].getCol2(), "Annuler"};
				int n = JOptionPane.showOptionDialog(fen,
					    "Sur quelle colonne voulez-vous débarquer ? ", "Quelle case ?",
					    	    JOptionPane.DEFAULT_OPTION,
					    	    JOptionPane.QUESTION_MESSAGE,
					    	    null,
					    	    options,
					    	    options[2]);
				System.out.println(n);
				if (n == 0) 
				{
					plateau = Utilitaires.avance2(1, plateau[i].getCol1(), plateau);
					plateau = Utilitaires.scannage(plateau, 1, b, b);
					plateauGraphique.setText(affichage(plateau));
					boutonsAdaptation();
				}
				if (n == 1) 
				{
					plateau = Utilitaires.avance2(1, plateau[i].getCol2(), plateau);
					plateau = Utilitaires.scannage(plateau, 1, a, a);
					plateauGraphique.setText(affichage(plateau));
					boutonsAdaptation();
				}
				
			}
		}
	} 
	public void boutonsAdaptation () 
	{
		for (int i = 0; i < 26; i++)
		{
			if (plateau[i].getCouleur() == couleur) {colonnes[i].setEnabled(plateau[i].isAmovible(couleur));}
			
		}
		
	}
}

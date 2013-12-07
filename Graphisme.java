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


@SuppressWarnings("serial")
public class Graphisme extends JFrame implements ActionListener{

	public JButton bouton1 = new JButton("Lancer les dés");
	public JButton[] colonnes = new JButton[26];
	public JButton bouton2 = new JButton("Bouton2");
	JLabel des;
	JTextArea plateauGraphique = new JTextArea();
	public Jeu jeu;
	private int a,b,c;
	private Colonne[] plateau;
	private int colSelec;
	private JFrame fen;
	public Graphisme (int a, int b, int c, Colonne[] plateau)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.plateau = plateau;
		fen = new JFrame("Backgammon");		
		fen.setVisible(true);
		
		

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
		String retour = " ";
		for (int i = 0; i < 26; i++) 
		{
			String couleur = "";
			if (plateau[i].getCompteur() == 0) {couleur = "";}
			if (plateau[i].getCouleur() == 1 ) {couleur = "blancs";}
			if (plateau[i].getCouleur() == 2 ) {couleur = "noirs";}
			String ligne = plateau[i].toString() + " : " + 
			plateau[i].getCompteur() + " pions " + couleur + plateau[i].colonnesPossibles() + "\n" ;
			retour = retour + ligne;
		}
		return retour;
	}
	public void actionPerformed(ActionEvent arg0) {      
		if (arg0.getSource() == bouton1) {


			a = Utilitaires.roll();
			b = Utilitaires.roll();
			des.setText(a + " " + b);
			System.out.println("Clic");
			
			plateau = Utilitaires.scannage(plateau, 1, a, b);
			plateauGraphique.setText(affichage(plateau));
			
		}
		if (arg0.getSource() == colonnes[1])
		{
			Object[] options = {"Colonne " + plateau[1].getCol1(), "Colonne " + plateau[1].getCol2(), "Annuler"};
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
				plateau = Utilitaires.avance(1, plateau[1].getCol1(), plateau);
				plateau = Utilitaires.scannage(plateau, 1, b, b);
				plateauGraphique.setText(affichage(plateau));
			}
			if (n == 1) 
			{
				plateau = Utilitaires.avance(1, plateau[1].getCol2(), plateau);
				plateau = Utilitaires.scannage(plateau, 1, a, a);
				plateauGraphique.setText(affichage(plateau));
			}
			
		}
	} 

}

package backgammon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Graphisme extends JFrame implements ActionListener{

	public JButton bouton1 = new JButton("Lancer");
	public JButton bouton2 = new JButton("Bouton2");
	JLabel des;
	JTextArea plateauGraphique = new JTextArea();
	public Jeu jeu;
	private int a,b,c;
	private Colonne[] plateau;
	public Graphisme (int a, int b, int c, Colonne[] plateau)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.plateau = plateau;
		JFrame fen = new JFrame("Backgammon");		
		fen.setVisible(true);
		
		

		// Boutons 

		bouton1.addActionListener(this);
		bouton2.addActionListener(this);

	
		plateauGraphique.setText(affichage(plateau));

		des = new JLabel(a + " " + b);
		JPanel pan = new JPanel();
		BorderLayout layout = new BorderLayout();
		pan.setLayout(layout);
		pan.add(bouton1,BorderLayout.NORTH);

		pan.add(des,BorderLayout.SOUTH);
		pan.add(plateauGraphique,BorderLayout.CENTER);

		fen.add(pan);
		fen.setSize(1280, 900);
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
			String ligne = "Colonne " + (plateau[i].getNuméro() +1) + " : " + plateau[i].getCompteur() + " pions " + couleur + "\n";
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
		}
		if (arg0.getSource() == bouton2)
		{
			System.out.println("Bouton 2 cliqué");
		}
	} 

}

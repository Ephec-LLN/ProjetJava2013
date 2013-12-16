package backgammon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class Graphisme2 extends JFrame implements ActionListener{

	public JButton bouton1 = new JButton("Lancer les des");
	public JButton[] colonnes = new JButton[26];
	public JButton[] col = new JButton[26];
	public JButton bouton2 = new JButton("Bouton2");
	JLabel des1;
	JLabel des2;
	JTextArea plateauGraphique = new JTextArea();
	public Jeu jeu;
	private int a = 1;
	private int b = 1; 
	private int c = 4;
	private Colonne[] plateau;
	private JFrame fen;
	private int couleur = 1;
	private Joueur[] joueurs = new Joueur[2];
	private boolean fini = false;
	Menu menu = new Menu();
	private String[] tabCheminImg = 
		{
			"images/pion_vide.png","images/pion1_1.png","images/pion1_1r.png","images/pion1_2.png","images/pion1_2r.png","images/pion1_3.png","images/pion1_3r.png","images/pion1_4.png","images/pion1_4r.png","images/pion1_5.png","images/pion1_5r.png",
			"images/pion2_1.png","images/pion2_1r.png","images/pion2_2.png","images/pion2_2r.png","images/pion2_3.png","images/pion2_3r.png","images/pion2_4.png","images/pion2_4r.png","images/pion2_5.png","images/pion2_5r.png","images/reserve_vide.png",
			"images/reserve_p1_1.png","images/reserve_p1_2.png","images/reserve_p1_3.png","images/reserve_p1_4.png","images/reserve_p1_5.png","images/reserve_p1_6.png","images/reserve_p2_1.png","images/reserve_p2_2.png","images/reserve_p2_3.png","images/reserve_p2_4.png","images/reserve_p2_5.png","images/reserve_p2_6.png",
			"images/d1.png","images/d2.png","images/d3.png","images/d4.png","images/d5.png","images/d6.png","images/pion_vide_r.png"};

	public Graphisme2 (Colonne[] plateau, Joueur joueur1, Joueur joueur2)
	{
		if (a == b) {c = 4;} else {c = 2;}
		this.plateau = plateau;
		fen = new JFrame("Backgammon");
		fen.setVisible(true);
		joueurs[0] = joueur1;
		joueurs[1] = joueur2;



		// Boutons 

		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		JPanel boutonsColonnes = new JPanel();
		JPanel tabCol1 = new JPanel();
		JPanel tabCol2 = new JPanel();
		


		GridBagLayout boutonsLayout = new GridBagLayout();
		GridBagConstraints gridbag;
		gridbag = new GridBagConstraints();


		boutonsColonnes.setLayout(boutonsLayout);

		gridbag.gridy = 2;
		
		for (int i = 13; i< 26; i++)
		{
			col[i] = new JButton("" + i);
			col[i].setPreferredSize(new Dimension(48,20));
			tabCol1.add(col[i],gridbag);
			col[i].addActionListener(this);
			col[i].setEnabled(false);
			col[i].setVisible(true);
			col[i].setOpaque(true);
		}
		
		
		gridbag.gridy = 10;

		for (int i = 13; i< 26; i++)
		{
			colonnes[i] = new JButton();
			colonnes[i].setPreferredSize(new Dimension(32,214));
			//colonnes[i].setOpaque(false);
			//colonnes[i].setContentAreaFilled(false);
			//colonnes[i].setBorderPainted(false);
			boutonsColonnes.add(colonnes[i],gridbag);
			colonnes[i].addActionListener(this);
			colonnes[i].setEnabled(false);
			colonnes[i].setVisible(true);
			colonnes[i].setOpaque(true);
		}

		gridbag.gridy = 20;

		for (int i = 12; i>=0; i--)
		{
			colonnes[i] = new JButton();
			colonnes[i].setPreferredSize(new Dimension(32,214));
			boutonsColonnes.add(colonnes[i],gridbag);
			colonnes[i].addActionListener(this);
			colonnes[i].setEnabled(false);
			colonnes[i].setVisible(true);
			colonnes[i].setOpaque(true);
		}
		
		gridbag.gridy = 22;
		
		for (int i = 12; i>0; i--)
		{
			col[i] = new JButton("" + i);
			col[i].setPreferredSize(new Dimension(48,15));
			tabCol2.add(col[i],gridbag);
			col[i].addActionListener(this);
			col[i].setEnabled(false);
			col[i].setVisible(true);
			col[i].setOpaque(true);
		}


		plateauGraphique.setText(affichage(plateau));

		des1 = new JLabel();
		des2 = new JLabel();
		bouton1.setSize(new Dimension(30,60));
		bouton1.setPreferredSize(new Dimension(30,60));
		JPanel pan = new JPanel();

		//pan.add(bouton1,BorderLayout.BEFORE_FIRST_LINE);


		pan.add(tabCol1);
		pan.add(boutonsColonnes,BorderLayout.CENTER);
		pan.add(tabCol2);
		fen.add(menu,BorderLayout.NORTH);
		fen.add(bouton1,BorderLayout.SOUTH);
		fen.add(des1,BorderLayout.LINE_END);
		fen.add(des2,BorderLayout.LINE_START);
		//pan.add(plateauGraphique,BorderLayout.SOUTH);


		fen.add(pan);
		fen.setSize(800, 680);
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

		for (int i = 1; i < 25; i++) 
		{
			String couleur = "";
			if(plateau[i].getNumero() < 25 && plateau[i].getNumero() > 12) {
				if (plateau[i].getCompteur() == 0) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[0]));}
				if (plateau[i].getCouleur() == 1 ) { 
					if (plateau[i].getCompteur() == 1) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[1]));}
					if (plateau[i].getCompteur() == 2) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[3]));}
					if (plateau[i].getCompteur() == 3) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[5]));}
					if (plateau[i].getCompteur() == 4) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[7]));}
					if (plateau[i].getCompteur() == 5) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[9]));}
				}
				if (plateau[i].getCouleur() == 2 ) {
					if (plateau[i].getCompteur() == 1) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[11]));}
					if (plateau[i].getCompteur() == 2) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[13]));}
					if (plateau[i].getCompteur() == 3) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[15]));}
					if (plateau[i].getCompteur() == 4) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[17]));}
					if (plateau[i].getCompteur() == 5) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[19]));}
				}
			}
			if(plateau[i].getNumero() > 0 && plateau[i].getNumero() < 13) {
				if (plateau[i].getCompteur() == 0) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[40]));}
				if (plateau[i].getCouleur() == 1 ) { 
					if (plateau[i].getCompteur() == 1) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[2]));}
					if (plateau[i].getCompteur() == 2) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[4]));}
					if (plateau[i].getCompteur() == 3) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[6]));}
					if (plateau[i].getCompteur() == 4) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[8]));}
					if (plateau[i].getCompteur() == 5) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[10]));}
				}
				if (plateau[i].getCouleur() == 2 ) {
					if (plateau[i].getCompteur() == 1) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[12]));}
					if (plateau[i].getCompteur() == 2) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[14]));}
					if (plateau[i].getCompteur() == 3) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[16]));}
					if (plateau[i].getCompteur() == 4) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[18]));}
					if (plateau[i].getCompteur() == 5) {colonnes[i].setIcon(new ImageIcon(tabCheminImg[20]));}
				}
			}
		}
		if (plateau[0].getCompteur() == 0) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[21]));}
		if (plateau[0].getCompteur() == 1) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[22]));}
		if (plateau[0].getCompteur() == 2) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[23]));}
		if (plateau[0].getCompteur() == 3) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[24]));}
		if (plateau[0].getCompteur() == 4) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[25]));}
		if (plateau[0].getCompteur() == 5) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[26]));}
		if (plateau[0].getCompteur() == 6) {colonnes[0].setIcon(new ImageIcon(tabCheminImg[27]));}

		if (plateau[25].getCompteur() == 0) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[21]));}
		if (plateau[25].getCompteur() == 1) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[28]));}
		if (plateau[25].getCompteur() == 2) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[29]));}
		if (plateau[25].getCompteur() == 3) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[30]));}
		if (plateau[25].getCompteur() == 4) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[31]));}
		if (plateau[25].getCompteur() == 5) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[32]));}
		if (plateau[25].getCompteur() == 6) {colonnes[25].setIcon(new ImageIcon(tabCheminImg[33]));}
		return retour;
	}
	
	public void actionPerformed(ActionEvent arg0) {      
		if (arg0.getSource() == bouton1) {

			plateau = Utilitaires.scannage(plateau, joueurs[couleur - 1], 0, 0);
			a = Utilitaires.roll();
			b = Utilitaires.roll();
			if (a == b) {c = 4;} else {c = 2;}
			if (a==1){des1.setIcon(new ImageIcon(tabCheminImg[34]));}
			if (a==2){des1.setIcon(new ImageIcon(tabCheminImg[35]));}
			if (a==3){des1.setIcon(new ImageIcon(tabCheminImg[36]));}
			if (a==4){des1.setIcon(new ImageIcon(tabCheminImg[37]));}
			if (a==5){des1.setIcon(new ImageIcon(tabCheminImg[38]));}
			if (a==6){des1.setIcon(new ImageIcon(tabCheminImg[39]));}

			if (b==1){des2.setIcon(new ImageIcon(tabCheminImg[34]));}
			if (b==2){des2.setIcon(new ImageIcon(tabCheminImg[35]));}
			if (b==3){des2.setIcon(new ImageIcon(tabCheminImg[36]));}
			if (b==4){des2.setIcon(new ImageIcon(tabCheminImg[37]));}
			if (b==5){des2.setIcon(new ImageIcon(tabCheminImg[38]));}
			if (b==6){des2.setIcon(new ImageIcon(tabCheminImg[39]));}

			System.out.println("Clic");

			plateau = Utilitaires.scannage(plateau, joueurs[couleur - 1], a, b);
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
						"Sur quelle colonne voulez-vous debarquer ? ", "Quelle case ?",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						options,
						options[2]);

				if (n == 0) 
				{
					if (couleur == 1) {plateau = Utilitaires.avance(i, (a + 1), plateau, joueurs[couleur - 1]);}
					else {plateau = Utilitaires.avance(i, (a + 1), plateau, joueurs[couleur - 1]);}
					plateau = Utilitaires.scannage(plateau, joueurs[couleur - 1], b, b);
					a = b;
					plateauGraphique.setText(affichage(plateau));
					c--;
					boutonsAdaptation();
				}
				if (n == 1) 
				{
					if (couleur == 1) {plateau = Utilitaires.avance(i, (b + 1), plateau, joueurs[couleur - 1]);}
					else {plateau = Utilitaires.avance(i, (b + 1), plateau, joueurs[couleur - 1]);}
					plateau = Utilitaires.scannage(plateau, joueurs[couleur - 1], a, a);
					b = a;
					plateauGraphique.setText(affichage(plateau));
					c--;
					boutonsAdaptation();
				}

			}
		}
	} 
	public void boutonsAdaptation () 
	{
		System.out.println( "valeur de c : " + c);
		for (int i = 0; i < 26; i++)
		{
			if(Utilitaires.avancable(i, plateau, joueurs[couleur - 1]) && plateau[i].getCouleur() == couleur) {colonnes[i].setEnabled(true);}
			else {colonnes[i].setEnabled(false); colonnes[i].setVisible(true); colonnes[i].setOpaque(true);}

		}
		if (c == 0) 
		{
			for (int i = 0; i < 25; i++)
			{
				colonnes[i].setEnabled(false);
				colonnes[i].setVisible(true);
				colonnes[i].setOpaque(true);
			}
			passageTour();
		}
	}
	public void passageTour()
	{
		switch(couleur)
		{
		case 1 : couleur = 2; break;
		case 2 : couleur = 1;
		}
		bouton1.setEnabled(true);

		plateauGraphique.setText(affichage(plateau));
	}


}

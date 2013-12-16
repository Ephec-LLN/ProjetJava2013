package backgammon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


public class Menu extends JMenuBar {


	/** The Constant Aide. */
	private static final String Aide = "Regles du jeu\n" +
			"-------------\n\n"+
			"L'objectif d'une partie de backgammon est de sortir toutes ses « dames » du tablier.\n"
			+ "Au début de la partie, les dames sont réparties sur le tablier d'une manière imposée.\n"
			+ "Elles circulent dans un sens déterminé, et selon le résultat du lancer de deux dés.\n"
			+ "Sur leur chemin vers la sortie, elles peuvent être bloquées ou « battues » par celles\n"
			+ "de l'adversaire.";


	/**
	 * Instancie un nouveau menu.
	 *
	 * @param PlateauTech Plateau Technique
	 */
	public Menu() {
		super();

		JMenuItem partie = new JMenuItem("Recommencer");
		partie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Recommencer?", "Nouvelle Partie",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					Utilitaires.initialisation();
				}
			}
		});
		this.add(partie);

		JMenuItem aide = new JMenuItem("Aide");
		aide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
		aide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,Aide,"Aide",JOptionPane.INFORMATION_MESSAGE);
			}
		});	

		JMenuItem apd = new JMenuItem("A propos");
		apd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Backgammon - Janvier 2014\nAuteurs : Ibrahim et Jonathan","A propos",JOptionPane.INFORMATION_MESSAGE);
			}
		});	

		/*JMenu perso = new JMenu("Personnalisation");
		JMenu submenu = new JMenu("Plateau");

		JMenuItem croix = new JMenuItem("Croix");
		croix.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		croix.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 1;
					choixPlateau(choix);
				}
				repaint();
				revalidate();
			}
		});	
		submenu.add(croix);

		JMenuItem carre = new JMenuItem("Carre");
		carre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		carre.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						choix = 2;
						choixPlateau(choix);
					}
					repaint();
					revalidate();
				}
		});

		submenu.add(carre);

		JMenuItem coeur = new JMenuItem("Coeur");
		coeur.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
		coeur.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 3;
					choixPlateau(choix);
				}
				repaint();
				revalidate();
			}
		});
		submenu.add(coeur);


		JMenuItem moz = new JMenuItem("Mozaique");
		moz.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
		moz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 4;
					choixPlateau(choix);
				}
				repaint();
				revalidate();				
			}
		});
		submenu.add(moz);

		JMenuItem smiley = new JMenuItem("Smiley");
		smiley.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		smiley.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int reply = JOptionPane.showConfirmDialog(null, "Votre partie sera perdue", "changer de plateau?",  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					choix = 5;
					choixPlateau(choix);
				}
				repaint();
				revalidate();					
			}
		});
		submenu.add(smiley);
		perso.add(submenu);
		this.add(perso); */
		this.add(aide);
		this.add(apd);
	}
}
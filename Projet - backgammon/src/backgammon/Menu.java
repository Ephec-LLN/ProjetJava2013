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
			"L'objectif d'une partie de backgammon est de sortir toutes ses � dames � du tablier.\n"
			+ "Au d�but de la partie, les dames sont r�parties sur le tablier d'une mani�re impos�e.\n"
			+ "Elles circulent dans un sens d�termin�, et selon le r�sultat du lancer de deux d�s.\n"
			+ "Sur leur chemin vers la sortie, elles peuvent �tre bloqu�es ou � battues � par celles\n"
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

		this.add(aide);
		this.add(apd);
	}
}
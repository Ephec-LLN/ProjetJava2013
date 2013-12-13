package backgammon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


class Fond extends JPanel {

	private Image image;

	public Fond() {
		image = Toolkit.getDefaultToolkit().getImage("images/plateau.jpg");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage (image, 0, 0, null);
		repaint();
	}
}	
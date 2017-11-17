package Zadanie7_8;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * This class is used to draw the customized JPanels in a certain way JFrame in
 * OpilecGui is filled with these
 * 
 * @author Mario Alina
 *
 */
public class Neighbourhood extends JPanel {

	private boolean green;

	public void draw_green(boolean green) {
		this.green = green;
	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("je: " + this.green);
		if (green == true) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.ORANGE);

		}
		g.fillRect(0, 0, 50, 50);

	}

}

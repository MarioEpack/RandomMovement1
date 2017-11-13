package Zadanie7_8;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Neighbourhood extends JPanel {

	private Opilec opilec = new Opilec();

	@Override
	public void paintComponent(Graphics g) {
		g.drawRect(0, 0, 50, 50);
		while (this.opilec.is_visited(this.opilec.get_position_index_x(), this.opilec.get_position_index_y()) == true) {
			g.drawOval(10, 10, 10, 10);
		}
	}
}

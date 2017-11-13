package Zadanie7_8;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class OpilecGui {

	private final int window_size_x = 800;
	private final int window_size_y = 600;

	private JFrame frame;
	private GridLayout grid;
	private Neighbourhood[][] city;
	private Neighbourhood neighbourhood;
	private Opilec opilec = new Opilec();

	public OpilecGui() throws IOException {

		this.run();
	}

	/**
	 * Initializes the frame
	 */
	private void make_board() {
		this.frame = new JFrame("Opilec");
		this.grid = new GridLayout(this.opilec.get_grid_x(), this.opilec.get_grid_y(), 0, 0);
		this.frame.setLocationRelativeTo(null);
		this.frame.setSize(this.window_size_x, this.window_size_y);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(this.grid);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
	}

	/**
	 * Fill's the frame with JPanels, draws the beginning state of the board
	 * 
	 * @throws IOException
	 */
	private void fill_board() throws IOException {
		this.city = new Neighbourhood[this.opilec.get_grid_x()][this.opilec.get_grid_y()];

		for (int i = 0; i < this.opilec.get_grid_x(); i++) {
			for (int j = 0; j < this.opilec.get_grid_y(); j++) {
				this.neighbourhood = new Neighbourhood();
				this.city[i][j] = this.neighbourhood;
				this.neighbourhood.setVisible(true);
				this.frame.getContentPane().add(neighbourhood);

			}
		}
	}

	private void run() throws IOException {
		this.make_board();
		this.fill_board();
		for (int i = 0; i < 10; i++) {
			try {
				this.opilec.simulate_motion();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

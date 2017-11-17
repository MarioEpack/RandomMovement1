package Zadanie7_8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Creates the simple gui and makes use of the simulation of the class "Opilec"
 * 
 * @author Mario Alina
 *
 */
public class OpilecGui implements ActionListener {

	private final int window_size_x = 800;
	private final int window_size_y = 600;

	private JFrame frame;
	private GridLayout grid;
	private Neighbourhood[][] city;
	private Neighbourhood neighbourhood;
	private Timer timer;
	/*
	 * Musel som spravit triedu na poziciu opilca, pretoze paintComponent vykresluje
	 * vsetko okamzite
	 */
	private OpilecPosition actual_position = new OpilecPosition();
	private Opilec opilec = new Opilec();

	public OpilecGui() throws IOException {
		this.init();
	}

	/**
	 * Initializes the JFrame with the GridLayout
	 */
	private void make_board() {
		this.frame = new JFrame("Opilec");
		this.grid = new GridLayout(this.opilec.get_grid_x(), this.opilec.get_grid_y(), 3, 3);
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
				this.neighbourhood.setLayout(new BorderLayout());
				this.neighbourhood.setVisible(false);
				this.city[i][j] = this.neighbourhood;
				// this.neighbourhood.setVisible(true);
				this.frame.getContentPane().add(neighbourhood);

			}
		}

	}

	/**
	 * Initializes a swing timer
	 */
	private void make_timer() {
		this.timer = new Timer(100, this);
		this.timer.setInitialDelay(100);
	}

	/**
	 * Called in the Constructor calles all the init methods make_board(),
	 * fill_board(), make_timer(), and also starts the swing timer
	 * 
	 * @throws IOException
	 */
	private void init() throws IOException {
		this.make_board();
		this.fill_board();
		this.make_timer();
		this.timer.start();
	}

	/**
	 * Swing method needed for the timer Code inside is a loop currently triggering
	 * every 0.1, --> can be changed in the method make_timer()
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = this.opilec.get_position_index_x();
		int y = this.opilec.get_position_index_y();
		int previous_x = this.opilec.get_previous_position_x();
		int previous_y = this.opilec.get_previous_position_y();

		try {
			this.city[previous_x][previous_y].draw_green(false);
			this.city[previous_x][previous_y].repaint();

			this.city[x][y].draw_green(true);
			this.city[x][y].setVisible(true);
			this.city[x][y].repaint();

			this.city[0][0].setVisible(false);
			this.opilec.simulate_motion();

		} catch (InterruptedException | IndexOutOfBoundsException e1) {
			System.out.println("Opilec is out of bounds");
			// ignore errors
		}
	}
}

package Zadanie7_8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Creates the simple gui and makes use of the simulation class "Drunk"
 * 
 * @author Mario Alina
 *
 */
public class DrunkGui implements ActionListener {

	private final int window_size_x = 800;
	private final int window_size_y = 600;

	private JFrame frame;
	private GridLayout grid;
	private Neighbourhood[][] city;
	private Neighbourhood neighbourhood;
	private Timer timer;
	/**
	 * Speed that the drunk man is walking in milliseconds
	 */
	private final int walking_speed = 500;
	/**
	 * Initialize the Drunk walking simulation class
	 */
	private Drunk drunk = new Drunk();

	/**
	 * Non-parametric constructor, calls method init()
	 * 
	 * @throws IOException
	 */
	public DrunkGui() throws IOException {
		this.init();
	}

	/**
	 * Initializes the JFrame with the GridLayout
	 */
	private void make_board() {
		this.frame = new JFrame("Opilec");
		this.grid = new GridLayout(this.drunk.get_grid_x(), this.drunk.get_grid_y(), 3, 3);
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
		this.city = new Neighbourhood[this.drunk.get_grid_x()][this.drunk.get_grid_y()];

		for (int i = 0; i < this.drunk.get_grid_x(); i++) {
			for (int j = 0; j < this.drunk.get_grid_y(); j++) {
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
		this.timer = new Timer(this.walking_speed, this);
		this.timer.setInitialDelay(500);
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
	 * actionPerformed is a swing method needed for the timer, code inside is a loop
	 * currently triggering every see@, --> "int this.walking_speed atribute"
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * variables that hold the current and previous position of the drunk man, by
		 * using get-ers from "Drunk Class"
		 */
		int x = this.drunk.get_position_index_x();
		int y = this.drunk.get_position_index_y();
		int previous_x = this.drunk.get_previous_position_x();
		int previous_y = this.drunk.get_previous_position_y();

		try {
			this.city[previous_x][previous_y].draw_green(false);
			this.city[previous_x][previous_y].repaint();

			this.city[x][y].draw_green(true);
			this.city[x][y].setVisible(true);
			this.city[x][y].repaint();

			this.city[0][0].setVisible(false);
			this.drunk.simulate_motion();

		} catch (InterruptedException | IndexOutOfBoundsException e1) {
			System.out.println("Opilec is out of bounds");
			// ignore errors
		}
	}
}

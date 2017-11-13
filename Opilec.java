package Zadanie7_8;

import java.util.Random;

public class Opilec {

	private final int grid_x = 20;
	private final int grid_y = 20;
	private int[][] mesto;
	private int position_index_x = 9;
	private int position_index_y = 9;
	private Random random;

	public Opilec() {
		this.mesto = new int[this.grid_x][this.grid_y];
	}

	public int get_grid_x() {
		return this.grid_x;
	}

	public int get_grid_y() {
		return this.grid_y;
	}

	public int get_position_index_x() {
		return this.position_index_x;
	}

	public int get_position_index_y() {
		return this.position_index_y;
	}

	/**
	 * This methods is called in the "simulate_motion" method, to change position of
	 * the opilec.
	 */
	private void move() {
		this.random = new Random();
		int random_move = this.random.nextInt(4);
		if (random_move == 0) {
			this.move_left();
		} else if (random_move == 1) {
			this.move_right();
		} else if (random_move == 2) {
			this.move_up();
		} else if (random_move == 3) {
			this.move_down();
		}
		this.neighbourhood_visited();

	}

	/**
	 * Methods to change the opilec's position.
	 */
	private void move_up() {
		this.position_index_y -= 1;
	}

	private void move_down() {
		this.position_index_y += 1;
	}

	private void move_left() {
		this.position_index_x -= 1;
	}

	private void move_right() {
		this.position_index_x += 1;
	}

	/**
	 * 
	 * @return false if opilec hasn't been on the positon yet, return true otherwise
	 */
	public boolean is_visited(int index_x, int index_y) {
		if (this.mesto[index_x][index_y] == 0) {
			return false;

		} else {
			return true;
		}
	}

	/**
	 * This methods sets the position in the array to value 1, in the case that
	 * opilec has "steped" there.
	 */
	private void neighbourhood_visited() {
		this.mesto[this.position_index_x][this.position_index_y] = 1;
	}

	/**
	 * This method is called on the object opilec to simulate motion
	 * 
	 * @throws InterruptedException
	 */
	public void simulate_motion() throws InterruptedException {

		this.move();
	}

}

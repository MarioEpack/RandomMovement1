package Zadanie7_8;

import javax.swing.SwingUtilities;

public class OpilecMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					OpilecGui opilec = new OpilecGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}

package tac.application.main;

import javax.swing.JFrame;

import tac.application.ui.CalculatorUI;

public class Main {
	
	/**
	 * Used to see the interface
	 * @param args
	 */
		public static void main(String[] args) {
			CalculatorUI calculator = CalculatorUI.getInstance();
			calculator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

}

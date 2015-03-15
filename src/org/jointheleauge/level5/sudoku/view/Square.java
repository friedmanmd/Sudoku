package org.jointheleauge.level5.sudoku.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Square extends JPanel {
	
	JLabel[] value = new JLabel[9];
	int row;
	int column;
	
	public Square(int row, int column) {
		this.row = row;
		this.column = column;
		
		setLayout(new GridLayout(3,3));
		
		for (int i = 0; i < value.length; i++) {
			value[i] = new JLabel(String.format("%d", i+1));
			value[i].setHorizontalAlignment(JLabel.CENTER);
			value[i].setVerticalAlignment(JLabel.CENTER);
			value[i].setFont(new Font("Serif", Font.PLAIN, 24));

			add(value[i]);
		}
		
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void updateValues(org.jointheleauge.level5.sudoku.Square aSquare) {
		if (aSquare.getValue() == 0) {
			int[] digit = aSquare.getPossibleValues();
			int i = 1;
			for (int aDigit : digit ) {
				while (i < aDigit) {
					value[i-1].setText(" ");
					i += 1;
				}
				value[i-1].setText(String.format("%d", aDigit));
				i++;
			}
			for (; i <= value.length; i++) {
				value[i-1].setText(" ");
			}
		} else {
			for (int i = 0; i < 9; i++) {
				if (i == 4) {
					value[i].setText(String.format("%d", aSquare.getValue()));
					value[i].setFont(new Font("Serif", Font.BOLD, 24));
				} else {
					value[i].setText(" ");
				}
			}
		}
	}

}

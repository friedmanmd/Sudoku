package org.jointheleauge.level5.sudoku.view;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_ROWS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_COLUMNS;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class SudokuView implements Observer {
	Square[][] square = new Square[NUM_ROWS][NUM_COLUMNS];
	
	public SudokuView() {
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		
		mainPanel.setLayout(new GridLayout(3,3));
		
		Border blackBorder = BorderFactory.createLineBorder(Color.black);
		JPanel[] region = new JPanel[3];
		
		for (int row = 0; row < NUM_ROWS ; row++) {
			if (row % 3 == 0) {
				region[0] = new JPanel();
				region[0].setBorder(blackBorder);
				region[0].setLayout(new GridLayout(3,3));
				mainPanel.add(region[0]);
				region[1] = new JPanel();
				region[1].setBorder(blackBorder);
				region[1].setLayout(new GridLayout(3,3));
				mainPanel.add(region[1]);
				region[2] = new JPanel();
				region[2].setBorder(blackBorder);
				region[2].setLayout(new GridLayout(3,3));
				mainPanel.add(region[2]);
			}
			for (int column = 0; column < NUM_COLUMNS; column++) {
				square[row][column] = new Square(row, column);
				region[column / 3].add(square[row][column]);
			}
		}
		
		mainPanel.setBorder(blackBorder);
		frame.setSize(1600,1200);
		frame.setVisible(true);
		
	}

	@Override
	// Called from the Model
	public void update(Observable obs, Object obj) {
		org.jointheleauge.level5.sudoku.Square aSquare = (org.jointheleauge.level5.sudoku.Square) obj;
		square[aSquare.getRow()][aSquare.getColumn()].updateValues(aSquare);

	} //update()
}

package org.jointheleauge.level5.sudoku;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class Column implements Section {
	private int columnNum;

	public Column(int num) {
		columnNum = num;
	}

	public void update(Square[][] square, Square aSquare) {
		if (aSquare.getColumn() == columnNum) {
			for (int item = 0; item < square.length; item++) {
				if (square[item][columnNum].getValue() == 0)
					square[item][columnNum]
							.removePossibleValue(aSquare.getValue());
			}
		}
	}
}

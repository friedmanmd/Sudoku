package org.jointheleauge.level5.sudoku;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class Row implements Section {
	private int rowNum;

	public Row(int num) {
		rowNum = num;
	}

	public void update(Square[][] square, Square aSquare) {
		if (aSquare.getRow() == rowNum) {
			for (int item = 0; item < square.length; item++) {
				if (square[rowNum][item].getValue() == 0)
					square[rowNum][item]
							.removePossibleValue(aSquare.getValue());
			}
		}
	}
}

package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class Row extends Section {
	private int rowNum;

	public Row(int num) {
		rowNum = num;
	}

	@Override
	public Square sectionSquare(Square[][] square, int index) {
		if (index < 0 || index > NUM_SQUARES_IN_SECTION) throw new IllegalArgumentException();
		return square[rowNum][index];
	}

	@Override
	protected boolean isInSection(Square aSquare) {
		return (aSquare.getRow() == rowNum);
	}
	
	@Override
	public String toString() {
		return String.format("Row [%d]", rowNum);
	}
}

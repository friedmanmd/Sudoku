package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;
import static org.jointheleauge.level5.sudoku.Sudoku.REGION_SIDE_LENGTH;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class Region extends Section {
	// Region is defined by its top-left square
	private int columnNum;
	private int rowNum;

	public Region(int row, int column) {
		rowNum = row;
		columnNum = column;
	}

	@Override
	public Square sectionSquare(Square[][] square, int index) {
		if (index < 0 || index > NUM_SQUARES_IN_SECTION) throw new IllegalArgumentException();
		int row = index / REGION_SIDE_LENGTH;
		int col = index % REGION_SIDE_LENGTH;
		return square[rowNum+row][columnNum+col];
	}

	@Override
	public boolean isInSection(Square aSquare) {
		return ((rowNum <= aSquare.getRow()) && (aSquare.getRow() < rowNum + 3) &&
				(columnNum <= aSquare.getColumn()) && (aSquare.getColumn() < columnNum + 3));
	}
	
	@Override
	public String toString() {
		return String.format("Region [%d, %d]", rowNum, columnNum);
	}
}

package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class DiagonalTRBL extends Section {
	private int diagNum;

	public DiagonalTRBL(int num) {
		diagNum = num;
	}

	@Override
	public Square sectionSquare(Square[][] square, int index) {
		if (index < 0 || index > NUM_SQUARES_IN_SECTION) throw new IllegalArgumentException();
		return square[index][(diagNum - index) % 9];
	}

	@Override
	protected boolean isInSection(Square aSquare) {
		return (aSquare.getColumn() == (aSquare.getRow() - diagNum) % 9);
	}
	
	@Override
	public String toString() {
		return String.format("DiagonalTRBL [%d]", diagNum);
	}
}

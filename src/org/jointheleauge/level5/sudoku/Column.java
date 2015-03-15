package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class Column extends Section {
	private int columnNum;

	public Column(int num) {
		columnNum = num;
	}

	@Override
	public Square sectionSquare(Square[][] square, int index) {
		if (index < 0 || index > NUM_SQUARES_IN_SECTION) throw new IllegalArgumentException();
		return square[index][columnNum];
	}

	@Override
	public boolean isInSection(Square aSquare) {
		return (aSquare.getColumn() == columnNum);
	}

	@Override
	public String toString() {
		return String.format("Column [%d]", columnNum);
	}

}

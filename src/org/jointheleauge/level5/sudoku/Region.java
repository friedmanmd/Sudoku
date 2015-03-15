package org.jointheleauge.level5.sudoku;

/**
 * Row represents a row of squares on a Sudoku board
 */
public class Region implements Section {
	// Region is defined by its top-left square
	private int columnNum;
	private int rowNum;

	public Region(int row, int column) {
		rowNum = row;
		columnNum = column;
	}

	public void update(Square[][] square, Square aSquare) {
		if (isInRegion(aSquare)) {
			for (int r = rowNum; r < rowNum + 3; r += 3) {
				for (int c = columnNum; c < columnNum + 3; c += 3) {
					if (square[r][c].getValue() == 0)
						square[r][c].removePossibleValue(aSquare.getValue());
				}
			}
		}
	}

	private boolean isInRegion(Square aSquare) {
		if ((rowNum <= aSquare.getRow() && aSquare.getRow() < rowNum + 3) &&
			(columnNum <= aSquare.getColumn() && aSquare.getColumn() < columnNum + 3)) {
			return true;
		} else {
			return false;
		}
	}
}

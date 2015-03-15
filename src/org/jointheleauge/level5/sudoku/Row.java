package org.jointheleauge.level5.sudoku;

import java.util.Arrays;

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

	@Override
	public int[] getPair(Square[][] square) {
		int[] pair;
		
		for (int i = 0; i < (square.length - 1); i++) {
			pair = square[rowNum][i].getPossibleValues();
			if (square[rowNum][i].getValue() == 0 && pair.length == 2) {
				for (int j = i + 1; j < square.length; j++) {
					if (square[rowNum][j].getValue() == 0 &&
							Arrays.equals(square[rowNum][j].getPossibleValues(), pair)) {
						return pair;
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public void processPair(Square[][] square, int[] pair) {
		for (int col = 0; col < square.length; col++) {
			if (square[rowNum][col].getValue() == 0) {
				square[rowNum][col].removePossibleValue(pair[0]);
				square[rowNum][col].removePossibleValue(pair[1]);
			}
		}
	}
}

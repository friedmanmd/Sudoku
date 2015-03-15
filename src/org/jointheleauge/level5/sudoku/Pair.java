package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

import java.util.Arrays;

public class Pair implements Strategy {
	
	public void invokeOn(Section section, Square[][] square) {
		int[] pair = getPair(section, square);
		if (pair != null) {
			processPair(section, square, pair);
		}
	}

	/**
	 * @return array of int of length two that contains the first pair of
	 * possible values that occur in two squares of this section;
	 * returns null if no such pair exists
	 */
	protected int[] getPair(Section section, Square[][] square) {
		int[] pair;
		
		for (int i = 0; i < (NUM_SQUARES_IN_SECTION - 1); i++) {
			Square currentSquare = section.sectionSquare(square, i);
			pair = currentSquare.getPossibleValues();
			if (currentSquare.getValue() == 0 && pair.length == 2) {
				for (int j = i + 1; j < NUM_SQUARES_IN_SECTION; j++) {
					Square testSquare = section.sectionSquare(square, j);
					if (testSquare.getValue() == 0 &&
							Arrays.equals(testSquare.getPossibleValues(), pair)) {
						return pair;
					}
				}
			}
		}
		
		return null;
	};
	
	 /**
	 * @param array of int of length two that contains a pair of
	 * possible values; removes the two values from all squares not
	 * having the pair as their only possible values
	 */
	protected void processPair(Section section, Square[][] square, int[] pair){
		for (int i = 0; i < NUM_SQUARES_IN_SECTION; i++) {
			Square currentSquare = section.sectionSquare(square, i);

			if (currentSquare.getValue() == 0 && !Arrays.equals(pair, currentSquare.getPossibleValues())) {
				currentSquare.removePossibleValue(pair[0]);
				currentSquare.removePossibleValue(pair[1]);
			}
		}
	}

}

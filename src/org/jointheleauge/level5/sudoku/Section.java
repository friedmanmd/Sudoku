package org.jointheleauge.level5.sudoku;

/**
 * Represents a portion of the board that must be updated when a board square
 * contained within this section is modified
 */
public interface Section {
	/**
	 * @param square
	 *            is the board data that holds all Sudoku information
	 * @param aSquare
	 *            is the Square used to update all Section values
	 */
	void update(Square[][] square, Square aSquare);
	
	 /**
	 * @return array of int of length two that contains the first pair of
	 * possible values that occur in two squares of this section;
	 * returns null if no such pair exists
	 */
	int[] getPair(Square[][] square);
	
	 /**
	 * @param array of int of length two that contains a pair of
	 * possible values; removes the two values from all squares not
	 * having the pair as their only possible values
	 */
	void processPair(Square[][] square, int[] pair); 

}
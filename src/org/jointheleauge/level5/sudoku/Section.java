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

}
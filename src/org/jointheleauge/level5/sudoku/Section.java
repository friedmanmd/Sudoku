package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

/**
 * Represents a portion of the board that must be updated when a board square
 * contained within this section is modified
 */
public abstract class Section {

	/**
	 * 
	 * @param square
	 *            is the board data that holds all Sudoku information
	 * @param index
	 * 			  is the 0 based index into the section of the Square to return
	 * 
	 * @return Square with at the index this section from the board
	 */
	public abstract Square sectionSquare(Square[][] square, int index);

	/**
	 * 
	 * @param aSquare
	 * @return true if aSquare is in this section
	 */
	protected abstract boolean isInSection(Square aSquare);

	/**
	 * @param square
	 *            is the board data that holds all Sudoku information
	 * @param aSquare
	 *            is the Square used to update all Section values
	 */
	void update(Square[][] square, Square aSquare) {
		if (isInSection(aSquare)) {
			for (int i = 0; i < NUM_SQUARES_IN_SECTION; i++) {
				Square sectionSquare = sectionSquare(square, i);
				if (sectionSquare.getValue() == 0) {
					sectionSquare.removePossibleValue(aSquare.getValue());
				}
			}
		}
	};
	

}
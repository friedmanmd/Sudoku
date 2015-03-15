package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_ROWS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_COLUMNS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_REGIONS;

/**
 * Board class models the 9 by 9 rectangular array of squares. Each square can
 * be blank or have an integer value 1 through 9. Each square also has a list of
 * possible values that may be used for that square's value.
 */
public class Board {
	// all squares on the Sudoku board
	private Square[][] square;
	// true if a square on the board has a new state; false otherwise
	private boolean stateChanged;
	// all sections that are defined for the board
	private Section[] section;

	/**
	 * Initialize all data related to the board
	 */
	public Board() {
		stateChanged = false; // indicates if a square has been changed

		square = new Square[NUM_ROWS][NUM_COLUMNS];

		for (int r = 0; r < square.length; r++) {
			for (int c = 0; c < square[0].length; c++) {
				// initializing a square with 0 means it has an
				// undetermined value (possible values are 1 to 9)
				square[r][c] = new Square(0, r, c);
			}
		}
		sectionsInit();
	}

	/*
	 * Initialize all sections (rows, columns, and regions) so each type of
	 * section is initialized with consecutive integer values beginning with 0.
	 */
	private void sectionsInit() {
		int totalSections = 0;
		section = new Section[NUM_ROWS+NUM_COLUMNS+NUM_REGIONS];
		for (int r = 0; r < NUM_ROWS; r++) {
			section[totalSections++] = new Row(r);
		}
		for (int c = 0; c < NUM_COLUMNS; c++) {
			section[totalSections++] = new Column(c);
		}
		for (int r = 0; r < NUM_ROWS; r += 3) {
			for (int c = 0; c < NUM_COLUMNS; c += 3) {
				section[totalSections++] = new Region(r,c);
			}
		}
	}
}

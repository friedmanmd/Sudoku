package org.jointheleauge.level5.sudoku;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_ROWS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_COLUMNS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_REGIONS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

import java.util.Observable;

/**
 * Board class models the 9 by 9 rectangular array of squares. Each square can
 * be blank or have an integer value 1 through 9. Each square also has a list of
 * possible values that may be used for that square's value.
 */
public class Board extends Observable {
	// all squares on the Sudoku board
	private Square[][] square;
	// true if a square on the board has a new state; false otherwise
	private boolean stateChanged;
	// all sections that are defined for the board
	private Section[] section;
	// all strategies that are defined for the sections
	private Strategy[] strategy;

	/**
	 * Initialize all data related to the board
	 */
	public Board() {
		stateChanged = true; // indicates if a square has been changed

		square = new Square[NUM_ROWS][NUM_COLUMNS];

		for (int r = 0; r < square.length; r++) {
			for (int c = 0; c < square[0].length; c++) {
				// initializing a square with 0 means it has an
				// undetermined value (possible values are 1 to 9)
				square[r][c] = new Square(0, r, c, this);
			}
		}
		sectionsInit();
		strategiesInit();
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
		for (int i = 0; i < NUM_SQUARES_IN_SECTION; i++) {
			section[totalSections++] = new DiagonalTLBR(i);
		}
		for (int i = 0; i < NUM_SQUARES_IN_SECTION; i++) {
			section[totalSections++] = new DiagonalTLBR(i);
		}

	}
	
	private void strategiesInit() {
		strategy = new Strategy[1];
		strategy[0] = new Pair();
	}


	public void solve() {
		stateChanged = true;

		while (stateChanged) {
			stateChanged = false;
			
			for (Strategy aStrategy : strategy) {
				for (Section aSection : section) {
					aStrategy.invokeOn(aSection, square);
				}
			}
			
			resolveKnownSquares();
		}
		
		
		return;
	}
	
	protected void resolveKnownSquares() {
		stateChanged = false;
		boolean doneUpdating = false;
		
		while (!doneUpdating) {
			doneUpdating = true;
			for (Square[] aRow : square) {
				for (Square aSquare : aRow) {
					if (aSquare.getValue() == 0) {
						int[] values = aSquare.getPossibleValues();
						if (values != null && values.length == 1) {
							updateSections(aSquare.getRow(), aSquare.getColumn(), values[0]);
							stateChanged = true;
							doneUpdating = false;
						}
					}
				}
			}
		}
		return;
	}

	public void updateSections(int row, int column, int value) {
		square[row][column].setValue(value);
		for (Section aSection : section) {
			aSection.update(square, square[row][column]);
		}		
		resolveKnownSquares();
	}

	public void updateBoard(Square aSquare) {
		setChanged();
		notifyObservers(aSquare);
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void dumpBoard() {
		for (int row = 0; row < square.length; row ++) {
			StringBuffer line1 = new StringBuffer();
			StringBuffer line2 = new StringBuffer();
			StringBuffer line3 = new StringBuffer();
			for (int column = 0; column < square.length; column++) {
				String[] cell = square[row][column].dump();
				line1.append(cell[0]);
				line2.append(cell[1]);
				line3.append(cell[2]);
				
				if (column % 3 == 2 && column != 8) {
					line1.append('|');
					line2.append('|');
					line3.append('|');
				} else if (column != 8) {
					line1.append('!');
					line2.append('!');
					line3.append('!');
				}
			}
			System.out.println(line1.toString());
			System.out.println(line2.toString());
			System.out.println(line3.toString());
			char horizontalSeparator = '-';
			if (row % 3 == 2) horizontalSeparator = '=';
			if (row != 8) {
				for (int i = 0; i < 35; i++) {
					System.out.print(horizontalSeparator);
				}
			}
			System.out.println();
		}
	}
}

package org.jointheleauge.level5.sudoku;

import org.jointheleauge.level5.sudoku.view.SudokuView;

public final class Sudoku {
	public static final int NUM_SQUARES_IN_SECTION = 9;
	public static final int NUM_ROWS = NUM_SQUARES_IN_SECTION;
	public static final int NUM_COLUMNS = NUM_SQUARES_IN_SECTION;
	public static final int NUM_REGIONS = NUM_SQUARES_IN_SECTION;
	public static final int REGION_SIDE_LENGTH = 3;
	
	public static void main(String [] args) {
		SudokuView view = new SudokuView();
		Board sudoku = new Board();
		sudoku.addObserver(view);
		sudoku.initFromFile("resource/puzzle1.json");
		
//		sudoku.updateSections(0, 0, 1);
//		sudoku.updateSections(0, 3, 8);
//		sudoku.updateSections(0, 6, 3);
//		sudoku.updateSections(1, 2, 4);
//		sudoku.updateSections(1, 4, 9);
//		sudoku.updateSections(1, 5, 3);
//		sudoku.updateSections(1, 8, 2);
//		sudoku.updateSections(2, 0, 3);
//		sudoku.updateSections(2, 3, 1);
//		sudoku.updateSections(2, 4, 6);
//		sudoku.updateSections(2, 8, 8);
//		sudoku.updateSections(3, 0, 6);
//		sudoku.updateSections(3, 1, 8);
//		sudoku.updateSections(3, 2, 5);
//		sudoku.updateSections(3, 3, 3);
//		sudoku.updateSections(3, 7, 4);
//		sudoku.updateSections(4, 1, 2);
//		sudoku.updateSections(4, 4, 4);
//		sudoku.updateSections(4, 7, 8);
//		sudoku.updateSections(5, 1, 4);
//		sudoku.updateSections(5, 5, 9);
//		sudoku.updateSections(5, 6, 6);
//		sudoku.updateSections(5, 7, 1);
//		sudoku.updateSections(5, 8, 5);
//		sudoku.updateSections(6, 0, 2);
//		sudoku.updateSections(6, 4, 1);
//		sudoku.updateSections(6, 5, 5);
//		sudoku.updateSections(6, 8, 4);
//		sudoku.updateSections(7, 0, 4);
//		sudoku.updateSections(7, 3, 9);
//		sudoku.updateSections(7, 4, 2);
//		sudoku.updateSections(7, 6, 5);
//		sudoku.updateSections(8, 2, 6);
//		sudoku.updateSections(8, 5, 7);
//		sudoku.updateSections(8, 8, 1); 
		sudoku.solve();
		
	}
}

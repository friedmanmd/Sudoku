package org.jointheleauge.level5.sudoku.strategy;

import org.jointheleauge.level5.sudoku.Section;
import org.jointheleauge.level5.sudoku.Square;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_ROWS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_COLUMNS;
import static org.jointheleauge.level5.sudoku.Sudoku.NUM_REGIONS;

public abstract class BoardStrategy implements Strategy {

	@Override
	public void invokeOn(Square[][] square, Section... sections) {
		if (sections.length != NUM_ROWS+NUM_COLUMNS+NUM_REGIONS)
			throw new IllegalArgumentException(String.format(
					"%s takes no section", this.getClass().getName()));
	}

}

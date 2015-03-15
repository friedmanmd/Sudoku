package org.jointheleauge.level5.sudoku.strategy;

import org.jointheleauge.level5.sudoku.Section;
import org.jointheleauge.level5.sudoku.Square;

public interface Strategy {
	public void invokeOn(Square[][] square, Section... sections);

}

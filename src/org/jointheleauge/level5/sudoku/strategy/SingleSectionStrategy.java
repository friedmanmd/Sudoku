package org.jointheleauge.level5.sudoku.strategy;

import org.jointheleauge.level5.sudoku.Section;
import org.jointheleauge.level5.sudoku.Square;

public abstract class SingleSectionStrategy implements Strategy {

	@Override
	public void invokeOn(Square[][] square, Section... sections) {
		if (sections.length != 1)
			throw new IllegalArgumentException(String.format(
					"%s takes one and only one section", this.getClass().getName()));
	}

}

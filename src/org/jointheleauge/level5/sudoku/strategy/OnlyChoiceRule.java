package org.jointheleauge.level5.sudoku.strategy;

import org.jointheleauge.level5.sudoku.Section;
import org.jointheleauge.level5.sudoku.Square;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

/**
 * 
 * @author Stephen
 * 
 *         There may be only one possible choice for a particular Sudoku square.
 *         In the simplest case you have a group (row, column or region) that
 *         has eight squares allocated leaving only one remaining choice
 *         available; so the remaining number must go in that empty square.
 *
 */
public class OnlyChoiceRule extends SingleSectionStrategy {

	private static final Logger logger = LogManager.getLogger(OnlyChoiceRule.class.getName());

	@Override
	public void invokeOn(Square[][] square, Section... sections) {
		super.invokeOn(square, sections);
		
		Square unsolvedSquare = null;
		boolean[] seenValues = new boolean[NUM_SQUARES_IN_SECTION];
		
		for (int i = 0; i < NUM_SQUARES_IN_SECTION; i++) {
			Square currentSquare = sections[0].sectionSquare(square, i);
			if (currentSquare.getValue() == 0) {
				if (unsolvedSquare != null) {
					// More than one unsolved square
					logger.debug("{} Multiple Unsolved", sections[0].toString());
					return;
				} else {
					unsolvedSquare = currentSquare;
				}
			} else {
				seenValues[currentSquare.getValue()-1] = true;
			}
		}

		logger.debug("{} Unsolved: {}", sections[0].toString(), unsolvedSquare != null);

		if (unsolvedSquare == null) {
			// No unsolved square
			return;
		}

		
		int setValue = 0;
		for (int i = 0; i < seenValues.length; i++) {
			if (seenValues[i]) continue;
			setValue = i + 1;
		}
		
		unsolvedSquare.setValue(setValue);
	}

}

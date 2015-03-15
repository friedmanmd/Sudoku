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
 *         When you look at individual squares you will often find that there is
 *         only one possibility left for the square. Note: If there are eight
 *         squares solved in the group then this is just the same as the only
 *         choice rule. Because of the way that groups intersect you may have a
 *         group with more than one unallocated square and yet only one
 *         possibility exists for one of the squares. So there is only one
 *         possibility for that square, and the number must go there.
 *
 */
public class SinglePossibilityRule extends BoardStrategy {

	private static final Logger logger = LogManager.getLogger(SinglePossibilityRule.class.getName());

	@Override
	public void invokeOn(Square[][] square, Section... sections) {
		super.invokeOn(square, sections);

		for (int r = 0; r < square.length; r++) {
			for (int c = 0; c < square.length; c++) {
				if (square[r][c].getValue() == 0) {
					int[] possibleValues = square[r][c].getPossibleValues();
					if (possibleValues.length == 1) {
						logger.debug("[{},{}] set: {}", r, c, possibleValues[0]);
						square[r][c].setValue(possibleValues[0]);
					}
				}
			}
		}
	}
}

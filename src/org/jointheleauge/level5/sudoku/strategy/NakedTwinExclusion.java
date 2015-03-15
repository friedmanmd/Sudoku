package org.jointheleauge.level5.sudoku.strategy;

import static org.jointheleauge.level5.sudoku.Sudoku.NUM_SQUARES_IN_SECTION;

import java.util.Arrays;

import org.jointheleauge.level5.sudoku.Section;
import org.jointheleauge.level5.sudoku.Square;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

/**
 * @author Stephen
 *
 * In the Naked Twin Strategy the twin squares are evident on their own (and so they are
 * termed 'naked' to distinguish them from the previous 'hidden' case) and these
 * are used to exclude possibilities in other squares in the same group.
 *
 */
public class NakedTwinExclusion extends SingleSectionStrategy {
	
	private static final Logger logger = LogManager.getLogger(NakedTwinExclusion.class.getName());

	public void invokeOn(Square[][] square, Section... sections) {
		super.invokeOn(square, sections);

		int[] pair = getPair(sections[0], square);
		logger.debug("{} Pair: {}", sections[0].toString(), pair != null);
		if (pair != null) {
			processPair(sections[0], square, pair);
		}
	}

	/**
	 * @return array of int of length two that contains the first pair of
	 *         possible values that occur in two squares of this section;
	 *         returns null if no such pair exists
	 */
	protected int[] getPair(Section section, Square[][] square) {
		int[] pair;

		for (int i = 0; i < (NUM_SQUARES_IN_SECTION - 1); i++) {
			Square currentSquare = section.sectionSquare(square, i);
			pair = currentSquare.getPossibleValues();
			if (currentSquare.getValue() == 0 && pair.length == 2) {
				for (int j = i + 1; j < NUM_SQUARES_IN_SECTION; j++) {
					Square testSquare = section.sectionSquare(square, j);
					if (testSquare.getValue() == 0
							&& Arrays.equals(testSquare.getPossibleValues(),
									pair)) {
						return pair;
					}
				}
			}
		}

		return null;
	};

	/**
	 * @param array
	 *            of int of length two that contains a pair of possible values;
	 *            removes the two values from all squares not having the pair as
	 *            their only possible values
	 */
	protected void processPair(Section section, Square[][] square, int[] pair) {
		for (int i = 0; i < NUM_SQUARES_IN_SECTION; i++) {
			Square currentSquare = section.sectionSquare(square, i);

			if (currentSquare.getValue() == 0
					&& !Arrays.equals(pair, currentSquare.getPossibleValues())) {
				currentSquare.removePossibleValue(pair[0]);
				currentSquare.removePossibleValue(pair[1]);
			}
		}
	}

}

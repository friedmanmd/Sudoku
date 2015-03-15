package org.jointheleauge.level5.sudoku;

public interface Strategy {
	public void invokeOn(Section section, Square[][] square);

}

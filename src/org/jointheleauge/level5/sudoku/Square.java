package org.jointheleauge.level5.sudoku;

import java.util.Arrays;

public class Square {
	protected Board board;
	protected int value;
	protected int row;
	protected int column;
	protected boolean[] possibleValue =
		{
		true, true, true,
		true, true, true,
		true, true, true
		};

	public Square(int value, int row, int column, Board board) {
		this.value = value;
		this.row = row;
		this.column = column;
		this.board = board;
	}

	
	public void setValue(int value) {
		this.value = value;
		board.updateBoard(this);
	}

	public int getValue() {
		return value;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void removePossibleValue(int value) {
		if (possibleValue[value-1]) {
			possibleValue[value-1] = false;
		}
		board.redrawSquare(this);
	}

	public int[] getPossibleValues() {
		int[] values = null;
		
		for (int i = 0; i < possibleValue.length; i++) {
			if (possibleValue[i]) {
				if (values == null) {
					values = new int[1];
					values[0] = i+1;
				} else {
					values = Arrays.copyOf(values, values.length+1);
					values[values.length-1] = i+1;
				}
			}
		}
		return values;
	}
	
	public String[] dump() {
		String[] returnVal = new String[3];
		char[] cell = new char[possibleValue.length];
		
		if (value == 0) {	
			for (int i = 0; i < possibleValue.length; i++) {
				if (possibleValue[i]) {
					cell[i] = Character.forDigit(i+1, 10);
				} else {
					cell[i] = ' ';
				}
			}
		} else {
			for (int i = 0; i < possibleValue.length; i++) cell[i] = ' ';
			cell[4] = Character.forDigit(value, 10);
		}
		returnVal[0] = new String(Arrays.copyOfRange(cell, 0, 3));
		returnVal[1] = new String(Arrays.copyOfRange(cell, 3, 6));
		returnVal[2] = new String(Arrays.copyOfRange(cell, 6, 9));
		
		return returnVal;
	}

}

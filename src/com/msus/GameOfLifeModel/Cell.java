package com.msus.GameOfLifeModel;

import java.util.HashSet;
import java.util.Set;

public class Cell implements Cloneable {
	private State state;
	private State nextState;
	private Set<Cell> neighbours = new HashSet<Cell>();

	public Cell(int x, int y, State state) {
		this.state = state;
	}

	public Cell(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "C(" + state + ")";
	}

	@Override
	protected Object clone() {
		return new Cell(getState());
	}

	public void findNextState() {
		int sum = 0;
		for (Cell cell : neighbours) {
			sum += cell.getState().intValue();
		}
		if (sum == 3) {
			setNextState(State.ALIVE);
		} else if( sum == 2)
			setNextState(getState());
		else
			setNextState(State.DEAD);
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public void addNeighbour(Cell cell) {
		neighbours.add(cell);
	}

	public void acceptNextState() {
		setState(getNextState());
	}

}

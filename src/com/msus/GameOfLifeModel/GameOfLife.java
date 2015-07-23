package com.msus.GameOfLifeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class GameOfLife extends Observable implements CellulatAutomation {

	private Map<Coords, Cell> grid = new HashMap<Coords, Cell>();
	private List<Integer> bounds = new ArrayList<Integer>();
	private Coords endCoords;

	public GameOfLife(int n, int m) {
		endCoords = new Coords(n, m);
		bounds.add(new Integer(n));
		bounds.add(new Integer(m));
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid.put(new Coords(i, j), new Cell(State.DEAD));

		for (Coords coords : grid.keySet()) {
			for (int i = coords.getX() - 1; i <= coords.getX() + 1; i++)
				for (int j = coords.getY() - 1; j <= coords.getY() + 1; j++) {
					Coords tmpNeighbour = new Coords(i, j).normalizeCoords(endCoords);
					if (i >= 0 && j >= 0 && i < endCoords.getX() && j < endCoords.getY()
							&& coords.compare(coords, tmpNeighbour) != 0)
						grid.get(coords).addNeighbour(grid.get(tmpNeighbour));
				}
		}
	}

	public List<Coords> toArrayOfState(State state) {
		List<Coords> result = new ArrayList<Coords>();
		for (Coords key : grid.keySet()) {
			if (grid.get(key).getState() == state) {
				result.add(key);
			}
		}
		return result;
	}

	@Override
	public void setCellState(Coords coords, State state) {
		grid.get(coords.normalizeCoords(endCoords)).setState(state);
	}

	@Override
	public void next() {
		for (Coords coords : grid.keySet()) {
			grid.get(coords).findNextState();
		}
		for (Cell cell : grid.values()) {
			cell.acceptNextState();
		}
		setChanged();
		notifyObservers(toArrayOfState(State.ALIVE));
	}

	@Override
	public List<Coords> getData() {
		return toArrayOfState(State.ALIVE);
	}

	@Override
	public void setCellState(Coords coords) {
		State currentState = grid.get(coords).getState();
		State newState = (currentState == State.DEAD) ? State.ALIVE : State.DEAD;
		setCellState(coords, newState);
		setChanged();
		notifyObservers(toArrayOfState(State.ALIVE));

	}

	@Override
	public State getCellState(Coords coords) {
		return grid.get(coords).getState();
//		return (grid.get(coords) != null) ? grid.get(coords).getState() : null;
	}

}

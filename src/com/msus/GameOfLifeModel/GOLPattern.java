package com.msus.GameOfLifeModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum GOLPattern {
	EMPTY, GLIDER, TOAD, LIGHTWEIGHT_SPACESHIP, GOSPER_GLIDER_GUN, INFINITE1, INFINITE2;

	List<Coords> points;

	public Set<Coords> getPoints(Coords currentCoords, int rot) {
		Set<Coords> points = new HashSet<Coords>();
		if (this == GOLPattern.EMPTY) {
			points.add(new Coords(0, 0));
		} else if (this == GOLPattern.GLIDER) {
			points.add(new Coords(0, 1));
			points.add(new Coords(1, 2));
			points.add(new Coords(2, 0));
			points.add(new Coords(2, 1));
			points.add(new Coords(2, 2));
		} else if (this == GOLPattern.TOAD) {
			points.add(new Coords(0, 1));
			points.add(new Coords(0, 2));
			points.add(new Coords(0, 3));
			points.add(new Coords(1, 0));
			points.add(new Coords(1, 1));
			points.add(new Coords(1, 2));
		} else if (this == GOLPattern.LIGHTWEIGHT_SPACESHIP) {
			points.add(new Coords(0, 1));
			points.add(new Coords(0, 4));
			points.add(new Coords(1, 0));
			points.add(new Coords(2, 0));
			points.add(new Coords(2, 4));
			points.add(new Coords(3, 0));
			points.add(new Coords(3, 1));
			points.add(new Coords(3, 2));
			points.add(new Coords(3, 3));
		} else if (this == GOLPattern.GOSPER_GLIDER_GUN) {
			points.add(new Coords(0, 0));
			points.add(new Coords(0, 1));
			points.add(new Coords(1, 0));
			points.add(new Coords(1, 1));
			points.add(new Coords(0, 10));
			points.add(new Coords(1, 10));
			points.add(new Coords(2, 10));
			points.add(new Coords(-1, 11));
			points.add(new Coords(3, 11));
			points.add(new Coords(-2, 12));
			points.add(new Coords(4, 12));
			points.add(new Coords(-2, 13));
			points.add(new Coords(4, 13));
			points.add(new Coords(1, 14));
			points.add(new Coords(-1, 15));
			points.add(new Coords(3, 15));
			points.add(new Coords(0, 16));
			points.add(new Coords(1, 16));
			points.add(new Coords(2, 16));
			points.add(new Coords(1, 17));
			points.add(new Coords(-2, 20));
			points.add(new Coords(-1, 20));
			points.add(new Coords(0, 20));
			points.add(new Coords(-2, 21));
			points.add(new Coords(-1, 21));
			points.add(new Coords(0, 21));
			points.add(new Coords(-3, 22));
			points.add(new Coords(1, 22));
			points.add(new Coords(-4, 24));
			points.add(new Coords(-3, 24));
			points.add(new Coords(1, 24));
			points.add(new Coords(2, 24));
			points.add(new Coords(-2, 34));
			points.add(new Coords(-1, 34));
			points.add(new Coords(-2, 35));
			points.add(new Coords(-1, 35));
		} else if (this == GOLPattern.INFINITE1) {
			points.add(new Coords(0, 0));
			points.add(new Coords(0, 2));
			points.add(new Coords(-1, 2));
			points.add(new Coords(-2, 4));
			points.add(new Coords(-3, 4));
			points.add(new Coords(-4, 4));
			points.add(new Coords(-3, 6));
			points.add(new Coords(-4, 6));
			points.add(new Coords(-5, 6));
			points.add(new Coords(-4, 7));
		} else if (this == GOLPattern.INFINITE2) {
			points.add(new Coords(0, 0));
			points.add(new Coords(0, 1));
			points.add(new Coords(0, 2));
			points.add(new Coords(0, 4));
			points.add(new Coords(1, 0));
			points.add(new Coords(2, 3));
			points.add(new Coords(2, 4));
			points.add(new Coords(3, 1));
			points.add(new Coords(3, 2));
			points.add(new Coords(3, 4));
			points.add(new Coords(4, 0));
			points.add(new Coords(4, 2));
			points.add(new Coords(4, 4));
		}
		for (Coords p : points) {
			int p0 = p.getX();
			int p1 = p.getY();
			p.setX(p0 * (int) Math.cos(Math.PI * rot / 2) - p1 * (int) Math.sin(Math.PI * rot / 2));
			p.setX(p.getX() + currentCoords.getX());
			p.setY(p0 * (int) Math.sin(Math.PI * rot / 2) + p1 * (int) Math.cos(Math.PI * rot / 2));
			p.setY(p.getY() + currentCoords.getY());
		}
		return points;
	}

	public void draw(CellulatAutomation model, Coords currentCoords, int rot) {
		State expectedState = State.ALIVE;
		if (this == GOLPattern.EMPTY && model.getCellState(currentCoords) == State.ALIVE)
			expectedState = State.DEAD;
		Set<Coords> points = getPoints(currentCoords, rot);
		for (Coords p : points) {
			model.setCellState(p, expectedState);
		}
	}

}

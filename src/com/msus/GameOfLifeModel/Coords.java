package com.msus.GameOfLifeModel;

import java.util.Comparator;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Coords implements Comparator<Coords> {
	private Integer x;
	private Integer y;

	
	public Coords(Integer x, Integer y) {
		super();
		this.x = x;
		this.y = y;
	}
	

	public Coords normalizeCoords(Coords endCoords) {
		this.setX((this.getX() % endCoords.getX() + endCoords.getX()) % endCoords.getX());
		this.setY((this.getY() % endCoords.getY() + endCoords.getY()) % endCoords.getY());
		return this;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	@Override
	public int compare(Coords o1, Coords o2) {
		return ComparisonChain.start().compare(o1.getX(),o2.getX()).compare(o1.getY(),o2.getY()).result();
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Coords other = (Coords) obj;
		return this.getX().equals(other.getX()) && this.getY().equals(other.getY());
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hashCode(getX(),getY());
	}
	
	
	
	
	
	
}

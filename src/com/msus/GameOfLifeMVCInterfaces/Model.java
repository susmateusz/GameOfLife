package com.msus.GameOfLifeMVCInterfaces;

import java.util.List;
import java.util.Observer;

import com.msus.GameOfLifeModel.Coords;

public interface Model {
	
	void addObserver(Observer o);
	
	List<Coords> getData();
	
	void next();

}

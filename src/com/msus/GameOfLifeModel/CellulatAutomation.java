package com.msus.GameOfLifeModel;

import java.util.List;

import com.msus.GameOfLifeMVCInterfaces.Model;

public interface CellulatAutomation extends Model {

	void setCellState(Coords coords,State state);

	void setCellState(Coords coords);

	State getCellState(Coords coords);
	void next();

	List<Coords> toArrayOfState(State state);
	
	boolean hasChanged();
	void notifyObservers(Object arg);

}

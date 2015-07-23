package com.msus.GameOfLifeTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.msus.GameOfLifeController.GameOfLifeController;
import com.msus.GameOfLifeModel.CellulatAutomation;
import com.msus.GameOfLifeModel.Coords;
import com.msus.GameOfLifeModel.GameOfLife;
import com.msus.GameOfLifeModel.State;

public class GameOfLifeTest {

	@Test
	public void shouldReturnEmptyBoardWhenEmptyInput() {
		List<Coords> expected = new ArrayList<Coords>();
		CellulatAutomation gol = new GameOfLife(3, 3);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturnEmptyWhen000_010_000() {
		List<Coords> expected = new ArrayList<Coords>();
		CellulatAutomation gol = new GameOfLife(3, 3);
		gol.setCellState(new Coords(1, 1), State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturnEmptyWhen000_011_000() {
		List<Coords> expected = new ArrayList<Coords>();
		CellulatAutomation gol = new GameOfLife(3, 3);
		gol.setCellState(new Coords(1, 1), State.ALIVE);
		gol.setCellState(new Coords(1, 2), State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturn000_011_011When000_011_011() {
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(1, 1));
		expected.add(new Coords(1, 2));
		expected.add(new Coords(2, 1));
		expected.add(new Coords(2, 2));
		CellulatAutomation gol = new GameOfLife(3, 3);
		for (Coords cell : expected)
			gol.setCellState(cell, State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturn110_101_010When110_101_010() {
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(0, 0));
		expected.add(new Coords(0, 1));
		expected.add(new Coords(1, 0));
		expected.add(new Coords(1, 2));
		expected.add(new Coords(2, 1));
		CellulatAutomation gol = new GameOfLife(4, 4);
		for (Coords cell : expected)
			gol.setCellState(cell, State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturn1100_1000_0001_0011When1100_1100_0011_0011() {
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(0, 0));
		expected.add(new Coords(0, 1));
		expected.add(new Coords(1, 0));
		expected.add(new Coords(2, 3));
		expected.add(new Coords(3, 2));
		expected.add(new Coords(3, 3));
		CellulatAutomation gol = new GameOfLife(4, 4);
		gol.setCellState(new Coords(0, 0), State.ALIVE);
		gol.setCellState(new Coords(0, 1), State.ALIVE);
		gol.setCellState(new Coords(1, 0), State.ALIVE);
		gol.setCellState(new Coords(1, 1), State.ALIVE);
		gol.setCellState(new Coords(2, 2), State.ALIVE);
		gol.setCellState(new Coords(2, 3), State.ALIVE);
		gol.setCellState(new Coords(3, 2), State.ALIVE);
		gol.setCellState(new Coords(3, 3), State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturn1100_1100_0011_0011When1100_1000_0001_0011() {
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(0, 0));
		expected.add(new Coords(0, 1));
		expected.add(new Coords(1, 0));
		expected.add(new Coords(1, 1));
		expected.add(new Coords(2, 2));
		expected.add(new Coords(2, 3));
		expected.add(new Coords(3, 2));
		expected.add(new Coords(3, 3));
		CellulatAutomation gol = new GameOfLife(4, 4);
		gol.setCellState(new Coords(0, 0), State.ALIVE);
		gol.setCellState(new Coords(0, 1), State.ALIVE);
		gol.setCellState(new Coords(1, 0), State.ALIVE);
		gol.setCellState(new Coords(2, 3), State.ALIVE);
		gol.setCellState(new Coords(3, 2), State.ALIVE);
		gol.setCellState(new Coords(3, 3), State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldReturn000_111_000When010_010_010() {
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(1, 0));
		expected.add(new Coords(1, 1));
		expected.add(new Coords(1, 2));
		CellulatAutomation gol = new GameOfLife(3, 3);
		gol.setCellState(new Coords(0, 1), State.ALIVE);
		gol.setCellState(new Coords(1, 1), State.ALIVE);
		gol.setCellState(new Coords(2, 1), State.ALIVE);
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldMoveGlider2MovesForward() {
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(2, 0));
		expected.add(new Coords(3, 1));
		expected.add(new Coords(3, 2));
		expected.add(new Coords(2, 2));
		expected.add(new Coords(1, 2));
		CellulatAutomation gol = new GameOfLife(10, 10);
		gol.setCellState(new Coords(0, 1), State.ALIVE);
		gol.setCellState(new Coords(1, 2), State.ALIVE);
		gol.setCellState(new Coords(2, 0), State.ALIVE);
		gol.setCellState(new Coords(2, 1), State.ALIVE);
		gol.setCellState(new Coords(2, 2), State.ALIVE);
		gol.next();
		gol.next();
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	@Test
	public void shouldFinishAfter32Moves() {
		// given 
		GameOfLife gol = new GameOfLife(10, 10);
		gol.setCellState(new Coords(0, 1), State.ALIVE);
		gol.setCellState(new Coords(1, 2), State.ALIVE);
		gol.setCellState(new Coords(2, 0), State.ALIVE);
		gol.setCellState(new Coords(2, 1), State.ALIVE);
		gol.setCellState(new Coords(2, 2), State.ALIVE);
//		GOLConsoleView console = new GOLConsoleView(10, 10);
//		console.setModel(gol);
//		gol.addObserver(console);
		// expected
		List<Coords> expected = new ArrayList<Coords>();
		expected.add(new Coords(9, 9));
		expected.add(new Coords(9, 8));
		expected.add(new Coords(8, 9));
		expected.add(new Coords(8, 8));
		// when
		int i = 0;
		while (i<32) {
			gol.next();
			i++;
		}
		List<Coords> result = gol.toArrayOfState(State.ALIVE);
		assertTrue(expected.containsAll(result) && result.containsAll(expected));
	}

	// @Test
	// public void shouldRunSwingView() {
	// GameOfLife gol = new GameOfLife(30, 40);
	// gol.setCellState(new Coords( 0, 1 ), State.ALIVE);
	// gol.setCellState(new Coords( 1, 2 ), State.ALIVE);
	// gol.setCellState(new Coords( 2, 0 ), State.ALIVE);
	// gol.setCellState(new Coords( 2, 1 ), State.ALIVE);
	// gol.setCellState(new Coords( 2, 2 ), State.ALIVE);
	// View swingView = new GOLSwingView(30,40);
	// GameOfLifeController control = new GameOfLifeController(gol,swingView);
	// control.setSpeed(30);
	// }

	// @Test
	// public void shouldRunSwingWithFixedParameters() {
	// int a = 103;
	// int b = 100;
	// System.out.println( (a%b+b)%b);
	// a = -3;
	// System.out.println( (a%b+b)%b);
	// System.out.println("Fixed.1");
	// GOLSwingView.CELL_SIZE=12;
	// GameOfLifeController control = new GameOfLifeController(10,10);
	//// GameOfLifeController control = new GameOfLifeController(170,280);
	// System.out.println("Fixed.2");
	// control.setSpeed(30);
	// System.out.println("Fixed.3");
	// }
	//
	 @Test
	 public void shouldRunSwingWithFixedParameters() {
	 GameOfLifeController control = new GameOfLifeController();
	// GameOfLifeController control = new GameOfLifeController(170,280);
	 control.setSpeed(30);
	 }

}

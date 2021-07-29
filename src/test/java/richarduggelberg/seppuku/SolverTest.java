package richarduggelberg.seppuku;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.ArrayList;

public class SolverTest {
	
	@Test
	public void solve_simpleTask1_isCorrectTrue() {
    	Board b = new Board(4);
    	int[] row1 = {1,0,3,4};
    	int[] row2 = {3,4,1,2};
    	int[] row3 = {2,3,4,1};
    	int[] row4 = {4,1,2,3};
    	b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);

    	Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
	}

	
	@Test
	public void solve_simpleTask2_isCorrectTrue() {
    	Board b = new Board(4);
    	int[] row1 = {0,2,3,4};
    	int[] row2 = {3,4,0,2};
    	int[] row3 = {2,3,4,1};
    	int[] row4 = {4,1,2,3};
    	b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);

    	Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
	}

	@Test
	public void solve_simpleTask3_isCorrectTrue() {
    	Board b = new Board(4);
    	int[] row1 = {0,0,3,4};
    	int[] row2 = {0,0,1,2};
    	int[] row3 = {2,3,4,1};
    	int[] row4 = {4,1,2,3};
    	b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);

    	Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
	}

	@Test
	public void solve_simpleTask4_isCorrectTrue() {
    	Board b = new Board(4);
    	int[] row1 = {1,0,3,4};
    	int[] row2 = {0,0,1,2};
    	int[] row3 = {2,3,0,1};
    	int[] row4 = {4,1,2,3};
    	b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);

    	Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
	}

	@Test
	public void solve_ALittleHarderTask1_isCorrectTrue() {
    	Board b = new Board(4);
    	int[] row1 = {1,0,3,4};
    	int[] row2 = {0,0,1,0};
    	int[] row3 = {2,3,0,1};
    	int[] row4 = {4,1,2,0};
    	b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);

    	Solver s = new Solver(b);
    	s.solve();
    	s.printPossibleValues();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
	}
}
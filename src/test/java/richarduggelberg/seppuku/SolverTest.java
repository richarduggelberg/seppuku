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
    public void solve_9x9task1_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,2,3,4,5,6,7,8,9};
        int[] row2 = {4,5,6,7,8,9,1,2,3};
        int[] row3 = {7,8,9,1,2,3,4,5,6};

        int[] row4 = {2,3,1,5,6,4,8,9,7};
        int[] row5 = {5,6,4,8,9,7,2,3,1};
        int[] row6 = {8,9,7,2,3,1,5,6,4};

        int[] row7 = {3,1,2,6,4,5,9,7,8};
        int[] row8 = {6,4,5,9,7,8,3,1,2};
        int[] row9 = {9,7,8,3,1,2,6,4,5};

        b.setRow(1, row1);
        b.setRow(2, row2);
        b.setRow(3, row3);
        b.setRow(4, row4);
        b.setRow(5, row5);
        b.setRow(6, row6);
        b.setRow(7, row7);
        b.setRow(8, row8);
        b.setRow(9, row9);

        Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
    }

    @Test
    public void solve_9x9task2_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,2,3,4,5,6,7,8,9};
        int[] row2 = {4,5,6,7,8,9,1,2,3};
        int[] row3 = {7,8,9,0,2,3,4,5,6};

        int[] row4 = {2,3,1,5,6,4,8,9,7};
        int[] row5 = {5,6,4,8,9,7,2,3,1};
        int[] row6 = {8,9,7,2,3,1,5,6,4};

        int[] row7 = {3,1,2,6,4,5,9,7,8};
        int[] row8 = {6,4,5,9,7,8,3,1,2};
        int[] row9 = {9,7,8,3,1,2,6,4,5};

        b.setRow(1, row1);
        b.setRow(2, row2);
        b.setRow(3, row3);
        b.setRow(4, row4);
        b.setRow(5, row5);
        b.setRow(6, row6);
        b.setRow(7, row7);
        b.setRow(8, row8);
        b.setRow(9, row9);

        Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
    }
}
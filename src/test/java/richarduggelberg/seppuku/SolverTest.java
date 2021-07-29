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

    @Test
    public void solve_9x9task3_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,2,3,4,5,6,7,8,9};
        int[] row2 = {4,5,6,7,8,9,1,2,3};
        int[] row3 = {7,8,9,0,2,3,4,5,6};

        int[] row4 = {2,3,1,5,6,4,8,9,7};
        int[] row5 = {5,6,4,8,9,7,2,3,1};
        int[] row6 = {8,9,7,2,3,1,5,6,4};

        int[] row7 = {3,1,2,6,4,5,9,7,8};
        int[] row8 = {6,4,5,9,7,8,0,1,2};
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
    public void solve_9x9task4_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,0,0,4,5,6,7,8,9};
        int[] row2 = {0,0,0,7,8,9,1,2,3};
        int[] row3 = {0,0,0,1,2,3,4,5,6};

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
    public void solve_9x9task5_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,0,0,0,0,0,0,0,0};
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
    public void solve_9x9task6_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,0,0,0,0,0,0,0,0};
        int[] row2 = {0,5,6,7,8,9,1,2,3};
        int[] row3 = {0,8,9,1,2,3,4,5,6};

        int[] row4 = {0,3,1,5,6,4,8,9,7};
        int[] row5 = {0,6,4,8,9,7,2,3,1};
        int[] row6 = {0,9,7,2,3,1,5,6,4};

        int[] row7 = {0,1,2,6,4,5,9,7,8};
        int[] row8 = {0,4,5,9,7,8,3,1,2};
        int[] row9 = {0,7,8,3,1,2,6,4,5};

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
    public void solve_9x9task7_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,0,0,0,0,0,0,0,0};
        int[] row2 = {0,0,6,7,8,9,1,2,3};
        int[] row3 = {0,8,0,1,2,3,4,5,6};

        int[] row4 = {0,3,1,0,6,4,8,9,7};
        int[] row5 = {0,6,4,8,0,7,2,3,1};
        int[] row6 = {0,9,7,2,3,0,5,6,4};

        int[] row7 = {0,1,2,6,4,5,0,7,8};
        int[] row8 = {0,4,5,9,7,8,3,0,2};
        int[] row9 = {0,7,8,3,1,2,6,4,5};

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
    public void solve_9x9FromOnlineEasy1_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {0,4,0, 0,3,0, 0,0,9};
        int[] row2 = {9,8,5, 1,0,2, 0,0,4};
        int[] row3 = {3,0,0, 4,7,9, 6,8,0};

        int[] row4 = {0,0,9, 0,8,7, 0,4,2};
        int[] row5 = {2,0,0, 0,0,0, 0,6,8};
        int[] row6 = {8,3,6, 0,5,0, 0,9,7};

        int[] row7 = {0,0,0, 0,2,0, 8,0,0};
        int[] row8 = {7,1,0, 3,0,5, 0,0,0};
        int[] row9 = {0,6,0, 0,0,1, 4,0,0};

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
    public void solve_9x9FromOnlineEasy2_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {3,0,4, 0,7,0, 0,0,0};
        int[] row2 = {2,7,0, 0,0,0, 1,4,0};
        int[] row3 = {0,0,0, 9,0,0, 0,0,3};

        int[] row4 = {0,1,0, 0,9,6, 0,0,0};
        int[] row5 = {8,9,2, 0,5,3, 4,0,7};
        int[] row6 = {4,0,6, 0,8,7, 5,9,1};

        int[] row7 = {0,0,0, 8,1,0, 6,0,4};
        int[] row8 = {0,0,8, 7,0,0, 9,3,0};
        int[] row9 = {0,2,0, 0,4,0, 0,0,0};

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
    public void solve_9x9FromOnlineEasy3_isCorrectTrue() {
        Board b = new Board(9);
        int[] row1 = {4,0,0, 8,5,0, 0,0,3};
        int[] row2 = {0,0,0, 0,3,4, 0,0,0};
        int[] row3 = {6,8,3, 0,0,9, 0,5,4};

        int[] row4 = {0,4,0, 0,0,0, 7,2,0};
        int[] row5 = {0,0,6, 3,4,0, 0,9,0};
        int[] row6 = {0,0,1, 6,0,2, 0,0,5};

        int[] row7 = {0,0,0, 0,6,8, 4,0,9};
        int[] row8 = {0,0,8, 0,0,3, 1,0,2};
        int[] row9 = {7,0,4, 0,2,1, 5,3,8};

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
    public void solve_16x16easyTask1_isCorrectTrue() {

        Board b = new Board(16);

        int[] row1  = { 0, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12, 13,14,15,16};
        int[] row2  = { 5, 6, 7, 8,  9,10,11,12, 13,14,15,16,  1, 2, 3, 4};
        int[] row3  = { 9,10,11,12, 13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8};
        int[] row4  = {13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12};

        int[] row5  = { 2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13, 14,15,16, 1};
        int[] row6  = { 6, 7, 8, 9, 10,11,12,13, 14,15,16, 1,  2, 3, 4, 5};
        int[] row7  = {10,11,12,13, 14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9};
        int[] row8  = {14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13}; 

        int[] row9  = { 3, 4, 5, 6,  7, 8, 9,10, 11,12,13,14, 15,16, 1, 2};
        int[] row10 = { 7, 8, 9,10, 11,12,13,14, 15,16, 1, 2,  3, 4, 5, 6};
        int[] row11 = {11,12,13,14, 15,16, 1, 2,  3, 4, 5, 6,  7, 8, 9,10};
        int[] row12 = {15,16, 1, 2,  3, 4, 5, 6,  7, 8, 9,10, 11,12,13,14};

        int[] row13 = { 4, 5, 6, 7,  8, 9,10,11, 12,13,14,15, 16, 1, 2, 3};
        int[] row14 = { 8, 9,10,11, 12,13,14,15, 16, 1, 2, 3,  4, 5, 6, 7};
        int[] row15 = {12,13,14,15, 16, 1, 2, 3,  4, 5, 6, 7,  8, 9,10,11};
        int[] row16 = {16, 1, 2, 3,  4, 5, 6, 7,  8, 9,10,11, 12,13,14,15};


        b.setRow(1,  row1);
        b.setRow(2,  row2);
        b.setRow(3,  row3);
        b.setRow(4,  row4);
        b.setRow(5,  row5);
        b.setRow(6,  row6);
        b.setRow(7,  row7);
        b.setRow(8,  row8);
        b.setRow(9,  row9);
        b.setRow(10, row10);
        b.setRow(11, row11);
        b.setRow(12, row12);
        b.setRow(13, row13);
        b.setRow(14, row14);
        b.setRow(15, row15);
        b.setRow(16, row16);

        Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
    }

    @Test
    public void solve_16x16easyTask2_isCorrectTrue() {

        Board b = new Board(16);

        int[] row1  = { 0, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12, 13,14,15,16};
        int[] row2  = { 5, 6, 7, 8,  9,10,11,12, 13,14,15,16,  1, 2, 3, 4};
        int[] row3  = { 9,10,11,12, 13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8};
        int[] row4  = {13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12};

        int[] row5  = { 2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13, 14,15,16, 1};
        int[] row6  = { 6, 7, 8, 9, 10,11,12,13, 14,15,16, 1,  2, 3, 4, 5};
        int[] row7  = {10,11,12,13, 14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9};
        int[] row8  = {14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13}; 

        int[] row9  = { 3, 4, 0, 6,  7, 8, 9,10, 11,12,13,14, 15,16, 1, 2};
        int[] row10 = { 7, 8, 9,10, 11,12,13,14, 15,16, 1, 2,  3, 4, 5, 6};
        int[] row11 = {11,12,13,14, 15,16, 1, 2,  3, 4, 5, 6,  7, 8, 9,10};
        int[] row12 = {15,16, 1, 2,  3, 4, 5, 6,  7, 8, 9,10, 11,12,13,14};

        int[] row13 = { 4, 5, 6, 7,  8, 9,10,11, 12,13,14,15, 16, 1, 2, 3};
        int[] row14 = { 8, 9,10,11, 12,13,14,15, 16, 1, 2, 3,  4, 5, 6, 7};
        int[] row15 = {12,13,14,15, 16, 1, 2, 3,  4, 5, 6, 7,  8, 9,10,11};
        int[] row16 = {16, 1, 2, 3,  4, 5, 6, 7,  8, 9,10,11, 12,13,14,15};


        b.setRow(1,  row1);
        b.setRow(2,  row2);
        b.setRow(3,  row3);
        b.setRow(4,  row4);
        b.setRow(5,  row5);
        b.setRow(6,  row6);
        b.setRow(7,  row7);
        b.setRow(8,  row8);
        b.setRow(9,  row9);
        b.setRow(10, row10);
        b.setRow(11, row11);
        b.setRow(12, row12);
        b.setRow(13, row13);
        b.setRow(14, row14);
        b.setRow(15, row15);
        b.setRow(16, row16);

        Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
    }

    @Test
    public void solve_16x16easyTask3_isCorrectTrue() {

        Board b = new Board(16);

        int[] row1  = { 0, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12, 13,14,15,16};
        int[] row2  = { 5, 6, 7, 8,  9,10,11,12, 13,14,15,16,  1, 2, 3, 4};
        int[] row3  = { 9,10,11,12, 13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8};
        int[] row4  = {13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12};

        int[] row5  = { 2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13, 14,15,16, 1};
        int[] row6  = { 6, 7, 8, 9, 10,11,12,13, 14,15, 0, 1,  2, 3, 4, 5};
        int[] row7  = {10,11,12,13, 14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9};
        int[] row8  = {14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13}; 

        int[] row9  = { 3, 4, 5, 6,  7, 0, 9,10, 11,12,13,14, 15,16, 1, 2};
        int[] row10 = { 7, 8, 9,10, 11,12,13,14, 15,16, 1, 2,  3, 4, 5, 6};
        int[] row11 = {11,12,13,14, 15,16, 1, 2,  3, 4, 5, 6,  7, 8, 9,10};
        int[] row12 = {15,16, 1, 2,  3, 4, 5, 6,  7, 8, 9,10, 11,12,13,14};

        int[] row13 = { 4, 5, 6, 7,  8, 9,10,11, 12,13,14,15, 16, 1, 2, 3};
        int[] row14 = { 8, 9,10,11, 12,13,14,15, 16, 1, 2, 3,  4, 5, 6, 7};
        int[] row15 = {12,13,14,15, 16, 1, 2, 3,  4, 5, 0, 7,  8, 9,10,11};
        int[] row16 = {16, 1, 2, 3,  4, 5, 6, 7,  8, 9,10,11, 12,13,14,15};


        b.setRow(1,  row1);
        b.setRow(2,  row2);
        b.setRow(3,  row3);
        b.setRow(4,  row4);
        b.setRow(5,  row5);
        b.setRow(6,  row6);
        b.setRow(7,  row7);
        b.setRow(8,  row8);
        b.setRow(9,  row9);
        b.setRow(10, row10);
        b.setRow(11, row11);
        b.setRow(12, row12);
        b.setRow(13, row13);
        b.setRow(14, row14);
        b.setRow(15, row15);
        b.setRow(16, row16);

        Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
    }

     @Test
    public void solve_16x16easyTask4_isCorrectTrue() {

        Board b = new Board(16);

        int[] row1  = { 0, 0, 0, 0,  5, 6, 7, 8,  9,10,11,12, 13,14,15,16};
        int[] row2  = { 0, 0, 7, 0,  9,10,11,12, 13,14,15,16,  1, 2, 3, 4};
        int[] row3  = { 0, 0, 0, 0, 13,14,15,16,  1, 2, 3, 4,  5, 6, 7, 8};
        int[] row4  = { 0, 0, 0, 0,  1, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12};

        int[] row5  = { 2, 3, 4, 5,  0, 0, 0, 0,  0, 0, 0, 0,  0, 0,16, 1};
        int[] row6  = { 6, 7, 8, 9, 10,11,12,13, 14,15, 0, 1,  2, 3, 4, 5};
        int[] row7  = {10,11,12,13, 14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9};
        int[] row8  = {14,15,16, 1,  2, 3, 4, 5,  6, 7, 8, 9, 10,11,12,13}; 

        int[] row9  = { 3, 4, 5, 6,  7, 0, 9,10,  0,12,13,14, 15,16, 1, 2};
        int[] row10 = { 7, 8, 9,10, 11,12,13,14,  0,16, 1, 2,  3, 4, 5, 6};
        int[] row11 = {11,12,13,14, 15,16, 1, 2,  0, 4, 5, 6,  7, 8, 9,10};
        int[] row12 = {15,16, 1, 2,  3, 4, 5, 6,  0, 8, 9,10, 11,12,13,14};

        int[] row13 = { 4, 5, 6, 7,  8, 9,10,11,  0,13,14,15, 16, 1, 2, 3};
        int[] row14 = { 8, 9,10,11, 12,13,14,15,  0, 1, 2, 3,  4, 5, 6, 7};
        int[] row15 = {12,13,14,15, 16, 1, 2, 3,  0, 5, 0, 7,  8, 9,10,11};
        int[] row16 = {16, 1, 2, 3,  4, 5, 6, 7,  0, 9,10,11, 12,13,14,15};


        b.setRow(1,  row1);
        b.setRow(2,  row2);
        b.setRow(3,  row3);
        b.setRow(4,  row4);
        b.setRow(5,  row5);
        b.setRow(6,  row6);
        b.setRow(7,  row7);
        b.setRow(8,  row8);
        b.setRow(9,  row9);
        b.setRow(10, row10);
        b.setRow(11, row11);
        b.setRow(12, row12);
        b.setRow(13, row13);
        b.setRow(14, row14);
        b.setRow(15, row15);
        b.setRow(16, row16);

        Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
    }

}
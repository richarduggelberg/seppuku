package richarduggelberg.seppuku;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BoardTest {
    @Test
    public void isCorrect_validSolution_true() {
    	Board b = new Board(4);
    	int[] row1 = {1,2,3,4};
    	int[] row2 = {3,4,1,2};
    	int[] row3 = {2,3,4,1};
    	int[] row4 = {4,1,2,3};
    	b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);
        assertTrue(b.isCorrect());
    }

    @Test
    public void isCorrect_9x9validSolution_true() {
        Board b = new Board(9);
        int[] row1 = {1,2,3,4,5,6,7,8,9};
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

        assertTrue(b.isCorrect());
    }

    @Test
    public void isCorrect_16x16validSolution_true() {
        
        Board b = new Board(16);

        int[] row1  = { 1, 2, 3, 4,  5, 6, 7, 8,  9,10,11,12, 13,14,15,16};
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
    public void isCorrect_9x9invalidSolution1_false() {
        Board b = new Board(9);
        int[] row1 = {2,2,3,4,5,6,7,8,9};
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

        assertFalse(b.isCorrect());
    }

    @Test
    public void isCorrect_9x9invalidSolution2_false() {
        Board b = new Board(9);
        int[] row1 = {1,2,3,4,5,6,7,8,9};
        int[] row2 = {1,5,6,7,8,9,1,2,3};
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

        assertFalse(b.isCorrect());
    }

    @Test
    public void isCorrect_9x9invalidSolution3_false() {
        Board b = new Board(9);
        int[] row1 = {1,2,3,4,5,6,7,8,9};
        int[] row2 = {4,5,6,7,8,9,1,2,3};
        int[] row3 = {7,8,9,1,2,3,4,5,6};

        int[] row4 = {2,3,1,5,6,4,8,9,7};
        int[] row5 = {5,6,4,8,1,7,2,3,1};
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

        assertFalse(b.isCorrect());
    }



    @Test
    public void isCorrect_invalidSolution1_false() {
        Board b = new Board(4);
        int[] row1 = {1,2,3,4};
        int[] row2 = {3,4,1,2};
        int[] row3 = {2,3,4,1};
        int[] row4 = {4,2,1,3};
        b.setRow(1, row1);
        b.setRow(2, row2);
        b.setRow(3, row3);
        b.setRow(4, row4);
        assertFalse(b.isCorrect());
    }

    @Test
    public void isCorrect_invalidSolution2_false() {
        Board b = new Board(4);
        int[] row1 = {1,2,3,4};
        int[] row2 = {3,4,1,2};
        int[] row3 = {2,3,4,1};
        int[] row4 = {4,1,2,5};
        b.setRow(1, row1);
        b.setRow(2, row2);
        b.setRow(3, row3);
        b.setRow(4, row4);
        assertFalse(b.isCorrect());
    }

    @Test
    public void containsError_validSet1_false() {
        Board b = new Board(4);
        int[] testSet = {1,2,3,4};
        assertFalse(b.containsError(testSet));
    }

    @Test
    public void containsError_validSet2_false() {
        Board b = new Board(4);
        int[] testSet = {4,2,3,1};
        assertFalse(b.containsError(testSet));
    }

    @Test
    public void containsError_containsDuplicate_true() {
        Board b = new Board(4);
        int[] testSet = {1,1,2,3};
        assertTrue(b.containsError(testSet));
    }

    @Test
    public void containsError_containsValueTooHigh_true() {
        Board b = new Board(4);
        int[] testSet = {1,5,2,4};
        assertTrue(b.containsError(testSet));
    }

    @Test
    public void containsError_containsValueTooLow_true() {
        Board b = new Board(4);
        int[] testSet = {1,3,2,0};
        assertTrue(b.containsError(testSet));
    }

    @Test
    public void containsError_setTooBig_true() {
        Board b = new Board(4);
        int[] testSet = {1,2,3,4,5};
        assertTrue(b.containsError(testSet));
    }
}

package richarduggelberg.seppuku;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BoardTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void isCorrect_validSolution_true()
    {
    	int size = 4;
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
    public void isCorrect_invalidSolution1_false()
    {
        int size = 4;
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
    public void isCorrect_invalidSolution2_false()
    {
        int size = 4;
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

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
}

package richarduggelberg.seppuku;

import org.junit.runner.RunWith;
import net.jqwik.api.*;
import net.jqwik.api.constraints.*;
import java.util.List;
import java.util.*;
import java.util.stream.*;

import static org.hamcrest.Matchers.*;

import static org.junit.Assume.*;

import static org.junit.Assert.*;

public class PropertiesTest {
	@Property
	void containsErrorFalse(
		@ForAll("containsErrorFalseGenerator") int[] arr)
	{
		Board b = new Board(4);
		assertFalse(b.containsError(arr));
	}

	@Provide
	public Arbitrary<int[]> containsErrorFalseGenerator() {
		return Arbitraries
		.of(1,2,3,4)
		.array(int[].class)
		.ofSize(4)
		.uniqueElements();
	}

	@Property
	void containsErrorTrue(
		@ForAll("containsErrorTrueGenerator") int[] arr) 
	{
		Board b = new Board(4);
		assertTrue(b.containsError(arr));
	}

	@Provide
	Arbitrary<int[]> containsErrorTrueGenerator() {
	    return Arbitraries
	    .of(0,1,2,3,4,5)
	    .array(int[].class)
	    .ofMinSize(4)
	    .ofMaxSize(5)
        .filter(a -> !(containsErrorFalseGenerator().allValues().get().anyMatch(b -> (Arrays.equals(a,b)))));
	}

	@Property
	void solve_isCorrect_true(
		@ForAll("validRow1Generator") int[] row1,
		@ForAll("validRow2Generator") int[] row2,
		@ForAll("validRow3Generator") int[] row3,
		@ForAll("validRow4Generator") int[] row4)
	{
		Board b = new Board(4);
		b.setRow(1, row1);
    	b.setRow(2, row2);
    	b.setRow(3, row3);
    	b.setRow(4, row4);

    	Solver s = new Solver(b);
    	s.solve();
    	Board solved = s.getSolved();
        assertTrue(solved.isCorrect());
	}

	@Provide
	Arbitrary<int[]> validRow1Generator() {
		return Arbitraries
		.of(0,1,2,3,4)
		.array(int[].class)
		.ofSize(4)
		.uniqueElements();
	}

	@Provide
	Arbitrary<int[]> validRow2Generator() {
		return Arbitraries
		.of(0,1,2,3,4)
		.array(int[].class)
		.ofSize(4)
		.uniqueElements();
	}

	@Provide
	Arbitrary<int[]> validRow3Generator() {
		return Arbitraries
		.of(0,1,2,3,4)
		.array(int[].class)
		.ofSize(4)
		.uniqueElements();
	}

	@Provide
	Arbitrary<int[]> validRow4Generator() {
		return Arbitraries
		.of(0,1,2,3,4)
		.array(int[].class)
		.ofSize(4)
		.uniqueElements();
	}
}

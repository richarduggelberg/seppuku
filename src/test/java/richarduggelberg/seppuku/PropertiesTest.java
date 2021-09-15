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
		@ForAll("containsErrorFalseSetGenerator") int[] set,
		@ForAll("containsErrorFalseSizeGenerator") int size)
	{
		Assume.that(size == set.length);
		Board b = new Board(size);
		assertFalse(b.containsError(set));
	}

	@Provide
	public Arbitrary<int[]> containsErrorFalseSetGenerator() {
		return Arbitraries
		.of(1,2,3,4)
		.array(int[].class)
		.ofSize(4)
		.uniqueElements();
	}

	@Provide
	public Arbitrary<Integer> containsErrorFalseSizeGenerator() {
		return Arbitraries
		.of(4);
	}

	@Property
	void containsErrorTrue(
		@ForAll("containsErrorTrueSetGenerator") int[] set,
		@ForAll("containsErrorTrueSizeGenerator") int size) 
	{
		Board b = new Board(size);
		assertTrue(b.containsError(set));
	}

	@Provide
	Arbitrary<int[]> containsErrorTrueSetGenerator() {
	    return Arbitraries
	    .of(0,1,2,3,4,5)
	    .array(int[].class)
	    .ofMinSize(4)
	    .ofMaxSize(5)
        .filter(a -> !(containsErrorFalseSetGenerator().allValues().get().anyMatch(b -> (Arrays.equals(a,b)))));
	}

	@Provide
	public Arbitrary<Integer> containsErrorTrueSizeGenerator() {
		return Arbitraries
		.of(4);
	}
}

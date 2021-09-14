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
}

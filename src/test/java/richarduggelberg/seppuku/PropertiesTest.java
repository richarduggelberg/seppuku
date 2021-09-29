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
	/*@Property
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
	}*/

	@Property (tries = 1000)
	public void containsErrorFalse(
		@ForAll("widths") int width,
		@ForAll("boxRowCol_false") int[] boxRowCol) 
	{	
		Assume.that(width == boxRowCol.length);
		Board board = new Board(width);
		assertFalse(board.containsError(boxRowCol));
	}

	@Provide
	public Arbitrary<Integer> widths() {
		return Arbitraries
		.of(4,9,16);
	}

	
	
	
	
	
	
	
	
	@Provide
	public Arbitrary<int[]> boxRowCol_false(
		//(return == false)  ==>  (this.width one of { 4, 9, 16 })
		@ForAll("widths") int width) 
	{
		//(return == false)  ==>  (this.boxWidth one of { 2, 3, 4 })
		//(return == false)  ==>  (orig(size(boxRowCol[])) % this.boxWidth == 0)
		//(return == false)  ==>  (orig(size(boxRowCol[])) == this.boxWidth**2)
		int boxWidth = (int) Math.sqrt(width);
		return Arbitraries
		.integers()
		//(return == false)  ==>  (boxRowCol[] elements <= orig(size(boxRowCol[])))
		//(return == false)  ==>  (boxRowCol[] elements <= this.width)
		//(return == false)  ==>  (boxRowCol[] elements >= 1)
		.between(1, width)
		.array(int[].class)
		//(return == false)  ==>  (orig(size(boxRowCol[])) one of { 4, 9, 16 })
		//(return == false)  ==>  (this.width == orig(size(boxRowCol[])))
		.ofSize(width)
		//(return == false)  ==>  (orig(size(boxRowCol[])) >= boxRowCol[this.boxWidth-1])
		.filter(a -> a[boxWidth-1] <= a.length)
		//(return == false)  ==>  (orig(size(boxRowCol[])) >= boxRowCol[this.width-1])
		.filter(a -> a[width-1] <= a.length)
		//(return == false)  ==>  (orig(size(boxRowCol[])) in boxRowCol[])
		.filter(a -> Arrays.asList(a).contains(a.length))
		//(return == false)  ==>  (size(boxRowCol[])-1 in boxRowCol[])
		//(return == false)  ==>  (size(this.board[])-1 in boxRowCol[])
		.filter(a -> Arrays.asList(a).contains(a.length-1))
		//(return == false)  ==>  (this.width >= boxRowCol[this.boxWidth-1])
		.filter(a -> a.length <= width)
		//(return == false)  ==>  (this.width >= boxRowCol[this.width-1])
		.filter(a -> a[width-1] <= width)
		//(return == false)  ==>  (this.width in boxRowCol[])
		.filter(a -> Arrays.asList(a).contains(width))
		;	
	}

	/*@Property
	public void containsErrorTrue() {
		
	}

	//(return == true)  ==>  (orig(size(boxRowCol[])) one of { 4, 5, 9 })
	//(return == true)  ==>  (this.boxWidth one of { 2, 3 })
	//(return == true)  ==>  (this.width one of { 4, 9 })
	@Provide
	public Arbitrary<int[]> boxRowCol_true() {
		
	}*/

}

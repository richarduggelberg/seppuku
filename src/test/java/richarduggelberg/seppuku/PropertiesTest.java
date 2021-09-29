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
		//.filter(a -> Arrays.asList(a).contains(a.length))

		//(return == false)  ==>  (size(boxRowCol[])-1 in boxRowCol[])
		//(return == false)  ==>  (size(this.board[])-1 in boxRowCol[])
		//.filter(a -> Arrays.asList(a).contains(a.length-1))

		//(return == false)  ==>  (this.width >= boxRowCol[this.boxWidth-1])
		.filter(a -> a[boxWidth-1] <= width)

		//(return == false)  ==>  (this.width >= boxRowCol[this.width-1])
		.filter(a -> a[width-1] <= width)

		//(return == false)  ==>  (this.width in boxRowCol[])
		//.filter(a -> Arrays.asList(a).contains(width))

		//boxRowCol[this.boxWidth] >= 1
		.filter(a -> a[boxWidth] >= 1)

		//boxRowCol[this.boxWidth-1] >= 1
		.filter(a -> a[boxWidth-1] >= 1)

		//this.width >= size(boxRowCol[])-1
		.filter(a -> a.length <= width)

		//this.boxWidth in boxRowCol[]
		//.filter(a -> Arrays.asList(a).contains(boxWidth))

		//this.boxWidth < size(boxRowCol[])-1
		.filter(a -> boxWidth < a.length - 1)

		//size(this.board[])-1 <= size(boxRowCol[])-1

		//orig(size(boxRowCol[])) >= boxRowCol[this.boxWidth]
		.filter(a -> a.length >= a[boxWidth])

		//boxRowCol[this.width-1] != boxRowCol[this.boxWidth]
		.filter(a -> a[width-1] != a[boxWidth])

		//boxRowCol[this.width-1] != boxRowCol[this.boxWidth-1]
		.filter(a -> a[width-1] != a[boxWidth-1])

		//boxRowCol[this.boxWidth] != boxRowCol[this.boxWidth-1]
		.filter(a -> a[boxWidth] != a[boxWidth-1])
		;	
	}
}

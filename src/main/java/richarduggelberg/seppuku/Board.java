package richarduggelberg.seppuku;

/**
Board is the basis of the sudoku solver.
This class serves as the board (obviously) and checks if the board is correctly filled in.

@author richarduggelberg
@version 1.0
*/
public class Board {
	private int width;
	private int[][] board;
	private int boxWidth;


	/**
	Constructor of Board.
	Initializes an empty sudoku board. The values are added later.

	@param width of the board to be created. The board is a square and thus only one measurement i required.
	*/
	public Board(int width) {
		this.width = width;

		//Stored as its own variable for easier use.
		this.boxWidth = (int) Math.round(Math.sqrt(width));

		//initialize the board with zeroes.
		//As zero is never within the valid range of numbers it is used as a place holder.
		//Any number outside the valid range could be used though.
		board = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = 0;
			}
		}
	}

	/**
	@return the width (or side length) of the board.
	*/
	public int getWidth() {
		return width;
	}

	/**
	@return the width of the boxes in the board (this is the square root of the board width).
	*/
	public int getBoxWidth() {
		return boxWidth;
	}

	/**
	Returns the value of a specific square of the board.

	@param i the row number
	@param j the column number

	@return the value at row i and column j of the board
	*/
	public int getValue(int i, int j) {
		return board[i][j];
	}

	/**
	@param i the row number
	@param j the column number
	@param value the value to be put into the square of the board specified by the row and column numbers.
	*/
	public void setValue(int i, int j, int value) {
		board[i][j] = value;
	}

	/**
	@param rowNumber the row to be replaced in its entirety.
	@param values the array of values that will replace the current row values.
	*/
	public void setRow(int rowNumber, int[] values) {
		for (int i = 0; i < width; i++) {
			board[rowNumber-1][i] = values[i];
		}
	}

	/**
	Calls methods that check boxes, rows and columns.
	@return true if and only if all those return true too.
	*/
	public boolean isCorrect() {
		boolean boxes = boxesCorrect();
		boolean rows = rowsCorrect();
		boolean columns = columnsCorrect();
		return boxes && rows && columns;
	}

	/**
	Returns the values of each box in the board as a 2D array.
	Important to note here is that each box is basically a 2D array with width boxWidth (which is sqrt(width)).
	To simplify the search process of the boxes their values are copied to 1D arrays of the board width.

	@return values of the boxes as 1D arrays.
	*/
	public int[][] getBoxes() {
		int[][] boxes = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {

				int boxRow = (int) Math.floor(i/boxWidth);
				int boxCol = (int) Math.floor(j/boxWidth);

				int boxPosi = i%boxWidth;
				int boxPosj = j%boxWidth;

				//Counted from left to right, top to bottom
				int boxNumber = boxWidth * boxRow + boxCol;

				//Same as boxNumber but for value within the box
				int boxPosition = boxWidth * boxPosi + boxPosj;

				boxes[boxNumber][boxPosition] = board[i][j];
			}
		}

		return boxes;
	}

	/**
	Checks the boxes for errors

	@return true if no errors are found
	*/
	public boolean boxesCorrect() {
		int[][] boxes = getBoxes();

		for (int i = 0; i < width; i++) {
			if (containsError(boxes[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	Returns the rows of the board as a list of arrays.
	These are unchanged in structure as they are already in an easily readable structure.

	@return 2D array of row values.
	*/
	public int[][] getRows() {
		int[][] rows = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				rows[i][j] = board[i][j];
			}
		}

		return rows;
	}

	/**
	Check the rows for errors

	@return true of no errors are found
	*/
	public boolean rowsCorrect() {
		int[][] rows = getRows();

		for (int i = 0; i < width; i++) {
			if (containsError(rows[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	Returns the columns of the board as a list of arrays
	The only change applied to these is the that row and column numbers are flipped.
	Thus, they can be checked for errors in the same way as the rows.

	@return 2D array of column values.
	*/
	public int[][] getColumns() {
		int[][] columns = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				columns[i][j] = board[j][i];
			}
		}
		return columns;
	}

	/**
	Check the columns for errors

	@return true if no errors are found
	*/
	public boolean columnsCorrect() {
		int[][] columns = getColumns();

		for (int i = 0; i < width; i++) {
			if (containsError(columns[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	Checks an array of errors.
	Sudoku errors are when a single row, column or box contain duplicates of a value or lacks a value.
	The rows, columns and boxes are "converted" to the same structure as rows and can thus be checked by this function in the same way.

	@param boxRowCol the values of a single box, row or column stored as an array.
	@return false if all values are found and no duplicates are found.
	*/
	public boolean containsError(int[] boxRowCol) {
		//All rows, columns and boxes must have the same number of elements as the width of the board.
		if (boxRowCol.length != width) {
			return true;
		}

		//All values must be within the valid range.
		for (int i = 0; i < width; i++) {
			if (boxRowCol[i] < 1 || boxRowCol[i] > width) {
				return true;
			}
		}

		//Check for duplicates
		for (int i = 0; i < width; i++) {
			for (int j = i + 1; j < width; j++) {
				if (boxRowCol[i] == boxRowCol[j]) {
					return true;
				}
			}
		}

		//Checks if all required values are present.
		boolean[] contains = new boolean[width];
		for (int i = 0; i < width; i++) {
			contains[i] = false;
		}
		for (int i = 0; i < width; i++) {
			contains[boxRowCol[i]-1] = true;
		}
		for (int i = 0; i < width; i++) {
			if (contains[i] == false) {
				return true;
			}
		}

		return false;
	}

	/**
	Prints the entire board.
	Used for debugging purposes.
	*/
	public void print() {
		for (int i = 0; i < width; i++) {
			String row = "";
			for (int j = 0; j < width; j++) {
				row += "" + board[i][j] + " ";
				if ((j+1)%boxWidth == 0) {
					row += " ";
				}
			}
			if ((i+1)%boxWidth == 0) {
				row += "\n";
			}
			System.out.println(row);
		}
	}
}




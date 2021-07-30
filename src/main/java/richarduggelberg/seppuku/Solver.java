package richarduggelberg.seppuku;

import java.util.ArrayList;

/**
The solver takes a Board as input and solves it, to the best of its abilities.

@author richarduggelberg
@version 1.0
*/
public class Solver {
	private Board b;
	private int width;
	//3D ArrayList of Integers
	//The first 2 dimensions represent the axes of the board
	//Then there is a list of possible values for each square.
	private ArrayList<ArrayList<ArrayList<Integer>>> possibleValues;

	/**
	Constructor of the solver.

	@param b the sudoku problem to be solved
	*/
	public Solver(Board b) {
		this.b = b;
		//width is stored in Solver too for easier use
		this.width = b.getWidth();
	}

	/**
	@return the 3D ArrayList of possible values for each square.
	*/
	public ArrayList<ArrayList<ArrayList<Integer>>> getPossibleValues() {
		return possibleValues;
	}

	/**
	Prints all the possible values of each square.
	Used for debugging purposes.
	*/
	public void printPossibleValues() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				System.out.printf(possibleValues.get(i).get(j) + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/**
	If a square can only be filled with a single value due to the values of its row, column and box
	it should be set to that value.

	@return true if there are no empty squares where only a single value is possible.
	*/
	public boolean allSinglesRemoved() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (possibleValues.get(i).get(j).size() == 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	Called to engage the core of the solver.
	Is run until the solver cannot solve the board any further or 100 times.
	100 is an arbitrary value and may cause errors for larger boards.
	*/
	public void solve() {
		for (int i = 0; i < 100; i++) {
			checkExisting();
			checkRows();
			checkColumns();
			checkBoxes();
			checkLackingRows();
			checkLackingColumns();
			checkSingles();
			if (allSinglesRemoved()) {
				break;
			}
		}
	}

	/**
	Puts the existing values of the board into the 3D ArrayList of possible values.
	*/
	public void checkExisting() {
		this.possibleValues = new ArrayList<ArrayList<ArrayList<Integer>>>();

		//Initialize an empty 3D ArrayList
		for (int i = 0; i < width; i++) {
    		possibleValues.add(new ArrayList<ArrayList<Integer>>(width));
    		for (int j = 0; j < width; j++) {
        		possibleValues.get(i).add(new ArrayList<Integer>(width));
        		for (int k = 0; k < width; k++) {
        			possibleValues.get(i).get(j).add(k+1);
        		}
   			}
		}

		//All squares with valid values cannot be set to any other value and thus there are no possible values.
		for (int i = 0; i < width; i++) {
    		for (int j = 0; j < width; j++) {
    			if(b.getValue(i,j) >= 1 && b.getValue(i,j) <= width) {
    				possibleValues.get(i).get(j).clear();
    			}
   			}
		}
	}

	/**
	If a valid value is found in a row
	another square in that row cannot contain that value
	Thus the value is removed from the possible values of all the squares in the row
	*/
	public void checkRows() {
		int[][] rows = b.getRows();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (rows[i][j] >= 1 && rows[i][j] <= width) {
					for (int k = 0; k < width; k++) {
						possibleValues.get(i).get(k).remove((Integer) rows[i][j]);
					}
				}
			}
		}
	}

	/**
	If a valid value is found in a column
	another square in that column cannot contain that value
	Thus the value is removed from the possible values of all the squares in the column
	*/
	public void checkColumns() {
		int[][] columns = b.getColumns();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (columns[i][j] >= 1 && columns[i][j] <= width) {
					for (int k = 0; k < width; k++) {
						possibleValues.get(k).get(i).remove((Integer) columns[i][j]);
					}
				}
			}
		}
	}

	/**
	If a valid value is found in a box
	another square in that box cannot contain that value
	Thus the value is removed from the possible values of all the squares in the box
	*/
	public void checkBoxes() {
		int[][] boxes = b.getBoxes();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (boxes[i][j] >= 1 && boxes[i][j] <= width) {
					for (int k = 0; k < width; k++) {
						int boxWidth = b.getBoxWidth();
						int boxRow = (int) Math.floor(i/boxWidth);
						int boxCol = (int) Math.floor(k/boxWidth);
						int boxPosi = i%boxWidth;
						int boxPosj = k%boxWidth;
						int boxNumber = boxWidth * boxRow + boxCol;
						int boxPosition = boxWidth * boxPosi + boxPosj;
						possibleValues.get(boxNumber).get(boxPosition).remove((Integer) boxes[i][j]);
					}
				}			
			}
		}
	}

	/**
	If a square is found to only be able to have one value
	the square is set to that value.
	*/
	public void checkSingles() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (possibleValues.get(i).get(j).size() == 1) {
					b.setValue(i,j,possibleValues.get(i).get(j).get(0));
				}
			}
		}
	}

	/**
	Checks if a row lacks at least one number

	@return true if at least one number is not present in a row.
	*/
	public boolean rowLacksNumber(int row, int number) {
		for (int i = 0; i < width; i++) {
			if (b.getValue(row, i) == number) {
				return false;
			}
		}
		return true;
	}

	/**
	@param row a row number
	@param number a number
	@return an ArrayList of indices where the number could potentially be set.
	*/
	public ArrayList<Integer> possiblePlacesInRow(int row, int number) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < width; i++) {
			if (possibleValues.get(row).get(i).contains(number)) {
				indices.add(i);
			}
		}
		return indices;
	}

	/**
	@param row
	@param number
	@return true if a number only has one possible spot in the row
	*/
	public boolean onlyOnePossiblePlaceInRow(int row, int number) {
		if (possiblePlacesInRow(row, number).size() == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	If a row lacks a number
	and that number can only possibly be stored in a single square in the row
	that square is set to that number
	*/
	public void checkLackingRows() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (rowLacksNumber(i,j) && onlyOnePossiblePlaceInRow(i,j)) {
					b.setValue(i,possiblePlacesInRow(i,j).get(0),j);
				}
			}
		} 
	}

	/**
	Checks if a column lacks at least one number

	@return true if at least one number is not present in a column.
	*/
	public boolean columnLacksNumber(int column, int number) {
		for (int i = 0; i < width; i++) {
			if (b.getValue(column, i) == number) {
				return false;
			}
		}
		return true;
	}

	/**
	@param column a column number
	@param number a number
	@return an ArrayList of indices where the number could potentially be set.
	*/
	public ArrayList<Integer> possiblePlacesInColumns(int column, int number) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < width; i++) {
			if (possibleValues.get(column).get(i).contains(number)) {
				indices.add(i);
			}
		}
		return indices;
	}

	/**
	@param column
	@param number
	@return true if a number only has one possible spot in the column
	*/
	public boolean onlyOnePossiblePlaceInColumn(int column, int number) {
		if (possiblePlacesInColumns(column, number).size() == 1) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	If a column lacks a number
	and that number can only possibly be stored in a single square in the column
	that square is set to that number
	*/
	public void checkLackingColumns() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (columnLacksNumber(i,j) && onlyOnePossiblePlaceInColumn(i,j)) {
					b.setValue(possiblePlacesInColumns(i,j).get(0),i,j);
				}
			}
		} 
	}

	/**
	Should be called after solve().

	@return the board
	*/ 
	public Board getSolved() {
		return b;
	}
}
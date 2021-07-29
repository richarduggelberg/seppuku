package richarduggelberg.seppuku;

import java.util.ArrayList;

public class Solver {
	private Board b;
	private int width;
	private ArrayList<ArrayList<ArrayList<Integer>>> possibleValues;

	public Solver(Board b) {
		this.b = b;
		this.width = b.getWidth();
	}

	public ArrayList<ArrayList<ArrayList<Integer>>> getPossibleValues() {
		return possibleValues;
	}

	public void printPossibleValues() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				System.out.printf(possibleValues.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}

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

	public void solve() {
		System.out.println("---------------------------------------------------------------------------------------");
		for (int i = 0; i < 100; i++) {
			checkExisting();
			checkRows();
			checkColumns();
			checkBoxes();
			checkSingles();
			printPossibleValues();
			if (allSinglesRemoved()) {
				break;
			}
		}
	}

	public void checkExisting() {
		this.possibleValues = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> allValues2 = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> allValues = new ArrayList<Integer>();
		ArrayList<Integer> noValues = new ArrayList<Integer>();

		for (int i = 0; i < width; i++) {
    		possibleValues.add(new ArrayList<ArrayList<Integer>>(width));
    		for (int j = 0; j < width; j++) {
        		possibleValues.get(i).add(new ArrayList<Integer>(width));
        		for (int k = 0; k < width; k++) {
        			possibleValues.get(i).get(j).add(k+1);
        		}
   			}
		}

		for (int i = 0; i < width; i++) {
    		for (int j = 0; j < width; j++) {
    			if(b.getValue(i,j) >= 1 && b.getValue(i,j) <= width) {
    				possibleValues.get(i).get(j).clear();
    			}
   			}
		}
	}

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

	public void checkBoxes() {
		int[][] boxes = b.getBoxes();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				for (int k = 0; k < width; k++) {
					if (boxes[i][k] >= 1 && boxes[i][k] <= width) {
						int boxWidth = b.getBoxWidth();
						int boxRow = (int) Math.floor(i/boxWidth);
						int boxCol = (int) Math.floor(j/boxWidth);
						int boxPosi = i%boxWidth;
						int boxPosj = j%boxWidth;
						int boxNumber = boxWidth * boxRow + boxCol;
						int boxPosition = boxWidth * boxPosi + boxPosj;
						possibleValues.get(boxNumber).get(boxPosition).remove((Integer) boxes[i][j]);
					}
				}
			}
		}
	}

	public void checkSingles() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (possibleValues.get(i).get(j).size() == 1) {
					b.setValue(i,j,possibleValues.get(i).get(j).get(0));
				}
			}
		}
	}

	public Board getSolved() {
		return b;
	}
}
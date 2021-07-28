package richarduggelberg.seppuku;

public class Board {
	private int width;
	private int[][] board;
	private int boxWidth;

	public Board(int width) {
		this.width = width;

		this.boxWidth = (int) Math.round(Math.sqrt(width));

		board = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = 0;
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getBoxWidth() {
		return boxWidth;
	}

	public int getValue(int i, int j) {
		return board[i][j];
	}

	public void setValue(int i, int j, int value) {
		board[i][j] = value;
	}

	public void setRow(int rowNumber, int[] values) {
		for (int i = 0; i < width; i++) {
			board[rowNumber-1][i] = values[i];
		}
	}

	public boolean isCorrect() {
		boolean boxes = boxesCorrect();
		boolean rows = rowsCorrect();
		boolean columns = columnsCorrect();
		return boxes && rows && columns;
	}

	public int[][] getBoxes() {
		int[][] boxes = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				int boxRow = (int) Math.floor(i/boxWidth);
				int boxCol = (int) Math.floor(j/boxWidth);
				int boxPosi = i%boxWidth;
				int boxPosj = j%boxWidth;
				int boxNumber = boxWidth * boxRow + boxCol;
				int boxPosition = boxWidth * boxPosi + boxPosj;
				boxes[boxNumber][boxPosition] = board[i][j];
			}
		}

		return boxes;
	}

	public boolean boxesCorrect() {
		int[][] boxes = getBoxes();

		for (int i = 0; i < width; i++) {
			if (containsError(boxes[i])) {
				return false;
			}
		}
		return true;
	}

	public int[][] getRows() {
		int[][] rows = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				rows[i][j] = board[i][j];
			}
		}

		return rows;
	}

	public boolean rowsCorrect() {
		int[][] rows = getRows();

		for (int i = 0; i < width; i++) {
			if (containsError(rows[i])) {
				return false;
			}
		}
		return true;
	}

	public int[][] getColumns() {
		int[][] columns = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				columns[i][j] = board[j][i];
			}
		}
		return columns;
	}

	public boolean columnsCorrect() {
		int[][] columns = getColumns();

		for (int i = 0; i < width; i++) {
			if (containsError(columns[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean containsError(int[] boxRowCol) {
		if (boxRowCol.length != width) {
			return true;
		}

		for (int i = 0; i < width; i++) {
			if (boxRowCol[i] < 1 || boxRowCol[i] > width) {
				return true;
			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = i + 1; j < width; j++) {
				if (boxRowCol[i] == boxRowCol[j]) {
					return true;
				}
			}
		}

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

	public void print() {
		for (int i = 0; i < width; i++) {
			String row = "";
			for (int j = 0; j < width; j++) {
				row += "" + board[i][j] + " ";
			}
			System.out.println(row);
		}
	}
}




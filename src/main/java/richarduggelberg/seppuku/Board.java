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

	public boolean boxesCorrect() {
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

		for (int i = 0; i < width; i++) {
			if (containsError(boxes[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean rowsCorrect() {
		int[][] rows = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				rows[i][j] = board[i][j];
			}
		}

		for (int i = 0; i < width; i++) {
			if (containsError(rows[i])) {
				return false;
			}
		}
		return true;
	}

	public boolean columnsCorrect() {
		int[][] columns = new int[width][width];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				columns[i][j] = board[j][i];
			}
		}

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




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
		return true;
	}

	public boolean rowsCorrect() {
		return true;
	}

	public boolean columnsCorrect() {
		return true;
	}
}




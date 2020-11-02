import java.util.ArrayList;

public class seppuku {
	public static void main(String args[]) {
		Board b = new Board();
		b.init();
		b.print();
	}
}

class Board {
	private int size = 9;
	private int[][] b = new int[size][size];

	void init() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				b[i][j] = 0;
			}
		}
	}

	void print() {
		System.out.println("+-----------------+");
		for (int i = 0; i < size; i++) {
			if(i % 3 == 0 && i != 0) {
				System.out.println("|-----+-----+-----|");
			}
			String row = "|";
			for (int j = 0; j < size; j++) {
				if (b[i][j] == 0) {
					row += " ";
				}
				else {
					row += b[i][j];
				}
				if ((j+1) % 3 == 0) {
					row += "|";
				}
				else if (j != size - 1) {
					row += " ";
				}
			}
			System.out.println(row);
		}
		System.out.println("+-----------------+");
	}
}
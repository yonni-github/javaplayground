package arraysAndStrings;
import java.util.ArrayList;

public class Matrix0 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 3, 0, 2 }, { 4, 3, 4 }, { 5, 6, 0 } };

		ArrayList<Cell> cells = new ArrayList<>(); // holds locations of zeros

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					cells.add(new Cell(i, j));
				}
			}
		}
		for (Cell c : cells) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[c.getX()][j] = 0;
			}
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][c.getY()] = 0;
			}
		}
		displayMatrix(matrix);
	}

	private static void displayMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}

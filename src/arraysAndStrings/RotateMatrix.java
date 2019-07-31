package arraysAndStrings;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 3, 9, 0 }, { 1, 5, 10 }, { 2, 6, 9 } };
		displayMatrix(matrix);
		System.out.println();
		displayMatrix(rotate90(matrix));

	}

	private static int[][] rotate90(int[][] m) {
		int[][] rotated = new int[3][3];

		for (int i = 0, j = m[0].length - 1; i < m[0].length; i++, j--) {
			for (int k = 0; k < m[0].length; k++) {
				rotated[k][j] = m[i][k];
			}
		}
		return rotated;
	}

	private static void displayMatrix(int[][] m) {
		for (int i = 0; i < m[0].length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
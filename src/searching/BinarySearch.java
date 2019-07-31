package searching;

public class BinarySearch {

	public static void main(String[] args) {
		int[] input = { 2, 4, 5, 7, 8, 10 };
		int x = 4;
		System.out.println(binarySearch(input, x));

	}

	private static int binarySearch(int[] input, int x) {
		int low = 0;
		int high = input.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x == input[mid])
				return mid;
			if (x > input[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

}

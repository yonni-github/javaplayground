package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 7, 1, 4 };
		int unsorted = 0;
		while (unsorted < a.length) {
			int smallestIndex = unsorted;
			for (int i = unsorted; i < a.length; i++) {

				if (a[smallestIndex] > a[i]) {
					smallestIndex = i;
				}
			}
			int temp = a[unsorted];
			a[unsorted] = a[smallestIndex];
			a[smallestIndex] = temp;
			unsorted++;
		}

		for (int i : a)
			System.out.println(i);

	}

}

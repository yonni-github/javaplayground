package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 7, 1, 4 };

		for (int unsorted = 1; unsorted < a.length; unsorted++) {
			int temp = a[unsorted];
			int i = unsorted - 1;
			while (i >= 0 && temp < a[i]) {
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = temp;
		}

		for (int i : a)
			System.out.println(i);

	}

}

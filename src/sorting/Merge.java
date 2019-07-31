package sorting;
//merges to sorted arrays
public class Merge {

	public static void main(String[] args) {
		// int[] a1 = {2,5,8,11};
		// int[] a2 = {1,2,3,4,5,6};
		int[] a = { 2, 5, 8, 11, 13, 0, 0, 0, 0, 0 };
		int[] b = { 1, 2, 3, 4, 5 };

		merge1(a, b, 5);
		for (int i : a)
			System.out.println(i);
	}

	// Sorted Merge: You are given two sorted arrays, A and B,
	// where A has a large enough buffer at the
	// end to hold B. Write a method to merge B into A in sorted order.
	private static void merge1(int[] a, int[] b, int size) {
		// int[] a = new int[a1.length + a2.length];
		int i = size - 1, j = b.length - 1, k = a.length - 1;

		while (i >= 0 && j >= 0) {
			if (a[i] >= b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}

		while (j >= 0) {
			a[k--] = b[j--];
		}
		while (i >= 0) {
			a[k--] = a[i--];
		}

		// return a;
	}

	// merge two sorted arrays and return a new sorted one
	private static int[] merge(int[] a1, int[] a2) {
		int[] a = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;

		while (i < a1.length && j < a2.length) {
			if (a1[i] <= a2[j]) {
				a[k++] = a1[i++];
			} else {
				a[k++] = a2[j++];
			}
		}

		while (j < a2.length) {
			a[k++] = a2[j++];
		}
		while (i < a1.length) {
			a[k++] = a1[i++];
		}

		return a;
	}

}

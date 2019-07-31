package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = { 2, 8, 7, 9, 0, 11, 4 };

		mergeSort(a);

		for (int i : a)
			System.out.println(i);
	}

	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int[] a, int start, int end) {
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		mergeSort(a, start, middle);
		mergeSort(a, middle + 1, end);
		merge(a, start, end);

	}

	public static void merge(int[] a, int start, int end) {
		int[] temp = new int[end - start + 1];
		int middle = (start + end) / 2;
		int leftEnd = middle;
		int rightEnd = end;
		int left = start;
		int right = middle + 1;
		int index = 0;
		while (left <= leftEnd && right <= rightEnd) {
			if (a[left] < a[right]) {
				temp[index++] = a[left++];
			} else {
				temp[index++] = a[right++];
			}
		}
		while (left <= leftEnd) {
			temp[index++] = a[left++];
		}
		while (right <= rightEnd) {
			temp[index++] = a[right++];
		}
		System.arraycopy(temp, 0, a, start, temp.length);
	}

}

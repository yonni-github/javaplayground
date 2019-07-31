package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 7, 1, 4 };
		boolean flag = true;

		while (flag) {
			flag = false;
			int j = a.length - 1;
			for (int i = 0; i < j; i++) {
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					flag = true;
				}
			}
			j--;
		}

		for (int i : a)
			System.out.println(i);

	}

}

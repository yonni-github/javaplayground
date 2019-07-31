package sorting;
import java.util.ArrayList;

public class RadixSort {

	public static void main(String[] args) {
		int[] a = { 2, 115, 30, 71, 1, 400 };
		int max = a[0];
		// create the buckets
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
		for (int k = 0; k < 10; k++) {
			bucket.add(new ArrayList<>());
		}

		// get max
		for (int i : a) {
			if (max < i)
				max = i;
		}

		// get number of digits
		int digit = 0;
		while (max > 0) {
			max = max / 10;
			digit++;
		}

		for (int i = 0; i < digit; i++) {
			for (int j : a) {
				int remainder = (j / (int) Math.pow(10, i)) % 10;
				bucket.get(remainder).add(j);
			}
			int index = 0;
			for (int k = 0; k < 10; k++) {

				if (bucket.get(k) != null && bucket.get(k).size() > 0) {
					for (int e : bucket.get(k)) {
						a[index++] = e;
					}
					bucket.get(k).clear();
				}
			}
		}
		for (int i : a)
			System.out.println(i);

	}

}

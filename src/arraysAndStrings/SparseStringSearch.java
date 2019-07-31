package arraysAndStrings;
public class SparseStringSearch {

	public static int sparseSearch(String[] words, String x) {

		int low = 0;
		int high = words.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (x.equals(words[mid])) {
				return mid;
			}
			boolean flag = true;
			while (mid < high) {
				if (!words[mid].equals("")) {
					flag = false;
					if (x.equals(words[mid])) {
						return mid;
					} else if (words[mid].compareTo(x) < 0) {
						low = mid + 1;
						break;
					} else {
						high = mid - 1;
						break;
					}
				}
				mid++;
			}
			while (mid >= low && flag) {
				if (!words[mid].equals("")) {
					if (x.equals(words[mid])) {
						return mid;
					} else if (words[mid].compareTo(x) > 0) {
						high = mid - 1;
						break;
					} else {
						low = mid + 1;
						break;
					}
				}
				mid--;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String[] input = { "at", "", "", "", "back", "", "", "car", "", "", "dad", "", "mam" };
		System.out.println(sparseSearch(input, "ma"));
	}
}
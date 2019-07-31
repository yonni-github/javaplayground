package arraysAndStrings;

public class URLify {

	public static void main(String[] args) {
		char[] input = { 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ' };
		int len = 13;
		char[] output = urlify(input, len);
		System.out.println(output);

	}

	private static char[] urlify(char[] in, int len) {
		for (int i = len - 1; i >= 0; i--) {
			if (in[i] == ' ') {
				for (int j = len - 1; j > i; j--) {
					in[j + 2] = in[j];
				}
				in[i] = '%';
				in[i + 1] = '2';
				in[i + 2] = '0';
				len += 2;
			}
		}

		return in;
	}

}

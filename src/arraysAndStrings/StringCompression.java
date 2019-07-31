package arraysAndStrings;
import java.util.ArrayList;

public class StringCompression {

	public static void main(String[] args) {
		String s = "aabbccc";
		String compressed = compress2(s);

		System.out.println(compressed);
	}

	// better code
	private static String compress2(String s) {

		int count = 0;
		char temp;
		int len = s.length();
		ArrayList<Character> comp = new ArrayList<>();

		if (len < 3)
			return s;

		temp = s.charAt(0);
		comp.add(temp);
		count = 1;

		for (int i = 1; i < len; i++) {
			char c = s.charAt(i);
			if (temp == c) {
				count++;
			} else {
				comp.add((char) (count + 48));
				comp.add(c);
				count = 1;
				temp = c;
			}
		}
		comp.add((char) (count + 48));

		if (comp.size() >= len)
			return s;

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < comp.size(); i++) {
			stringBuilder.append(comp.get(i));
		}

		return stringBuilder.toString();
	}

//needs refactor
	private static String compress(String s) {

		int count = 0;
		char temp = ' ';
		ArrayList<Character> comp = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (count == 0) {
				comp.add(c);
				count++;
				temp = c;
			} else if (count > 0) {
				if (c == temp) {
					count++;
				} else {
					comp.add((char) (count + 48));
					comp.add(c);
					count = 1;
					temp = c;
				}
			}
		}
		comp.add((char) (count + 48));

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < comp.size(); i++) {
			stringBuilder.append(comp.get(i));
		}

		return stringBuilder.toString();
	}

}

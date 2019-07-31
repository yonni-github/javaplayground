package arraysAndStrings;
import java.util.Hashtable;

//checks if a string has a palindrome permutation
public class PalindromePermutation {

	public static void main(String[] args) {
		String s = "carerac";
		System.out.println(palPer(s));

	}

	private static boolean palPer(String s) {
		Hashtable<Character, Integer> map = new Hashtable<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else
				map.put(c, 1);
		}

		int oddCount = 0;
		for (char key : map.keySet()) {
			oddCount += map.get(key) % 2;
			if (oddCount > 1)
				return false;
		}

		if (s.length() % 2 == 0 && oddCount == 0)
			return true;
		if (s.length() % 2 == 1 && oddCount == 1)
			return true;

		return false;
	}

}

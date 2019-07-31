package arraysAndStrings;
import java.util.Hashtable;

public class StringUniqueness {

	public static void main(String[] args) {
		String s = "abcda";
		System.out.println(isUnique(s));

	}

	public static boolean isUnique(String s) {
		Hashtable<Character, Integer> map = new Hashtable<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c))
				return false;
			else
				map.put(c, 1);
		}

		return true;
	}

}

package arraysAndStrings;
public class StringRotation {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(checkRotaion(s1, s2));

		s1 = "abcda";
		s2 = "bacda";
		System.out.println(checkRotaion(s1, s2));
	}

	private static boolean checkRotaion(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int shiftFactor = 0;
		char c = s1.charAt(0);
		for (int i = 0; i < s2.length(); i++) {
			if (c == s2.charAt(i)) {
				shiftFactor = i;
				break;
			}
		}
		String sub1 = s2.substring(0, shiftFactor);
		String sub2 = s2.substring(shiftFactor, s2.length());
		String s = sub2 + sub1;

		return s.equals(s1);
	}

}
package arraysAndStrings;

public class StringPermutation {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "aac";

		System.out.println(arePermutation(s1, s2));
		System.out.println(arePermutation2(s1, s2));
	}

	private static boolean arePermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (s2.indexOf(c) < 0)
				return false;
		}

//		for(int i=0; i<s2.length();i++) {
//			char c = s2.charAt(i);
//			if(s1.indexOf(c)<0)
//				return false;
//		}

		return true;
	}

	private static boolean arePermutation2(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;

		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < s1.length(); i++) {
			sum1 += (int) s1.charAt(i);
			sum2 += (int) s2.charAt(i);
		}

		return (sum1 == sum2);
	}

}

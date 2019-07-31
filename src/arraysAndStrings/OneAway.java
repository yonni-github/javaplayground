package arraysAndStrings;
//check if two strings are one edit (or zero edits) away.
public class OneAway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static boolean oneAway(String s1, String s2) {
		int lenDiff = Math.abs(s1.length() - s2.length());

		if (lenDiff > 1)
			return false;

		return true;
	}

}

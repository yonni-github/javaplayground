package lists;

public class PalindromeList {

	public static void main(String[] args) {
		Node list = null;
		list = new Node(9);
		list.appendToTail(8);
		list.appendToTail(7);
		list.appendToTail(7);
		list.appendToTail(9);
		list.print();

		System.out.println(isPalindrome(list));

	}

	private static boolean isPalindrome(Node list1) {
		Node list2 = list1.copy();
		list2 = list2.reverse();
		list2.print();
		do {
			if (list1.data != list2.data)
				return false;

			list1 = list1.next;
			list2 = list2.next;
		} while (list1.next != null && list2.next != null);

		return true;
	}

}

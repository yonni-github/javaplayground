package lists;

public class AddLists {

	public static void main(String[] args) {
		Node l1 = null;
		l1 = new Node(9);
		l1.appendToTail(7);
		l1.appendToTail(8);

		Node l2 = null;
		l2 = new Node(6);
		l2.appendToTail(8);
		l2.appendToTail(5);

		System.out.println("Print L1");
		l1.print();
		System.out.println("Print L2");
		l2.print();

		System.out.println("879 + 586");
		Node result = sum(l1, l2, 0); // 879 + 586
		result.print();

		System.out.println("978 + 685");
		Node result2 = sum2(l1, l2, 0);// 978 + 685
		result2.print();

		l1.appendToTail(7);
		l1.appendToTail(8);
		l2.appendToTail(8);
		l2.appendToTail(5);
		System.out.println("978 + 685");

		Node result3 = sum3(l1, l2, 0);// 978 + 685
		result3.print();

	}

	// when lists are in regular/forward order (without reversing)
	private static Node sum3(Node l1, Node l2, int c) {
		int carry = c;
		int sum = 0;
		int digit = 0;
		Node result = null, last1 = null, last2 = null, temp = null;

		last1 = l1 != null ? l1.getLast() : null;
		last2 = l2 != null ? l2.getLast() : null;
		l1 = l1 != null ? l1.trimLast() : null;
		l2 = l2 != null ? l2.trimLast() : null;

		sum = carry;
		sum += last1 != null ? last1.data : 0;
		sum += last2 != null ? last2.data : 0;
		digit = sum % 10;
		result = new Node(digit);
		carry = sum / 10;

		if (l1 != null || l2 != null) {
			temp = sum3(l1, l2, carry);
			Node n = temp;
			while (n.next != null)
				n = n.next;

			n.next = result;
			result = temp;
		} else if (carry != 0)
			result = result.appendToHead(carry);

		return result;

	}

	// when lists are in regular/forward order (by reversing)
	private static Node sum2(Node l1, Node l2, int c) {
		Node result = sum(l1.reverse(), l2.reverse(), c);
		return result.reverse();

	}

	// when lists are in reverse/backward order
	private static Node sum(Node l1, Node l2, int c) {

		int carry = c;
		int sum = 0;
		int digit = 0;
		Node result = null;

		sum = carry;
		sum += l1 != null ? l1.data : 0;
		sum += l2 != null ? l2.data : 0;
		digit = sum % 10;
		result = new Node(digit);
		carry = sum / 10;

		if (l1.next != null && l2.next != null) {
			result.next = sum(l1.next, l2.next, carry);
			carry = 0;
		} else if (l1.next != null) {
			result.next = sum(l1.next, new Node(0), carry);
			carry = 0;
		} else if (l2.next != null) {
			result.next = sum(new Node(0), l2.next, carry);
			carry = 0;
		} else if (carry != 0)
			result.next = new Node(carry);

		return result;

	}

}

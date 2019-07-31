package lists;
class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	Node copy() {
		Node n = this;
		Node copy = new Node(n.data);
		while (n.next != null) {
			copy.appendToTail(n.next.data);
			n = n.next;
		}

		return copy;
	}

	Node appendToHead(int d) {
		Node head = new Node(d);
		Node n = this;

		head.next = n;

		return head;

	}

	Node reverse() {
		return reverse(this);
	}

	private Node reverse(Node h) {
		Node reversed = null;
		Node n = h;
		Node secToLast = h;

		while (n.next != null) {
			reversed = n.next;
			secToLast = n;
			n = n.next;
		}
		secToLast.next = null;

		if (h.next != null)
			reversed.next = reverse(h);
		else if (reversed != null)
			reversed.next = h;
		else
			reversed = h;

		return reversed;
	}

	public Node getLast() {
		Node last = this;
		while (last.next != null) {
			last = last.next;
		}
		return last;
	}

	public Node trimLast() {
		Node n = this;
		Node secToLast = this;

		if (n.next == null) {
			return null;
		}
		while (n.next != null) {
			secToLast = n;
			n = n.next;
		}
		secToLast.next = null;

		return this;
	}

	Node deleteNode(Node head, int d) {
		Node n = head;

		if (n.data == d) {
			return head.next; /* moved head */
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; /* head didn't change */
			}
			n = n.next;
		}
		return head;
	}

	void print() {
		Node n = this;
		while (n != null) {
			System.out.print(n.data);
			if (n.next != null)
				System.out.print("->");
			n = n.next;
		}
		System.out.println();
	}
}
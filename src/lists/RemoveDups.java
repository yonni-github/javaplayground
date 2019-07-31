package lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDups {

	public static void main(String[] args) {
		Node head = null;
		head = new Node(5);// creating the first node
		head.appendToTail(3);
		head.appendToTail(3);
		head.appendToTail(3);

		head.appendToTail(4);
		head.appendToTail(7);
		head.appendToTail(5);
		head.appendToTail(6);
		// head = head.deleteNode(head, 5);
		head.print();

		List<Integer> st = new ArrayList<>();
		Node n = head;
		while (n != null) {
			if (st.contains(n.data)) {
				int data = n.data;
				n = n.next;
				head = head.deleteNode(head, data);
			} else {
				st.add(n.data);
				n = n.next;
			}
		}

		head.print();

	}
}
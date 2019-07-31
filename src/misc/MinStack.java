package misc;

public class MinStack {
	StackNode top = null;

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(7);
		stack.print();
		System.out.println(stack.min());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		stack.print();
		System.out.println(stack.pop());
		System.out.println(stack.min());

	}

	private static class StackNode {
		StackNode next = null;
		StackNode min = null;
		int data;

		StackNode(int data) {
			super();
			this.data = data;
		}
	}

	Integer pop() {
		if (isEmpty())
			return null;
		Integer value = new Integer(top.data);
		top = top.next;

		return value;
	}

	boolean push(int d) {
		StackNode n = new StackNode(d);
		if (top == null) {
			top = n;
			top.min = top;
		} else {
			n.next = top;
			top = n;

			if (top.data > top.next.min.data)
				top.min = top.next.min;
			else
				top.min = top;
		}

		return true;
	}

	boolean isEmpty() {
		return top == null;
	}

	Integer peek() {
		if (isEmpty())
			return null;

		return top.data;
	}

	Integer min() {
		if (isEmpty())
			return null;

		return top.min.data;
	}

	void print() {
		StackNode n = top;
		while (n != null) {
			System.out.print(n.data);
			if (n.next != null)
				System.out.print("->");
			n = n.next;
		}
		System.out.println();
	}

}

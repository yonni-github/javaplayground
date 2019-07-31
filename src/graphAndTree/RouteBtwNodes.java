package graphAndTree;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RouteBtwNodes {

	private static class GraphNode {

		int data;
		ArrayList<GraphNode> childNodes = new ArrayList<>();

		public GraphNode(int data) {

			super();
			this.data = data;

		}

	}

	private static boolean routebtwNodes(GraphNode n1, GraphNode n2) {

		// GraphNode root = n1;

		Set<GraphNode> visited = new HashSet<>();

		Queue<GraphNode> queue = new LinkedList<>();

		queue.add(n1);

		while (!queue.isEmpty()) {

			GraphNode node = queue.poll();

			visited.add(node);

			if (visited.contains(n2)) {

				return true;

			}

			for (GraphNode gn : node.childNodes) {

				queue.add(gn);

			}

		}

		return false;

	}

	public static void main(String[] args) {

		ArrayList<GraphNode> graph = new ArrayList<>();
		GraphNode one = new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		GraphNode five = new GraphNode(5);

		one.childNodes.add(two);
		two.childNodes.add(four);
		three.childNodes.add(two);
		three.childNodes.add(four);
		four.childNodes.add(five);

		graph.add(one);
		graph.add(two);
		graph.add(three);
		graph.add(four);
		graph.add(five);

		System.out.println(routebtwNodes(one, five));

		System.out.println(routebtwNodes(one, three));

		System.out.println(routebtwNodes(one, four));

		System.out.println(routebtwNodes(two, four));

		System.out.println(routebtwNodes(two, three));

		System.out.println(routebtwNodes(three, five));

		System.out.println(routebtwNodes(five, three));

	}

}
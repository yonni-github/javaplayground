package graphAndTree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*

 * Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of

projects, where the second project is dependent on the first project). All of a project's dependencies

must be built before the project is. Find a build order that will allow the projects to be built. If there

is no valid build order, return an error.

EXAMPLE

Input:

projects: a, b, c, d, e, f

dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)

Output: f, e, a, b, d, c

 */

public class BuildOrder {

	static ArrayList<GraphNode> graph = new ArrayList<>();

	private static class GraphNode {

		int data;
		ArrayList<GraphNode> dependencies = new ArrayList<>();

		public GraphNode(int data) {

			super();

			this.data = data;

		}

	}

	private static void build() {

		List<GraphNode> completed = new ArrayList<>();
		do {
			Iterator<GraphNode> it = graph.iterator();
			while (it.hasNext()) {
				GraphNode gn = it.next();
				if (gn.dependencies.isEmpty()) { // if no dependecy
					completed.add(gn);
					it.remove();

				} else {
					for (GraphNode dependency : gn.dependencies) {

						if (graph.contains(dependency)) {
							break;
						} else {
							completed.add(gn);
							it.remove();
							break;
						}
					}
				}
			}
		} while (!graph.isEmpty());

		for (GraphNode gn : completed) {
			System.out.print(gn.data + " ");
		}

	}

	public static void main(String[] args) {

		// ArrayList<GraphNode> graph = new ArrayList<>();

		GraphNode one = new GraphNode(1);

		GraphNode two = new GraphNode(2);

		GraphNode three = new GraphNode(3);

		GraphNode four = new GraphNode(4);

		GraphNode five = new GraphNode(5);

		GraphNode six = new GraphNode(6);

		one.dependencies.add(six);

		two.dependencies.add(six);

		three.dependencies.add(four);

		four.dependencies.add(one);

		four.dependencies.add(two);

		graph.add(one);

		graph.add(two);

		graph.add(three);

		graph.add(four);

		graph.add(five);

		graph.add(six);

		build();

	}
}
package graphAndTree;
import graphAndTree.MinimalTree.TreeNode;

public class TreePerimeter {

	public static void treePerimeter(MinimalTree.TreeNode node) {
		printLeft(node);
		printLeaf(node);
		printRight(node);
	}

	private static void printLeaf(MinimalTree.TreeNode node) {
		if (isLeaf(node))
			System.out.print(node.data + " ");
		if (node.children[0] != null)
			printLeaf(node.children[0]);
		if (node.children[1] != null)
			printLeaf(node.children[1]);

	}

	private static void printRight(MinimalTree.TreeNode node) {
		if (node.children[1] != null && !isLeaf(node.children[1]))
			printRight(node.children[1]);

		System.out.print(node.data + " ");

	}

	private static void printLeft(MinimalTree.TreeNode node) {
		System.out.print(node.data + " ");
		if (node.children[0] != null && !isLeaf(node.children[0]))
			printLeft(node.children[0]);

	}

	public static boolean isLeaf(MinimalTree.TreeNode node) {
		if (node.children[0] == null && node.children[1] == null)
			return true;

		return false;
	}

	public static void main(String[] args) {
		// int[] input = { 5,1,6,3,7,0,2,4,9,8};
		// int[] input = { 6,1,12,11,10,8};
		int[] input = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		MinimalTree mt = new MinimalTree();

		for (int i : input) {
			mt.insertValue(i);
		}
		System.out.println("---------------------------");
		mt.printTree();
		treePerimeter(mt.root);

	}

}

package graphAndTree;

import java.util.LinkedList;

public class ListOfDepths {

	// LinkedList<MinimalTree.TreeNode> list = new LinkedList<>();

	public static void TreeToList(LinkedList<MinimalTree.TreeNode> level) {

		LinkedList<MinimalTree.TreeNode> list = level;

		for (MinimalTree.TreeNode tn : list) {

			System.out.print(tn.toString());

		}

		System.out.println();

		level = new LinkedList<>();

		for (MinimalTree.TreeNode tn : list) {

			if (tn.children[0] != null) {

				level.add(tn.children[0]);

			}

			if (tn.children[1] != null) {

				level.add(tn.children[1]);

			}

		}

		if (!level.isEmpty()) {
			TreeToList(level);
		}

	}

	public static void main(String[] args) {

		int[] input = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		MinimalTree mt = new MinimalTree();

		for (int i : input) {

			mt.insertValue(i);

		}

		mt.printTree();

		System.out.println("------------------------------");

		LinkedList<MinimalTree.TreeNode> list = new LinkedList<>();

		list.add(mt.root);
		TreeToList(list);

	}

}
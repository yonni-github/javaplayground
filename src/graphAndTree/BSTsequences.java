package graphAndTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class BSTsequences {
	static MinimalTree mt = new MinimalTree();

	public static LinkedList<LinkedList<MinimalTree.TreeNode>> combination(LinkedList<MinimalTree.TreeNode> list) {

		LinkedList<LinkedList<MinimalTree.TreeNode>> combinations = new LinkedList<>();
		ListIterator<MinimalTree.TreeNode> it = list.listIterator();
		while (it.hasNext()) {
			MinimalTree.TreeNode node = it.next();
			it.remove();
			combinations = combination(list);
			if (combinations.isEmpty()) {
				LinkedList<MinimalTree.TreeNode> comb = new LinkedList<>();
				comb.add(node);
				combinations.add(comb);
			} else {
				for (LinkedList<MinimalTree.TreeNode> comb : combinations) {
					comb.add(0, node);
				}
			}
		}

		return combinations;

	}

	public static void append(ArrayList<MinimalTree.TreeNode> list, MinimalTree.TreeNode leftChild,
			MinimalTree.TreeNode rightChild) {

	}

	public static ArrayList<ArrayList<MinimalTree.TreeNode>> possibleSequences(MinimalTree.TreeNode node) {
		ArrayList<ArrayList<MinimalTree.TreeNode>> left = new ArrayList<>();
		ArrayList<ArrayList<MinimalTree.TreeNode>> right = new ArrayList<>();
		ArrayList<ArrayList<MinimalTree.TreeNode>> both = new ArrayList<>();

		ArrayList<MinimalTree.TreeNode> leftSub = new ArrayList<>();
		ArrayList<MinimalTree.TreeNode> rightSub = new ArrayList<>();

		if (node.children[0] != null) {
			left = possibleSequences(node.children[0]);

			leftSub.add(node.children[0]);
			if (node.children[1] != null) {
				leftSub.add(node.children[1]);
				rightSub.add(node.children[1]);
				rightSub.add(node.children[0]);
			}

			for (ArrayList<MinimalTree.TreeNode> list : left) {
				list.add(0, node.children[0]);
				if (node.children[1] != null)
					list.add(1, node.children[1]);
			}
		}
		if (node.children[1] != null) {
			right = possibleSequences(node.children[1]);
			for (ArrayList<MinimalTree.TreeNode> list : right) {
				list.add(0, node.children[1]);
				if (node.children[1] != null)
					list.add(1, node.children[1]);
			}
		}

		return both;
	}

	public static void main(String[] args) {
		// int[] input = { 5,1,6,3,7,0,2,4,9,8};
		// int[] input = { 6,1,12,11,10,8};
		int[] input = { 5, 3, 6, 2, 4, 9 };

		for (int i : input) {
			mt.insertValue(i);
		}
		mt.printTree();
		System.out.println("Tree height: " + mt.treeHeight());
		System.out.println(mt.root.isBalanced());

		LinkedList<MinimalTree.TreeNode> list = new LinkedList<>();

		list.add(mt.root);
		list.add(mt.root.children[0]);
		list.add(mt.root.children[1]);
		LinkedList<LinkedList<MinimalTree.TreeNode>> combinations = combination(list);

		for (LinkedList<MinimalTree.TreeNode> l : combinations) {
			for (MinimalTree.TreeNode n : l) {
				System.out.print(n + " ");
			}
		}
	}

}

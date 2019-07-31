package graphAndTree;

public class BinaryTree {
	TreeNode root;
	
	public TreeNode fca(TreeNode n1, TreeNode n2) {
		if (root == n1 || root == n2 || !root.find(n1) || !root.find(n2))
			return null;
	
		TreeNode n = root.fca(n1, n2);
		if(n != null)
			return n;
		else 
			return root;
	}
	void insert(TreeNode node) {
		
		if(root == null)
			root = node;
		else
			root.insertNode(node);
	}
	
	void printTree() {
		if (root != null)
			root.print(1);
	}
}

package graphAndTree;

public class TreeNode {

	int data;
	TreeNode[] children;
	TreeNode parent;
	
	public TreeNode(int data) {
		super();
		this.data = data;
		children = new TreeNode[2];
	}
	
	public TreeNode fca(TreeNode n1, TreeNode n2) {		
		
		TreeNode a = null;
		if(this == n1 || this == n2 )
			return null;
		
		if(this.find(n1) && this.find(n2)) {
			a = this;
			TreeNode left = this.children[0] == null ? null : this.children[0].fca(n1, n2);
			TreeNode right =  this.children[1] == null ? null : this.children[1].fca(n1, n2);
			
			if(left == null && right == null)
				a = this;
			else if(left != null || right != null)
				a = left != null ? left : right;
		}
			
		return  a;
	}

	boolean find(TreeNode n) {//DFS search for n in the subtree
		boolean found = false;
		
		if(n == this) {
			return true;
		}
		found = (this.children[0] != null ? this.children[0].find(n) : false) || 
				(this.children[1] != null ?this.children[1].find(n) : false);
		
		return found;
	}

	void print(int level) {
		space(level);
		System.out.println(this.data);
		level++;
		if(this.children[0] != null) {
			this.children[0].print(level);
		}
		if(this.children[1] != null) {
			this.children[1].print(level);
		}
	}
	void space(int level) {
		for(int i= 1; i< level; i++) {
			System.out.print("  ");
		}
	}
	
	public void insertNode(TreeNode node) {
		if(this.data > node.data) {
			if(this.children[0] == null)
				this.children[0] = node;
			else
				this.children[0].insertNode(node);
		}else {
			if(this.children[1] == null)
				this.children[1] = node;
			else
				this.children[1].insertNode(node);
		}
			
		
	}
	
}


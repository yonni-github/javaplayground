package graphAndTree;

public class FirstCommonAncestor {
	static BinaryTree bt = new BinaryTree();

	public static void main(String[] args) {
		int[] input = {1,5,8,6,2,0,3,7,9,4};		
		TreeNode[] nodes= new TreeNode[10];
		
		for(int i: input) {
			TreeNode n = new TreeNode(i);
			bt.insert(n);
			nodes[i] = n;
		}
//		TreeNode n1 = new TreeNode(7);
//		TreeNode n2 = new TreeNode(2);
//		bt.insert(n1);
//		bt.insert(n2);
		bt.printTree();
		
		TreeNode fca = bt.fca(nodes[8],nodes[7]);
		if(fca != null)
			System.out.println("FCA is: " + fca.data);
		else
			System.out.println("No common ancentor.");
								
	}

}

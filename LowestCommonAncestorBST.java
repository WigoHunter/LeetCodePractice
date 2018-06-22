import java.util.*;

public class LowestCommonAncestorBST {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
	}
    
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val)
                cur = cur.left;
            else if (cur.val < p.val && cur.val < q.val)
                cur = cur.right;
            else break;
        }

        return cur;
    } 
}
import java.util.*;

public class ConvertBSTToGreaterThanTree {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(13);
        root.left = new TreeNode(2);

        System.out.println(convertBST(root).val);
	}
    
    private static TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        int count = 0;
        Stack<TreeNode> s = new Stack<>();

        while (cur != null) {
            s.push(cur);
            cur = cur.right;
        }

        while (!s.isEmpty()) {
            cur = s.pop();
            count += cur.val;
            cur.val = count;
            
            cur = cur.left;
            while (cur != null) {
                s.push(cur);
                cur = cur.right;
            }
        }

        return root;
    }
}
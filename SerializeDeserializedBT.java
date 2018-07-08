import java.util.*;

public class SerializeDeserializedBT {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static class Codec {
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			preOrderAppend(sb, root);

			return sb.toString();
		}

		private static void preOrderAppend(StringBuilder sb, TreeNode root) {
			if (root == null) {
				sb.append("null,");
				return;
			}

			sb.append("" + root.val + ",");
			preOrderAppend(sb, root.left);
			preOrderAppend(sb, root.right);

		}
	
		public TreeNode deserialize(String data) {
			Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
			if (q.isEmpty()) return null;

			return preOrderRead(q);
		}

		private static TreeNode preOrderRead(Queue<String> q) {
			TreeNode root = null;
			String cur = q.poll();
			
			if (!cur.equals("null")) {
				root = new TreeNode(Integer.parseInt(cur));
				root.left = preOrderRead(q);
				root.right = preOrderRead(q);
			}

			return root;
		}
	}

    public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		System.out.println(codec.serialize(root));
		TreeNode res = codec.deserialize("1,2,null,null,3,4,null,null,5,null,null");
		System.out.println(codec.serialize(res));
	}
}
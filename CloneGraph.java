import java.util.*;

public class CloneGraph {
	private static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; }
	}

	private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)	return null;

		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		Map<Integer, UndirectedGraphNode> map = new HashMap<>();

		map.put(node.label, res);
		q.offer(node);

		while (!q.isEmpty()) {
			UndirectedGraphNode cur = q.poll();

			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor.label)) {
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					q.offer(neighbor);
				}

				map.get(cur.label).neighbors.add(map.get(neighbor.label));
			}
		}

		return res;
	}
}
import java.util.*;

public class ImplementTrie {
    private static class Trie {
        class TrieNode {
            Map<Character, TrieNode> map;
            boolean isEnd = false;
            public TrieNode() {
                map = new HashMap<>();
            }
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null || word.length() < 1) return;

            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.map.containsKey(c)) {
                    cur = cur.map.get(c);
                } else {
                    cur.map.put(c, new TrieNode());
                    cur = cur.map.get(c);
                }
            }

            cur.isEnd = true;
        }

        public boolean search(String word) {
            if (word == null || word.length() < 1)  return false;

            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.map.containsKey(c))    return false;
                cur = cur.map.get(c);
            }

            return cur.isEnd;
        }

        public boolean startsWith(String word) {
            if (word == null || word.length() < 1)  return false;

            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.map.containsKey(c))    return false;
                cur = cur.map.get(c);
            }

            return true;
        }
    }

    public static void main(String[] args) {

    }

}
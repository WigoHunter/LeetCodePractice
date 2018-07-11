import java.util.*;

public class WordLadder {
   	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","log","lot"));
		// System.out.println(twoEndSolution("hit", "cog", list));
		System.out.println(ladderLength("hit", "cog", list));
	}
	
	private static int twoEndSolution(String beginWord, String endWord, List<String> wordList) {
		Set<String> wSet = new HashSet<>(wordList);
		if (!wSet.contains(endWord))	return 0;
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);

		int level = 1;
		while (!beginSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> temp = beginSet;
				beginSet = endSet;
				endSet = temp;
			}

			Set<String> set = new HashSet<>();
			for (String word : beginSet) {
				char[] chars = word.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char original = chars[i];

					for (char c = 'a'; c <= 'z'; c++) {
						if (original == c)	continue;
						chars[i] = c;
						String newStr = new String(chars);
						if (endSet.contains(newStr)) {
							return level + 1;
						}

						if (wSet.contains(newStr)) {
							set.add(newStr);
							wSet.remove(newStr);
						}
					}

					chars[i] = original;
				}
			}

			beginSet = set;
			level++;
		}

		return 0;
	}
 
    private static int ladderLength(String start, String end, List<String> dict) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int level = 0;
        int loopSize;
        
        while (!q.isEmpty()) {
            level++;
            loopSize = q.size();
            String curWord;
            
            for (int i = 0; i < loopSize; i++) {
                curWord = q.poll();
                
                if (curWord.equals(end)) {
                    return level;
                } else {
                    char[] chars = curWord.toCharArray();
                    
                    for (int j = 0; j < chars.length; j++) {
                        char origin = chars[j];
                        
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (origin == c)    continue;
                            chars[j] = c;
                            String str = new String(chars);
                            if (str.equals(end)) {
                                return level + 1;
                            } else if (dict.contains(str)) {
                                q.add(str);
                                dict.remove(str);
                            }
                        }
                        
                        chars[j] = origin;
                    }
                }
            }
        }
        
        return 0;
	}

	private static boolean valid(String s1, String s2) {
		int buffer = 1;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				buffer--;
			}
			if (buffer < 0) {
				return false;
			}
		}

		return true;
	}
}
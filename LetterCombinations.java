import java.util.*;

public class LetterCombinations {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
		list = _letterCombinations("234");

		System.out.println(Arrays.toString(list.toArray()));
	}
	
	final static Map<Character, Character[]> dictionary = new HashMap<>();
 
    private static List<String> _letterCombinations(String digits) {
		dictionary.put('2', new Character[]{'a', 'b', 'c'});
		dictionary.put('3', new Character[]{'d', 'e', 'f'});
		dictionary.put('4', new Character[]{'g', 'h', 'i'});
		dictionary.put('5', new Character[]{'j', 'k', 'l'});
		dictionary.put('6', new Character[]{'m', 'n', 'o'});
		dictionary.put('7', new Character[]{'p', 'q', 'r', 's'});
		dictionary.put('8', new Character[]{'t', 'u', 'v'});
		dictionary.put('9', new Character[]{'w', 'x', 'y', 'z'});
 
		return solution(digits);
	}

	private static List<String> solution(String digits) {
		List<String> res = new ArrayList<String>();

		if (digits.length() == 0)
			return res;
		else {
			res.add("");

			for(int i = 0; i < digits.length(); i++) {
				res = recursiveAdd(dictionary.get(digits.charAt(i)), res);
			}
		}

		return res;
	}

	private static List<String> recursiveAdd(Character[] possibles, List<String> l) {
		List<String> res = new ArrayList<String>();

		for (int i = 0; i < possibles.length; i++) {
			for (String s : l) {
				res.add(s + possibles[i]);
			}
		}
		
		return res;
	}
}
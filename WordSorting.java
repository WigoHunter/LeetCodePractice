import java.util.*;

public class WordSorting {
	
    public static void main(String[] args) {
		System.out.println(Arrays.toString(wordSort(
			new char[]{'z','b','a','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','c'},
			new String[]{"bca","czb","za","zba","ade"})));
	}
    
    private static String[] wordSort(char[] alphabet, String[] words) {
		char[] in = new char[26];

		for (int i = 0; i < 26; i++) {
			in[(int) (alphabet[i] - 'a')] = (char) ('a' + i);
		}

		for (int i = 0; i < words.length; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < words[i].length(); j++) {
				sb.append(in[(int) (words[i].charAt(j) - 'a')]);
			}

			words[i] = sb.toString();
		}

		Arrays.sort(words);

		for (int i = 0; i < words.length; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < words[i].length(); j++) {
				sb.append(alphabet[(int) (words[i].charAt(j) - 'a')]);
			}

			words[i] = sb.toString();
		}

		return words;
    } 
}
import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(_longestCommonPrefix(new String[]{"dog", "doracecar", "docar"}));
    }
 
    
    private static String _longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
            
        StringBuilder sb = new StringBuilder();
        char temp;

        for (int i = 0; i < strs[0].length(); i++) {
            temp = strs[0].charAt(i);

            for(int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || temp != strs[j].charAt(i))
                    return sb.toString();
            }

            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }
}
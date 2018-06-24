import java.util.*;

public class SimilarRGBColor {
    public static void main(String[] args) {
        System.out.println(similarRGB("#09f166")); 
    }
    
    private static String similarRGB(String color) {
        char[] hexs = "0123456789abcdef".toCharArray();
        List<Character> chars = new ArrayList<>();
        for (char c : hexs) {
            chars.add(c);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("#");

        for (int i = 0; i < 3; i++) {
            int target = chars.indexOf(color.charAt(1 + 2 * i)) * 16 + chars.indexOf(color.charAt(2 + 2 * i));
            int minDiff = Integer.MAX_VALUE;
            char best = 'f';

            for (int j = 0; j < 16; j++) {
                int temp = Math.abs(j * 16 + j - target);
                if (minDiff > temp) {
                    minDiff = temp;
                    best = chars.get(j);
                }
            }

            sb.append("" + best);
            sb.append("" + best);
        }

        return sb.toString();
    }
}
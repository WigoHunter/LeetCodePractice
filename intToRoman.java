import java.util.Arrays;

public class intToRoman {

    public static void main(String[] args) {
        System.out.println(_intToRoman(1001));
    }
 
    
    private static String _intToRoman(int x) {
        int[] vals = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < vals.length; i++) {
            while(x >= vals[i]) {
                x -= vals[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();
    }
}
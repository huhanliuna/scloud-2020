public class RomanToInt {
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static int romanToInt(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int length = s.length();
        int x = 0, y = 1;
        int val = 0;
        while (x < y && y <= length) {
            for (int j = 0; j < symbols.length; j++) {
                if (y+1<=length &&symbols[j].equals(s.substring(x, y+1))) {
                    y=y+1;
                    val += values[j];
                    x=x+2;
                    y=y+1;
                    break;
                } else if(symbols[j].equals(s.substring(x, y))){
                    val += values[j];
                    x++;
                    y++;
                    break;
                }
            }

        }
        return val;
    }
    public static void main (String[]args){
        int s = romanToInt("MMMCMXCIV");
        System.out.println(s);
    }
}
